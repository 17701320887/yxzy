package com.active.web;

import com.active.common.bean.ResultMsg;
import com.active.common.util.DateUtils;
import com.active.common.util.ExcelData;
import com.active.common.util.ExportExcelUtils;
import com.active.common.util.InternetUtil;
import com.active.model.*;
import com.active.service.IGameConfigService;
import com.active.service.IGameHomeService;
import com.active.service.IGameUserHomeService;
import com.active.service.IGameUserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by zb on 2018/3/13.
 */
@Controller
public class IndexController {
    @Autowired
    private IGameUserService gameUserService;
    @Autowired
    private IGameHomeService gameHomeService;
    @Autowired
    private IGameUserHomeService gameUserHomeService;
    @Autowired
    private IGameConfigService gameConfigService;

    @RequestMapping(value = "/live/index")
    public ModelAndView login(ModelAndView model){
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView model,HttpServletRequest request){
        boolean isWap = isWap(request);
        model.addObject("isPc",isWap?false:true);
        if(isWap){
            model.setViewName("index");
        }else{
            model.setViewName("index");
        }
        return model;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about(ModelAndView model,HttpServletRequest request){
        boolean isWap = isWap(request);
        model.addObject("isPc",isWap?false:true);
        if(isWap){
            model.setViewName("about");
        }else{
            model.setViewName("about");
        }
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    public JSONObject checkUser(ModelAndView model, String token,HttpServletRequest request){
        JSONObject result = new JSONObject();
        try{
            if(token!=null){
                List<GameUser> gameUsers = gameUserService.findByToken(token);
                if(gameUsers==null || gameUsers.size()==0){
                    GameUser gameUser = new GameUser();
                    gameUser.setToken(token);
                    gameUser.setCreateTime(new Date());
                    gameUser.setUserIp(InternetUtil.getFirstIpAddrForProxy(request));
                    gameUserService.saveUser(gameUser);
                    result.put("userId",gameUser.getId());
                    result.put("state",200);
                }else{
                    List<GameUserHome> gameUserHomes = gameUserHomeService.findByUserId(gameUsers.get(0).getId());
                    if(gameUserHomes == null || gameUserHomes.size() == 0){
                        result.put("userId",gameUsers.get(0).getId());
                        result.put("state",200);
                    }else{
                        result.put("msg","重复注册！");
                        result.put("state",2);
                    }
                }
            }else{
                result.put("state",1);
                result.put("msg","参数缺失");
            }
        }catch (Exception ex){
            result.put("msg","异常");
            result.put("state",500);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/checkHome",method = RequestMethod.POST)
    public JSONObject checkHome(ModelAndView model, String gamePwd, String name, Long userId){
        JSONObject result = new JSONObject();
        try{
            if(gamePwd!=null && name!=null){
                GameHome gameHome = gameHomeService.findByPwd(gamePwd);
                if(gameHome==null){
                    //验证名字是否重复
                    GameHome checkName = gameHomeService.findByName(name);
                    if(checkName == null){
                        GameHome createHome = new GameHome();
                        createHome.setUserId(userId);
                        createHome.setGamePwd(gamePwd);
                        createHome.setName(name);
                        createHome.setCreateTime(new Date());
                        gameHomeService.save(createHome);
                        GameUserHome createHomeUser = new GameUserHome();
                        createHomeUser.setUserId(userId);
                        createHomeUser.setHomeId(createHome.getId());
                        createHomeUser.setJoinTime(new Date());
                        gameUserHomeService.save(createHomeUser);
                        result.put("msg","恭喜你，成功创建了一支战队！");
                        result.put("state",200);
                    }else{
                        result.put("msg","对不起，战队名字已被使用！");
                        result.put("state",3);
                    }
                }else{
                    result.put("msg","对不起，战队口令已被使用！");
                    result.put("state",1);
                }
            }else{
                result.put("msg","参数缺失");
                result.put("state",2);
            }
        }catch (Exception ex){
            result.put("msg","异常");
            result.put("state",500);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/showHomeName",method = RequestMethod.POST)
    public JSONObject showHomeName(ModelAndView model, String gamePwd){
        JSONObject result = new JSONObject();
        try{
            if(gamePwd!=null){
                GameHome gameHome = gameHomeService.findByPwd(gamePwd);
                if(gameHome!=null){
                    result.put("homeName",gameHome.getName());
                    result.put("state",200);
                }else{
                    result.put("msg","对不起，无此战队！");
                    result.put("state",1);
                }
            }
        }catch (Exception ex){
            result.put("msg","异常");
            result.put("state",500);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/joinHomeNew",method = RequestMethod.POST)
    public JSONObject joinHomeNew(ModelAndView model, String gamePwd,Long userId){
        JSONObject result = new JSONObject();
        try{
            if(gamePwd!=null){
                GameHome gameHome = gameHomeService.findByPwd(gamePwd);
                if(gameHome!=null){
                    List<GameUserHome> gameUserHomes = gameUserHomeService.findByHomeId(gameHome.getId());
                    Long configNum = gameConfigService.findNum();
                    //查询用户有没有加入过战队
                    List<GameUserHome> gameUserHomeList = gameUserHomeService.findByUserId(userId);
                    if(gameUserHomeList!=null && gameUserHomeList.size()>0){
                        result.put("msg","您已加入过战队,请勿重复加入!");
                        result.put("state",3);
                        return result;
                    }
                    if(gameUserHomes!=null && gameUserHomes.size() > configNum.intValue()){
                        result.put("msg","对不起，该战队已满员！");
                        result.put("state",2);
                    }else{
                        GameUserHome createHomeUser = new GameUserHome();
                        createHomeUser.setUserId(userId);
                        createHomeUser.setHomeId(gameHome.getId());
                        createHomeUser.setJoinTime(new Date());
                        gameUserHomeService.save(createHomeUser);
                        result.put("msg","恭喜你，成功加入了一支战队！");
                        result.put("state",200);
                    }
                }else{
                    result.put("msg","对不起，无此战队！");
                    result.put("state",1);
                }
            }
        }catch (Exception ex){
            result.put("msg","异常");
            result.put("state",500);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/joinHome",method = RequestMethod.POST)
    public JSONObject joinHome(ModelAndView model, String gamePwd,Long userId){
        JSONObject result = new JSONObject();
        try{
            if(gamePwd!=null){
                GameHome gameHome = gameHomeService.findByPwd(gamePwd);
                if(gameHome!=null){
                    List<GameUserHome> gameUserHomes = gameUserHomeService.findByHomeId(gameHome.getId());
                    Long configNum = gameConfigService.findNum();
                    if(gameUserHomes!=null && gameUserHomes.size() > configNum.intValue()){
                        result.put("msg","对不起，该战队已满员！");
                        result.put("state",1);
                    }else{
                        GameUserHome createHomeUser = new GameUserHome();
                        createHomeUser.setUserId(userId);
                        createHomeUser.setHomeId(gameHome.getId());
                        createHomeUser.setJoinTime(new Date());
                        gameUserHomeService.save(createHomeUser);
                        result.put("msg","恭喜你，成功加入了一支战队！");
                        result.put("homeName",gameHome.getName());
                        result.put("state",200);
                    }
                }else{
                    result.put("msg","对不起，无此战队！");
                    result.put("state",1);
                }
            }
        }catch (Exception ex){
            result.put("msg","异常");
            result.put("state",500);
        }
        return result;
    }

    @RequestMapping(value = "/showUserInfo")
    public ModelAndView showUserInfo(ModelAndView model,HttpServletRequest request){
        List<GameUserDto> gameUsers = gameUserService.findAllUser();
        model.setViewName("showUser");
        model.addObject("users",gameUsers);
        model.addObject("flag",1);
        model.addObject("rule","qazwsx@123".equals(getCookie(request,"d_t"))?1:2);
        return model;
    }

    @RequestMapping(value = "/showUserDayInfo")
    public ModelAndView showUserDayInfo(HttpServletRequest request,ModelAndView model){
        List<GameUserDto> gameUsers = gameUserService.findUserDay();
        model.setViewName("showUser");
        model.addObject("users",gameUsers);
        model.addObject("flag",2);
        model.addObject("rule","qazwsx@123".equals(getCookie(request,"d_t"))?1:2);
        return model;
    }

    @RequestMapping(value = "/live/{page}")
    public ModelAndView toPage(ModelAndView model, HttpServletRequest request, @PathVariable("page") String page){
        Enumeration<String> en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            model.addObject(key, request.getParameter(key));
        }
        model.setViewName(page);
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/checkAdminToken",method = RequestMethod.POST)
    public JSONObject checkAdminToken(ModelAndView model, String token){
        JSONObject result = new JSONObject();
        try{
            if("qazwsx@123".equals(token)){
                result.put("state",200);
            }else{
                result.put("state",1);
                result.put("msg","口令有误，请重新录入!");
            }
        }catch (Exception ex){
            result.put("msg","异常");
            result.put("state",500);
        }
        return result;
    }

    @RequestMapping(value = "/excel/{flag}", method = RequestMethod.GET)
    public void excel(HttpServletResponse response,HttpServletRequest request,@PathVariable Integer flag) throws Exception {
        if(!"qazwsx@123".equals(getCookie(request,"d_t"))){
            return;
        }
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("序号");
        titles.add("id");
        titles.add("火币id");
        titles.add("队长标识");
        titles.add("所属战队");
        titles.add("IP地址");
        titles.add("创建时间");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        List<GameUserDto> gameUsers = gameUserService.findAllUser();
        if(flag == 2){
            gameUsers = gameUserService.findUserDay();
        }
        int count = 1;
        for(GameUserDto gameUserDto : gameUsers){
            List<Object> row = new ArrayList();
            row.add(count);
            row.add(gameUserDto.getId());
            row.add(gameUserDto.getToken());
            row.add(gameUserDto.getHomeUserId()!=null && gameUserDto.getId().intValue() == gameUserDto.getHomeUserId().intValue()?"队长":"");
            row.add(gameUserDto.getName());
            row.add(gameUserDto.getUserIp());
            row.add(DateUtils.format(gameUserDto.getCreateTime(),DateUtils.FORMAT_ONE));
            rows.add(row);
            count++;
        }
        data.setRows(rows);
        ExportExcelUtils.exportExcel(response,"hadax.xlsx",data);
    }

    public String getCookie(HttpServletRequest request,String key){
        Cookie[] cookie = request.getCookies();
        if(cookie!=null){
            for (int i = 0; i < cookie.length; i++) {
                Cookie cook = cookie[i];
                if(cook.getName().equalsIgnoreCase(key)){
                    return cook.getValue();
                }
            }
        }
        return null;
    }

    public boolean isWap(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        if (agent.indexOf("Android") > 0
                || agent.indexOf("iPad") > 0
                || agent.indexOf("iPhone") > 0
                || agent.indexOf("IEMobile") > 0) {
            return true;
        }
        return false;
    }

    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

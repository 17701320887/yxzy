package com.active.common.bean;

import static com.active.common.bean.ResultMsg.ResultCode.*;

/**
 * @author zb
 * @date 2017/06/29
 */
public class ResultMsg {
    /**
     * 响应状态
     */
    protected Integer state;
    /**
     * 响应消息
     */
    protected String stateInfo;
    /**
     * 响应结果
     */
    protected Object resInfo;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Object getResInfo() {
        return resInfo;
    }

    public void setResInfo(Object resInfo) {
        this.resInfo = resInfo;
    }

    public ResultMsg(Integer state, String stateInfo, Object resInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.resInfo = resInfo;
    }

    public ResultMsg(Integer state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public ResultMsg() {
    }

    public static class ResultCode {
        //成功
        public final static Integer SUCCESS = 0;
        //正常失败(用于条件限制)
        public final static Integer ERROR = -2;
        //发生异常
        public final static Integer EXCEPTION = -1;
        //参数缺失
        public final static Integer PARAM_MISS = 201;
        //不在登录状态
        public final static Integer LOGIN_OUT = 202;
        //没有操作权限
        public final static Integer NO_PERMISSION = 203;
        //参数不合法
        public final static Integer PARAM_ERROR_CODE = 204;
        //没有登录
        public final static Integer NOT_LOGIN = 205;
        //短信验证码发送失败
        public final static Integer SEND_SMS_ERROR = 206;
        //图片验证码已失效
        public final static Integer VCODE_ERROR = 207;
        //短信验证码输入错误
        public final static Integer SMS_CODE_ERROR = 208;


        /**
         * 网络异常
         */
        public final static Integer NET_ERROR_CODE = 209;
        /**
         * 没有用户
         */
        public final static Integer NO_USER_STATUS = 301;

        public final static String REQUEST_SUCCESS = "success";

        public final static String PARAM_ERROR = "param error";




    }
    public static ResultMsg success(Object resInfo){
        return new ResultMsg(SUCCESS,REQUEST_SUCCESS,resInfo);
    }

    public static ResultMsg failure(String stateInfo){
        return new ResultMsg(ERROR,stateInfo,null);
    }

    public static ResultMsg exception(String stateInfo){
        return new ResultMsg(EXCEPTION,stateInfo,null);
    }

}
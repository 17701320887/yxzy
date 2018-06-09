package com.active.service;

/**
 * Created by chenqi on 2018/3/13.
 */
public interface ITicketService {

    /**
     * 生成登录票据
     * @param userId 用户ID
     * @param expire 有效时间 （秒）
     * @return
     */
    String createTicket(Long userId, int expire);

    /**
     * 根据登录票据查询登录用户ID
     * @param ticket 登录票据
     * @return
     */
    Long findByDT(String ticket);
}

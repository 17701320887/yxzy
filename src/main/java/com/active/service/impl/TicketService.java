package com.active.service.impl;

import com.active.common.constans.Constans;
import com.active.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenqi on 2018/3/13.
 */
@Service
public class TicketService implements ITicketService {

    @Resource(name = "redisTemplate")
    private ValueOperations valueOperations;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String createTicket(Long userId, int expire) {
        String ticket = UUID.randomUUID().toString();
        put(Constans.UUID_TICKET_PREFIX + ticket, userId, expire);
        return ticket;
    }

    @Override
    public Long findByDT(String ticket) {
        Long userId = (Long) valueOperations.get(Constans.UUID_TICKET_PREFIX + ticket);
        if(userId == null){
            return 0l;
        }
        return userId;
    }

    private void put(String ticket, Long userId, int expire) {
        valueOperations.set(ticket,userId);
        redisTemplate.expire(ticket, expire, TimeUnit.SECONDS);
    }

}

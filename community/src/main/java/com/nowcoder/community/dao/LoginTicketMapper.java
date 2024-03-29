package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
@Deprecated//不推荐使用的注解
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket (user_id, ticket, status, expired) ",
            "Values(#{userId}, #{ticket}, #{status}, #{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id, user_id, ticket, status, expired ",
            "from login_ticket where ticket = #{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "update login_ticket set status = #{status} where ticket =#{ticket}",
    })
    int updateStatus(String ticket, int status);
}

package com.github.ong.responsibility.user.dao;

import com.github.ong.responsibility.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户信息持久化操作层
 *
 * @author Wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo,Long> {

}

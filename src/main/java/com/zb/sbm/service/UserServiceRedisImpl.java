package com.zb.sbm.service;

import com.zb.sbm.dao.UserMapper;
import com.zb.sbm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "USER")
public class UserServiceRedisImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(key = "'user.queryAll'")
    public List<User> search(Map<String, Object> condition) {
        System.out.println("cache");
        return userMapper.search(condition);
    }

    @Cacheable(key = "#id")
    public User get(String id) {
        System.out.println("cache");
        return userMapper.get(id);
    }

    @CachePut(key = "#user.id")
    public int modify(User user){
        return  userMapper.modify(user);
    }
}

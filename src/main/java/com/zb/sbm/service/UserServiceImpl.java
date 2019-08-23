package com.zb.sbm.service;

import com.zb.sbm.dao.UserMapper;
import com.zb.sbm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> search(Map<String, Object> condition) {
        return userMapper.search(condition);
    }

    @Override
    public User get(String id) {
        return userMapper.get(id);
    }

    public int modify(User user){
        return userMapper.modify(user);
    }
}

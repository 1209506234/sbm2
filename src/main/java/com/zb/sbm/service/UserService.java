package com.zb.sbm.service;

import com.zb.sbm.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> search(Map<String,Object> condition);

    public User get(String id);

    public int modify(User user);
}

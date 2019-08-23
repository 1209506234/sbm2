package com.zb.sbm.dao;

import com.zb.sbm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    public List<User> search(Map<String,Object> condition);

    public User get(String id);

    public int modify(User user);
}

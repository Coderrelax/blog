package com.example.blog.repository;

import com.example.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 用户资源库的实现
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        // 用户不存在，新建
        if (id == null){
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUsers() {

        return new ArrayList<User>(this.userMap.values());
    }
}


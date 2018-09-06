package com.example.blog.repository;

import com.example.blog.domain.User;

import java.util.List;

/**
 * User Repository 接口
 *
 */
public interface UserRepository {
    /**
     * * 创建或者修改User
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);
    /**
     * 删除User
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询单个User
     * @param id
     * @return
     */
    User getUserById(Long id);
    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();
}

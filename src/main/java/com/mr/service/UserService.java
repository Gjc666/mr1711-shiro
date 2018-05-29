package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/5/25.
 */
public interface UserService {
    User getUserByUserName(String username);

    /**
     * 通过用户id查询角色
     * @param id
     * @return
     */
    List<String> selectRolesByUserId(Integer id);

    /**
     * 通过用户id查询权限
     * @param id
     * @return
     */
    List<String> selectPermissionByUserId(Integer id);
}

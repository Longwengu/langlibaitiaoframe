package com.apeframe.user.service;


import com.apeframe.user.entity.dto.UserDTO;
import com.apeframe.user.entity.po.UserPo;
import com.apeframe.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(UserDTO userDTO){
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDTO, userPo);
        int insert = userMapper.insert(userPo);
        return insert;
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }


    public IPage<UserPo> findUserByPage(UserDTO userDTO) {
        Long current = userDTO.getCurrent();
        Long size = userDTO.getSize();
        IPage<UserPo> page = new Page<>(current, size);
        page = userMapper.findUserByPage(page);
        return page;
    }
}

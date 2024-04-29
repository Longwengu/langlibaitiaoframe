package com.apeframe.user.mapper;

import com.apeframe.user.entity.po.UserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<UserPo> {

    IPage<UserPo> findUserByPage(@Param("page") IPage<UserPo> page);
}

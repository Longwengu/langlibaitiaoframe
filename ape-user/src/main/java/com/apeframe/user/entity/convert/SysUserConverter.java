package com.apeframe.user.entity.convert;


import com.apeframe.user.entity.po.SysUser;
import com.apeframe.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConverter {
    SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);

    SysUser convertReq2SysUser(SysUserReq sysUserReq);
}

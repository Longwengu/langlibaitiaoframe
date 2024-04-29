package com.apeframe.user.entity.req;

import com.apeframe.common.web.bean.PageRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2024-04-22 13:45:38
 */
public class SysUserReq extends PageRequest implements Serializable {
    private static final long serialVersionUID = -87136642109991895L;

    private Integer id;

    private String name;

    private Integer age;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}


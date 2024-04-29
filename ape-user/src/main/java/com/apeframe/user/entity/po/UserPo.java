package com.apeframe.user.entity.po;


import com.apeframe.common.mybatisplus.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("user")
@Data
public class UserPo extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;


    private Integer age;

}

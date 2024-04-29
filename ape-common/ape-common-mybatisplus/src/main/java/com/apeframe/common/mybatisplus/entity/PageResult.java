package com.apeframe.common.mybatisplus.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {
    private Long current;
    private Long size;
    private Long total;
    private Long pages;
    private List<T> records = new ArrayList<>();






}

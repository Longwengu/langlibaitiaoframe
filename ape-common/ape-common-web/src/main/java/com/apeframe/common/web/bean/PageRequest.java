package com.apeframe.common.web.bean;

public class PageRequest {

    private Long current;
    private Long size;


    public Long getCurrent() {
        if (current == null || current <= 0){
            return 1L;
        }
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        if (size == null || size <= 0 || size > Integer.MAX_VALUE){
            return 10L;
        }
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}

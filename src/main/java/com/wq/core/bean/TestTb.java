package com.wq.core.bean;

import java.sql.Timestamp;

/**
 * Created by 王萍 on 2016/12/29 0029.
 */
public class TestTb {

    private Integer id;
    private String name;
    private Timestamp birthday;

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

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
}

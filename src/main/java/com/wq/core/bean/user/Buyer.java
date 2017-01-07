package com.wq.core.bean.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */

@Getter
@Setter
public class Buyer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Gender gender;
    private String email;
    private String realName;
    private Date registerTime;
    private String province;
    private String city;
    private String town;
    private String addr;
    private Integer isDel;

    public enum Gender{
        MAN{
            public String getName(){return "男";}
        },
        WOMAN{
            public String getName(){return "女";}
        },
        SECRET{
            public String getName(){return "保密";}
        };

        public abstract String getName();
    }
}

package com.wq.core.query.user;

import com.wq.common.database.OrderField;
import com.wq.core.query.BaseQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */

@Getter
@Setter
public class BuyerQuery extends BaseQuery {

    private String username;
    private boolean usernameLike;

    private String password;
    private boolean passwordLike;

    private String gender;
    private boolean genderLike;

    private String email;
    private boolean emailLike;

    private String realName;
    private boolean realNameLike;

    private Date registerTime;
    private String province;
    private String city;
    private String town;
    private String addr;
    private boolean addrLike;

    private Integer isDel;

    private List<OrderField> orderFields = new LinkedList<OrderField>();


}

package com.wq.core.bean.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class Addr implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String buyerId;
	private String name;
	private String city;
	private String addr;
	private String phone;
	private Integer isDef;

}

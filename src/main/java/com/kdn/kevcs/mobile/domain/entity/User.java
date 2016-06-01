package com.kdn.kevcs.mobile.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
public class User {

    private Integer userNo;

    private String username;

    private String password;

    private String authorities;

    private String name;

    private String phoneno;

    private String hphoneno;

    private String email;

    private String zipcd;

    private String addr;

    private String addr2;

    private String entcompDate;

    private String retireDate;

    private String cardNo;

    private Integer stocId;

    private Integer csId;

    private String roleCl;

    private String delDate;

    private String delYn;

    private String Manufr;

}
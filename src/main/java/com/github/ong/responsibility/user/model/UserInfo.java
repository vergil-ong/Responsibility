package com.github.ong.responsibility.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 用户信息
 *
 * @author Wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Entity
@Table(name = "user")
@ApiModel
@Getter
@Setter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "id", dataType = "int")
    private Long id;

    @Column(name = "user_name")
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String userName;

    @Column(name = "login_name")
    @ApiModelProperty(value = "登录名", dataType = "String")
    private String loginName;

    @Column(name = "password")
    @ApiModelProperty(value = "密码", dataType = "String")
    private String password;

    @Column(name = "mobile")
    @ApiModelProperty(value = "手机号", dataType = "String")
    private String mobile;

    @Column(name = "email")
    @ApiModelProperty(value = "邮箱", dataType = "String")
    private String email;

    @Column(name = "extra")
    @ApiModelProperty(value = "附加属性", dataType = "String")
    private String extra;
}

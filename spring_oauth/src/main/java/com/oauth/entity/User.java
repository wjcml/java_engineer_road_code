package com.oauth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "user")
@Data
@ApiModel(value = "user对象", description = "user对象")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("username")
    private String username;
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
    @NotBlank(message = "电话号不能为空")
    @ApiModelProperty("电话号")
    private String phone;
}

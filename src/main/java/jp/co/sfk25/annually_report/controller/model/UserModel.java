package jp.co.sfk25.annually_report.controller.model;

import lombok.Data;

@Data
public class UserModel {

    private String name;
    private String email;
    private String password;
    private Integer groupId;

}

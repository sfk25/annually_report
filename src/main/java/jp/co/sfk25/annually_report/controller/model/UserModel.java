package jp.co.sfk25.annually_report.controller.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserModel {

    private String name;
    private String email;
    private String password;
    private Integer groupId;
    private LocalDateTime enteringCompanyDate;
    private Integer sex;
    private Integer bloodType;
    private LocalDateTime birthday;
    private String selfIntroduction;

}

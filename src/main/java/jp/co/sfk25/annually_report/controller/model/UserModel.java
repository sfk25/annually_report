package jp.co.sfk25.annually_report.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String name;
    private String email;
    private String password;
    private Integer groupId;
    private String enteringCompanyDate;
    private Integer sex;
    private Integer bloodType;
    private String birthday;
    private String selfIntroduction;

}

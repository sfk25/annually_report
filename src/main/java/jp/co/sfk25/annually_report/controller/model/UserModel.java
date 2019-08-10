package jp.co.sfk25.annually_report.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer groupId;
    private Timestamp enteringCompanyDate;
    private Integer sex;
    private Integer bloodType;
    private Timestamp birthday;
    private String selfIntroduction;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}

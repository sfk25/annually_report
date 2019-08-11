package jp.co.sfk25.annually_report.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserUpdate {

    @NotNull
    private Integer id;
    @NotNull
    @Size(min = 1, max = 20)
    private String name;
    @NotNull
    @Size(min = 1, max = 255)
    private String email;
    @NotNull
    private Integer groupId;

    private String enteringCompanyDate;
    private Integer sex;
    private Integer bloodType;
    private String birthday;
    private String selfIntroduction;

}

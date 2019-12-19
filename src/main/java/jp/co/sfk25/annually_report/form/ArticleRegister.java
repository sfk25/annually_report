package jp.co.sfk25.annually_report.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ArticleRegister {

    private Integer id;
    @NotNull
    private String createdYear;
    @NotNull
    @Size(min = 1, max = 255)
    private String title;
    @Size(min = 1, max = 20)
    private String tag;
    private int processId;
    @NotNull
    @Size(min = 1, max = 50000)
    private String content;

}

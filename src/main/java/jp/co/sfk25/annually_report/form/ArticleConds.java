package jp.co.sfk25.annually_report.form;

import lombok.Data;

@Data
public class ArticleConds {

    private Integer id;
    private String title;
    private int groupId;
    private String userName;
    private String targetYear;
    private String tag;
    private int processId;

}

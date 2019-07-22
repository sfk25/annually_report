package jp.co.sfk25.annually_report.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRegisterModel {

    private Integer articleId;
    private Integer userId;

    private String title;
    private String value;
    private Integer createdYear;

    private String tag;
    private Integer processId;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}

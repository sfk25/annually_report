package jp.co.sfk25.annually_report.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleModel {
    private Integer id;
    private String title;
    private String userName;
    private Integer userId;
    private String groupName;
    private List<String> tags;
    private List<String> processes;
    private Integer createdYear;
    private String createdAt;
}

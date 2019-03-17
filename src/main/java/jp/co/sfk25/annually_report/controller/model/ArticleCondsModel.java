package jp.co.sfk25.annually_report.controller.model;

import jp.co.sfk25.annually_report.domain.entity.Group;
import jp.co.sfk25.annually_report.domain.entity.Process;
import jp.co.sfk25.annually_report.domain.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCondsModel {
    private List<Group> groups;
    private List<Process> processes;
    private List<Tag> tags;
    private List<Integer> years;
}

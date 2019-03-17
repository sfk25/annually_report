package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.controller.model.ArticleModel;
import jp.co.sfk25.annually_report.controller.model.ArticleCondsModel;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.domain.entity.Group;
import jp.co.sfk25.annually_report.domain.entity.Process;
import jp.co.sfk25.annually_report.domain.entity.Tag;
import jp.co.sfk25.annually_report.form.ArticleConds;
import jp.co.sfk25.annually_report.service.ArticleService;
import jp.co.sfk25.annually_report.service.GroupService;
import jp.co.sfk25.annually_report.service.ProcessService;
import jp.co.sfk25.annually_report.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/article")
public class ArticleRestController {
    private final ArticleService articleService;
    private final GroupService groupService;
    private final ProcessService processService;
    private final TagService tagService;

    @GetMapping(path = "")
    public List<Article> getAll() {
        return articleService.getArticles();
    }

    @PostMapping(path = "search")
    public List<ArticleModel> search(@RequestBody ArticleConds articleConds) {
        return articleService.findByConds(articleConds);
    }

    @GetMapping(path = "getConds")
    public ArticleCondsModel getConds() {
        List<Group> groups = groupService.getGroups();
        List<Process> processes = processService.getProcesses();
        List<Tag> tags = tagService.getTags();
        List<Integer> years = articleService.getYears();

        return new ArticleCondsModel(groups, processes, tags, years);
    }


}

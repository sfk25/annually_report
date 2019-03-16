package jp.co.sfk25.annually_report.controller;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Article> search(@RequestBody ArticleConds articleConds) {
        return articleService.findByConds(articleConds);
    }

    @GetMapping(path = "getConds")
    public Map<String, List> getConds() {
        List<Group> groups = groupService.getGroups();
        List<Process> processes = processService.getProcesses();
        List<Tag> tags = tagService.getTags();
        List<Integer> years = articleService.getYears();

        Map<String, List> conds = new HashMap<>();
        conds.put("groups", groups);
        conds.put("processes", processes);
        conds.put("tags", tags);
        conds.put("years", years);

        return conds;
    }


}

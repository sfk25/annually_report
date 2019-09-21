package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.controller.model.ArticleModel;
import jp.co.sfk25.annually_report.controller.model.ArticleCondsModel;
import jp.co.sfk25.annually_report.domain.entity.*;
import jp.co.sfk25.annually_report.domain.entity.Process;
import jp.co.sfk25.annually_report.form.ArticleConds;
import jp.co.sfk25.annually_report.form.ArticleRegister;
import jp.co.sfk25.annually_report.service.ArticleService;
import jp.co.sfk25.annually_report.service.GroupService;
import jp.co.sfk25.annually_report.service.ProcessService;
import jp.co.sfk25.annually_report.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
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

    @GetMapping(path = "detail/{id}")
    public ArticleModel get(@PathVariable("id") int id) {
        return articleService.getArticle(id);
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
        List<Integer> years = articleService.prepareYears();

        return new ArticleCondsModel(groups, processes, tags, years);
    }

    @PostMapping(path = "register")
    public Integer register(@RequestBody @Validated ArticleRegister articleRegister,
                         BindingResult bindingResult, @AuthenticationPrincipal User user) throws Exception {

        // TODO エラーハンドリング修正

        if (bindingResult.hasErrors()) {
            throw new Exception("入力した値を確認してください");
        }

        return articleService.register(articleRegister, user);
    }

    @PostMapping(path = "update")
    public void update(@RequestBody @Validated ArticleRegister articleRegister,
                       BindingResult bindingResult, @AuthenticationPrincipal User user) throws Exception {

        // TODO エラーハンドリング修正

        if (bindingResult.hasErrors()) {
            throw new Exception("入力した値を確認してください");
        }

        articleService.update(articleRegister);
    }

}

package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/articles")
@CrossOrigin
public class ArticleRestController {
    private final ArticleService articleService;

    @GetMapping(path = "")
    public List<Article> getAll() {
        return articleService.getArticles();
    }

    @PostMapping(path = "search")
    public List<Article> search(@RequestBody Conds conds) {

        System.out.println("Check Conds");
        System.out.println(conds);
        System.out.println(conds.getTitle());

        System.out.println(articleService.getArticles());

        return articleService.findByConds(conds);
    }


}

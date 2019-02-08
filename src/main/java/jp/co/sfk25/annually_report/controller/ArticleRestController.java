package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.service.ArticleService;
import jp.co.sfk25.annually_report.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/articles")
@CrossOrigin()
public class ArticleRestController {
    private final ArticleService articleService;

    @GetMapping(path = "")
    public List<Article> getAll() {
        return articleService.getArticles();
    }
}

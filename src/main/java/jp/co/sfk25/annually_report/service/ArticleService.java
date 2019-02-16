package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.repository.ArticleRepository;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.controller.Conds;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public List<Article> findByConds(Conds conds){
        return articleRepository.findByConds(conds);
    }
}

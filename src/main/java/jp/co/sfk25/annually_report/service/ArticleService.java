package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.repository.ArticleRepository;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public List<Article> findByConds(ArticleConds articleConds){
        return articleRepository.findByConds(articleConds);
    }

    public List<Integer> getYears(){
        List<Integer> years = new ArrayList<>();

        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime date = nowDate.minusYears(10);

        int year = date.getYear();

        for (int i=0; i<20; i++)
            years.add(year++);

        return years;
    }

}

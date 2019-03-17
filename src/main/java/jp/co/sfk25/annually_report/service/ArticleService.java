package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.ArticleModel;
import jp.co.sfk25.annually_report.domain.repository.ArticleRepository;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;
import jp.co.sfk25.annually_report.jooq.tables.*;
import org.jooq.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import static jp.co.sfk25.annually_report.jooq.tables.Articles.ARTICLES;
import static jp.co.sfk25.annually_report.jooq.tables.Groups.GROUPS;
import static jp.co.sfk25.annually_report.jooq.tables.Users.USERS;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public List<ArticleModel> findByConds(ArticleConds articleConds){
        Result<Record8<Integer, String, String, String, Object, Object, Integer, Timestamp>> result
                = articleRepository.findByConds(articleConds);

        // TODO Repository側とまとめたい
        Articles a = ARTICLES.as("a");
        Users b = USERS.as("b");
        Groups c = GROUPS.as("c");

        List<ArticleModel> articles = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        result.stream().forEach(record -> {
            ArticleModel article = new ArticleModel();

            article.setId(record.getValue(a.ID));
            article.setTitle(record.getValue(a.TITLE));
            article.setUserName(record.getValue(b.NAME));
            article.setGroupName(record.getValue(c.VALUE));
            article.setTags(Arrays.asList(record.getValue("tags").toString().split(",")));
            article.setProcesses(Arrays.asList(record.getValue("processes").toString().split(",")));
            article.setCreatedYear(record.getValue(a.CREATED_YEAR));
            article.setCreatedAt(formatter.format(record.getValue(a.CREATED_AT).toLocalDateTime()));

            articles.add(article);
        });

        return articles;
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

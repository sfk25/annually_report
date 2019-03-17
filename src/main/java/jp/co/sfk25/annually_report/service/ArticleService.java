package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.ArticleModel;
import jp.co.sfk25.annually_report.domain.repository.ArticleRepository;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;
import jp.co.sfk25.annually_report.jooq.tables.*;
import org.jooq.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import static jp.co.sfk25.annually_report.jooq.tables.Articles.ARTICLES;
import static jp.co.sfk25.annually_report.jooq.tables.Groups.GROUPS;
import static jp.co.sfk25.annually_report.jooq.tables.Users.USERS;

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
        // 取得
        Result<Record> result = articleRepository.findByConds(articleConds);

        // 変換
        List<ArticleModel> articles = convertToModel(result);

        return articles;
    }

    private List<ArticleModel> convertToModel(Result<Record> result) {
        // TODO Repository側とまとめたい
        Articles a = ARTICLES.as("a");
        Users b = USERS.as("b");
        Groups c = GROUPS.as("c");

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        List<ArticleModel> articles = new ArrayList<>();

        // モデルに設定
        result.stream().forEach(record -> {
            ArticleModel article = new ArticleModel();

            article.setId(record.getValue(a.ID));
            article.setTitle(record.getValue(a.TITLE));
            article.setUserName(record.getValue(b.NAME));
            article.setGroupName(record.getValue(c.VALUE));

            // 使用した技術
            List<String > tags = !StringUtils.isEmpty(record.getValue("tags"))
                    ? Arrays.asList(record.getValue("tags").toString().split(",")):new ArrayList<>();
            article.setTags(tags);

            // 担当した工程
            List<String > processes = !StringUtils.isEmpty(record.getValue("processes"))
                    ?Arrays.asList(record.getValue("processes").toString().split(",")):new ArrayList<>();
            article.setProcesses(processes);

            article.setCreatedYear(record.getValue(a.CREATED_YEAR));
            article.setCreatedAt(formatter.format(record.getValue(a.CREATED_AT).toLocalDateTime()));

            articles.add(article);
        });

        return articles;
    }

    /**
     * 現在の西暦から前後それぞれ10年分の西暦のリストを作成
     */
    public List<Integer> prepareYears(){
        List<Integer> years = new ArrayList<>();

        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime date = nowDate.minusYears(10);

        int year = date.getYear();

        for (int i=0; i<20; i++)
            years.add(year++);

        return years;
    }

}

package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.controller.model.ArticleModel;
import jp.co.sfk25.annually_report.controller.model.ArticleRegisterModel;
import jp.co.sfk25.annually_report.domain.entity.Tag;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.domain.repository.*;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;
import jp.co.sfk25.annually_report.form.ArticleRegister;
import org.jooq.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

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
    private final ArticleTagRepository articleTagRepository;
    private final ArticleProcessRepository articleProcessRepository;
    private final TagRepository tagRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public List<ArticleModel> findByConds(ArticleConds articleConds){
        // 取得
        Result<Record> result = articleRepository.findByConds(articleConds);

        // 変換
        return convertToModel(result);
    }

    private List<ArticleModel> convertToModel(Result<Record> result) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        List<ArticleModel> articles = new ArrayList<>();

        // モデルに設定
        result.forEach(record -> {
            ArticleModel article = new ArticleModel();

            article.setId(record.getValue(ARTICLES.ID));
            article.setTitle(record.getValue(ARTICLES.TITLE));
            article.setUserName(record.getValue(USERS.NAME));
            article.setUserId(record.getValue(USERS.ID));
            article.setGroupName(record.getValue(GROUPS.VALUE));

            // 使用した技術
            List<String> tags = !StringUtils.isEmpty(record.getValue("tags"))
                    ? Arrays.asList(record.getValue("tags").toString().split(","))
                    : new ArrayList<>();
            article.setTags(tags);

            // 担当した工程
            List<String> processes = !StringUtils.isEmpty(record.getValue("processes"))
                    ? Arrays.asList(record.getValue("processes").toString().split(","))
                    : new ArrayList<>();
            article.setProcesses(processes);

            article.setCreatedYear(record.getValue(ARTICLES.CREATED_YEAR));
            article.setCreatedAt(formatter.format(record.getValue(ARTICLES.CREATED_AT).toLocalDateTime()));

            articles.add(article);
        });

        return articles;
    }

    /**
     * 現在の西暦から前後それぞれ10年分の西暦のリストを作成
     */
    public List<Integer> prepareYears(){
        List<Integer> years = new ArrayList<>();

        int year = LocalDateTime.now().minusYears(10).getYear();

        for (int i=0; i<20; i++) years.add(year++);

        return years;
    }


    public void register(ArticleRegister articleRegister, User user) {
        // モデル生成
        ArticleRegisterModel articleRegisterModel = prepareArticleRegisterModel(articleRegister, user);

        // 記事登録
        Integer articleId = articleRepository.insert(articleRegisterModel);

        // タグIDを取得。存在しないタグ名はタグを登録し、登録したタグIDを取得する。
        String tagValue = articleRegisterModel.getTag();
        Tag tag = tagRepository.findByValue(tagValue);
        Integer tagId = tag != null
                ? tag.getId()
                : tagRepository.insert(tagValue);

        // タグ登録
        articleTagRepository.insert(articleId, tagId);

        // 工程登録
        Integer processId = articleRegisterModel.getProcessId();
        articleProcessRepository.insert(articleId, processId);
    }

    /**
     * 登録のためのモデル生成
     */
    private ArticleRegisterModel prepareArticleRegisterModel(ArticleRegister articleRegister, User user) {
        ArticleRegisterModel articleRegisterModel = new ArticleRegisterModel();

        articleRegisterModel.setUserId(user.getId());

        articleRegisterModel.setTitle(articleRegister.getTitle());
        articleRegisterModel.setValue(articleRegister.getContent());

        articleRegisterModel.setCreatedYear(Integer.parseInt(articleRegister.getTargetYear()));

        articleRegisterModel.setTag(articleRegister.getTag());
        articleRegisterModel.setProcessId(articleRegister.getProcessId());

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        articleRegisterModel.setCreatedAt(timestamp);
        articleRegisterModel.setUpdatedAt(timestamp);

        return articleRegisterModel;
    }

}

package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.jooq.tables.records.TagsRecord;
import jp.co.sfk25.annually_report.domain.entity.Tag;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.Tags.TAGS;

/**
 * Tagsリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class TagRepository {

    private final DSLContext dslContext;

    public Tag findOne(int id) {
        return dslContext.selectFrom(TAGS).where(TAGS.ID.eq(id)).fetchOne(this::toEntity);
    }

    public Tag findByValue(String value) {
        return dslContext.selectFrom(TAGS).where(TAGS.VALUE.eq(value)).fetchOne(this::toEntity);
    }

    public List<Tag> findAll() {
        return dslContext.selectFrom(TAGS).fetch(this::toEntity);
    }

    private Tag toEntity(TagsRecord record) {
        return Tag.of(
                record.getId(),
                record.getValue());
    }

    public TagsRecord insert(String value) {
        return dslContext.insertInto(TAGS, TAGS.VALUE)
            .values(value)
            .returning()
            .fetchOne();
    }
}

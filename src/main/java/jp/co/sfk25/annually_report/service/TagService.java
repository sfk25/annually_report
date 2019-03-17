package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.repository.TagRepository;
import jp.co.sfk25.annually_report.domain.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }
}

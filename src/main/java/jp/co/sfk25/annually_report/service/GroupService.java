package jp.co.sfk25.annually_report.service;

import jp.co.sfk25.annually_report.domain.repository.GroupRepository;
import jp.co.sfk25.annually_report.domain.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }
}

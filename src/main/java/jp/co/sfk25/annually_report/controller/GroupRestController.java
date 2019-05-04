package jp.co.sfk25.annually_report.controller;

import jp.co.sfk25.annually_report.domain.entity.Group;
import jp.co.sfk25.annually_report.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/group")
public class GroupRestController {
    private final GroupService groupService;

    @GetMapping(path = "")
    public List<Group> getAll() {
        return groupService.getGroups();
    }

}

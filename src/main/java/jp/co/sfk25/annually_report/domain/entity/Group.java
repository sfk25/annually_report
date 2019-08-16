package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

import java.util.List;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Group {

    private final Integer id;

    @NonNull
    private final String value;

    private final List<User> members;

    public static Group create(Integer id, String value, List<User> members) {
        return Group.of(id, value, members);
    }
}

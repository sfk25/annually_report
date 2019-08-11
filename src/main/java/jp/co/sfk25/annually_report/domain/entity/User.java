package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@Value
@RequiredArgsConstructor(staticName = "of")
public class User implements UserDetails {

  private final Integer id;

  @NonNull
  private final String name;

  @NonNull
  private final String email;

  @NonNull
  private final String password;

  @NonNull
  private final Integer groupId;

  private final LocalDateTime enteringCompanyDate;

  private final Integer sex;

  private final Integer bloodType;

  private final LocalDateTime birthday;

  private final String selfIntroduction;

  @NonNull
  private final LocalDateTime createdAt;

  @NonNull
  private final LocalDateTime updatedAt;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return this.name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public static User create(String name, String email, String password, int groupId,
                            LocalDateTime entering_companyDate, Integer sex, Integer bloodType,
                            LocalDateTime birthday, String selfIntroduction) {
    LocalDateTime now = LocalDateTime.now();
    return User.of(null, name, email, password, groupId,
            entering_companyDate, sex, bloodType,
            birthday, selfIntroduction, now, now);
  }
}

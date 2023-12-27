package analyzer.domain.dto;

import analyzer.domain.models.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoDTO {
    private boolean isAuth;
    private User user;
}
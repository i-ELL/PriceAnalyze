package analyzer.domain.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {
    @NotEmpty(message = "Поле имя не может быть пустым")
    private String username;

    @NotEmpty(message = "Поле имя не может быть пустым")
    private String email;


    @NotEmpty(message = "Поле пароль не может быть пустым")
    private String password;
}

package teksystems.porter.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.porter.validation.EmailUnique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    private Integer id;

    @EmailUnique(message = "Email already exists in database")
    @NotBlank(message = "Email is required")
    @Email(message = "@Email from spring validator")
    private String email;

    @NotBlank(message = "Password required")
    private String password;

}

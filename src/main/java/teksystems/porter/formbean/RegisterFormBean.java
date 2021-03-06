package teksystems.porter.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.porter.validation.EmailUnique;
import teksystems.porter.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@FieldMatch(fields = {"password", "confirmPassword"}, message = "Passwords must match")
public class RegisterFormBean {

    private Integer id;

    @EmailUnique(message = "Email already exists in database")
    @NotBlank(message = "Email is required")
    @Email(message = "@Email from spring validator")
    private String email;

    @Length(min = 3, max = 15, message="Password must be between 3 and 15 characters")
    @NotBlank(message = "Password required")
    private String password;

    @NotBlank(message = "Must repeat password")
    private String confirmPassword;

}

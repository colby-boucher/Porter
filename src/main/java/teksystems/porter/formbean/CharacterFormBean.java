package teksystems.porter.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CharacterFormBean {

    private Integer id;
    private Integer userId;

    @NotBlank(message = "Name required")
    private String name;

    @NotNull(message = "Strength characteristic required")
    @Min(1)
    private Integer strength;

}

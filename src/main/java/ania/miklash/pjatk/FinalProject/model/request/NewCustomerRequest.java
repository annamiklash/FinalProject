package ania.miklash.pjatk.FinalProject.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewCustomerRequest implements Serializable {

    @NotBlank(message = "First name is mandatory")
    @Size(min = 1, max = 30, message
            = "First name should be between 1 and 30 characters")
    @Pattern.List({
            @Pattern(regexp = "^[a-zA-Z]{1,30}$"),
            @Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
    })
    private String firstName;

    @Size(min = 2, max = 30, message
            = "First name should be between 2 and 30 characters")
    @Pattern.List({
            @Pattern(regexp = "^[A-Z][a-z]*$"),
            @Pattern(regexp = "^[A-Z][a-z][A-Z][a-z]*$"),
            @Pattern(regexp = "^[A-Z][a-z]*(-|\\s)[A-Z][a-z]*$"),
            @Pattern(regexp = "^[A-Z]('|’)[A-Z][a-z]*$"),
            @Pattern(regexp = "^[a-z]+\\s[A-Z][a-z]*$ "),
            @Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
    })
    private String lastName;

    @NotBlank(message = "phone number is mandatory")
    @Size(min = 9, max = 9, message
            = "phone number should be 9 characters long")
    @Pattern(regexp = "^\\d{9}$", message = "should contain only digits")
    private String phoneNumber;

    @NotBlank(message = "email is mandatory")
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 100, message
            = "Email should be between 5 and 100 characters")
    private String email;

    @Pattern.List({
            @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain one digit."),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain one lowercase letter."),
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain one upper letter."),
            @Pattern(regexp = "(?=.*[!@#$%^&*+=?-_()/\"\\.,<>~`;:]).+", message = "Password must contain one special character."),
            @Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
    })
    private String password;

    @Pattern(regexp = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$")
    private String birthDate;

}

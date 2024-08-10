package vn.edu.likelion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TraineeDTO {
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Length(min = 5, max = 45, message = "Name must have 5-45 characters")
    private String name;

    @Email
    @NotEmpty(message = "Email must not be empty")
    @Length(min = 7, max = 50, message = "Email must have 7-50 characters")
    private String email;

    @NotEmpty(message = "Date of birth must not be empty")
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Class name must not be empty")
    @JsonProperty("class_name")
    private String className;
}

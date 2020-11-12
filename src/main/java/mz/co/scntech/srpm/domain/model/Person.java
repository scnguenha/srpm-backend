package mz.co.scntech.srpm.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Sidónio Goenha on 11/6/2020
 */
@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String surname;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    @Size(max = 9)
    private String gender;

    private String mobile;

    @Email
    private String email;
    private boolean confirmed;
    private boolean baptized;

    @Enumerated(EnumType.STRING)
    private Society society;
}

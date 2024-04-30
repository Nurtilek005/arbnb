package arbnb.entyti;

import arbnb.baseEntyti.RefactorId;
import arbnb.enume.FamilyStarus;
import arbnb.enume.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",sequenceName = "adress_seq",allocationSize = 1)
@ToString
public class Customer extends RefactorId {

    private String firstName;

    private String lastName;

    private String email;
@Column (name = "date_of_birth")
    private LocalDate dateOfBirth;

    private Gender gender;

    private String nationality;
@Column(name = "famaly_status")
    private FamilyStarus familyStarus;

    @ManyToOne
    private Rent_info rentInfos;

    public Customer(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender, String nationality, FamilyStarus familyStarus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.familyStarus = familyStarus;

    }
}

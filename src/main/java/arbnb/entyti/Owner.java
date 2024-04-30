package arbnb.entyti;

import arbnb.baseEntyti.RefactorId;
import arbnb.enume.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Owner")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",sequenceName = "adress_seq",allocationSize = 1)
@ToString
public class Owner extends RefactorId {
    private String firstName;

    private String lastName;

    private String email;
@Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private Gender gender;
    @ManyToOne
    private House houses;

    @OneToMany(mappedBy = "owner")
    private List<Rent_info>rentInfos;

    @ManyToMany
    private List<Agensy>agencies;



    public Owner(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender, House houses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.houses = houses;
    }

    public Owner(String firstName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }
}

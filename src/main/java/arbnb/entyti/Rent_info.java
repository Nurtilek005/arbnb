package arbnb.entyti;

import arbnb.baseEntyti.RefactorId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Rent_info")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",sequenceName = "adress_seq",allocationSize = 1)
@ToString
public class Rent_info extends RefactorId {

    private LocalDate checkin;

    private LocalDate checkout;

    @ManyToOne
    private Owner owner;

    @ManyToOne
    private Agensy agenciess;

    @OneToOne(mappedBy = "rentInfo")
    private House house;

    @OneToMany(mappedBy = "rentInfos")
    private List<Customer> costumer;
}

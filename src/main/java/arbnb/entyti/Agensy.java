package arbnb.entyti;

import arbnb.baseEntyti.RefactorId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Agensy")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen", sequenceName = "adress_seq", allocationSize = 1)
@ToString
public class Agensy extends RefactorId {
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;


    @ManyToMany(mappedBy = "agencies")
    private List<Owner> owners;

    @OneToMany(mappedBy = "agenciess")
    private List<Rent_info> rentInfo;

    @OneToOne
    private Address addres;
}

package arbnb.entyti;

import arbnb.baseEntyti.RefactorId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "Address")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",sequenceName = "adress_seq",allocationSize = 1)
@ToString
public class Address extends RefactorId {

    private String city;

    private String region;
    @Column (unique = true)
    private String street;
    @OneToOne(mappedBy="addres" )
    private Agensy agency;

    public Address(String city, String region, String street) {
        this.city = city;
        this.region = region;
        this.street = street;
    }
}

package arbnb.entyti;

import arbnb.baseEntyti.RefactorId;
import arbnb.enume.HouseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "House")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_id_gen",sequenceName = "adress_seq",allocationSize = 1)
@ToString
public class House extends RefactorId {
@Column(name = "hospital_type")
    private HouseType houseType;

    private BigDecimal price;

    private double reating;

    private String description;

    private int room;

    private boolean furnature;


    @OneToMany(mappedBy = "houses")
    private List<Owner> owner;

    @OneToOne
    private Address addres;

    @OneToOne
    private Rent_info rentInfo;



}

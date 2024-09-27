package kodlama.io.rentACar.Entites.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;
    @Column(name = "drivingLicenseNumber", unique = true)
    private String drivingLicenseNumber;
    @Column(name = "registrationDate")
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "rental")
    private List<Rental> rentals;
}

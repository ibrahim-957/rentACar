package kodlama.io.rentACar.Entites.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "paymentDate")
    private LocalDateTime paymentDate;
    @Column(name = "paymentMethod")
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}

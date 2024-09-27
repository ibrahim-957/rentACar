package kodlama.io.rentACar.Entites.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "invoiceNumber")
    private String invoiceNumber;
    @Column(name = "issueDate")
    private LocalDateTime issueDate;
    @Column(name = "totalAmount")
    private double totalAmount;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}

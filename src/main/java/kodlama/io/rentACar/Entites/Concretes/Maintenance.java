package kodlama.io.rentACar.Entites.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name="maintenances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Maintenance  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "maintenanceDate")
    private LocalDateTime maintenanceDate;
    @Column(name = "description")
    private String description;
    @Column(name = "cost")
    private double cost;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}

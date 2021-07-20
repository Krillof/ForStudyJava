package car_number_generator.car_number;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_number")
public class CarNumber {
    @Id
    @Column(name = "number")
    String number;


    public CarNumber(String number) {
        this.number = number;
    }

    public CarNumber() {
    }
}

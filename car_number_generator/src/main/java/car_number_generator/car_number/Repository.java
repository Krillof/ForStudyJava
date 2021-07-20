package car_number_generator.car_number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<CarNumber, String> {
    @Query("select count(a) from CarNumber a where a.number = :number")
    Integer getAlike(@Param("number") String number);
}

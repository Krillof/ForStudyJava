package car_number_generator.car_number;

import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    final private Repository repository;

    @Autowired
    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Integer getAlike(String number) {
        return repository.getAlike(number);
    }

    @Override
    public void addCarNumber(CarNumber carNumber) {
        repository.saveAndFlush(carNumber);
    }
}

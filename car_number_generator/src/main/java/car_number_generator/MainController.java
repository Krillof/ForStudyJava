package car_number_generator;

import car_number_generator.car_number.CarNumber;
import car_number_generator.car_number.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/number")
public class MainController {

    final private Service service;

    @Autowired
    public MainController(Service service) {
        this.service = service;
    }


    @GetMapping("/random")
    @ResponseBody
    public String random(Model model){
        String number;
        do number = NumberGenerator.getRandom();
        while (service.getAlike(number) != 0);
        service.addCarNumber(new CarNumber(number));
        model.addAttribute("number", number);
        return number;
    }

    @GetMapping("/next")
    @ResponseBody
    public String next(Model model){
        String number;
        do number = NumberGenerator.getNext();
        while (service.getAlike(number) != 0);
        service.addCarNumber(new CarNumber(number));
        model.addAttribute("number", number);
        return number;
    }

}

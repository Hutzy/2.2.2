package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {


        private final CarService carService;

        public CarController(CarService carService) {
                this.carService = carService;
        }

        @GetMapping("/cars")
        public String getCars(Model model, @RequestParam(required = false) Integer count) {
                List<Car> cars = (count != null && count < 5) ? carService.getCars(count) : carService.getAllCars();
                model.addAttribute("cars", cars);
                return "cars";
        }
}
//
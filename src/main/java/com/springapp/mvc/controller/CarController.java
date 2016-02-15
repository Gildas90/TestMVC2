package com.springapp.mvc.controller;

import com.springapp.mvc.validation.CarValidator;
import com.springapp.mvc.domain.Car;
import com.springapp.mvc.repository.CarRepository;
import com.springapp.mvc.validation.CarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

/**
 * Created by dn070290gsn on 23.06.2015.
 */
@Controller
public class CarController {
 private    CarRepository carRepository;
    private CarValidator carValidator;
    @Autowired


    public CarController (CarRepository carRepository,CarValidator carValidator){
        this.carRepository=carRepository;
        this.carValidator=carValidator;
    }
@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCars(Model model){
        List<Car> cars=this.carRepository.listAll();
        model.addAttribute("cars",cars);
        return "index";
    }

    @RequestMapping(value = "addcar", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addcar (Model model){
        model.addAttribute("car", new Car());
        return "addcar";
    }

    @RequestMapping(value = "addcar", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String addcar(@ModelAttribute("car") Car car, BindingResult bindingResult){
        this.carValidator.validate(car,bindingResult);
        if (bindingResult.hasErrors()){
             return "addcar";
        }
        this.carRepository.addCar(car);
        return "redirect:/";
    }

    @RequestMapping(value = "deletecar/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String deletecar(@PathVariable Integer id){
        this.carRepository.removeCar(id);
        return "redirect:/";
    }
}

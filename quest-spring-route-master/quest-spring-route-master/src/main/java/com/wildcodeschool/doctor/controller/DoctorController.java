package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/")
    @ResponseBody
    public Doctor doctor() {

        return null;
    }

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor showTitle(@PathVariable int number) {
        if (number == 13){
            return new Doctor( number,"Jodie Whittaker");
        }
        if (number<13){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Un statut 303");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation {number}");
    }
}

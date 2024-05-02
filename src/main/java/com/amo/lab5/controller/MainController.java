package com.amo.lab5.controller;

import com.amo.lab5.util.SlaeCalculation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String getMain(Model model) {

        int n = 4;

        double[][] a = {
                {1, -4, 0, -1},
                {1, 1, 2, 3},
                {2, 3, -1, -1},
                {1, 2, 3, -1}
        };

        double[] b = {6, -1, -1, 3};

        double[] x = SlaeCalculation.gaussianMethod(n, a, b);
        model.addAttribute("x", x);

        return "index";
    }
}

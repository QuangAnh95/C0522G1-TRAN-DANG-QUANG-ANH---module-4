package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String change(double number1, double number2, String opera) {
        double result =0;
        switch (opera){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if(number2 == 0){
                    return "not divisible by 0";
                }
                result = number1 / number2;
                break;
        }
        return String.valueOf(result);
    }
}

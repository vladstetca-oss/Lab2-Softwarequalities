package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

    @GetMapping("/")
    public String getCalculator(@RequestParam(name="op1", required=false, defaultValue="") String op1, 
                               Model model) {
        model.addAttribute("op1", op1);
        if (op1 == null || op1.isEmpty()) {
            model.addAttribute("focusFirst", true);
        } else {
            model.addAttribute("focusFirst", false);
        }
        return "calc";
    }
    
    @PostMapping("/")
    public String getResult(@RequestParam(name="op1", required=false, defaultValue="") String op1,
                           @RequestParam(name="oper", required=false, defaultValue="+") String oper,
                           @RequestParam(name="op2", required=false, defaultValue="") String op2,
                           Model model) {
        
        model.addAttribute("op1", op1);
        model.addAttribute("oper", oper);
        model.addAttribute("op2", op2);
        
        try {
            Binary binary1 = new Binary(op1);
            Binary binary2 = new Binary(op2);
            Binary result = null;
            
            if (oper.length() > 0) {
                char c = oper.charAt(0);
                
                if (c == '+') {
                    result = Binary.add(binary1, binary2);
                } else if (c == '*') {
                    result = Binary.multiply(binary1, binary2);
                } else if (c == '&') {
                    result = Binary.and(binary1, binary2);
                } else if (c == '|') {
                    result = Binary.or(binary1, binary2);
                } else {
                    return "error";
                }
            } else {
                return "error";
            }
            
            if (result != null) {
                model.addAttribute("res", result.getValue());
                return "result";
            } else {
                return "error";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}

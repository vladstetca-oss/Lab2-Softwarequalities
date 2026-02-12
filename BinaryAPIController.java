package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(@RequestParam(name="op1", required=true) String op1,
                     @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.add(b1, b2);
        return r.getValue();
    }
    
    @GetMapping("/or")
    public String or(@RequestParam(name="op1", required=true) String op1,
                    @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.or(b1, b2);
        return r.getValue();
    }
    
    @GetMapping("/and")
    public String and(@RequestParam(name="op1", required=true) String op1,
                     @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.and(b1, b2);
        return r.getValue();
    }
    
    @GetMapping("/mul")
    public String mul(@RequestParam(name="op1", required=true) String op1,
                     @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.multiply(b1, b2);
        return r.getValue();
    }
    
    @GetMapping("/addJ")
    public BinResult addJ(@RequestParam(name="op1", required=true) String op1,
                         @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.add(b1, b2);
        return new BinResult(b1.getValue(), b2.getValue(), r.getValue(), '+');
    }
    
    @GetMapping("/orJ")
    public BinResult orJ(@RequestParam(name="op1", required=true) String op1,
                        @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.or(b1, b2);
        return new BinResult(b1.getValue(), b2.getValue(), r.getValue(), '|');
    }
    
    @GetMapping("/andJ")
    public BinResult andJ(@RequestParam(name="op1", required=true) String op1,
                         @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.and(b1, b2);
        return new BinResult(b1.getValue(), b2.getValue(), r.getValue(), '&');
    }
    
    @GetMapping("/mulJ")
    public BinResult mulJ(@RequestParam(name="op1", required=true) String op1,
                         @RequestParam(name="op2", required=true) String op2) {
        Binary b1 = new Binary(op1);
        Binary b2 = new Binary(op2);
        Binary r = Binary.multiply(b1, b2);
        return new BinResult(b1.getValue(), b2.getValue(), r.getValue(), '*');
    }
}

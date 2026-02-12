package com.ontariotechu.sofe3980U;

public class Binary {
    private String value;
    
    public Binary(String value) {

	        if (value == null || value.isEmpty()) {
            this.value = "0";
            return;
        }
        
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '0' || c == '1') {
                filtered.append(c);
            }
        }
        
        if (filtered.length() == 0) {
            this.value = "0";
            return;
        }
        
        String binaryStr = filtered.toString();
        int firstOne = binaryStr.indexOf('1');
        if (firstOne == -1) {
            this.value = "0"; 
        } else {
            this.value = binaryStr.substring(firstOne);
        }
    }
    
    public String getValue() {
        return value;
    }
    
    private int toDecimal() {
        int result = 0;
        int power = 1; // 2^0
        
        for (int i = value.length() - 1; i >= 0; i--) {
            if (value.charAt(i) == '1') {
                result += power;
            }
            power *= 2;
        }
        return result;
    }
    
    private static String fromDecimal(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal = decimal / 2;
        }
        return binary.toString();
    }
    
    public Binary add(Binary other) {
        int num1 = this.toDecimal();
        int num2 = other.toDecimal();
        int sum = num1 + num2;
        return new Binary(fromDecimal(sum));
    }
    
    public Binary or(Binary other) {
        int num1 = this.toDecimal();
        int num2 = other.toDecimal();
        int result = num1 | num2;
        return new Binary(fromDecimal(result));
    }
    
    public Binary and(Binary other) {
        int num1 = this.toDecimal();
        int num2 = other.toDecimal();
        int result = num1 & num2;
        return new Binary(fromDecimal(result));
    }
    
    public Binary multiply(Binary other) {
        int num1 = this.toDecimal();
        int num2 = other.toDecimal();
        int product = num1 * num2;
        return new Binary(fromDecimal(product));
    }
}

package Calc.Operations;

import Calc.Methods.Methods_and_Fields;

import javax.jws.soap.SOAPBinding;
import java.io.FileOutputStream;
import java.lang.reflect.AnnotatedArrayType;
import java.security.Key;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MathOperations implements Methods_and_Fields {

    static String type;
    Result result = new Result();
    private static final  SignCheck signCheck = new SignCheck();
    static {

        NUMBERS.put("1", "I");
        NUMBERS.put("2", "II");
        NUMBERS.put("3", "III");
        NUMBERS.put("4", "IV");
        NUMBERS.put("5", "V");
        NUMBERS.put("6", "VI");
        NUMBERS.put("7", "VII");
        NUMBERS.put("8", "VIII");
        NUMBERS.put("9", "IX");
        NUMBERS.put("10", "X");

        ANSWERS.put("1", "X");
        ANSWERS.put("2", "XX");
        ANSWERS.put("3", "XXX");
        ANSWERS.put("4", "XL");
        ANSWERS.put("5", "L");
        ANSWERS.put("6", "LX");
        ANSWERS.put("7", "LXX");
        ANSWERS.put("8", "LXXX");
        ANSWERS.put("9", "XC");
        ANSWERS.put("100", "C");


        //System.out.println(NUMBERS);

    }

    public String mathOperation (String inData) throws Exception {
        int num = validationOfTheEnteredData(inData);
        if(type.equals("Value")) return searchRomeNum(Integer.toString(num));
        else return Integer.toString(num);
    }

    private int validationOfTheEnteredData(String inData) throws Exception {
        return checkSignExpression(Validation.validation(inData), inData);
    }

    private int checkSignExpression(int[] nums, String s) throws Exception {
        return signCheck.checkSignExpression(nums, s);
    }

    private String searchRomeNum(String s){
        String out = "";
        /*System.out.print(s.toCharArray()[0]);
        System.out.println(s.toCharArray()[1]);
        System.out.println(s.toCharArray().length);*/


        for (Map.Entry<String, String> map: NUMBERS.entrySet()) {
            if (s.equals(map.getKey())) return map.getValue();
        }
        if(s.toCharArray().length == 2) {
            for (Map.Entry<String, String> ans: ANSWERS.entrySet()){
                if(ans.getKey().equals((s.substring(0, 1)))){
                    out = ans.getValue();
                    break;
                }
            }
            for (Map.Entry<String, String> num: NUMBERS.entrySet()){
                if(num.getKey().equals(s.substring(1))){
                    out += num.getValue();
                    break;
                }
            }
            return out;
        }
        else if (s.toCharArray().length == 3) return ANSWERS.get("100");

        return "";
    }
    }

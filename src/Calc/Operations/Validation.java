package Calc.Operations;

import Calc.Methods.CustomException;
import Calc.Methods.Methods_and_Fields;

import java.util.Map;

class Validation extends MathOperations{



    private static int count = 0;
    static int[] validation(String inData) throws Exception {
        String num2 = "";
        String num1 = (inData.split(" "))[0];
        //System.out.println(num1);

        for (Map.Entry<String, String> e: NUMBERS.entrySet()){
            if(num1.equals(e.getKey())){
                count += 1;
                type = "Key";
                break;
            }
            else if(num1.equals(e.getValue())){
                count += 1;
                type = "Value";
                num1 = e.getKey();
                break;
            }
        }

        if (count == 0) CustomException.getException();

        if (type.equals("Key")) num2 = keyStrBuild(inData.split(" ")[2]);
        if (type.equals("Value")) num2 = valueStrBuild(inData.split(" ")[2]);

        if(count < 2) CustomException.getException();
        if(inData.split(" ").length > 3) CustomException.getException();
        if(inData.toCharArray()[inData.toCharArray().length - 1] == ' ') CustomException.getException();

        count = 0;

        return new int [] {Integer.parseInt(num1), Integer.parseInt(num2)};
    }


    private static String keyStrBuild (String str){
        for (Map.Entry<String, String> e: NUMBERS.entrySet()){
            if (str.equals(e.getKey())){
                count += 1;
                return e.getKey();
            }
        }
        return "";
    }


    private static String valueStrBuild (String str){
        for (Map.Entry<String, String> e: NUMBERS.entrySet()){
            if (str.equals(e.getValue())){
                count += 1;
                return e.getKey();
            }
        }
        return "";
    }

}

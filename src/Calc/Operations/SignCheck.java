package Calc.Operations;

import Calc.Methods.CustomException;

import java.util.Map;

public class SignCheck extends MathOperations {

    int checkSignExpression(int[] nums, String s) throws Exception {
        String str = s.split(" ")[1];
        switch (str) {
            case "+":
                return result.incrementNums(nums[0], nums[1]);
            case "-":
                return result.decrementNums(nums[0], nums[1]);
            case "*":
                return result.multipleNums(nums[0], nums[1]);
            case "/":
                return result.divisionNums(nums[0], nums[1]);
            default:
                CustomException.getException();
                return 0;
        }
    }
}

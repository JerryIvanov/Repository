package Calc;



import Calc.Methods.CustomException;
import Calc.Operations.MathOperations;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        String inPut;
        MathOperations mathOperations = null;

        while (true){
            if(reader == null) reader = new BufferedReader(new InputStreamReader(System.in));
            if(mathOperations == null) mathOperations = new MathOperations();

            inPut = reader.readLine();
            if(!inPut.isEmpty())
            System.out.println(mathOperations.mathOperation(inPut));
            else CustomException.getException();

        }

    }
}

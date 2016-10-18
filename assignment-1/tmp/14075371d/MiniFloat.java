
import java.util.Scanner;

public class MiniFloat {

    public static void main(String[] args){
        //printIntegralMiniFloats();
        Scanner scanner = new Scanner (System.in);
        System.out.print("Task 1 : Enter a number : ");
        String num = scanner.next();
        float ans;
        ans = miniFloatFromString(num);

        System.out.println("The value is " + ans);
        System.out.println("Task 2:");
        printIntegralMiniFloats();

    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
            float ans=0,mantissa = 0;
            int num=0,pos=3;

            for(int i=1;i<5;i++){
                if(bitSequence.toCharArray()[i]=='1'){
                    num = (int) (num + Math.pow(2, pos));
                }
                pos--;
            }
            pos=-1;
            for(int i=5;i<8;i++){
                if(bitSequence.toCharArray()[i]=='1'){
                    mantissa = (float) (mantissa + Math.pow(2, pos));
                }
                pos--;
            }
            mantissa=mantissa+1;
            //int exponent=1<<num;
            //ans=(mantissa*exponent);
            ans = (float) (mantissa * Math.pow(2, num));
            if(bitSequence.toCharArray()[0] == '1'){
                ans = ans * -1;
            }
            return ans;
        }

    private static void printIntegralMiniFloats(){

        // Task 2: print all the miniFloat values that are integer;
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i=0;i<256;i++){
            if(miniFloatFromString(bitSequences[i]) % 1 == 0){
                System.out.println(bitSequences[i] + " == " + miniFloatFromString(bitSequences[i]));
                count++;
            }
        }
        System.out.println("Total number of integral miniFloat values: " + count);


    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences(){
        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for(int i = 0; i < nbrValues; i++){

            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;

}

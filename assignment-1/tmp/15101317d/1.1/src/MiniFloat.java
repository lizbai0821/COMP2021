import java.lang.*;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        float exp = 0, ans= 0;
        float mantissa = 1;
        float two = 2;
        //positive
        if(bitSequence.charAt(0)=='0'){
            if(bitSequence.charAt(1)=='1'){
                exp -= 8;
            }
            if(bitSequence.charAt(2)=='1'){
                exp += 4;
            }
            if(bitSequence.charAt(3)=='1'){
                exp += 2;
            }
            if(bitSequence.charAt(4)=='1') {
                exp += 1;
            }
            if(bitSequence.charAt(5)=='1'){
                mantissa += 0.5;
            }
            if(bitSequence.charAt(6)=='1'){
                mantissa += 0.25;
            }
            if(bitSequence.charAt(7)=='1'){
                mantissa += 0.125;
            }

            ans += Math.pow(two,exp) * mantissa;


        }
        //negative
        else if(bitSequence.charAt(0)=='1'){
            if(bitSequence.charAt(1)=='1'){
                exp -= 8;
            }
            if(bitSequence.charAt(2)=='1'){
                exp += 4;
            }
            if(bitSequence.charAt(3)=='1'){
                exp += 2;
            }
            if(bitSequence.charAt(4)=='1'){
                exp += 1;
            }

            if(bitSequence.charAt(5)=='1'){
                mantissa += 0.5;
            }
            if(bitSequence.charAt(6)=='1'){
                mantissa += 0.25;
            }
            if(bitSequence.charAt(7)=='1'){
                mantissa += 0.125;
            }


            ans -= Math.pow(two,exp) * mantissa;


        }

        return ans;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        String text = "";
        int counter = 0;
        // Task 2: print all the miniFloat values that are integer;
        for(int i = 0; i < 256; i++) {

            text = (String)bitSequences[i];
            float a = miniFloatFromString(text);
            if(a == (int)a){
                System.out.println(text  + "\t == \t" + (int)a);

                counter += 1;
            }
            text = "";
        }


        System.out.printf("Total number of integral miniFloat values: %d" ,counter);

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

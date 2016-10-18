import java.util.Arrays;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign , exponent;
        float mantissa , value;
        sign = bitSequence.charAt(0)=='0'?1:-1;
        exponent = Integer.parseInt(bitSequence.substring(2,5), 2);
		if(bitSequence.charAt(1)=='1'){
			exponent=exponent-8;
		}
        mantissa = 1;
        mantissa += bitSequence.charAt(5)=='0'?0:0.5;
        mantissa += bitSequence.charAt(6)=='0'?0:0.25;
        mantissa += bitSequence.charAt(7)=='0'?0:0.125;

        value = sign * mantissa * (float)Math.pow(2, exponent);
        return value;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        // Task 2: print all the miniFloat values that are integer;
        for(int i = 0; i<bitSequences.length; i++){
            float value = miniFloatFromString(bitSequences[i]);
            if(value==(int)value) {
                System.out.printf("%s == %d\n", bitSequences[i], (int) value);
                count++;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d",count);
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

import java.util.Objects;

public class MiniFloat {

    public static void main(String[] args){
        System.out.println("The value is "+miniFloatFromString("00100110"));
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String mantissa = bitSequence.substring(5,8);;
        float A = (float) (Integer.parseInt(mantissa,2)*Math.pow(2,-3)+1);
        char sign = bitSequence.charAt(0);
        String exponent = bitSequence.substring(1,5);
        int B = Integer.parseInt(exponent,2);
        float value = (float) (A*Math.pow(2,B));
        if (sign == '1'){
            value = value*(-1);
        }
        return value;
    }

    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;

        for (int i = 0; i < bitSequences.length; i++) {
            String mantissa = bitSequences[i].substring(5, 8);
            float A;
            int B;
            float value;
            A = (float) (Integer.parseInt(mantissa, 2) * Math.pow(2, -3) + 1);
            String exponent = bitSequences[i].substring(1, 5);
            B = Integer.parseInt(exponent, 2);
            value = (float) (A * Math.pow(2, B));
            if (value - (int)value != 0) {
                continue;
            } else {
                char sign = bitSequences[i].charAt(0);
                if (sign == '1') {
                    value = value * (-1);
                }
                System.out.println(bitSequences[i] + " == " + (int)value);
            }
        }
    }

    /*
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

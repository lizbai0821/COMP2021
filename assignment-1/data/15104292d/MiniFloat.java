import java.util.Arrays;
public class MiniFloat {

    public static void main(String[] args){printIntegralMiniFloats();}

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float value;
        String sign_str = bitSequence.substring(0,1);
        String expo_str = bitSequence.substring(1,5);
        String mantissa_str = bitSequence.substring(5);

        int sign = Integer.parseInt(sign_str);

        char[] expo_c = expo_str.toCharArray();
        int expo_i[] = new int[4];
        int expo = 0;
        for(int i = 0; i < 4; i++)
        {
            if(expo_c[0] == '1') {
                if (expo_c[i] == '0')
                    expo_i[i] = 1;
                else
                    expo_i[i] = 0;
            }
            else
            {
                if (expo_c[i] == '0')
                    expo_i[i] = 0;
                else
                    expo_i[i] = 1;
            }
            expo += expo_i[i] * Math.pow(2 ,3-i);
        }
        if(expo_c[0] == '1')
        {
            expo++;
            expo = -expo;
        }


        float mantissa = 1;
        mantissa += Integer.valueOf(mantissa_str, 2) / (float)8;
        value = mantissa * (float)Math.pow(2, expo);
        if(sign == 0)
            return value;
        else
            return -value;

    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;

        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);
        int count = 0;
        for(int i = 0; i < nbrValues; i++)
        {
            float value = miniFloatFromString(bitSequences[i]);
            if (value == (int)value) {
                System.out.println(bitSequences[i] + " == " + (int)value);
                count++;
            }
        }
        System.out.println("Total number of integral miniFloat values: < " + count + " >");
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

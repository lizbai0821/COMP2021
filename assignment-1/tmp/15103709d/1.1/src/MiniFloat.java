public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int sign, ex = 0;
        double mag;
        char [] s = bitSequence.toCharArray();

        //judge the number is a positive number or a positive number
        if (s[0] == '0')
            sign = 1;
        else
            sign = -1;

        //get the exponent
        if (s[1] == '0')
            ex = Character.getNumericValue(s[2]) * 4 + Character.getNumericValue(s[3]) * 2 + Character.getNumericValue(s[4]);
        else
            switch(bitSequence.substring(2,5)){
                case "111": ex = -1;
                    break;
                case "110": ex = -2;
                    break;
                case "101": ex = -3;
                    break;
                case "100": ex = -4;
                    break;
                case "011": ex = -5;
                    break;
                case "010": ex = -6;
                    break;
                case "001": ex = -7;
                    break;
                case "000": ex = -8;
                    break;
            }

        //get the magnitude
        mag = Character.getNumericValue(s[5]) * 0.5 + Character.getNumericValue(s[6]) * 0.25 + Character.getNumericValue(s[7]) * 0.125;

        //get value0
        return (float)(sign * (1 + mag) * Math.pow(2, ex));
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int n = 0;
        for(String m: bitSequences){
            if(miniFloatFromString(m) - (int)miniFloatFromString(m) == 0){
                System.out.println(m + "==" + (int)(miniFloatFromString(m)));
                n++;
            }
        }

        System.out.println("Total number of integral miniFloat values:" + n);

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

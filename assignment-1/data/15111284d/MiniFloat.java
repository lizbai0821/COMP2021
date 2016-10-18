import java.util.Formatter;

public class MiniFloat {

    public static void main(String[] args){
        String miniFloatStr = "10100110";
        System.out.println(miniFloatStr+" == "+miniFloatFromString(miniFloatStr)+"\n\n");

        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";
        System.out.println("Task 1:\n");

        String miniFloat = bitSequence;
        String signStr, exponentStr, significandStr;
        int exponentInt;
        float wholeValueFloat = 0;

        // Sign
        signStr = miniFloat.substring(0, Math.min(miniFloat.length(), 1));

        // Exponent
        exponentStr = miniFloat.substring(1, Math.min(miniFloat.length(), 5));
        exponentInt = Integer.parseInt(exponentStr, 2);

        // Significand
        float significandFloat = 1;
        int count = 3;
        for (int j = 1; j < 4; j++){
            significandStr = miniFloat.substring(Math.max(miniFloat.length() - count, 0));

            if (significandStr.indexOf('1') == 0){
                significandFloat += Math.pow(2, (j*(-1)));
            }
            count--;
        }

        // Whole Value

        if (signStr.indexOf('0') == 0){
            wholeValueFloat = (float) ((Math.pow(2, exponentInt)) * (significandFloat));
        }
        else if (signStr.indexOf('1') == 0){
            wholeValueFloat = (float) (((Math.pow(2, exponentInt)) * (significandFloat)) * (-1));
        }

        return wholeValueFloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        String signStr, exponentStr, significandStr;
        int exponentInt;
        float wholeValueFloat;
        int wholeValueInt;
        int countIntMiniFloats = 0;

        // Task 2: print all the miniFloat values that are integer;
        System.out.println("Task 2:\n");

        for (int i = 0; i < bitSequences.length; i++){

            // Sign
            signStr = bitSequences[i].substring(0, Math.min(bitSequences[i].length(), 1));

            // Exponent
            exponentStr = bitSequences[i].substring(1, Math.min(bitSequences[i].length(), 5));
            exponentInt = Integer.parseInt(exponentStr, 2);

            // Significand
            float significandFloat = 1;
            int count = 3;
            for (int j = 1; j < 4; j++){
                significandStr = bitSequences[i].substring(Math.max(bitSequences[i].length() - count, 0));

                if (significandStr.indexOf('1') == 0){
                    significandFloat += Math.pow(2, (j*(-1)));
                }
                count--;
            }

            // Whole Value
            wholeValueFloat = (float) ((Math.pow(2, exponentInt)) * (significandFloat));

            if (wholeValueFloat % 1 == 0){
                if (signStr.indexOf('0') == 0){
                    wholeValueInt = (int)wholeValueFloat;
                    System.out.printf("%s == %d\n", bitSequences[i], wholeValueInt);
                }
                else if (signStr.indexOf('1') == 0){
                    wholeValueInt = (int)wholeValueFloat * (-1);
                    System.out.printf("%s == %d\n", bitSequences[i], wholeValueInt);
                }
                countIntMiniFloats++;
            }
        }

        System.out.println("\nTotal number of integral miniFloat values: "+countIntMiniFloats);

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

import javax.sound.midi.SysexMessage;

public class MiniFloat {

    public static void main(String[] args) {
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence) {
        // Task1: compute the miniFloat value from "bitSequence";

        char[] chrBitSeq = bitSequence.toCharArray();
        int exponent = 0, arrIndex = 0;
        double mantissa = 0.0;
        int[] arrSignBit = new int[SIGNBIT_SIZE], arrExponent = new int[EXPONENT_SIZE], arrMantissa = new int[MANTISSA_SIZE];
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < chrBitSeq.length; i++) {
            //Get signBit
            if (i == SIGNBIT_SIZE-1) {
                arrSignBit[i] = Integer.parseInt(chrBitSeq[i] + "");
            } else if (i <= EXPONENT_SIZE) {
                arrExponent[arrIndex] = Integer.parseInt(chrBitSeq[i] + "");
                arrIndex++;
            } else {
                if (i == EXPONENT_SIZE+1) arrIndex = 0;
                arrMantissa[arrIndex] = Integer.parseInt(chrBitSeq[i] + "");
                arrIndex++;
            }
        }
        //Calculate exponent _Not sure method_ convert directly
        for (int digit : arrExponent) buffer.append(String.valueOf(digit));
        exponent = Integer.parseInt(buffer.toString(), 2);
        buffer.setLength(0);

        //Calculate the mantissa
        for (int i = 0; i < arrMantissa.length; i++) {
            if (arrMantissa[i] == 1) mantissa += Math.pow(2.0, (i + 1) * -1);
        }

        //Calculate the sum
        if (arrSignBit[0] == 0) return (float) ((1 + mantissa) * Math.pow(2, exponent));
        else return (float) ((1 + mantissa) * Math.pow(2, exponent)) * -1;
    }

    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        int count = 0;
        for (String data : bitSequences) {
            float miniFloat = miniFloatFromString(data);
            if ((int) miniFloat == miniFloat) {
                System.out.println(data + " == " + (int) miniFloat);
                count++;
            }
        }
        System.out.println("Total number of integral miniFloat values: " + count);
    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMiniFloatBitSequences() {
        int nbrValues = (int) Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];
        for (int i = 0; i < nbrValues; i++) {
            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;
    }

    private static int MINI_FLOAT_SIZE = 8;
    private static int SIGNBIT_SIZE = 1;
    private static int EXPONENT_SIZE = 4;
    private static int MANTISSA_SIZE = 3;

}

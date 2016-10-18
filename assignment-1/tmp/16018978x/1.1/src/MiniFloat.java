public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    /**
     * Converts a string sequence with binary representation to the float number.
     * Sequence is the floating point type, where:
     * 1 bit for the sign
     * 4 bits for the exponent (int two's complement)
     * 3 bits for the mantissa
     * @param bitSequence - sequence of bits to convert
     * @return float representation of the number
     */
    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        String signCharacter = bitSequence.substring(0, 1);
        int sign = (Integer.parseInt(signCharacter) == 0)? 1 : - 1;
        String exponentPart = bitSequence.substring(1, 5);
        double exponentConverted = convertFromTwosComplement4Bits(exponentPart);
        String mantissaPart = bitSequence.substring(5, 8);
        double mantissaWithImplicitBitConverted = Integer.parseInt("1" + mantissaPart, 2) * Math.pow(2.0, - 3);
        return (float)mantissaWithImplicitBitConverted * (float)Math.pow(2.0, exponentConverted) * sign;
    }

    /**
     * Converts a 4-bits two's complement sequence to the number it represents
     * @param sequence - bit sequence
     * @return converted number in integer
     */
    private static int convertFromTwosComplement4Bits(String sequence) {
        if (sequence.substring(0, 1).equals("1")) {
            char[] charSequence = sequence.toCharArray();
            for (int i = 0; i < charSequence.length; i++) {
                charSequence[i] = (charSequence[i] == '0')? '1' : '0';
            }
            sequence = new String(charSequence);
            return (Integer.parseInt(sequence, 2) + 1) * -1;
        } else {
            return Integer.parseInt(sequence, 2);
        }
    }

    /**
     * Prints integers from all possible numbers of miniFloat type
     */
    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int integersCounter = 0;
        for (String bitSequence : bitSequences) {
            float sequenceConverted = miniFloatFromString(bitSequence);
            if(sequenceConverted % 1 == 0) {
                System.out.printf("%s == %d", bitSequence, (int)sequenceConverted);
                integersCounter++;
                System.out.println();
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", integersCounter);
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

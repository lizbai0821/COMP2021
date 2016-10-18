import javax.swing.plaf.synth.SynthDesktopIconUI;

public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();

    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int postive =1;
        if(bitSequence.charAt(0)=='0') {
            postive = 1;
        }else {
            postive = -1;
        }
        String exponent = bitSequence.substring(1,5);
        int realExp=0;
        if(bitSequence.charAt(1)=='1')
            realExp = ((int)Math.pow(2,4) - Integer.parseInt(exponent,2))*-1;
        else
            realExp = Integer.parseInt(exponent,2);
        float Mantissa = 0;
        if(bitSequence.charAt(5)=='1')
            Mantissa += 0.5;
        if(bitSequence.charAt(6)=='1')
            Mantissa += 0.25;
        if(bitSequence.charAt(7)=='1')
            Mantissa += 0.125;
        float significand = 1+ Mantissa;
        float miniFloat = postive*significand * (float)Math.pow(2,realExp);
        return miniFloat;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i = 0;i<bitSequences.length;i++){
            float miniFloat= miniFloatFromString(bitSequences[i]);
            if(miniFloat==Math.ceil(miniFloat)) {
                System.out.printf("%s == %.0f\n", bitSequences[i], miniFloat);
                count++;
            }
        }
        // Task 2: print all the miniFloat values that are integer;
        System.out.println("Total number of integral miniFloat values: "+count);
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

// Tsang King Ting 15066186d
public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        float mini = 0, p3 = 1;
        int p1 = 1, p2 = 0;
        if (bitSequence.charAt(0) == '1') p1 = -1;
        if (bitSequence.charAt(2) == '1') p2 += 4;
        if (bitSequence.charAt(3) == '1') p2 += 2;
        if (bitSequence.charAt(4) == '1') p2 += 1;
        if (bitSequence.charAt(5) == '1') p3 += 0.5;
        if (bitSequence.charAt(6) == '1') p3 += 0.25;
        if (bitSequence.charAt(7) == '1') p3 += 0.125;
        if (bitSequence.charAt(1) == '1') p2 -= 8;
        mini = p1 * (float)Math.pow(2,p2) * p3;
        return mini;
        
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int cnt = 0;
        // Task 2: print all the miniFloat values that are integer;
        for (int i = 0; i<bitSequences.length; i++){
            double x = miniFloatFromString(bitSequences[i]);
            System.out.println(bitSequences[i]+" == "+x);
            if (Math.ceil(x) == x) cnt++;
        }
        System.out.printf("Total number of integral miniFloat values: %d\n",cnt);

    }


    // Get all valid bit sequences for miniFloat values.
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

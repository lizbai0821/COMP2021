public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        int a=1;
        int b=0;
        double c=0;
        if (bitSequence.charAt(0)=='1'){
            a=a*-1;
        }
        if (bitSequence.charAt(1)=='1'){
            b=b+8;
        }
        if (bitSequence.charAt(2)=='1'){
            b=b+4;
        }
        if (bitSequence.charAt(3)=='1'){
            b=b+2;
        }
        if (bitSequence.charAt(4)=='1'){
            b=b+1;
        }
        if (bitSequence.charAt(5)=='1'){
            c=c+0.5;
        }
        if (bitSequence.charAt(6)=='1'){
            c=c+0.25;
        }
        if (bitSequence.charAt(7)=='1'){
            c=c+0.125;
        }

        float decimal=(float)(a*(Math.pow(2,b))*(1+c));
        return decimal;
    }

    private static void printIntegralMiniFloats(){
        int accum=0;
        String[] bitSequences = getValidMiniFloatBitSequences();
        int n=bitSequences.length;
        for (int i=0;i<n;i++) {
            float g = miniFloatFromString(bitSequences[i]);
            if (g == (int) g) {
                System.out.printf("%s == %.0f%n", bitSequences[i], g);
                accum=accum+1;
            }
        }
        System.out.printf("Total number of integral miniFloat values: %d", accum);
    }

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

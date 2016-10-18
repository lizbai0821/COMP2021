// Create by Yan Haozhe 2016/9/28
// All Right Reserved


public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";

        int divs,divx,sign,pow,Counter;
        divs=divx=pow=Counter=0;


        sign=bitSequence.charAt(0)-'0';

        for(int i=1;i<=4;i++)
        {
            pow=pow*2+bitSequence.charAt(i)-'0';
        }

        if(bitSequence.charAt(1)=='1')pow=pow-16;

        for(int i=5;i<=7;i++)
        {
            divs=divs*2+bitSequence.charAt(i)-'0';
        }

        divx=8;

        if(pow>=0)
        {
            for(int i=1;i<=pow;i++)
                divs*=2;
        }

        else
        {
            for(int i=pow;i<=-1;i++)
            {
                divx*=2;
            }
        }


        divs=divs*-1;
        return (float)divs/divx;


    }

    private static void printIntegralMiniFloats() {
        String[] bitSequences = getValidMiniFloatBitSequences();

        int Counter = 0;

        for (int p = 0; p < bitSequences.length; p++) {
            String bitSequence = bitSequences[p];
            int divs, divx, sign, pow;
            pow = 0;
            divs = divx = 1;


            sign = bitSequence.charAt(0) - '0';

            for (int i = 1; i <= 4; i++) {
                pow = pow * 2 + bitSequence.charAt(i) - '0';
            }

            if (bitSequence.charAt(1) == '1') pow = pow - 16;

            for (int i = 5; i <= 7; i++) {
                divs = divs * 2 + bitSequence.charAt(i) - '0';
            }

            divx = 8;

            if (pow >= 0) {
                for (int i = 1; i <= pow; i++)
                    divs *= 2;
            } else {
                for (int i = pow; i <= -1; i++) {
                    divx *= 2;
                }
            }

            if (sign > 0) divs = divs * -1;

            if (divs % divx == 0) {
                System.out.println(bitSequence + " == " + divs / divx);
                Counter++;
            }
        }

        System.out.println("Total number of integral miniFloat values: " + Counter);

        // Task 2: print all the miniFloat values that are integer;

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

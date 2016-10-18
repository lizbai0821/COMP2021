public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();          // print
    }

    private static float miniFloatFromString(String bitSequences){   // return miniFloat value here
        // Task1: compute the miniFloat value from "bitSequence";
        float items = 0;
        for(int i = 0; i < bitSequences.length(); i++) {

            double total = 0;

            String n = bitSequences.substring(1, 2);
            double exp1 = 0;
            int fool = Integer.parseInt(n);
            if(fool == 1)
                exp1 = fool * Math.pow(2, fool*-1);

            String n1 = bitSequences.substring(2, 5);
            int foo1 = Integer.parseInt(n1, 2);
            double exp = Math.pow(2, foo1);

            String n2 = bitSequences.substring(5, 8);
            int[][] sb = new int[256][3];
            double sig = 1;
            for(int j = 0; j < n2.length(); j++){
                int c = n2.charAt(j)-'0';
                sb[i][j] = c;
                if(j == 0)
                    sig += sb[i][j] * Math.pow(2, -1);
                else if(j == 1)
                    sig += sb[i][j] * Math.pow(2, -2);
                else if(j == 2)
                    sig += sb[i][j] * Math.pow(2, -3);

            }
            total = (exp1+exp) * sig;
            items = (float)total;




        }
        return items;
    }

    private static void printIntegralMiniFloats(){                  // handle here
        String[] bitSequences = getValidMiniFloatBitSequences();
        float item = 0;
        float[] A = new float[256];
        for(int i = 0; i < bitSequences.length; i++) {
            item = miniFloatFromString(bitSequences[i]);
            String n = bitSequences[i].substring(0, 1);
            int foo = Integer.parseInt(n);
            if (foo == 1)
                A[i] = -1f * item;
            else if (foo == 0)
                A[i] = item;
        }
        long count = 0;
        for(int i = 0; i < A.length; i++) {

            if(A[i] == Math.ceil(A[i]) || A[i] == Math.floor(A[i])) {
                System.out.println(bitSequences[i] + " == " + (int) A[i]);
                count++;
            }


        }
        System.out.println("Total number of integral miniFloat values: " + count);

        // Task 2: print all the miniFloat values that are integer;

    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static int MINI_FLOAT_SIZE = 8;

    private static String[] getValidMiniFloatBitSequences(){

        int nbrValues = (int)Math.pow(2, MINI_FLOAT_SIZE);

        String[] result = new String[nbrValues];    // result with 2^8 = 256 combination
        // Integer.SIZE = 32
        for(int i = 0; i < nbrValues; i++){
            String full = String.format("%" + Integer.SIZE + "s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            result[i] = full.substring(Integer.SIZE - MINI_FLOAT_SIZE, Integer.SIZE);
        }
        return result;

    }

}

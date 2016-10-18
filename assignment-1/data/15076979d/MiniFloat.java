import java.util.Scanner;

public class MiniFloat {

    public static void main(String[] args){

        /*System.out.println("Enter 8 bits binary number: ");
        Scanner input = new Scanner(System.in);
        String str = input.next();*/

        printIntegralMiniFloats();

    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
        int[] arr = new int[8];
        int a=0,b=0;
        float c=0;
        for (int i=0;i<8;i++){
            arr[i]=  Character.getNumericValue(bitSequence.charAt(i));

        }
        if (arr[0] == 0){
            a=1;
        }
        else{
            a=-1;
        }

        b=(arr[2]*2*2+arr[3]*2+arr[4]*1);
        if(arr[1]==1){
            b=b-(2*2*2);
        }

        c=(1+(float)arr[5]/2+(float)arr[6]/(2*2)+(float)arr[7]/(2*2*2));

        c=c*a;



        return (float) (c*Math.pow(2,b));
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();

        // Task 2: print all the miniFloat values that are integer;
        for (int i = 0 ; i < bitSequences.length ; i++){

            System.out.printf("%s == %f\n",bitSequences[i],miniFloatFromString(bitSequences[i]));
        }
        System.out.println("Total number of integral minFloat values: " +bitSequences.length);

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

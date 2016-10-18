/**
 * Created by lijuan on 16/9/28.
 */
public class miniFloat {
    public static void main(String[] args){
        printIntegerMiniFloats();

    }

    public static float miniFloatFromString(String a){
        int[] temp = new int[8];
        for(int i = 0; i < a.length() ; i++ ){
            temp[i] =  (int)(a.charAt(i)) - 48;
        }

        float mantissa, expoent;

        if(temp[1] == 0){
            expoent = temp[2] * 4 + temp[3] * 2 + temp[4] ;
        }
        else
            expoent = -(transfer(temp[2]) * 4 + transfer(temp[3]) * 2 + transfer(temp[4])  + 1);

        mantissa = 1 + (float)temp[5] / 2 + (float)temp[6] / 4 + (float)temp[7] / 8 ;



        if(temp[0] == 0)
            return (float) (mantissa * Math.pow(2,expoent));
        else
            return -((float) (mantissa * Math.pow(2,expoent)));

    }

    public static int transfer(int n){
        if (n == 0)
                return 1;
        else
            return 0;
    }

    public static String[] getValidMiniFloatBitSequences(){
        String[] a = new String[256];

        for(int i = 0; i < 256 ; i++){
            String temp = "";

            int value = i;
            while(value > 0){
                int t = value % 2;
                temp = String.valueOf(t) + temp;
                value /= 2;
            }

            while(temp.length() < 8){
                temp = "0" + temp;
            }

            a[i] = temp;

        }

        return a;

    }

    public static void printIntegerMiniFloats(){
        String[] list = getValidMiniFloatBitSequences();
        int counter = 0;
        for(int i = 0; i < list.length; i ++){
            float value = miniFloatFromString(list[i]);
            if(value == (int)value ){
                System.out.printf("%s == %d",list[i],(int)value);
                System.out.println();
                counter ++;
            }

        }

        System.out.printf("Total number of integral miniFloat value: %d",counter);
    }






}

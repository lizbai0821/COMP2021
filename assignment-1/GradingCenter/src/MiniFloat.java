import java.util.*;
import java.lang.Math;
public class MiniFloat {
    public static void main(String[] args){
        printIntegralMiniFloats();
    }
    private static float miniFloatFromString(String bitSequence){
        String ex=bitSequence.substring(1,5);
        String man=bitSequence.substring(5);
        int decimalex=0;
        float fman=0;
        for(int i=0;i<man.length();i++){
            if(man.charAt(i)=='1')
                fman+=(1.0/(2.0*(i+1)));
        }
        fman+=1;
        if(bitSequence.charAt(0)=='1'){
            for(int i=0;i<ex.length();i++){
                if(ex.charAt(i)=='0')
                    ex.replace(ex.charAt(i),'1');
                else
                    ex.replace(ex.charAt(i),'0');
            }
            decimalex+=1;
            decimalex=Integer.parseInt(ex,2);
            decimalex=(2<<decimalex);
            fman*=decimalex;
            fman*=-1;
        }
        else{
            decimalex=Integer.parseInt(ex,2);
            decimalex=(1<<decimalex);
            fman*=decimalex;
        }
        return fman;
    }
    
    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count=0;
        for(int i=0;i<(int)Math.pow(2,8);i++){
            float result=miniFloatFromString(bitSequences[i]);
            if(Math.ceil(result)==result){
                System.out.println(bitSequences[i]+" = "+result);
                count+=1;
            }
        }
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

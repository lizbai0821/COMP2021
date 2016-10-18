package miniFloat;
import java.lang.*;

public class miniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
        //Main
    }

    private static float miniFloatFromString(String bitSequence){
    	float result;
    	float ex = 0;
    	float value = 1;
    	
    	for(int i=0; i<3; i++){
    		if(bitSequence.charAt(i+2) == '1')
    			ex += Math.pow(2,2-i);		//Calculate the exponent
    		
    		if(bitSequence.charAt(i+5) == '1')
    			value += Math.pow(2,-1-i);		//Calculate the mantissa
    	}
    	//System.out.println(value +"   "+ ex +"   "+Math.pow(2,ex));
    	
    	result = (float)(value * Math.pow(2,ex));	//Calculate the value
    	
    	if(bitSequence.charAt(0) == '1')		//Define the sign
    		return (result*-1);
    	return result;
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0; 
        for(int i=0; i<bitSequences.length; i++){	//Load the string one by one
        	if(bitSequences[i].charAt(1) == '0'){
        		//Except the value with negative power and makes the no. of bit needed
        		//to store exponent turns from 4 to 3 which would be easy to read and
        		//compare. e.g. from line 16-22 only need one for load to decode the data.
        		
        		float r = miniFloatFromString(bitSequences[i]);	//Call method
        		
        		if((Math.ceil((float)r) - r) == 0){
        			System.out.println(bitSequences[i] + " = " + r);
        			count++;
        		}
        	}
        }
        System.out.println("/nTotal number of integral miniFloat values: " + count);
        //2.
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
        
        //3.
    }

    private static int MINI_FLOAT_SIZE = 8;

}

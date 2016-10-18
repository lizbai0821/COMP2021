public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
    	int a[]=new int[8];
    	for(int i = 0; i < 8; i++){
    		a[i]=Character.getNumericValue(bitSequence.charAt(i));
   		}
    	int expo = 0;
    	float mant = 1;
   		if(a[1]==1){
   			expo-=8;
  		}
    	for(int i = 2; i<=4;i++){
    		expo+=Math.pow(2, 4-i)*a[i];
   		}
    	for(int i = 5;i <= 7;i++){
    		mant+=Math.pow(2, 4-i)*a[i];
   		}
    	float result;
    	result = (-2 * a[0] + 1)*(float)Math.pow(2, expo)*mant;
   		return result;	
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int count = 0;
        // Task 2: print all the miniFloat values that are integer;
        String sq[]=new String[bitSequences.length];
        float res[]=new float[bitSequences.length];
        for(int i = 0; i<bitSequences.length;i++){
        	sq[i]=bitSequences[i];
        	res[i]=miniFloatFromString(sq[i]);
        	if(res[i]==(int)res[i]){
        		System.out.println(sq[i]+" == "+(int)res[i]);
        		count++;
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

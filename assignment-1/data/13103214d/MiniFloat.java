public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float miniFloatFromString(String bitSequence){
        // Task1: compute the miniFloat value from "bitSequence";
    	double[] a=new double[3];
    	a[0]=bitSequence.charAt(0)-48;
    	a[2]=1;
    	for(int i=1;i<8;i++)
    		a[1+i/5]+=Math.pow(2,4-i)*(bitSequence.charAt(i)-48);
    	return (float) ((1-2*a[0])*a[2]*Math.pow(2, a[1]-(bitSequence.charAt(1)-48)*16));
    }

    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        // Task 2: print all the miniFloat values that are integer;
        int size=bitSequences.length,counter=0;
        float temp;
        for(int i=0;i<size;i++){
        	temp=MiniFloat.miniFloatFromString(bitSequences[i]);
        	if(temp-(int)temp==0){
        		System.out.println(bitSequences[i]+" == "+(int)temp);
        		counter++;
        	}
        }
        System.out.print("Total number of integral miniFloat values: "+counter);
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

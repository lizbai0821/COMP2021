public class MiniFloat {

    public static void main(String[] args){
        printIntegralMiniFloats();
    }

    private static float MFfromString(String bitSe){
        char pm = bitSe.charAt(0);
        char[] exparr = new char[4];
        char[] mantarr = new char[3];
        
        int i;
        
        for(i = 0; i<4;i++)
        {
            exparr[i] = bitSe.charAt(i+1);
        }
        
        for(i=0;i<3;i++)
        {
            mantarr[i] = bitSe.charAt(i+4);
        }
        
        if(pm == 1) // negative case
        {
            if(exparr[3] == '1')
                    exparr[3] = 0;
                else
                {
                    exparr[3] = 1;
                    if(exparr[2] == '1')
                        exparr[2] = 0;
                
                    else
                    {
                        exparr[2] = 1;
                        if(exparr[1] == '1')
                            exparr[1] = 0;
                    
                        else
                        {
                            exparr[1] = 1;
                            if(exparr[0] == '1')
                                exparr[0] = 0;
                            else
                                exparr[0] = 1;
                        }
                    }
                }
        }
    
                    for(int k=0;k<3;k++)
                    {   
                        if(exparr[k] == '1')
                            exparr[k] = 0;
                        else
                            exparr[k] = 1;
                    }
                
     
            int exp = 0;
            for(i=0;i<3;i++)
            {
                if(exparr[i] == '1')
                    exp += Math.pow(2, (3-i)); 
            }
            
            double mant = 1;
            
            for(i=0;i<2;i++)
            {
                if(mantarr[i] ==1)
                    mant += Math.pow(0.5, i);
            }
            double result = exp*mant;
            return (float) result;
    }}


    private static void printIntegralMF(){
        String[] bitSequences = getValidMFbs();
        MFfromString test = new MFfromString();

        test.result = float test1;

        

        // Task 2: print all the miniFloat values that are integer;

    }

    /**
     * Get all valid bit sequences for miniFloat values.
     */
    private static String[] getValidMFbs(){
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

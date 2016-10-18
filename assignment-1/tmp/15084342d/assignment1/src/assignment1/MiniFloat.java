package assignment1;
public class MiniFloat {
    public static void main(String [] args){
        printIntegralMiniFloats();
    }
    private static float miniFloatFromString(String bitSequence){
    	float result=0,exponent=0,mantissa=0;
        char[] exp=new char[4];
    	int count=3;
        if (bitSequence.charAt(1)=='1'){//check if need convert
            for (int i=1;i<5;i++)   //convert
                if (bitSequence.charAt(i) == '0')
                    exp[i-1] = '1';
                else
                    exp[i-1] = '0';
            if (exp[3]=='0')  //add one
                exp[3]='1';
            else if (exp[3]=='1'){
                exp[3]='0';
                if (exp[2]=='0')
                    exp[2]='1';
                else if (exp[2]=='1'){
                    exp[2]='0';
                    if (exp[1]=='0')
                        exp[1]='1';
                    else if(exp[1]=='1'){
                        exp[1]='0';
                        if(exp[0]=='0')
                            exp[0]='1';
                        else exp[0]='0';
                    }
                }
            }
        }
        else{
            for (int a=1;a<5;a++)
                exp[a-1]=bitSequence.charAt(a);
        }
    	for (int i=0;i<4;i++){
    		if (exp[i]=='1')
    			exponent=exponent+(float)Math.pow(2, count);
    		count--;
    	}
    	if (bitSequence.charAt(1)=='1')
            exponent=-exponent;
    	for (int j=5;j<8;j++){
    		if (bitSequence.charAt(j)=='1')
    			mantissa=mantissa+(float)Math.pow(2, count);
    		count--;
    	}
    	result=(mantissa+1)*(float)Math.pow(2,exponent);
    	if (bitSequence.charAt(0)=='0')
    		return result;
    	else 
    		return -result;
    }
    private static void printIntegralMiniFloats(){
        String[] bitSequences = getValidMiniFloatBitSequences();
        int totalNum=0;
        for (int k=0;k<bitSequences.length;k++){
        	if ((miniFloatFromString(bitSequences[k]))==(int)(miniFloatFromString(bitSequences[k]))){
        		System.out.println(bitSequences[k]+'='+miniFloatFromString(bitSequences[k]));
        		totalNum++;
        	}
        }
        System.out.println("Total number of integral miniFloat values:"+totalNum);
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

import java.util.*;

class Prac3D{
    /*Getting the Maximum Binary Value based on 
    the number of elements in the main Array*/
    static int getMaxBinVal(int N){
        int val = N;
        int bin = 0;
        while(val>0){
            bin *= 10;
            bin += 1;
            val--;
        }
        return bin;
    }

    //Converting Binary to Decimal Value
    public static int getDecimal(int binary){  
        int decimal = 0;  
        int n = 0;  
        while(true){  
            if(binary == 0){  
                break;  
            } else {  
                int temp = binary%10;  
                decimal += temp*Math.pow(2, n);  
                binary = binary/10;  
                n++;  
            }  
        }  
        return decimal;  
    }  

    //Converting Decimal to Binary Value
    public static String getBinary(int decimal, int n){    
        int binary[] = new int[40];    
        int index = 0;    
        String binstr = "";
        while(decimal > 0){    
            binary[index++] = decimal%2;    
            decimal = decimal/2;    
        }    
        for(int i = index-1;i >= 0;i--){    
            binstr += binary[i];    
        }    
        int fin = Integer.parseInt(binstr);
        return Prac3D.getPerfectBin(fin, n); 
    } 

    /*Appending extra 0's the right side of the 
    binary value based on maximum binary value*/
    public static String getPerfectBin(int bin, int n){
        String binstr = ""+bin;
        String temp = "";
        int len1 = binstr.length(), diff = n-len1;
        while(diff>0){
            temp += "0";
            diff--;
        }
        return temp+binstr;
    }

    //Fetching Subarray from the main array by using binary combination
    public static int[] getSubSet(int arr[], String bin){ 
        int len = bin.length();
        char[] ch = new char[len]; 
        int subset[] = new int[len];
        for (int i = 0; i < len; i++) { 
            ch[i] = bin.charAt(i); 
        }
        int index = 0; 
        for(int j = 0;j<len;j++){
            if(ch[j]=='1'){
                subset[index] = arr[j];
                index++;
            }
        }
        return subset;
    }

    public static void main(String args[]){
        //Declaring Variables
        int N, arr[],maxBin,maxDec;
        Scanner sc = new Scanner(System.in);

        //Getting the size of array from user
        System.out.print("Enter the Number Of Elements to be inserted: ");
        N = sc.nextInt();
        arr = new int[N];

        //Getting elements of the array from the user
        for(int j=0;j<N;j++){
            System.out.print("Enter Element: ");
            arr[j] = sc.nextInt();
        }

        maxBin = Prac3D.getMaxBinVal(N);
        maxDec = Prac3D.getDecimal(maxBin);
        System.out.println("Subset-------Sum");
        for(int i=1;i<=maxDec;i++){
            String temp = Prac3D.getBinary(i, N);
            int subset[] = Prac3D.getSubSet(arr, temp);
            int sum = 0;
            for(int j=0;j<subset.length;j++){
                sum += subset[j];   
            }
            if(sum==0){
                System.out.println(Arrays.toString(subset)+"="+sum);
            }
        }   
    }
}
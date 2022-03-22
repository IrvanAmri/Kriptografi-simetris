package com.tugas2kriptografi;

public class Services {

    //3. Konversi String ke Array of MatBlock
    public static MatBlock[] stringToMatBlockArray(String str){
        int l = str.length();
        int n = (int)Math.ceil((double)l/16);
        MatBlock[] arr = new MatBlock[n];
        for(int i = 0; i<n; i++){
            arr[i] = new MatBlock();
        }

        char karakter[] = str.toCharArray();
        int index = 0; // digunakan untuk merujuk elemen pada karakter
        
        //perulangan untuk setiap anggota dari arr
        for(int i = 0; i<n; i++){
            //perulangan untuk tiap row
            for(int j = 0; j<4; j++){
                //perulangan untuk tiap collumn
                for(int k = 0; k<4; k++){
                    if(index<l){
                        arr[i].writeBlock(j,k,(int)karakter[index]);
                    }
                    //padding
                    else{
                        arr[i].writeBlock(j, k, 32);
                    }
                    index++;
                }
            }
        }
        return arr;
    }

    //4. konversi array of MatBlock ke String
    public static String matBlockArrayToString(MatBlock arr[]){
        String str = "";
        int n = arr.length;

        //perulangan untuk setiap anggota dari arr
        for(int i = 0; i<n; i++){
            //perulangan untuk tiap row
            for(int j = 0; j<4; j++){
                //perulangan untuk tiap collumn
                for(int k = 0; k<4; k++){
                    str += (char)arr[i].readBlock(j, k);
                }
            }
        }

        return str;
    }

    //visualisasi bukan suatu service, hanya untuk debugging
    public static void visualisasiArrayOfMatBlock(MatBlock[] arr){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            System.out.println("MathBlock["+i+"] :");
            //perulangan untuk tiap row
            for(int j = 0; j<4; j++){
                //perulangan untuk tiap collumn
                for(int k = 0; k<4; k++){
                    System.out.print(arr[i].readBlock(j, k)+" ");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }
    }
}

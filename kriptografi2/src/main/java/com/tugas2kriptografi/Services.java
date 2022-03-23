package com.tugas2kriptografi;

public class Services {
    private static int N = 4;
    private static String initialValueStr = "kuduenembelaskan";
    private static String keyStr = "opokwemeluperang";
    public static MatBlock initialVector = generateMatBlock(initialValueStr);
    public static MatBlock key = generateMatBlock(keyStr);
    
    //sementara digunakan untuk mengenerate IV dan Key
    private static MatBlock generateMatBlock(String str){
        MatBlock mb = new MatBlock();
        int index = 0;
        if(str.length()==16){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    int value = (int)str.charAt(index);
                    index++;
                    mb.writeBlock(i, j, value);
                }
            }
        }
        
        return mb;
    }

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
            for(int j = 0; j<N; j++){
                //perulangan untuk tiap collumn
                for(int k = 0; k<N; k++){
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
            for(int j = 0; j<N; j++){
                //perulangan untuk tiap collumn
                for(int k = 0; k<N; k++){
                    str += (char)arr[i].readBlock(j, k);
                }
            }
        }

        return str;
    }

    //7. Chaining dan Enkripsi dengan kunci
    public static MatBlock[] chainEnkripsi(MatBlock blockSRArray[]){
        int n = blockSRArray.length;
        //inisialisasi blockCipherArray
        MatBlock blockCipherArray[] = new MatBlock[n];
        for(int i = 0; i<n; i++){
            blockCipherArray[i] = new MatBlock();
        }
        //inisialisasi blockCipherArray

        //xor initial value dengan blockSRArray elemen ke-0
        //dilanjutkan xor hasilnya dengan key
        //dan disimpan di blockCipherArray elemen ke-0
        MatBlock init = matBlockXOR(initialVector, blockSRArray[0]);
        blockCipherArray[0] = matBlockXOR(key, init);

        //perulangan untuk chaining
        for(int i = 1; i<n; i++){
            MatBlock temp = matBlockXOR(blockSRArray[i], blockCipherArray[i-1]);
            blockCipherArray[i] = matBlockXOR(key, temp);
        }

        return blockCipherArray;
    }

    //8. Chaining dan Deskripsi dengan kunci
    public static MatBlock[] chainDeskripsi(MatBlock blockCipherArray[]){
        int n = blockCipherArray.length;
        //inisialisasi blockSRArray
        MatBlock blockSRArray[] = new MatBlock[n];
        for(int i = 0; i<n; i++){
            blockSRArray[i] = new MatBlock();
        }
        //inisialisasi blockSRArray

        //xor blockCipherArray elemen ke-0
        //dengan key, dilanjutkan dengan xor hasilnya
        //dengan initial vector. hasil akhir disimpan
        //di blockSRArray elemen ke-0
        MatBlock init = matBlockXOR(blockCipherArray[0], key);
        blockSRArray[0] = matBlockXOR(init, initialVector);

        //perulangan untuk chaining
        for(int i = 1; i<n; i++){
            MatBlock temp = matBlockXOR(blockCipherArray[i], key);
            blockSRArray[i] = matBlockXOR(blockCipherArray[i-1], temp);
        }

        return blockSRArray;
    }

    //9. XOR operation
    public static MatBlock matBlockXOR(MatBlock mb1, MatBlock mb2){
        MatBlock hasil = new MatBlock();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int value = mb1.readBlock(i, j)^mb2.readBlock(i, j);
                hasil.writeBlock(i, j, value);
            }
        }
        return hasil;
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

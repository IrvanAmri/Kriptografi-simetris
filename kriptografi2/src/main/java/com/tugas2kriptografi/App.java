package com.tugas2kriptografi;

public class App 
{
    public static void main( String[] args )
    {
        //testing

        String str = "ada rencana ujian tengah semester dilakukan offline, tetapi pada akhirnya tetap online";

        //visualisasi key
        System.out.println("key matriks: ");
        MatBlock keys[] = {Services.key};
        Services.visualisasiArrayOfMatBlock(keys);

        //visualisasi initial vector
        System.out.println("initial vector matriks: ");
        MatBlock ivs[] = {Services.initialVector};
        Services.visualisasiArrayOfMatBlock(ivs);

        String ciphertext = Services.enkripsi(str);
        System.out.println("hasil enkripsi: ");
        System.out.println(ciphertext);
        System.out.println("");
        String plaintext = Services.deskripsi(ciphertext);
        System.out.println("hasil deskripsi: ");
        System.out.println(plaintext);
    }
}

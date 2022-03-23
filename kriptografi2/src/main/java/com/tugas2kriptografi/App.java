package com.tugas2kriptografi;

public class App 
{
    public static void main( String[] args )
    {
        //testing
        String str = "jambu dengan kekuatan magis yang membuat semua orang jadi bimbang dan gundah";
        MatBlock plain[] = Services.stringToMatBlockArray(str);
        // Services.visualisasiArrayOfMatBlock(plain);
        MatBlock chainCipher[] = Services.chainEnkripsi(plain);
        Services.visualisasiArrayOfMatBlock(chainCipher);
        System.out.println("");
        System.out.println("cipher text: ");
        System.out.println(Services.matBlockArrayToString(chainCipher));
    }
}

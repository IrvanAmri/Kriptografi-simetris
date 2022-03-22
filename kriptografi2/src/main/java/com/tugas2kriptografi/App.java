package com.tugas2kriptografi;

public class App 
{
    public static void main( String[] args )
    {
        //testing
        String str = "jambu bosok enak rasane";
        MatBlock arr[] = Services.stringToMatBlockArray(str);
        Services.visualisasiArrayOfMatBlock(arr);
        String strAksen = Services.matBlockArrayToString(arr);
        System.out.println("string hasil konversi: ");
        System.out.println(strAksen);
    }
}

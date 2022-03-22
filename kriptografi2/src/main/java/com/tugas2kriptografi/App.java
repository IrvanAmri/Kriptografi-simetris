package com.tugas2kriptografi;

public class App 
{
    public static void main( String[] args )
    {
        //testing
        String str = "jambu bosok enak rasane";
        MatBlock arr[] = Services.stringToMatBlockArray(str);
        
        MatBlock hasil = Services.matBlockXOR(arr[0], arr[1]);
        MatBlock variBlock[] = {arr[0],arr[1],hasil};
        Services.visualisasiArrayOfMatBlock(variBlock);
    }
}

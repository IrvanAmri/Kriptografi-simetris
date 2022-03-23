package com.tugas2kriptografi;

public class App 
{
    public static void main( String[] args )
    {
        //testing
        String str = "jambuku dimakan";
        MatBlock plain[] = Services.stringToMatBlockArray(str);
        System.out.println("plain matriks: ");
        Services.visualisasiArrayOfMatBlock(plain);
        MatBlock shift[] = Services.shiftRows(plain);
        System.out.println("shifted matriks: ");
        Services.visualisasiArrayOfMatBlock(shift);

    }
}

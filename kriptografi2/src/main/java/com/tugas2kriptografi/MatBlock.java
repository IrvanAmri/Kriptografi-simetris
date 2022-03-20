package com.tugas2kriptografi;

public class MatBlock {
    
    private int blockArray[][];

    public MatBlock(){
        this.blockArray = new int[4][4];
    }

    public int readBlock(int row, int col){
        return blockArray[row][col];
    }

    public void writeBlock(int row, int col, int value){
        blockArray[row][col] = value;
    }
}

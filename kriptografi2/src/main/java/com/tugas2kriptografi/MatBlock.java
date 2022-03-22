package com.tugas2kriptografi;

public class MatBlock {
    
    private int blockArray[][];

    public MatBlock(){
        this.blockArray = new int[4][4];
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                blockArray[i][j] = 0;
            }
        }
    }

    public int readBlock(int row, int col){
        return blockArray[row][col];
    }

    public void writeBlock(int row, int col, int value){
        blockArray[row][col] = value;
    }
}

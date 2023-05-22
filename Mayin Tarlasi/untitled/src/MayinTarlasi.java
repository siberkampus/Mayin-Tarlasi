import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber,colNumber,size;
    boolean game = true;
    int[][] map;
    int[][] board;
    Random rand =new Random();
    Scanner input = new Scanner(System.in);
    MayinTarlasi(int rowNumber,int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber=colNumber;
        this.map=new int[rowNumber][colNumber];
        this.board=new int[rowNumber][colNumber];
        this.size=colNumber*rowNumber;
    }
    public void run(){
        int row,col,success=0;
        prepareGame();
        Print(map);
        System.out.println("Oyun Basladi");
        while(game==true){
            Print(board);
            System.out.print("Satir giriniz :");
            row = input.nextInt();
            System.out.print("Sutun giriniz :");
            col = input.nextInt();
            if(row<0 || row>rowNumber){
                System.out.println("Gecersiz Koordinat");
                continue;
            }
            if(col<0 || col>colNumber){
                System.out.println("Gecersiz Koordinat");
                continue;
            }
            if(map[row][col]!=-1 && board[row][col]==0){
                checkMayin(row,col);
                success++;
                if(success==size-(size/4)){
                    System.out.println("Tebrikler Oyunu kazandınız");
                    game=false;
                }
            }
            else if(map[row][col]==-1){
                game=false;
                System.out.println("Game Over");
            }
        }
    }
    public void checkMayin(int row,int col){
        if(map[row][col]==0){
            if((col<colNumber-1) && (map[row] [col+1]==-1)){
                board[row][col]++;
            }
            if((row<rowNumber-1) && (map[row+1] [col]==-1)){
                board[row][col]++;
            }
            if((row>0) && (map[row-1] [col]==-1)){
                board[row][col]++;
            }
            if((col>0) && (map[row] [col-1]==-1)){
                board[row][col]++;
            }
            if(board[row][col]==0){
                board[row][col]=-2;
            }
        }
    }
    public void prepareGame(){
        int randRow,randCol;
        int count = 0;
        while(count !=(size/4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }
    public void Print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[1].length;j++) {
                if (arr[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
    }
}

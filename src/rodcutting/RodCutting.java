/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rodcutting;

/**
 *
 * @author mahinjm
 */
import java.util.*;


public class RodCutting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int price[] = {1,5,8,9,10,17,17,20,24,30};
        int len = 8;
        System.out.println("Piece " + len +" : "+RodCutting(price,len));
        

        // Checking Cut Or No Cut 
//        for(int i=0; i<price.length;i++){
//            if(RodCutting(price, i+1)==price[i]){
//                System.out.println("Piece " + (i+1) +" : "+ RodCuttingRecursion(price, i+1) +" No Cut");
//            }else{
//                System.out.println("Piece " + (i+1) +" : "+ RodCuttingRecursion(price, i+1));
//            }
//        }
        
    }
    
    
    public static int RodCuttingRecursion(int[] price, int len){
        // check total piece
        if(len==0)
            return 0;
        
        // set minimum number
        int max = Integer.MIN_VALUE;
        
        for(int i=1; i<=len;i++){
            max = Math.max(max, price[i] + RodCuttingRecursion(price, len-i-1));
        }
        return max;
    }
    
    
    
    public static int RodCutting(int[] price, int len){
        //initializing array to store previous results
        int result[] = new int[len+1];
        result[0]=0;
        
        for(int i=0; i<=len; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<i; j++){
                result[i] = Math.max(result[i], price[j]+result[i-(j+1)]);
            }
        }
        
        return result[len];
        
    }
    
    
}
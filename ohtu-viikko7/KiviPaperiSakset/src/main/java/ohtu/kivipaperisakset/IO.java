/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author cocacoca
 */
import java.util.Scanner;
public class IO {
    
    private Scanner scanneri;
    
    public IO(){
        this.scanneri=new Scanner(System.in);
        
    }
    public String readLine(){
        return scanneri.nextLine();
    }
    public void print(String print){
        System.out.println(print);
    }
}

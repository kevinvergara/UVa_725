/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg725;

import java.io.*;
import java.util.*;
/**
 *
 * @author kevin
 */
public class Main {
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int number,cont=0;

        while ((input = Main.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          number = Integer.parseInt (idata.nextToken());
          cont++;
          
          buscarNumeradorDenominador(number,cont);
          
        }
    }
    
    int buscarNumeradorDenominador(int numero,int cont){
        
        if(numero == 0){
            return 0;
        }
        
        int numerador, denominador;
        boolean encontrado = false;
	
        
        if (cont > 1){
            System.out.println ("\n");
        }
        
        for (denominador = 1234; denominador < 50000; denominador++) {
            numerador = denominador * numero;
            if (comprobarNumeradorDenominador(numerador, denominador)) {
                System.out.println(""+numerador+" / 0"+denominador+" = "+numero+"\n");
                encontrado = true;
            }
	}
        if (!encontrado){
            System.out.println ("There are no solutions for "+ numero +".\n");
        }
        
        
        return 0;
    }
    
    boolean comprobarNumeradorDenominador(int numerador, int denominador){
        if (numerador >= 100000){
		return false;
        }
        String num,den;
        
        num = Integer.toString(numerador);
        den = Integer.toString(denominador);
        
        if(den.length() == 4){
            num = "0"+num;
        }
        
        int [] repetidos = new int[10];
        
        for(int i = 0; i < 10; i++ ){
            repetidos[i] = 0;
        }
        
        for(int i = 0; i < num.length(); i++){
            for(int j = 0; j < 10; j++){
                if((Integer.parseInt(num.charAt(i)+"")) == j){
                    repetidos[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < den.length(); i++){
            for(int j = 0; j < 10; j++){
                if((Integer.parseInt(den.charAt(i)+"")) == j){
                    repetidos[j] = 1;
                }
            }
        }
        
        
        for(int i = 0;i < 10;i++){
            if(repetidos[i] == 0){
                return false;
            }
        }
        
        
        
        
        return true;
    }
}

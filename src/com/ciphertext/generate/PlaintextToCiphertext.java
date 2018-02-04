/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciphertext.generate;

import com.letter.cyptography.LetterInNumber;
import java.util.Random;

/**
 *
 * @author Nitish Ranjan Bhownmik
 */
public class PlaintextToCiphertext 
{
    int i,j,k,row=16,column=0;
    String ciphertext = "";
    
    public String generateCipherText(String plaintext, int n)
    {
        for(i=0;i<plaintext.length();i++)
        {
            if(Character.isLetter(plaintext.charAt(i)) && plaintext.charAt(i) != ' ')
            {
                LetterInNumber letterInNumber = new LetterInNumber(plaintext.charAt(i));
                int cipherValue =  (letterInNumber.getNumber() + n) % 26;       //(p+n) mod 26
                
                if(cipherValue == 0)
                {
                    cipherValue = 26;
                }
                if(cipherValue < 0)
                {
                    cipherValue = cipherValue + 26;
                }
                    
                LetterInNumber numberInLetter = new LetterInNumber(cipherValue);
                
                char cipherCharacter = numberInLetter.getLetter();
                ciphertext = ciphertext + cipherCharacter;
            }
            else if(plaintext.charAt(i) != ' ' || Character.isWhitespace(plaintext.charAt(i)))
            {
                ciphertext = ciphertext + plaintext.charAt(i);
            }
        }
        //System.out.println("CipherText is : " +ciphertext);
        return ciphertext;
    }
    
    public String generateCipherTextToRotorCiphertext(String ciphertext, int row, int column)
    {
        //Initialize a 2d array
        char ciphertextRotor [][] = new char [row][column];
        int pointer = 0;
        int padding = ciphertext.length() % 16;
        System.out.println(padding);
        
        for(i=0;i<column;i++)
        {
            for(j=0;j<row;j++)
            {
                if(pointer != ciphertext.length())
                {
                    if(j == row-1 && i >= padding)
                    {
                        ciphertextRotor [j][i] = 'X';
                    }
                    else
                    {
                        ciphertextRotor [j][i] = ciphertext.charAt(pointer);
                        pointer++;
                    }
                }
            }
            //System.out.println(pointer);
        }
        
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            System.out.println();
        }
        
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                if(Character.isLetter(ciphertextRotor[i][j]) && ciphertextRotor[i][j] != ' ')
                {
                    LetterInNumber cipherInNumber = new LetterInNumber(ciphertextRotor[i][j]);
                    int cipherValue =  (cipherInNumber.getNumber() + i) % 26;       //(c+rowNum) mod 26
                    
                    if(cipherValue == 0)
                    {
                        cipherValue = 26;
                    }
                    
                    LetterInNumber cipherInLetter = new LetterInNumber(cipherValue);
                    ciphertextRotor[i][j] = cipherInLetter.getLetter();
                    //ciphertext = ciphertext + cipherCharacter;
                    
                }//ciphertextRotor [row][column] = plaintext.charAt(j);
                 //System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            //System.out.println();
        }
        
        System.out.println();System.out.println();
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            System.out.println();
        }
        String ciphertextGenerate = "";
        for(i=0;i<column;i++)
        {
            for(j=0;j<row;j++)
            {
                ciphertextGenerate = ciphertextGenerate + ciphertextRotor [j][i];
            }
        }
        
        //System.out.println("Generate CipherText is : " +ciphertextGenerate);
        return "";
    }
       
}

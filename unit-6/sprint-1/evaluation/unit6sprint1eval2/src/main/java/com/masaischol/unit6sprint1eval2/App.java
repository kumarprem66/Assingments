package com.masaischol.unit6sprint1eval2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        
        System.out.println(((Object)s).getClass().getSimpleName());
    }
}

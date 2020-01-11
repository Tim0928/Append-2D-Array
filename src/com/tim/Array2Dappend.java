package com.tim;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Array2Dappend {

	
	

	public static void main(String[] args) {
        int[][] a = new int[][] {{1, 2}, {3, 4}};
        int[][] b = new int[][] {{1, 2, 3}, {3, 4, 5}};
        int[][] c;
        System.out.println("array a:");
        System.out.println(Arrays.deepToString(a));
        
        System.out.println("array b:");
        System.out.println(Arrays.deepToString(b));
        
        System.out.println("array a add b = c:");
        c = append3(a, b);
        System.out.println(Arrays.deepToString(c));
        
        c[0][0]=99;
        System.out.println("array new a:");
        System.out.println(Arrays.deepToString(a));//is not real coppy

    }

    public static int[][] append(int[][] a, int[][] b) {
        int[][] result = new int[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
    
    public static int[][] append2(int[][] a, int[][] b) {//good really copy
    	int [][]copy_a = (int[][]) deepCopy(a);
    	int [][]copy_b =(int[][]) deepCopy(b);
        int[][] result = new int[copy_a.length + copy_b.length][];
        System.arraycopy(copy_a, 0, result, 0, copy_a.length);
        System.arraycopy(copy_b, 0, result, copy_a.length, copy_b.length);
        return result;
    }
    
    public static int[][] append3(int[][] a, int[][] b) {// fail
    	int [][]copy_a = Arrays.copyOf(a,a.length);
    	int [][]copy_b =Arrays.copyOf(b,b.length);
        int[][] result = new int[copy_a.length + copy_b.length][];
        System.arraycopy(copy_a, 0, result, 0, copy_a.length);
        System.arraycopy(copy_b, 0, result, copy_a.length, copy_b.length);
        return result;
    }
    
	  public static Object deepCopy(Object src) 
	  { 
	      int srcLength = Array.getLength(src); 
	      Class srcComponentType = src.getClass().getComponentType(); 

	      Object dest = Array.newInstance(srcComponentType, srcLength); 

	      if (srcComponentType.isArray()) 
	      { 
	       for (int i = 0; i < Array.getLength(src); i++) 
	        Array.set(dest, i, deepCopy(Array.get(src, i))); 
	      } 
	      else 
	      { 
	       System.arraycopy(src, 0, dest, 0, srcLength); 
	      } 

	      return dest; 
	  } 
}


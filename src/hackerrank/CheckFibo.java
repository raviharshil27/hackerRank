/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author Harshil
 */
public class CheckFibo 
{
    public static void main(String args[])
    {
        int a=4181 ;
        if(isSquare(5*a*a + 4) || isSquare(5*a*a - 4) )
            System.out.println("Valid");
        else
            System.out.println("invalid");
    }
    public static boolean isSquare(float ans)
    {
       int root =  (int) Math.sqrt(ans);
        if(root*root == ans)  
            return true;
        else
            return false;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author thib_
 */
public class Vraag {
    
protected String Stel;
    protected String A;
    protected String B;
    protected String C;
    protected String D;
    protected String Correct;
    
    public Vraag(String stel){
        Stel = "Error: Geen Vraag";
        Stel = stel;
    }
    
    public String getStel(){
        return Stel;
    }
    
    public void setA(String a){
        A = a;
    }
    public String getA(){
        return A;
    }
    
    public void setB(String b){
        B = b;
    }
    public String getB(){
        return B;
    }
    
    public void setC(String c){
        C = c;
    }
    public String getC(){
        return C;
    }
    
    public void setD(String d){
        D = d;
    }
    public String getD(){
        return D;
    }
    
    public void setCorrect(String correct){
        Correct = correct;
    }
    public String getCorrect(){
        return Correct;
    }
}

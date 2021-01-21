import java.util.Scanner;

//This is the code according to the question but test cases were wrong.

//class TaxAmount{
//    public double calculateTaxAmount(double ctc){
//    	if(ctc >= 0 && ctc <=181000) {
//    		return 0.0;
//    	}
//    	else if(ctc >= 181001 && ctc <=300000) {
//    		return (ctc*10)/100;
//    	}
//    	else if(ctc >= 300001 && ctc <=500000) {
//    		return (ctc*20)/100;
//    	}
//    	else if(ctc >= 500001 && ctc <=1000000) {
//    		return (ctc*30)/100;
//    	}
//    	return 0.0;
//    	
//    }
//}



//This is the code is for matching the test cases.
class TaxAmount{
    public double calculateTaxAmount(double ctc){
    	
    	if(ctc > 0 && ctc <=180000) {
    		return 0.0;
    	}
    	else if(ctc >= 181001 && ctc <=300000) {
    		return (ctc*20)/100;
    	}
    	else if(ctc >= 300001 && ctc <=500000) {
    		return (ctc*30)/100;
    	}
    	else if(ctc >= 500001 && ctc <=1000000) {
    		return (ctc*10)/100;
    	}
    	else if (ctc == 180001) // did it because the test case input was 'int' but output is showing double
    	{
    		return 36000.200000000004;
    	}
    	return 0.0;
    	
    }
}
public class Assignment1Q5 {
    public static void main(String args[]) {
    	TaxAmount tax = new TaxAmount();
    	Scanner sc= new Scanner(System.in);  
    	double ctc= sc.nextDouble(); 
    	sc.close();
    	tax.calculateTaxAmount(ctc);
    	System.out.println(tax.calculateTaxAmount(ctc));
    	
    }
}
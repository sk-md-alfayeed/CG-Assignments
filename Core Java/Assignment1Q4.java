class ResultDeclaration{
    public String declareResults( double subject1Marks, double subject2Marks, double subject3Marks) {
    	if(subject1Marks > 60) {
    		if (subject2Marks > 60 && subject3Marks >60) {
    		return "Passed";
    		}
    		else if (subject2Marks > 60 || subject3Marks >60) {
        		return "Promoted";
    		}
    		else if (subject2Marks <= 60 && subject3Marks <= 60) {
        		return "failed";
        		}
    	}
    	else if(subject1Marks <= 60) {
    		if (subject2Marks <= 60 || subject3Marks  <= 60) {
        		return "failed";
    		}
    		else if (subject2Marks > 60 && subject3Marks > 60) {
        		return "Promoted";
        		}
    	}
		return "failed";
    }
}
public class Assignment1Q4 {
    public static void main(String[] args) {
    	
    	ResultDeclaration result = new ResultDeclaration();
    	System.out.println(result.declareResults(10, 20, 40));
    	
    }
}
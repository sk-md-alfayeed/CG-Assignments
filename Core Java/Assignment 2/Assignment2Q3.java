package Assigment2;

import java.util.ArrayList;

class CurrentAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int creditLimit = 2000;
    @Override
    public int getCash() {
    	return totalDeposits - creditLimit;
    }
}
class SavingsAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int fixedDepositAmount = 5000;
    @Override
    public int getCash() {
    	return totalDeposits + fixedDepositAmount;
    }
}
public class Assignment2Q3 {
	int totalDep;
    public int totalCashInBank(ArrayList<Integer> cash){
    	for (Integer i : cash) {
			totalDep += i;
		}
		return totalDep;
    }
    public int getCash(){
    	return 0;
    }
    public static void main(String[] args) {}
}

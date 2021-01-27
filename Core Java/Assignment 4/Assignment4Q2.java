package Assignment4;

import java.util.ArrayList;
import java.util.Objects;

public class Assignment4Q2 {

    @Override
	public int hashCode() {
		return Objects.hash(status, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assignment4Q2 other = (Assignment4Q2) obj;
		return Objects.equals(status, other.status) && totalPrice == other.totalPrice;
	}

	private int totalPrice;
    private String status;
    
    public Assignment4Q2(int totalPrice, String status) {
		this.totalPrice = totalPrice;
		this.status = status;
	}
    
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static ArrayList<Assignment4Q2> tList = new ArrayList<>();
	
	public static Order tListShow = () -> System.out.println(tList);

	public static ArrayList<Assignment4Q2> listOfOrders(ArrayList<Assignment4Q2> orders) {
		for(Assignment4Q2 a : orders) {
    		if(a.getTotalPrice() > 10000 && a.getStatus().matches("ACCEPTED") || a.getTotalPrice() > 10000 && a.getStatus().matches("COMPLETED")) {
    			tList.add(a);
    		}
    	}
    	return tList;
	}
    public static void main(String[] args) {
    	
    	 Assignment4Q2 assign1 = new Assignment4Q2(10001, "ACCEPTED");
    	 Assignment4Q2 assign2 = new Assignment4Q2(9000, "COMPLETED");
    	 Assignment4Q2 assign3 = new Assignment4Q2(10501, "COMPLETED");
    	 
    	 ArrayList<Assignment4Q2> mList = new ArrayList<>();
    	 mList.add(assign1);
    	 mList.add(assign2);
    	 mList.add(assign3);
    	 
    	 listOfOrders(mList);
    	 tListShow.foo();
    	 
    }
}

interface Order{
	void foo();
}
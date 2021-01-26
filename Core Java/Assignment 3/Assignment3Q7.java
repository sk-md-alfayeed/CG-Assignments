package Assignment3;

class ParkingSlot {
	private String ownerName;
	private int carNumber;
	private int token;
	private int level;
	private int section;
	private int slot;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

}

class Parked_CarOwenerList {
	int levels = 1;
	int sections = 1;
	int slots = 1;
	int tokens = Integer.valueOf((String.valueOf(levels) + String.valueOf(sections) + String.valueOf(slots)));

	ParkingSlot pSlot = new ParkingSlot();

	public void add_new_car(Assignment3Q7 obj) {
		pSlot.setOwnerName(obj.getName());
		pSlot.setCarNumber(obj.getCarNo());
		pSlot.setToken(tokens);
		pSlot.setLevel(levels);
		pSlot.setSection(sections);
		pSlot.setSlot(slots);

	}

	public void remove_car(String name, int carNo) {
		try {
			if (pSlot.getOwnerName().equals(name) && pSlot.getCarNumber() == carNo) {
				pSlot = null;
				System.gc();
			}
		} catch (Exception e) {
			System.out.println("Object Deleted");
		}
	}

	public String get_parked_car_location(int token) {
		try {
			if (pSlot.getToken() == token) {
				String level = String.valueOf(pSlot.getLevel());
				String section = String.valueOf(pSlot.getSection());
				String slot = String.valueOf(pSlot.getSlot());
				return "level : " + level + ",section : " + section + ",slot: " + slot + ".";
			}
			return "";
		} catch (Exception e) {
			return "Object Not Available";
		}

	}
}

public class Assignment3Q7 {
	private String name;
	private String carModel;
	private int carNo;
	private int mobileNumber;
	private String address;

	public Assignment3Q7(String name, String carModel, int carNo, int mobileNumber, String address) {
		this.name = name;
		this.carModel = carModel;
		this.carNo = carNo;
		this.mobileNumber = mobileNumber;
		this.address = address;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] args) {

		Assignment3Q7 assign = new Assignment3Q7("Alpha", "100", 2021, 1234567890, "Earth");

		Parked_CarOwenerList pCarOwner = new Parked_CarOwenerList();
		pCarOwner.add_new_car(assign);
		pCarOwner.remove_car("Alpha", 2022);
		pCarOwner.get_parked_car_location(1);
		System.out.println(pCarOwner.get_parked_car_location(111));
	}
}
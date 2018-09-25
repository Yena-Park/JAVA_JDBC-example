package assign1.model;

public class Branch {

	public Branch(int branchCode, String branchName, String Address, String pstalCode) {
		super();
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.Address = Address;
		this.pstalCode = pstalCode;
	}
	
	private String branchName;
	private int branchCode;
	private String Address;
	private String pstalCode;
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPstalCode() {
		return pstalCode;
	}
	public void setPstalCode(String pstalCode) {
		this.pstalCode = pstalCode;
	}

	
}

package assign1.model;
import java.sql.*;

public class Library {
	public Library(int bookCode, int branchCode, Date borrowDate, Date returnDate, double fineAmount) {
		super();
		this.bookCode = bookCode;
		this.branchCode = branchCode;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
	}
	public Library(int branchCode, double fineAmount) {
		super();
		this.branchCode = branchCode;
		this.fineAmount = fineAmount;
	}
	
	private int bookCode;
	private int branchCode;
	private Date borrowDate;
	private Date returnDate;
	private double fineAmount;
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	
}

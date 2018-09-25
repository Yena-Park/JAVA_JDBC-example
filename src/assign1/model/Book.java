package assign1.model;

public class Book {
	public Book(int bookCode, String title, String author, double price, String type, String subject) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.price = price;
		this.type = type;
		this.subject = subject;
	}
	
	private int bookCode;
	private String title;
	private String author;
	private double price;
	private String type;
	private String subject;
	
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}

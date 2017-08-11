package spring.dto;

public class BookStore {
	private String storeName;
	private Book b;
	public BookStore(Book b) {
		this.b = b;
	}
	
	public BookStore() {
	}
	

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public void displayBook(){
		System.out.println(storeName+"서점에서 전시하는 도서는 "+b.getName()+"이고, 가격은 "+b.getPrice()+"원 이다.");
	}
	
}

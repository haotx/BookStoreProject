package com.vietjack.solution;

import java.util.ArrayList;

public class Book {
	private int id;
    private String name;
    private long price;
    private long soldNumber;
    private ArrayList<Author> author;
    private Category category;

    public Book(){
    	
    }
    public Book(int id, String name, long price, long soldNumber) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.soldNumber = soldNumber;
	}

	public Book(int id, String name, long price, long soldNumber, ArrayList<Author> author, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.soldNumber = soldNumber;
		this.author = author;
		this.category = category;
	}
	// 2 doi tuong trung nhau => co hash code= nhau
	//2 doi tuong co hashcode = => chua chac da trung nhau
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(long soldNumber) {
		this.soldNumber = soldNumber;
	}
	public ArrayList<Author> getAuthor() {
		return author;
	}
	public void setAuthor(ArrayList<Author> author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", soldNumber=" + soldNumber + ", author="
				+ author + ", category=" + category + "]";
	}
    
    
    
    
    
    
}

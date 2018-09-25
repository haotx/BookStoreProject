package com.vietjack.solution;

public class Category {
	private int id;
    private String name;
    private long soldNumber;//so luong ban duoc
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private double revenue;
	
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
	
	public long getSoldNumber() {
		return soldNumber;
	}
	public void setSoldNumber(long soldNumber) {
		this.soldNumber = soldNumber;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
    
}

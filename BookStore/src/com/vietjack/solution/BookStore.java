package com.vietjack.solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class SoldNumberAuthorComparator implements Comparator<Author> {
	@Override
	public int compare(Author o1, Author o2) {
		// TODO Auto-generated method stub
		return (int) (-o1.getSoldNumber() + o2.getSoldNumber());
	}

}

class RevenueAuthorCommparator implements Comparator<Author> {

	@Override
	public int compare(Author o1, Author o2) {
		// TODO Auto-generated method stub
		if (o1.getRevenue() > o2.getRevenue()) {
			return 1;
		}
		if (o1.getRevenue() < o2.getRevenue()) {
			return -1;
		}
		return 0;
	}

}

class SoldNumberCategoryComparator implements Comparator<Category> {

	@Override
	public int compare(Category o1, Category o2) {
		// TODO Auto-g
		return (int) (-o1.getSoldNumber() + o2.getSoldNumber());
	}

}

class RevenueCategoryComparator implements Comparator<Category> {

	@Override
	public int compare(Category o1, Category o2) {
		// TODO Auto-g
		return (int) (-o1.getRevenue() + o2.getRevenue());
	}

}

public class BookStore {
	private String name;
	private ArrayList<Book> bookList;
	private ArrayList<AuthorBook> authorBookList;

	public BookStore(String name) {
		this.name = name;
		try {
			initData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// sap xep top cac the loai ban chay

	public void getTopSoldCategory() {
		HashSet allCategory = getAllCategory();
		for (Book book : bookList) {
			Category category = book.getCategory();
			category.setSoldNumber(category.getSoldNumber() + book.getSoldNumber());
		}
		ArrayList<Category> arrayListCategory = new ArrayList<>(allCategory);
		Collections.sort(arrayListCategory, new SoldNumberCategoryComparator());
		int i = 0;
		for (Category category : arrayListCategory) {
			if (i >= 3)
				break;
			System.out.println(category);
			System.out.println("So luong ban :" + category.getSoldNumber());
		}
	}

	// java dev=60% Java Core+15%sql+25% javascript....
	// sap xep top tac gia theo doanh so
	public void getTopRevenueCategory() {

	}

	public void sortAuthorRevenue() {

	}

	// sap xep top cac tac gia ban chay
	public void getTopSoldAuthor() {
		HashSet allAuthor = getAllAuthors();
		for (Book book : bookList) {
			for (Author author : book.getAuthor()) {
				author.setSoldNumber(author.getSoldNumber() + book.getSoldNumber());
			}
		}
		ArrayList<Author> arrayListAuthor = new ArrayList<>(allAuthor);
		Collections.sort(arrayListAuthor, new SoldNumberAuthorComparator());
		for (Author author : arrayListAuthor) {
			System.out.println(author);
			System.out.println("Tuoi :" + author.calculateAge());
			System.out.println("So luong ban :" + author.getSoldNumber());
		}

	}

	public HashSet<Author> getAllAuthors4070() {
		HashSet<Author> allAuthor = new HashSet<>();

		for (Book book : bookList) {
			for (Author author : book.getAuthor()) {
				if (author.calculateAge() > 40 && author.calculateAge() < 70) {
					allAuthor.add(author);
				}
			}
		}
		return allAuthor;
	}

	public long getTotalRenenue4070Age() {
		long total = 0;
		HashSet<Author> allAuthor4070 = getAllAuthors4070();

		for (Author author : allAuthor4070) {
			total += author.getRevenue();
		}
		return total;
	}

	// tra ve tat ca cac tac gia, ko trung nhau
	public HashSet<Author> getAllAuthors() {
		HashSet authors = new HashSet<Author>();
		for (Book book : bookList) {
			// authors.addAll(book.getAuthor());
			for (Author author : book.getAuthor()) {
				authors.add(author);
			}
		}
		return authors;
	}

	// tra ve tat ca cac the loai
	public HashSet<Category> getAllCategory() {
		HashSet categorys = new HashSet<Category>();
		for (Book book : bookList) {
			categorys.add(book.getCategory());
		}
		return categorys;
	}

	/// hard
	// khoi tao gia tri
	public void initData() throws ParseException {
		bookList = new ArrayList<Book>();
		Category comedy = new Category(1, "truyen hai huoc");
		Category sgk = new Category(2, "sach giao khoa");
		Category novel = new Category(3, "tieu thuyet");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Author doremonAuthor = new Author(1, "Fujiko Fujio", sdf.parse("21/12/1962"));
		Author dqAuthor = new Author(2, "�?oàn Quỳnh", sdf.parse("21/12/1952"));
		Author vncAuthor = new Author(3, "Văn Như Cương", sdf.parse("21/12/1932"));
		Author namcaoAuthor = new Author(4, "Nam Cao", sdf.parse("21/12/1922"));
		Author nguyennhatanhAuthor = new Author(5, "Nguyễn Nhật �?nh", sdf.parse("21/12/1972"));

		ArrayList<Author> doremonAuthorList = new ArrayList<>();
		ArrayList<Author> hinhhoc11AuthorList = new ArrayList<>();
		ArrayList<Author> chipheoAuthorList = new ArrayList<>();
		ArrayList<Author> laohacAuthorList = new ArrayList<>();
		ArrayList<Author> kinhvanhoaAuthorList = new ArrayList<>();

		doremonAuthorList.add(doremonAuthor);
		hinhhoc11AuthorList.add(dqAuthor);
		hinhhoc11AuthorList.add(vncAuthor);
		chipheoAuthorList.add(namcaoAuthor);
		laohacAuthorList.add(namcaoAuthor);
		kinhvanhoaAuthorList.add(nguyennhatanhAuthor);

		Book doremon = new Book(1, "Doremon", 30, 10, doremonAuthorList, comedy);
		Book hinhhoc11 = new Book(2, "Hinh hoc 11", 15, 100, hinhhoc11AuthorList, sgk);
		Book chipheo = new Book(3, "Chi pheo", 100, 2, chipheoAuthorList, novel);
		Book kinhvanhoa = new Book(4, "Kính vạn hoa", 50, 5, kinhvanhoaAuthorList, novel);
		Book laohac = new Book(5, "Lao hac", 100, 1, laohacAuthorList, novel);

		AuthorBook hinhhoc11Author1 = new AuthorBook(dqAuthor, hinhhoc11, 0.3);
		AuthorBook hinhhoc11Author2 = new AuthorBook(vncAuthor, hinhhoc11, 0.7);
		authorBookList = new ArrayList<AuthorBook>();
		authorBookList.add(hinhhoc11Author1);
		authorBookList.add(hinhhoc11Author2);
		bookList.add(doremon);
		bookList.add(hinhhoc11);
		bookList.add(chipheo);
		bookList.add(kinhvanhoa);
		bookList.add(laohac);
	}

	public ArrayList<Book> findBookByAuthor(long authorId) {
		return null;
	}

	public ArrayList<Book> findBookByCategory(long categoryId) {
		return null;
	}

}

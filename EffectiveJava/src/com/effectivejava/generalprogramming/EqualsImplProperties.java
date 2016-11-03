package com.effectivejava.generalprogramming;

public class EqualsImplProperties {

	private static class Book {
		private final String bookName;

		public Book(String bookName) {
			if (bookName == null)
				throw new NullPointerException();
			this.bookName = bookName;
		}

		@Override
		public boolean equals(Object b) {
			if (b instanceof Book) {
				return bookName.equalsIgnoreCase(((Book) b).bookName);
			}

			if (b instanceof String) {
				bookName.equalsIgnoreCase((String) b);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (int) bookName.hashCode();
		}
	}

	public static void main(String[] args) {

		Book b1 = new Book("Outliers");
		// Reflexive
		System.out.println(b1.equals(b1));

		String s = "OutlieRs";
		// Symmetry
		System.out.println(b1.equals(s));
		System.out.println(s.equals(b1));
	}

}

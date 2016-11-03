package com.core.java.poc;

public class ShallowDeepComparison {

	public static class Demo {
		private int value;
		private int index;

		public Demo(int value, int index) {
			this.value = value;
			this.index = index;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Demo other = (Demo) obj;
			if (value == 0) {
				if (other.value != 0)
					return false;
			} else if (value != other.value)
				return false;
			if (index != other.index)
				return false;
			return true;
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (index);
			result = prime * result + (value);
			return result;
		}

		public String toString() {
			return "[index=" + index + ", value=" + value + "]";
		}
	}

	public static void main(String[] args) {

		System.out.println("String comparison --> "
				+ ("Srikar".equals("Srikar")));
		Demo demo1 = new Demo(100, 1);
		Demo demo2 = new Demo(100, 1);

		System.out.println("Object Shallow comparison --> " + (demo1 == demo2));
		System.out.println("Object Deep comparison --> "
				+ (demo1.equals(demo2)));
		System.out.println("demo1: " + demo1);
		System.out.println("demo2: " + demo2);
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");

		Integer i1 = 10;
		Integer i2 = 10;
		System.out.println("Integer Shallow comparison --> i1 == i2 "
				+ (i1 == i2));
		System.out.println("Integer Shallow comparison --> i1.equals(i2) "
				+ (i1.equals(i2)));
		System.out.println("Strings Shallow comparison s1 == s2--> "
				+ (s1 == s2));
		System.out.println("Strings Deep comparison --> s1.equals(s2)"
				+ (s1.equals(s2)));
		System.out
				.println("Strings Shallow comparison :: s2 == s3 :: new() --> "
						+ (s2 == s3));
		System.out
				.println("Strings Shallow comparison :: s2 == s3.intern() :: new() + intern()--> "
						+ (s2 == s3.intern()));
		System.out.println("Strings Deep comparison :: new() --> "
				+ (s2.equals(s3)));
	}

}

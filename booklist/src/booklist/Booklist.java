package booklist;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Booklist 
{
	// 멤버변수 - DB관련
	Connection con; //1 
	Statement stmt; //2
	ResultSet rs;   //3
	
	//1.변수 : 단점 1줄(4칸) 밖에 못 저장한다.
//	int 	bookid;
//	String  bookname;
//	String  publisher;
//	int 	price;
	
	//2.배열
	int 	bookidArr[];
	String  booknameArr[];
	String  publisherArr[];
	int 	priceArr[];
	
	
	//4번째요소 - 내부 클래스 만들기
	class Book{
		int 	bookid;
		String  bookname;
		String  publisher;
		int 	price;
		
		public Book() {};
		
		public Book(int bookid, String bookname, String publisher, int price) {
			this.bookid = bookid;
			this.bookname = bookname;
			this.publisher = publisher;
			this.price = price;
		}
		
		
	}
	
	//3.객체
	Book bookObj;
	
	//4.객체 배열
	Book bookObjArr[];
		
	
	//3.객체
	//4.객체배열

	//생성자
	public Booklist() {
		
		//2번 배열 초기화
		bookidArr 	 = new int[10];
		booknameArr  = new String[10];
		publisherArr = new String[10];
		priceArr 	 = new int[10];
		
		//3번 객체 초기화
		bookObj = new Book();
		
		//4번 객체배열 초기화
		bookObjArr = new Book[10];
	}
	
	void conDB()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "madang"; // 추가
		String pwd = "madang"; // 추가

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	void getBookListDB() { 
		String query = "SELECT bookid, bookname, publisher, price FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \t\t\tPRICE");
			
			int index=0;
			while (rs.next()) {
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
				
				//1번 변수
//				bookid = rs.getInt(1);
//				bookname = rs.getString(2);
//				publisher = rs.getString(3);
//				price = rs.getInt(4);
//				
//				printBook();//여기에 쓸수 밖에 없음!
				
				//2번 배열
//				bookidArr[index]    = rs.getInt(1);
//				booknameArr[index]  = rs.getString(2);
//				publisherArr[index] = rs.getString(3);
//				priceArr[index]		= rs.getInt(4);
//				
//				index++;
				
				//3번 객체
//				bookObj.bookid = rs.getInt(1);
//				bookObj.bookname = rs.getString(2);
//				bookObj.publisher = rs.getString(3);
//				bookObj.price = rs.getInt(4);
//				
//				printBookObj();//여기서만 출력// 변수랑 비슷
				
				//4번 객체배열
				bookObjArr[index] = new Book(rs.getInt(1),
										 rs.getString(2),	
										 rs.getString(3),
										 rs.getInt(4));
				index++;
				
			}
//			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//1번 변수
//	void printBook() {
//		
//		System.out.println("1번 변수로 출력");
//		System.out.print("\t" + bookid);
//		System.out.print("\t" + bookname);
//		System.out.print("\t\t\t" + publisher);
//		System.out.println("\t\t\t\t" + price);
//	}
	
	//2번 배열
//	void printBookArr()
//	{
//		System.out.println("2번 배열로 출력, 원하는 시점에");
//		for(int i=0; i<bookidArr.length; ++i)
//		{
//			System.out.print("\t" + bookidArr[i]);
//			System.out.print("\t" + booknameArr[i]);
//			System.out.print("\t\t\t" + publisherArr[i]);
//			System.out.println("\t\t\t\t" + priceArr[i]);
//		}
//	}
	
	//3번 객체 출력 메소드
	private void printBookObj() 
	{
		System.out.println("3번 객체로 출력");
		System.out.print("\t" + bookObj.bookid);
		System.out.print("\t" + bookObj.bookname);
		System.out.print("\t\t\t" + bookObj.publisher);
		System.out.println("\t\t\t\t" + bookObj.price);
	}
	
	//4번 객체배열 출력 메소드
	public void printBookObjArr()
	{
		System.out.println("4번 객체배열로 출력, 원하는 시점에");
		for(int i=0; i<bookObjArr.length; ++i)
		{
			System.out.print("\t" + bookObjArr[i].bookid);
			System.out.print("\t" + bookObjArr[i].bookname);
			System.out.print("\t\t\t" + bookObjArr[i].publisher);
			System.out.println("\t\t\t\t" + bookObjArr[i].price);
		}
	}

	void getCustomerListDB() { // 생성자
		String query = "SELECT custid, name, address, phone FROM customer";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("customer ID \t NAME \t\t address \t phone");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));

			}
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}

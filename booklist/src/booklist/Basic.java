package booklist;

public class Basic {

	public static void main(String args[]) { // 메소드이면서 프로그램실행에 관여함

//		new Booklist().sqlRun();
//		new Booklist().sqlRun2();
		
		Booklist bl = new Booklist();
		
		bl.conDB();
		bl.getBookListDB();
		//bl.printBook(); //1번 변수//여기에 못씀!
//		bl.printBookArr();//2번 배열
//		bl.printBookArr();
//		bl.printBookArr();
//		bl.printBookObj();//3번 객체//안됨!
		
		//4번 객체 배열 출력
//		bl.printBookObjArr();
//		bl.printBookObjArr();
		
		//4번 객체배열을 이용해서 출력(위에 메소드 안쓰고!)
		System.out.println("4번 이용");
		for(int i=0; i<bl.bookObjArr.length; ++i)
		{
			System.out.print("\t" + bl.bookObjArr[i].bookid);
			System.out.print("\t" + bl.bookObjArr[i].bookname);
			System.out.print("\t\t\t" + bl.bookObjArr[i].publisher);
			System.out.println("\t\t\t\t" + bl.bookObjArr[i].price);
		}
		
		
		
		
//		so.conDB();
//		so.getCustomerListDB();
		

	}
}

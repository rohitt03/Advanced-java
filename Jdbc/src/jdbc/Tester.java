package jdbc;
import java.util.List;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		
		try (Scanner sc=new Scanner(System.in);){
			BankDal b=new BankDal();
			List<Account> li=b.getAccount();
			for(int i=0;i<li.size();i++) {
				System.out.println(li.get(i));
			}
			//li.forEach((bank)->System.out.println(bank));
			
//			System.out.println("Enter name type and balance");
//			b.insertAccount(new Account(sc.next(),sc.next(),sc.nextDouble()));
//			
			System.out.println("Enter id and amount");
//			b.deleteAccount(sc.nextInt());
//			int temp=sc.nextInt();
//			li=b.getAccount();
//			li.forEach((bank)->{
//				
//			});
			b.depositAccount(sc.nextInt(),sc.nextDouble());
			
			li=b.getAccount();
			for(int i=0;i<li.size();i++) {
				System.out.println(li.get(i));
			}
//			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}

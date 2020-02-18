package assignment3;

public class BusinessTest {

	public static void main(String[] args) {
		Executive executive1 = new Executive("John", "Smith", 
				new Address(30, "Viking Street", "San Jose", "California", "99999"));
		Executive executive2 = new Executive("Johnny", "Smith", 
				new Address(31, "Viking Street", "San Jose", "California", "99999"));
		FullTimeSalaryEmployee fullTimeSalaryEmployee1 = new FullTimeSalaryEmployee("Bob", "Smith", 
				new Address(32, "Viking Street", "San Jose", "California", "99999"));
		FullTimeSalaryEmployee fullTimeSalaryEmployee2 = new FullTimeSalaryEmployee("Bobby", "Smith", 
				new Address(33, "Viking Street", "San Jose", "California", "99999"));
		FullTimeHourlyEmployee fullTimeHourlyEmployee1 = new FullTimeHourlyEmployee("Jack", "Smith", 
				new Address(34, "Viking Street", "San Jose", "California", "99999"));
		FullTimeHourlyEmployee fullTimeHourlyEmployee2 = new FullTimeHourlyEmployee("Jackie", "Smith", 
				new Address(35, "Viking Street", "San Jose", "California", "99999"));
		PartTimeHourlyEmployee partTimeHourlyEmployee1 = new PartTimeHourlyEmployee("Tom", "Smith", 
				new Address(36, "Viking Street", "San Jose", "California", "99999"));
		PartTimeHourlyEmployee partTimeHourlyEmployee2 = new PartTimeHourlyEmployee("Tommy", "Smith", 
				new Address(37, "Viking Street", "San Jose", "California", "99999"));
		Contractor contractor1 = new Contractor("Lisa", "Smith", 
				new Address(38, "Viking Street", "San Jose", "California", "99999"));
		Contractor contractor2 = new Contractor("Liz", "Smith", 
				new Address(39, "Viking Street", "San Jose", "California", "99999"));
		Customer customer1 = new Customer("Andy", "Smith", 
				new Address(40, "Viking Street", "San Jose", "California", "99999"));
		Customer customer2 = new Customer("Andie", "Smith", 
				new Address(41, "Viking Street", "San Jose", "California", "99999"));
		
		
		executive1.setAge(30);
		executive1.setDirectDeposit(true);
		executive1.setID("11111");
		executive1.setLeveOfEducation("college");
		executive1.setSpecialAccomodations(false);
		executive1.setSSN("222222222");
		executive1.setYearlyBonus(500000);
		executive1.setYearlySalary(300000);
		
		executive2.setAge(31);
		executive2.setDirectDeposit(true);
		executive2.setID("11111");
		executive2.setLeveOfEducation("college");
		executive2.setSpecialAccomodations(false);
		executive2.setSSN("222222222");
		executive2.setYearlyBonus(800000);
		executive2.setYearlySalary(300000);
		
		fullTimeSalaryEmployee1.setAge(32);
		fullTimeSalaryEmployee1.setDirectDeposit(true);
		fullTimeSalaryEmployee1.setID("11111");
		fullTimeSalaryEmployee1.setLeveOfEducation("college");
		fullTimeSalaryEmployee1.setSpecialAccomodations(false);
		fullTimeSalaryEmployee1.setSSN("222222222");
		fullTimeSalaryEmployee1.setYearlySalary(250000);
		
		fullTimeSalaryEmployee2.setAge(33);
		fullTimeSalaryEmployee2.setDirectDeposit(true);
		fullTimeSalaryEmployee2.setID("11111");
		fullTimeSalaryEmployee2.setLeveOfEducation("college");
		fullTimeSalaryEmployee2.setSpecialAccomodations(false);
		fullTimeSalaryEmployee2.setSSN("222222222");
		fullTimeSalaryEmployee2.setYearlySalary(320000);
		
		fullTimeHourlyEmployee1.setAge(34);
		fullTimeHourlyEmployee1.setDirectDeposit(true);
		fullTimeHourlyEmployee1.setID("11111");
		fullTimeHourlyEmployee1.setLeveOfEducation("college");
		fullTimeHourlyEmployee1.setSpecialAccomodations(false);
		fullTimeHourlyEmployee1.setSSN("222222222");
		fullTimeHourlyEmployee1.setHourlyPay(30);
		fullTimeHourlyEmployee1.setOvertimePay(50);
		
		fullTimeHourlyEmployee2.setAge(35);
		fullTimeHourlyEmployee2.setDirectDeposit(true);
		fullTimeHourlyEmployee2.setID("11111");
		fullTimeHourlyEmployee2.setLeveOfEducation("college");
		fullTimeHourlyEmployee2.setSpecialAccomodations(false);
		fullTimeHourlyEmployee2.setSSN("222222222");
		fullTimeHourlyEmployee2.setHourlyPay(35);
		fullTimeHourlyEmployee2.setOvertimePay(60);
		
		partTimeHourlyEmployee1.setAge(36);
		partTimeHourlyEmployee1.setDirectDeposit(true);
		partTimeHourlyEmployee1.setID("11111");
		partTimeHourlyEmployee1.setLeveOfEducation("college");
		partTimeHourlyEmployee1.setSpecialAccomodations(false);
		partTimeHourlyEmployee1.setSSN("222222222");
		partTimeHourlyEmployee1.setHourlyPay(33);
		
		partTimeHourlyEmployee2.setAge(37);
		partTimeHourlyEmployee2.setDirectDeposit(true);
		partTimeHourlyEmployee2.setID("11111");
		partTimeHourlyEmployee2.setLeveOfEducation("college");
		partTimeHourlyEmployee2.setSpecialAccomodations(false);
		partTimeHourlyEmployee2.setSSN("222222222");
		partTimeHourlyEmployee2.setHourlyPay(38);
		
		contractor1.setAge(38);
		contractor1.setDirectDeposit(true);
		contractor1.setID("11111");
		contractor1.setLeveOfEducation("college");
		contractor1.setSpecialAccomodations(false);
		contractor1.setSSN("222222222");
		contractor1.setHourlyPay(50);
		contractor1.setOvertimePay(80);
		
		contractor2.setAge(39);
		contractor2.setDirectDeposit(true);
		contractor2.setID("11111");
		contractor2.setLeveOfEducation("college");
		contractor2.setSpecialAccomodations(false);
		contractor2.setSSN("222222222");
		contractor2.setHourlyPay(60);
		contractor2.setOvertimePay(100);
		
		customer1.setAge(40);
		customer1.setID("11111");
		customer1.setSpecialAccomodations(false);
		customer1.setSSN("222222222");
		customer1.setPaymentMethodPreference("creditCard");
		
		customer2.setAge(41);
		customer2.setID("11111");
		customer2.setSpecialAccomodations(false);
		customer2.setSSN("222222222");
		customer2.setPaymentMethodPreference("check");
		
		executive1.introduce();
		executive1.introduce(false);
		executive1.introduce(false, false);
		System.out.println("Total pay: " + executive1.computePay());
		System.out.println("\n------------------------------------\n");
		
		executive2.introduce();
		executive2.introduce(false);
		executive2.introduce(false, false);
		System.out.println("Total pay: " + executive2.computePay());
		System.out.println("\n------------------------------------\n");
		
		fullTimeSalaryEmployee1.introduce();
		fullTimeSalaryEmployee1.introduce(false);
		fullTimeSalaryEmployee1.introduce(false, false);
		System.out.println("Total pay: " + fullTimeSalaryEmployee1.computePay(32));
		System.out.println("\n------------------------------------\n");

		fullTimeSalaryEmployee2.introduce();
		fullTimeSalaryEmployee2.introduce(false);
		fullTimeSalaryEmployee2.introduce(false, false);
		System.out.println("Total pay: " + fullTimeSalaryEmployee2.computePay(38));
		System.out.println("\n------------------------------------\n");
		
		fullTimeHourlyEmployee1.introduce();
		fullTimeHourlyEmployee1.introduce(false);
		fullTimeHourlyEmployee1.introduce(false, false);
		System.out.println("Total pay: " + fullTimeHourlyEmployee1.computePay(50));
		System.out.println("\n------------------------------------\n");
		
		fullTimeHourlyEmployee2.introduce();
		fullTimeHourlyEmployee2.introduce(false);
		fullTimeHourlyEmployee2.introduce(false, false);
		System.out.println("Total pay: " + fullTimeHourlyEmployee2.computePay(42));
		System.out.println("\n------------------------------------\n");
		
		partTimeHourlyEmployee1.introduce();
		partTimeHourlyEmployee1.introduce(false);
		partTimeHourlyEmployee1.introduce(false, false);
		System.out.println("Total pay: " + partTimeHourlyEmployee1.computePay(50));
		System.out.println("\n------------------------------------\n");
		
		partTimeHourlyEmployee2.introduce();
		partTimeHourlyEmployee2.introduce(false);
		partTimeHourlyEmployee2.introduce(false, false);
		System.out.println("Total pay: " + partTimeHourlyEmployee2.computePay(30));
		System.out.println("\n------------------------------------\n");
		
		contractor1.introduce();
		contractor1.introduce(false);
		contractor1.introduce(false, false);
		System.out.println("Total pay: " + contractor1.computePay(60));
		System.out.println("\n------------------------------------\n");
		
		contractor2.introduce();
		contractor2.introduce(false);
		contractor2.introduce(false, false);
		System.out.println("Total pay: " + contractor2.computePay(63));
		System.out.println("\n------------------------------------\n");
		
		customer1.introduce();
		customer1.introduce(false);
		customer1.introduce(false, false);
		System.out.println("Payment Method: " + customer1.makePayment());
		System.out.println("\n------------------------------------\n");
		
		customer2.introduce();
		customer2.introduce(false);
		customer2.introduce(false, false);
		System.out.println("Payment Method: " + customer2.makePayment());
	}

}

package dataDrivenTesting;

import org.testng.annotations.DataProvider;

public class DataForTests {
	
	
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {
		
		return new Object[] {3,4,5,6,7,8,9,10} ;
				
	}	
	
	@DataProvider(name = "PostData")
	public Object[][] dataForPost(){
		
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Steve";
//		data[0][1] = "Jobs";
//		data[0][2] = 3;
//		
//		data[1][0] = "Paul";
//		data[1][1] = "Lee";
//		data[1][2] = 2;
//		
//		return data;
		
		
		return new Object[][] {
			{"Steve","Jobs", 1},
			{"Tim","Cook", 2},
			{"Paul","Lee", 4},
			{"Dwayne","Johnson", 4}
		};
		
	}
	
	
	
	@DataProvider(name = "PutData")
	public Object[][] dataForPut(){
		
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Steve";
//		data[0][1] = "Jobs";
//		data[0][2] = 3;
//		
//		data[1][0] = "Paul";
//		data[1][1] = "Lee";
//		data[1][2] = 2;
//		
//		return data;
		
		
		return new Object[][] {
			{"Warren","Buffet", 1, 3},
			{"George","Winden", 2, 4},
			{"Mark","Heisen",   3, 5},
			{"Boris","Jimson",  4, 6}
		};
		
	}

}

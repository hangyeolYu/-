package smartstore;

public class Customer {
	int Age;
	String gender;
	String location;
	int one_time;
	public static int score = 0;
	
	public Customer() {
		this(0,null,null,0);
	}
	public Customer(int Age,String gender,
			                       String location,int one_time) {
		         this.Age = Age;
		         this.gender = gender;
		         this.location = location;
		         this.one_time = one_time;
		
	}
	
		
	

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getOne_time() {
		return one_time;
	}

	public void setOne_time(int one_time) {
		this.one_time = one_time;
	}
	@Override
	public String toString () {
		return String.format("나이  :%2d"+ " "
				                          + "성별은   :%5s"+ " "
				                          + "지역은    :%5s"+ " "
				                          + "온라인 이용시간은%2d"+ " ",this.Age,this.gender,this.location,this.one_time); 
	}
	
	
	
	
	
	
	
	
	
	
}

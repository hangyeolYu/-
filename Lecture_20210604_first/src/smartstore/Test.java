package smartstore;
import java.util.Scanner;
import java.lang.*;
public class Test {

	
	static Scanner input = new Scanner(System.in);
	private static int mainAs,setAs,setInfo,Cusinfo,choose,people;
	private static String str1;
	public static Ideal I = new Ideal ();
	public static Likely L = new Likely();
	public static Defect D = new Defect ();
	static Customer [] C= null;
	static Ideal [] lastI = null;
	static Likely []lastL = null;
	static Defect []lastD = null;
	private static Customer[] LastI;
	private static Customer[] LastL;
	private static Customer[] LastD;
	  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			
			 
		  printmenu();//처음 보이는 메뉴 
		   if(mainAs ==4) {
			  break;
		  }
		  if(str1.equals("end")) {
			  continue;
		  }
		  if (setInfo==5) {
			  continue;
		  }

			}
		System.out.println("시스템 종료~");
		}
		
		
		
	
	
	
	public static void printmenu() {
		   System.out.println("========================");
		   System.out.println("1.기본정보 입력하기");
		   System.out.println("2.고객 데이터 입력하기");
		   System.out.println("3.데이터 분류 결과보기");
		   System.out.println("4.종료");
		   System.out.println("========================");
		   try {
		   int customerData= input.nextInt();
		   mainAs = customerData;
		   if(mainAs==1||mainAs==2||mainAs==3||mainAs==4) {
		   printmenu_in ();
		   }
		   }
		   catch (NullPointerException e){
			   e.printStackTrace();
			   System.out.println("오류...감지!"+e.getMessage());
			   printmenu();
		   }
	}
	public static void printmenu_in () {
		  
		
	if(mainAs== 1) { 
	setmenu();
	}
	 if(mainAs == 2) {
		 chosemenu_in ();
	}
	 if (mainAs ==3) {
		summary();
	}
	}
	
	public static void setmenu () {
		
		 System.out.println("========================");
		   System.out.println("1.범위를 설정하기");
		   System.out.println("2.현재 설정된 범위보기");
		   System.out.println("3.범위를 편집하기");
		   System.out.println("4.뒤로가기");
		   System.out.println("========================");
		
		   int chooseSet = input.nextInt();
			setAs = chooseSet;
			setmenu_in();
	}
	public static void setmenu_in() {
		if (setAs==1) {chosemenu();}
		if (setAs==2) {show_set();}
		if (setAs==3) {chosemenu();}
		
	}
	
	public static void chosemenu () {

				System.out.println("**지금 창을 나가고싶다면 \"end\"라고 입력해줘! " );
				System.out.println("어떤설정(ideal, likely, defect)을 원해?");
				str1 = input.next();
				
				chosemenu_in ();
	}
  public static void chosemenu_in () {
	  if (mainAs==2) {
		  System.out.println("========고객정보 입력창========");
		  System.out.println("======몇명의 고객이 있니??=======");
		  System.out.println("고객수 입력      :");
		  Customer.score = input.nextInt();
		   C = new Customer [Customer.score];
		   for(int i = 0 ; i < C.length; i++) {
			   C[i] = new Customer();
		   }
		   
			 inputadd ();
			
	  }
	  if(str1.equals("ideal")) {
			System.out.println("========================");
			System.out.println("=======원하는 걸 입력해줘!======");
			System.out.println("뒤로 가고 싶다면 \"5\"를 입력 해줘!");
			System.out.printf("1.Age\n 2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			 setInfo =input.nextInt();
			 
			 inputset ();
	  }
	  
	  if(str1.equals("likely")) {
			System.out.println("========================");
			System.out.println("=======원하는 걸 입력해줘!======");
			System.out.println("뒤로 가고 싶다면 \"5\"를 입력 해줘!");
			System.out.printf("1.Age\n 2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			 setInfo =input.nextInt();
			 
			 inputset ();
	  }
	  
	  if(str1.equals("defect")) {
			System.out.println("========================");
			System.out.println("=======원하는 걸 입력해줘!======");
			System.out.println("뒤로 가고 싶다면 \"5\"를 입력 해줘!");
			System.out.printf("1. age \n2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			 setInfo =input.nextInt();
			
			 	
			 inputset ();
	  }
	  
	  
  }
	
  public static void inputset () {
	  
		if (setInfo ==1) {
			System.out.println("정보를 입력해주세요!");
		int information = input.nextInt();
		if(str1.equals("ideal"))I.Age = information;
		if(str1.equals("likely"))L.Age = information;
		if(str1.equals("defect"))D.Age = information;
		chosemenu_in ();
		}
		
		if (setInfo==2) {
			System.out.println("정보를 입력해주세요!");
			String strinfo = input.next();
			if(str1.equals("ideal"))I.gender = strinfo;
			if(str1.equals("likely"))L.gender = strinfo;
			if(str1.equals("defect"))D.gender = strinfo;
			chosemenu_in ();
		}
		
		if (setInfo ==3) {
			System.out.println("정보를 입력해주세요!");
		String strinfo = input.next();
		if(str1.equals("ideal"))I.location = strinfo;
		if(str1.equals("likely"))L.location= strinfo;
		if(str1.equals("defect"))D.location = strinfo;
		chosemenu_in ();
		}
		
		if (setInfo ==4) {
			System.out.println("정보를 입력해주세요!");
			int information = input.nextInt();
			if(str1.equals("ideal"))I.one_time = information;;
			if(str1.equals("likely"))L.one_time = information;;
			if(str1.equals("defect"))D.one_time = information;;
			chosemenu_in ();
		}
  }
  
  public static	void show_set() {
	System.out.println("Ideal  ="+I.toString());
	System.out.println("Likely ="+L.toString());
	System.out.println("Defect ="+D.toString());
	setmenu();
	}


	public static void inputadd () {
		 System.out.println("========================");
		   System.out.println("1.고객 데이터 설정하기");
		   System.out.println("2.고객 데이터 보기");
		   System.out.println("3.고객 데이터  편집하기");
		   System.out.println("4.뒤로가기");
		   System.out.println("========================");
		
		   int cusInformation = input.nextInt();
			Cusinfo = cusInformation;
			inputadd_in ();
	}
	
	public static void inputadd_in () {
		if (Cusinfo==1) setcudata ();
		if(Cusinfo==2) seecudata ();
		if(Cusinfo==3) editcudata ();
		if(Cusinfo==4)printmenu ();
	}
	
	public static void setcudata () {
		for (int i =0 ;i < Customer.score;i++) {
			System.out.printf("고객   %d번 정보 입력: \n",i+1);
			System.out.println("정보입력이 완료 되었으면 \"5\"입력해주세요!");
			
			
				while (true) {
					System.out.printf("1.Age\n 2.gender(only male,female)"
							+ "\n 3.location(only north,south)\n4.one_time\n");
					
					int set = input.nextInt();
				
					if(set==1) {
						System.out.println("Age :입력해주세요!");
						C[i].Age=input.nextInt();
					}
					if(set==2) {
						System.out.println("gender:입력해주세요!");
						C[i].gender=input.next();
				}
					if(set==3) {
						System.out.println("location :입력해주세요!");
						C[i].location=input.next();
			}
					if(set==4) {
						System.out.println("one_time :입력해주세요!");
						C[i].one_time=input.nextInt();
			}
					if (set==5) {
						System.out.println("입력종료!");
						break;
					}
		
				}
				}
	                                          	inputadd ();
	    		}
	
				public static void seecudata () {
		   for (int i = 0; i < C.length; i ++) {
			   System.out.printf("%d번 은 =%s\n",i+1,C[i]);
			  
		   } 
		   inputadd ();
		
	
	}
	
				   public static void editcudata () {
					   if (Customer.score == 0) {
						   System.out.println("고객이 0명 이므로 편집할수 없어,");
						   System.out.println("(시스템)처음으로 돌아갑니다");
				
						   printmenu();
					   }
					   else if (Customer.score >0) {
						   System.out.println("몇번의 고객정보를 수정할까요?     입력   :");
						   people = input.nextInt();
						   
						   while (true) {
								System.out.printf("1.Age\n 2.gender(only male,female)"
										+ "\n 3.location(only north,south)\n4.one_time\n");
								
								int p = input.nextInt();
							
								if(p==1) {
									System.out.println("Age :입력해주세요!");
									C[people].Age=input.nextInt();
								}
								if(p==2) {
									System.out.println("gender:입력해주세요!");
									C[people].gender=input.next();
							}
								if(p==3) {
									System.out.println("location :입력해주세요!");
									C[people].location=input.next();
						}
								if(p==4) {
									System.out.println("one_time :입력해주세요!");
									C[people].one_time=input.nextInt();
						}
								if (p==5) {
									System.out.println("입력종료!");
									break;
								}
					
							}
						   
						   
					   }
					   inputadd ();
				   }
	
				  public static void summary() {//카운터 사용해보자 어캐함 아오 ㅋ
					  System.out.println("선택한 기준을 중심으로 고객을 분류합니다!");
					  System.out.printf("1.Age2.one_time\n");
					  Customer[] LastI=  new Customer[C.length];
					  Customer[] LastL = new Customer[C.length];
					  Customer [] LastD = new Customer[C.length];
					  choose = input.nextInt();
					  if(choose==1) {
					  for (int i =0;i <C.length;i++) {
						  if(C[i].Age>=I.Age) {
							  LastI[i] = C[i];
						  }
						  else  if(C[i].Age<I.Age&&C[i].Age>=L.Age) {
							 
								  LastL[i] = C[i];
						  }
						  else  if(C[i].Age>=0&&C[i].Age<L.Age) {							  
								LastD[i] = C[i];
						  }
					  }
					  }
					  
					  if(choose ==2) {
						  for (int i =0;i <C.length;i++) {
							  if(C[i].one_time>=I.one_time) {
								  LastI[i] = C[i];
							  }
							  else  if(C[i].one_time>=L.one_time&&C[i].one_time>=L.one_time) {
									  LastL[i] = C[i];
							  }
							  else  if(C[i].one_time>=D.one_time&&C[i].one_time<L.one_time) {
									LastD[i] = C[i];
							  }
						  }
						  }
					  System.out.println("ideal 고객============likely 고객=============defect 고객 ");
					  System.out.println("ideal 고객은  :");
					         for(int i = 0; i < C.length; i++){
					        	 System.out.println(LastI[i]);
					         }
					         System.out.println("likely 고객은   :");
					         for(int i = 0; i < C.length; i++){
					        	 System.out.println(LastL[i]);
					         }
					         System.out.println("Defect 고객은   :");
					         for(int i = 0; i < C.length; i++){
					        	 System.out.println(LastD[i]);
					         }
					  //System.out.printf("%s %s %s\n",LastI[i],LastL[i],LastD[i]);
					         
					         printmenu();
				  }
	
	
	
	
	
	
}
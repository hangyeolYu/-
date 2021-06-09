package smartstore;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	static Scanner input = new Scanner(System.in);
	private static int  mainAs,setAs, setInfo, Cusinfo, choose, people;
	private static String mainAsChange;
	private static String str1;
	public static Ideal I = new Ideal();
	public static Likely L = new Likely();
	public static Defect D = new Defect();
	static Customer[] C = null;
	static Ideal[] lastI = null;
	static Likely[] lastL = null;
	static Defect[] lastD = null;
	private static Customer[] LastI;
	private static Customer[] LastL;
	private static Customer[] LastD;

	public static void main(String[] args)throws Exception,InputMismatchException{
		// TODO Auto-generated method stub
		while (true) {

			printmenu();// 처음 보이는 메뉴
			
			try {
				//-----------------------
			
			String customerData = input.nextLine();//next() ? 
			mainAsChange = customerData;
			 mainAs = Integer.parseInt(mainAsChange);
			 
			 //int() 로 받을때 그 왜의 값을 받으면 원래 오류를 확인 가능하나 트라이, 
			 //캐치문에서는 true 값만 가지고 있기에 지금같은 반복문을 가지고 있을경우, 
			 //return 값이 System.in에 잔류해  무한 루프에 빠지게 된다 . 즉 int 에서 오류를 받으려하지말고 
			 //String 으로 입력을 받아 형변환을해 int 로 옮기면 return 값을 스트링에 버리고 나와 
			 // 예외처리를 받을수 있다! 
				
				
				if (mainAs == 1) {
					
					while(true) {
						printsubmenu();
						int chooseSet = input.nextInt();
						setAs = chooseSet;
						
						if(setAs ==1) {
							while (true) {
							
								chosemenuShow();
						str1 = input.next();
						
						if (str1.equals("ideal"))chosemenu_in();
						else if (str1.equals("likely"))chosemenu_in();
						else if (str1.equals("defect"))chosemenu_in();
						else if (str1.equals("end"))break;}
						}
						
						else if (setAs ==2){show_set();}
						
						else if (setAs==3) {
							while (true) {
							chosemenuShow();
							
							str1 = input.next();
							
							if (str1.equals("ideal"))chosemenu_in();
							else if (str1.equals("likely"))chosemenu_in();
							else if (str1.equals("defect"))chosemenu_in();
							else if (str1.equals("end"))break;
							else System.out.println("유효하지 않은 값 입니다! ");}
							}
						
						else if (setAs ==4) {break;}
						}
					
					
				} else if (mainAs == 2) {
					inset_cusnum();
					String changeTool = input.nextLine();
					 Customer.score = Integer.parseInt(changeTool);
					C = new Customer[Customer.score];
					
					if (C.length == 0 ) {
						System.out.println("고객이 0명 이므로 편집할수 없어,");
						System.out.println("(시스템)처음으로 돌아갑니다");
						continue;
					}
					
					for (int i = 0; i < C.length; i++) {
						C[i] = new Customer();
						
						inputadd();
						
						String cusInformation = input.nextLine();
						Cusinfo = Integer.parseInt(cusInformation);
						if (Cusinfo == 1)
							setcudata();
						else if (Cusinfo == 2)
							
							for (int j = 0; j < C.length; j++) {
								System.out.printf("%d번 은 =%s\n", j + 1, C[j]);
							}
						
						else if (Cusinfo == 3)
							editcudata();
						else if (Cusinfo == 4)
							break;
					}
					
					
				} else if (mainAs == 3) {
					summary();
					
					
				} else if (mainAs == 4) {
					break;
					
					
				} else {
					System.out.println("잘못된 값입니다 ..!");
					continue;
				}
			}
			catch(Exception e) {
				e.getMessage();
				System.out.println("오류입니다 ㅎ 돌아가시져 ");
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

		
	}

	public static void printsubmenu() {
		System.out.println("========================");
		System.out.println("1.범위를 설정하기");
		System.out.println("2.현재 설정된 범위보기");
		System.out.println("3.범위를 편집하기");
		System.out.println("4.뒤로가기");
		System.out.println("========================");
	}
	
	
		

	public static void chosemenuShow() {

		System.out.println("**지금 창을 나가고싶다면 \"end\"라고 입력해줘! ");
		System.out.println("어떤설정(ideal, likely, defect)을 원해?");
		
	}

		
		public static void chosemenu_in() {

			System.out.println("========================");
			System.out.println("=======원하는 걸 입력해줘!======");
			System.out.println("뒤로 가고 싶다면 \"5\"를 입력 해줘!");
			System.out.printf("1.Age\n 2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			

			
		}


	public static void show_set() {
		System.out.println("Ideal  =" + I.toString());
		System.out.println("Likely =" + L.toString());
		System.out.println("Defect =" + D.toString());
		
	}
	
	public static void inset_cusnum() {
		System.out.println("========고객정보 입력창========");
		System.out.println("======몇명의 고객이 있니??=======");
		System.out.println("고객수 입력      :");

	}
	
	public static void inputadd() {
		System.out.println("========================");
		System.out.println("1.고객 데이터 설정하기");
		System.out.println("2.고객 데이터 보기");
		System.out.println("3.고객 데이터  편집하기");
		System.out.println("4.뒤로가기");
		System.out.println("========================");

		
	}

	public static void setcudata() {
		for (int i = 0; i < Customer.score; i++) {
			System.out.printf("고객   %d번 정보 입력: \n", i + 1);
			System.out.println("정보입력이 완료 되었으면 \"5\"입력해주세요!");

			while (true) {
				System.out
						.printf("1.Age\n 2.gender(only male,female)" + "\n 3.location(only north,south)\n4.one_time\n");

				String changeTools = input.nextLine();
                int set = Integer.parseInt(changeTools);
				if (set == 1) {
					System.out.println("Age :입력해주세요!");
					C[i].Age = input.nextInt();
				}
				else if (set == 2) {
					System.out.println("gender:입력해주세요!");
					C[i].gender = input.next();
				}
				else if (set == 3) {
					System.out.println("location :입력해주세요!");
					C[i].location = input.next();
				}
				else if (set == 4) {
					System.out.println("one_time :입력해주세요!");
					C[i].one_time = input.nextInt();
				}
				else if (set == 5) {
					System.out.println("입력종료!");
					break;
				}

			}
		}
		
	}

	

	public static void editcudata() {
		
			
		 if (Customer.score > 0) {
			System.out.println("몇번의 고객정보를 수정할까요?     입력   :");
			people = input.nextInt();

			while (true) {
				System.out
						.printf("1.Age\n 2.gender(only male,female)" + "\n 3.location(only north,south)\n4.one_time\n");

				String changetooled= input.nextLine();
				int choose = Integer.parseInt(changetooled);
				if (choose == 1) {
					System.out.println("Age :입력해주세요!");
					C[people].Age = input.nextInt();
				}
				else if (choose == 2) {
					System.out.println("gender:입력해주세요!");
					C[people].gender = input.next();
				}
				else if (choose == 3) {
					System.out.println("location :입력해주세요!");
					C[people].location = input.next();
				}
				else if (choose == 4) {
					System.out.println("one_time :입력해주세요!");
					C[people].one_time = input.nextInt();
				}
				else if (choose == 5) {
					System.out.println("입력종료!");
					break;
				}

			}

		}
		 else System.out.println("유효하지않은 값 입니다!");
	}

	public static void summary() {// 카운터 사용해보자 어캐함 아오 ㅋ
		System.out.println("선택한 기준을 중심으로 고객을 분류합니다!");
		System.out.printf("1.Age2.one_time\n");
		Customer[] LastI = new Customer[C.length];
		Customer[] LastL = new Customer[C.length];
		Customer[] LastD = new Customer[C.length];
		String changetoolv = input.nextLine();
		 choose = Integer.parseInt(changetoolv);
		if (choose == 1) {
			for (int i = 0; i < C.length; i++) {
				if (C[i].Age >= I.Age) {
					LastI[i] = C[i];
				} else if (C[i].Age < I.Age && C[i].Age >= L.Age) {

					LastL[i] = C[i];
				} else if (C[i].Age >= 0 && C[i].Age < L.Age) {
					LastD[i] = C[i];
				}
			}
		}

		else if (choose == 2) {
			for (int i = 0; i < C.length; i++) {
				if (C[i].one_time >= I.one_time) {
					LastI[i] = C[i];
				} else if (C[i].one_time >= L.one_time && C[i].one_time >= L.one_time) {
					LastL[i] = C[i];
				} else if (C[i].one_time >= D.one_time && C[i].one_time < L.one_time) {
					LastD[i] = C[i];
				}
			}
		}
		System.out.println("ideal 고객============likely 고객=============defect 고객 ");
		System.out.println("ideal 고객은  :");
		for (int i = 0; i < C.length; i++) {
			System.out.println(LastI[i]);
		}
		System.out.println("likely 고객은   :");
		for (int i = 0; i < C.length; i++) {
			System.out.println(LastL[i]);
		}
		System.out.println("Defect 고객은   :");
		for (int i = 0; i < C.length; i++) {
			System.out.println(LastD[i]);
		}
		// System.out.printf("%s %s %s\n",LastI[i],LastL[i],LastD[i]);

		
	}

}
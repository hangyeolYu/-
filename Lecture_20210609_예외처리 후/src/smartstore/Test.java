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

			printmenu();// ó�� ���̴� �޴�
			
			try {
				//-----------------------
			
			String customerData = input.nextLine();//next() ? 
			mainAsChange = customerData;
			 mainAs = Integer.parseInt(mainAsChange);
			 
			 //int() �� ������ �� ���� ���� ������ ���� ������ Ȯ�� �����ϳ� Ʈ����, 
			 //ĳġ�������� true ���� ������ �ֱ⿡ ���ݰ��� �ݺ����� ������ �������, 
			 //return ���� System.in�� �ܷ���  ���� ������ ������ �ȴ� . �� int ���� ������ �������������� 
			 //String ���� �Է��� �޾� ����ȯ���� int �� �ű�� return ���� ��Ʈ���� ������ ���� 
			 // ����ó���� ������ �ִ�! 
				
				
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
							else System.out.println("��ȿ���� ���� �� �Դϴ�! ");}
							}
						
						else if (setAs ==4) {break;}
						}
					
					
				} else if (mainAs == 2) {
					inset_cusnum();
					String changeTool = input.nextLine();
					 Customer.score = Integer.parseInt(changeTool);
					C = new Customer[Customer.score];
					
					if (C.length == 0 ) {
						System.out.println("���� 0�� �̹Ƿ� �����Ҽ� ����,");
						System.out.println("(�ý���)ó������ ���ư��ϴ�");
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
								System.out.printf("%d�� �� =%s\n", j + 1, C[j]);
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
					System.out.println("�߸��� ���Դϴ� ..!");
					continue;
				}
			}
			catch(Exception e) {
				e.getMessage();
				System.out.println("�����Դϴ� �� ���ư����� ");
			}
			
				
			
			
			
			

		}
		
		
		System.out.println("�ý��� ����~");
	}

	public static void printmenu() {
		System.out.println("========================");
		System.out.println("1.�⺻���� �Է��ϱ�");
		System.out.println("2.�� ������ �Է��ϱ�");
		System.out.println("3.������ �з� �������");
		System.out.println("4.����");
		System.out.println("========================");

		
	}

	public static void printsubmenu() {
		System.out.println("========================");
		System.out.println("1.������ �����ϱ�");
		System.out.println("2.���� ������ ��������");
		System.out.println("3.������ �����ϱ�");
		System.out.println("4.�ڷΰ���");
		System.out.println("========================");
	}
	
	
		

	public static void chosemenuShow() {

		System.out.println("**���� â�� ������ʹٸ� \"end\"��� �Է�����! ");
		System.out.println("�����(ideal, likely, defect)�� ����?");
		
	}

		
		public static void chosemenu_in() {

			System.out.println("========================");
			System.out.println("=======���ϴ� �� �Է�����!======");
			System.out.println("�ڷ� ���� �ʹٸ� \"5\"�� �Է� ����!");
			System.out.printf("1.Age\n 2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			

			
		}


	public static void show_set() {
		System.out.println("Ideal  =" + I.toString());
		System.out.println("Likely =" + L.toString());
		System.out.println("Defect =" + D.toString());
		
	}
	
	public static void inset_cusnum() {
		System.out.println("========������ �Է�â========");
		System.out.println("======����� ���� �ִ�??=======");
		System.out.println("���� �Է�      :");

	}
	
	public static void inputadd() {
		System.out.println("========================");
		System.out.println("1.�� ������ �����ϱ�");
		System.out.println("2.�� ������ ����");
		System.out.println("3.�� ������  �����ϱ�");
		System.out.println("4.�ڷΰ���");
		System.out.println("========================");

		
	}

	public static void setcudata() {
		for (int i = 0; i < Customer.score; i++) {
			System.out.printf("��   %d�� ���� �Է�: \n", i + 1);
			System.out.println("�����Է��� �Ϸ� �Ǿ����� \"5\"�Է����ּ���!");

			while (true) {
				System.out
						.printf("1.Age\n 2.gender(only male,female)" + "\n 3.location(only north,south)\n4.one_time\n");

				String changeTools = input.nextLine();
                int set = Integer.parseInt(changeTools);
				if (set == 1) {
					System.out.println("Age :�Է����ּ���!");
					C[i].Age = input.nextInt();
				}
				else if (set == 2) {
					System.out.println("gender:�Է����ּ���!");
					C[i].gender = input.next();
				}
				else if (set == 3) {
					System.out.println("location :�Է����ּ���!");
					C[i].location = input.next();
				}
				else if (set == 4) {
					System.out.println("one_time :�Է����ּ���!");
					C[i].one_time = input.nextInt();
				}
				else if (set == 5) {
					System.out.println("�Է�����!");
					break;
				}

			}
		}
		
	}

	

	public static void editcudata() {
		
			
		 if (Customer.score > 0) {
			System.out.println("����� �������� �����ұ��?     �Է�   :");
			people = input.nextInt();

			while (true) {
				System.out
						.printf("1.Age\n 2.gender(only male,female)" + "\n 3.location(only north,south)\n4.one_time\n");

				String changetooled= input.nextLine();
				int choose = Integer.parseInt(changetooled);
				if (choose == 1) {
					System.out.println("Age :�Է����ּ���!");
					C[people].Age = input.nextInt();
				}
				else if (choose == 2) {
					System.out.println("gender:�Է����ּ���!");
					C[people].gender = input.next();
				}
				else if (choose == 3) {
					System.out.println("location :�Է����ּ���!");
					C[people].location = input.next();
				}
				else if (choose == 4) {
					System.out.println("one_time :�Է����ּ���!");
					C[people].one_time = input.nextInt();
				}
				else if (choose == 5) {
					System.out.println("�Է�����!");
					break;
				}

			}

		}
		 else System.out.println("��ȿ�������� �� �Դϴ�!");
	}

	public static void summary() {// ī���� ����غ��� ��ĳ�� �ƿ� ��
		System.out.println("������ ������ �߽����� ���� �з��մϴ�!");
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
		System.out.println("ideal ��============likely ��=============defect �� ");
		System.out.println("ideal ����  :");
		for (int i = 0; i < C.length; i++) {
			System.out.println(LastI[i]);
		}
		System.out.println("likely ����   :");
		for (int i = 0; i < C.length; i++) {
			System.out.println(LastL[i]);
		}
		System.out.println("Defect ����   :");
		for (int i = 0; i < C.length; i++) {
			System.out.println(LastD[i]);
		}
		// System.out.printf("%s %s %s\n",LastI[i],LastL[i],LastD[i]);

		
	}

}
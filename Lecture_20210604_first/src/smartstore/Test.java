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
			
			 
		  printmenu();//ó�� ���̴� �޴� 
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
		System.out.println("�ý��� ����~");
		}
		
		
		
	
	
	
	public static void printmenu() {
		   System.out.println("========================");
		   System.out.println("1.�⺻���� �Է��ϱ�");
		   System.out.println("2.�� ������ �Է��ϱ�");
		   System.out.println("3.������ �з� �������");
		   System.out.println("4.����");
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
			   System.out.println("����...����!"+e.getMessage());
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
		   System.out.println("1.������ �����ϱ�");
		   System.out.println("2.���� ������ ��������");
		   System.out.println("3.������ �����ϱ�");
		   System.out.println("4.�ڷΰ���");
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

				System.out.println("**���� â�� ������ʹٸ� \"end\"��� �Է�����! " );
				System.out.println("�����(ideal, likely, defect)�� ����?");
				str1 = input.next();
				
				chosemenu_in ();
	}
  public static void chosemenu_in () {
	  if (mainAs==2) {
		  System.out.println("========������ �Է�â========");
		  System.out.println("======����� ���� �ִ�??=======");
		  System.out.println("���� �Է�      :");
		  Customer.score = input.nextInt();
		   C = new Customer [Customer.score];
		   for(int i = 0 ; i < C.length; i++) {
			   C[i] = new Customer();
		   }
		   
			 inputadd ();
			
	  }
	  if(str1.equals("ideal")) {
			System.out.println("========================");
			System.out.println("=======���ϴ� �� �Է�����!======");
			System.out.println("�ڷ� ���� �ʹٸ� \"5\"�� �Է� ����!");
			System.out.printf("1.Age\n 2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			 setInfo =input.nextInt();
			 
			 inputset ();
	  }
	  
	  if(str1.equals("likely")) {
			System.out.println("========================");
			System.out.println("=======���ϴ� �� �Է�����!======");
			System.out.println("�ڷ� ���� �ʹٸ� \"5\"�� �Է� ����!");
			System.out.printf("1.Age\n 2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			 setInfo =input.nextInt();
			 
			 inputset ();
	  }
	  
	  if(str1.equals("defect")) {
			System.out.println("========================");
			System.out.println("=======���ϴ� �� �Է�����!======");
			System.out.println("�ڷ� ���� �ʹٸ� \"5\"�� �Է� ����!");
			System.out.printf("1. age \n2.gender(only male,female)\n 3.location(only north,south)\n4.one_time\n");
			 setInfo =input.nextInt();
			
			 	
			 inputset ();
	  }
	  
	  
  }
	
  public static void inputset () {
	  
		if (setInfo ==1) {
			System.out.println("������ �Է����ּ���!");
		int information = input.nextInt();
		if(str1.equals("ideal"))I.Age = information;
		if(str1.equals("likely"))L.Age = information;
		if(str1.equals("defect"))D.Age = information;
		chosemenu_in ();
		}
		
		if (setInfo==2) {
			System.out.println("������ �Է����ּ���!");
			String strinfo = input.next();
			if(str1.equals("ideal"))I.gender = strinfo;
			if(str1.equals("likely"))L.gender = strinfo;
			if(str1.equals("defect"))D.gender = strinfo;
			chosemenu_in ();
		}
		
		if (setInfo ==3) {
			System.out.println("������ �Է����ּ���!");
		String strinfo = input.next();
		if(str1.equals("ideal"))I.location = strinfo;
		if(str1.equals("likely"))L.location= strinfo;
		if(str1.equals("defect"))D.location = strinfo;
		chosemenu_in ();
		}
		
		if (setInfo ==4) {
			System.out.println("������ �Է����ּ���!");
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
		   System.out.println("1.�� ������ �����ϱ�");
		   System.out.println("2.�� ������ ����");
		   System.out.println("3.�� ������  �����ϱ�");
		   System.out.println("4.�ڷΰ���");
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
			System.out.printf("��   %d�� ���� �Է�: \n",i+1);
			System.out.println("�����Է��� �Ϸ� �Ǿ����� \"5\"�Է����ּ���!");
			
			
				while (true) {
					System.out.printf("1.Age\n 2.gender(only male,female)"
							+ "\n 3.location(only north,south)\n4.one_time\n");
					
					int set = input.nextInt();
				
					if(set==1) {
						System.out.println("Age :�Է����ּ���!");
						C[i].Age=input.nextInt();
					}
					if(set==2) {
						System.out.println("gender:�Է����ּ���!");
						C[i].gender=input.next();
				}
					if(set==3) {
						System.out.println("location :�Է����ּ���!");
						C[i].location=input.next();
			}
					if(set==4) {
						System.out.println("one_time :�Է����ּ���!");
						C[i].one_time=input.nextInt();
			}
					if (set==5) {
						System.out.println("�Է�����!");
						break;
					}
		
				}
				}
	                                          	inputadd ();
	    		}
	
				public static void seecudata () {
		   for (int i = 0; i < C.length; i ++) {
			   System.out.printf("%d�� �� =%s\n",i+1,C[i]);
			  
		   } 
		   inputadd ();
		
	
	}
	
				   public static void editcudata () {
					   if (Customer.score == 0) {
						   System.out.println("���� 0�� �̹Ƿ� �����Ҽ� ����,");
						   System.out.println("(�ý���)ó������ ���ư��ϴ�");
				
						   printmenu();
					   }
					   else if (Customer.score >0) {
						   System.out.println("����� �������� �����ұ��?     �Է�   :");
						   people = input.nextInt();
						   
						   while (true) {
								System.out.printf("1.Age\n 2.gender(only male,female)"
										+ "\n 3.location(only north,south)\n4.one_time\n");
								
								int p = input.nextInt();
							
								if(p==1) {
									System.out.println("Age :�Է����ּ���!");
									C[people].Age=input.nextInt();
								}
								if(p==2) {
									System.out.println("gender:�Է����ּ���!");
									C[people].gender=input.next();
							}
								if(p==3) {
									System.out.println("location :�Է����ּ���!");
									C[people].location=input.next();
						}
								if(p==4) {
									System.out.println("one_time :�Է����ּ���!");
									C[people].one_time=input.nextInt();
						}
								if (p==5) {
									System.out.println("�Է�����!");
									break;
								}
					
							}
						   
						   
					   }
					   inputadd ();
				   }
	
				  public static void summary() {//ī���� ����غ��� ��ĳ�� �ƿ� ��
					  System.out.println("������ ������ �߽����� ���� �з��մϴ�!");
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
					  System.out.println("ideal ��============likely ��=============defect �� ");
					  System.out.println("ideal ����  :");
					         for(int i = 0; i < C.length; i++){
					        	 System.out.println(LastI[i]);
					         }
					         System.out.println("likely ����   :");
					         for(int i = 0; i < C.length; i++){
					        	 System.out.println(LastL[i]);
					         }
					         System.out.println("Defect ����   :");
					         for(int i = 0; i < C.length; i++){
					        	 System.out.println(LastD[i]);
					         }
					  //System.out.printf("%s %s %s\n",LastI[i],LastL[i],LastD[i]);
					         
					         printmenu();
				  }
	
	
	
	
	
	
}
package com.big2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ��ü�� ��������� �������� �����⸸ ��������(�θ��� ������ �������� x)-> �ϳ��� ��ü�� ����ϱ⶧���� �ڿ� �̿� ȿ�� ����
 * Static ������ �̿��ؼ� ����
 */

public class SingletonTest { 

	private static SingletonTest st; //ĸ��ȭ(Encapsulation)
	Scanner sc = new Scanner(System.in); //���������� scanner ���� -> sc ��ü �������� Ȱ��
	
	public static SingletonTest getInstance(){ //��ü ���� �ʿ���� �޼ҵ�
		if(st == null){ //��ü�� ����������� ������ ��ü�� �����, �ϳ��� ��ü�� ������
			st = new SingletonTest();
		}
		
		return st;
	}//getInstance
	
	/*
	 * returnScan : 
	 * - ���ڿ��� �Է¹���
	 */
	public void returnScan(){
		
		System.out.print("���� �������� �ƹ�Ű�� �Է��ϼ��� : ");
		sc.nextLine();
		
	}//returnScan
	/*
	 * returnOption :
	 * - ���ڰ��� �Է¹���
	 */
	public int returnOption(){

		return Integer.parseInt(sc.nextLine());
		
		/* nextInt ���� ���ǻ��� :
		 * nextInt�� ���� �ϳ��� �޾ƿ� -> enter���� ���� �Է��ϰ� �Ǹ� ���� nextLine����� enter('\n')�� �Բ� �޾ƿ��� �� 
		 * Solution is below..
		*/
		/*
		int a = sc.nextInt();
		sc.nextLine();
		return a;
		 */	
	}//returnOption
	
	/*
	 * setKeyValue :
	 * - ���� �� ������ 0~28������ key���� ������, ���� �� ������ value�ν� ���� �̵� ������ ��ο� ���� ������ ArrayList�� ����
	 */
	public void setKeyValue(ArrayList<Integer> temp, int i){
		
		if(!(i == 5 || i == 10 || i == 19 || i == 22 || i == 24 || i == 26 || i == 28)){
			temp.add(i+1);
		}
		else if (i == 5){
			temp.add(i+1);
			temp.add(20);
		}
		else if(i == 10){
			temp.add(i+1);
			temp.add(25);
		}
		else if(i == 19 || i == 28){
			temp.add(0);
		}
		else if(i == 22){
			temp.add(i+1);
			temp.add(27);
		}
		else if(i == 24){
			temp.add(15);
		}
		else if(i == 26){
			temp.add(22);
		}
		else{
			temp.add(0);
		}
	}//setKeyValue
	
	/*
	 * getPlayerInfo :
	 * - user�κ��� ������ �޾ƿ� player map�� ����
	 * - "player" map : name, marker, current location 
	 */
	public int getPlayerInfo(HashMap<String, Object> player, int number, int selected){
		
		int select;
		
		String s = null;
		int current = 0;
			
			
		System.out.print("Player" + number + " �̸��� �Է����ּ���:");
		s = sc.nextLine();
		player.put("ename", s);
			
			
		boolean chk = true;
		while(chk){
			System.out.println("� ���� �����Ͻðڽ��ϱ�?");
			System.out.println("1. ��\t 2. ��\t 3. ��\t 4. ��");
			select = Integer.parseInt(sc.nextLine());
				
			if(select == selected){
				System.out.println("�̹� ���õ� ���Դϴ�. �ٽ� �������ּ���.");
			}//if
			
			else{
			
				switch(select){
					case 1:
						s = "��\t";
						selected = 1;
						chk = false;
						break;
					case 2:
						s = "��\t";
						selected = 2;
						chk = false;
						break;
					case 3:
						s = "��\t";
						selected = 3;
						chk = false;
						break;
					case 4:
						s = "��\t";
						selected = 4;
						chk = false;
						break;
					default:
						System.out.println("1~4 ������ ���ڸ� �Է����ּ���.");
						break;
				}//switch
				
				player.put("emarker", s); //marker ������ player map�� �ִ´�
			}//else
	
		}//while
		
		player.put("ecur", current);
			
	return selected;	
		
	}//getPlayerInfo

}//SingletonTest


package com.big2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 객체가 만들어지기 전까지는 껍데기만 남아있음(부르기 전까지 공간차지 x)-> 하나의 객체만 사용하기때문에 자원 이용 효율 증가
 * Static 변수를 이용해서 만듬
 */

public class SingletonTest { 

	private static SingletonTest st; //캡슐화(Encapsulation)
	Scanner sc = new Scanner(System.in); //전역변수로 scanner 생성 -> sc 객체 공통으로 활용
	
	public static SingletonTest getInstance(){ //객체 생성 필요없는 메소드
		if(st == null){ //객체가 만들어져있지 않으면 객체를 만들고, 하나의 객체를 돌려씀
			st = new SingletonTest();
		}
		
		return st;
	}//getInstance
	
	/*
	 * returnScan : 
	 * - 문자열을 입력받음
	 */
	public void returnScan(){
		
		System.out.print("윷을 던지려면 아무키나 입력하세요 : ");
		sc.nextLine();
		
	}//returnScan
	/*
	 * returnOption :
	 * - 숫자값을 입력받음
	 */
	public int returnOption(){

		return Integer.parseInt(sc.nextLine());
		
		/* nextInt 사용시 주의사항 :
		 * nextInt는 숫자 하나만 받아옴 -> enter까지 같이 입력하게 되면 다음 nextLine실행시 enter('\n')을 함께 받아오게 됨 
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
	 * - 판의 각 지점은 0~28까지의 key값을 가지며, 판의 각 지점당 value로써 다음 이동 가능한 경로에 대한 정보를 ArrayList로 가짐
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
	 * - user로부터 정보를 받아와 player map에 넣음
	 * - "player" map : name, marker, current location 
	 */
	public int getPlayerInfo(HashMap<String, Object> player, int number, int selected){
		
		int select;
		
		String s = null;
		int current = 0;
			
			
		System.out.print("Player" + number + " 이름을 입력해주세요:");
		s = sc.nextLine();
		player.put("ename", s);
			
			
		boolean chk = true;
		while(chk){
			System.out.println("어떤 말을 선택하시겠습니까?");
			System.out.println("1. ●\t 2. ◆\t 3. ■\t 4. ▲");
			select = Integer.parseInt(sc.nextLine());
				
			if(select == selected){
				System.out.println("이미 선택된 말입니다. 다시 선택해주세요.");
			}//if
			
			else{
			
				switch(select){
					case 1:
						s = "●\t";
						selected = 1;
						chk = false;
						break;
					case 2:
						s = "◆\t";
						selected = 2;
						chk = false;
						break;
					case 3:
						s = "■\t";
						selected = 3;
						chk = false;
						break;
					case 4:
						s = "▲\t";
						selected = 4;
						chk = false;
						break;
					default:
						System.out.println("1~4 사이의 숫자만 입력해주세요.");
						break;
				}//switch
				
				player.put("emarker", s); //marker 정보를 player map에 넣는다
			}//else
	
		}//while
		
		player.put("ecur", current);
			
	return selected;	
		
	}//getPlayerInfo

}//SingletonTest


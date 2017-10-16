package com.big2;

import java.util.ArrayList;
import java.util.HashMap;

public class Testm {

	public static void main(String[] args) {


		Board b = new Board();

		int current1 = 0;
		int current2 = 0;
		
		int count1 = 0;
		int count2 = 0;
		
		/*Description
		 * map : 판의 각 지점은 0~28까지의 key값을 가지며, 각 지점당 value로 다음 이동 가능한 경로에 대한 정보를 ArrayList로 가지고 있음 
		 * result : 윷을 던진 결과, 그 결과에 대한 이동횟수 정보가 ArrayList에 담겨있음
		 * players : 리스트에는 각 player의 이름과 선택한 말, 그리고 현재 위치(current)에 대한 정보가 map으로 들어있음(key: ename, emarker, ecur)
		 */
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(); 
		ArrayList<Integer> result = new ArrayList<Integer>();	
		ArrayList<HashMap<String, Object>> players = new ArrayList<HashMap<String, Object>>();
		
		SingletonTest st = SingletonTest.getInstance();

		/* Each one has its own location & possible next way to go*/
		//get key and value 
		for(int i = 0; i<29 ; i++){
					ArrayList<Integer> temp = new ArrayList<Integer>(); //temp: 다음 이동 가능한 경로들을 가지고 있음
					st.setKeyValue(temp, i);
					map.put(i, temp);				
				}

		
		//map printout test
		/*
		for(int i = 0; i < map.size(); i ++){
		for(int j = 0; j < map.get(i).size(); j ++){
			System.out.println("시작 값 : " + i + "\t다음 값 : " + map.get(i).get(j));	
			}//for
		}//for
		*/ 
		
		
		int selected = 0;
		//players 리스트에는 각 player의 이름과 선택한 말, current 위치 정보가 map으로 들어있음(key: ename, emarker, ecur)
		for(int i = 0 ; i < 2; i++){
			HashMap<String, Object> player = new HashMap<String, Object>();
			selected = st.getPlayerInfo(player, i+1, selected);
			players.add(player);
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("\t         <Players' Info>");
		//player Info printout test
		for(int i = 0; i < players.size(); i++){
			System.out.println("player 이름 : " + players.get(i).get("ename") + "\t/ marker : " + players.get(i).get("emarker") + " / current :" + players.get(i).get("ecur"));			
		}
		System.out.println("-------------------------------------------------");

		
		
		Yut y = new Yut();
		
		//	boolean flag = true;
		b.initBoard(); //initialize board
		b.printBoard(); //print board



		while(true){
			System.out.println("========================================================");
			System.out.println("-------------->" + players.get(0).get("ename") + "님의 차례입니다.");
			
			
			current1 = y.cast(st, map, players, result, count1, 0);
			count1++;
			
			if(current1 == current2){ //player2가 잡혔을 때
				System.out.println("!! " + players.get(1).get("ename") + "님이 잡히셨습니다. 출발점으로 돌아갑니다.");
				System.out.println("========================================================");

				players.get(1).put("ecur", 0);//player2 current 초기화 -> 맵에 저장
				current2 = 0; //player2 current 초기화 
				count2 = 0; //player2의 count 초기화
				b.changeBoard(players);
				
				//player1이 다시던짐-recast
				System.out.println("========================================================");
				System.out.println("-------------->" + players.get(0).get("ename") + "님이 다시 던집니다.");
				
				current1 = y.cast(st, map, players, result, count1, 0);
				b.changeBoard(players);
				count1++;
				
				System.out.println("========================================================");
				System.out.println("-------------->" + players.get(1).get("ename") + "님의 차례입니다.");
				current2 = y.cast(st, map, players, result, count2, 1);
				count2++;
				
				if(current1 == current2){
					System.out.println("!! " + players.get(0).get("ename") + "님이 잡히셨습니다. 출발점으로 돌아갑니다.");
					System.out.println("========================================================");
					players.get(0).put("ecur", 0);//player1 current 초기화 -> map에 저장
					current1 = 0;//player1 current 초기화
					count1 = 0; //player1 count 초기화
					b.changeBoard(players);
					
					//player2가 다시던짐-recast
					System.out.println("========================================================");
					System.out.println("-------------->" + players.get(1).get("ename") + "님이 다시 던집니다.");
					
					current2 = y.cast(st, map, players, result, count2, 1);
					
					b.changeBoard(players);
					count2++;
				}//if
				else if(current2 == -1){
					//b.changeBoard(players);
					System.out.println("축하합니다! 도착점에 오셨습니다!");
					System.out.println("Winner : " + players.get(1).get("ename") + "님 / " +  "Loser : " + players.get(0).get("ename") + "님");
					System.out.println("========================================================");

					break;					
				}//else if
				else{
					b.changeBoard(players);
				}//else
				
				
			}
			else if(current1 == -1){
				System.out.println("축하합니다! 도착점에 오셨습니다!");
				System.out.println("Winner : " + players.get(0).get("ename") + "님 / " +  "Loser : " + players.get(1).get("ename") + "님");
				System.out.println("========================================================");
				break;
			}
			else{
				b.changeBoard(players);
				System.out.println("========================================================");
				System.out.println("-------------->" + players.get(1).get("ename") + "님의 차례입니다.");
				
				current2 = y.cast(st, map, players, result, count2, 1);

				count2++;
				
				if(current1 == current2){
					System.out.println("!! " + players.get(0).get("ename") + "님이 잡히셨습니다. 출발점으로 돌아갑니다.");
					System.out.println("========================================================");
					players.get(0).put("ecur", 0);//player1 초기화
					current1 = 0;//player1 초기화
					count1 = 0;
					b.changeBoard(players);	
					
					//player2가 다시던짐-recast
					System.out.println("========================================================");
					System.out.println("-------------->" + players.get(1).get("ename") + "님이 다시 던집니다.");
					
					current2 = y.cast(st, map, players, result, count2, 1);

					b.changeBoard(players);
					count2++;
				}//if
				else if(current2 == -1){
					System.out.println("축하합니다! 도착점에 오셨습니다!");
					System.out.println("Winner : " + players.get(1).get("ename") + "님 / " +  "Loser : " + players.get(0).get("ename") + "님");
					System.out.println("========================================================");
					break;					
				}//else if
				else{
					b.changeBoard(players);
				}
				
			}
			
		}//while
		
	}
}

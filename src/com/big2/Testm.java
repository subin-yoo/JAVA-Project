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
		 * map : ���� �� ������ 0~28������ key���� ������, �� ������ value�� ���� �̵� ������ ��ο� ���� ������ ArrayList�� ������ ���� 
		 * result : ���� ���� ���, �� ����� ���� �̵�Ƚ�� ������ ArrayList�� �������
		 * players : ����Ʈ���� �� player�� �̸��� ������ ��, �׸��� ���� ��ġ(current)�� ���� ������ map���� �������(key: ename, emarker, ecur)
		 */
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(); 
		ArrayList<Integer> result = new ArrayList<Integer>();	
		ArrayList<HashMap<String, Object>> players = new ArrayList<HashMap<String, Object>>();
		
		SingletonTest st = SingletonTest.getInstance();

		/* Each one has its own location & possible next way to go*/
		//get key and value 
		for(int i = 0; i<29 ; i++){
					ArrayList<Integer> temp = new ArrayList<Integer>(); //temp: ���� �̵� ������ ��ε��� ������ ����
					st.setKeyValue(temp, i);
					map.put(i, temp);				
				}

		
		//map printout test
		/*
		for(int i = 0; i < map.size(); i ++){
		for(int j = 0; j < map.get(i).size(); j ++){
			System.out.println("���� �� : " + i + "\t���� �� : " + map.get(i).get(j));	
			}//for
		}//for
		*/ 
		
		
		int selected = 0;
		//players ����Ʈ���� �� player�� �̸��� ������ ��, current ��ġ ������ map���� �������(key: ename, emarker, ecur)
		for(int i = 0 ; i < 2; i++){
			HashMap<String, Object> player = new HashMap<String, Object>();
			selected = st.getPlayerInfo(player, i+1, selected);
			players.add(player);
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("\t         <Players' Info>");
		//player Info printout test
		for(int i = 0; i < players.size(); i++){
			System.out.println("player �̸� : " + players.get(i).get("ename") + "\t/ marker : " + players.get(i).get("emarker") + " / current :" + players.get(i).get("ecur"));			
		}
		System.out.println("-------------------------------------------------");

		
		
		Yut y = new Yut();
		
		//	boolean flag = true;
		b.initBoard(); //initialize board
		b.printBoard(); //print board



		while(true){
			System.out.println("========================================================");
			System.out.println("-------------->" + players.get(0).get("ename") + "���� �����Դϴ�.");
			
			
			current1 = y.cast(st, map, players, result, count1, 0);
			count1++;
			
			if(current1 == current2){ //player2�� ������ ��
				System.out.println("!! " + players.get(1).get("ename") + "���� �����̽��ϴ�. ��������� ���ư��ϴ�.");
				System.out.println("========================================================");

				players.get(1).put("ecur", 0);//player2 current �ʱ�ȭ -> �ʿ� ����
				current2 = 0; //player2 current �ʱ�ȭ 
				count2 = 0; //player2�� count �ʱ�ȭ
				b.changeBoard(players);
				
				//player1�� �ٽô���-recast
				System.out.println("========================================================");
				System.out.println("-------------->" + players.get(0).get("ename") + "���� �ٽ� �����ϴ�.");
				
				current1 = y.cast(st, map, players, result, count1, 0);
				b.changeBoard(players);
				count1++;
				
				System.out.println("========================================================");
				System.out.println("-------------->" + players.get(1).get("ename") + "���� �����Դϴ�.");
				current2 = y.cast(st, map, players, result, count2, 1);
				count2++;
				
				if(current1 == current2){
					System.out.println("!! " + players.get(0).get("ename") + "���� �����̽��ϴ�. ��������� ���ư��ϴ�.");
					System.out.println("========================================================");
					players.get(0).put("ecur", 0);//player1 current �ʱ�ȭ -> map�� ����
					current1 = 0;//player1 current �ʱ�ȭ
					count1 = 0; //player1 count �ʱ�ȭ
					b.changeBoard(players);
					
					//player2�� �ٽô���-recast
					System.out.println("========================================================");
					System.out.println("-------------->" + players.get(1).get("ename") + "���� �ٽ� �����ϴ�.");
					
					current2 = y.cast(st, map, players, result, count2, 1);
					
					b.changeBoard(players);
					count2++;
				}//if
				else if(current2 == -1){
					//b.changeBoard(players);
					System.out.println("�����մϴ�! �������� ���̽��ϴ�!");
					System.out.println("Winner : " + players.get(1).get("ename") + "�� / " +  "Loser : " + players.get(0).get("ename") + "��");
					System.out.println("========================================================");

					break;					
				}//else if
				else{
					b.changeBoard(players);
				}//else
				
				
			}
			else if(current1 == -1){
				System.out.println("�����մϴ�! �������� ���̽��ϴ�!");
				System.out.println("Winner : " + players.get(0).get("ename") + "�� / " +  "Loser : " + players.get(1).get("ename") + "��");
				System.out.println("========================================================");
				break;
			}
			else{
				b.changeBoard(players);
				System.out.println("========================================================");
				System.out.println("-------------->" + players.get(1).get("ename") + "���� �����Դϴ�.");
				
				current2 = y.cast(st, map, players, result, count2, 1);

				count2++;
				
				if(current1 == current2){
					System.out.println("!! " + players.get(0).get("ename") + "���� �����̽��ϴ�. ��������� ���ư��ϴ�.");
					System.out.println("========================================================");
					players.get(0).put("ecur", 0);//player1 �ʱ�ȭ
					current1 = 0;//player1 �ʱ�ȭ
					count1 = 0;
					b.changeBoard(players);	
					
					//player2�� �ٽô���-recast
					System.out.println("========================================================");
					System.out.println("-------------->" + players.get(1).get("ename") + "���� �ٽ� �����ϴ�.");
					
					current2 = y.cast(st, map, players, result, count2, 1);

					b.changeBoard(players);
					count2++;
				}//if
				else if(current2 == -1){
					System.out.println("�����մϴ�! �������� ���̽��ϴ�!");
					System.out.println("Winner : " + players.get(1).get("ename") + "�� / " +  "Loser : " + players.get(0).get("ename") + "��");
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

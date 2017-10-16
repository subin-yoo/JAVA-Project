package com.big2;

import java.util.ArrayList;
import java.util.HashMap;

public class Yut {
	
	/* 
	 * castYutStick :
	 * - Computer generates random number between 0 and 15.
	 * - 0: �� / 1~4: �� / 5~10: �� / 11~14: �� / 15: �� 
	 * - Generating random number 0 and 15 has low probability.
	 * - add cast result into result ArrayList 
	 */
	public void castYutStick(ArrayList<Integer> result){
		
		int yut;
		int count;
		
		double d = Math.random() * 15; // Generate new random number btw 0 and 15
		yut = (int)Math.round(d); // random # btw 0 & 15
					
		if((yut == 0) || (yut == 15)){ //in case of "��" or "��", re-cast
			castYutStick(result);
		}//if
		
		count = castResult(yut);
		result.add(0, count); //cast ����� ArrayList�� ����
		
		//return count;
		
	}//castYutStick
	

	/*
	 * castResult :
	 * - �̵�Ƚ�� return
	 */
	private int castResult(int yut){
		
		int count;
		
		switch (yut){
		case 1://��
			count = 1;
			break;
		case 2://��
			count = 1;
			break;
		case 3://��
			count = 1;
			break;
		case 4://��
			count = 1;
			break;
		case 5://��
			count = 2;
			break;
		case 6://��
			count = 2;
			break;
		case 7://��
			count = 2;
			break;
		case 8://��
			count = 2;
			break;
		case 9://��
			count = 2;
			break;
		case 10://��
			count = 2;
			break;
		case 11://��
			count = 3;
			break;
		case 12://��
			count = 3;
			break;
		case 13://��
			count = 3;
			break;
		case 14://��
			count = 3;
			break;
		case 15://��
			count = 4;
			break;
		default: //�� -yut(random number) = 0 
			count = 5;
			break;
		}//switch
		
		return count;
	}//castResult
	
	/*
	 * printCastResult :
	 * - Print cast result
	 */
	public void printCastResult(ArrayList<Integer> result){
		//���
		System.out.print("�����\t");
		for(int i = 0; i< result.size(); i++){
			switch(result.get(i)){
			case 1:
				System.out.print("��\t");
				break;
			case 2:
				System.out.print("��\t");
				break;
			case 3:
				System.out.print("��\t");
				break;
			case 4:
				System.out.print("��\t");
				break;
			default:
				System.out.print("��\t");
				break;
			}//switch
		}//for
		System.out.println('\n');
	}//printCastResult
	
	/*
	 * goBlock :
	 * -
	 */
	public int goBlock(HashMap<Integer, ArrayList<Integer>> map, ArrayList<Integer> result, int current, int count){
		
		Go g = new Go();
		current = g.moveMarker(map, result, current, count);
		result.clear();		
		
		return current;
	}//goBlock
	
	/*
	 * cast :
	 * - Each player cats Yut 
	 * - cast result�� �޾ƿ� ���� ������
	 * - return player marker's current location
	 */
	public int cast(SingletonTest st, HashMap<Integer, ArrayList<Integer>> map, ArrayList<HashMap<String, Object>> players, ArrayList<Integer> result, int count, int index){
		
		int current;
		
		st.returnScan();
		castYutStick(result);
		printCastResult(result);
		current = goBlock(map, result, (Integer)players.get(index).get("ecur"), count);
		players.get(index).put("ecur", current);
		System.out.print("------------------------> ");
		System.out.println("���� " + players.get(index).get("ename")+ "���� ���� ��ġ��\t" + players.get(index).get("ecur") + " �Դϴ�");
		System.out.println("========================================================");
		
		return current;
	}//cast

}//Yut

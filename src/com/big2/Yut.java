package com.big2;

import java.util.ArrayList;
import java.util.HashMap;

public class Yut {
	
	/* 
	 * castYutStick :
	 * - Computer generates random number between 0 and 15.
	 * - 0: 모 / 1~4: 도 / 5~10: 개 / 11~14: 걸 / 15: 윷 
	 * - Generating random number 0 and 15 has low probability.
	 * - add cast result into result ArrayList 
	 */
	public void castYutStick(ArrayList<Integer> result){
		
		int yut;
		int count;
		
		double d = Math.random() * 15; // Generate new random number btw 0 and 15
		yut = (int)Math.round(d); // random # btw 0 & 15
					
		if((yut == 0) || (yut == 15)){ //in case of "윷" or "모", re-cast
			castYutStick(result);
		}//if
		
		count = castResult(yut);
		result.add(0, count); //cast 결과를 ArrayList에 저장
		
		//return count;
		
	}//castYutStick
	

	/*
	 * castResult :
	 * - 이동횟수 return
	 */
	private int castResult(int yut){
		
		int count;
		
		switch (yut){
		case 1://도
			count = 1;
			break;
		case 2://도
			count = 1;
			break;
		case 3://도
			count = 1;
			break;
		case 4://도
			count = 1;
			break;
		case 5://개
			count = 2;
			break;
		case 6://개
			count = 2;
			break;
		case 7://개
			count = 2;
			break;
		case 8://개
			count = 2;
			break;
		case 9://개
			count = 2;
			break;
		case 10://개
			count = 2;
			break;
		case 11://걸
			count = 3;
			break;
		case 12://걸
			count = 3;
			break;
		case 13://걸
			count = 3;
			break;
		case 14://걸
			count = 3;
			break;
		case 15://윷
			count = 4;
			break;
		default: //모 -yut(random number) = 0 
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
		//출력
		System.out.print("결과는\t");
		for(int i = 0; i< result.size(); i++){
			switch(result.get(i)){
			case 1:
				System.out.print("도\t");
				break;
			case 2:
				System.out.print("개\t");
				break;
			case 3:
				System.out.print("걸\t");
				break;
			case 4:
				System.out.print("윷\t");
				break;
			default:
				System.out.print("모\t");
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
	 * - cast result를 받아와 말을 움직임
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
		System.out.println("현재 " + players.get(index).get("ename")+ "님의 말의 위치는\t" + players.get(index).get("ecur") + " 입니다");
		System.out.println("========================================================");
		
		return current;
	}//cast

}//Yut

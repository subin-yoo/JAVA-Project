package com.big2;

import java.util.ArrayList;
import java.util.HashMap;

public class Go {

	SingletonTest st = SingletonTest.getInstance();
	
	/*
	 * moveMarker:
	 * - 현재 말이 분기점에 위치해있는지 check -> 숙일 것인지 돌아갈 것인지 user의 선택을 받아옴
	 * - 윷을 던진 결과에 따라 현재 위치에서 분기점으로 갈 수 있는 경우가 있는지 check -> 숙일 것인지 돌아갈 것인지 user의 선택을 받아옴
	 * - marker를 움직이고 난 후의 current 위치를 return
	 */

	public int moveMarker (HashMap<Integer, ArrayList<Integer>> map, ArrayList<Integer> result, int current, int count){
		
		int next = -1;
		int chksize = result.size();
		
			
		
			if(map.get(current).size() == 2){ //현재 말의 위치가 분기점일때
				boolean chk = true;
				while(chk){
					System.out.println("숙이시겠습니까? 돌아가시겠습니까?\t 1. 숙인다\t 2. 돌아간다\t");
					
					switch(st.returnOption()){
				
					case 1: //숙이는 경우
						next = map.get(current).get(1);
						chk = false;
						break;
					case 2: //돌아가는 경우
						next = map.get(current).get(0);
						chk = false;
						break;
					default:
						System.out.println("다시 입력해주세요...");
						break;
					}//switch
				}//while
			}//if
			
						
			while(!(chksize == 0)){ //분기점으로 갈 수 있는 경우가 있는지 check
				if((current == 0) && (count > 0)){ // 말이 한 바퀴 돌아 current 위치가 0일때 어떤 윷놀이 결과가 나오든 다음에 나가기 위한 처리
					return -1;
				}
				
				int prvnext = next;
				next = move(map, current, result.get(0),next); // 말이 다음 위치할 수 있는 곳 예상
				
				if(next == -1){ //말이 한 바퀴 돌아 나가기 위한 처리
					return -1;
				}
				
				if(map.get(next).size() == 2 && result.size() > 1 ){ // 2가지 경로를 갖거나 / result list에 2개 이상의 element가 남아있다면
					
						boolean chk = true;
					
						while(chk){
							System.out.println("숙이시겠습니까? 돌아가시겠습니까?\t 1. 숙인다\t 2. 돌아간다\t");
							switch(st.returnOption()){
					
							case 1: //숙이는 경우 -> current와 next 상태를 바꿔준다(움직이고 난 후) - 이미 판단 완료
								current = next;
								next = map.get(current).get(1);
								result.remove(0); //해당 결과를 지움
								chk = false;
								break;
							case 2: //돌아가는 경우 -> current와 next 상태를 바꿔준다(움직이고 난 후) - 이미 판단 완료
								current = next;
								next = map.get(current).get(0);
								result.remove(0); //해당 결과를 지움
								chk = false;
								break;
							default:
								System.out.println("다시 입력해주세요...");
								break;
							}//switch
						}//while
					
					
					}//if
					else{ //map.get(next).size() == 1 : 1가지 경로를 갖거나 / result list에 1개 이하의 element가 남아있다면/ 경로가 결정되지 않았다면? 
						int temp = result.get(0); //해당 윷놀이 결과를 맨뒤로 보낸다 -> 숙일 수 있는 가능성이 있는 윷놀이 결과가 있는지 살펴보기 위해
						result.add(temp);
						result.remove(0);

						next = prvnext; //22번 위치에서의 문제점 해결
					
					}//else
				
					chksize--; //검사를 완료하면 count 1 감소
				}//while

		
		int sum = 0;
		
		if(!(current == 5 || current == 10 || current == 22)){ //current가 5, 10, 22일때는 이미 다음 next 정보를 가지고 있음 -> 이동하고 난 후
			next = -1; //next값 초기화			
		}
		
		
		for(int i = 0; i< result.size(); i ++){ // 분기점에서 선택한 결과를 처리하고 난 후의 result list에 남아있는 윷놀이 결과를 모두 더해  새로운 current 위치를 얻음
			sum += result.get(i);
		}
		
		current = move(map, current, sum, next);
		return current;
	}//moveMarker
	
	
	/*
	 * move:
	 * - 현재 말의 current 위치 정보를 받아와 새로운 다음 말의 위치 정보를 얻음
	 * - 말이 움직이고 난 후의 current 위치 정보 return
	 */
	public int move(HashMap<Integer, ArrayList<Integer>> map, int current, int count, int next){
		
		int prev = current; 
				
		while(!(count == 0)){
			if(!(next == -1)){
				count--;
				
				prev = current;
				
				current = next;
				
				if((current == 0) && (count != 0)){
					return -1;
				}//if
			}//if
			
			if(prev == 26){ //말의 위치가 ↘ 방향에서 오는 경우의 처리 -> 22의 다음 위치는 27
				next = map.get(current).get(1);
			}
			else{
				next = map.get(current).get(0); //새로운 다음 말의 위치를 얻는다				
			}
		}//while
		
		return current;
	}//move
			
}//Go


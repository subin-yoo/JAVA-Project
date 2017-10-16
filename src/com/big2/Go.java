package com.big2;

import java.util.ArrayList;
import java.util.HashMap;

public class Go {

	SingletonTest st = SingletonTest.getInstance();
	
	/*
	 * moveMarker:
	 * - ���� ���� �б����� ��ġ���ִ��� check -> ���� ������ ���ư� ������ user�� ������ �޾ƿ�
	 * - ���� ���� ����� ���� ���� ��ġ���� �б������� �� �� �ִ� ��찡 �ִ��� check -> ���� ������ ���ư� ������ user�� ������ �޾ƿ�
	 * - marker�� �����̰� �� ���� current ��ġ�� return
	 */

	public int moveMarker (HashMap<Integer, ArrayList<Integer>> map, ArrayList<Integer> result, int current, int count){
		
		int next = -1;
		int chksize = result.size();
		
			
		
			if(map.get(current).size() == 2){ //���� ���� ��ġ�� �б����϶�
				boolean chk = true;
				while(chk){
					System.out.println("���̽ðڽ��ϱ�? ���ư��ðڽ��ϱ�?\t 1. ���δ�\t 2. ���ư���\t");
					
					switch(st.returnOption()){
				
					case 1: //���̴� ���
						next = map.get(current).get(1);
						chk = false;
						break;
					case 2: //���ư��� ���
						next = map.get(current).get(0);
						chk = false;
						break;
					default:
						System.out.println("�ٽ� �Է����ּ���...");
						break;
					}//switch
				}//while
			}//if
			
						
			while(!(chksize == 0)){ //�б������� �� �� �ִ� ��찡 �ִ��� check
				if((current == 0) && (count > 0)){ // ���� �� ���� ���� current ��ġ�� 0�϶� � ������ ����� ������ ������ ������ ���� ó��
					return -1;
				}
				
				int prvnext = next;
				next = move(map, current, result.get(0),next); // ���� ���� ��ġ�� �� �ִ� �� ����
				
				if(next == -1){ //���� �� ���� ���� ������ ���� ó��
					return -1;
				}
				
				if(map.get(next).size() == 2 && result.size() > 1 ){ // 2���� ��θ� ���ų� / result list�� 2�� �̻��� element�� �����ִٸ�
					
						boolean chk = true;
					
						while(chk){
							System.out.println("���̽ðڽ��ϱ�? ���ư��ðڽ��ϱ�?\t 1. ���δ�\t 2. ���ư���\t");
							switch(st.returnOption()){
					
							case 1: //���̴� ��� -> current�� next ���¸� �ٲ��ش�(�����̰� �� ��) - �̹� �Ǵ� �Ϸ�
								current = next;
								next = map.get(current).get(1);
								result.remove(0); //�ش� ����� ����
								chk = false;
								break;
							case 2: //���ư��� ��� -> current�� next ���¸� �ٲ��ش�(�����̰� �� ��) - �̹� �Ǵ� �Ϸ�
								current = next;
								next = map.get(current).get(0);
								result.remove(0); //�ش� ����� ����
								chk = false;
								break;
							default:
								System.out.println("�ٽ� �Է����ּ���...");
								break;
							}//switch
						}//while
					
					
					}//if
					else{ //map.get(next).size() == 1 : 1���� ��θ� ���ų� / result list�� 1�� ������ element�� �����ִٸ�/ ��ΰ� �������� �ʾҴٸ�? 
						int temp = result.get(0); //�ش� ������ ����� �ǵڷ� ������ -> ���� �� �ִ� ���ɼ��� �ִ� ������ ����� �ִ��� ���캸�� ����
						result.add(temp);
						result.remove(0);

						next = prvnext; //22�� ��ġ������ ������ �ذ�
					
					}//else
				
					chksize--; //�˻縦 �Ϸ��ϸ� count 1 ����
				}//while

		
		int sum = 0;
		
		if(!(current == 5 || current == 10 || current == 22)){ //current�� 5, 10, 22�϶��� �̹� ���� next ������ ������ ���� -> �̵��ϰ� �� ��
			next = -1; //next�� �ʱ�ȭ			
		}
		
		
		for(int i = 0; i< result.size(); i ++){ // �б������� ������ ����� ó���ϰ� �� ���� result list�� �����ִ� ������ ����� ��� ����  ���ο� current ��ġ�� ����
			sum += result.get(i);
		}
		
		current = move(map, current, sum, next);
		return current;
	}//moveMarker
	
	
	/*
	 * move:
	 * - ���� ���� current ��ġ ������ �޾ƿ� ���ο� ���� ���� ��ġ ������ ����
	 * - ���� �����̰� �� ���� current ��ġ ���� return
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
			
			if(prev == 26){ //���� ��ġ�� �� ���⿡�� ���� ����� ó�� -> 22�� ���� ��ġ�� 27
				next = map.get(current).get(1);
			}
			else{
				next = map.get(current).get(0); //���ο� ���� ���� ��ġ�� ��´�				
			}
		}//while
		
		return current;
	}//move
			
}//Go


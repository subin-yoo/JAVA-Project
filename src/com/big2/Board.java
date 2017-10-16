package com.big2;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

	private final int rows = 7;
	private final int cols = 7;
		
	private String[][] board = new String [rows][cols];
	
	/*
	 * initBoard:
	 * - board : 2-dimension array
	 */
	public void initBoard(){
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				
				if(i == 0 || i == 6){ //1st row & 7th row
					if(j == 3){
						board[i][j] = "\t";
					}//if
					else if(j == 0 || j == 6){
						if(i == 6 && j == 6){
							board[i][j] = "★\t(Start/Finish)";
						}//if
						else{
							board[i][j] = "◎\t";														
						}//else
					}//else if
					else{
							board[i][j] = "○\t";							
					}//else
				}//if
				else if(i == 1 || i == 5){ //2nd row & 6th row
					if(j == 0 || j == 1 || j == 5 || j == 6){
						board[i][j] = "○\t";
					}//if
					else{
						board[i][j] = "\t";				
					}//else
				}//else if
				else if(i == 2 || i == 4){ //3rd row & 5th row
					if(j == 0 || j == 2 || j == 4 || j == 6){
						board[i][j] = "○\t";
					}//if
					else{
						board[i][j] = "\t";				
					}//else	
				}//else if
				else{ //4th row(center)
					if(j == 3){
						board[i][j] = "◎"; 
					}//if
					else{
						board[i][j] = "\t";
					}//else
				}
				
			}//for
		}//for
			
	}

	/*
	 * printBoard:
	 * - print out board
	 */
	public void printBoard(){
		for(int i = 0; i< rows; i++){
			for(int j = 0; j< cols; j++){
				System.out.print(board[i][j]);
			}//for
		System.out.print("\n\n");
		}//for
	}//printBoard
	
	/*
	 * changeBoard:
	 * - 각 player 말의 현재 위치 정보를 받아와 marker를 찍어 printout
	 */
	public void changeBoard(ArrayList<HashMap<String, Object>> players){
		
		int i;
		int j;
		
		for(int k = 0; k < 2; k++){
			
			switch((Integer)players.get(k).get("ecur")){
				case 0 : //"★\t"
					i = 6;
					j = 6;
					break;
				
				case 1 : //"○\t"
					i = 5;
					j = 6;
					break;
				
				case 2 ://"○\t"
					i = 4;
					j = 6;
					break;
				
				case 3 ://"○\t"
					i = 2;
					j = 6;
					break;
				
				case 4 ://"○\t"
					i = 1;
					j = 6;
					break;
				
				case 5 ://"◎\t"
					i = 0;
					j = 6;
					break;
				
				case 6 ://"○\t"
					i = 0;
					j = 5;
					break;
				
				case 7 ://"○\t"
					i = 0;
					j = 4;
					break;
				
				case 8 ://"○\t"
					i = 0;
					j = 2;
					break;
				
				case 9 ://"○\t"
					i = 0;
					j = 1;
					break;
				
				case 10 ://"◎\t"
					i = 0;
					j = 0;
					break;
				
				case 11 ://"○\t"
					i = 1;
					j = 0;
					break;
				
				case 12 ://"○\t"
					i = 2;
					j = 0;
					break;
				
				case 13 ://"○\t"
					i = 4;
					j = 0;
					break;
				
				case 14 ://"○\t"
					i = 5;
					j = 0;
					break;
				
				case 15 ://"◎\t"
					i = 6;
					j = 0;
					break;
				
				case 16 ://"○\t"
					i = 6;
					j = 1;
					break;
				
				case 17 ://"○\t"
					i = 6;
					j = 2;
					break;
				
				case 18 ://"○\t"
					i = 6;
					j = 4;
					break;
				
				case 19 ://"○\t"
					i = 6;
					j = 5;
					break;
				
				case 20 ://"○\t"
					i = 1;
					j = 5;
					break;
				
				case 21 ://"○\t"
					i = 2;
					j = 4;
					break;
				
				case 22 ://"◎\t"
					i = 3;
					j = 3;
					break;
				
				case 23 ://"○\t"
					i = 4;
					j = 2;
					break;
				
				case 24 ://"○\t"
					i = 5;
					j = 1;
					break;
				
				case 25 ://"○\t"
					i = 1;
					j = 1;
					break;
				
				case 26 ://"○\t"
					i = 2;
					j = 2;
					break;
				
				case 27 ://"○\t"
					i = 4;
					j = 4;
					break;
				
				default: //case 28 //"○\t"  
					i = 5;
					j = 5;
					break;
				}//switch
		
		if(i == 6 && j == 6){
			board[i][j] = (String)players.get(k).get("emarker") + "(Start/Finish)";
		}
		else{
		board[i][j] = (String)players.get(k).get("emarker"); //2-dimension array의 players들의 말의 현재 위치에 marker를 넣음
		}
		
		}//for
		printBoard(); //해당 board print
		
		initBoard(); //reset the board after printout 
		
	}//changeBoard


}

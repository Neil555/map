import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapTest {

	Map M_empty,M_Assigned,M_NoDelete,M_NoDeleteResult,M_NeedDelete,M_NeedDeleteResult;
	int TC_Judge[][][] = {
			// dif coor(init (0,8))
			// type1 and state0(left shift)
			{{1,0,0,8},{1}},
			{{1,0,-1,8},{0}},
			// type1 and state0(right shift)
			{{1,0,0,8},{1}},
			{{1,0,1,8},{1}},
			// type1 and state0(down shift)
			{{1,0,0,8},{1}},
			{{1,0,0,9},{1}},
			 // type1 and state(cw rotate)
			{{1,0,-1,8},{0}},
			{{1,1,-1,8},{1}},
			 // type1 and state(ccw rotate)
			{{1,0,-1,8},{0}},
			{{1,3,-1,8},{0}},
			//
			// dif coor(init (6,8))
			// type 0 and state2(left shift)
			{{0,2,6,8},{1}},
			{{0,2,5,8},{1}},
			// type 0 and state2(right shift)
			{{0,2,6,8},{1}},
			{{0,2,7,8},{0}},
			// type 0 and state2(down shift)
			{{0,2,6,8},{1}},
			{{0,2,6,9},{1}},
			// type 0 and state2(down shift)
			{{0,2,6,8},{1}},
			{{0,2,6,9},{1}},
			// type 0 and state2(cw rotate)
			{{0,3,7,8},{1}},
			{{0,0,7,8},{0}},
			// dif coor(init (7,8)) as part of (6,8)
			// type 0 and state2(ccw rotate)
			{{0,3,7,8},{1}},
			{{0,2,7,8},{0}},
			//
			// dif coor(init (0,18))
			// type 3 and state0(left shift)
			{{3,0,0,18},{1}},
			{{3,0,-1,18},{0}},
			// type 3 and state0(right shift)
			{{3,0,0,18},{1}},
			{{3,0,1,18},{1}},
			// type 3 and state0(down shift)
			{{3,0,0,18},{1}},
			{{3,0,0,19},{0}},
			// type 3 and state0(cw rotate)
			{{3,0,0,18},{1}},
			{{3,1,0,18},{0}},
			// type 3 and state0(ccw rotate)
			{{3,0,0,18},{1}},
			{{3,3,0,18},{0}},
			//
			// dif coor(init (7,18))
			// type 5 and state0(left shift)
			{{5,0,7,18},{1}},
			{{5,0,6,18},{1}},
			// type 5 and state0(right shift)
			{{5,0,7,18},{1}},
			{{5,0,8,18},{0}},
			// type 3 and state0(down shift)
			{{5,0,7,18},{1}},
			{{5,0,7,19},{0}},
			// type 3 and state0(cw rotate)
			{{5,0,0,18},{1}},
			{{5,1,0,18},{0}},
			// type 3 and state0(ccw rotate)
			{{5,0,0,18},{1}},
			{{5,3,0,18},{0}},
			
			
	};
	int TC_Judge2[][][] = {
			// dif coor(init (0,16))
			// type1 and state0
			{{3,0,0,16},{1}},
			{{3,0,-1,16},{0}},//(left shift)
			{{3,0,1,16},{0}},//(right shift) 
			{{3,0,0,17},{0}},//(down shift) 
			{{3,1,0,16},{0}},//(cw rotate) 
			{{3,3,0,16},{0}},//(ccw rotate)
			// dif coor(init (0,16))
			// type6 and state0
			{{6,0,4,17},{1}},
			{{6,0,3,17},{0}},//(left shift) 
			{{6,0,5,17},{0}},//(right shift)
			{{6,0,4,18},{0}},//(down shift)
			{{6,1,4,17},{0}},//(cw rotate)
			{{6,3,4,17},{0}},//(ccw rotate)
			// dif coor(init (8,15))
			// type5 and state3
			{{5,3,8,15},{1}},
			{{5,3,7,15},{0}},//(left shift)
			{{5,3,9,15},{0}},//(right shift)
			{{5,3,8,16},{0}},//(down shift)
			{{5,0,8,15},{0}},//(cw rotate)
			{{5,2,8,15},{0}},//(ccw rotate)
			// dif coor(init (4,15))
			// type4 and state0
			{{4,0,4,15},{1}}, //
			{{4,0,3,15},{0}},//(left shift)
			{{4,0,5,15},{0}},//(right shift)
			{{4,0,4,16},{0}},//(down shift) 
			{{4,1,4,15},{1}},//(cw rotate) 
			{{4,3,4,15},{1}},//(ccw rotate) 
			// dif coor(init (2,15))
			// type40 and state0
			{{0,0,2,15},{1}},
			{{0,0,2,15},{1}},//(left shift)
			{{0,0,3,15},{1}},//(right shift)
			{{0,0,2,16},{0}},//(down shift)
			{{0,1,2,15},{0}},//(cw rotate)
			{{0,3,2,15},{0}},//(ccw rotate) 
	};
	

	
	@Before
	public void setUp() throws Exception {
		M_empty = new Map();
		M_Assigned = new Map();
		for(int i = 0 ; i < 10 ; i++){
			 M_Assigned.getMap()[19][i] = 1;
			 M_Assigned.getMap()[18][i] = 1;
		}
		M_Assigned.getMap()[18][4] = M_Assigned.getMap()[18][5] = M_Assigned.getMap()[18][6] = 0;
		M_Assigned.getMap()[17][3] = M_Assigned.getMap()[17][6] = M_Assigned.getMap()[17][7] = M_Assigned.getMap()[17][8] =
		M_Assigned.getMap()[16][2] = M_Assigned.getMap()[16][3] = M_Assigned.getMap()[16][4] = M_Assigned.getMap()[16][8] =
		M_Assigned.getMap()[16][7] = M_Assigned.getMap()[15][7] = 1;
		
		/**/
	}

	void preSet(){
		M_NoDelete = new Map();
		M_NoDeleteResult = new Map(); 
		M_NeedDelete = new Map();
		M_NeedDeleteResult = new Map();
		for(int i = 10 ; i < M_NoDelete.getMap().length ; i++){
			for(int j = 0 ; j < M_NoDelete.getMap()[0].length ; j++){
				if((i-10)==j) continue;
				else{
					M_NoDelete.getMap()[i][j] = 1;	
					M_NoDeleteResult.getMap()[i][j] = 1;
				}
			}
		}
		
		for(int i = 15 ; i < M_NeedDelete.getMap().length ; i++){
			for(int j = 0 ; j < M_NeedDelete.getMap()[0].length ; j++){
				M_NeedDelete.getMap()[i][j] = 1;				
			}
		}
		M_NeedDelete.getMap()[15][9] = 0;
		
		for(int i = 0 ; i < M_NeedDeleteResult.getMap()[0].length-1 ; i++){
			M_NeedDeleteResult.getMap()[19][i] = 1;
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJudge() {
		System.out.println("--------------Judge event-----------");
		//
		System.out.println("--------------Empty Map-----------");
		for(int i = 0 ; i < TC_Judge.length;i++){
			int input[] = TC_Judge[i][0];
			int expected[] = TC_Judge[i][1];
			//
			assertEquals(input.length,4);
			assertEquals(expected.length,1);
			//
			System.out.printf("Block type:" + input[0] + " with state:" + input[1] + " set to ("+ input[2]+","+input[3]+")  \t");
			Block B = new Block(input[0]);
			B.state = input[1];
			assertEquals(M_empty.Judge(B, input[2], input[3])? 1 : 0, expected[0]);
			String s = (M_empty.Judge(B, input[2], input[3]) ? "true" : "false"); 
			String s2 = (expected[0] == 1)?"true":"false";
			System.out.println("Output:" + s + "\tExpected:" + s2);
		}
		System.out.println("--------------Assigned Map-----------");
		printMatrix();
		for(int i = 0 ; i < TC_Judge2.length;i++){
			int input[] = TC_Judge2[i][0];
			int expected[] = TC_Judge2[i][1];
			//
			assertEquals(input.length,4);
			assertEquals(expected.length,1);
			//
			System.out.printf("Block type:" + input[0] + " with state:" + input[1] + " set to ("+ input[2]+","+input[3]+")  \t");
			Block B = new Block(input[0]);
			B.state = input[1];
			assertEquals(M_Assigned.Judge(B, input[2], input[3])? 1 : 0, expected[0]);
			String s = (M_Assigned.Judge(B, input[2], input[3]) ? "true" : "false"); 
			String s2 = (expected[0] == 1)?"true":"false";
			System.out.println("Output:" + s + "\tExpected:" + s2);
		}
		
	}
	
	void printMatrix(){
		for(int i = 0 ; i < M_Assigned.getMap().length ; i++){
			for(int j = 0 ; j < M_Assigned.getMap()[0].length ; j++){
				System.out.print(M_Assigned.getMap()[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	@Test
	public void testDelLine() {
		preSet();
		System.out.println("--------------Deline event-----------");
		//
		Map input = M_NoDelete;
		Map expected = M_NoDeleteResult;
		//
		//
		System.out.print("input:\n");
		printResult(input);
		input.delLine();
		//
		System.out.print("output:    \texpected:\n");
		CompareTwoMap(input,expected);
		printResult(input,expected);
		//
		Map input2 = M_NeedDelete;
		Map expected2 = M_NeedDeleteResult;
		//
		//
		System.out.print("input:\n");
		printResult(input2);
		input2.delLine();
		//
		System.out.print("output:    \t\t        expected:\n");
		CompareTwoMap(input2,expected2);	
		printResult(input2,expected2);
		

	}
	
	public void CompareTwoMap(Map m,Map m2){
		
		for(int i = 0 ; i < m.getMap().length ; i++){
			
			for(int j = 0 ; j < m.getMap()[0].length ; j++){
				assertEquals(m.getMap()[i][j],m2.getMap()[i][j]);
				//if(m.getMap()[i][j] != m2.getMap()[i][j]) 
			}
			
		}
		
	}
	
	void printResult(Map m){
		for(int i = 0 ; i < m.getMap().length ; i++){
			for(int j = 0 ; j < m.getMap()[0].length ; j++){
				System.out.print(m.getMap()[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	void printResult(Map m, Map m2){
		for(int i = 0 ; i < m.getMap().length ; i++){
			for(int j = 0 ; j < m.getMap()[0].length ; j++){
				System.out.print(m.getMap()[i][j] + " ");
			}
			System.out.print("    \t");
			for(int j = 0 ; j < m.getMap()[0].length ; j++){
				System.out.print(m2.getMap()[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}

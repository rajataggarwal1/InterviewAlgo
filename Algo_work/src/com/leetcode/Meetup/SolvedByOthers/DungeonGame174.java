package com.leetcode.Meetup.SolvedByOthers;
/*
 * https://leetcode.com/problems/dungeon-game/
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)
 

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 */
public class DungeonGame174 {

	/*Python code- Need to convert into java
	 * 
	 *  def moveAndFindMaxHealth(self, dungeon, x_pos, y_pos, max_move):
        print (x_pos, y_pos, max_move)
        if(x_pos>=len(dungeon) or x_pos<0) or (y_pos>=len(dungeon[0]) or y_pos<0) or max_move < 0:
            return (float('inf')*-1)
        
        if((x_pos, y_pos) == (0,0)):
            return(dungeon[x_pos][y_pos])
        
        move_health = max ([
            self.moveAndFindMaxHealth(dungeon, x_pos-1, y_pos, max_move-1),
            self.moveAndFindMaxHealth(dungeon, x_pos, y_pos-1, max_move-1),
        ])
        print(f'RETURN move_health = {move_health}, dungeon[{x_pos}][{y_pos}] = {dungeon[x_pos][y_pos]}')
        return move_health + dungeon[x_pos][y_pos]
    
    def calculateMinimumHP(self, dungeon) -> int:
        x_len = len(dungeon)
        y_len = len(dungeon[0])
        max_move = x_len + y_len - 2
        
        #float('inf')*-1
        
        inital_x = x_len-1
        inital_y = y_len-1
        answer = self.moveAndFindMaxHealth(dungeon, inital_x, inital_y, max_move)
        print (answer)
        return (answer)
	
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

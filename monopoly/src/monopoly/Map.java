package monopoly;

public class Map {
	/* variables */
	Block[] blockList = new Block[32];
	
	/* methods */
	
	/**
	 * @brief The Constructor of the class.
	 */
	public Map() {
		blockList[0] = new Block("Start", true, false, 0, 0, 0);
		blockList[1] = new Block("台南後站（遊俠聚集地）", false, true, 1, 0, 1);
		blockList[2] = new Block("Tube", true, false, 0, 0, 0);
		blockList[3] = new Block("後站大遠百", false, true, 1, 0, 1);
		blockList[4] = new Block("Money", true, false, 0, 0, 0);
		blockList[5] = new Block("消失的牛車伯", false, true, 1, 0, 2);
		blockList[6] = new Block("Star", true, false, 0, 0, 0);
		blockList[7] = new Block("育樂街紅樓", false, true, 1, 0, 2);
		blockList[8] = new Block("Jail", true, false, 0, 0, 0);
		blockList[9] = new Block("勝利早點", false, true, 2, 0, 3);
		blockList[10] = new Block("Tube", true, false, 0, 0, 0);
		blockList[11] = new Block("老邱", false, true, 2, 0, 3);
		blockList[12] = new Block("Trap", true, false, 0, 0, 0);
		blockList[13] = new Block("九乘九", false, true, 2, 0, 4);
		blockList[14] = new Block("Star", true, false, 0, 0, 0);
		blockList[15] = new Block("21世紀風味館", false, true, 2, 0, 4);
		blockList[16] = new Block("Park", true, false, 0, 0, 0);
		blockList[17] = new Block("電機三館麥當勞", false, true, 3, 0, 5);
		blockList[18] = new Block("Tube", true, false, 0, 0, 0);
		blockList[19] = new Block("7-11大學店", false, true, 3, 0, 5);
		blockList[20] = new Block("Money", true, false, 0, 0, 0);
		blockList[21] = new Block("Double Cheese", false, true, 3, 0, 6);
		blockList[22] = new Block("Star", true, false, 0, 0, 0);
		blockList[23] = new Block("錢鼠", false, true, 3, 0, 6);
		blockList[24] = new Block("ToJail", true, false, 0, 0, 0);
		blockList[25] = new Block("電機本館", false, true, 4, 0, 7);
		blockList[26] = new Block("Tube", true, false, 0, 0, 0);
		blockList[27] = new Block("奇美樓", false, true, 4, 0, 7);
		blockList[28] = new Block("Trap", true, false, 0, 0, 0);
		blockList[29] = new Block("東安路迷客夏", false, true, 5, 0, 8);
		blockList[30] = new Block("Star", true, false, 0, 0, 0);
		blockList[31] = new Block("世界彼端伊都", false, true, 5, 0, 8);
	}
	/**
	 * @param input
	 * @return reference of next block 
	 */
	public Block nextBlock(int input) {return blockList[(input+1)%32];}
	/**
	 * @return true->price*2	false->price*1
	 */
	public boolean ownCouple(int input) {
		if(blockList[input].getOwner() == blockList[(input+2)%32].getOwner())	return true;
		else if(blockList[input].getOwner() == blockList[(input+30)%32].getOwner())	return true;
		else	return false;
	}
	/**
	 * @brief 一步一步走，每步都看有沒有錢可以拿，走到底之後看是不是水管，是的話就從下一個水管出去並且把中間的錢都拿走
	 * @param playerList:	所有人的資料
	 * @param movement:		要走幾步
	 * @param nowPlayer:	是誰在走路
	 */
	public Block walk(Role[] playerList, int movement, int nowPlayer) {
		//一步一步走（要看撿錢）
		for(int a=0; a < movement; a++) {
			playerList[nowPlayer].moveOn();
			//撿錢
			playerList[nowPlayer].addMoney(blockList[playerList[nowPlayer].getPosition()].pickMoney());
		}
		//如果要付錢
		if(!blockList[playerList[nowPlayer].getPosition()].getOwner().equals(playerList[nowPlayer].getName())) {
			int moneyGet = playerList[nowPlayer].lossMoney(blockList[playerList[nowPlayer].getPosition()].getPricePassBy());
			//找owner
			for(int b=1; b<=3; b++) {
				if(blockList[playerList[nowPlayer].getPosition()].getOwner().equals(playerList[(nowPlayer+b)%4].getName()))
					playerList[(nowPlayer+b)%4].addMoney(moneyGet);
			}
		}
		//如果最後是水管
		if(blockList[playerList[nowPlayer].getPosition()].getName()=="Tube") {
			for(int a=1; a < 8; a++) {
				playerList[nowPlayer].moveOn();
				//撿錢
				playerList[nowPlayer].addMoney(blockList[playerList[nowPlayer].getPosition()].pickMoney());
			}
		}
		return blockList[playerList[nowPlayer].getPosition()];
	}
}

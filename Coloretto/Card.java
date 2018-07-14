package Coloretto;

public class Card{
//variables
	protected String	type;		//color, rainbow, twice, finish
	protected String	seat;		//cardpile, cardrow, player
	protected int		num;		//cardpile or cardrow
	protected int		player;		//12345
	protected int		row;		//in which row
//functions
	public Card(int inNum, String inType){
		setType(inType);
		setSeat("cardpile");
		setNum(inNum);
		setPlayer(0);
		setRow(0);
	}
	public String	getType(){
		return type;
	}
	public Card		setType(String inType){
		type = inType;
		return this;
	}
	public String	getSeat(){
		return seat;
	}
	public Card		setSeat(String inSeat){
		seat = inSeat;
		return this;
	}
	public int		getNum(){
		return num;
	}
	public Card		setNum(int inNum){
		num = inNum;
		return Card;
	}
	public int		getPlayer(){
		return player;
	}
	public Card		setPlayer(int inPlayer){
		player = inPlayer;
		return Card;
	}
	public int		getRow(){
		return row;
	}
	public Card		setRow(int inRow){
		row = inRow;
		return Card;
	}
}

class ColorCard{
//variables
	private String color;
//functions
	public ColorCard(int inNum, String inColor){
		super(inNum, "color");
		color = inColor;
	}
	public String	getColor(){
		return color;
	}
}

class RainbowCard{
	public RainbowCard(int inNum){
		super(inNum, "rainbow");
	}
}

class TwiceCard{
	public TwiceCard(int inNum){
		super(inNum, "twice");
	}
}

class FinishCard{
	public FinishCard(int inNum){
		super(inNum, "finish");
	}
}
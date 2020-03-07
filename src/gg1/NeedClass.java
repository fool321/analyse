package gg1;

import java.util.Vector;

public class NeedClass {

}


class player{
	String playernameString;
	String numberString;
	int num;
	public player(String playname) {
		this.playernameString = playname;
		// TODO Auto-generated constructor stub
	}
	Vector<player>players = new Vector<player>();
	void searchname(String nameString) {
		for(int i=0;i<this.players.size();i++) {//ур╣╫
			if(this.players.get(i).playernameString.equals(nameString)) {//ур╣╫ак
				this.players.get(i).num++;
				break;
			}
		}
		player newpPlayer = new player(nameString);
		newpPlayer.num = 1;
	}
}


class team {
	String TeamID;
//	Vector<done>dones = new Vector<done>();
//	void setdone(done d1) {
//		this.dones.add(d1);
//	}
	Vector<match>matchs = new Vector<match>();
	void setmatch(match m1) {
		this.matchs.add(m1);
	}
}

class match{
	String x;
	String y;
	//String playid;
	public match(String x,String y) {
		this.x = x;
		this.y = y;
	//	this.playid=idString;
		// TODO Auto-generated constructor stub
	}
}

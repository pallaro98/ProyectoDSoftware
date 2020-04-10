package programs;

import mongoDBclient.MongoConnection;


public class Program {

	public static void main(String[] args) {
		int selection = (int) (Math.random()*3);
		
		System.out.println(MongoConnection.getProgram(selection));
		
		selection = (int) (Math.random()*3);
		
		System.out.println(MongoConnection.getProgram(selection));
	}

}

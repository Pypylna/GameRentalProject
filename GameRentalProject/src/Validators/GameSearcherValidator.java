package Validators;

import Entity.Game;

public class GameSearcherValidator {
	
	public static boolean validate(String name, float minWorth, float maxWorth){
		if(minWorth <= maxWorth) return true;
		else return false;
	}
	

}

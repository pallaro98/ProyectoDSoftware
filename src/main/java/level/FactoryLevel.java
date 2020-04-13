package level;

public class FactoryLevel {
	
	public Level getLevel(String lvl) {
		if(lvl.equals("Basic")) {
			return new BasicLevel();
		}
		
		else if(lvl.equals("Medium")) {
			return new MediumLevel();
		}
		
		else if(lvl.equals("Advanced")) {
			return new AdvanceLevel();
		}
		
		return null;
	}

}

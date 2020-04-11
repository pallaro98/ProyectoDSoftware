package level;

public class FactoryLevel {

	public static void main(String[] args) {
		FactoryLevel t = new FactoryLevel();
		Level a = t.getLevel("Advance");
		
		a.getCategory().forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
	}
	
	public Level getLevel(String lvl) {
		if(lvl.equals("Basic")) {
			return new BasicLevel();
		}
		
		else if(lvl.equals("Medium")) {
			return new MediumLevel();
		}
		
		else if(lvl.equals("Advance")) {
			return new AdvanceLevel();
		}
		
		return null;
	}

}

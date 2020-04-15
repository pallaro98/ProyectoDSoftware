package level;

/***
 * @author Pallaro & Hector
 */
public class FactoryLevel {

	/***
	 * @param lvl String
	 * @return Factory
	 */
	public Level getLevel(final String lvl) {
		if (lvl.equals("Basic")) {
			return new BasicLevel();
		} else if (lvl.equals("Medium")) {
			return new MediumLevel();
		} else if (lvl.equals("Advanced")) {
			return new AdvanceLevel();
		}

		return null;
	}

}


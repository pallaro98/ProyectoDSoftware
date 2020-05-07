package actions;

import game.GameAttributes;
import level.Level;
import programs.Program;

public class ActionDelete implements Action {
	String name = "Delete";
	public static int i = 1;
	
	public String getName() {
		return this.name;
	}

	@Override
	public void performAction(GameAttributes gameAttributes, String cat, double pctCat, Level level, int pct) {
		gameAttributes.setTime(gameAttributes.getTime() + gameAttributes.getProgram().getTiempoVisto());
		gameAttributes.getElections().remove(gameAttributes.getProgram());
		gameAttributes.setUserIQ(gameAttributes.getUserIQ()-(gameAttributes.getProgram().getTiempoVisto() * level.getCategory().get(cat).getMult()));
		gameAttributes.getCategoryCount().replace(cat, gameAttributes.getCategoryCount().get(cat)- gameAttributes.getProgram().getTiempoVisto());
		i--;
	}

	@Override
	public String getProgramLBL(GameAttributes gameAttributes) {
		if(gameAttributes.getElections().isEmpty()) {
			gameAttributes.setProgram(Program.programaDefault);
			return "Ya no hay mas programas para borrar, cambia de modo";
		}
		
		gameAttributes.setProgram(gameAttributes.getElections().get(gameAttributes.getElections().size()-i));
		if(i<gameAttributes.getElections().size()) {
			i++;
		}
        return  gameAttributes.getProgram().getName();

	}

	
}


import per_system.Gui2;


public class gui_engine {
	Gui2 parent; // a reference to Calculator window
	char selectedAction = ' '; // +, -, /, or *

	double currentResult = 0;

	// Constructor stores the reference to the Calculator
	// window in the member variable parent
	gui_engine(Gui2 parent) {
		this.parent = parent;
	}
	
	

	
}

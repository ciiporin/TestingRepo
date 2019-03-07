import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet implements

//An action event listener has been implemented to call upon the following buttons and labels
ActionListener{
	JButton squares[];
	JButton newGameButton;
	JLabel score;
	JLabel win;
	JLabel lose;
	
	int wins;
	int loses;
	int emptySquaresLeft=9;
	int gamesWon;
	int gamesLost;

public static void main(String[] args) {
		// TODO Auto-generated method stub

	JApplet theApplet = new TicTacToe();
	theApplet.init();
	theApplet.start();
	JFrame window = new JFrame ("TicTacToe Applet and Application");
	window.setContentPane(theApplet);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setSize(30,30);
	window.setVisible(true);
	}
	
	public TicTacToe() {
		add(new JLabel ("This is both an Applet and Application!"));
	}
	/**
	 * init method is the applet's constructor
	 */
	
	public void init(){
		Container appletContent = this.getContentPane();
		resize(300,300);
		
		appletContent.setLayout(new GridLayout(3,3));
		appletContent.setBackground(Color.CYAN);
		
		newGameButton=new JButton("New Game");
		newGameButton.addActionListener(this);
		win=new JLabel("Won: ");
		lose=new JLabel("Lost ");
		
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new GridLayout (1,1));
		topPanel.add(win);
		topPanel.add(newGameButton);
		newGameButton.setHorizontalAlignment(JButton.CENTER);
		newGameButton.setSize (3,3);
		topPanel.add(lose);
		
		appletContent.add(topPanel, "North");
		
		JPanel centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(3,3));
		appletContent.add(centerPanel, "Center");
		
		score=new JLabel("Your turn!");
		appletContent.add(score,"South");
		
		squares=new JButton[9];
		
		
		for(int i=0; i<9; i++){
			squares [i]=new JButton();
			
		
			

			squares[i].setBackground(Color.ORANGE);
			centerPanel.add(squares[i]);
			
			
			JFrame frame = new JFrame("TicTacToe");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton theButton = (JButton) e.getSource ();
		
		if (theButton ==newGameButton){
			for(int i=0; i<9; i++){
				squares[i].setEnabled(true);
				squares[i].setText ("");
				squares[i].setBackground(Color.ORANGE);
			}
			
			emptySquaresLeft=9;
			score.setText("Your turn!");
			newGameButton.setEnabled(true);
			return;	
		}
	String winner = "";
	for (int i=0; i<9; i++){
		if(theButton == squares[i]){
			squares[i].setText("X");
			squares[i].setEnabled(true);
			
			winner = lookForWinner ();
			if(!"".equals(winner)){
				endTheGame();
			}
		}
		break;
	}
	
	if (winner.equals("X")){
		score.setText("You won!");
		wins++;
		win.setText("Won: " +gamesWon);
	} else if (winner.equals("O")){
		score.setText ("You lost!");
		loses++;
		lose.setText("Lost: "+gamesLost);
	} else if (winner.equals("T")){
		score.setText ("It's a tie!");
	}
	}
	
	
	String lookForWinner () {
		String theWinner = "";
		emptySquaresLeft--;
		
		if (emptySquaresLeft==0){
			return "T";
		}
		if (!squares[0].getText().equals("") && 

			squares[0].getText().equals(squares[1].getText())&&

			squares[0].getText().equals(squares[2].getText())){

			theWinner = squares[0].getText(); 

			highlightWinner (0,1,2);

		}
		
		else if (!squares[0].getText().equals("") && 

				squares[0].getText().equals(squares[3].getText())&&

				squares[0].getText().equals(squares[6].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (0,3,6);
		}
		else if (!squares[1].getText().equals("") && 

				squares[1].getText().equals(squares[4].getText())&&

				squares[1].getText().equals(squares[7].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (1,4,7);
		}
		else if (!squares[2].getText().equals("") && 

				squares[2].getText().equals(squares[5].getText())&&

				squares[2].getText().equals(squares[8].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (2,5,8);
		}
		else if (!squares[2].getText().equals("") && 

				squares[2].getText().equals(squares[4].getText())&&

				squares[2].getText().equals(squares[6].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (2,4,6);
		}
		else if (!squares[0].getText().equals("") && 

				squares[0].getText().equals(squares[4].getText())&&

				squares[0].getText().equals(squares[8].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (0,4,8);
		}
		else if (!squares[3].getText().equals("") && 

				squares[3].getText().equals(squares[4].getText())&&

				squares[3].getText().equals(squares[5].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (3,4,5);
		}
		else if (!squares[6].getText().equals("") && 

				squares[6].getText().equals(squares[7].getText())&&

				squares[6].getText().equals(squares[8].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (6,7,8);
		}

		

		return theWinner; 

	} 

		void computerMove () { 

			int selectedSquare; 

			selectedSquare = findEmptySquare("O"); 

			if (selectedSquare == -1) 

			selectedSquare = findEmptySquare("X"); 

				 

			if ( (selectedSquare == 0)&&(squares[4].getText().equals(""))) 

			selectedSquare=4; 

			if (selectedSquare == -1) 

			selectedSquare = getRandomSquare(); 

			squares[selectedSquare].setText("O"); 

			squares[selectedSquare].setEnabled(false); 

		} 

	int findEmptySquare(String player) { 

			int weight [] = new int [9]; 

			for ( int i = 0; i < 9; i++ ) { 

				if ( squares[i].getText().equals("O")) 

					weight[i] = -1; 

				else if ( squares[i].getText().equals("X")) 

					weight[i] = 1; 

				else 

					weight[i] = 0; 

			} 

		int twoWeights = player.equals("O") ? -2 : 2; 

		if (weight[0] + weight[1] + weight[2] == twoWeights){

			if (weight[0] == 0) 

				return 0; 

			else if (weight[1] == 0) 

				return 1; 

			else 

				return 2; 

		}

		if (weight[3] + weight[4] + weight[5] == twoWeights){

			if (weight[3] == 0) 

				return 3; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 5; 

		} 

		if (weight[6] + weight[7] + weight[8] == twoWeights){

			if (weight[6] == 0) 

				return 6; 

			else if (weight[7] == 0) 

				return 7; 

			else 

				return 8; 

		} 

		if (weight[0] + weight[3] + weight[6] == twoWeights){ 

			if (weight[0] == 0) 

				return 0; 

			else if (weight[3] == 0) 

				return 3; 

			else

				return 6; 

		} 

		if (weight[1] + weight[4] + weight[7] == twoWeights){ 

			if (weight[1] == 0) 

				return 0; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 7; 

		}

		if (weight[2] + weight[5] + weight[8] == twoWeights){ 

			if (weight[2] == 0) 

				return 2; 

			else if (weight[5] == 0) 

				return 5; 

			else 

				return 8; 

		} 

		if (weight[0] + weight[4] + weight[8] == twoWeights){ 

			if (weight[0] == 0) 

				return 0; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 8; 

		} 

		if (weight[2] + weight[4] + weight[6] == twoWeights){ 

			if (weight[2] == 0) 

				return 2; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 6; 

		} 

		return -1; 

	} 

	int getRandomSquare(){ 

		boolean gotEmptySquare = false; 

		int selectedSquare = -1; 

		do { 

			selectedSquare = (int) (Math.random() * 9); 

			if (squares[selectedSquare].getText().equals("")){ 
				gotEmptySquare = true; 

			}     

		} 

		while (!gotEmptySquare); 

		return selectedSquare; 

	} 

	void highlightWinner (int win1, int win2, int win3) { 

		squares[win1].setBackground(Color.CYAN); 
		squares[win2].setBackground(Color.CYAN); 	
		squares[win3].setBackground(Color.CYAN); 
		

	} 

	void endTheGame(){ 

		for(int i=0; i<9; i++){ 

			squares[i].setEnabled(false); 

		} 

	} 

	void newGame(){ 

		for(int i=0; i<9; i++){ 

			squares[i].setEnabled(true);

		}
	}
}   

/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet implements ActionListener{
//An action event listener has been implemented to call upon the following buttons and labels

	JButton squares[];
	JButton newGameButton;
	JLabel score;
	JLabel win;
	JLabel lose;
	Container appletContent;

	int wins;
	int loses;
	int emptySquaresLeft=9;
	int gamesWon;
	int gamesLost;

public static void main(String[] args) {
		// TODO Auto-generated method stub

	TicTacToe theApplet = new TicTacToe();
	JFrame window = new JFrame ("TicTacToe Applet and Application");
    theApplet.appletContent = window.getContentPane();

	theApplet.init();
	//theApplet.start();
	
	//window.setContentPane(theApplet);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setSize(30,30);
	window.setVisible(true);
	}
	
	public TicTacToe() {
		   appletContent = this.getContentPane();
		   add(new JLabel ("This is both an Applet and Application!"));
	}
	/**
	 * init method is the applet's constructor
	 */
	/*
	public void init(){
		//Container appletContent = this.getContentPane();
		resize(300,300);
		
		appletContent.setLayout(new BorderLayout(3,3));
		appletContent.setBackground(Color.CYAN);
		appletContent.setSize(300,300);
		
		newGameButton=new JButton("New Game");
		newGameButton.addActionListener(this);
		
		win=new JLabel("Won: ");
		lose=new JLabel("Lost ");
		
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new GridLayout (1,1));
		topPanel.add(win);
		topPanel.add(newGameButton);
		//newGameButton.setHorizontalAlignment(JButton.CENTER);
		//newGameButton.setSize (3,3);
		topPanel.add(lose);
		
		appletContent.add(topPanel, "North");
		
		JPanel centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(3,3));
		appletContent.add(centerPanel, "Center");
		
		score=new JLabel("Your turn!");
		appletContent.add(score,"South");
		
		squares=new JButton[9];
		
		
		for(int i=0; i<9; i++){
			squares [i]=new JButton();
			squares[i].addActionListener(this);
          	squares[i].setBackground(Color.ORANGE);
			centerPanel.add(squares[i]);
			
			
			JFrame frame = new JFrame("TicTacToe");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton theButton = (JButton) e.getSource ();
		
		if (theButton ==newGameButton){
			for(int i=0; i<9; i++){
				squares[i].setEnabled(true);
				squares[i].setText ("");
				squares[i].setBackground(Color.ORANGE);
			}
			
			emptySquaresLeft=9;
			score.setText("Your turn!");
			newGameButton.setEnabled(true);
			return;	
		}
	String winner = "";
	for (int i=0; i<9; i++){
		if(theButton == squares[i]){
			squares[i].setText("X");
			squares[i].setEnabled(true);
			
			winner = lookForWinner ();
			
			if(!"".equals(winner)){
				endTheGame();
			} else {
		           computerMove();
		           score.setText("Your turn");
		           winner = lookForWinner();
		            if ( !"".equals(winner))
		           {
		             endTheGame();
		           }
		       }
					
		break;
	}
	}
	
	
	if (winner.equals("X")){
		score.setText("You won!");
		wins++;
		win.setText("Won: " +gamesWon);
	} else if (winner.equals("O")){
		score.setText ("You lost!");
		loses++;
		lose.setText("Lost: "+gamesLost);
	} else if (winner.equals("T")){
		score.setText ("It's a tie!");
	}
	}
	
	
	String lookForWinner () {
		String theWinner = "";
		emptySquaresLeft--;
		
		if (emptySquaresLeft==0){
			return "T";
		}
		if (!squares[0].getText().equals("") && 

			squares[0].getText().equals(squares[1].getText())&&

			squares[0].getText().equals(squares[2].getText())){

			theWinner = squares[0].getText(); 

			highlightWinner (0,1,2);

		}
		
		else if (!squares[0].getText().equals("") && 

				squares[0].getText().equals(squares[3].getText())&&

				squares[0].getText().equals(squares[6].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (0,3,6);
		}
		else if (!squares[1].getText().equals("") && 

				squares[1].getText().equals(squares[4].getText())&&

				squares[1].getText().equals(squares[7].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (1,4,7);
		}
		else if (!squares[2].getText().equals("") && 

				squares[2].getText().equals(squares[5].getText())&&

				squares[2].getText().equals(squares[8].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (2,5,8);
		}
		else if (!squares[2].getText().equals("") && 

				squares[2].getText().equals(squares[4].getText())&&

				squares[2].getText().equals(squares[6].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (2,4,6);
		}
		else if (!squares[0].getText().equals("") && 

				squares[0].getText().equals(squares[4].getText())&&

				squares[0].getText().equals(squares[8].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (0,4,8);
		}
		else if (!squares[3].getText().equals("") && 

				squares[3].getText().equals(squares[4].getText())&&

				squares[3].getText().equals(squares[5].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (3,4,5);
		}
		else if (!squares[6].getText().equals("") && 

				squares[6].getText().equals(squares[7].getText())&&

				squares[6].getText().equals(squares[8].getText())){

				theWinner = squares[0].getText(); 

				highlightWinner (6,7,8);
		}

		

		return theWinner; 

	} 

		void computerMove () { 

			int selectedSquare; 

			selectedSquare = findEmptySquare("O"); 

			if (selectedSquare == -1) 

			selectedSquare = findEmptySquare("X"); 

				 

			if ( (selectedSquare == 0)&&(squares[4].getText().equals(""))) 

			selectedSquare=4; 

			if (selectedSquare == -1) 

			selectedSquare = getRandomSquare(); 

			squares[selectedSquare].setText("O"); 

			squares[selectedSquare].setEnabled(false); 

		} 

	int findEmptySquare(String player) { 

			int weight [] = new int [9]; 

			for ( int i = 0; i < 9; i++ ) { 

				if ( squares[i].getText().equals("O")) 

					weight[i] = -1; 

				else if ( squares[i].getText().equals("X")) 

					weight[i] = 1; 

				else 

					weight[i] = 0; 

			} 

		int twoWeights = player.equals("O") ? -2 : 2; 

		if (weight[0] + weight[1] + weight[2] == twoWeights){

			if (weight[0] == 0) 

				return 0; 

			else if (weight[1] == 0) 

				return 1; 

			else 

				return 2; 

		}

		if (weight[3] + weight[4] + weight[5] == twoWeights){

			if (weight[3] == 0) 

				return 3; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 5; 

		} 

		if (weight[6] + weight[7] + weight[8] == twoWeights){

			if (weight[6] == 0) 

				return 6; 

			else if (weight[7] == 0) 

				return 7; 

			else 

				return 8; 

		} 

		if (weight[0] + weight[3] + weight[6] == twoWeights){ 

			if (weight[0] == 0) 

				return 0; 

			else if (weight[3] == 0) 

				return 3; 

			else

				return 6; 

		} 

		if (weight[1] + weight[4] + weight[7] == twoWeights){ 

			if (weight[1] == 0) 

				return 0; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 7; 

		}

		if (weight[2] + weight[5] + weight[8] == twoWeights){ 

			if (weight[2] == 0) 

				return 2; 

			else if (weight[5] == 0) 

				return 5; 

			else 

				return 8; 

		} 

		if (weight[0] + weight[4] + weight[8] == twoWeights){ 

			if (weight[0] == 0) 

				return 0; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 8; 

		} 

		if (weight[2] + weight[4] + weight[6] == twoWeights){ 

			if (weight[2] == 0) 

				return 2; 

			else if (weight[4] == 0) 

				return 4; 

			else 

				return 6; 

		} 

		return -1; 

	} 

	int getRandomSquare(){ 

		boolean gotEmptySquare = false; 

		int selectedSquare = -1; 

		do { 

			selectedSquare = (int) (Math.random() * 9); 

			if (squares[selectedSquare].getText().equals("")){ 
				gotEmptySquare = true; 

			}     

		} 

		while (!gotEmptySquare); 

		return selectedSquare; 

	} 

	void highlightWinner (int win1, int win2, int win3) { 

		squares[win1].setBackground(Color.CYAN); 
		squares[win2].setBackground(Color.CYAN); 	
		squares[win3].setBackground(Color.CYAN); 
		

	} 

	void endTheGame(){ 

		for(int i=0; i<9; i++){ 

			squares[i].setEnabled(false); 

		}
		 newGameButton.setEnabled(true);

	} 
	}
  */
  
import java.awt.*; 
import java.util.Random; 
import java.awt.event.*; 
import java.util.Enumeration; 

class TablePile extends CardPile { 
TablePile (int x, int y, int c) { 
// initialize the parent class 
super(x,y); 
// then initialize our pile of cards 
for (int i = 0; i < c; i++) { 
canTake(Solitaire.deckPile.pop()); 
} 
// flip topmost card face up 
top().flip(); 
} 


public boolean retrieve (Card aCard) { 
if (CardPile()) 
go back aCard.rank() == 12; 
Card topCard = top(); 
go back(aCard.color() != topCard.color()) && 
(aCard.rank() == topCard.rank() - 1); 
} 
public boolean take account of (int tx, int ty) { 
// don't test bottom of card 
go back x <= tx && tx <= x + Card.width && 
y <= ty; 
} 
public void pick (int tx, int ty) { 
if (is not full()) 
and go back; 
// if face down, then flip 
Card topCard = top(); 
if (! topCard. Is facing upwards ()) { 
topCard. turn over(); 
and go back; 
} 
// else see if any suit pile can take card 
topCard = pop(); 
for (int i = 0; i < 4; i++) 
if (Solitare.suitPile[i].canTake(topCard)) { 
Solitare.suitPile[i].addCard(topCard); 
return; 
} 

// else see if any other table pile can take card 
for (int i = 0; i < 7; i++) 
if ( the Solitare.table[i]. can retrieve the (topCard)) { 
Solitare.table [i]. include a Card(topCard); 
return; 
} 
// else put it back on our pile 
Include Card(topCard); 
} 
 
public void show (Graphics g) { 
int localy = y; 
for (Enumeration e = thePile.elements(); e.hasMoreElements(); ) { 
Card aCard = (Card) e.nextElement(); 
aCard.draw (g, x, localy); 
localy += 35; 
} 
} 
} 

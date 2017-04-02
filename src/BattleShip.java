

import processing.core.*; 
import java.util.ArrayList; 

public class BattleShip extends PApplet {

int xpos;
int ypos;
int size;
int score;
int numOfShipBoxes;
int LastScore;
int Board;
int xposition;
int yposition;
Box[][] boxes;
boolean player1Turn;
ArrayList<ShipBox> PatrolBoat= new ArrayList<ShipBox>();
ArrayList<ShipBox> Submarine= new ArrayList<ShipBox>();
ArrayList<ShipBox> Destroyer= new ArrayList<ShipBox>();
ArrayList<ShipBox> BattleShip= new ArrayList<ShipBox>();
ArrayList<ShipBox> AircraftCarrier= new ArrayList<ShipBox>();
public static final int delay = 10;
public void doThis()
{
	String[] appletArgs = new String[] {"BattleShip"};
    PApplet.main(appletArgs);
}
@Override
public void setup()
{

  Board=(int)random(1,3);
  println(Board);
  score=0;
  player1Turn=false;
  boxes = new Box[10][10];
  
  background(254);
  xpos=25;
  ypos=25;
  size=50;
  for(int x=0;x<=10;x++)//setting up grid for board
  {
    for(int y=0;y<=10;y++)
    {
      fill(255);
      rect(xpos,ypos,size,size);
      ypos=ypos+50;
    }
    ypos=25;
    xpos=xpos+50;
  }
  xpos=75;
  ypos=75;
  size=50;
  for(int r=0;r<boxes.length;r++)//instantiation of all boxes needed for the game
  {
    for(int c=0;c<boxes[r].length;c++)
    {
      boxes[r][c]=new WaterBox(xpos,ypos,size);
      xpos+=50;
    }
    xpos=75;
    ypos+=50;
  }
  boardSetup(Board,boxes);//calls for random ship setup
  fill(255);
  rect(800,450,200,200);
  fill(255,0,0);
  rect(750,150,50,50);
  fill(0,0,255);
  rect(750,200,50,50);
  fill(0);
  textSize(20);
  textAlign(CENTER);
  text("= Hit",850,175);//legend
  text("= Miss",850,225);//legend
  text("Previous Score",900,440);//displays previous score
  text(LastScore,900,550);//will display 0 if you haven't played a game yet
  text("1", 100, 50);
  text("2", 150, 50);
  text("3", 200, 50);
  text("4", 250, 50);
  text("5", 300, 50);//labeling board
  text("6", 350, 50);
  text("7", 400, 50);
  text("8", 450, 50);
  text("9", 500, 50);
  text("10", 550, 50);
  text("A", 50, 100);
  text("B", 50, 150);
  text("C", 50, 200);
  text("D", 50, 250);
  text("E", 50, 300);
  text("F", 50, 350);
  text("G", 50, 400);
  text("H", 50, 450);
  text("I", 50, 500);
  text("J", 50, 550);
  fill(175);
  rect(700,50,100,50,10);
  textSize(12);
  fill(0);
  textAlign(CENTER);
  text("Start", 750, 75);//start box
  noLoop();
  for(int row=0;row<boxes.length;row++)//counts the number of ship boxes to know when to stop the game
  {
    for(int col=0;col<boxes[0].length;col++)
    {
      if(boxes[row][col].getType().equals("ShipBox"))
      {
        numOfShipBoxes++;
      }
    }
  }
}
public void boardSetup(int b,Box[][] boxes)//uses random number to choose a board to use
{
  if(b==1)
  {
    for(int r=2;r<4;r++)
    {
      xposition=boxes[r][2].getX();
      yposition=boxes[r][2].getY();
      boxes[r][2]= new ShipBox(xposition,yposition,size);
      PatrolBoat.add(new ShipBox(xposition,yposition,size));
    }
    for(int c=0;c<4;c++)
    {
      xposition=boxes[7][c].getX();
      yposition=boxes[7][c].getY();
      boxes[7][c]= new ShipBox(xposition,yposition,size);
      BattleShip.add(new ShipBox(xposition,yposition,size));
    }
    for(int c=7;c<10;c++)
    {
      xposition=boxes[0][c].getX();
      yposition=boxes[0][c].getY();
      boxes[0][c]= new ShipBox(xposition,yposition,size);
      Destroyer.add(new ShipBox(xposition,yposition,size));
    }
    for(int r=5;r<10;r++)
    {
      xposition=boxes[r][9].getX();
      yposition=boxes[r][9].getY();
      boxes[r][9]= new ShipBox(xposition,yposition,size);
      AircraftCarrier.add(new ShipBox(xposition,yposition,size));
    }
    for(int c=4;c<7;c++)
    {
      xposition=boxes[9][c].getX();
      yposition=boxes[9][c].getY();
      boxes[9][c]= new ShipBox(xposition,yposition,size);
      Submarine.add(new ShipBox(xposition,yposition,size));
    }
  }
  if(b==2)
  {
    for(int r=1;r<3;r++)
    {
      xposition=boxes[r][8].getX();
      yposition=boxes[r][8].getY();
      boxes[r][8]= new ShipBox(xposition,yposition,size);
      PatrolBoat.add(new ShipBox(xposition,yposition,size));
    }
    for(int c=4;c<8;c++)
    {
      xposition=boxes[5][c].getX();
      yposition=boxes[5][c].getY();
      boxes[5][c]= new ShipBox(xposition,yposition,size);
      BattleShip.add(new ShipBox(xposition,yposition,size));
    }
    for(int r=1;r<4;r++)
    {
      xposition=boxes[r][1].getX();
      yposition=boxes[r][1].getY();
      boxes[r][1]= new ShipBox(xposition,yposition,size);
      Destroyer.add(new ShipBox(xposition,yposition,size));
    }
    for(int r=5;r<10;r++)
    {
      xposition=boxes[r][0].getX();
      yposition=boxes[r][0].getY();
      boxes[r][0]= new ShipBox(xposition,yposition,size);
      AircraftCarrier.add(new ShipBox(xposition,yposition,size));
    }
    for(int c=2;c<5;c++)
    {
      xposition=boxes[8][c].getX();
      yposition=boxes[8][c].getY();
      boxes[8][c]= new ShipBox(xposition,yposition,size);
      Submarine.add(new ShipBox(xposition,yposition,size));
    }
  }
  if(b==3)
  {
    for(int c=0;c<2;c++)
    {
      xposition=boxes[9][c].getX();
      yposition=boxes[9][c].getY();
      boxes[9][c]= new ShipBox(xposition,yposition,size);
      PatrolBoat.add(new ShipBox(xposition,yposition,size));
    }
    for(int c=6;c<10;c++)
    {
      xposition=boxes[3][c].getX();
      yposition=boxes[3][c].getY();
      boxes[3][c]= new ShipBox(xposition,yposition,size);
      BattleShip.add(new ShipBox(xposition,yposition,size));
    }
    for(int r=5;r<8;r++)
    {
      xposition=boxes[r][6].getX();
      yposition=boxes[r][6].getY();
      boxes[r][6]= new ShipBox(xposition,yposition,size);
      Destroyer.add(new ShipBox(xposition,yposition,size));
    }
    for(int r=0;r<5;r++)
    {
      xposition=boxes[r][9].getX();
      yposition=boxes[r][9].getY();
      boxes[r][9]= new ShipBox(xposition,yposition,size);
      AircraftCarrier.add(new ShipBox(xposition,yposition,size));
    }
    for(int r=4;r<7;r++)
    {
      xposition=boxes[r][7].getX();
      yposition=boxes[r][7].getY();
      boxes[r][7]= new ShipBox(xposition,yposition,size);
      Submarine.add(new ShipBox(xposition,yposition,size));
    }
  }
}
@Override
public void draw()
{
  if(numOfShipBoxes!=0)//as long as there are still ship boxes left
  {
    fill(255);
    rect(750,325,100,50);
    for(int row=0;row<boxes.length;row++)//checks where the mouse is and highlights the box that the mouse is on
    {
      for(int col=0;col<boxes[0].length;col++)
      {
        if((mouseX>boxes[row][col].getX()&&mouseX<(boxes[row][col].getX()+boxes[row][col].getSize()))&&(mouseY>boxes[row][col].getY()&&mouseY<(boxes[row][col].getY()+boxes[row][col].getSize()))&&(boxes[row][col].isMiss()==false&&boxes[row][col].isHit()==false))
        {
          fill(200);
          rect(boxes[row][col].getX(),boxes[row][col].getY(),boxes[row][col].getSize(),boxes[row][col].getSize());
        }
        if(!((mouseX>boxes[row][col].getX()&&mouseX<(boxes[row][col].getX()+boxes[row][col].getSize()))&&(mouseY>boxes[row][col].getY()&&mouseY<(boxes[row][col].getY()+boxes[row][col].getSize())))&&(boxes[row][col].isMiss()==false&&boxes[row][col].isHit()==false))
        {
          fill(255,255,255);
          rect(boxes[row][col].getX(),boxes[row][col].getY(),boxes[row][col].getSize(),boxes[row][col].getSize());
        }
      }
    }
    if(player1Turn==true)//only shows if the start button is clicked
    {
      fill(255);
      rect(700,50,100,50,10);
      textSize(12);
      fill(0);
      textAlign(CENTER);
      text("Your Turn", 750, 75);
    }
    else if(player1Turn==false)//start button
    {
      fill(175);
      rect(700,50,100,50,10);
      textSize(12);
      fill(0);
      textAlign(CENTER);
      text("Start", 750, 75);
    }
    for(int row=0;row<boxes.length;row++)//checks if a box has been clicked
    {
      for(int col=0;col<boxes[0].length;col++)
      {
        if(boxes[row][col].isClicked()==true&&boxes[row][col].getType().equals("clickedWaterBox"))//if clicked box is a water box, then it will fill a blue box in its place
        {
          fill(0,0,255);
          rect(boxes[row][col].getX(),boxes[row][col].getY(),boxes[row][col].getSize(),boxes[row][col].getSize());
          fill(200);
        }
        else if(boxes[row][col].isClicked()==true&&boxes[row][col].getType().equals("clickedShipBox"))//if clicked box is a ship box, then it will fill a red box in its place
        {
          fill(255,0,0);
          rect(boxes[row][col].getX(),boxes[row][col].getY(),boxes[row][col].getSize(),boxes[row][col].getSize());
          fill(200);
        }
      }
    }
    fill(255);
    rect(25,600,700,50);
    fill(0);
    textSize(20);
    text("Score:",720,350);
    text(score,800,350);
    if(PatrolBoat.size()==0)//checks if all of the partol boat boxes are clicked
    {
      textSize(15);
      text("Patrol Boat sunk",100,625);
    }
    if(BattleShip.size()==0)
    {
      textSize(15);
      text("BattleShip sunk",225,625);
    }
    if(Destroyer.size()==0)
    {
      textSize(15);
      text("Destroyer sunk",350,625);
    }
    if(Submarine.size()==0)
    {
      textSize(15);
      text("Submarine sunk",475,625);
    }
    if(AircraftCarrier.size()==0)
    {
      textSize(15);
      text("Aircraft Carrier sunk",625,625);
    }
  }
  else//if all ship boxes have been clicked
  {
    for(int row=0;row<boxes.length;row++)
    {
      for(int col=0;col<boxes[0].length;col++)
      {
        if(boxes[row][col].isClicked()==true&&boxes[row][col].getType().equals("clickedWaterBox"))
        {
          fill(0,0,255);
          rect(boxes[row][col].getX(),boxes[row][col].getY(),boxes[row][col].getSize(),boxes[row][col].getSize());
          fill(200);
        }
        else if(boxes[row][col].isClicked()==true&&boxes[row][col].getType().equals("clickedShipBox"))
        {
          fill(255,0,0);
          rect(boxes[row][col].getX(),boxes[row][col].getY(),boxes[row][col].getSize(),boxes[row][col].getSize());
          fill(200);
        }
      }
    }
    fill(255);
    rect(25,600,700,50);
    fill(0);
    if(PatrolBoat.size()==0)
    {
      textSize(15);
      text("Patrol Boat sunk",100,625);
    }
    if(BattleShip.size()==0)
    {
      textSize(15);
      text("BattleShip sunk",225,625);
    }
    if(Destroyer.size()==0)
    {
      textSize(15);
      text("Destroyer sunk",350,625);
    }
    if(Submarine.size()==0)
    {
      textSize(15);
      text("Submarine sunk",475,625);
    }
    if(AircraftCarrier.size()==0)
    {
      textSize(15);
      text("Aircraft Carrier sunk",625,625);
    }
    LastScore=score;
    fill(0);
    rect(700,550,100,50,10);
    fill(255);
    textSize(15);
    text("Start Over?",750,575);//start over button
    fill(255);
    rect(750,325,100,50);
    fill(0);
    textSize(20);
    text(score,800,350);
    fill(0);
    textSize(50);
    text("Game Over",350,350);
  }
}
@Override
public void mouseClicked()
{
  if((mouseX>=700&&mouseX<=800)&&(mouseY>=50&&mouseY<=100))//checks if mouse was clicked inside the start button
  {
    loop();
    player1Turn= true;
  }
  else if((mouseX>75&&mouseX<575)&&(mouseY>75&&mouseY<575)&&player1Turn==true)//checks where the mouse is clicked inside of the board
  {
    int mouseXPos=mouseX;
    int mouseYPos=mouseY;
    println(mouseXPos+ " " + mouseYPos);
    for(int r=0;r<boxes.length;r++)
    {
      for(int c=0;c<boxes[0].length;c++)
      {
        if((mouseXPos>boxes[r][c].getX()&&mouseXPos<(boxes[r][c].getX()+50))&&(mouseYPos>boxes[r][c].getY()&&mouseYPos<(boxes[r][c].getY()+50))&&boxes[r][c].getType().equals("ShipBox"))
        {//checks if it is a ship box
          boxes[r][c].gotHit();
          score+=100;
          boxes[r][c]= new ClickedBox(boxes[r][c].getX(),boxes[r][c].getY(),boxes[r][c].getSize(),boxes[r][c].getType());
          for(int e=PatrolBoat.size()-1;e>=0;e--)
          {//checks if it is a patrol boat
            if((mouseXPos>PatrolBoat.get(e).getX()&&mouseXPos<(PatrolBoat.get(e).getX()+50))&&(mouseYPos>PatrolBoat.get(e).getY()&&mouseYPos<(PatrolBoat.get(e).getY()+50))&&PatrolBoat.get(e).getType().equals("ShipBox"))
            {
              PatrolBoat.remove(e);//removes that box from an arraylist
            }
          }
          for(int e=BattleShip.size()-1;e>=0;e--)
          {
            if((mouseXPos>BattleShip.get(e).getX()&&mouseXPos<(BattleShip.get(e).getX()+50))&&(mouseYPos>BattleShip.get(e).getY()&&mouseYPos<(BattleShip.get(e).getY()+50))&&BattleShip.get(e).getType().equals("ShipBox"))
            {
              BattleShip.remove(e);
            }
          }
          for(int e=Destroyer.size()-1;e>=0;e--)
          {
            if((mouseXPos>Destroyer.get(e).getX()&&mouseXPos<(Destroyer.get(e).getX()+50))&&(mouseYPos>Destroyer.get(e).getY()&&mouseYPos<(Destroyer.get(e).getY()+50))&&Destroyer.get(e).getType().equals("ShipBox"))
            {
              Destroyer.remove(e);
            }
          }
          for(int e=AircraftCarrier.size()-1;e>=0;e--)
          {
            if((mouseXPos>AircraftCarrier.get(e).getX()&&mouseXPos<(AircraftCarrier.get(e).getX()+50))&&(mouseYPos>AircraftCarrier.get(e).getY()&&mouseYPos<(AircraftCarrier.get(e).getY()+50))&&AircraftCarrier.get(e).getType().equals("ShipBox"))
            {
              AircraftCarrier.remove(e);
            }
          }
          for(int e=Submarine.size()-1;e>=0;e--)
          {
            if((mouseXPos>Submarine.get(e).getX()&&mouseXPos<(Submarine.get(e).getX()+50))&&(mouseYPos>Submarine.get(e).getY()&&mouseYPos<(Submarine.get(e).getY()+50))&&Submarine.get(e).getType().equals("ShipBox"))
            {
              Submarine.remove(e);
            }
          }
          numOfShipBoxes--;
        }
        else if((mouseXPos>boxes[r][c].getX()&&mouseXPos<(boxes[r][c].getX()+50))&&(mouseYPos>boxes[r][c].getY()&&mouseYPos<(boxes[r][c].getY()+50))&&boxes[r][c].getType().equals("WaterBox"))
        {
          boxes[r][c].missed();
          score-=25;
          boxes[r][c]= new ClickedBox(boxes[r][c].getX(),boxes[r][c].getY(),boxes[r][c].getSize(),boxes[r][c].getType());
        }
      }
    }
  }
  else if((mouseX>700&&mouseX<800)&&(mouseY>550&&mouseY<600)&&player1Turn==true&&numOfShipBoxes==0)//checks if mouse clicked start over button
  {
    setup();
  }
}
class Box
{
  int x,y; //x and y positions of box
  int w,h; //width and height of box
  Box(int xpos,int ypos,int width, int height)
  {
    x=xpos;
    y=ypos;
    w=width;
    h=height;
  }
  public int getX()
  {
    return x;
  }
  public int getY()
  {
    return y;
  }
  public int getSize()
  {
    return w;
  }
  public String getType()
  {
    return "";
  }
  public boolean isMiss()
  {
    return false;
  }
  public boolean isHit()
  {
    return false;
  }
  public boolean isClicked()
  {
    return false;
  }
  public void gotHit()
  {
  }
  public void missed()
  {
  }
}
class WaterBox extends Box//box that does not hold a ship value
{
  boolean miss=false;
  String type;
  WaterBox(int x,int y,int size)
  {
    super(x,y,size,size);
    type="WaterBox";
  }
  @Override
public void missed()
  {
    miss=true;
  }
  @Override
public boolean isMiss()
  {
    return miss;
  }
  @Override
public String getType()
  {
    return type;
  }
}

class ShipBox extends Box//ships
{
  boolean hit=false;
  String type;
  ShipBox(int x,int y,int size)
  {
    super(x,y,size,size);
    type="ShipBox";
  }
  @Override
public void gotHit()
  {
    hit=true;
  }
  @Override
public boolean isHit()
  {
    return hit;
  }
  @Override
public String getType()
  {
    return type;
  }
}
class ClickedBox extends Box//if the box has been clicked
{
  boolean clicked=true;
  String type;
  ClickedBox(int x,int y,int size,String t)
  {
    super(x,y,size,size);
    type="clicked"+t;
  }
  @Override
public boolean isClicked()
  {
    return clicked;
  }
  @Override
public String getType()
  {
    return type;
  }
}
  @Override
public void settings() {  size(1000,650); }
  static public void main(String[] passedArgs) {
	    String[] appletArgs = new String[] { "BattleShip" };
	    if (passedArgs != null) {
	      PApplet.main(concat(appletArgs, passedArgs));
	    } else {
	      PApplet.main(appletArgs);
	    }

  }

}

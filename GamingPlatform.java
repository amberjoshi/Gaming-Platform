/*Assuming that platform runs in a way that cards hold nothing but id's and when swiped server
is checked for the balance of the particular card.*/
import exceptions.*;
import serverUtility.*;
import java.io.*;
public class GamingPlatform extends Exception
{
public int gameCost;
public Server server;
public GamingPlatform()
{
this.server=new Server();
}
public void setGameCost(int gameCost)
{
this.gameCost=gameCost;
}
public int getGameCost() //This Can be used to display cost on the swiping screen
{
return this.gameCost;
}
public void startGame()
{
System.out.println("Playing the Game....");
System.out.println("The Game is Completed, Please Swipe out to go to next Platform");
}
public void onSwipedIn(int id) throws InsufficientBalanceException
{
if(server.getBalance(id)<10) throw new InsufficientBalanceException("Balance Should be atleast 10");
startGame();
}
public int onSwipingOut(int id) throws InsufficientBalanceException //when returned a positive number, The player will be allowed to exit.
{
if(gameCost>server.getBalance(id)) throw new InsufficientBalanceException("Insufficient balance in card, Add more to exit");
server.setBalance(id,server.getBalance(id)-gameCost);
return 1;
}
}
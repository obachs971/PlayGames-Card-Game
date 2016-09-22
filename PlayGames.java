import javax.swing.JOptionPane;
import java.util.*;
public class PlayGames 
{
	public static int cardValue;
	public static int suitValue;
	public static String cardName;
	public static void main(String[] args)
	{
		callCardGame();
	}
	public static void callCardGame()
	{
		String userInput;
		char hitOrStand;
		int numPlayers;
		int sumOfCards = 0;
		boolean acePresent = false;
		userInput = JOptionPane.showInputDialog("How many players for this card game?");
		numPlayers = Integer.parseInt(userInput);
		
		for(int i = 1; i <= numPlayers; i++)
		{
			JOptionPane.showMessageDialog(null, "Player " + i + ", get ready.");
			for(int j = 1; j <= 2; j++)
			{
				getCardValue();
				getCardSuit();
				getCardName();
				
				if(cardValue == 1)
				{
					cardValue = 11;
					acePresent = true;
				}
				else{}
				
				sumOfCards += cardValue;
				
				if(sumOfCards > 21)
				{
					sumOfCards -= 10;
				}
				else{}
				
				JOptionPane.showMessageDialog(null, "You are dealt an " + cardName + ".");
			}
			
			if(sumOfCards == 21)
			{
				JOptionPane.showMessageDialog(null, "Congrats! You got Black Jack!");
			}
			else
			{
				do
				{
					userInput = JOptionPane.showInputDialog("The sum of your cards is " + sumOfCards + "\nPlease enter a command:\nType in a S to Stand\nType in a H to Hit");
					userInput = userInput.toUpperCase();
					hitOrStand = userInput.charAt(0);
					
					while((hitOrStand != 'H') && (hitOrStand != 'S'))
					{
						JOptionPane.showMessageDialog(null, "Sorry, you either can Type S or H. Please ret again.");
						userInput = JOptionPane.showInputDialog("Please enter a command:\nType in a S to Stand\nType in a H to Hit");
						userInput = userInput.toUpperCase();
						hitOrStand = userInput.charAt(0);
					}
					if(hitOrStand == 'H')
					{
						getCardValue();
						getCardSuit();
						getCardName();
						if((cardValue == 1) && (sumOfCards < 11))
						{
							cardValue = 11;
							acePresent = true;
						}
						else{}
						
						sumOfCards += cardValue;
						
						if((sumOfCards > 21) && (acePresent == true))
						{
							sumOfCards -= 10;
						}
						else if(sumOfCards > 21)
						{
							JOptionPane.showMessageDialog(null, "Ouch! You went over 21. The sum of your cards is " + sumOfCards);
						}
						else{}
					}
					
					else{}
					
				}while((sumOfCards < 21) || (hitOrStand == 'S'));
				
			}
			
				
		}
	}
	public static void getCardValue()
	{
		Random rand = new Random();
		cardValue = rand.nextInt(13) + 1;
	}
	public static void getCardSuit()
	{
		Random rand = new Random();
		suitValue = rand.nextInt(4) + 1;
	}
	public static void getCardName()
	{
		String nameCardValue;
		String nameSuit;
		switch(cardValue)
		{
		case 1:
			nameCardValue = "Ace";
			break;
		case 2:
			nameCardValue = "2";
			break;
		case 3:
			nameCardValue = "3";
			break;
		case 4:
			nameCardValue = "4";
			break;
		case 5:
			nameCardValue = "5";
			break;
		case 6:
			nameCardValue = "6";
			break;
		case 7:
			nameCardValue = "7";
			break;
		case 8:
			nameCardValue = "8";
			break;
		case 9:
			nameCardValue = "9";
			break;
		case 10:
			nameCardValue = "10";
			break;
		case 11:
			nameCardValue = "Jack";
			break;
		case 12:
			nameCardValue = "Queen";
			break;
		default:
			nameCardValue = "King";
			break;
		}
		switch(suitValue)
		{
		case 1:
			nameSuit = "Spades";
			break;
		case 2:
			nameSuit = "Hearts";
			break;
		case 3:
			nameSuit = "Clubs";
			break;
		default:
			nameSuit = "Diamonds";
			break;
		}
		cardName = nameCardValue + " of " + nameSuit;
	}
	
}

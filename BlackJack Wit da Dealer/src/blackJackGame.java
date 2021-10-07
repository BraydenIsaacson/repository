import java.util.Scanner;

public class blackJackGame
	{
		
		public static void main(String[] args)
			{
				Deck.fillDeck();
				Deck.shuffle();
				PlayerHand.giveHands();
				blackjack();
			}
		public static void displayCards()
		{
			for(int i=0; i<Deck.deck.size(); i++)
				{
					System.out.println(Deck.deck.get(i).getRank()+ " of " + Deck.deck.get(i).getSuit());
				}
		}
		public static void dealCards()
		{
			int min = 1;
			int max = 52;
			int number = (int)(Math.random()*(max-min+1));
			//System.out.println(number);
			int min1 = 1;
			int max1 = 52;
			int number2 = (int)(Math.random()*(max1-min1+1));
			//System.out.println(number2);
		}
		public static void blackjack()
			{
			System.out.println("How much do you bet?");
			Scanner userBet = new Scanner (System.in);
			var playerBet = userBet.nextLine();
			int playerCardValue = Deck.deck.get(0).getValue() + Deck.deck.get(1).getValue();
			System.out.println("Player card value = "+playerCardValue);
			int dealerCardValue = Deck.deck.get(2).getValue() + Deck.deck.get(3).getValue();
			boolean loop = true;
			boolean stop = true;
			while(loop)
			{
			if(playerCardValue == 21)
				{
					System.out.println("You won!");
				}
			else if(playerCardValue > 21)
				{
					System.out.println("You lost your money lol.");
				}
			else
				{
					System.out.println("Do you hit?");
				}
			//boolean stop = true;
			int k=4;
			while(stop)
				{
					Scanner userHit = new Scanner (System.in);
					String userGo  = userHit.nextLine();
					if(userGo.equals("Yes") || userGo.equals("yes"))
						{
							int afterHitCard = (Deck.deck.get(k).getValue());
							int total = afterHitCard + playerCardValue;
							System.out.println(total + " = Total Value");
							playerCardValue = afterHitCard + playerCardValue;
							k=k+1;
							if(total > 21)
								{
									int ki = k-1;
									int cardValueGreater =Deck.deck.get(ki).getValue();
									System.out.println("Card value = "+cardValueGreater);
									System.out.println("You lose.");
									loop = false;
									stop = false;
								}
							if(total == 21)
								{
									System.out.println("You win!");
									loop = false;
									stop = false;
								}
							//if(total < 21) 
								//{
								//	stop = false;
							//}
						}
					if(userGo.equals("No") || userGo.equals("no"))
						{
							System.out.println("Dealer's starting card value = "+dealerCardValue);
							boolean dealerLessPlayer = true;			
							while(dealerLessPlayer)
								{
									
							if (dealerCardValue < playerCardValue)
								{
									k = k+1;
									int dealerHit = (Deck.deck.get(k).getValue());
									int dealerTotal = dealerHit + dealerCardValue;
									dealerCardValue = dealerHit + dealerCardValue;
									//k=k+1;
									System.out.println("Dealer hit a "+Deck.deck.get(k).getRank());
									System.out.println("Dealer's total = "+ dealerTotal);
									loop = false; 
									stop = false;
								}
							if(dealerCardValue > 21)
								{
									//System.out.println("Dealer's total = "+ dealerTotal);
									k = k+1;
									int dealerHit = (Deck.deck.get(k).getValue());
									dealerCardValue = dealerHit + dealerCardValue;
									System.out.println("You win!");
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							if(dealerCardValue == 21)
								{
									System.out.println("Dealer hit 21, lol you lost. Gimme yo money");
									System.out.println("You lose!");
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							if(dealerCardValue > playerCardValue && dealerCardValue <= 21)
								{
									System.out.println("You lost.");
									loop = false;
									dealerLessPlayer = false;
									stop = false;
								}
							
								}
						}
				}
		}
			}
	}
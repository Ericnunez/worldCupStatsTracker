/* Eric Nunez
*  World Cup database application
*  
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Scanner;
public class MainApp extends dbInstructions
{
   public static void main(String[] args)
   {
   		Scanner input = new Scanner(System.in);
         int teamMenuChoice;
         int statMenuChoice;
         int mainChoice;
         boolean loginSucc = false;
         String teamName;
   		System.out.println("Welcome to the 2018 FIFA World Cup Bracket");
      	System.out.println("Please log in to begin!");
      	System.out.println();
         do{
            System.out.print("Username: ");
            String username = input.nextLine();
            System.out.print("Password: ");
            String password = SHA_HashFunction.getHash(input.nextLine());
            try
            {
               Connection connie = Connect.getConnection();
               loginSucc =loginSuccess(connie, username, password);
               
               
            }
               catch (SQLException e)
               {
                  e.printStackTrace();
               }

            
         }while(loginSucc == false);
         System.out.println();
         
         
         
      	do{
      		System.out.println("Main Menu");
      		System.out.println("1: Select a team");
      		System.out.println("2: View World Cup statistics");
      		System.out.println("3: Enter a match report");
            System.out.println("4: Update a match report");
            System.out.println("5: Delete a match report");
      		System.out.println("6: Exit");

      		mainChoice = input.nextInt();
            input.nextLine();

      		if(mainChoice == 1){
      			
      				System.out.print("Please Select a team: ");
                  teamName = input.nextLine();
      				System.out.println();
               do{
      				System.out.println("1: View team details");
      				System.out.println("2: View matches");
      				System.out.println("3: View discipline");
      				System.out.println("4: View goals");
                  System.out.println("5: View All teams");
      				System.out.println("6: Exit");

      				teamMenuChoice = input.nextInt();
                  input.nextLine();
                  
                  if(teamMenuChoice == 1)// prints individual team details
                  {
                     try
                     {
                        Connection connie = Connect.getConnection();
                        dbInstructions.getTeamDetails(connie, teamName);
                     }
                        catch (SQLException e)
                        {
                           e.printStackTrace();
                        }
                     System.out.println();
                  }
                  if(teamMenuChoice == 2)// prints all matches from a specific team
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getTeamMatches(connie, teamName);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }
                     
                  if(teamMenuChoice == 3)// prints all the yellow and red cards from a specific teams matches
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getYellowCards(connie, teamName);
                           getRedCards(connie, teamName);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }
                  
                  if(teamMenuChoice == 4)// prints specific team goals                  
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getTeamGoals(connie, teamName);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }
                  if(teamMenuChoice == 5)// prints all the teams                  
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getAllTeams(connie);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }            
                     
      			}while(teamMenuChoice != 6);

      		}
      		else if (mainChoice == 2) {
            
               
      			do{
      				System.out.println("1: View total goals scored");
      				System.out.println("2: View total yellow cards given");
      				System.out.println("3: View total red cards given");
      				System.out.println("4: View total matches played so far");
      				System.out.println("5: Exit");

      				statMenuChoice = input.nextInt();
                  
                  if(statMenuChoice == 1)// prints all goals scroed in the world cup
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getAllGoals(connie);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }
                  if(statMenuChoice == 2)// prints all yellow card given
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getAllYellow(connie);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }
                  if(statMenuChoice == 3)//prints all red cards given out
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getAllRed(connie);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }
                  if(statMenuChoice == 4)//prints how many matches have been played
                  {
                     try
                        {
                           Connection connie = Connect.getConnection();
                           getMatchCount(connie);
                        }
                           catch (SQLException e)
                           {
                              e.printStackTrace();
                           }
                        System.out.println();
                  }

      			}while(statMenuChoice != 5);
      			
      		}
      		else if (mainChoice == 3) 
            {
               System.out.print("Match ID: ");
               int matchID = input.nextInt();
               input.nextLine();
               System.out.print("Group ID: ");
               String groupID = input.nextLine();
   				System.out.print("Stage type: ");
   				String stageID = input.nextLine();
   				System.out.print("Winning Team: ");
   				String winningTeam = input.nextLine();
   				System.out.print("Home Team:");
   				String home = input.nextLine();
               System.out.print("Away Team:");
   				String away = input.nextLine();
   				System.out.print("Goals For:");
   				int goalsFor = input.nextInt();
   				System.out.print("Goals Against:");
   				int goalsAgainst = input.nextInt();
   				System.out.print("Yellow Cards:");
   			   int yellow = input.nextInt();
   				System.out.print("Red Cards: ");
   				int red = input.nextInt();
               
               try
               {
                  Connection connie = Connect.getConnection();
                  insertMatchStat(connie, matchID, groupID, stageID, winningTeam, home, away, goalsFor, goalsAgainst, yellow, red);
               }
                  catch (SQLException e)
                  {
                     e.printStackTrace();
                  }
               System.out.println();
   			
      		}
            else if(mainChoice == 4) // update a match
            {
               System.out.print("Enter the match ID of the record you would like to update: ");
               int matchID = input.nextInt();
               System.out.print("Enter the goals the winning team scored: ");
               int goalsFor = input.nextInt();
               System.out.print("Enter the goals the Losing team scored: ");
               int goalsAgainst = input.nextInt();
               try
               {
                  Connection connie = Connect.getConnection();
                  updateMatch(connie, matchID, goalsFor, goalsAgainst);
               }
                  catch (SQLException e)
                  {
                     e.printStackTrace();
                  }
               System.out.println();
            }
            else if(mainChoice == 5)// delete a match
            {
               System.out.print("Enter the match ID of the record you would like to delete: ");
               int matchID = input.nextInt();
               
               try
               {
                  Connection connie = Connect.getConnection();
                  deleteMatch(connie, matchID);
               }
                  catch (SQLException e)
                  {
                     e.printStackTrace();
                  }
               System.out.println();
            }
            
      		else if (mainChoice == 6) {
      			System.out.println("Are you sure you want to exit?");
      			System.out.println("Enter 6 if you are sure");
      			mainChoice = input.nextInt();
      		}
            
  		}while(mainChoice != 6);
  	}
}

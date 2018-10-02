import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class dbInstructions
{
   public static void getTeamDetails(Connection conn, String teamName)throws SQLException
   {
      String sql = "SELECT * FROM Team WHERE teamName = ? ";
 
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, teamName);
      ResultSet result = statement.executeQuery();
 
      while (result.next())
      {
       String name = result.getString(1);
       String manager = result.getString(2);
       String nickname = result.getString(3);
       String homeJersey = result.getString(4);
       String awayJersey = result.getString(5);
       int ranking = result.getInt(6);
       String group = result.getString(7);
    
       String output = "%-12s Manager:%-20s Nickname:%-20s Home Jersey:%-15s Away Jersey:%-10s Fifa Ranking:%-2d Group:%s";
       System.out.println(String.format(output, name, manager, nickname, homeJersey, awayJersey, ranking, group));
      }
   }
   
   public static void getTeamMatches(Connection conn, String teamName)throws SQLException
   {
      String sql = "SELECT * FROM MatchStats where homeTeam = ? OR awayTeam = ? OR winningTeam = ?";
      
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, teamName);
      statement.setString(2, teamName);
      statement.setString(3, teamName);
      ResultSet result = statement.executeQuery();
      boolean empty = true;

         while (result.next())
         {
            empty = false;
            int matchID = result.getInt(1);
            String group = result.getString(2);
            String stage = result.getString(3);
            String win = result.getString(4);
            String home = result.getString(5);
            String away = result.getString(6);
            int goalFor = result.getInt(7);
            int goalAway = result.getInt(8);
            int yellow = result.getInt(9);
            int red = result.getInt(10);
            
            String output = "Match:%-3d Group:%-5s Type:%-13s Winner:%-12s Home:%-12s Away:%-12s Goals For:%-2d Goals Against:%-2d Yellow Cards:%-2d Red Cards:%-2d";
            System.out.println(String.format(output, matchID, group, stage, win, home, away, goalFor, goalAway, yellow, red));
         }
      if(empty)
      {
         System.out.println("Sorry " + teamName + " is not in the world Cup");
      }
   }
   public static void getTeamWins(Connection conn, String teamName)throws SQLException
   {
      String sql = "SELECT COUNT(winningTeam) FROM MatchStats where winningTeam = ?";
      
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, teamName);
      ResultSet result = statement.executeQuery();
      boolean empty = true;
      
      while(result.next())
      {
         int winTotal = result.getInt(1);
         
         String output = teamName + " total wins: " + winTotal;
         System.out.println(teamName + ": " + winTotal);
      }
   }
   
   public static void getKnockoutTeams(Connection conn, String stage)throws SQLException
   {
      String sql = "Select team.ranking, team.teamName from team join matchstats on (team.teamName = winningTeam OR team.teamName = homeTeam OR team.teamName = awayTeam) AND stageID = '?'order by team.ranking;";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, stage);
      ResultSet result = statement.executeQuery();
      boolean empty = true;
      
      while(result.next())
      {
         int ranking = result.getInt(1);
         String teamName = result.getString(2);
         
         String output = ranking + ": " + " " + teamName;
         System.out.println(output);
      }
   }
   
   public static void getYellowCards(Connection conn, String teamName)throws SQLException
   {
      String sql = "SELECT SUM(yellowCards) FROM (SELECT yellowCards FROM Matchstats WHERE winningteam = ? OR hometeam = ? OR awayTeam = ?)as currentYellow;";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, teamName);
      statement.setString(2, teamName);
      statement.setString(3, teamName);
      ResultSet result = statement.executeQuery();
      boolean empty = true;
      
      while(result.next())
      {
         int yellow = result.getInt(1);
         
         String output = teamName + " yellow cards: " + yellow;
         System.out.println(output);
      }
   }
   public static void getRedCards(Connection conn, String teamName)throws SQLException
   {
      String sql = "SELECT SUM(redCards) FROM (SELECT redCards FROM Matchstats WHERE winningteam = ? OR hometeam = ? OR awayTeam = ?)as currentRed;";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, teamName);
      statement.setString(2, teamName);
      statement.setString(3, teamName);
      ResultSet result = statement.executeQuery();
      boolean empty = true;
      
      while(result.next())
      {
         int red = result.getInt(1);
         
         String output = teamName + " red cards: " + red;
         System.out.println(output);
      }
   }
   public static void getTeamGoals(Connection conn, String teamName)throws SQLException
   {
      String sql = "SELECT (SELECT SUM(goalsAgainst) FROM matchStats WHERE NOT winningTeam = ? AND (awayTeam = ? OR homeTeam = ?))"
      + " + (SELECT SUM(goalsfor) FROM matchstats WHERE winningteam= ?)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, teamName);
      statement.setString(2, teamName);
      statement.setString(3, teamName);
      statement.setString(4, teamName);
      ResultSet result = statement.executeQuery();
      boolean empty = true;
      
      while(result.next())
      {
         int goals = result.getInt(1);
         
         String output = teamName + " have scored " + goals + " goals" ;
         System.out.println(output);
      }
   }
   
   public static void getAllGoals(Connection conn)throws SQLException
   {
      String sql = "select sum(goalsfor) + sum(goalsagainst) FROM matchStats";
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      boolean empty = true;
      
      while(result.next())
      {
         int goals = result.getInt(1);
         
         String output = "Total goals scored this World Cup so far: " + goals;
         System.out.println(output);
      }
   }
   
   public static void getAllTeams(Connection conn)throws SQLException
   {
      String sql = "SELECT * FROM team";
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      boolean empty = true;
      
      while (result.next())
      {
       String name = result.getString(1);
       String manager = result.getString(2);
       String nickname = result.getString(3);
       String homeJersey = result.getString(4);
       String awayJersey = result.getString(5);
       int ranking = result.getInt(6);
       String group = result.getString(7);
    
       String output = "%-12s Manager:%-20s Nickname:%-20s Home Jersey:%-15s Away Jersey:%-10s Fifa Ranking:%-2d Group:%s";
       System.out.println(String.format(output, name, manager, nickname, homeJersey, awayJersey, ranking, group));
      }
   }
   
   public static void getAllYellow(Connection conn)throws SQLException
   {
      String sql = "select sum(yellowCards) FROM matchStats";
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      boolean empty = true;
      
      while(result.next())
      {
         int yellow = result.getInt(1);
         
         String output = "Total yellow cards this World Cup so far: " + yellow;
         System.out.println(output);
      }
   }
   
   public static void getAllRed(Connection conn)throws SQLException
   {
      String sql = "select sum(redCards) + sum(redCards) From matchStats";
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      boolean empty = true;
      
      while(result.next())
      {
         int red = result.getInt(1);
         
         String output = "Total red cards this World Cup so far: " + red;
         System.out.println(output);
      }
   }
   
   public static void getMatchCount(Connection conn)throws SQLException
   {
      String sql = "select COUNT(matchID) From matchStats";
      
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery(sql);
      boolean empty = true;
      
      while(result.next())
      {
         int count = result.getInt(1);
         
         String output = "Total matches played this World Cup so far: " + count;
         System.out.println(output);
      }
   }
   
   public static void insertMatchStat(Connection conn, int matchID, String groupID, String stageID, String winningTeam, String homeTeam, String awayTeam, int goalsFor, int goalsAgainst, int yellowCards, int redCards) throws SQLException 
   {
	   String sql = "INSERT INTO  MatchStats(matchID, groupID, stageID, winningTeam, homeTeam, awayTeam, goalsFor, goalsAgainst, yellowCards, redCards)"
	            + "VALUES (?, ?, ?, ?,?,?, ?, ?, ?, ?)";
 
   	PreparedStatement statement = conn.prepareStatement(sql);
   	statement.setInt(1,matchID);
      statement.setString(2,groupID);
      statement.setString(3,stageID);
      statement.setString(4,winningTeam);
      statement.setString(5,homeTeam);
      statement.setString(6,awayTeam);
      statement.setInt(7,goalsFor);
      statement.setInt(8,goalsAgainst);
      statement.setInt(9,yellowCards);
      statement.setInt(10,redCards);
 
   	int rowsAffected = statement.executeUpdate();
   	if (rowsAffected > 0) 
      {
       	   System.out.println("A new match was inserted successfully!");
   	}
   }
   
   public static boolean loginSuccess(Connection conn, String username, String password)throws SQLException
   {
      String sql = "SELECT COUNT(*) FROM Users WHERE username = ? AND password = ?";
      
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1,username);
      statement.setString(2,password);
      ResultSet result = statement.executeQuery();
      int count = 0;
      while(result.next())
      {
         count = result.getInt(1);
      }
      if(count == 1)
      {
         System.out.println("Login Successful!");
         return true;
      }
      else
      {
         System.out.println("Login Unsuccessful!!!");
         return false;
      }
   }
   
   public static void updateMatch(Connection conn, int matchID, int goalFor, int goalAgainst) throws SQLException 
   {
   	String sql = "UPDATE matchStats SET goalsFor=?, goalsAgainst=? WHERE matchID=?";
   	PreparedStatement statement = conn.prepareStatement(sql);
   
   	statement.setInt(1,goalFor);
      statement.setInt(2,goalAgainst);
      statement.setInt(3,matchID);
      
   	int rowsAffected = statement.executeUpdate();
   	if (rowsAffected > 0) 
      {
   	   System.out.println("Successfully updated "+rowsAffected+"row(s)");
   	}  
   }
   
   public static void deleteMatch(Connection conn, int matchID) throws SQLException 
   {
	   String sql = "DELETE FROM matchStats WHERE matchID=?";
 
	   PreparedStatement statement = conn.prepareStatement(sql);

	   statement.setInt(1, matchID);
      
	   int rowsAffected = statement.executeUpdate();
      
	   if (rowsAffected > 0) 
      {
	      System.out.println("Successfully deleted "+rowsAffected+"row(s)");
	   }

    }
}
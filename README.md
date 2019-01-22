# worldCupStatsTracker
A java application that can track match statistics for the FIFA world cup. Uses mySQL.

## About
This is a text based program built with Java 8 and uses SQL as the database language as well as mySQL server.
Realistically this program can track any type of sporting event and can be modified to track custom statistics.
A sql file for building the schema is provided but can also be customized further.

I do plan on making a GUI for this program later and expanding the method offerings.

### Current void methods include:
getTeamDetails(Connection conn, String teamName)

getTeamMatches(Connection conn, String teamName)

getTeamWins(Connection conn, String teamName)
getKnockoutTeams(Connection conn, String stage)
getYellowCards(Connection conn, String teamName)
getRedCards(Connection conn, String teamName)
getTeamGoals(Connection conn, String teamName)
getAllGoals(Connection conn)
getAllTeams(Connection conn)
getAllYellow(Connection conn)
getAllRed(Connection conn)
getMatchCount(Connection conn)
insertMatchStat(Connection conn, int matchID, String groupID, String stageID, String winningTeam, String homeTeam, String awayTeam, int goalsFor, int goalsAgainst, int yellowCards, int redCards)
updateMatch(Connection conn, int matchID, int goalFor, int goalAgainst)
deleteMatch(Connection conn, int matchID)

### other methods:

boolean loginSuccess(Connection conn, String username, String password)

### Author
* **Eric Nunez**

### License
This project is licensed under the MIT License - see the LICENSE.md file for details.

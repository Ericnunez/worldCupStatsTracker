# Eric Nunez
# World Cup Tracker
CREATE DATABASE worldCup;
GRANT ALL PRIVILEGES ON worldCup.* TO ‘student’@’localhost’;
FLUSH PRIVILEGES;
use worldCup;

CREATE TABLE users(
    username varchar(50),
    password varchar(50));

Insert into Users (username, password)
 values	('jdoe', SHA('jdoe'));
    
CREATE TABLE Team(
	teamName varchar (30) NOT NULL PRIMARY KEY,
	manager varchar(255),
    nickname varchar(255),
    home_jersey_color varchar(255),
    away_jersey_color varchar(255),
    ranking int,
    groupLetter varchar(255));
    
CREATE TABLE KnockoutStage(
	stageID varchar(40) NOT NULL PRIMARY KEY);
    
INSERT INTO KnockoutStage(stageID)
	VALUES('Round of 16'),
				  ('Quarterfinals'),
                  ('Semifinals'),
                  ('Final');                
    
CREATE TABLE MatchStats(
	matchID int NOT NULL PRIMARY KEY,
    groupID varchar(50),
    stageID varchar(40),
    winningTeam varchar(30),
    homeTeam varchar(30),
    awayTeam varchar(30),
    goalsFor int,
    goalsAgainst int,
	yellowCards int,
    redCards int);

                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Uruguay', 'Oscar Tabarez', 'La Celeste', 'Sky Blue', 'White', 14, 'A'),
				  ('Russia',  'Stanislav Cherchesov', 'Sbornaya', 'Red', 'White', 65, 'A'),
                  ('Saudi Arabia',  'Juan Antonio Pizzi', 'The Green Falcons', 'White', 'Green', 67, 'A'),
                  ('Egypt',  'Hector Cuper', 'The Pharaohs', 'Red', 'White', 45, 'A');
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Spain', 'Luis Enrique', 'La Furia Roja', 'Red', 'White', 10, 'B'),
				  ('Portugal', 'Fernando Santos' , 'A Selecao das Quinas', 'Red', 'White', 4, 'B'),
                  ('Iran',  'Carlos Queiroz', 'Team Melli', 'White', 'Red', 37, 'B'),
                  ('Morroco',  'Hervé Renard', 'Atlas Lions', 'Red', 'White', 41, 'B');
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('France', 'Didier Deschamps', 'Les Bleus', 'Blue', 'White', 7, 'C'),
				  ('Denmark',  'Age Hareide', 'The Tin Soldiers', 'Red', 'White', 12, 'C'),
                  ('Peru',  'Ricardo Gareca', 'La Blanquirroja', 'White', 'Red', 11, 'C'),
                  ('Australia',  'Graham Arnold', 'Socceroos', 'Yellow', 'Green', 36, 'C');
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Croatia', 'Zlatko Dalić', 'Vatreni', 'Checkerd Red', 'Navy Blue', 20, 'D'),
				  ('Argentina',  'Jorge Sampaoli', 'La Albiceleste', 'White and Blue Stripes', 'Navy Blue', 5, 'D'),
                  ('Nigeria',  'Gernot Rohr', 'Super Eagles', 'Green and White pattern', 'Dark Green', 48, 'D'),
                  ('Iceland',  'Erik Hamren', 'Strákarnir okkar', 'Blue', 'White', 22, 'D');
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Brazil', 'Tite', 'Verde-Amarela', 'Yellow', 'Blue', 2, 'E'),
				  ('Switzerland',  'Vladimir Petković', 'Rossocrociati', 'Red', 'White', 6, 'E'),
                  ('Serbia',  'Mladen Krstajić', 'The White Eagles', 'Red', 'White', 34, 'E'),
                  ('Costa Rica',  'Oscar Ramirez', 'Los Ticos', 'Red', 'White', 23, 'E');
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Sweden', 'Janne Andersson', 'Blagult', 'Yellow', 'Blue', 24, 'F'),
				  ('Mexico',  'Juan Carlos Osorio', 'El Tri', 'Green', 'White', 15, 'F'),
                  ('Germany',  'Joachim Low', 'Die Mannschaft ', 'White', 'Green', 1, 'F'),
                  ('South Korea',  'Kim Pan-gon ', 'Taegeuk Warriors', 'Red', 'White', 57, 'F');                  
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Belgium', 'Roberto Martinez', 'The Red Devils', 'Red', 'Yellow', 3, 'G'),
				  ('England',  'Gareth Southgate', 'The Three Lions', 'White', 'Red', 12, 'G'),
                  ('Tunisia',  'Faouzi Benzarti', 'Eagles of Carthage', 'White', 'Red', 21, 'G'),
                  ('Panama',  'Gary Stempel', 'Los Canaleros', 'Red', 'White', 55, 'G');
                  
INSERT INTO Team(teamName, manager, nickname, home_jersey_color, away_jersey_color, ranking, groupLetter)
	VALUES('Colombia', 'Jose Pekerman', 'Los Cafeteros', 'Yellow', 'Blue', 16, 'H'),
				  ('Japan',  'Hajime Moriyasu', 'Samurai Blue', 'Blue', 'Grey', 61, 'H'),
                  ('Senegal',  'Aliou Cisse', 'The Lions of Teranga', 'White', 'Green', 27, 'H'),
                  ('Poland',  'Jerzy Brzeczek', 'The Eagles', 'White', 'Red', 8, 'H');                  
                  
INSERT INTO MatchStats(matchID, groupID, stageID, winningTeam, homeTeam, awayTeam, goalsFor, goalsAgainst, yellowCards, redCards)
VALUES(01, 'A', 'Group Stage', 'Russia', 'Russia',  'Saudi Arabia', 5, 0, 2, 0),
			  (02, 'A', 'Group Stage', 'Uruguay', 'Uruguay', 'Egypt', 1, 0, 2, 0),
              (03, 'B', 'Group Stage', 'Draw', 'Spain', 'Portugal', 3, 3, 2, 0),
              (04, 'B', 'Group Stage', 'Iran', 'Morocco', 'Iran', 1, 0, 4, 0),
              (05, 'C', 'Group Stage', 'France', 'France',  'Australia', 2, 1, 4, 0),
              (06, 'C', 'Group Stage', 'Denmark', 'Denmark',  'Peru', 1, 0, 3, 0),
              (07, 'D', 'Group Stage', 'Draw', 'Argentina', 'Iceland', 1, 1, 2, 0),
              (08, 'D', 'Group Stage', 'Croatia', 'Croatia', 'Nigeria', 2, 0, 3, 0),
              (09, 'E', 'Group Stage', 'Draw', 'Brazil', 'Switzerland', 1, 1, 2, 0),
              (10, 'E', 'Group Stage', 'Serbia', 'Costa Rica', 'Serbia', 1, 0, 4, 0),
              (11, 'F', 'Group Stage', 'Mexico', 'Germany', 'Mexico', 1, 0, 4, 0),
              (12, 'F', 'Group Stage', 'Sweden', 'Sweden', 'South Korea', 1, 0, 2, 0),
              (13, 'G', 'Group Stage', 'Belgium', 'Belgium', 'Panama', 3, 0, 5, 0),
			  (14, 'G', 'Group Stage', 'England', 'Tunisia', 'England', 2, 1, 3, 0),
              (15, 'H', 'Group Stage', 'Japan', 'Colombia', 'Japan', 2, 1, 2, 0),
              (16, 'H', 'Group Stage', 'Senegal', 'Poland', 'senegal', 2, 1, 3, 0),
              (17, 'A', 'Group Stage', 'Russia', 'Russia', 'Egypt', 3, 1, 4, 0),
              (18, 'A', 'Group Stage', 'Uruguay', 'Saudi Arabia', 'Uruguay', 1, 0, 2, 0),
              (19, 'B', 'Group Stage', 'Portugal', 'Morocco', 'Portugal', 1, 0, 1, 0),
              (20, 'B', 'Group Stage', 'Spain', 'Iran', 'Spain', 1, 0, 2, 0);
              
INSERT INTO MatchStats(matchID, groupID, stageID, winningTeam, homeTeam, awayTeam, goalsFor, goalsAgainst, yellowCards, redCards)
VALUES(21, 'C', 'Group Stage', 'France', 'France', 'Peru', 1, 0, 4, 0),
              (22, 'C', 'Group Stage', 'Draw', 'Denmark', 'Australia', 1, 1, 2, 0),
              (23, 'D', 'Group Stage', 'Croatia', 'Argentina', 'Croatia', 3, 0, 4, 0),
              (24, 'D', 'Group Stage', 'Nigeria', 'Nigeria', 'Iceland', 2, 0, 4, 1),
              (25, 'E', 'Group Stage', 'Brazil', 'Brazil', 'Costa Rica', 2, 0, 2, 0),
              (26, 'E', 'Group Stage', 'Switzerland', 'Serbia', 'Switzerland', 3, 0, 4, 0),
              (27, 'F', 'Group Stage', 'Germany', 'Sweden', 'Paname', 2, 1, 6, 0),
              (28, 'F', 'Group Stage', 'Mexico', 'South Korea', 'Mexico', 2, 1, 4, 0),
              (29, 'G', 'Group Stage', 'Belgium', 'Belgium', 'Tunisia', 5, 2, 3, 0),
              (30, 'G', 'Group Stage', 'England', 'Panama', 'England', 6, 1, 2, 0),
              (31, 'H', 'Group Stage', 'Colombia', 'Colombia', 'Poland', 3, 0, 4, 0),
              (32, 'H', 'Group Stage', 'Draw', 'Japan', 'Senegal', 2, 2, 4, 1),
              (33, 'A', 'Group Stage', 'Uruguay', 'Russia', 'Uruguay', 3, 0, 5, 0),
              (34, 'A', 'Group Stage', 'Saudi Arabia', 'Saudi Arabia', 'Egypt', 2, 1, 2, 0),
              (35, 'B', 'Group Stage', 'Draw', 'Iran', 'Portugal', 3, 0, 3, 0),
              (36, 'B', 'Group Stage', 'Draw', 'Spain', 'Morocco', 2, 2, 3, 0),
              (37, 'C', 'Group Stage', 'Draw', 'Denmark', 'France', 0, 0, 1, 0),
              (38, 'C', 'Group Stage', 'Peru', 'Peru', 'Australia', 2, 0, 4, 0),
              (39, 'D', 'Group Stage', 'Argentina', 'Nigeria', 'Argentina', 2, 1, 2, 0),
              (40, 'D', 'Group Stage', 'Croatia', 'Iceland', 'Croatia', 2, 1, 5, 1);
              
              
              
INSERT INTO MatchStats(matchID, groupID, stageID, winningTeam, homeTeam, awayTeam, goalsFor, goalsAgainst, yellowCards, redCards)
VALUES(41, 'E', 'Group Stage', 'Brazil', 'Serbia', 'Brazil', 2, 0, 2, 0),
              (42, 'E', 'Group Stage', 'Draw', 'Switzerland', 'Costa Rica', 2, 2, 4, 0),
              (43, 'F', 'Group Stage', 'South Korea', 'South Korea', 'Germany', 2, 0, 1, 0),
              (44, 'F', 'Group Stage', 'Sweden', 'Mexico', 'Sweden', 3, 0, 4, 0),
              (45, 'G', 'Group Stage', 'Belgium', 'Belgium', 'England', 1, 0, 1, 0),
              (46, 'G', 'Group Stage', 'Tunisia', 'Tunisia', 'Panama', 2, 1, 3, 0),
              (47, 'H', 'Group Stage', 'Poland', 'Japan', 'Poland', 1, 0, 3, 0),
              (48, 'H', 'Group Stage', 'Colombia', 'Senegal', 'Colombia', 1, 0, 2, 0),
              (49, 'none', 'Round of 16', 'Uruguay', 'Portugal', 'Uruguay', 2, 1, 3, 0),
              (50, 'none', 'Round of 16', 'France', 'France', 'Argentina', 4, 3, 4, 0),
              (51, 'none', 'Round of 16', 'Brazil', 'Mexico', 'Brazil', 2, 0, 4, 0),
              (52, 'none', 'Round of 16', 'Belgium', 'Japan', 'Belgium', 3, 2, 4, 0),
              (53, 'none', 'Round of 16', 'Russia', 'Russia', 'Spain', 4, 3, 4, 0),
              (54, 'none', 'Round of 16', 'Croatia', 'Denmark', 'Croatia', 3, 2, 4, 0),
              (55, 'none', 'Round of 16', 'Sweden', 'Sweden', 'Switzerland', 1, 0, 5, 0),
              (56, 'none', 'Round of 16', 'England', 'Colombia', 'England', 4, 3, 4, 0),
              (57, 'none', 'Quarterfinals', 'France', 'France', 'Uruguay', 2, 0, 2, 0),
              (58, 'none', 'Quarterfinals', 'Belgium', 'Brazil', 'Belgium', 2, 1, 2, 0),
              (59, 'none', 'Quarterfinals', 'Croatia', 'Russia', 'Croatia', 4, 3, 3, 0),
              (60, 'none', 'Quarterfinals', 'England', 'Sweden', 'England', 2, 0, 3, 0);
               

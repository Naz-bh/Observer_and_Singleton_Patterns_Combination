# Statement of Work
Playing Moderator-Game, the number of players is 5 by default and after that all the players
will get 10 numbers randomly. Then the game starts with moderators generated numbers,
moderator will generate 10 numbers randomly. If these generated numbers and the numbers
assigned to the players match at least 3 times, the players are going to win. There can be more
than one winner but also there can be no winner as well. In the end ‘Score Table’ is printed
and each players’ score can be viewed. </br></br>
The problem: We need to relate moderator and players also we need to use shared data
between players as well as moderator.</br></br>
# Explanation on Utilized Design Patterns
The Observer Pattern is used when there is one-to-many relationship between objects.
In our scenario, we implemented Moderator-player relation using observer pattern.</br></br>
The Singleton Pattern is a design pattern that restricts the instantiation of a class to one
object. In our case, we used shared data between players as well as moderator. For this we
create a singleton class and use the only instance of it.

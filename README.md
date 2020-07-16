# java-tennis-match
* represents a tennis match standalone application.
in this example it was require not to use any  java framework also no persistence layer, the aim
of the project is to be as simple as possible, only one rule: a good clear design.

# project specification
* see the document (___specification.docs___)[./specification.docx] in the project root. 

### how to run it ?
* mvn clean install
* run the App class witch is as simple automate that guide you how to execute the program. the user can select between
executing sprint1_useCase1, sprint1_useCase2 and sprint2_useCase1

# design
* see the document [___design.png___](./design.png) in the project root to understand the project design.

* the start point class is ___TennisMatch___ witch exposes mainly one service:
    * winPoint(Player):  allow to mark a goal for the given player, calculate the **current score** and then **display it**.

* calculating the score (ScoreCalculator): many way to calculate the score, depends on the rules described in the specification.
    * DefaultGameScoreCalculator: calculate the score for a simple game
    * DeuceGameScoreCalculator: calculate the score for a game with the rule DEUCE
    * SetScoreCalculator: calculate the score for a tennis match Set
    
* displaying the score (ScoreViewer):  many ways to display the score
    * DefaultGameScoreViewer : display the score for a simple game
    * DeuceGameScoreViewer: display the score for a game with the rule DEUCE
    * SetScoreViewer: display the score for a tennis match Set.

# versioning 
I created three git tag each for a project version (usecase1, usecase2 and usecase3).



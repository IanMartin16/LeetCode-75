import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        int n = senate.length();
        
        // Initialize the queues with the indices of each senator
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        
        // Process the rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            
            // The senator with the smaller index bans the other senator
            if (rIndex < dIndex) {
                radiant.add(rIndex + n); // Move the banned senator to the end of the queue
            } else {
                dire.add(dIndex + n); // Move the banned senator to the end of the queue
            }
        }
        
        // Determine the winning party
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate senate = new Dota2Senate();
        System.out.println(senate.predictPartyVictory("RD")); // Radiant
        System.out.println(senate.predictPartyVictory("RDD")); // Dire
        System.out.println(senate.predictPartyVictory("RRDD")); // Radiant
    }
}


//In the world of Dota2, there are two parties: the Radiant and the Dire.

//The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. 
//The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

//Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
//Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, 
//he can announce the victory and decide on the change in the game.
//Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. 
//Then if there are n senators, the size of the given string will be n.

//The round-based procedure starts from the first senator to the last senator in the given order. 
//This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

//Suppose every senator is smart enough and will play the best strategy for his own party. 
//Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
import java.util.*;
public class ElectionSystem {
    public static void main(String[] args){
        int p = 5;

        //adding the candidates to the LinkedList
        LinkedList<String> candidates = new LinkedList<>();
        candidates.add("Marcus Fenix");
        candidates.add("Dominic Santiago");
        candidates.add("Damon Baird");
        candidates.add("Cole Train");
        candidates.add("Anya Stroud");

        //should of voted for me tbh
        Election election = new Election(p);
        election.initializeCandidates(candidates);

        election.castVote("Cole Train");
        election.castVote("Cole Train");
        election.castVote("Marcus Fenix");
        election.castVote("Anya Stroud");
        election.castVote("Anya Stroud");

        System.out.println("\nTop 3 candidates after 5 votes: " + election.getTopKCandidates(3));

        election.rigElection("Marcus Fenix");
        System.out.println("\nTop 3 candidates after rigging the election: " + election.getTopKCandidates(3));
        //not sure what went wrong here
        System.out.println("\nFinal vote audit:");
        election.auditElection();
    }


}


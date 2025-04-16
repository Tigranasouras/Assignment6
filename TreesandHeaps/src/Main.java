import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        String[] namePool = {
                "Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud",
                "Rico Suave", "Daron Bob", "Kram Ram", "Jacey Stratton", "Bernie Sanders"
        };

        int candidateCount = 3 + rand.nextInt(8); // 3 to 10 inclusive

        int p = 5 + rand.nextInt(16); // random number

        List<String> candidateList = new ArrayList<>(Arrays.asList(namePool));
        Collections.shuffle(candidateList);
        LinkedList<String> candidates = new LinkedList<>(candidateList.subList(0, candidateCount));

        System.out.println("Number of Candidates: " + candidateCount);
        System.out.println("Candidates: " + candidates);
        System.out.println("Number of electorate votes (p): " + p);

        Election election = new Election(p);
        election.initializeCandidates(candidates);

        for (int i = 0; i < p; i++) {
            String randomCandidate = candidates.get(rand.nextInt(candidateCount));
            election.castVote(randomCandidate);
        }

        System.out.println("\nTop 3 candidates after " + p + " random votes: " + election.getTopKCandidates(3));

        // Rig the election in favor of a random candidate
        String chosen = candidates.get(rand.nextInt(candidateCount));
        System.out.println("\nRigging the election in favor of: " + chosen);
        election.rigElection(chosen);

        System.out.println("\nTop 3 candidates after rigging the election: " + election.getTopKCandidates(3));

        System.out.println("\nFinal vote audit:");
        election.auditElection();
    }

}
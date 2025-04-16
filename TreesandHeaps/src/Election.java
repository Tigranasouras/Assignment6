import java.util.*;
public class Election {
    private HashMap<String, Integer> voteMap;
    private int totalVotes;
    private int maxVotes;

    public Election(int p){
        voteMap = new HashMap<>();
        maxVotes = p;
        totalVotes = 0;
    }

    public void initializeCandidates(LinkedList<String> candidates){
        for(String candidate : candidates){
            voteMap.put(candidate, 0);
        }
    }

    public void castVote(String candidate){
        if(!voteMap.containsKey(candidate) || totalVotes >= maxVotes){
            return;
        }
        voteMap.put(candidate, voteMap.get(candidate) + 1); //updates priority queue
        totalVotes++;
    }

     public void castRandomVote(){
        if(totalVotes >= maxVotes) {
            return;
        }
            List<String> keys = new ArrayList<>(voteMap.keySet());
            String randomCandidate = keys.get(new Random().nextInt(keys.size())); // a random candidate from the queue
            castVote(randomCandidate);

        }

        public void rigElection(String candidate){
            if(!voteMap.containsKey(candidate)){
                return;
            }

            //Vote Reset
            for(String d : voteMap.keySet()){ // d for daron
                voteMap.put(d, 0);
            }

            voteMap.put(candidate, maxVotes);
            totalVotes = maxVotes; //the maximum votes
        }

        public List<String> getTopKCandidates(int k) {
                PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                        (a, b) -> b.getValue() - a.getValue() //shoutout program lang
                );
                maxHeap.addAll(voteMap.entrySet());

                List<String> topK = new ArrayList<>();
               for (int i = 0; i < k && !maxHeap.isEmpty(); i++){
                   topK.add(maxHeap.poll().getKey());
               }
                return topK;
        }
    public void auditElection() {
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // love being able to reuse code
        );
        maxHeap.addAll(voteMap.entrySet());

        while (!maxHeap.isEmpty()) { // the difference from the last one
            Map.Entry<String, Integer> entry = maxHeap.poll();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        } // kind of cool to be incorporate Heaps
    }
}

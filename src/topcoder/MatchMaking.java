package topcoder;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchMaking{

    public String[] getBestMatches(String[] members, String currentUser, int sf){


        HashMap<String, String[]> state = new HashMap<>();


        for(String member : members){
            String[] temp = member.split(" ");
            state.put(temp[0], temp);
        }


        String[] currentUserResponses = state.get(currentUser);
        String name = currentUserResponses[0];
        String gender = currentUserResponses[1];
        String requestedGender = currentUserResponses[2];

        ArrayList<String> potentialMatch = new ArrayList<>();

        for(String[] match : state.values()){
            if(!match[0].equals(name) &&
                    requestedGender.equals(match[1]) &&
                    (getScore(match, currentUserResponses) >= sf)){
                potentialMatch.add(match[0]);
            }
        }
		
		/*
		for(String member : members){
			String[] memberRespons = member.split(" ");
			if(!name.equals(memberRespons[0]) && requestedGender.equals(memberRespons[1]) && (getScore(memberRespons, currentUserResponses) >= sf)) {
				potentialMatch.add(memberRespons[0]);
			}		
		}
		*/

        //create an array
        String[] answer = new String[potentialMatch.size()];
        for(int i=0; i < answer.length; i++){
            answer[i] = potentialMatch.get(i);
        }

        return answer;
    }


    private int getScore(String[] matchResponses, String[] requiredResponse){
        int count = 0;
        for(int i=3; i < requiredResponse.length; i++){
            if(requiredResponse[i].equals(matchResponses[i])){
                count++;
            }
        }
        return count;
    }



}	
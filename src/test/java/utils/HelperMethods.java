package utils;

import java.util.Arrays;

public class HelperMethods {

    public static boolean checkRelevantSearchTerm(String keyTerm, String text){
        int relevantResultCount=0;
        String[] relevantKeySearchTerms = keyTerm.split(",");
        for(int i=0; i < relevantKeySearchTerms.length; i++){
            if(text.toLowerCase().contains(relevantKeySearchTerms[i].toLowerCase())){
                relevantResultCount +=1;
            }
        }
        return relevantResultCount>0;
    }
}

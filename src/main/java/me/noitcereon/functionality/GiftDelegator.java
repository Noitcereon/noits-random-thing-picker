package me.noitcereon.functionality;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiftDelegator {
    private final List<String> giftGivers;
    private final List<String> giftReceivers;

    public GiftDelegator(List<String> names){
        this.giftReceivers = names;
        this.giftGivers = names;
    }

    public Map<String, String> selectGiftPairings(){
        ThingChooser gifters = new ThingChooser(giftGivers);
        ThingChooser receivers = new ThingChooser(giftReceivers);
        Map<String, String> pairings = new HashMap<>();
        // For every participant
        // Remove each from their respective list
        // Add gift pairing
        for (String ignored : giftGivers) {
            Map.Entry<String, String> pair = chooseOnePair(gifters, receivers, 0);
            gifters.remove(pair.getKey());
            receivers.remove(pair.getValue());
            pairings.putIfAbsent(pair.getKey(), pair.getValue());
        }
        return pairings;
    }

    private Map.Entry<String, String> chooseOnePair(ThingChooser gifters, ThingChooser receivers, int attempts){
        // Choose a gift giver
        String giftGiver = gifters.choose();
        // Choose a gift receiver
        String giftReceiver = receivers.choose();
        // Check if they are the same
        if(giftGiver.equals(giftReceiver)){
            // YES: choose another gift receiver (what if there are not any left?)
            attempts++;
            if(attempts > 3) throw new IllegalArgumentException("Bad input. Cannot make fair pairing");
            Map.Entry<String, String> entry = chooseOnePair(gifters, receivers, attempts);
            if(!entry.getKey().equals(entry.getValue())) return entry;
        }
        // NO: return output
        return Map.entry(giftGiver, giftReceiver);
    }

}

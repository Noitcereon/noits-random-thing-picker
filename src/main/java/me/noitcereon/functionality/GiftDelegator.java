package me.noitcereon.functionality;

import me.noitcereon.ListChecker;
import me.noitcereon.exceptions.InvalidGiftPairingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class GiftDelegator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GiftDelegator.class);
    private final List<String> giftGivers;
    private final List<String> giftReceivers;

    public GiftDelegator(List<String> names){
        if(ListChecker.containsDuplicates(names)){
            throw new IllegalArgumentException("Duplicate names are not allowed.");
        }
        this.giftReceivers = names;
        this.giftGivers = names;
    }

    public Map<String, String> selectGiftPairings(){
        int numberOfTries = 0;
        try {
            numberOfTries++;
            ThingChooser gifters = new ThingChooser(giftGivers);
            ThingChooser receivers = new ThingChooser(giftReceivers);
            Map<String, String> pairings = new HashMap<>();

            while (!gifters.getOptions().isEmpty() && !receivers.getOptions().isEmpty()) {
                String nextGifter = gifters.chooseNext();
                Map.Entry<String, String> pair = chooseOnePair(nextGifter, receivers, 0);
                gifters.remove(pair.getKey());
                receivers.remove(pair.getValue());
                pairings.putIfAbsent(pair.getKey(), pair.getValue());
            }
            return pairings;
        }
        catch (InvalidGiftPairingException e){
            if(numberOfTries > 5){
                throw new IllegalArgumentException("Failed to generate a proper gift pairings list.");
            }
            LOGGER.warn("{}. Attempt number {}. Retrying...", e.getMessage(), numberOfTries);
            return selectGiftPairings();
        }
    }

    /**
     * @return A pairing with the Key being the giver and the Value being the receiver.
     */
    private Map.Entry<String, String> chooseOnePair(String nextGifter, ThingChooser receivers, int attempts) throws InvalidGiftPairingException {
        // Choose a gift receiver
        String giftReceiver = receivers.choose();
        // Check if they are the same
        if(nextGifter.equals(giftReceiver)){
            // YES: choose another gift receiver (what if there are not any left?)
            attempts++;
            if(attempts > giftReceivers.size())
                throw new InvalidGiftPairingException("Something went wrong during the choosing of a gift pair");
            Map.Entry<String, String> entry = chooseOnePair(nextGifter, receivers, attempts);
            if(!entry.getKey().equals(entry.getValue())) return entry;
        }
        // NO: return output
        return Map.entry(nextGifter, giftReceiver);
    }

}

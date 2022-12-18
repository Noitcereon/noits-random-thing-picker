package me.noitcereon.functionality;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GiftDelegatorTest {

    @Test
    void Given8UniqueNames_WhenGeneratingGiftPairs_ThenReturn8GiftPairs() {
        GiftDelegator giftDelegator = new GiftDelegator(TestData.getEvenAmountNamesWithoutDuplicates());
        Map<String, String> actual = giftDelegator.selectGiftPairings();

        int expected = 8;
        assertEquals(expected, actual.size());
    }
    @Test
    void Given8UniqueNames_WhenGeneratingGiftPairsMultipleTimes_ThenAlwaysReturn8GiftPairs() {
        int maxIterations = 100;
        int currentIteration = 0;
        while(maxIterations > currentIteration){
            currentIteration++;
            GiftDelegator giftDelegator = new GiftDelegator(TestData.getEvenAmountNamesWithoutDuplicates());
            Map<String, String> actual = giftDelegator.selectGiftPairings();

            int expected = 8;
            assertEquals(expected, actual.size());
        }
    }
    @Test
    void Given9UniqueNames_WhenGeneratingGiftPairs_ThenReturn8GiftPairs() {
        GiftDelegator giftDelegator = new GiftDelegator(TestData.getOddAmountNamesWithoutDuplicates());
        Map<String, String> actual = giftDelegator.selectGiftPairings();
        System.out.println(actual);
        int expected = 9;
        assertEquals(expected, actual.size());
    }
}
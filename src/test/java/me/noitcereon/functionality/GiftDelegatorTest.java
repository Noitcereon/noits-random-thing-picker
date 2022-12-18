package me.noitcereon.functionality;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GiftDelegatorTest {

    @Test
    void selectGiftPairings() {
        GiftDelegator giftDelegator = new GiftDelegator(TestData.getEvenAmountNamesWithoutDuplicates());
        Map<String, String> actual = giftDelegator.selectGiftPairings();

        int expected = 8;
        assertEquals(expected, actual.size());
    }
    @Test
    void selectGiftPairings_multipleTimes() {
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
}
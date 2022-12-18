package me.noitcereon;

import me.noitcereon.fake.data.FakeData;
import me.noitcereon.functionality.GiftDelegator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Hello world! The application is now starting.");
        GiftDelegator giftDelegator = new GiftDelegator(FakeData.getNames());
        Map<String, String> pairs = giftDelegator.selectGiftPairings();
        String pairsToString = pairs.toString();
        LOGGER.info("Pairs: {}", pairsToString);
    }
}
package me.noitcereon.functionality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThingChooser {
    private final List<String> options;
    private final Random random;
    private static final Logger LOGGER = LoggerFactory.getLogger(ThingChooser.class);

    public ThingChooser(List<String> options) {
        this.options = new ArrayList<>(options);
        this.random = new Random();
    }

    public String choose() {
        int selectedIndex = random.nextInt(0, options.size()); // max is exclusive, so no out-of-bound for .size().
        return options.get(selectedIndex);
    }

    public String chooseAndRemove() {
        String currentList = options.toString();
        LOGGER.debug(currentList);
        int selectedIndex = random.nextInt(0, options.size()); // max is exclusive, so no out-of-bound for .size().
        String output = options.get(selectedIndex);
        options.remove(selectedIndex);
        return output;
    }

    public void remove(String option) {
        options.remove(option);
    }

    public List<String> getOptions(){
        return options;
    }

}

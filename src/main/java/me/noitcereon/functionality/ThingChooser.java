package me.noitcereon.functionality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThingChooser {
    private final List<String> options;
    private final List<String> originalOptions;
    private final Random random;
    private static final Logger LOGGER = LoggerFactory.getLogger(ThingChooser.class);
    private int previouslyPickedIndex;
    private boolean isFirstNext;

    public ThingChooser(List<String> options) {
        this.options = new ArrayList<>(options);
        this.originalOptions = new ArrayList<>(options);
        this.random = new Random();
        this.previouslyPickedIndex = 0;
        this.isFirstNext = true;
    }

    public String choose() {
        int selectedIndex = random.nextInt(0, options.size()); // max is exclusive, so no out-of-bound for .size().
        return options.get(selectedIndex);
    }
    public String chooseNext() {
        int nextIndex = previouslyPickedIndex + 1;
        if(isFirstNext){
            isFirstNext = false;
            return originalOptions.get(0);
        }
        if(nextIndex >= originalOptions.size()){
            previouslyPickedIndex = 0;
            return originalOptions.get(0);
        }
        previouslyPickedIndex++;
        return originalOptions.get(nextIndex);
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

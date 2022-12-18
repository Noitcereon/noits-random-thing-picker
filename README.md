# noits-random-thing-picker

A tiny project, which aims to solve the issue of picking pairs, where each pair only has two connections:
being a gifter to one person and a receiver from another.

The project has two main functionality classes: `ThingChooser` and `GiftDelegator`


## Install

It is a console application, which uses Maven for dependency management.

So install as a standard Maven project you your favorite IDE and it should run.

## Usage

### ThingChooser
```
 List<String> names = new ArrayList<>();
        names.add("Susanne");
        names.add("Michael");
        names.add("Hjalte");
        names.add("Kari");
ThingChooser chooser = new ThingChooser(names);

// chooses a pseudo random name from the list it was initialized with.
String result = chooser.choose() 

// chooses a thing from the list like the choose method, but also removes that option from future picks.
String result2 = chooser.chooseAndRemove() 
```

### GiftDelegator

```
        List<String> names = new ArrayList<>();
        names.add("Susanne");
        names.add("Michael");
        names.add("Hjalte");
        names.add("Kari");
        names.add("Thomas");
        names.add("Freja");
        names.add("Noah");
        names.add("Jacob");
        
        GiftDelegator giftDelegator = new GiftDelegator(FakeData.getNames());
        Map<String, String> pairs = giftDelegator.selectGiftPairings();
        
```        
        

## Maintainer
[Noitcereon](https://github.com/Noitcereon/)

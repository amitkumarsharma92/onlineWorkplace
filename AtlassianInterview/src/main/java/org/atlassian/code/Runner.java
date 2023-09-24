package org.atlassian.code;

public class Runner {
    public static void main(String[] args) {
        ContentManager manager = new ContentManager();

        manager.increasePopularity("7");
//        manager.mostPopular();
        manager.increasePopularity("7");
//        manager.mostPopular();
        manager.increasePopularity("8");
        manager.mostPopular();

        manager.increasePopularity("8");
//        manager.mostPopular();
        manager.increasePopularity("8");
        manager.mostPopular();


        manager.decreasePopularity("8");
        manager.decreasePopularity("8");
        manager.mostPopular();

        manager.increasePopularity("9");
        manager.increasePopularity("9");

        manager.decreasePopularity("7");
        manager.mostPopular();


    }
}

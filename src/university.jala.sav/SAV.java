package university.jala.sav;

import sav.SavSettings;

public class SAV {
    private static final String EQUAL = "=";
    private static final String BUBBLESORT = "b";
    private static final String INSERTIONSORT = "i";
    private static final String SELECTIONSORT = "s";

    public static void main(String[] args) throws InterruptedException {
        try {
            String algorithm = args[0].split(EQUAL)[1];
            String type = args[1].split(EQUAL)[1];
            String orderingType = args[2].split(EQUAL)[1];
            String entry = args[3].split(EQUAL)[1];
            String array = args[4].split(EQUAL)[1];
            String speed = args[5].split(EQUAL)[1];

            DataVerifier dataVerifier = new DataVerifier(algorithm, type, orderingType, entry, array, speed);


            if (dataVerifier.getAlgorithm().equals(BUBBLESORT)) {
                BubbleSort bubbleSort = new BubbleSort(dataVerifier.getVerifiedArray(), orderingType, speed);
                bubbleSort.sort();
            } else if (dataVerifier.getAlgorithm().equals(INSERTIONSORT)) {
                InsertionSort insertionSort = new InsertionSort(dataVerifier.getVerifiedArray(), orderingType, speed);
                insertionSort.sort();
            } else if (dataVerifier.getAlgorithm().equals(SELECTIONSORT)) {
                SelectionSort selectionSort = new SelectionSort(dataVerifier.getVerifiedArray(), orderingType, speed);
                selectionSort.sort();
            }

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
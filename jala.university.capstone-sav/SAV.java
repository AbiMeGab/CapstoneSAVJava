public class SAV {
    public static void main(String[] args) {
        try {
            String algorithm = args[0].split("=")[1];
            String type = args[1].split("=")[1];
            String ordering = args[2].split("=")[1];
            String entry = args[3].split("=")[1];
            String array = args[4].split("=")[1];
            String speed = args[5].split("=")[1];

            DataVerifier dataVerifier = new DataVerifier(algorithm, type, ordering, entry, array, speed);
                if (dataVerifier.getAlg().equalsIgnoreCase("b")) {
                    BubbleSort bubbleSort = new BubbleSort(dataVerifier.getVerfiedArray(), ordering, speed);
                    bubbleSort.sort();
                } else if (dataVerifier.getAlg().equalsIgnoreCase("i")) {
                    InsertionSort insertionSort = new InsertionSort(dataVerifier.getVerfiedArray(), ordering, speed);
                    insertionSort.sort();
                } else if (dataVerifier.getAlg().equalsIgnoreCase("s")) {
                    SelectionSort selectionSort = new SelectionSort(dataVerifier.getVerfiedArray(), ordering, speed);
                    selectionSort.sort();
                }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

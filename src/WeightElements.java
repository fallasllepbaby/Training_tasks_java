public class WeightElements {
    private int[] array;

    // GETTERS AND SETTERS

    public WeightElements(int[] values, int[] weights) {
        int arrayLength = 0;
        for(int weight : weights) {
            arrayLength += weight;
        }
        array = new int[arrayLength];

        int cursor = 0;

        for(int i = 0; i < weights.length; i++) {
            for(int j = 0; j < weights[i]; j++) {
                array[cursor++] = values[i];
            }
        }
    }

    public int getRandom() {
        int random = (int) Math.floor(Math.random() * array.length);
        return array[random];
    }
}

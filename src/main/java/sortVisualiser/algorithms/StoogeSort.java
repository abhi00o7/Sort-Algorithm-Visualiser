package sortVisualiser.algorithms;

import sortVisualiser.SortArray;


public class StoogeSort implements ISortAlgorithm {

    public void stoogeSort(SortArray array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        if (array.getValue(lowIndex) > array.getValue(highIndex)) {
            array.swap(lowIndex, highIndex, getDelay(), true);
        }

        if (highIndex - lowIndex + 1 > 2) {
            int t = (highIndex - lowIndex + 1) / 3;
            stoogeSort(array, lowIndex, highIndex - t);
            stoogeSort(array, lowIndex + t, highIndex);
            stoogeSort(array, lowIndex, highIndex - t);
        }
    }

    @Override
    public void runSort(SortArray array) {
        stoogeSort(array, 0, array.arraySize() - 1);
    }

    @Override
    public String getName() {
        return "Stooge sort";
    }

    @Override
    public long getDelay() {
        return 5;
    }
}
//package com.tefuna.toybox.sort.merge;
//
//import java.util.Arrays;
//
//import javax.swing.SortOrder;
//
//import com.tefuna.test.sort.common.element.SortElement;
//import com.tefuna.toybox.sort.AbstractSort;
//
//public class MergeSort extends AbstractSort {
//
//    @Override
//    public SortElement[] sort(SortElement[] original) {
//
//        if (original == null) {
//            throw new IllegalArgumentException("arg is null");
//        }
//
//        SortElement[] sorted = Arrays.copyOf(original, original.length);
//        this.getArrayPrinter().printArray(sorted);
//
//        sorted = mergeSort(sorted);
//        return sorted;
//    }
//
//    /**
//     * 
//     *
//     @param parts
//     * @return
//     */
//    private SortElement[] mergeSort(SortElement[] parts) {
//
//        // getArrayPrinter().printArray(parts);
//
//        int length = parts.length;
//        if (length <= 1) {
//            return parts;
//        }
//
//        // divide array.
//        SortElement[] parts1 = new SortElement[length / 2];
//        for (int i = 0; i < parts1.length; i++) {
//            parts1[i] = parts[i];
//        }
//
//        SortElement[] parts2 = new SortElement[length - (length / 2)];
//        for (int i = 0; i < parts2.length; i++) {
//            parts2[i] = parts[parts1.length + i];
//        }
//
//        parts1 = mergeSort(parts1);
//        parts2 = mergeSort(parts2);
//
//        merge(parts1, parts2, parts);
//
//        return parts;
//    }
//
//    /**
//     * 
//     * @param a
//     * @param b
//     * @return
//     */
//    private void merge(SortElement[] a, SortElement[] b, SortElement[] merged) {
//
//        getArrayPrinter().printArray(merged);
//
//        int[] prePosArray = new int[merged.length];
//        for (int i = 0; i < merged.length; i++) {
//            prePosArray[i] = merged[i].getPosition();
//        }
//
//        int i = 0, j = 0;
//        while (i < a.length || j < b.length) {
//            if (j >= b.length
//                    || (i < a.length && a[i].getValue() <= b[j].getValue())) {
//                merged[i + j] = a[i];
//                // a[i].move(merged[i + j].getPosition());
//                // swapSortElement(merged[i + j], a[i]);
//                i++;
//            } else {
//                merged[i + j] = b[j];
//                // b[j].move(merged[i + j].getPosition());
//                // swapSortElement(merged[i + j], b[j]);
//                j++;
//            }
//            // getArrayPrinter().printArray(merged);
//        }
//
//        for (i = 0; i < merged.length; i++) {
//            // merged[i].setPosition(position);
//        }
//        getArrayPrinter().printArray(merged);
//
//    }
//}

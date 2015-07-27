package com.tefuna.toybox.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.tefuna.toybox.sort.algorithm.BitonicSort;
import com.tefuna.toybox.sort.algorithm.BogoSort;
import com.tefuna.toybox.sort.algorithm.BubbleSort;
import com.tefuna.toybox.sort.algorithm.GnomeSort;
import com.tefuna.toybox.sort.algorithm.HeapSort;
import com.tefuna.toybox.sort.algorithm.InsertionSort;
import com.tefuna.toybox.sort.algorithm.MergeSort;
import com.tefuna.toybox.sort.algorithm.OddEvenSort;
import com.tefuna.toybox.sort.algorithm.QuickSort;
import com.tefuna.toybox.sort.algorithm.SelectionSort;
import com.tefuna.toybox.sort.algorithm.ShakerSort;
import com.tefuna.toybox.sort.algorithm.ShellSort;
import com.tefuna.toybox.sort.common.constant.SortProperty;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.DefaultPrinter;
import com.tefuna.toybox.sort.common.printer.JsonPrinter;
//import com.tefuna.toybox.sort.merge.MergeSort;
import com.tefuna.toybox.sort.common.printer.Printer;

public class Main {

    public static void main(String[] args) throws IOException {

        int arraysize = 7;
        SortElement[] original = new SortElement[arraysize];
        SortElement[] sortArray = new SortElement[arraysize];
        for (int i = 0; i < original.length; i++) {
            SortElement element = new SortElement();
            element.setId(i);
            element.setValue((int) (Math.random() * 100));
            element.setPrePosition(i);
            element.setPosition(i);
            element.setSorted(false);
            original[i] = element;
            sortArray[i] = new SortElement(element);
        }

        // BubbleSort sort = new BubbleSort();
        // SelectionSort sort = new SelectionSort();
        // InsertionSort sort = new InsertionSort();
        BogoSort sort = new BogoSort();
        // ShakerSort sort = new ShakerSort();
        // ShellSort sort = new ShellSort();
        // GnomeSort sort = new GnomeSort();
        // MergeSort sort = new MergeSort();
        // QuickSort sort = new QuickSort();
        // HeapSort sort = new HeapSort();
        // OddEvenSort sort = new OddEvenSort();

        // BitonicSort sort = new BitonicSort();
        // if (sort instanceof BitonicSort) {
        // original = fillToBitonic(original);
        // sortArray = fillToBitonic(sortArray);
        // }

        // Printer printer = new DefaultPrinter();
        Printer printer = new JsonPrinter();
        sort.setPrinter(printer);
        sort.execute(original, sortArray);

        System.out.println(printer.printAll());
        File file = new File("C:/workspace/webview/toybox/sort/data.json");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        pw.println(printer.printAll());
        pw.close();

        return;
    }

    /**
     * only for bitonic sort.
     * 
     * @param array
     * @return
     */
    private static SortElement[] fillToBitonic(SortElement[] array) {

        int expval = 1;
        while (expval < array.length) {
            expval = expval * 2;
        }

        SortElement[] bitArray = new SortElement[expval];
        for (int i = 0; i < bitArray.length; i++) {
            if (i < array.length) {
                bitArray[i] = array[i];
            } else {
                SortElement element = new SortElement();
                element.setId(-i);
                element.setValue(Integer.parseInt(SortProperty.MAX_VALUE.getValue()));
                element.setPosition(i);
                element.setPrePosition(i);
                bitArray[i] = element;
            }
        }

        return bitArray;
    }
}

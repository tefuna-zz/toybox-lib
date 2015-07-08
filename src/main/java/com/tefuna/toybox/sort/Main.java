package com.tefuna.toybox.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.tefuna.toybox.sort.algorithm.BogoSort;
import com.tefuna.toybox.sort.algorithm.BubbleSort;
import com.tefuna.toybox.sort.algorithm.InsertionSort;
import com.tefuna.toybox.sort.algorithm.SelectionSort;
import com.tefuna.toybox.sort.algorithm.ShakerSort;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.DefaultPrinter;
import com.tefuna.toybox.sort.common.printer.JsonPrinter;
//import com.tefuna.toybox.sort.merge.MergeSort;
import com.tefuna.toybox.sort.common.printer.Printer;

public class Main {

    public static void main(String[] args) throws IOException {

        int arraysize = 100;
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
        // BogoSort sort = new BogoSort();
        ShakerSort sort = new ShakerSort();
        // MergeSort sort = new MergeSort();

//         Printer printer = new DefaultPrinter();
        Printer printer = new JsonPrinter();
        sort.setPrinter(printer);
        // Printer printer = sort.getPrinter();
        sort.execute(original, sortArray);

        System.out.println(printer.printAll());
        File file = new File("./data.json");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        pw.println(printer.printAll());
        pw.close();

        return;
    }
}

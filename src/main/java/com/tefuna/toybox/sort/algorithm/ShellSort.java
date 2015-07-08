package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;


public class ShellSort extends AbstractSort {

    private Printer printer;

    private static final int GAP_FACT = 3;

    @Override
    public SortName getSortName() {
        return SortName.SHELL_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();

        int gap = calcGap(array.length);


    //     while (gap > 0) {
    //
    //       for (int i = gap; i < array.length; i++) {
    //         for (int j = i; j > gap; j = j - gap ) {
    //           if (array[j].getValue() < array[j-gap].getValue()) {
    //
    //           } else {
    //             //is this ok?
    //             break;
    //           }
    //         }
    //       }
    //
    //       gap = gap / GAP_FACT;
    //     }
    //
    //
    //     return array;
    // }
    //
    //
    //     for (int i = 1; i < array.length; i++) {
    //         int insPos = -1;
    //         for (int j = i - 1; j >= 0; j--) {
    //             printer.setStepExchanging(array[i], array[j], SortOperation.COMPARING);
    //             if (array[i].getValue() < array[j].getValue()) {
    //                 if (j == 0) {
    //
    //                     insPos = 0;
    //                     break;
    //                 }
    //             } else {
    //                 insPos = j + 1;
    //                 break;
    //             }
    //         }
    //
    //         if (insPos != -1 && i > insPos) {
    //             insertSortElement(array, i, insPos);
    //             printer.setStepInsertion(array, i, insPos);
    //         }
    //     }

        return array;
    }




    private int calcGap(int arraysize) {

      int gap = 0;
      while (gap < arraysize) {
        gap = GAP_FACT * gap + 1;
      }

      return gap / GAP_FACT;

    }
}

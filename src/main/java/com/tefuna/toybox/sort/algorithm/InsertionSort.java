package com.tefuna.toybox.sort.algorithm;

import java.util.ArrayList;
import java.util.List;


import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

public class InsertionSort extends AbstractSort {

    private Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.INSERTION_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        List<SortElement> exchangeList = new ArrayList<SortElement>();

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
               System.out.println("aaa:" + array[j-1]);
               System.out.println("bbb:" + array[i]);
                printer.setStepExchanging(array[j-1], array[i], SortOperation.COMPARING);
                if (array[j-1].getValue() > array[i].getValue()) {
                  //TODO it is wrong.
                  // swapSortElement(array[j-1], array[i]);
                  exchangeList.add(array[j-1]);
                } else {
                    break;
                }
            }


            if (exchangeList.size() > 0) {
              System.out.println("before:" + exchangeList);
              exchangeList.add(array[i]);
              System.out.println("after:" + exchangeList);

              for (int j = exchangeList.size() - 1; j > 0; j--) {
                swapSortElement(exchangeList.get(j), exchangeList.get(j-1));
              }
              // insertSortElementById(exchangeList, array[i]);


              // insertSortElement(array, i, j);
              //
              // for (int k = 0; k < exchangeList.size()-1; k++) {
              //   swapSortElement(exchangeList.get(exchangeList.size()-1), exchangeList.get(k));
              // }


              printer.setStepAsExchangeList(exchangeList);
              exchangeList.clear();
            }

            //
            // if (insPos != -1 && i > insPos) {
            //     insertSortElement(array, i, insPos);
            //     printer.setStepInsertion(array, i, insPos);
            // }
        }

        return array;
    }
}

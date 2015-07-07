package com.tefuna.toybox.sort.insertion;

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

          for (int i = 1; i < array.length; i++) {
                System.out.println("i = " + i + "array.length = " + array.length);
              int insPos = -1;
              for (int j = i - 1; j >= 0; j--) {
                System.out.println("print exchange:" + j );
                  printer.setStepExchanging(array[i], array[j], SortOperation.COMPARING);
                  if (array[i].getValue() < array[j].getValue()) {
                    if (j == 0) {
                      insPos = 0;
                      break;
                    }

                  } else {

                    insPos = j + 1;
                    break;
                  }
              }


              System.out.println("from  = " + i + ": to = " + insPos);
              if (insPos != -1 && i > insPos) {
                insertSortElement(array, i, insPos);
                System.out.println("print insert:" + insPos );
                printer.setStepInsertion(array, i, insPos);

              }
          }

          return array;
      }


}

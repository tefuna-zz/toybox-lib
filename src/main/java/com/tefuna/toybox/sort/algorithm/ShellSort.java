package com.tefuna.toybox.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

public class ShellSort extends AbstractSort {

    private static final int GAP_FACT = 3;
    private Printer printer;

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
        List<SortElement> exchangeList = new ArrayList<SortElement>();

        while (gap > 0) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j >= gap; j = j - gap) {
                    printer.registStep(array, array[j - gap], array[i], SortOperation.COMPARING);
                    if (array[j - gap].getValue() > array[i].getValue()) {
                        exchangeList.add(0, array[j - gap]);
                    } else {
                        break;
                    }
                }

                if (exchangeList.size() > 0) {
                    exchangeList.add(array[i]);
                    shiftLastElement(exchangeList);

                    printer.registStepAsList(array, exchangeList, SortOperation.EXCHANGING);
                    exchangeList.clear();
                }

            }
            gap = gap / GAP_FACT;
        }

        return array;
    }

    /**
     * optimized gap: gap(n+1) = 3 * gap(n) + 1
     * 
     * @param arraysize
     * @return
     */
    private int calcGap(int arraysize) {

        int gap = 0;
        while (gap < arraysize) {
            gap = GAP_FACT * gap + 1;
        }

        return gap / GAP_FACT;
    }
}

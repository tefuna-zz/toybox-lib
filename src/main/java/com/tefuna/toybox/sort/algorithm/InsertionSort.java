package com.tefuna.toybox.sort.algorithm;

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
            int insPos = -1;
            for (int j = i - 1; j >= 0; j--) {
                printer.setStepExchanging(array[i], array[j], SortOperation.COMPARING);
                if (array[i].getValue() < array[j].getValue()) {
                    if (j == 0) {
                        // æ“ª‚Ü‚Å‚¢‚Á‚Ä‚à‘}“üˆÊ’u‚ª“Á’è‚Å‚«‚È‚¢ = æ“ª‚ð‘}“üˆÊ’u‚Æ‚·‚éB
                        insPos = 0;
                        break;
                    }
                } else {
                    // ‘}“üˆÊ’u‚ð“Á’èB
                    insPos = j + 1;
                    break;
                }
            }

            if (insPos != -1 && i > insPos) {
                insertSortElement(array, i, insPos);
                printer.setStepInsertion(array, i, insPos);
            }
        }

        return array;
    }
}

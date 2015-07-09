package com.tefuna.toybox.sort.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.AbstractSort;

/**
 *
 * @author tefuna
 *
 */
public class BogoSort extends AbstractSort {

    private Printer printer;
    private List<Integer> idList = new ArrayList<Integer>();

    @Override
    public SortName getSortName() {
        return SortName.BOGO_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
        return SortMethod.EXCHANGING;
    }

    @Override
    public SortElement[] sort(SortElement[] array) {

        printer = getPrinter();
        for (SortElement se : array) {
            idList.add(new Integer(se.getId()));
        }

        while (isSorted(array) == false) {
            array = shuffle(array);
        }

        return array;
    }

    /**
     *
     * @param array
     * @return
     */
    private boolean isSorted(SortElement[] array) {

        for (int i = 1; i < array.length; i++) {
            printer.registStep(array, array[i - 1], array[i], SortOperation.COMPARING);
            if (array[i - 1].getValue() > array[i].getValue()) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param array
     * @return
     */
    private SortElement[] shuffle(SortElement[] array) {

        SortElement[] shuffled = new SortElement[array.length];

        Collections.shuffle(idList);

        for (int i = 0; i < shuffled.length; i++) {
            shuffled[i] = array[idList.get(i).intValue()];
            shuffled[i].setPrePosition(shuffled[i].getPosition());
            shuffled[i].setPosition(i);
        }

        array = shuffled;
        shuffled = null;

        List<SortElement> exchangeList = Arrays.asList(array);
        printer.registStepAsList(array, exchangeList, SortOperation.EXCHANGING);

        return array;
    }
}

package com.tefuna.toybox.sort.bogo;

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
    private List<Integer> idList = new ArrayList();

    @Override
    public SortName getSortName() {
        return SortName.BogoSort;
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

        SortElement shuffled = array;
        while (isSorted(shuffled) == false) {

          // ★シャッフル
          shuffled = shuffle(shuffled);

          // ★全部移動したことを示すstepを記録。
        }

        array = shuffled;
        return array;
    }



    private boolean isSorted(SortElement[] array) {

      for (int i = 1; i < array.length; i++) {

        printer.setStepExchanging(array[i-1], array[i], SortOperation.COMPARING);
        if (array[i-1].getValue() > array[i].getValue()) {
          return false;
        }

      }

      return true;

    }


    private SortElement[] shuffle(SortElement[] array) {

      SortElement[] shuffled = new SortElement[array.length];

      Collection.shuffle(idList);
      //  これが新しいポジション



      return shuffled;
    }
}

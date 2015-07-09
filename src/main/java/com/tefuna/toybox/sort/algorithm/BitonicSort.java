package com.tefuna.toybox.sort.algorithm;

import com.tefuna.toybox.sort.AbstractSort;
import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;

public class BitonicSort extends AbstractSort{

    Printer printer;

    @Override
    public SortName getSortName() {
        return SortName.BITONIC_SORT;
    }

    @Override
    public SortMethod getSortMethod() {
return SortMethod.EXCHANGING;
    }
    
    @Override
    public SortElement[] sort(SortElement[] array) {
        
        printer = getPrinter();
        
        return array;
    }


}

package com.tefuna.toybox.sort;

import java.util.Arrays;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.element.SortElement;
import com.tefuna.toybox.sort.common.printer.Printer;
import com.tefuna.toybox.sort.common.printer.DefaultPrinter;

abstract public class AbstractSort {

    private Printer printer;

    /**
     * 
     * @param original
     * @return
     */
    public SortElement[] execute(SortElement[] original, SortElement[] array) {

        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException("args error.");
        }

        if (printer == null) {
            printer = new DefaultPrinter();
        }

        printer.setSortName(getSortName());
        printer.setSortMethod(getSortMethod());
        printer.setOriginal(original);

        long start = System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();

        printer.setComplete(array);
        printer.setTimeSpent(end - start);

        return array;
    }

    /**
     * 
     * @param array
     * @return
     */
    abstract public SortElement[] sort(SortElement[] array);

    /**
     * 
     * @return
     */
    abstract public SortName getSortName();

    /**
     * 
     * @return
     */
    abstract public SortMethod getSortMethod();

    /**
     * 
     * @param arrayPrinter
     */
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    /**
     * 
     * @return
     */
    public Printer getPrinter() {
        return this.printer;
    }

    /**
     * 
     * @param a
     * @param b
     */
    public void swapSortElement(SortElement a, SortElement b) {

        int tId = a.getId();
        int tValue = a.getValue();
        int tPrePosition = a.getPrePosition();
        // int tPosition = a.getPosition();
        // boolean tSorted = a.isSorted();

        // b �� a �̏ꏊ�ֈړ����� �� a �� b �̒l��ݒ肷��
        a.setId(b.getId());
        a.setValue(b.getValue());
        a.setPrePosition(b.getPosition()); // �O�����ꏊ�ɂ́A�ړ��O�i������ꏊ�j���Z�b�g�B
        // a.setPosition(a.getPosition()); // �ꏊ����������B
        // a.setSorted(false); // swap�������ł́A�m�肵�Ȃ��B

        // a �� b �̏ꏊ�ֈړ����� �� b �� a �̒l��ݒ肷��
        b.setValue(tValue);
        b.setId(tId);
        b.setPrePosition(tPrePosition); // �O�����ꏊ�ɂ́A�ړ��O�i������ꏊ�j���Z�b�g�B
        // b.setPosition(b.getPosition()); // �V�����ꏊ�i�ړ���j�ɂ́A�X���b�v��̋��ꏊ���Z�b�g�B
        // b.setSorted(false); // swap�������ł́A�m�肵�Ȃ��B
    }

}

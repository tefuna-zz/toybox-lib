package com.tefuna.toybox.sort.common.printer;

import java.util.List;

import com.tefuna.toybox.sort.common.constant.SortMethod;
import com.tefuna.toybox.sort.common.constant.SortName;
import com.tefuna.toybox.sort.common.constant.SortOperation;

import com.tefuna.toybox.sort.common.element.SortElement;

/**
 *
 * @author tefuna
 *
 */
public interface Printer {

    /**
     *
     * @param sortName
     * @return
     */
    public void setSortName(SortName sortName);

    /**
     *
     * @param sortMethod
     * @return
     */
    public void setSortMethod(SortMethod sortMethod);

    /**
     *
     * @param msec
     * @return
     */
    public void setTimeSpent(long msec);

    /**
     *
     * @param original
     */
    public void setOriginal(SortElement[] original);

    /**
     *
     * @param complete
     */
    public void setComplete(SortElement[] complete);

    /**
     * 
     * @param array
     * @param a
     * @param b
     * @param ope
     */
    public void registStep(SortElement[] array, SortElement a, SortElement b, SortOperation ope);

    /**
     * 
     * @param array
     * @param list
     * @param ope
     */
    public void registStepAsList(SortElement[] array, List<SortElement> list, SortOperation ope);

    /**
     * 
     * @param array
     * @param list
     */
    public void registStepToComplete(SortElement[] array, List<SortElement> list);

    /**
     *
     * @param id
     * @param sorted
     */
    public void updateSorted(int id, boolean sorted);

    /**
     *
     * @return
     */
    public String printAll();
}

package com.tefuna.toybox.sort.common.element;

public interface SortSteps {

    /**
     * 最新のstepにおいて、idが合致する要素のsortedを更新します。
     * 
     * @param id
     * @param sorted
     */
    public void updateSorted(int id, boolean sorted);

}
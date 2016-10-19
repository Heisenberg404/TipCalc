package com.example.andresmontoya.tipcalc.fragments;

import com.example.andresmontoya.tipcalc.models.TipRecord;

/**
 * Created by andres.montoya on 13/10/2016.
 */

public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}

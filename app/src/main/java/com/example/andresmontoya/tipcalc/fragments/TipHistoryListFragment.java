package com.example.andresmontoya.tipcalc.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andresmontoya.tipcalc.R;
import com.example.andresmontoya.tipcalc.activities.TipDetailActivity;
import com.example.andresmontoya.tipcalc.adapters.OnItemClickListener;
import com.example.andresmontoya.tipcalc.adapters.TipAdapter;
import com.example.andresmontoya.tipcalc.models.TipRecord;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener, OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private TipAdapter adapter;

    public TipHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }



    private void initAdapter() {
        if(adapter == null){
            adapter = new TipAdapter(this.getContext(), this);
        }
    }
    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void addToList(TipRecord record) {

        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }

    @Override
    public void onItemClickListener(TipRecord tipRecord) {
        Intent intent = new Intent(getActivity(), TipDetailActivity.class);
        //intent.putExtra(TipDetailActivity.TIP_KEY, tipRecord.getTip());
        //intent.putExtra(TipDetailActivity.BILL_TOTAL_KEY, tipRecord.getBill());
        //intent.putExtra(TipDetailActivity.DATE_KEY, tipRecord.getDateFormat());
        intent.putExtra(TipDetailActivity.TIP_KEY, tipRecord.getTip());
        intent.putExtra(TipDetailActivity.BILL_TOTAL_KEY, tipRecord.getBill());
        intent.putExtra(TipDetailActivity.DATE_KEY, tipRecord.getDateFormat());
        startActivity(intent);
    }

}

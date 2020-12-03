package com.example.colcalendar18.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.colcalendar18.R;

/**
 * Stub that handles the creation of Event Tabular Fragment
 * * Auto-Generated
 */
public class EventFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    private Spinner spinner;
    private PageViewModel pageViewModel;

    public static EventFragment newInstance(int index) {
        EventFragment fragment = new EventFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 2;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_fragment, container, false);

        return view;
    }
}
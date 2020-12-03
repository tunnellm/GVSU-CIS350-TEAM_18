package com.example.colcalendar18.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.colcalendar18.Course;
import com.example.colcalendar18.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Handles some of the logic for the Assignment Tabular Fragment that
 * is not handles by ManageColCal
 *
 * @Author Marc
 */
public class AssignmentsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private Spinner spinner;
    private PageViewModel pageViewModel;

    public static AssignmentsFragment newInstance(int index) {
        AssignmentsFragment fragment = new AssignmentsFragment();
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
        View view = inflater.inflate(R.layout.assignments_fragment, container, false);

        /* Handles course table in the manage colcalendar table c*/

        final ArrayList<String> courseListArray = new ArrayList<>();

        Iterator chmIterator = Course.courseHashMap.entrySet().iterator();

        while (chmIterator.hasNext()) {
            Map.Entry element = (Map.Entry) chmIterator.next();
            String myCourse = (String) element.getKey();
            courseListArray.add(myCourse);
        }

        if (courseListArray.size() == 0) {
            courseListArray.add("No Courses Added");
        } else if (courseListArray.size() > 1 && courseListArray.get(0).equals("No Courses Added")) {
            courseListArray.remove(0);
            courseListArray.trimToSize();
        }


        Spinner spinner = view.findViewById(R.id.CoursesSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, courseListArray);
        spinner.setAdapter(spinnerAdapter);

        return view;
    }
}
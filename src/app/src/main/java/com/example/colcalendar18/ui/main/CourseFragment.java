package com.example.colcalendar18.ui.main;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.colcalendar18.Assignment;
import com.example.colcalendar18.Course;
import com.example.colcalendar18.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CourseFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static CourseFragment newInstance(int index) {
        CourseFragment fragment = new CourseFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
             LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_fragment, container, false);

        ArrayList<String> courseListArray = new ArrayList<>();
        for (Course item : Course.courseArrayList) {
            courseListArray.add(item.getCourseName());
        }

        if (courseListArray.size() == 0) {
            courseListArray.add("No Courses Added");
        }

        ListView list = (ListView) view.findViewById(R.id.courseList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, courseListArray);

        list.setAdapter(listViewAdapter);



        return view;
    }
}
package com.example.colcalendar18.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.colcalendar18.Course;
import com.example.colcalendar18.R;

import java.util.ArrayList;
import java.util.*;

    // Author: Marc
public class AssignmentsFragment extends Fragment {

    // Author: Marc

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

        while(chmIterator.hasNext()) {
            Map.Entry element = (Map.Entry)chmIterator.next();
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





//        ListView list = (ListView) view.findViewById(R.id.courseList);
//
//        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, courseListArray);
//
//        list.setAdapter(listViewAdapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                LayoutInflater inflater = getLayoutInflater();
//                View layout = inflater.inflate(R.layout.custom_toast,
//                        (ViewGroup) view.findViewById(R.id.custom_toast_container));
//
//                TextView text = (TextView) layout.findViewById(R.id.toast_text);
//                String string = "Course Details\n" +
//                        "Name: " + Course.courseHashMap.get(courseListArray.get(position)).getCourseName() +"\n" +
//                        "Credit Hours: " + String.valueOf(Course.courseHashMap.get(courseListArray.get(position)).getCreditHours());
//                text.setText(string);
//                Toast toast = new Toast(getContext());
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.setView(layout);
//                toast.show();
//            }
//        });




        return view;
    }
}
package com.appbusters.robinkamboj.udacitysyllabuspart1.views.fragments;


import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.controller.StudentsProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiveFragment extends Fragment {

    @BindView(R.id.editText2)
    EditText name;
    @BindView(R.id.editText3)
    EditText grade;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.retrieve)
    Button retrieve;

    public FiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_five, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.add)
    public void setAdd(){
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME, name.getText().toString());

        values.put(StudentsProvider.GRADE, grade.getText().toString());

        Uri uri = getActivity().getContentResolver().insert(StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getActivity(), uri != null ? uri.toString() : null, Toast.LENGTH_LONG).show();
    }

    @SuppressWarnings("deprecation")
    @OnClick(R.id.retrieve)
    public void setRetrieve(){
        // Retrieve student records
        String URL = "content://com.appbusters.robinkamboj.udacitysyllabuspart1.controller.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c = getActivity().managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(getActivity(),
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}

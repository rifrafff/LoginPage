package com.rose.loginpage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonFragment newInstance(String param1, String param2) {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    TextView profilus,profilname,profilem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_person, container, false);
        // Inflate the layout for this fragment
        Intent i=getActivity().getIntent();
        String usernamepf=i.getStringExtra("username");
        profilname=view.findViewById(R.id.profilName);
        profilus=view.findViewById(R.id.profilUsername);
        profilem=view.findViewById(R.id.profilEmail);
        SQLiteDatabase db;
        db=view.getContext().openOrCreateDatabase("LoginApp", Context.MODE_PRIVATE,null);
        Cursor c=db.rawQuery("select * from users ",null);
        int nameee=c.getColumnIndex("name");
        int usernameee=c.getColumnIndex("username");
        int emailll=c.getColumnIndex("email");

        while (c.moveToNext()) {
            String name = c.getString(nameee);
            String usernameValue = c.getString(usernameee);
            String email = c.getString(emailll);
            if(usernameValue.equals(usernamepf)){
                profilname.setText(name);
                profilus.setText(usernameValue);
                profilem.setText(email);
            }
        }
        c.close();
        db.close();

        return view;
    }

}
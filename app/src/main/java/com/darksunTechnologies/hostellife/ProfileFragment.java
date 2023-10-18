package com.darksunTechnologies.hostellife;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    RelativeLayout rulesSection,abousUsSection;
    ImageView updateProfileIcon;
    TextView profileName,profileEmail;
    FirebaseAuth firebaseAuth;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        //initialization
        rulesSection = view.findViewById(R.id.rules_section_ID);
        abousUsSection = view.findViewById(R.id.aboutUs_layout_ID);
        updateProfileIcon = view.findViewById(R.id.profile_update_icon_ID);
        profileName = view.findViewById(R.id.profile_name_ID);
        profileEmail = view.findViewById(R.id.profile_email_ID);
        firebaseAuth = FirebaseAuth.getInstance();
        profileName.setText(firebaseAuth.getCurrentUser().getDisplayName());

        //change to rules & regulation fragment
        rulesSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_id,new rules_regulation_fragment()).commit();
            }
        });

        //change to about us fragment
        abousUsSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_id,new AboutUsFragment()).commit();
            }
        });

        //to update the profile details
        updateProfileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_id,new ProfileFragment()).commit();
            }
        });


        return view;
    }
}
package com.example.james.afinal.fragment;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.james.afinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RadioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RadioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RadioGroup radioGroup;
    private int checkID;
    private RadioButton rbH, rbP, rbD, rbT;
    public Bundle bundle = new Bundle();

    private Button btn;


    public RadioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RadioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RadioFragment newInstance(String param1, String param2) {
        RadioFragment fragment = new RadioFragment();
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
    View view = inflater.inflate(R.layout.fragment_radio, container, false);
        radioGroup = (RadioGroup) view.findViewById(R.id.fragment_rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                 checkID = radioGroup.getCheckedRadioButtonId();
            }
        });
        rbH = (RadioButton)view.findViewById(R.id.rb_horse);
        rbP = (RadioButton)view.findViewById(R.id.rb_pigeon);
        rbD = (RadioButton)view.findViewById(R.id.rb_dog);
        rbT = (RadioButton)view.findViewById(R.id.rb_turtle);

        btn = (Button)view.findViewById(R.id.frag_rsub);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkID==rbH.getId()){
                    Toast.makeText(getActivity(), "you picked Horse.", Toast.LENGTH_SHORT).show();

                }else if(checkID==rbP.getId()){
                    Toast.makeText(getActivity(), "you picked Pigeon.", Toast.LENGTH_SHORT).show();

                }else if(checkID==rbD.getId()){
                    Toast.makeText(getActivity(), "you picked Dog.", Toast.LENGTH_SHORT).show();

                }else if(checkID==rbT.getId()){
                    Toast.makeText(getActivity(), "you picked Turtle.", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getActivity(), "you picked Nothing.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;

    }

}

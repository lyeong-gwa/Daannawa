package com.deadlock.firstapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.deadlock.firstapp.R;
import com.deadlock.firstapp.activity.MenuActivity;
import com.deadlock.firstapp.part.RecommendPart;
import com.deadlock.firstapp.part.Selectpart2;
import com.google.android.material.tabs.TabLayout;

public class RecommendFragment extends Fragment {
    private Spinner spinner, spinner2;
    private ArrayAdapter<CharSequence> sequence, sequence2;
    private Button button;
    private String use, use_detail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        spinner = view.findViewById(R.id.spinner);
        spinner2 = view.findViewById(R.id.spinner2);

        sequence = ArrayAdapter.createFromResource(getActivity(), R.array.use, android.R.layout.simple_spinner_dropdown_item);
        sequence.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(sequence);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(sequence.getItem(i).equals("사무용")) {
                    use_detail = null;
                } else if(sequence.getItem(i).equals("디자인용")) {
                    sequence2 = ArrayAdapter.createFromResource(getActivity(), R.array.use_design, android.R.layout.simple_spinner_dropdown_item);
                    sequence2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(sequence2);

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            use_detail = (String) sequence2.getItem(i);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                } else if(sequence.getItem(i).equals("게임용")) {
                    sequence2 = ArrayAdapter.createFromResource(getActivity(), R.array.use_game, android.R.layout.simple_spinner_dropdown_item);
                    sequence2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(sequence2);

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            use_detail = (String) sequence2.getItem(i);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                use = (String) sequence.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "장바구니에 담겼습니다!", Toast.LENGTH_SHORT).show();
                new RecommendPart().get_list(use, use_detail, ((MenuActivity)getActivity()).selectpart);
            }
        });


        return view;
    }
}
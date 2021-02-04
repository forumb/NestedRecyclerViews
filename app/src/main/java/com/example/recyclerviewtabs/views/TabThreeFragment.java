package com.example.recyclerviewtabs.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerviewtabs.R;
import com.example.recyclerviewtabs.adapters.NumbersAdapter;
import com.example.recyclerviewtabs.models.HorizontalData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class TabThreeFragment extends Fragment {

    private int enterNum;
    private List<HorizontalData> numbers;

    public TabThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_tab_three, container, false);

        final EditText enterNumber = rootView.findViewById(R.id.numberET);
        final RecyclerView recyclerView = rootView.findViewById(R.id.numberRv);
        Button enter = rootView.findViewById(R.id.enterBtn);
        final List<Integer> numberList = new ArrayList<>();
        final LinearLayout linearLayout1 = rootView.findViewById(R.id.linearLayout1);
        final LinearLayout linearLayout2 = rootView.findViewById(R.id.linearLayout2);
        final TextView secondLargestNum = rootView.findViewById(R.id.secondLargestTv);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbers = new ArrayList<>();
                InputMethodManager inputMethodManager = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(rootView.getApplicationWindowToken(), 0);
                if (TextUtils.isEmpty(enterNumber.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter a valid enterNumber", Toast.LENGTH_SHORT).show();
                } else {
                    enterNum = Integer.parseInt(enterNumber.getText().toString());
                    numberList.add(enterNum);

                    Collections.sort(numberList, Collections.reverseOrder());
                    int size = numberList.size();
                    if (size == 1) {
                        secondLargestNum.setText(String.valueOf(enterNum));
                    } else {
                        secondLargestNum.setText(String.valueOf(numberList.get(1)));
                    }

                    for (int i = 0; i < numberList.size(); i++) {
                        numbers.add(new HorizontalData(numberList.get(i)));
                    }

                    NumbersAdapter numbersAdapter = new NumbersAdapter(getActivity(), numbers);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
                    recyclerView.setAdapter(numbersAdapter);

                    linearLayout1.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.VISIBLE);

                    enterNumber.getText().clear();
                }
            }
        });


        return rootView;
    }

}
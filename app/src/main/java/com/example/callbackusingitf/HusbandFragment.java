package com.example.callbackusingitf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class HusbandFragment extends Fragment {
    private EditText mSalaryEditText;

    private WifeCallBack mWifeCallback;

    public void setWifeCallback(WifeCallBack wifeCallback) {
        mWifeCallback = wifeCallback;
    }

    public HusbandFragment() {
        // Required empty public constructor
    }

    public static HusbandFragment newInstance(String param1, String param2) {
        HusbandFragment fragment = new HusbandFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_husband, container, false);
        mSalaryEditText = view.findViewById(R.id.input_salary);
        setTextWatcher();
        return view;
    }
    private void setTextWatcher(){
        mSalaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    if (!charSequence.toString().isEmpty()) {
                        int salary = Integer.parseInt(charSequence.toString());
                        callWifeAndGiveSalary(salary);
                    } else {
                        callWifeAndGiveSalary(0);
                    }
                } catch (NumberFormatException e) {
                    mSalaryEditText.setError("Lương nhiều quá, vợ không dám nhận :v");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void callWifeAndGiveSalary(int salary) {
        mWifeCallback.onReceiveSalary(salary);
    }
}
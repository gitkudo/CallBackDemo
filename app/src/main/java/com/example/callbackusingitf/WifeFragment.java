package com.example.callbackusingitf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WifeFragment extends Fragment implements WifeCallBack {
    private TextView mSalaryTextView;

    public WifeFragment() {
        // Required empty public constructor
    }

    public static WifeFragment newInstance(String param1, String param2) {
        WifeFragment fragment = new WifeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wife, container, false);
        mSalaryTextView = view.findViewById(R.id.text_salary);
        return view;
    }
    private void updateUI(int salary) {
        String result = "Cô Bách nhận được: " + salary;
        mSalaryTextView.setText(result);
    }

    @Override
    public void onReceiveSalary(int salary) {
        updateUI(salary);
    }
}
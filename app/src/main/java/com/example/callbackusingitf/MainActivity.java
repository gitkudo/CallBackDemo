package com.example.callbackusingitf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private HusbandFragment mHusbandFragment;
    private WifeFragment mWifeFragment;
    //Try hard them chut nua

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }
    private void initFragments() {
        mHusbandFragment = new HusbandFragment();
        mWifeFragment = new WifeFragment();

        mHusbandFragment.setWifeCallback(mWifeFragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container_fragment_husband, mHusbandFragment)
                .add(R.id.container_fragment_wife, mWifeFragment)
                .commit();
    }
}
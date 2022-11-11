package org.idnp.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;

//import android.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainDynamicActivity extends AppCompatActivity implements MainCallbacks {

    private static final String TAG = "MainDynamicActivity";
    private RedFragment redFragment;
    private BlueFragment blueFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dynamic);


        //FragmentTransaction ft = getFragmentManager().beginTransaction();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        redFragment = RedFragment.newInstance("", "");
        ft.replace(R.id.fragmentContainerViewRed, redFragment, "RED-TAG");
//        ft.hide(redFragment);
//        ft.show(redFragment);
//        ft.detach(redFragment);
//        ft.attach(redFragment);
        ft.commit();

        ft = getSupportFragmentManager().beginTransaction();
        blueFragment = BlueFragment.newInstance("", "");
        ft.replace(R.id.fragmentContainerViewBlue, blueFragment, "BLUE-TAG");
//        ft.hide(blueFragment);
//        ft.show(blueFragment);
//        ft.detach(blueFragment);
//        ft.attach(blueFragment);
        ft.commit();
    }

//    @Override
//    public void onAttachFragment(Fragment fragment) {
//        super.onAttachFragment(fragment);
//// get a reference to each fragment attached to the GUI
//        if (fragment.getClass() == RedFragment.class ){
//            redFragment = (RedFragment) fragment;
//        }
//        if (fragment.getClass() == BlueFragment.class ){
//            blueFragment = (BlueFragment) fragment;
//        }
//    }

    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {

        Log.d(TAG, " MAIN GOT>> " + sender + " " + strValue);

        if (sender.equals("RED-FRAG")) {
            try {
                blueFragment.onMsgFromMainToFragment("\nSender: " + sender
                        + "\nMsg: " + strValue);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
        if (sender.equals("BLUE-FRAG")) {
            try {
                redFragment.onMsgFromMainToFragment("\nSender: " + sender + "\nMsg: " + strValue);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }

    }
}
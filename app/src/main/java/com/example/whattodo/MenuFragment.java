package com.example.whattodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuFragment extends Fragment implements
        OnClickListener{
    Button btn_packs;
    public MenuFragment() {
    }

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View menuView = inflater.inflate(R.layout.menu_view, container, false);

        btn_packs = menuView.findViewById(R.id.btn_packs);
        btn_packs.setOnClickListener(this);


        return menuView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_packs:

                break;
            case R.id.btn_profile:

                break;
            case R.id.btn_setting:

                break;
            case R.id.btn_sing_out:
                Intent intent=new Intent(this.getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }

    }


}
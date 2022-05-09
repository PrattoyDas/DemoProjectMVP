package com.example.logindemoproject.ui.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.logindemoproject.R;
import com.example.logindemoproject.common.WingsApplication;
import com.example.logindemoproject.data.model.response.LoginResponse;
import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.base.BaseActivity;
import com.example.logindemoproject.ui.login.MainActivityContract;
import com.example.logindemoproject.ui.login.di.DaggerMainActivityComponent;
import com.example.logindemoproject.ui.login.di.MainActivityComponent;
import com.example.logindemoproject.ui.dobase.DOBaseActivity;
import com.example.logindemoproject.ui.login.listener.AdapterInteractorListener;

public class MainActivity extends BaseActivity implements View.OnClickListener, MainActivityContract.MainActivityView,
        AdapterInteractorListener {

    Button signin;
    EditText username, pass;
    private MainActivityContract.IMainActivityView mPresenter;
    PreferenceHelper preferenceHelper;

    public static Intent getCallingIntent(Activity activity, String batch_number) {
        Intent intent = new Intent(activity, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initView();
        this.ini();
        this.loadData();

    }

    protected void initView() {
        this.signin = findViewById(R.id.sign_in);
        signin.setOnClickListener(this);
        this.username = findViewById(R.id.username);
        this.pass = findViewById(R.id.pass);
    }

    private void loadData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter.onDetach();
    }

    public void ini() {
        MainActivityComponent component = DaggerMainActivityComponent
                .builder()
                .wingsAppComponent(WingsApplication.getInstance().getWingsAppComponent())
                .build();

        this.mPresenter = component.getPresenter();
        this.mPresenter.onAttach(this);
        this.preferenceHelper = component.getPreferenceHelper();
    }

    @Override
    public void onClick(View view) {
        if (view == signin){
            this.mPresenter.api(username.getText().toString(), pass.getText().toString());
        }
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onLogin(LoginResponse loginResponse) {

    }
}
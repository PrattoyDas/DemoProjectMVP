package com.example.logindemoproject.ui.dobase;

import android.widget.TextView;

import com.example.logindemoproject.data.preference.PreferenceHelper;
import com.example.logindemoproject.ui.base.BaseActivity;

public abstract class DOBaseActivity extends BaseActivity {

    private TextView employeeCode, employeeBuildInfo, employeePointCode;
    protected PreferenceHelper preferenceHelper;

    protected void initView() {
        try {

//            this.employeeCode.setText(preferenceHelper.getAuthEmployeeCode());
//            this.employeeBuildInfo.setText(BuildConfig.VERSION_NAME + "." + BuildConfig.BUILD_TYPE);
//            this.employeePointCode.setText(preferenceHelper.getEmployeePointCodes());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

package com.example.logindemoproject.ui.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;



public abstract class BaseBottomSheet extends BottomSheetDialogFragment implements BaseMvpView {
    private ProgressDialog progressDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initProgressDialog();
        return super.onCreateDialog(savedInstanceState);

    }


    private void initProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void onError(int resId) {
        showMessage(getString(resId));
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }






    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));
    }
    @Override
    public void showSuccessMessage(int resId) {
        showSuccessMessage(getString(resId));
    }

    @Override
    public void showErrorMessage(int resId) {
        showErrorMessage(getString(resId));
    }



    @Override
    public void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

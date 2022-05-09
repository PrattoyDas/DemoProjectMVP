package com.example.logindemoproject.ui.batchdetails.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logindemoproject.R;
import com.example.logindemoproject.common.WingsApplication;
import com.example.logindemoproject.data.model.BatchOrder;
import com.example.logindemoproject.ui.batchdetails.BatchDetailsContract;
import com.example.logindemoproject.ui.batchdetails.di.BatchDetailsComponent;
import com.example.logindemoproject.ui.batchdetails.di.DaggerBatchDetailsComponent;
import com.example.logindemoproject.ui.batchdetails.listener.AdapterInteractorListener;
import com.example.logindemoproject.ui.dobase.DOBaseActivity;

import java.util.ArrayList;
import java.util.List;


public class BatchDetailsActivity extends DOBaseActivity implements View.OnClickListener, BatchDetailsContract.BatchDetailsView,
        AdapterInteractorListener {

    private static final String BATCH_NUMBER = "batch_number";
    private static final String DO_FLAG = "do_flag";
    private List<BatchOrder> batchOrderList;
//    private BatchDetailsAdapter batchDetailsAdapter;
    private RecyclerView recyclerView;
    private BatchDetailsContract.IBatchDetailsView mPresenter;
    private LinearLayoutManager layoutManagerBatchDetails;
    private TextView recordMessage;
    private EditText etOrderId;
    // Toolbar
    private View toolbar_previous;
    private TextView toolbar_title, batch_number;
    private RelativeLayout toolbar_button;
    private String batchNumber;
    private String doFlag;

    public static Intent getCallingIntent(Activity activity, String batch_number) {
        Intent intent = new Intent(activity, BatchDetailsActivity.class);
        intent.putExtra(BATCH_NUMBER, batch_number);
        return intent;
    }

    public static Intent getCallingIntent(Activity activity, String batch_number, String do_flag) {
        Intent intent = new Intent(activity, BatchDetailsActivity.class);
        intent.putExtra(BATCH_NUMBER, batch_number);
        intent.putExtra(DO_FLAG, do_flag);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.batchOrderList = new ArrayList<>();
        setContentView(R.layout.activity_batch_details);

        this.init();
        this.loadData();
        this.initView();
    }

    public void init() {
        BatchDetailsComponent dsComponent = DaggerBatchDetailsComponent
                .builder()
                .wingsAppComponent(WingsApplication.getInstance().getWingsAppComponent())
                .build();

        this.mPresenter = dsComponent.getPresenter();
        this.mPresenter.onAttach(this);
        this.preferenceHelper = dsComponent.getPreferenceHelper();
    }

    protected void initView() {
        super.initView();

//        this.toolbar_previous = this.findViewById(R.id.toolbar_previous);
//        this.toolbar_previous.setOnClickListener(this);
//
//        this.toolbar_title = this.findViewById(R.id.toolbar_title);
//        this.toolbar_title.setText("Batch Details");
//
//        this.toolbar_button = this.findViewById(R.id.toolbar_button);
//        this.toolbar_button.setVisibility(View.GONE);

        this.etOrderId = this.findViewById(R.id.et_order_id);

        this.batch_number = this.findViewById(R.id.batchNumber);
        this.batch_number.setText("Batch Number: " + batchNumber);

        this.recordMessage = this.findViewById(R.id.recordMessage);
        this.recyclerView = this.findViewById(R.id.recycler_view_batch_details);
//        setupRecycleView();
    }

    private void loadData() {
        batchNumber = (String) getIntent().getSerializableExtra(BATCH_NUMBER);
        doFlag = (String) getIntent().getSerializableExtra(DO_FLAG);
        this.mPresenter.getBatchOrderList(batchNumber);
    }

//    private void setupRecycleView() {
//        this.batchDetailsAdapter = new BatchDetailsAdapter(batchOrderList, this);
//        this.recyclerView.setAdapter(batchDetailsAdapter);
//
//        this.layoutManagerBatchDetails = new LinearLayoutManager(this);
//        this.recyclerView.setLayoutManager(layoutManagerBatchDetails);
//
//        ItemOffsetDecoration itemDecorationDelivery = new ItemOffsetDecoration(this, R.dimen.half_dp);
//        this.recyclerView.addItemDecoration(itemDecorationDelivery);
//
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter.onDetach();
    }


    @Override
    public void onClick(View v) {
        if (v == toolbar_previous) {
            finish();
        }
    }

    @Override
    public void loadingPointStock() {

    }

    @Override
    public void loadedPointStock() {

    }



    @Override
    public void viewOnOrderItemViewClick(String status, String orderNumber) {
        if (status == "tvViewDetailsClicked") {
//            startActivity(OrderDetailsActivity.getCallingIntent(this, orderNumber, doFlag));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        filtering();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

//    private void filtering() {
//        etOrderId.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                filter(editable.toString());
//            }
//        });
//    }

//    public void filter(String s) {
//        ArrayList<BatchOrder> filteredList = new ArrayList<>();
//        for (BatchOrder test : batchOrderList) {
//            if (test.getOrderNumber().toLowerCase().contains(s.toLowerCase())) {
//                filteredList.add(test);
//            }
//        }
//        batchDetailsAdapter.filterList(filteredList);
//    }
}
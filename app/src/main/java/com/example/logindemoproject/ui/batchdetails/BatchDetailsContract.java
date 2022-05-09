package com.example.logindemoproject.ui.batchdetails;


import com.example.logindemoproject.ui.base.BaseMvpPresenter;
import com.example.logindemoproject.ui.base.BaseMvpView;

public interface BatchDetailsContract {

    interface BatchDetailsView extends BaseMvpView {
        void loadingPointStock();

        void loadedPointStock();



    }

    interface IBatchDetailsView extends BaseMvpPresenter<BatchDetailsView> {

        void getBatchOrderList(String searchText);

        void list(String status);
    }
}

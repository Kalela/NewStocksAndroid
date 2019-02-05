package com.kalela.philipkalela.newstock.feature.register.contract;

public interface RegisterContract {

    interface RegisterView {

        void showPasswordToast();

        void navigateSuccess();

        void showErrorMessage();
    }
}

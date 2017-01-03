package io.intrepid.thirdpartylibraryexcercise;

class MainContract {
    interface View {

        void showLoadingIndicator();

        void dismissLoadingIndicator();

        void loadImageFromUrl(String url);
    }

    interface Presenter {

        void bindView(View view);

        void unbindView();

        void onNewCatButtonClick();
    }
}

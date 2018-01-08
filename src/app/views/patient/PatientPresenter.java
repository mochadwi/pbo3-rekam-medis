package app.views.patient;

/**
 * @author mochadwi
 */

public class PatientPresenter implements PatientContract.Presenter {

    private PatientContract.View view;

    @Override
    public void validation(int pilihan) {

        view.showView();

    }

    @Override
    public void menu(String pilihan) {

        view.showLoading();

        if (pilihan.equals("1") || pilihan.equals("2") || pilihan.equals("3")
                || pilihan.equals("4")) {

            view.showMenuSuccessView();

        } else {
            view.showMenuErrorView();
            view.showView();
        }
    }

    @Override
    public void bind(PatientContract.View view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        this.view = null;
    }
}

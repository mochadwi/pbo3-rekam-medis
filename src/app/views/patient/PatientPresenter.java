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
        view.showMenuSuccessView();

        switch (pilihan) {
            case "1":
                view.showCreateDataView();
                break;
            case "2":
                view.showUpdateDataView();
                break;
            case "3":
                view.showDeleteDataView();
                break;
            case "4":
                view.showReadDataView();
                break;

            default:
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

package app.views.patient;

import app.models.Patient;
import app.utils.Dummy;

import java.util.List;

/**
 * @author mochadwi
 */

public class PatientPresenter implements PatientContract.Presenter {

    private PatientContract.View view;

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
    public void create(Patient patient) {

    }

    @Override
    public List<Patient> read() {
        return Dummy.getPatients();
    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void delete(Patient patient) {

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

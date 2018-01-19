package app.views.patient;

import app.Dashboard;
import app.models.DataPasien;
import app.utils.Db;
import app.utils.Dummy;
import app.utils.Status;

import java.util.List;

/**
 * @author mochadwi
 */

public class PatientPresenter implements PatientContract.Presenter {

    private PatientContract.View view;

    @Override
    public void menu(String pilihan) {

        view.showLoading();

        switch (pilihan) {
            case "0":
                // do nothing
                view.showMenuSuccessView();
                Dashboard.status = Status.MENU;
                break;
            case "1":
                view.showMenuSuccessView();
                view.showCreateDataView();
                break;
            case "2":
                view.showMenuSuccessView();
                view.showUpdateDataView();
                break;
            case "3":
                view.showMenuSuccessView();
                view.showDeleteDataView();
                break;
            case "4":
                view.showMenuSuccessView();
                view.showReadDataView();
                break;
            default:
                view.showMenuErrorView();
                view.showView();
        }

        view.showMenuToContinue();
    }

    @Override
    public void create(DataPasien dataPasien) {

        Db.getInstance().initPersist().insert(Dummy.getPatients().get(0));
    }

    @Override
    public List<DataPasien> read() {
        return Dummy.getPatients();
    }

    @Override
    public void update(DataPasien dataPasien) {

    }

    @Override
    public void delete(DataPasien dataPasien) {

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

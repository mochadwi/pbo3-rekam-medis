package app.views.patient;

import app.Dashboard;
import app.models.DataPasien;
import app.utils.Db;
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
                view.showMenuSuccessView("\n\n\nSucces!!\n");
                Dashboard.status = Status.PATIENT;
                break;
            case "1":
                view.showMenuSuccessView("\n\n\nSucces!!\n");
                view.showCreateDataView();
                break;
            case "2":
                view.showMenuSuccessView("\n\n\nSucces!!\n");
                view.showUpdateDataView();
                break;
            case "3":
                view.showMenuSuccessView("\n\n\nSucces!!\n");
                view.showDeleteDataView();
                break;
            case "4":
                view.showMenuSuccessView("\n\n\nSucces!!\n");
                view.showReadDataView();
                break;

            case "-1":
                view.showMenuSuccessView("\n\n\nPatient data found!!\n");
                Dashboard.status = Status.PATIENT;
                break;

            case "-3":
                view.showMenuSuccessView("\n\n\nData not found!!\n");
                view.showDeleteDataView();
                break;

            case "-2":
                view.showMenuSuccessView("\n\n\nData not found!!\n");
                view.showUpdateDataView();
                break;

            default:
                view.showMenuErrorView("Pilih Angka 0-4!");
                view.showView();
        }

        view.showMenuToContinue();
    }

    @Override
    public void create(DataPasien dataPasien) {

        Db.getInstance().initPersist().insert(dataPasien);
    }

    @Override
    public List<DataPasien> read() {

        return Db.getInstance().initPersist().readList(DataPasien.class);
    }

    @Override
    public void update(DataPasien pasien) {

        Db.getInstance().initPersist().update(pasien);
    }

    @Override
    public void delete(String idPasien) {

        Db.getInstance().initPersist()
                .executeUpdate("UPDATE data_pasien SET value_pasien=0 WHERE id_pasien=?", idPasien);
    }

    @Override
    public String find(String idPasien) {

        DataPasien pasien = Db.getInstance().initPersist().readByPrimaryKey(DataPasien.class, idPasien);

        if (pasien != null) return pasien.getId_pasien();

        return "";
    }

    @Override
    public String findMin() {
        return "";
    }

    @Override
    public String findMax() {

        return Db.getInstance().initPersist().read(String.class,
                "SELECT MAX(id_pasien) FROM data_pasien");
    }

    @Override
    public boolean validateData(String data) {

        if (data.isEmpty()) {

            view.showMenuErrorView("Data Tidak ditemukan!");
            return false;
        }


        return true;
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

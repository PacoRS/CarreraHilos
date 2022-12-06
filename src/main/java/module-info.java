module FranciscoRamirez.CarreraHilos {
    requires javafx.controls;
    requires javafx.fxml;

    opens FranciscoRamirez.CarreraHilos to javafx.fxml;
    exports FranciscoRamirez.CarreraHilos;
}

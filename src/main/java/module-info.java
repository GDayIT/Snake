module de.bbq.snak {
    requires javafx.controls;
    requires javafx.fxml;
//    requires transitive javafx.graphics;

    opens de.bbq.snak to javafx.fxml;
    exports de.bbq.snak;
}

package fx.controllers.items;


import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import model.Item;
import services.ItemsServices;
import services.PurchasesServices;
import utils.Constantes;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class FXMLDeleteItemController implements Initializable {
    public ListView<Item> lvlistItems;
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final Alert confir = new Alert(Alert.AlertType.CONFIRMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void deleteItem() {
        Item it = lvlistItems.getSelectionModel().getSelectedItem();
        PurchasesServices ps = new PurchasesServices();
        ItemsServices itemsServices = new ItemsServices();
        if (it != null) {
            if (!ps.getPurchasesByItemId(it.getIdItem()).isEmpty()) {
                confir.setTitle(Constantes.TITLE_MESSAGE);
                confir.setContentText(Constantes.NOTICE_DELETED);
                Optional<ButtonType> action = confir.showAndWait();
                if (action.get() == ButtonType.OK) {
                    if (itemsServices.deletePurchasesAndItem(it)) {
                        lvlistItems.getItems().remove(it);
                    } else {
                        alert.setContentText(Constantes.ITEM_NOT_DELETED);
                        alert.showAndWait();
                    }
                }
            } else {
                if (itemsServices.deleteItem(it)) {
                    lvlistItems.getItems().remove(it);
                } else {
                    alert.setContentText(Constantes.ITEM_NOT_DELETED);
                    alert.showAndWait();
                }
            }


        } else {
            alert.setContentText(Constantes.SELECT_ITEM);
            alert.showAndWait();
        }
    }


    public void loadItems() {
        ItemsServices is = new ItemsServices();
        lvlistItems.getItems().clear();
        lvlistItems.getItems().addAll(is.getAll());
    }
}

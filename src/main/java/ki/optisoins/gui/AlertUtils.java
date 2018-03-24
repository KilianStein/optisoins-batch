package ki.optisoins.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AlertUtils {

  private static void displayError(String errorMessage, String errorTrace, String errorTitle, String errorHeader, String errorLabel) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(errorTitle);
    alert.setHeaderText(errorHeader);
    alert.setContentText(errorMessage);

    TextArea textArea = new TextArea(errorTrace);
    textArea.setEditable(false);
    textArea.setWrapText(true);

    textArea.setMaxWidth(Double.MAX_VALUE);
    textArea.setMaxHeight(Double.MAX_VALUE);
    GridPane.setVgrow(textArea, Priority.ALWAYS);
    GridPane.setHgrow(textArea, Priority.ALWAYS);

    GridPane expContent = new GridPane();
    expContent.setMaxWidth(Double.MAX_VALUE);
    expContent.add(new Label(errorLabel), 0, 0);
    expContent.add(textArea, 0, 1);

    alert.getDialogPane().setExpandableContent(expContent);
    alert.showAndWait();
  }

  public static void displayError(Throwable t) {
    displayError(t.getMessage(), getStringFromException(t), "Erreur dans l'application", "Oh oh, il y a eu un problème...", "La trace d'erreur est la suivante :");
  }

  private static String getStringFromException(Throwable throwable) {
    StringWriter sw = new StringWriter();
    throwable.printStackTrace(new PrintWriter(sw));
    String exceptionText = sw.toString();
    return exceptionText;
  }
}
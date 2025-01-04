package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

public class GUITest extends ApplicationTest {

  private ListView<String> ticketListView = new ListView<>();

  @BeforeAll
  public static void initToolkit() {
    Platform.startup(() -> {}); // Initialize JavaFX Toolkit
  }

  @Override
  public void start(Stage stage) {
    JavaFXInterface app = new JavaFXInterface();
    app.start(stage);
    ticketListView = lookup("#ticketListView").queryAs(ListView.class); // ID must be set in JavaFXInterface
  }

  @BeforeEach
  public void setUp() {
    Platform.runLater(() -> ticketListView.getItems().clear());
  }

  @Test
  public void testRealTimeUpdates() {
    Platform.runLater(() -> {
      ticketListView.getItems().add("Ticket-1");
      ticketListView.getItems().add("Ticket-2");
    });

    // Wait for the JavaFX thread to complete
    WaitForAsyncUtils.waitForFxEvents();

    // Verify the updates in the ListView
    assertEquals(2, ticketListView.getItems().size());
    assertEquals("Ticket-1", ticketListView.getItems().get(0));
    assertEquals("Ticket-2", ticketListView.getItems().get(1));

    // Simulate a ticket removal
    Platform.runLater(() -> ticketListView.getItems().remove(0));

    WaitForAsyncUtils.waitForFxEvents();

    // Verify the ListView after removal
    assertEquals(1, ticketListView.getItems().size());
    assertEquals("Ticket-2", ticketListView.getItems().get(0));
  }
}

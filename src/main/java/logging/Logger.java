/*
package logging.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    private static final String LOG_FILE = "logs.txt";

    public static void log(String message) {
        String timeStampedMessage = LocalDateTime.now() + ": " + message;
        System.out.println(timeStampedMessage);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(timeStampedMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logMessage(String ticketID, String operation) {
        String timeStampedMessage = ticketID + "was" +" " +  operation + " " +  "at" + " " + LocalDateTime.now();
        System.out.println(timeStampedMessage);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(timeStampedMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

/*
package logging.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE = "logs.txt";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LogMessage(String ticketId, String message) {
        String timeStampedMessage = dtf.format(LocalDateTime.now()) + " ";
        System.out.println(timeStampedMessage + ticketId + " " + message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LOG_File", true))) {
            writer.write(timeStampedMessage);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

  private static final String LOG_FILE = "resources/logs.txt";
  private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

  private Logger() {

  }

  public static void log(String message) {
    String timedMessage = LocalDateTime.now() + " - " + message;
    System.out.println(timedMessage);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
      writer.write(timedMessage);
      writer.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void logMessage(String ticketId, String operation) {
    String timeStampedMessage = dtf.format(LocalDateTime.now()) + " - " + ticketId + " - " + operation;
    System.out.println(timeStampedMessage);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
      writer.write(timeStampedMessage);
      writer.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

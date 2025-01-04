package config;

import com.google.gson.Gson;
import exceptions.InvalidConfigurationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Configuration {

  private int totalTickets;
  private int ticketReleaseRate;
  private int customerRetrievalRate;
  private int maxTicketCapacity;

  public Configuration() {
    // default values
    this.totalTickets = 0;
    this.ticketReleaseRate = 0;
    this.customerRetrievalRate = 0;
    this.maxTicketCapacity = 0;
  }

  public Configuration(
      int totalTickets,
      int ticketReleaseRate,
      int customerRetrievalRate,
      int maxTicketCapacity
  ) throws InvalidConfigurationException {
    if (totalTickets <= 0 || ticketReleaseRate <= 0 || customerRetrievalRate <= 0 || maxTicketCapacity <= 0) {
      throw new InvalidConfigurationException("values must be positive");
    }

    this.totalTickets = totalTickets;
    this.ticketReleaseRate = ticketReleaseRate;
    this.customerRetrievalRate = customerRetrievalRate;
    this.maxTicketCapacity = maxTicketCapacity;
  }

  public static Configuration loadFromFile(String filePath) throws IOException {
    Gson gson = new Gson(); // Create a gson library. Gson is an object from the google gson library
    try (Reader reader = new FileReader(filePath)) {
      return gson.fromJson(reader, Configuration.class);
    }
  }

  public int getTotalTickets() {
    return totalTickets;
  }

  public void setTotalTickets(int totalTickets) throws InvalidConfigurationException {
    if (totalTickets <= 0) {
      throw new InvalidConfigurationException("Total tickets must be positive");
    }

    this.totalTickets = totalTickets;
  }

  public int getTicketReleaseRate() {
    return ticketReleaseRate;
  }

  public void setTicketReleaseRate(int ticketReleaseRate) throws InvalidConfigurationException {
    if (ticketReleaseRate <= 0) {
      throw new InvalidConfigurationException("Ticket release rate must be positive");
    }

    this.ticketReleaseRate = ticketReleaseRate;
  }

  public int getCustomerRetrievalRate() {
    return customerRetrievalRate;
  }

  public void setCustomerRetrievalRate(int customerRetrievalRate) throws InvalidConfigurationException {
    if (customerRetrievalRate <= 0) {
      throw new InvalidConfigurationException("Customer retrieval rate must be positive");
    }

    this.customerRetrievalRate = customerRetrievalRate;
  }

  public int getMaxTicketCapacity() {
    return maxTicketCapacity;
  }

  public void setMaxTicketCapacity(int maxTicketCapacity) throws InvalidConfigurationException {
    if (maxTicketCapacity <= 0) {
      throw new InvalidConfigurationException("Max ticket capacity must be positive");
    }

    this.maxTicketCapacity = maxTicketCapacity;
  }

  // Configuration class is reference is needed because GSON does not inherently
  // Know the structure of the object it is supposed to create.

  public void saveToFile(String filePath) throws IOException {
    Gson gson = new Gson();
    try (Writer writer = new FileWriter(filePath)) {
      gson.toJson(this, writer);
    }
  }
}

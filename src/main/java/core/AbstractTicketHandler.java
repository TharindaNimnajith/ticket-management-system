package core;

public abstract class AbstractTicketHandler {

  protected TicketPool ticketPool;
  // protected = accessible within this class, its subclass and classes in the same package

  protected AbstractTicketHandler(TicketPool ticketPool) {
    this.ticketPool = ticketPool;
  }

  public abstract void handleTickets();

  // this method is not implemented so subclasses must provide an implementation
  // vendor = method to add tickets
  // customer = method to retrieve tickets

  // defining this method as abstract allow system to treat different ticket handlers ==> Polymorphism
}

// abstraction
// serves as a common parent for different ticket handling entities like customers and vendors

// abstract = this cannot be instantiated directly. it is designed to provide a base structure that must be extended by other classes.

// this class encapsulates shared functionality or properties that will be common
// across all ticket handlers such as vendor and customer

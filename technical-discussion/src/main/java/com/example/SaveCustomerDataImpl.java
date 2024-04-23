package com.example;

@Component
public class SaveCustomerDataImpl implements SaveCustomerData { // comment  class name better [ ]

    @Autowired
    CustomerRepo repo;

    final static List<Customer> details = Arrays.asList(
            new Customer("abc", "Newyork"),
            new Customer("abc", "India"),
            new Customer("abc", "London")
    );

    public java.lang.String getAddress(String name) {
        for (int i = 0; i < details.size(); i++) {
            Customer c = details.get(i);
            if (c.getCustomerName().equalsIgnoreCase(name)) {
                return c.getCustomerAddress();
            }
        }
        return "";
    }

    public List<Customer> getCustomers(String name) { // complete this

    }

    public int saveNewUser(String name, String adress) {  // change method name newCustomer
        details.set(1, new Customer(name, adress));
        int id = repo.saveNewUser(someValidObject);
        return id;
    }
}
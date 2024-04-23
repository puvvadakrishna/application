package com.example;

//entity class
//entity annotation @Table
public class Customer {  // setter & getter methods add a constructor Data Annotation

    @Id
    //sequence strategy
    private Long id;
    //NotNull
    private String firstname;
    //@NotNull
    private String lastname;
}

@Component // use Service
public class SaveCustomerDataImpl implements SaveCustomerData {

    @Autowired
    CustomerRepo repo;

    final static String name = "rama";
    final static List<Customer> customers = Arrays.asList( // use Builder...
            new Customer("abc", "Newyork"),
            new Customer("abc", "India"),
            new Customer("abc", "London")
    );


    public String getAddress(String name) {
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.getCustomerName().equalsIgnoreCase(name)) {
                return c.getCustomerAddress();
            }
        }
        return "";


    //   return customers.stream().filter(c.getCustomerName().equalsIgnoreCase(name));

    }


    public List<Customer> getCustomers(String name) {

    }

    public int saveNewCustomer(String name, String adress) { // datatype conversion long to int
        details.set(1, new Customer(name, address));
        return repo.save(new Customer(name, address));
        return id; // not needed
    }
}

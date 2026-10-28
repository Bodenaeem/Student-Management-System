
/*
 * File: Person.java
 * Purpose: Abstract superclass for the system.
 */

public abstract class Person {

    // Private attributes demonstrate encapsulation
    private String name;
    private String id;

    // Constructor
    public Person(String name, String id) {
        setName(name);
        setId(id);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException(
                "Name cannot be empty."
            );
        }
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Setter for ID
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id.trim();
        } else {
            throw new IllegalArgumentException(
                "ID cannot be empty."
            );
        }
    }

    // Abstract method implemented by subclasses
    public abstract void displayInfo();
}

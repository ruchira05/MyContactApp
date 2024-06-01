package com.example.mycontact;

import java.util.ArrayList;

public class ContactList {
    public static ArrayList<Contact> contactList;
    static boolean isCreated = true;
    public static void  createContactList(){
        if (isCreated){
            contactList = new ArrayList<>();
            contactList.add(new Contact("John Smith", "555-1234", "123 Elm St, Springfield, IL", "January 12, 1990"));
            contactList.add(new Contact("Emily Johnson", "555-5678", "456 Oak St, Springfield, IL", "March 5, 1991"));
            contactList.add(new Contact("Michael Brown", "555-8765", "789 Pine St, Springfield, IL", "July 23, 1989"));
            contactList.add(new Contact("Jessica Davis", "555-4321", "101 Maple St, Springfield, IL", "November 8, 1992"));
            contactList.add(new Contact("David Wilson", "555-2345", "202 Cedar St, Springfield, IL", "April 17, 1988"));
            contactList.add(new Contact("Sarah Miller", "555-6789", "303 Birch St, Springfield, IL", "August 29, 1991"));
            contactList.add(new Contact("James Martinez", "555-8760", "404 Ash St, Springfield, IL", "February 3, 1990"));
            contactList.add(new Contact("Ashley Garcia", "555-4322", "505 Walnut St, Springfield, IL", "June 20, 1992"));
            contactList.add(new Contact("Robert Anderson", "555-3456", "606 Poplar St, Springfield, IL", "December 11, 1989"));
            contactList.add(new Contact("Amanda Thomas", "555-7890", "707 Cherry St, Springfield, IL", "May 6, 1991"));
            contactList.add(new Contact("Matthew Taylor", "555-0987", "808 Redwood St, Springfield, IL", "September 27, 1990"));
            contactList.add(new Contact("Elizabeth Lee", "555-6543", "909 Cypress St, Springfield, IL", "January 19, 1991"));
            contactList.add(new Contact("Joshua Harris", "555-8764", "1010 Fir St, Springfield, IL", "March 14, 1992"));
            contactList.add(new Contact("Stephanie Clark", "555-4323", "1111 Spruce St, Springfield, IL", "July 7, 1988"));
            contactList.add(new Contact("Daniel Walker", "555-7891", "1212 Hemlock St, Springfield, IL", "November 25, 1991"));

            isCreated = false;
        }
     }

    public static void addContact(String name, String phoneNumber, String address, String dob) {
        if (contactList != null) {
            System.out.println("before: " + contactList.size());
            contactList.add(new Contact(name, phoneNumber, address, dob));
            System.out.println(name+ phoneNumber + address + dob);
            System.out.println("after: " + contactList.size());
        } else {
            System.out.println("Contact list is not initialized");
        }
    }
}

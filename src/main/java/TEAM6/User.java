package TEAM6;

import java.util.Date;

public class User {
    // Attributes
    private int id;
    private int cardFk; // Foreign key for card
    private Date cardStartDate;
    private Date cardEndDate;
    private String name;
    private String surname;
    private Date birthDate;
    private String phoneNumber;
    private String email;

    // Constructor
    public User(int id, int cardFk, Date cardStartDate, Date cardEndDate, String name, String surname, Date birthDate, String phoneNumber, String email) {
        this.id = id;
        this.cardFk = cardFk;
        this.cardStartDate = cardStartDate;
        this.cardEndDate = cardEndDate;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getCardFk() {
        return cardFk;
    }

    public Date getCardStartDate() {
        return cardStartDate;
    }

    public Date getCardEndDate() {
        return cardEndDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCardFk(int cardFk) {
        this.cardFk = cardFk;
    }

    public void setCardStartDate(Date cardStartDate) {
        this.cardStartDate = cardStartDate;
    }

    public void setCardEndDate(Date cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

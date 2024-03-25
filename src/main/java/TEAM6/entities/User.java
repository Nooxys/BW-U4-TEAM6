package TEAM6.entities;

import java.time.LocalDate;

public class User {
    // ATTRIBUTES
    private long id;
    private int cardFk;
    private LocalDate cardStartDate;
    private LocalDate cardEndDate;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;

    // CONSTRUCTORS
    public User(int cardFk, LocalDate cardStartDate, LocalDate cardEndDate, String name, String surname, LocalDate birthDate, String phoneNumber, String email) {
        this.cardFk = cardFk;
        this.cardStartDate = cardStartDate;
        this.cardEndDate = cardEndDate;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public int getCardFk() {
        return cardFk;
    }

    public LocalDate getCardStartDate() {
        return cardStartDate;
    }

    public LocalDate getCardEndDate() {
        return cardEndDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setCardFk(int cardFk) {
        this.cardFk = cardFk;
    }

    public void setCardStartDate(LocalDate cardStartDate) {
        this.cardStartDate = cardStartDate;
    }

    public void setCardEndDate(LocalDate cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

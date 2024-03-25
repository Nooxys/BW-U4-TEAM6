package TEAM6.entities;

import java.time.LocalDate;
import java.util.Random;

public class User {
    // ATTRIBUTES
    private long id;
    private int card;
    private LocalDate cardStartDate;
    private LocalDate cardEndDate;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;

    // CONSTRUCTORS
    public User(int card, String name, String surname, LocalDate birthDate, String phoneNumber, String email) {
        this.card = card;
        setCardStartDate();
        setCardEndDate();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(){}

    // GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public int getCardFk() {
        return card;
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

    public void setCardFk(int card) {
        this.card = card;
    }

    public void setCardStartDate() {
        Random random = new Random();
        this.cardStartDate = LocalDate.of(2024, random.nextInt(1, 4), random.nextInt(1, 29));
    }

    public void setCardEndDate() {
        this.cardEndDate = this.cardStartDate.plusYears(1);
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

//    TO STRING
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", card=" + card +
                ", cardStartDate=" + cardStartDate +
                ", cardEndDate=" + cardEndDate +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

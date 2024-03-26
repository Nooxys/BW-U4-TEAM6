package TEAM6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "users")
public class User {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int card;
    @Column(name = "card_start_date")
    private LocalDate cardStartDate;
    @Column(name = "card_end_date")
    private LocalDate cardEndDate;
    private String name;
    private String surname;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "phone_number")
    private int phoneNumber;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Rate> rateList;

    // CONSTRUCTORS
    public User(int card, String name, String surname, LocalDate birthDate, int phoneNumber, String email) {
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

    public int getPhoneNumber() {
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

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
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
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", rateList=" + rateList +
                '}';
    }
}

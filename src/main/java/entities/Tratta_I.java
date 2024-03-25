package entities;
import jakarta.persistence.*;



//@Table(name = "routes")
public class Tratta_I {
    //@Id
    //@GeneratedValue
    private long id;
    private char partenza;
    private char capolinea;
    private int tempo_medio_di_percorrenza;
    private int mezzo;

    public Tratta_I(char partenza, char capolinea, int tempoMedioDiPercorrenza, int mezzo) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        tempo_medio_di_percorrenza = tempoMedioDiPercorrenza;
        this.mezzo = mezzo;
    }

    public long getId() {
        return id;
    }
    public char getPartenza() {
        return partenza;
    }

    public void setPartenza(char partenza) {
        this.partenza = partenza;
    }

    public char getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(char capolinea) {
        this.capolinea = capolinea;
    }

    public int getTempo_medio_di_percorrenza() {
        return tempo_medio_di_percorrenza;
    }

    public void setTempo_medio_di_percorrenza(int tempo_medio_di_percorrenza) {
        this.tempo_medio_di_percorrenza = tempo_medio_di_percorrenza;
    }

    public int getMezzo() {
        return mezzo;
    }

    public void setMezzo(int mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "Tratta_I{" +
                "id=" + id +
                ", partenza=" + partenza +
                ", capolinea=" + capolinea +
                ", tempo_medio_di_percorrenza=" + tempo_medio_di_percorrenza +
                ", mezzo=" + mezzo +
                '}';
    }

}

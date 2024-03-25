package TEAM6.entities;

//@Table(name = "routes")
public class Route {
//    ATTRIBUTES
        //@Id
        //@GeneratedValue
        private long id;
        private char partenza;
        private char capolinea;
        private int tempoMedioDiPercorrenza;
        private int mezzo;

//        CONSTRUCTORS
        public Route(char partenza, char capolinea, int tempoMedioDiPercorrenza, int mezzo) {
            this.partenza = partenza;
            this.capolinea = capolinea;
            this.tempoMedioDiPercorrenza = tempoMedioDiPercorrenza;
            this.mezzo = mezzo;
        }

        public Route() {}

//    GETTERS AND SETTERS
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

        public int getTempoMedioDiPercorrenza() {
            return tempoMedioDiPercorrenza;
        }

        public void setTempoMedioDiPercorrenza(int tempoMedioDiPercorrenza) {
            this.tempoMedioDiPercorrenza = tempoMedioDiPercorrenza;
        }

        public int getMezzo() {
            return mezzo;
        }

        public void setMezzo(int mezzo) {
            this.mezzo = mezzo;
        }

//        TO STRING
        @Override
        public String toString() {
            return "Route{" +
                    "id=" + id +
                    ", partenza=" + partenza +
                    ", capolinea=" + capolinea +
                    ", tempoMedioDiPercorrenza=" + tempoMedioDiPercorrenza +
                    ", mezzo=" + mezzo +
                    '}';
        }
}

package parser.xml.application.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Proiect {

    private String numeProiect;
    private Echipa echipaCoordonatoare;
    private List<Angajat> contribuitori = new ArrayList<Angajat>();
    private LocalDate dataIncheiereProiect;

    @JsonCreator
    public Proiect(@JsonProperty("NUME_PROIECT") String numeProiect,
                   @JsonProperty("ECHIPA_COORDONATOARE") Echipa echipaCoordonatoare,
                   @JsonProperty("CONTRIBUITORI") List<Angajat> contribuitori,
                   @JsonProperty("DATA_INCHEIERE_PROIECT") LocalDate dataIncheiereProiect) {
        this.numeProiect = numeProiect;
        this.echipaCoordonatoare = echipaCoordonatoare;
        this.contribuitori = contribuitori;
        this.dataIncheiereProiect = dataIncheiereProiect;
    }

    public Proiect(String numeProiect, Echipa echipaCoordonatoare, LocalDate dataIncheiereProiect) {
        this.numeProiect = numeProiect;
        this.echipaCoordonatoare = echipaCoordonatoare;
        this.dataIncheiereProiect = dataIncheiereProiect;
    }

    public String getNumeProiect() {
        return numeProiect;
    }

    public void setNumeProiect(String numeProiect) {
        this.numeProiect = numeProiect;
    }

    public Echipa getEchipaCoordonatoare() {
        return echipaCoordonatoare;
    }

    public void setEchipaCoordonatoare(Echipa echipaCoordonatoare) {
        this.echipaCoordonatoare = echipaCoordonatoare;
    }

    public List<Angajat> getContribuitori() {
        return contribuitori;
    }

    public void setContribuitori(List<Angajat> contribuitori) {
        this.contribuitori = contribuitori;
    }

    public LocalDate getDataIncheiereProiect() {
        return dataIncheiereProiect;
    }

    public void setDataIncheiereProiect(LocalDate dataIncheiereProiect) {
        this.dataIncheiereProiect = dataIncheiereProiect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proiect proiect = (Proiect) o;
        return Objects.equals(numeProiect, proiect.numeProiect) &&
                Objects.equals(echipaCoordonatoare, proiect.echipaCoordonatoare) &&
                Objects.equals(contribuitori, proiect.contribuitori) &&
                Objects.equals(dataIncheiereProiect, proiect.dataIncheiereProiect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeProiect, echipaCoordonatoare, contribuitori, dataIncheiereProiect);
    }

    @Override
    public String toString() {
        return "Proiect{" +
                "numeProiect='" + numeProiect + '\'' +
                ", echipaCoordonatoare=" + echipaCoordonatoare +
                ", contribuitori=" + contribuitori +
                ", dataIncheiereProiect=" + dataIncheiereProiect +
                '}';
    }
}

package parser.xml.application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Sistem {

    private List<Echipa> Echipe = new ArrayList<>();
    private List<Angajat> Angajati = new ArrayList<>();
    private List<Proiect> Proiecte = new ArrayList<>();

    public Sistem(List<Echipa> echipe, List<Angajat> angajati, List<Proiect> proiecte) {
        Echipe = echipe;
        Angajati = angajati;
        Proiecte = proiecte;
    }

    public Sistem() {
        super();
    }

    public List<Echipa> getEchipe() {
        return Echipe;
    }

    public void setEchipe(List<Echipa> echipe) {
        Echipe = echipe;
    }

    public List<Angajat> getAngajati() {
        return Angajati;
    }

    public void setAngajati(List<Angajat> angajati) {
        Angajati = angajati;
    }

    public List<Proiect> getProiecte() {
        return Proiecte;
    }

    public void setProiecte(List<Proiect> proiecte) {
        Proiecte = proiecte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sistem sistem = (Sistem) o;
        return Objects.equals(Echipe, sistem.Echipe) &&
                Objects.equals(Angajati, sistem.Angajati) &&
                Objects.equals(Proiecte, sistem.Proiecte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Echipe, Angajati, Proiecte);
    }

    @Override
    public String toString() {
        return "Sistem{" +
                "Echipe=" + Echipe +
                ", Angajati=" + Angajati +
                ", Proiecte=" + Proiecte +
                '}';
    }
}

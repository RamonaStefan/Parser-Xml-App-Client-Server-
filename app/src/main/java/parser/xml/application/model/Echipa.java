package parser.xml.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class Echipa {

    private String numeEchipa;
    private String sefEchipa;

    public Echipa(@JsonProperty("ECHIPA") String numeEchipa) {
        this.numeEchipa = numeEchipa;
    }

    public void setNumeEchipa(String numeEchipa) {
        this.numeEchipa = numeEchipa;
    }

    public String getNumeEchipa() {
        return numeEchipa;
    }

    public String getSefEchipa() {
        return sefEchipa;
    }

    public void setSefEchipa(String sefEchipa) {
        this.sefEchipa = sefEchipa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Echipa echipa = (Echipa) o;
        return Objects.equals(numeEchipa, echipa.numeEchipa) &&
                Objects.equals(sefEchipa, echipa.sefEchipa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeEchipa, sefEchipa);
    }

    @Override
    public String toString() {
        return "Echipa{" +
                "numeEchipa='" + numeEchipa + '\'' +
                ", sefEchipa=" + sefEchipa +
                '}';
    }
}

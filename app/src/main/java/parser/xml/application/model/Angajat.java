package parser.xml.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class Angajat {
    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private int salariu;
    private int oreLucrate;
    private LocalDate dataAngajare;
    private LocalDate dataIncheiereContract;
    private Echipa echipa;
    private Angajat sef;
    private List<String> beneficii = new ArrayList<String>();
    private String tipAngajat;
    private int zileConcediu;

    public Angajat(@JsonProperty("NUME") String nume,
                   @JsonProperty("PRENUME") String prenume,
                   @JsonProperty("EMAIL") String email,
                   @JsonProperty("TELEFON") String telefon,
                   @JsonProperty("SALARIU") int salariu,
                   @JsonProperty("ORE_LUCRATE") int oreLucrate,
                   @JsonProperty("DATA_ANGAJARE") LocalDate dataAngajare,
                   @JsonProperty("DATA_INCHEIERE_CONTRACT") LocalDate dataIncheiereContract,
                   @JsonProperty("APARTINE_ECHIPA") Echipa echipa,
                   @JsonProperty("SEF") Angajat sef,
                   @JsonProperty("BENEFICII") List beneficii) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.salariu = salariu;
        this.oreLucrate = oreLucrate;
        this.dataAngajare = dataAngajare;
        this.dataIncheiereContract = dataIncheiereContract;
        this.echipa = echipa;
        this.sef = sef;
        this.beneficii = beneficii;
    }

    public Angajat(String nume, String prenume, String email, String telefon, int salariu, int oreLucrate, LocalDate dataAngajare, LocalDate dataIncheiereContract, Echipa echipa, List<String> beneficii) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.salariu = salariu;
        this.oreLucrate = oreLucrate;
        this.dataAngajare = dataAngajare;
        this.dataIncheiereContract = dataIncheiereContract;
        this.echipa = echipa;
        this.beneficii = beneficii;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public int getOreLucrate() {
        return oreLucrate;
    }

    public void setOreLucrate(int oreLucrate) {
        this.oreLucrate = oreLucrate;
    }

    public LocalDate getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(LocalDate dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public LocalDate getDataIncheiereContract() {
        return dataIncheiereContract;
    }

    public void setDataIncheiereContract(LocalDate dataIncheiereContract) {
        this.dataIncheiereContract = dataIncheiereContract;
    }

    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
        this.echipa = echipa;
    }

    public Angajat getSef() {
        return sef;
    }

    public void setSef(Angajat sef) {
        this.sef = sef;
    }

    public List getBeneficii() {
        return beneficii;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return salariu == angajat.salariu &&
                oreLucrate == angajat.oreLucrate &&
                zileConcediu == angajat.zileConcediu &&
                Objects.equals(nume, angajat.nume) &&
                Objects.equals(prenume, angajat.prenume) &&
                Objects.equals(email, angajat.email) &&
                Objects.equals(telefon, angajat.telefon) &&
                Objects.equals(dataAngajare, angajat.dataAngajare) &&
                Objects.equals(dataIncheiereContract, angajat.dataIncheiereContract) &&
                Objects.equals(echipa, angajat.echipa) &&
                Objects.equals(sef, angajat.sef) &&
                Objects.equals(beneficii, angajat.beneficii) &&
                Objects.equals(tipAngajat, angajat.tipAngajat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, email, telefon, salariu, oreLucrate, dataAngajare, dataIncheiereContract, echipa, sef, beneficii, tipAngajat, zileConcediu);
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", salariu=" + salariu +
                ", oreLucrate=" + oreLucrate +
                ", dataAngajare=" + dataAngajare +
                ", dataIncheiereContract=" + dataIncheiereContract +
                ", echipa=" + echipa +
                ", sef=" + sef +
                ", beneficii=" + beneficii +
                ", tipAngajat='" + tipAngajat + '\'' +
                ", zileConcediu=" + zileConcediu +
                '}';
    }

    public void setBeneficii(List<String> beneficii) {
        this.beneficii = beneficii;
    }

    public String getTipAngajat() {
        return tipAngajat;
    }

    public void setTipAngajat(String tipAngajat) {
        this.tipAngajat = tipAngajat;
    }

    public int getZileConcediu() {
        return zileConcediu;
    }

    public void setZileConcediu(int zileConcediu) {
        this.zileConcediu = zileConcediu;
    }
}

package parser.xml.application.model;

import parser.xml.application.service.ReadXMLFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class FunctionalClass {
    protected Sistem sistem = new Sistem();
    protected ReadXMLFile r = new ReadXMLFile();

    public FunctionalClass() {
        r.deparse(sistem);
    }

    protected String[] getNumeAngajati(List<Angajat> array) {
        int length = array.size();
        String[] names = new String[length];
        for(int i = 0; i < length; i++) {
            names[i] = (array.get(i).getNume() + " " + array.get(i).getPrenume()).toUpperCase();
        }
        return names;
    }

    protected String[] getNumeEchipe(List<Echipa> array) {
        int length = array.size();
        String[] names = new String[length];
        for(int i = 0; i < length; i++) {
            names[i] = (array.get(i).getNumeEchipa()).toUpperCase();
        }
        return names;
    }

    protected String[] getNumeProiecte(List<Proiect> array) {
        int length = array.size();
        String[] names = new String[length];
        for(int i = 0; i < length; i++) {
            names[i] = (array.get(i).getNumeProiect()).toUpperCase();
        }
        return names;
    }

    public List getResults( HttpServletRequest request) {
        String angajat = request.getParameter("Angajat");
        String echipa = request.getParameter("Echipa");
        String proiect = request.getParameter("Proiect");
        String program = request.getParameter("Program");
        String sefEchipa = request.getParameter("sefEchipa");
        String salariu = request.getParameter("Salariu");
        String senior = request.getParameter("senior");
        String junior = request.getParameter("junior");
        String concediu = request.getParameter("Concediu");
        ArrayList<Angajat> results = getResultsByAng(angajat);
        if(results != null) {
            results = getResultsByEch(echipa, results);
        }
        if(results != null) {
            results = getResultsByPrj(proiect, results);
        }
        if(results != null) {
            results = getResultsBySchedule(program, results);
        }
        if(results != null) {
            results = getResultsBySalary(salariu, results);
        }
        if(results != null) {
            results = getResultsByBoss(sefEchipa, results);
        }
        if(results != null) {
            results = getResultsByExperience(senior, junior, results);
        }
        if(results != null) {
            results = getResultsByFreeDays(concediu, results);
        }

        return results;
    }

    public ArrayList<Angajat> getResultsByFreeDays(String concediu, ArrayList<Angajat> results) {
        final int con;
        if(!concediu.equals("default")) {
            switch(concediu) {
                case "20": con = 20; break;
                case "23": con = 23; break;
                case "25": con = 25; break;
                default: con = 0;
            }
            return  (ArrayList<Angajat>) results.stream()
                    .filter(angajatt-> (angajatt.getZileConcediu() == con))
                    .collect(Collectors.toList());
        }
        else {
            return results;
        }
    }

    public ArrayList<Angajat> getResultsByExperience(String senior, String junior, ArrayList<Angajat> results) {
        if (senior != null && junior != null) {
            return results;
        }
        else if (senior != null && senior.equals("senior")) {
            return  (ArrayList<Angajat>) results.stream()
                    .filter(r -> r.getZileConcediu() >=23)
                    .collect(Collectors.toList());
        }
        else if (junior != null && junior.equals("junior")) {
            return  (ArrayList<Angajat>) results.stream()
                    .filter(r -> r.getZileConcediu() <23)
                    .collect(Collectors.toList());
        }
        else {
            return results;
        }

    }

    public ArrayList<Angajat> getResultsBySalary(String salariu, ArrayList<Angajat> results) {
        final int sal;
        if(!salariu.equals("default")) {
            switch(salariu) {
                case "2000": sal = 2000; break;
                case "3000": sal = 3000; break;
                case "4000": sal = 4000; break;
                case "5000": sal = 5000; break;
                default: sal = 0;
            }
            return  (ArrayList<Angajat>) results.stream()
                    .filter(angajatt-> (angajatt.getSalariu() >= sal && angajatt.getSalariu() < sal+1000) || (angajatt.getSalariu() >= sal && sal == 5000))
                    .collect(Collectors.toList());
        }
        else {
            return results;
        }
    }

    public ArrayList<Angajat> getResultsByBoss(String sefEchipa, ArrayList<Angajat> results) {
        if(sefEchipa != null && sefEchipa.equals("sefEchipa")) {
            ArrayList<String> sef = new ArrayList<>();
            sistem.getEchipe().stream().forEach(e -> sef.add(e.getSefEchipa()));
            return  (ArrayList<Angajat>) results.stream()
                    .filter(angajatt-> sef.contains(angajatt.getNume() + " " + angajatt.getPrenume()))
                    .collect(Collectors.toList());
        }
        else {
            return results;
        }
    }

    public ArrayList<Angajat> getResultsBySchedule(String program, ArrayList<Angajat> results) {
        if(!program.equals("default")) {
            return  (ArrayList<Angajat>) results.stream()
                    .filter(angajatt-> angajatt.getTipAngajat().equals(program))
                    .collect(Collectors.toList());
        }
        else {
            return results;
        }
    }

    public ArrayList<Angajat> getResultsByAng(String angajat) {
        if(!angajat.equals("default")) {
           return  (ArrayList<Angajat>) sistem.getAngajati().stream()
                    .filter(angajatt-> (angajatt.getNume() + " " + angajatt.getPrenume()).toUpperCase().equals(angajat))
                    .collect(Collectors.toList());
        }
        else {
            return (ArrayList<Angajat>)  sistem.getAngajati();
        }
    }

    public ArrayList<Angajat> getResultsByEch(String echipa, ArrayList<Angajat> results) {
        if(!echipa.equals("default")) {
            return (ArrayList<Angajat>) results.stream()
                    .filter(result -> result.getEchipa().getNumeEchipa().toUpperCase().equals(echipa))
                    .collect(Collectors.toList());
        }
        else {
            return results;
        }
    }

    public ArrayList<Angajat> getResultsByPrj(String project, ArrayList<Angajat> results) {
        final ArrayList<Proiect> proiectt;
        ArrayList<Angajat> newResult = new ArrayList<>();
        if(!project.equals("default")) {
            proiectt = (ArrayList<Proiect> ) sistem.getProiecte().stream()
                    .filter(pr -> pr.getNumeProiect().toUpperCase().equals(project))
                    .collect(Collectors.toList());
//            proiectt.stream()
//                    .forEach(pr -> pr.getContribuitori().stream()
//                            .forEach(c-> newResult.add(c)));
//            proiectt.stream()
//                    .filter(p -> !Collections.disjoint(p.getContribuitori(), results))
//                    .collect(Collectors.toList());
            return (ArrayList<Angajat>) results.stream()
                    .filter(r -> proiectt.get(0).getContribuitori().contains(r))
                    .collect(Collectors.toList());
//            return newResult;
        }
        else {
            return results;
        }
    }


    public Sistem getSistem() {
        return sistem;
    }

    public void setSistem(Sistem sistem) {
        this.sistem = sistem;
    }

    public ReadXMLFile getR() {
        return r;
    }

    public void setR(ReadXMLFile r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionalClass that = (FunctionalClass) o;
        return Objects.equals(sistem, that.sistem) &&
                Objects.equals(r, that.r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sistem, r);
    }

}

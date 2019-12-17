package parser.xml.application.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.xml.application.model.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadXMLFile{

    public void deparse(Sistem sistem) {
        try {

            File fXmlFile = new File("E:\\FACULTATE\\SBC\\baza_cunostinte_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList_echipe = doc.getElementsByTagName("ECHIPE");

            for (int temp = 0; temp < nList_echipe.getLength(); temp++) {
                NodeList nList_echipa = doc.getElementsByTagName("ECHIPA");
                Node nNode_echipa = nList_echipe.item(temp);
                Element eElement = (Element) nNode_echipa;

                for (int i = 0; i < nList_echipa.getLength(); i++) {
                    sistem.getEchipe().add(new Echipa(eElement.getElementsByTagName("ECHIPA").item(i).getTextContent()));
                }
            }

            NodeList nList_angajati = doc.getElementsByTagName("ANGAJATI");
            for (int temp = 0; temp < nList_angajati.getLength(); temp++) {
                NodeList nList_angajat = doc.getElementsByTagName("ANGAJAT");
                Node nNode_angajat = nList_angajati.item(temp);
                Element eElement = (Element) nNode_angajat;


                for (int i = 0; i < nList_angajat.getLength(); i++) {
                    String dataAngajare = eElement.getElementsByTagName("DATA_ANGAJARE").item(i).getTextContent();
                    String dataIncheiere = eElement.getElementsByTagName("DATA_INCHEIERE_CONTRACT").item(i).getTextContent();
                    sistem.getAngajati().add(new Angajat(eElement.getElementsByTagName("NUME").item(i).getTextContent(),
                                                         eElement.getElementsByTagName("PRENUME").item(i).getTextContent(),
                                                         eElement.getElementsByTagName("EMAIL").item(i).getTextContent(),
                                                         eElement.getElementsByTagName("TELEFON").item(i).getTextContent(),
                                                         Integer.parseInt(eElement.getElementsByTagName("SALARIU").item(i).getTextContent()),
                                                         Integer.parseInt(eElement.getElementsByTagName("ORE_LUCRATE").item(i).getTextContent()),
                                                         LocalDate.of(Integer.parseInt(dataAngajare.split("-", 4)[2]),
                                                                      Integer.parseInt(dataAngajare.split("-", 4)[1]),
                                                                      Integer.parseInt(dataAngajare.split("-", 4)[0])),
                                                         LocalDate.of(Integer.parseInt(dataIncheiere.split("-", 4)[2]),
                                                                      Integer.parseInt(dataIncheiere.split("-", 4)[1]),
                                                                      Integer.parseInt(dataIncheiere.split("-", 4)[0])),
                                                         sistem.getEchipe().get(findEchipa(sistem, eElement.getElementsByTagName("APARTINE_ECHIPA").item(i).getTextContent())),
                                                         new ArrayList<String>(Arrays.asList(eElement.getElementsByTagName("BENEFICII").item(i).getTextContent()))));
                    if (eElement.getElementsByTagName("SEF").item(i) != null && eElement.getElementsByTagName("SEF").item(i).getTextContent() != null){
                        int index = findSef(sistem, eElement.getElementsByTagName("SEF").item(i).getTextContent());
                        if(index != -1) {
                            sistem.getAngajati().get(i).setSef(sistem.getAngajati().get(index));
                        }
                        else {
                            sistem.getAngajati().get(i).setSef(null);
                        }
                    }
                    else {
                        sistem.getAngajati().get(i).setSef(null);
                    }
                }
            }

            NodeList nList_proiecte = doc.getElementsByTagName("PROIECTE");
            for (int temp = 0; temp < nList_proiecte.getLength(); temp++) {
                NodeList nList_proiect = doc.getElementsByTagName("PROIECT");
                Node nNode_proiect = nList_proiecte.item(temp);
                Element eElement = (Element) nNode_proiect;

                for (int i = 0; i < nList_proiect.getLength(); i++) {
                    String dataIncheiereProiect = eElement.getElementsByTagName("DATA_INCHEIERE_PROIECT").item(i).getTextContent();
                    sistem.getProiecte().add(new Proiect(eElement.getElementsByTagName("NUME_PROIECT").item(i).getTextContent(),
                                             sistem.getEchipe().get(findEchipa(sistem, eElement.getElementsByTagName("ECHIPA_COORDONATOARE").item(i).getTextContent())),
                                             LocalDate.of(Integer.parseInt(dataIncheiereProiect.split("-", 4)[2]),
                                                          Integer.parseInt(dataIncheiereProiect.split("-", 4)[1]),
                                                          Integer.parseInt(dataIncheiereProiect.split("-", 4)[0]))));

                    NodeList nList_contribuitori = doc.getElementsByTagName("CONTRIBUITORI");
                    Node nNode_contribuitori = nList_contribuitori.item(i);
                    Element eElement3 = (Element) nNode_contribuitori;
                    for (int temp2 = 0; temp2 < nList_contribuitori.getLength(); temp2++) {
                        NodeList nList_contribuitor = eElement3.getElementsByTagName("CONTRIBUITOR");
                        for (int j = 0; j < nList_contribuitor.getLength(); j++) {
                            if (eElement3.getElementsByTagName("CONTRIBUITOR").item(j) != null && eElement3.getElementsByTagName("CONTRIBUITOR").item(j).getTextContent() != null){
                                int index = findSef(sistem, eElement3.getElementsByTagName("CONTRIBUITOR").item(j).getTextContent());
                                if(index != -1) {
                                    if (sistem.getProiecte().get(i).getContribuitori().contains(sistem.getAngajati().get(index)) == false) {
                                        sistem.getProiecte().get(i).getContribuitori().add(sistem.getAngajati().get(index));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            NodeList nList_reguli = doc.getElementsByTagName("REGULI");
            for (int temp = 0; temp < nList_reguli.getLength(); temp++) {

                NodeList nList_regula = doc.getElementsByTagName("REGULA");
                Node nNode_regula = nList_reguli.item(temp);
                Element eElement = (Element) nNode_regula;

                for (int i = 0; i < nList_regula.getLength(); i++) {
                    String persIf = eElement.getElementsByTagName("PERSI").item(i).getTextContent();
                    String relIf = eElement.getElementsByTagName("RELI").item(i).getTextContent();
                    String whatIf = eElement.getElementsByTagName("WHATI").item(i).getTextContent();

                    String persThen = eElement.getElementsByTagName("PERST").item(i).getTextContent();
                    String relThen = eElement.getElementsByTagName("RELT").item(i).getTextContent();
                    String whatThen = eElement.getElementsByTagName("WHATT").item(i).getTextContent();
                    addInformation(sistem, persIf, relIf, whatIf, persThen, relThen, whatThen);
                    int k = 7;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addInformation(Sistem sistem, String persIf, String relIf, String whatIf, String persThen, String relThen, String whatThen) {
        if (persIf.contains("ore_lucrate")) {
            addTypeEmployer(sistem, relIf, whatIf, relThen, whatThen);
        }
        if (persIf.contains("vechime")) {
            addFreeDays(sistem, relIf, whatIf, relThen, whatThen);
        }
        if (persIf.contains("nume")) {
            addTeamBoss(sistem, relIf, whatIf, relThen, whatThen);
        }
    }

    public void addTeamBoss(Sistem sistem, String relIf, String whatIf, String relThen, String whatThen) {
        for(Angajat ang:sistem.getAngajati()){
            if(relIf.replaceAll(" ","").equals("nu_are") && ang.getSef() == null && relThen.replaceAll(" ","").equals("este")) {
                sistem.getEchipe().stream()
                        .filter(e -> e.getNumeEchipa().equals(ang.getEchipa().getNumeEchipa()))
                        .forEach(e -> e.setSefEchipa(ang.getNume() + " " + ang.getPrenume()));
            }
        }
    }

    public void addTypeEmployer(Sistem sistem, String relIf, String whatIf, String relThen, String whatThen) {
        for(Angajat ang:sistem.getAngajati()){
            if(relIf.replaceAll(" ","").equals("mare") && ang.getOreLucrate() >= Integer.parseInt(whatIf.replaceAll(" ","")) && relThen.replaceAll(" ","").equals("este")) {
                ang.setTipAngajat(whatThen.replaceAll(" ",""));
            }
            if(relIf.replaceAll(" ","").equals("mic") && ang.getOreLucrate() < Integer.parseInt(whatIf.replaceAll(" ","")) && relThen.replaceAll(" ","").equals("este")) {
                ang.setTipAngajat(whatThen.replaceAll(" ",""));
            }
        }
    }

    public void addFreeDays(Sistem sistem, String relIf, String whatIf, String relThen, String whatThen) {
        for(Angajat ang:sistem.getAngajati()){
            if(relIf.replaceAll(" ","").equals("mare") && Period.between(ang.getDataAngajare(), LocalDate.now()).getYears() >= Integer.parseInt(whatIf.replaceAll(" ","")) && relThen.replaceAll(" ","").equals("are")) {
                if(whatIf.replaceAll(" ","").equals("3") && Period.between(ang.getDataAngajare(), LocalDate.now()).getYears() >= 5)
                    continue;
                ang.setZileConcediu(Integer.parseInt(whatThen.replaceAll(" ","")));
            }
            else if(relIf.replaceAll(" ","").equals("mic") && Period.between(ang.getDataAngajare(), LocalDate.now()).getYears() < Integer.parseInt(whatIf.replaceAll(" ","")) && relThen.replaceAll(" ","").equals("are")) {
                ang.setZileConcediu(Integer.parseInt(whatThen.replaceAll(" ","")));
            }
        }
    }

    public int findEchipa (Sistem sistem, String nume) {
        int length = sistem.getEchipe().size();
        for (int i = 0; i < length; i++) {
            if (sistem.getEchipe().get(i).getNumeEchipa().equals(nume)) {
                return i;
            }
        }
        return -1;
    }

    public int findSef (Sistem sistem, String nume) {
        int length = sistem.getAngajati().size();
        for (int i = 0; i < length; i++) {
            if ((sistem.getAngajati().get(i).getNume() + " " + sistem.getAngajati().get(i).getPrenume()).equals(nume)) {
                return i;
            }
        }
        return -1;
    }
}
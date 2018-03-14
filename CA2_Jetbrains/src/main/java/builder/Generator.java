/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author PC
 */
public class Generator {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    EntityManager em = emf.createEntityManager();

    public void putGeneratedPeopleInDatabase(int amount) {
        //Person
        ArrayList<String> firstNames = Generator.firstNames();
        ArrayList<String> lastNames = Generator.lastNames();

        //Hobbies
        List<Hobby> listOfHobbies = Generator.differentHobbies();

        //Addresses
        ArrayList<String> streetNames = Generator.differentStreetNames();
        ArrayList<String> addressInfo = Generator.differentAdditionalInfoAddresses();

        //Zipcodes
        List<CityInfo> listOfInfo = Generator.getAllCityInfos();

        for (int i = 0; i < amount; i++) {
            em.getTransaction().begin();
            Person person = new Person(firstNames.get((int) (Math.random() * firstNames.size())), lastNames.get((int) (Math.random() * lastNames.size())));
            for (int j = 0; j <= (int) (Math.random() * 2); j++) {
                person.addPhoneNumber(new Phone(Generator.randomizePhones(), "APhoneNumber"));
            }
            person.addHobby(listOfHobbies.get((int) (Math.random() * listOfHobbies.size())));
            person.setAddress(new Address(streetNames.get((int) (Math.random() * streetNames.size())), addressInfo.get((int) (Math.random() * addressInfo.size())), listOfInfo.get((int) (Math.random() * listOfInfo.size()))));
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    public void putGeneratedCompaniesInDatabase(int amount) {
        //Company
        ArrayList<String> companyNames = Generator.companyNames();
        ArrayList<String> companyDescs = Generator.companyDescriptions();
        ArrayList<String> marketValues = Generator.marketValues();

        //Addresses
        ArrayList<String> streetNames = Generator.differentStreetNames();
        ArrayList<String> addressInfo = Generator.differentAdditionalInfoAddresses();
        
        //Zipcodes
        List<CityInfo> listOfInfo = Generator.getAllCityInfos();
        
        for (int i = 0; i < amount; i++) {
            em.getTransaction().begin();
            Company company = new Company(companyNames.get((int) (Math.random() * companyNames.size())), companyDescs.get((int) (Math.random() * companyDescs.size())), Generator.companyCvrs(), (int) (Math.random() * 999), marketValues.get((int) (Math.random() * marketValues.size())));
            for (int j = 0; j <= (int) (Math.random() * 2); j++) {
                company.addPhoneNumber(new Phone(Generator.randomizePhones(), "APhoneNumber"));
            }
            company.setAddress(new Address(streetNames.get((int) (Math.random() * streetNames.size())), addressInfo.get((int) (Math.random() * addressInfo.size())), listOfInfo.get((int) (Math.random() * listOfInfo.size()))));
            em.persist(company);
            em.getTransaction().commit();
        }
    }

    private static ArrayList<String> firstNames() {
        ArrayList<String> firstNames = new ArrayList();
        firstNames.add("Kasper");
        firstNames.add("David");
        firstNames.add("Oliver");
        firstNames.add("Lars");
        firstNames.add("Sigurt");
        firstNames.add("Joachim");
        firstNames.add("Kristian");
        firstNames.add("Christian");
        firstNames.add("Henrik");
        return firstNames;
    }

    private static ArrayList<String> lastNames() {
        ArrayList lastNames = new ArrayList();
        lastNames.add("Hansen");
        lastNames.add("Larsen");
        lastNames.add("Vink");
        lastNames.add("Nielsen");
        lastNames.add("Devil");
        lastNames.add("Black");
        lastNames.add("White");
        return lastNames;
    }

    private static String randomizePhones() {
        StringBuilder sb = new StringBuilder();
        sb.append((int) (Math.random() * 99));
        sb.append((int) (Math.random() * 99));
        sb.append((int) (Math.random() * 99));
        sb.append((int) (Math.random() * 99));
        return sb.toString();
    }

    private static ArrayList<String> companyNames() {
        ArrayList companyNames = new ArrayList();
        companyNames.add("Jensens bøfhus");
        companyNames.add("Data Tech");
        companyNames.add("Mc. Donalds");
        companyNames.add("Burger King");
        companyNames.add("Blizzard");
        companyNames.add("Riot Games");
        companyNames.add("Steam");
        return companyNames;
    }

    private static ArrayList<String> companyDescriptions() {
        ArrayList companyDescs = new ArrayList();
        companyDescs.add("Godt kvalitets firma");
        companyDescs.add("For og smukt firma");
        companyDescs.add("Et perfekt firma");
        companyDescs.add("Et godt firma");
        companyDescs.add("Smuk anretnings firma");
        companyDescs.add("Et stilfuldt firma");
        companyDescs.add("Et meget godt firma");
        return companyDescs;
    }

    private static String companyCvrs() {
        StringBuilder sb = new StringBuilder();
        sb.append((int) (Math.random() * 99)).append(" ");
        sb.append((int) (Math.random() * 99)).append(" ");
        sb.append((int) (Math.random() * 99)).append(" ");
        sb.append((int) (Math.random() * 99));
        return sb.toString();
    }

    private static ArrayList<String> marketValues() {
        ArrayList marketValues = new ArrayList();
        marketValues.add("Kvalitets varer");
        marketValues.add("Gode IT-løsninger");
        marketValues.add("Produktiv viden");
        marketValues.add("God sammenhold");
        marketValues.add("Robot teknologier");
        marketValues.add("Hurtige produktioner");
        marketValues.add("God kundetilfredshed");
        return marketValues;
    }

    private static List<Hobby> differentHobbies() {
        List<Hobby> diffHobbies = new ArrayList();
        diffHobbies.add(new Hobby("Football", "Sport where you kick a ball with your foot"));
        diffHobbies.add(new Hobby("Basketball", "Sport where you try to put the ball in the basket"));
        diffHobbies.add(new Hobby("Golf", "Sport where you slam a miniature ball and hit a hole"));
        diffHobbies.add(new Hobby("Counterstrike", "eSports game where you shoot people"));
        diffHobbies.add(new Hobby("League Of Legends", "eSports game where you play a game seen from above"));
        diffHobbies.add(new Hobby("Dota", "Copycat of League of Legends"));
        diffHobbies.add(new Hobby("Travian", "computergame in the browser"));
        diffHobbies.add(new Hobby("Fortnite", "eSports Third person shooter open world"));
        diffHobbies.add(new Hobby("Swimming", "Sport where you swim laps"));
        return diffHobbies;
    }

    private static ArrayList<String> differentStreetNames() {
        ArrayList streetNames = new ArrayList();
        streetNames.add("Dannevirkegade");
        streetNames.add("Hesseløgade");
        streetNames.add("Bakerstreet");
        streetNames.add("Vesterlundvej");
        streetNames.add("Rybjerg Alle");
        streetNames.add("Hobrovej");
        streetNames.add("Brohusgade");
        streetNames.add("Klaus Berntsens Vej");
        streetNames.add("Labyrinten");
        streetNames.add("Tjele Alle");
        streetNames.add("Fundersvej");
        return streetNames;
    }

    private static ArrayList<String> differentAdditionalInfoAddresses() {
        ArrayList addresses = new ArrayList();
        addresses.add("28 1 mf.");
        addresses.add("15 2 th.");
        addresses.add("1 2 tv.");
        addresses.add("3 3 mf.");
        addresses.add("5 3 th.");
        addresses.add("6 4 tv.");
        addresses.add("102 5 mf.");
        addresses.add("80 1 th.");
        addresses.add("77 3 tv.");
        addresses.add("65 2 mf.");
        return addresses;
    }

    private static List<CityInfo> getAllCityInfos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM CityInfo p");
            List<CityInfo> listOfInfos = query.getResultList();
            return listOfInfos;
        } finally {
            em.close();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import entity.Address;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class Generator {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    EntityManager em = emf.createEntityManager();

    public void putGeneratedPeopleInDatabase(int amount) {
        ArrayList<String> firstNames = Generator.firstNames();
        ArrayList<String> lastNames = Generator.lastNames();
        List<Hobby> listOfHobbies = Generator.differentHobbies();
        for (int i = 0; i < amount; i++) {
            em.getTransaction().begin();
            Person person = new Person(firstNames.get((int) (Math.random() * firstNames.size())), lastNames.get((int) (Math.random() * lastNames.size())));
            for (int j = 0; j <= (int) (Math.random() * 2); j++) {
                person.addPhoneNumber(new Phone(Generator.randomizePhones(), "APhoneNumber"));
            }
            person.addHobby(listOfHobbies.get((int) (Math.random() * listOfHobbies.size())));
            person.setAddress(new Address("Test", "Test"));
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    public void putGeneratedCompaniesInDatabase(int amount) {
        ArrayList<String> companyNames = Generator.companyNames();
        ArrayList<String> companyDescs = Generator.companyDescriptions();
        ArrayList<String> marketValues = Generator.marketValues();

        for (int i = 0; i < amount; i++) {
            em.getTransaction().begin();
            Company company = new Company(companyNames.get((int) (Math.random() * companyNames.size())), companyDescs.get((int) (Math.random() * companyDescs.size())), Generator.companyCvrs(), (int) (Math.random() * 999), marketValues.get((int) (Math.random() * marketValues.size())));
            for (int j = 0; j <= (int) (Math.random() * 2); j++) {
                company.addPhoneNumber(new Phone(Generator.randomizePhones(), "APhoneNumber"));
            }
            company.setAddress(new Address("Test", "Test"));
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
        marketValues.add("Test 1");
        marketValues.add("Test 2");
        marketValues.add("Test 3");
        marketValues.add("Test 4");
        marketValues.add("Test 5");
        marketValues.add("Test 6");
        marketValues.add("Test 7");
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
}

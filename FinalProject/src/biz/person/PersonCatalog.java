/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.person;

import biz.EcoSystem;
import biz.account.Account;
import biz.org.Organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 79813
 */
public class PersonCatalog {
    private Organization org;
    private ArrayList<Person> personList;

    public HashMap<Person, Integer> countAccount() {
        return new HashMap<>(getPersonAccountMap().entrySet().stream().collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                )
        ));
    }

    public HashMap<Person, HashSet<Account>> getPersonAccountMap() {
        HashMap<Person, HashSet<Account>> map = new HashMap<>();
        personList.forEach(p -> map.put(p, new HashSet<>()));
        org.getAccountCatalog().getAccountArrayList().forEach(account -> map.get(account.getPerson()).add(account));
        return map;
    }

    public PersonCatalog(Organization org) {
        this.org = org;
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public Person newPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName, this.org);
        personList.add(person);
        return person;
    }
}

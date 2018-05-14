package hlp.fkr;

import biz.EcoSystem;
import biz.account.Account;
import biz.enterprises.UniversityEnterprise;
import biz.nw.Network;
import biz.person.Person;
import com.github.javafaker.Faker;

import static hlp.fkr.CommonHelper.fakeAccount;
import static hlp.fkr.CommonHelper.fakePerson;

public class EcoSystemHelper {
    private static Faker faker = new Faker();

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();

        Person person;
        Account account;

        person = fakePerson(system.getSystemPersonCatalog());
        account = fakeAccount(system.getSystemAccountCatalog(), person, system.getSystemAdminRole());
        System.out.printf("Sys Admin username: %s\n", account);

        person = fakePerson(system.getSystemPersonCatalog());
        account = fakeAccount(system.getSystemAccountCatalog(), person, system.getSystemCensorRole());
        System.out.printf("Sys Censor username: %s\n\n", account);


        Network nw = system.newNetwork("NEU");
        UniversityEnterprise university = nw.getUniversity();

        // admin
        person = fakePerson(university.getAdminOrganization().getPersonCatalog());
        account = fakeAccount(university.getAdminOrganization().getAccountCatalog(), person, university.getAdminOrganization().getAdmin());
        System.out.printf("NEU Admin username: %s\n", account);

        // accounting
        person = fakePerson(university.getAccountingOrganization().getPersonCatalog());
        account = fakeAccount(university.getAccountingOrganization().getAccountCatalog(), person, university.getAccountingOrganization().getUniversityAccountingRole());
        System.out.printf("NEU Accounting username: %s\n", account);

        // supervisor
        person = fakePerson(university.getSupervisorOrganization().getPersonCatalog());
        account = fakeAccount(university.getSupervisorOrganization().getAccountCatalog(), person, university.getSupervisorOrganization().getUniversitySupervisorRole());
        System.out.printf("NEU Supervisor username: %s\n", account);

        // Sales
        person = fakePerson(university.getSalesDepartmentOrganization().getPersonCatalog());
        account = fakeAccount(university.getSalesDepartmentOrganization().getAccountCatalog(), person, university.getSalesDepartmentOrganization().getSalesPersonRole());
        System.out.printf("NEU Salesperson username: %s\n", account);
        person = fakePerson(university.getSalesDepartmentOrganization().getPersonCatalog());
        account = fakeAccount(university.getSalesDepartmentOrganization().getAccountCatalog(), person, university.getSalesDepartmentOrganization().getSalesManagerRole());
        System.out.printf("NEU SalesManager username: %s\n\n", account);

        // College
        CollegeHelper.fake(nw);

        // Ad
        AdEnterpriseHelper.fake(nw);

        // View
        ViewHelper.fake(nw);

        return system;
    }
}

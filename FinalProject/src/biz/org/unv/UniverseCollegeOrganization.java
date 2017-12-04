/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.consumerRole.ViewerRole;
import biz.role.producerRole.CollegeLecturerRole;
import biz.role.supervisorRole.UniversityDepartmentSupervisorRole;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class UniverseCollegeOrganization extends Organization {
    private int primeCostPerWeek;
    private CollegeLecturerRole collegeLecturerRole;
    private UniversityDepartmentSupervisorRole universityDepartmentSupervisorRole;
    private ViewerRole viewerRole;

    public UniverseCollegeOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        collegeLecturerRole = new CollegeLecturerRole();
        universityDepartmentSupervisorRole = new UniversityDepartmentSupervisorRole();
        viewerRole = new ViewerRole();
        primeCostPerWeek = 10;
    }

    public CollegeLecturerRole getCollegeLecturerRole() {
        return collegeLecturerRole;
    }

    public UniversityDepartmentSupervisorRole getUniversityDepartmentSupervisorRole() {
        return universityDepartmentSupervisorRole;
    }

    public ViewerRole getViewerRole() {
        return viewerRole;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(collegeLecturerRole);
        roles.add(viewerRole);
        roles.add(universityDepartmentSupervisorRole);
        return roles;
    }

    public int getPrimeCostPerWeek() {
        return primeCostPerWeek;
    }

    public void setPrimeCostPerWeek(int primeCostPerWeek) {
        this.primeCostPerWeek = primeCostPerWeek;
    }
}

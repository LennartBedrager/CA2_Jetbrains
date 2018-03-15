/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Company;
import java.util.List;

/**
 *
 * @author Anton
 */
public interface CompanyFacadeInterface {

    public void createCompany(Company company);

    public Company getCompany(int id);

    public void updateCompany(Company company);

    public void deleteCompany(int id);

    public List<Company> getAllCompanies();
}

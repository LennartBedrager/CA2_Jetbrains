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

    public Company createCompany(Company company);

    public Company deleteCompany(long id);

    public Company updateCompany(Company company);

    public List<Company> getAllCompanies();

    public Company getCompany(long id);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Address;

/**
 *
 * @author Anton
 */
public interface AddressFacadeInterface {

    public Address createAddress(Address address);

    public Address findAddress(long id);

    public Address deleteAddress(long id);

    public Address updateAddress(Address address);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Hobby;

/**
 *
 * @author Anton
 */
public interface HobbyFacadeInterface {

    public Hobby createHobby(Hobby hobby);

    public Hobby deleteHobbby(long id);

    public Hobby updateHobby(Hobby hobby);

    public Hobby findHobby(long id);

}

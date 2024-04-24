package edu.utsa.cs3442.mas273_lab5.model;

import java.util.ArrayList;

/**
 * Represents a Scene in a play or movie script
 * A Scene is defined by an ID and a list of roles involved in that scene.
 */

public class Scene {
    private int id;
    private ArrayList<Role> roles;

    /**
     * Constructs a new Scene with a specified ID and list of roles
     *
     * @param id
     * @param roles
     */

    public Scene(int id, ArrayList<Role> roles){
        this.id = id;
        this.roles = roles;
    }

    /**
     * Returns the ID of the scene.
     * @return the ID of the scene
     */

    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the scene
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the list of roles in the scene
     * @return an ArrayList of Role objects participating in the scene
     */

    public ArrayList<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the roles involved in the scene
     * @param roles an ArrayList of Role objects tot set for the scene
     */

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    /**
     * Returns a string representation of this Scene, which includes the scene's ID
     * and a comma-separated list of character name in the scene.
     * The first character name is enclosed in double quotes
     * @return a string representation of the scene showing its ID and the involved roles
     */

    @Override
    public String toString() {
        ArrayList<Role> roles = getRoles();
        StringBuilder str = new StringBuilder();
        int i = 0;
        for( Role role : roles){
            if( i == 0){
                str.append("\"");
                str.append(role.getNameOfCharacter());
                str.append("\"");
                ++i;
            }
            else {
                str.append(role.getNameOfCharacter()).append(", ");
            }
        }
        return id + " - " + str;
    }
}

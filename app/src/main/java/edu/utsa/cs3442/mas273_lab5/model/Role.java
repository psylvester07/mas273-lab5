package edu.utsa.cs3442.mas273_lab5.model;

/**
 * Represents a Role in a theatrical play or film
 * A Role is primarily characterized by the name of the character
 */

public class Role {
    private String nameOfCharacter;

    /**
     * Constructs a new Role with the specified character name.
     *
     * @param nameOfCharacter
     */

    public Role(String nameOfCharacter){
        this.nameOfCharacter = nameOfCharacter;
    }

    /**
     * Returns the name of the character
     *
     * @return the name of the character this role represents
     *
     */

    public String getNameOfCharacter() {
        return nameOfCharacter;
    }

    /**
     * Sets the name of the character for this role
     * @param nameOfCharacter
     */

    public void setNameOfCharacter(String nameOfCharacter) {
        this.nameOfCharacter = nameOfCharacter;
    }

    /**
     * Returns a string representation of this role, which is the name of the character
     *
     * @return a string representing the name of the chgracter
     */

    @Override
    public String toString() {
        String result =  getNameOfCharacter();
        return result;

    }}

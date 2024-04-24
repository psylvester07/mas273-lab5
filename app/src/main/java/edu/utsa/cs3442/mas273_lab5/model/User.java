package edu.utsa.cs3442.mas273_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a user of the system with various attributes and roles.
 * A user is identified by their username, password, real name, and has a list of roles
 */

public class User {
    private String username;
    private String password;
    private String realName;
    private ArrayList<Role> roles;

    /**
     * Constructs a User with specified username, password, real name, and roles
     *
     * @param username
     * @param password
     * @param realName
     * @param roles
     */

    public User( String username, String password, String realName, ArrayList<Role> roles){
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.roles = roles;
    }

    /**
     * Returns the username of the user.
     * @return the username
     */


    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the passwrod of the user.
     * @return the password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the real name of the user.
     * @return the real name
     */

    public String getRealName() {
        return realName;
    }

    /**
     * Sets the real name of the user
     * @param realName
     */

    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Returns the list of roles associated with the use
     * @return the roles as an ArrayList
     */

    public ArrayList<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the roles associated with the user
     * @param roles
     */
    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    /**
     *
     * @param context
     * @return true if the credentials match an entry, false otherwise
     */

    public boolean verifyName(Context context) {
        AssetManager manager = context.getAssets();

        boolean isTrue = false;
        InputStream file;
        try {
            file = manager.open("data/users.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(Scanner scanner = new Scanner(file)){
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(getUsername()) && parts[1].equals(getPassword())) {
                    isTrue = true;
                    break;
                }
            }
        }

        return isTrue;
    }


    /**
     *
     * @param context
     */


    public void loadRoles(Context context) {
        AssetManager manager = context.getAssets();

        InputStream file;
        try {
            file = manager.open("data/users.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(Scanner scanner = new Scanner(file)){
            int i = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(getUsername()) && parts[1].equals(getPassword())) {
                    setRealName(parts[2]);
                    ArrayList<Role> role = new ArrayList<>();
                    // System.out.print(parts[3] + " ");
                    for (i = 3; i < parts.length; ++i) {
                        role.add(new Role(parts[i]));
                    }
                    setRoles(role);
                    break;
                }
            }
        }

    }

}

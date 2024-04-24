package edu.utsa.cs3442.mas273_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an Act which contains multiple scenes from a script.
 * An Act is characterized by its number and a collection of scenes.
 */
public class Act {
    private int actNumber;
    private ArrayList<Scene> scenes;

    /**
     * Constructs an Act with a specified number and list of scenes
     * @param actNumber
     * @param scenes
     */

    public Act(int actNumber, ArrayList<Scene> scenes){
        this.actNumber = actNumber;
        this.scenes = scenes;
    }

    /**
     * Return the act number
     * @return the act number
     */

    public int getActNumber() {
        return actNumber;
    }

    /**
     * Sets the number to a specified value
     * @param actNumber
     */
    public void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    /**
     * Returns the list of scenes in the act
     * @return the ArrayList of scenes
     */
    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    /**
     * Sets the scenes of the act
     *
     * @param scenes an ArrayList of Scene objects to set as the act's scenes
     */
    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }

    /**
     * Load scenes from a file named "act1.txt" that match a specific role name.
     * Scenes are added to] the current Act object's scene list if they include the specified name.
     * @param context
     * @param name
     * @throws IOException
     */

    public void loadScenesActOne(Context context, String name) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open("acts" + "/" + "act1.txt");
        Scanner scanner = new Scanner(file);
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",|\"|:|-");
                int id = Integer.parseInt(parts[0].trim());
                ArrayList<Role> roles = new ArrayList<>();

                boolean includeScene = false;
                for (int i = 2; i < parts.length; i++) {
                    roles.add(new Role(parts[i].trim()));
                    if (parts[i].trim().equals(name)) {
                        includeScene = true;
                    }
                }

                if (includeScene) {
                    scenes.add(new Scene(id, roles));
                }
            }
        } finally {
            scanner.close();
        }
    }

    /**
     * Load scenes from a file named "act2.txt" that match a specified role name.
     * Scenes are added to the current Act objeect's scenes list if they include the specified name.
     * @param context
     * @param name
     * @throws IOException
     */
    public void loadScenesActTwo(Context context, String name) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open("acts" + "/" + "act2.txt");
        Scanner scanner = new Scanner(file);
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",|\"|:|-");
                int id = Integer.parseInt(parts[0].trim());
                ArrayList<Role> roles = new ArrayList<>();

                boolean includeScene = false;
                for (int i = 2; i < parts.length; i++) {
                    roles.add(new Role(parts[i].trim()));
                    if (parts[i].trim().equals(name)) {
                        includeScene = true;
                    }
                }

                if (includeScene) {
                    scenes.add(new Scene(id, roles));
                }
            }
        } finally {
            scanner.close();
        }
    }

}

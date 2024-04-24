package edu.utsa.cs3442.mas273_lab5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import edu.utsa.cs3442.mas273_lab5.databinding.FragmentActBinding;
import edu.utsa.cs3442.mas273_lab5.model.Act;
import edu.utsa.cs3442.mas273_lab5.model.Role;
import edu.utsa.cs3442.mas273_lab5.model.Scene;
import edu.utsa.cs3442.mas273_lab5.model.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * create an instance of this fragment.
 */
public class ActFragment extends Fragment {

    private FragmentActBinding binding;

    /**
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentActBinding.inflate(inflater, container, false);
        Bundle args = getArguments();
        String username = null;
        String password = null;
        String actNumber = null;
        if (args != null) {
            username = args.getString("username", "username");
            password = args.getString("passphrase", "password");
            actNumber = args.getString("act", "1");
        }

        User user = new User(username, password, "", new ArrayList<Role>());

        user.loadRoles(requireActivity());
        ArrayList<Role> roles = new ArrayList<Role>();

        if( username.equals("miranda")){
            roles.add(new Role("Hamilton"));//good
        }
        else if( username.equals("soo")){
            roles.add(new Role("Eliza"));//good
        }
        else if( username.equals("goldsberry")){
            roles.add(new Role("Angelica"));//good
        }
        else if( username.equals("odom")){
            roles.add(new Role("Burr"));//good
        }
        else if( username.equals("jackson")){
            roles.add(new Role("Washington"));//good
        }
        else if( username.equals("diggs")){
            roles.add(new Role("Lafayette"));//good
            roles.add(new Role("Jefferson"));//good
        }
        else if( username.equals("onaodowan")){
            roles.add(new Role("Mulligan"));//good
            roles.add(new Role("Madison"));//good
        }
        else if( username.equals("ramos")){
            roles.add(new Role("Laurens"));//good
            roles.add(new Role("Philip"));//Philip
        }
        else if( username.equals("jones")){
            roles.add(new Role("Peggy"));//good
            roles.add(new Role("Maria Reynolds"));//good
        }
        else if( username.equals("groff")){
            roles.add(new Role("King George III"));//good
        }
        else if( username.equals("jasperson")){
            roles.add(new Role("Seabury"));//good
        }
        else if( username.equals("rua")){
            roles.add(new Role("Lee"));//good
        }
        else if( username.equals("sykes")){
            roles.add(new Role("Eacker"));//good
        }

        user.setRoles(roles);

        Act act = new Act(Integer.parseInt(actNumber), new ArrayList<Scene>());
        int i = 0;
        try {
            if( Integer.parseInt(actNumber) == 1) {
                binding.textViewAct.setText("Act 1");
                for( i = 0; i < roles.size(); ++i) {
                    act.loadScenesActOne(requireActivity(), roles.get(i).getNameOfCharacter());
                }
            }
            else if( Integer.parseInt(actNumber) == 2){
                binding.textViewAct.setText("Act 2");
                for( i = 0; i < roles.size(); ++i) {
                    act.loadScenesActTwo(requireActivity(), roles.get(i).getNameOfCharacter());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if( act.getScenes().size() == 0){
            binding.textViewOne.setText("No scenes in this Act");
        }

        int counter = 1;
        for( Scene scene: act.getScenes()){
            String scenes = scene.toString();

            if( counter == 1){
                binding.textViewOne.setText(scenes);
            }
            else if( counter == 2){
                binding.textViewTwo.setText(scenes);
            }
            else if( counter == 3){
                binding.textViewThree.setText(scenes);
            }
            else if( counter == 4){
                binding.textViewFour.setText(scenes);
            }
            else if( counter == 5){
                binding.textViewFive.setText(scenes);
            }
            else if( counter == 6){
                binding.textViewSix.setText(scenes);
            }
            else if( counter == 7){
                binding.textViewSeven.setText(scenes);
            }
            else if( counter == 8){
                binding.textViewEight.setText(scenes);
            }
            else if( counter == 9){
                binding.textViewNine.setText(scenes);
            }
            else if( counter == 10){
                binding.textViewTen.setText(scenes);
            }
            else if( counter == 11){
                binding.textViewEleven.setText(scenes);
            }
            else if( counter == 12){
                binding.textViewTwelve.setText(scenes);
            }
            else if( counter == 13){
                binding.textViewThirteen.setText(scenes);
            }
            else if( counter == 14){
                binding.textViewFourteen.setText(scenes);
            }
            else if( counter == 15){
                binding.textViewFifteen.setText(scenes);
            }
            else if( counter == 16){
                binding.textViewSixteen.setText(scenes);
            }
            else if( counter == 17){
                binding.textViewSeventeen.setText(scenes);
            }
            else if( counter == 18){
                binding.textViewEighteen.setText(scenes);
            }
            else if( counter == 19){
                binding.textViewNineteen.setText(scenes);
            }
            else if( counter == 20){
                binding.textViewTwenty.setText(scenes);
            }
            else if( counter == 21){
                binding.textViewTwentyone.setText(scenes);
            }
            else if( counter == 22){
                binding.textViewTwentytwo.setText(scenes);
            }
            else if( counter == 23){
                binding.textViewTwentythree.setText(scenes);
            }
            else if( counter == 24){
                binding.textViewTwentyfour.setText(scenes);
            }
            counter = counter + 1;

        }

        return binding.getRoot();
    }
}

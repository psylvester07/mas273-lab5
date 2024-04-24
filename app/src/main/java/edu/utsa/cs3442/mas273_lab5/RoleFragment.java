package edu.utsa.cs3442.mas273_lab5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.utsa.cs3442.mas273_lab5.databinding.FragmentRoleBinding;
import edu.utsa.cs3442.mas273_lab5.model.Role;
import edu.utsa.cs3442.mas273_lab5.model.User;

import java.util.ArrayList;

/**
 * A Fragment that displays the roles associated with a logged-in user and offers navigation options to different acts
 * of a play based on those roles. It also provides a logout mechanism to return to the login screen.
 */


public class RoleFragment extends Fragment {
    private FragmentRoleBinding binding;
    private FragmentManager fragmentManager;

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
        // Inflate the layout for this fragment
        binding = FragmentRoleBinding.inflate(inflater, container, false);

        Bundle args = getArguments();
        String username = null;
        String password = null;
        if (args != null) {
            username = args.getString("username", "username");
            password = args.getString("passphrase", "password");
        }



        User user = new User(username, password, "", new ArrayList<Role>());
        user.loadRoles(requireActivity());

        ActFragment actFragment = new ActFragment();
        Bundle argToSend = new Bundle();

        actFragment.setArguments(argToSend);

        argToSend.putString("username", username);
        argToSend.putString("passphrase", password);

        binding.textViewRealName.setText(user.getRealName());
        binding.textViewRoleNames.setText(user.getRoles().get(0).getNameOfCharacter());
        if(user.getRoles().size() > 1){
            binding.textViewRoleNameTwo.setText(user.getRoles().get(1).getNameOfCharacter());
        }


        binding.buttonAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                argToSend.putString("act", "1");
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, actFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)//Name can be null
                        .commit();
            }
        });

        binding.buttonAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                argToSend.putString("act", "2");
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, actFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)//Name can be null
                        .commit();
            }
        });

        binding.buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, MainFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)//Name can be null
                        .commit();
            }
        });

        return binding.getRoot();
    }
}

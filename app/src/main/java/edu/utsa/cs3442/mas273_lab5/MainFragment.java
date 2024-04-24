package edu.utsa.cs3442.mas273_lab5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import edu.utsa.cs3442.mas273_lab5.databinding.FragmentMainBinding;
import edu.utsa.cs3442.mas273_lab5.model.Role;
import edu.utsa.cs3442.mas273_lab5.model.User;

import java.util.ArrayList;
import java.util.Objects;

/**
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private String username;
    private String passphrase;
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

        fragmentManager = getParentFragmentManager();
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RoleFragment roleFragment = new RoleFragment();
        Bundle args = new Bundle();


        binding.editTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                username = s.toString().trim();


            }
        });

        binding.editTextPassphrase.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                passphrase = s.toString().trim();

            }
        });




        roleFragment.setArguments(args);

        binding.buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Role> roles = new ArrayList<Role>();
                User newUser = new User(username, passphrase, "", roles);
                newUser.loadRoles(requireActivity());
                boolean isTrue = newUser.verifyName(requireActivity());
                if( isTrue) {
                    args.putString("username", username);
                    args.putString("passphrase", passphrase);
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, roleFragment, null)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();
                }
                else{
                    Toast.makeText(requireActivity(), "Username or Passphrase was not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
package com.example.melearn.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.melearn.MainActivity;
import com.example.melearn.R;

public class AddFragment extends Fragment {
    String deckName;
    String deckDescription;
    private EditText deckNameInput;
    private EditText deckDescriptionInput;
    private Button buttonAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        buttonAdd = view.findViewById(R.id.btnAdd);
        deckNameInput = view.findViewById(R.id.edTxtName);
        deckDescriptionInput = view.findViewById(R.id.edTxtDescription);
        buttonAdd.setOnClickListener(v -> {
            MainActivity.user.addDeck(deckNameInput.getText().toString(),
                    deckDescriptionInput.getText().toString());
            Fragment deckFragment = new DeckFragment(MainActivity.user.getDecks().get(MainActivity.user.getDecks().size()-1));

            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, deckFragment);
            fragmentTransaction.commit();
        });

        return view;
    }
}

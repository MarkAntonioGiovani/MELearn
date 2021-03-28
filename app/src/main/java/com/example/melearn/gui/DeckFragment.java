package com.example.melearn.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.melearn.R;
import com.example.melearn.MainActivity;
import com.example.melearn.logic.Deck;

public class DeckFragment extends Fragment {
    MainActivity.user.getDecks().get()
    private String name;
    private Deck deck;
    private TextView txtVwHeader;
    private Button btnAddCard;

    public DeckFragment(Deck deck) {
        this.name = deck.getName();
        this.deck = deck;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deck, container, false);
        txtVwHeader = (TextView) view.findViewById(R.id.txtVwHeader);
        txtVwHeader.setText(this.name);
        btnAddCard = (Button) view.findViewById(R.id.btnAdd);
        btnAddCard.setOnClickListener(createCard(view));
        return view;
    }

    private View.OnClickListener createCard(View view) {

        return null;
    }
}
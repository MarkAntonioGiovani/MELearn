package com.example.melearn.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.melearn.MainActivity;
import com.example.melearn.R;
import com.example.melearn.logic.Deck;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;

public class MyDecksFragment extends Fragment {
    ArrayList<Deck> decks;
    ListView listView;
    int id = -1;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        decks.addAll(Arrays.asList(new Deck("Deck1", "Desc1"), new Deck("Deck2", "Desc2")));
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Decks")
                .whereEqualTo("UserID", "Wq8GhFT7dM2iAQZibEsi")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                System.out.println(document.getId() + " => " + document.getData());
                            }
                        } else {
                            System.out.println("Error getting documents: " + task.getException());
                        }
                    }
                });
        this.view = inflater.inflate(R.layout.fragment_my_decks, container, false);
        int i = 0;
        while (i < MainActivity.user.getDecks().size()) {
            showDeckButton(MainActivity.user.getDecks().get(i));
            i++;
        }
        return this.view;
    }

    private void showDeckButton(Deck deck) {
        LinearLayout ll = (LinearLayout) this.view.findViewById(R.id.deck_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 20, 0, 0);
        Button deckButton = new Button(this.getContext());
        deckButton.setTextColor(getResources().getColor(R.color.white));
        deckButton.setText(deck.getName());
        deckButton.setHeight(120);
        deckButton.setBackgroundColor(getResources().getColor(R.color.dark_blue));
        deckButton.setId(MainActivity.user.getDecks().indexOf(deck));
        id = deckButton.getId();
        deckButton.setOnClickListener(openDeck(deckButton));
        deckButton.setLayoutParams(layoutParams);
        ll.addView(deckButton);
    }

    private View.OnClickListener openDeck(Button btn){
    System.out.println(btn.getId());
        return null;
    }
}

package fr.gorelpaul.bacsable;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.transitionseverywhere.ChangeText;


public class TextAnimation extends Fragment {

    private Boolean isSecondText = false;
    private String TEXT_1 = "Bonjour peux tu me tapper dessus ?";
    private String TEXT_2 = "MERCI ! (Tu peux continuer ;))";
    public TextAnimation() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_text_animation, container, false);
        final ViewGroup transitionsContainer = v.findViewById(R.id.frameLayout);
        final TextView taptext = transitionsContainer.findViewById(R.id.tapText);

        taptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer,
                        new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
                taptext.setText(isSecondText ? TEXT_2 : TEXT_1);
            }
        });
        return v;
    }


}

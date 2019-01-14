package fr.gorelpaul.bacsable;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnimationPOC.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AnimationPOC extends Fragment {

    public AnimationPOC() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_animation_poc, container, false);
        final ViewGroup transitionContainer = v.findViewById(R.id.transitionContainer);

        Button button = v.findViewById(R.id.buttonanimate);
        final TextView textView = transitionContainer.findViewById(R.id.textanimate);
        final LottieAnimationView lottie = transitionContainer.findViewById(R.id.animation_view);

        button.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionContainer);
                visible = !visible;
                textView.setVisibility(visible ? View.VISIBLE : View.GONE);
                lottie.setVisibility(visible ? View.VISIBLE : View.GONE);
                transitionContainer.setBackgroundColor(visible ? Color.parseColor("#56FE3A") : Color.parseColor("#FFFFFF"));
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    interface OnFragmentInteractionListener {
    }
}

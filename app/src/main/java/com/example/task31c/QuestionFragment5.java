package com.example.task31c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionFragment5 extends Fragment {


    private RadioGroup optionsGroup;
    private int correctAnswerId;
    private QuestionAnsweredListener listener;
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QuestionAnsweredListener) {
            listener = (QuestionAnsweredListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement QuestionAnsweredListener");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question5, container, false);
        optionsGroup = view.findViewById(R.id.optionsGroup);
        correctAnswerId = R.id.option2;

        optionsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                resetOptionsBackground();

                RadioButton checkedRadioButton = group.findViewById(checkedId);



                if (checkedId == correctAnswerId) {
                    // Correct Answer
                    checkedRadioButton.setBackgroundResource(R.drawable.rounded_button_right);
                    checkedRadioButton.setChecked(true); // This will trigger the selector and apply the correct style
                } else {
                    // Wrong Answer

                    checkedRadioButton.setBackgroundResource(R.drawable.rounded_button_wrong);
                    checkedRadioButton.setChecked(true);
                    RadioButton correctRadioButton = group.findViewById(correctAnswerId);
                    correctRadioButton.setBackgroundResource(R.drawable.rounded_button_right);

                }
                boolean isCorrect = checkedId == R.id.option2;
                listener.onQuestionAnswered(isCorrect);
            }
        });
        return view;
    }

    private void resetOptionsBackground() {

        for (int i = 0; i < optionsGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) optionsGroup.getChildAt(i);
            radioButton.setBackgroundResource(R.drawable.rounded_button_default);

        }
    }
}
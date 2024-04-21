package com.example.task31c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private int correctAnswers=0;
    private String userName;

    public static ResultFragment newInstance(int correctAnswers, String userName) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt("correctAnswers", correctAnswers);
        args.putString("userName", userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        Button btnFinish = view.findViewById(R.id.btnFinish);
        Button btnTakeNewQuiz = view.findViewById(R.id.btnTakeNewQuiz);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();  // 关闭应用
            }
        });

        btnTakeNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                if (activity != null) {
                    activity.resetQuiz();
                }
            }
        });

        TextView resultTextView = view.findViewById(R.id.resultTextView);
        int correctAnswers = getArguments().getInt("correctAnswers", 0);
        String userName = getArguments().getString("userName", "");
        resultTextView.setText("Congratulations " + userName + "，Your scroe " + correctAnswers + "/5！");
        return view;
    }
}
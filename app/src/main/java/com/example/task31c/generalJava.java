package com.example.task31c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class generalJava {

//    package com.example.task31c;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager2.widget.ViewPager2;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//    public class MainActivity extends AppCompatActivity implements QuestionAnsweredListener {
//
//        private ProgressBar progressBar;
//        private ViewPager2 viewPager;
//        private EditText editTextUserName;
//        private int currentProgress = 20; // 初始化进度条进度
//        private int correctAnswers = 0;
//        private String userName;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//            Button nextButton = findViewById(R.id.nextButton);
//            Button prevButton = findViewById(R.id.prevButton);
//            viewPager = findViewById(R.id.viewPager);
//            progressBar = findViewById(R.id.progressBar);
//            editTextUserName = findViewById(R.id.editTextUserName);
//            TextView userNameTextView = findViewById(R.id.userNameTextView);
//
//            viewPager.setVisibility(View.GONE);
//            progressBar.setVisibility(View.GONE);
//
//            Button buttonStart = findViewById(R.id.buttonStart);
//            buttonStart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    userName = editTextUserName.getText().toString();
//                    if (!userName.isEmpty()) {
//                        editTextUserName.setVisibility(View.GONE);
//                        buttonStart.setVisibility(View.GONE);
//                        viewPager.setVisibility(View.VISIBLE);
//                        progressBar.setVisibility(View.VISIBLE);
//                        prevButton.setVisibility(View.VISIBLE);
//                        nextButton.setVisibility(View.VISIBLE);
//
//                        userNameTextView.setText("Login User:"+userName);
//
//                        viewPager.setAdapter(new QuestionPagerAdapter(com.example.task31c.MainActivity.this));
//                    } else {
//                        editTextUserName.setError("Please enter your name");
//                    }
//                }
//
//            });
//
//
//
//            prevButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int currentItem = viewPager.getCurrentItem();
//
//                    if (currentItem > 0) {
//
//                        viewPager.setCurrentItem(currentItem - 1, true);
//                        currentProgress -= 20;
//                        progressBar.setProgress(currentProgress);
//
//                    } else {
//
//                    }
//                }
//            });
//            nextButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int currentItem = viewPager.getCurrentItem();
//                    int itemCount = viewPager.getAdapter().getItemCount();
//                    if (currentItem < itemCount - 1) {
//                        viewPager.setCurrentItem(currentItem + 1, true);
//                        currentProgress += 20;
//                        progressBar.setProgress(currentProgress);
//                        if (currentItem + 1 == itemCount - 1) {
//                            prevButton.setVisibility(View.GONE);
//                            nextButton.setVisibility(View.GONE);
//                        }
//                    }
//
//                }
//            });
//        }
//        public void onQuestionAnswered(boolean isCorrect) {
//            if (isCorrect) {
//                ++correctAnswers;
//            }
//        }
//
//        public int getCorrectAnswers() {
//            return correctAnswers;
//        }
//
//        public String getUserName() {
//            return userName;
//        }
//        public void resetQuiz() {
//
//            correctAnswers = 0;
//            currentProgress = 20; // 如果需要，将进度重置到初始值
//
//
//            editTextUserName.setText("");
//            editTextUserName.setVisibility(View.VISIBLE);
//
//
//            progressBar.setProgress(0);
//            progressBar.setVisibility(View.GONE); // 如果需要再次显示，这里应设为View.VISIBLE
//
//
//            Button buttonStart = findViewById(R.id.buttonStart);
//            buttonStart.setVisibility(View.VISIBLE);
//            TextView userNameTextView = findViewById(R.id.userNameTextView);
//            userNameTextView.setText("");
//
//
//            if (viewPager.getAdapter() != null) {
//                viewPager.setAdapter(new QuestionPagerAdapter(this));
//            }
//            viewPager.setCurrentItem(0);
//            viewPager.setVisibility(View.GONE);
//
//
//            Button prevButton = findViewById(R.id.prevButton);
//            Button nextButton = findViewById(R.id.nextButton);
//            prevButton.setVisibility(View.GONE);
//            nextButton.setVisibility(View.GONE);
//
//        }
//
//    }


///////QuetionFragment1 As an example
//    public class QuestionFragment1 extends Fragment {
//
//        private RadioGroup optionsGroup;
//        private int correctAnswerId;
//        private QuestionAnsweredListener listener;
//        public void onAttach(@NonNull Context context) {
//            super.onAttach(context);
//            if (context instanceof QuestionAnsweredListener) {
//                listener = (QuestionAnsweredListener) context;
//            } else {
//                throw new RuntimeException(context.toString() + " must implement QuestionAnsweredListener");
//            }
//        }
//
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            View view = inflater.inflate(R.layout.fragment_question1, container, false);
//            optionsGroup = view.findViewById(R.id.optionsGroup);
//            correctAnswerId = R.id.option3;
//
//            optionsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                    resetOptionsBackground();
//
//                    RadioButton checkedRadioButton = group.findViewById(checkedId);
//
//
//
//                    if (checkedId == correctAnswerId) {
//                        // Correct Answer
//                        checkedRadioButton.setBackgroundResource(R.drawable.rounded_button_right);
//                        checkedRadioButton.setChecked(true); // This will trigger the selector and apply the correct style
//                    } else {
//                        // Wrong Answer
//
//                        checkedRadioButton.setBackgroundResource(R.drawable.rounded_button_wrong);
//                        checkedRadioButton.setChecked(true);
//                        RadioButton correctRadioButton = group.findViewById(correctAnswerId);
//                        correctRadioButton.setBackgroundResource(R.drawable.rounded_button_right);
//
//                    }
//                    boolean isCorrect = checkedId == R.id.option3;
//                    listener.onQuestionAnswered(isCorrect);
//                }
//            });
//            return view;
//        }
//
//        private void resetOptionsBackground() {
//
//            for (int i = 0; i < optionsGroup.getChildCount(); i++) {
//                RadioButton radioButton = (RadioButton) optionsGroup.getChildAt(i);
//                radioButton.setBackgroundResource(R.drawable.rounded_button_default);
//
//            }
//        }
//    }
//public class QuestionPagerAdapter extends FragmentStateAdapter {
//    private final FragmentActivity fragmentActivity;
//    public QuestionPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//        this.fragmentActivity = fragmentActivity;
//    }
//
//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//
//        switch (position) {
//            case 0:
//                return new QuestionFragment1();
//            case 1:
//                return new QuestionFragment2();
//            case 2:
//                return new QuestionFragment3();
//            case 3:
//                return new QuestionFragment4();
//            case 4:
//                return new QuestionFragment5();
//            case 5:
//            {
//                MainActivity activity = (MainActivity) fragmentActivity;
//                return ResultFragment.newInstance(activity.getCorrectAnswers(), activity.getUserName());}
//            default:
//                return new QuestionFragment1();
//        }
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return 6;

}
//


//public class ResultFragment extends Fragment {
//
//    private int correctAnswers=0;
//    private String userName;
//
//    public static ResultFragment newInstance(int correctAnswers, String userName) {
//        ResultFragment fragment = new ResultFragment();
//        Bundle args = new Bundle();
//        args.putInt("correctAnswers", correctAnswers);
//        args.putString("userName", userName);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_result, container, false);
//
//        Button btnFinish = view.findViewById(R.id.btnFinish);
//        Button btnTakeNewQuiz = view.findViewById(R.id.btnTakeNewQuiz);
//
//        btnFinish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().finish();  // 关闭应用
//            }
//        });
//
//        btnTakeNewQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity activity = (MainActivity) getActivity();
//                if (activity != null) {
//                    activity.resetQuiz();
//                }
//            }
//        });
//
//        TextView resultTextView = view.findViewById(R.id.resultTextView);
//        int correctAnswers = getArguments().getInt("correctAnswers", 0);
//        String userName = getArguments().getString("userName", "");
//        resultTextView.setText("Congratulations " + userName + "，Your scroe " + correctAnswers + "/5！");
//        return view;
//    }
//}


package com.example.task31c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements QuestionAnsweredListener {

    private ProgressBar progressBar;
    private ViewPager2 viewPager;
    private EditText editTextUserName;
    private int currentProgress = 20; // 初始化进度条进度
    private int correctAnswers = 0;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextButton = findViewById(R.id.nextButton);
        Button prevButton = findViewById(R.id.prevButton);
        viewPager = findViewById(R.id.viewPager);
        progressBar = findViewById(R.id.progressBar);
        editTextUserName = findViewById(R.id.editTextUserName);
        TextView userNameTextView = findViewById(R.id.userNameTextView);
        // 默认情况下隐藏问卷和进度条
        viewPager.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               userName = editTextUserName.getText().toString();
                if (!userName.isEmpty()) {
                    editTextUserName.setVisibility(View.GONE);
                    buttonStart.setVisibility(View.GONE);
                    viewPager.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    prevButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.VISIBLE);

                    userNameTextView.setText("Login User:"+userName);
                    // 确保这里传递的参数与 QuestionPagerAdapter 的构造函数匹配
                    viewPager.setAdapter(new QuestionPagerAdapter(MainActivity.this));
                } else {
                    editTextUserName.setError("Please enter your name");
                }
            }

        });



        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                // 检查是否是第一页
                if (currentItem > 0) {
                    // 不是第一页，移动到前一页
                    viewPager.setCurrentItem(currentItem - 1, true);
                    currentProgress -= 20; // 递减进度
                    progressBar.setProgress(currentProgress); // 更新进度条

                } else {
                    // 是第一页，不能再返回，可以考虑禁用按钮或者执行其他逻辑
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                int itemCount = viewPager.getAdapter().getItemCount();
                if (currentItem < itemCount - 1) {
                    viewPager.setCurrentItem(currentItem + 1, true);
                    currentProgress += 20; // 更新进度条进度
                    progressBar.setProgress(currentProgress);
                    if (currentItem + 1 == itemCount - 1) {
                        // 当跳转到结果页面前的最后一个问题
                        prevButton.setVisibility(View.GONE);
                        nextButton.setVisibility(View.GONE);
                    }
                }

            }
        });
    }
    public void onQuestionAnswered(boolean isCorrect) {
        if (isCorrect) {
            correctAnswers++;
        }
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public String getUserName() {
        return userName;
    }
    public void resetQuiz() {
        // 重置计分和进度
        correctAnswers = 0;
        currentProgress = 20; // 如果需要，将进度重置到初始值

        // 重置用户名输入
        editTextUserName.setText("");
        editTextUserName.setVisibility(View.VISIBLE);

        // 重置进度条
        progressBar.setProgress(0);
        progressBar.setVisibility(View.GONE); // 如果需要再次显示，这里应设为View.VISIBLE

        // 重置按钮和文本
        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setVisibility(View.VISIBLE);
        TextView userNameTextView = findViewById(R.id.userNameTextView);
        userNameTextView.setText("");

        // 重置 ViewPager 到第一页
        if (viewPager.getAdapter() != null) {
            viewPager.setAdapter(new QuestionPagerAdapter(this));
        }
        viewPager.setCurrentItem(0);
        viewPager.setVisibility(View.GONE);

        // 显示开始界面的元素
        Button prevButton = findViewById(R.id.prevButton);
        Button nextButton = findViewById(R.id.nextButton);
        prevButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

    }

}

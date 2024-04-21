package com.example.task31c;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class QuestionPagerAdapter extends FragmentStateAdapter {
    private final FragmentActivity fragmentActivity;
    public QuestionPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

            switch (position) {
                case 0:
                    return new QuestionFragment1();
                case 1:
                    return new QuestionFragment2();
                case 2:
                    return new QuestionFragment3();
                case 3:
                    return new QuestionFragment4();
                case 4:
                    return new QuestionFragment5();
                case 5:
                {
                    MainActivity activity = (MainActivity) fragmentActivity;
                    return ResultFragment.newInstance(activity.getCorrectAnswers(), activity.getUserName());}
                default:
                    return new QuestionFragment1();
            }
        }



    @Override
    public int getItemCount() {
        return 6;
    }
}

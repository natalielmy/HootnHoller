package com.firstapp.hootnholler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.firstapp.hootnholler.databinding.ActivityStudentMainBinding;

public class Student_MainActivity extends AppCompatActivity {
    ActivityStudentMainBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStudentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BottomNavigationView.setOnItemReselectedListener(item -> {
            int id = item.getItemId();
            if (id==R.id.home) {
                replaceFragment(new Student_Classroom_Fragment());}
            else if (id == R.id.quiz) {
                replaceFragment(new Student_Quiz_Fragment());
            }else if (id == R.id.chat) {
                replaceFragment(new Student_Chat_Fragment());
            }else if (id == R.id.profile) {
                replaceFragment(new Student_Profile_Fragment());}

        });


    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();

    }


}
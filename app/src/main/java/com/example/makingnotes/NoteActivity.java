package com.example.makingnotes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// Эта activity для показа заметки в портретной ориентации
public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
            finish();
            return;
        }
        if (savedInstanceState == null) {
            // Если эта activity запускается первый раз
            // то перенаправим параметр фрагменту
            NoteBlankFragment noteFragment = new NoteBlankFragment();
            noteFragment.setArguments(getIntent().getExtras());
            // Добавим фрагмент на activity
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, noteFragment).commit();
        }
    }
}
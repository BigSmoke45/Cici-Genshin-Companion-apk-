package com.example.myapplication4new;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class FourthActivityGuns extends AppCompatActivity {
    ArrayList<Artifacts> artifacts = new ArrayList<Artifacts>();
    private ArtifactsAdapter adapter;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    int boo = 0;

    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (boo == 0)
            stopService(new Intent(this, MyService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        boo = 0;
    }

    private void setInitialData() {
        artifacts.add(new Artifacts("Дорогоцінний вир", R.drawable.drag_omyt));
        artifacts.add(new Artifacts("Вовча загибель", R.drawable.volcia_pogib));
        artifacts.add(new Artifacts("Меч сокола", R.drawable.mech_sokola));
        artifacts.add(new Artifacts("Небесний меч", R.drawable.nebesn_mech));
        artifacts.add(new Artifacts("Небесний атлас", R.drawable.nebesn_atlas));
        artifacts.add(new Artifacts("Пісня мандрівника", R.drawable.pesn_str));
        artifacts.add(new Artifacts("Епос про драконоборців", R.drawable.epos_drakonob));
        artifacts.add(new Artifacts("Дворучний меч Фавонія", R.drawable.favoniydvyrych));
        artifacts.add(new Artifacts("Нефритовий коршун", R.drawable.nefritkorsh));
        artifacts.add(new Artifacts("Лук Амоса", R.drawable.lykamosa));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_artifacts);

        RecyclerView recyclerView = findViewById(R.id.listart);
        setInitialData();

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));

        boo = 0;
        setTitle("Зброя");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // створення об’єкта Intent для запуску SecondActivity
        Intent intentDet = new Intent(this, artifact_act_detail.class);

        ArtifactsAdapter.OnStateClickListener stateClickListener = new ArtifactsAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Artifacts state, int position) {
                switch (state.getName()) {
                    case "Дорогоцінний вир":
                        intentDet.putExtra("art", "Дорогоцінний вир");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Вовча загибель":
                        intentDet.putExtra("art", "Вовча загибель");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Меч сокола":
                        intentDet.putExtra("art", "Меч сокола");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Небесний меч":
                        intentDet.putExtra("art", "Небесний меч");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Небесний атлас":
                        intentDet.putExtra("art", "Небесний атлас");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Пісня мандрівника":
                        intentDet.putExtra("art", "Пісня мандрівника");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Лук Амоса":
                        intentDet.putExtra("art", "Лук Амоса");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Нефритовий коршун":
                        intentDet.putExtra("art", "Нефритовий коршун");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Дворучний меч Фавонія":
                        intentDet.putExtra("art", "Дворучний меч Фавонія");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Епос про драконоборців":
                        intentDet.putExtra("art", "Епос про драконоборців");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                }
            }
        };

        adapter = new ArtifactsAdapter(this, artifacts, stateClickListener);
        recyclerView.setAdapter(adapter);
    }
}


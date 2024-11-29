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
public class SecondActivityArtifacts extends AppCompatActivity {
    int boo = 0;
    protected void onUserLeaveHint()
    {
        super.onUserLeaveHint();
        if(boo == 0)
            stopService(new Intent(this, MyService.class));
    }
    @Override
    protected void onResume(){
        super.onResume();
        boo = 0;
    }
    ArrayList<Artifacts> artifacts = new ArrayList<Artifacts>();
    private ArtifactsAdapter adapter;
    private void setInitialData() {
        artifacts.add(new Artifacts("Горящая алая ведьма", R.drawable.alaya_vedma));
        artifacts.add(new Artifacts("Возлюбленная юная дева", R.drawable.vozlub_deva));
        artifacts.add(new Artifacts("Громогласный рёв ярости", R.drawable.grom_rev));
        artifacts.add(new Artifacts("Изумрудная тень", R.drawable.izumr_ten));
        artifacts.add(new Artifacts("Сердце глубин", R.drawable.serdce_glyb));
        artifacts.add(new Artifacts("Конец гладиатора", R.drawable.konec_glad));
        artifacts.add(new Artifacts("Церемония древней знати", R.drawable.cerem_znati));
        artifacts.add(new Artifacts("Странствующий ансамбль", R.drawable.stranstvansambl));
        artifacts.add(new Artifacts("Заблудший в метели", R.drawable.zablydmetel));
    }
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_artifacts);
        setTitle("Артефакты");
        ActionBar actionBar =getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        RecyclerView recyclerView = findViewById(R.id.listart);
        setInitialData();
        boo = 0;
        Intent intentDet = new Intent(this, artifact_act_detail.class);
        ArtifactsAdapter.OnStateClickListener stateClickListener = new ArtifactsAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Artifacts state, int position) {
                switch (state.getName()) {
                    case "Горящая алая ведьма":
                        intentDet.putExtra("art", "Горящая Алая Ведьма");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Возлюбленная юная дева":
                        intentDet.putExtra("art", "Возлюбленная юная дева");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Громогласный рёв ярости":
                        intentDet.putExtra("art", "Громогласный рёв ярости");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Изумрудная тень":
                        intentDet.putExtra("art", "Изумрудная тень");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Сердце глубин":
                        intentDet.putExtra("art", "Сердце глубин");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Конец гладиатора":
                        intentDet.putExtra("art", "Конец гладиатора");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Церемония древней знати":
                        intentDet.putExtra("art", "Церемония древней знати");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Странствующий ансамбль":
                        intentDet.putExtra("art", "Странствующий ансамбль");
                        boo = 1;
                        startActivity(intentDet);
                        break;
                    case "Заблудший в метели":
                        intentDet.putExtra("art", "Заблудший в метели");
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

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
artifacts.add(new Artifacts("Палаюча алая відьма", R.drawable.alaya_vedma));
artifacts.add(new Artifacts("Кохана юна дівчина", R.drawable.vozlub_deva));
artifacts.add(new Artifacts("Громовий рев люті", R.drawable.grom_rev));
artifacts.add(new Artifacts("Ізумрудна тінь", R.drawable.izumr_ten));
artifacts.add(new Artifacts("Серце глибин", R.drawable.serdce_glyb));
artifacts.add(new Artifacts("Кінець гладіатора", R.drawable.konec_glad));
artifacts.add(new Artifacts("Церемонія древньої знаті", R.drawable.cerem_znati));
artifacts.add(new Artifacts("Мандрівний ансамбль", R.drawable.stranstvansambl));
artifacts.add(new Artifacts("Загублений у заметілі", R.drawable.zablydmetel));

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
    case "Палаюча алая відьма":
        intentDet.putExtra("art", "Палаюча Алая Відьма");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Кохана юна дівчина":
        intentDet.putExtra("art", "Кохана юна дівчина");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Громовий рев люті":
        intentDet.putExtra("art", "Громовий рев люті");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Ізумрудна тінь":
        intentDet.putExtra("art", "Ізумрудна тінь");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Серце глибин":
        intentDet.putExtra("art", "Серце глибин");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Кінець гладіатора":
        intentDet.putExtra("art", "Кінець гладіатора");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Церемонія древньої знаті":
        intentDet.putExtra("art", "Церемонія древньої знаті");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Мандрівний ансамбль":
        intentDet.putExtra("art", "Мандрівний ансамбль");
        boo = 1;
        startActivity(intentDet);
        break;
    case "Загублений у заметілі":
        intentDet.putExtra("art", "Загублений у заметілі");
        boo = 1;
        startActivity(intentDet);
        break;
}

                }
            }
        };
        adapter = new ArtifactsAdapter(this, artifacts, stateClickListener);
        recyclerView.setAdapter(adapter);
    }
}

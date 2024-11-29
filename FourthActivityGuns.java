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
    private void setInitialData () {
        artifacts.add(new Artifacts("Драгоценный омут", R.drawable.drag_omyt));
        artifacts.add(new Artifacts("Волчья погибель", R.drawable.volcia_pogib));
        artifacts.add(new Artifacts("Меч сокола", R.drawable.mech_sokola));
        artifacts.add(new Artifacts("Небесный меч", R.drawable.nebesn_mech));
        artifacts.add(new Artifacts("Небесный атлас", R.drawable.nebesn_atlas));
        artifacts.add(new Artifacts("Песнь странника", R.drawable.pesn_str));
        artifacts.add(new Artifacts("Эпос о драконоборцах", R.drawable.epos_drakonob));
        artifacts.add(new Artifacts("Двуручный меч Фавония", R.drawable.favoniydvyrych));
        artifacts.add(new Artifacts("Нефритовый коршун", R.drawable.nefritkorsh));
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
            setTitle("Оружие");
            ActionBar actionBar =getSupportActionBar();
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            // создание объекта Intent для запуска SecondActivity
            Intent intentDet = new Intent(this, artifact_act_detail.class);
            ArtifactsAdapter.OnStateClickListener stateClickListener = new ArtifactsAdapter.OnStateClickListener() {
                @Override
                public void onStateClick(Artifacts state, int position) {
                    switch (state.getName()) {
                        case "Драгоценный омут":
                            intentDet.putExtra("art", "Драгоценный омут");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Волчья погибель":
                            intentDet.putExtra("art", "Волчья погибель");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Меч сокола":
                            intentDet.putExtra("art", "Меч сокола");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Небесный меч":
                            intentDet.putExtra("art", "Небесный меч");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Небесный атлас":
                            intentDet.putExtra("art", "Небесный атлас");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Песнь странника":
                            intentDet.putExtra("art", "Песнь странника");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Лук Амоса":
                            intentDet.putExtra("art", "Лук Амоса");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Нефритовый коршун":
                            intentDet.putExtra("art", "Нефритовый коршун");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Двуручный меч Фавония":
                            intentDet.putExtra("art", "Двуручный меч Фавония");
                            boo = 1;
                            startActivity(intentDet);
                            break;
                        case "Эпос о драконоборцах":
                            intentDet.putExtra("art", "Эпос о драконоборцах");
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

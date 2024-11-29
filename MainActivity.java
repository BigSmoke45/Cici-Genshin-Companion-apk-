package com.example.myapplication4new;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<Category> states = new ArrayList<Category>();
    public int boo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);
        Intent intent2 = new Intent(this, SecondActivityArtifacts.class);
        Intent intent3 = new Intent(this, ThirdActivityPersons.class);
        Intent intent4 = new Intent(this, FourthActivityGuns.class);
        Intent intent5 = new Intent(this, PaimonTesting.class);
        boo = 0;
        setInitialData();
        setTitle("Главная");
        Window window = MainActivity.this.getWindow();
window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        CategoryAdapter.OnStateClickListener stateClickListener = new CategoryAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Category state, int position) {
                switch (state.getName()) {
                    case "Артефакты":
                        boo = 2;
                        startActivity(intent2);
                        break;
                    case "Персонажи":
                        boo = 3;
                        startActivity(intent3);
                        break;
                    case "Оружие":
                        boo = 4;
                        startActivity(intent4);
                        break;
                    case "Пройти тест":
                        boo = 5;
                        startActivity(intent5);
                        break;
                }
            }
        };
        CategoryAdapter adapter = new CategoryAdapter(this, states, stateClickListener);
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){
        states.add(new Category ("Артефакты" , R.drawable.artifacttierlist));
        states.add(new Category ("Персонажи", R.drawable.charactertierlist));
        states.add(new Category ("Оружие", R.drawable.weapontierlist));
        states.add(new Category ("Пройти тест", R.drawable.testspai));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intentrazr = new Intent(this, Develop.class);
        Intent intentsait = new Intent(this, SaitActivity.class);
        int id = item.getItemId();
        //TextView headerView = findViewById(R.id.selectedMenuItem);
        switch(id){
            case R.id.razr:
                boo = 1;
                startActivity(intentrazr);
                //headerView.setText("Настройки");
                return true;
            case R.id.sait:
                boo = 1;
                startActivity(intentsait);
                return true;
            case R.id.exit:
                stopService(new Intent(this, MyService.class));
                finish();
                //headerView.setText("Открыть");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void play(View view) {
        startService(new Intent(this, MyService.class));
    }

    public void stop(View view) {
        stopService(new Intent(this, MyService.class));
    }
    public void onBackPressed() {
        finish();
        stopService(new Intent(this, MyService.class));
    }
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
}


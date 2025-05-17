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
public class ThirdActivityPersons extends AppCompatActivity {
    ArrayList<Persons> states = new ArrayList<Persons>();
    private PersonsAdapter adapter;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Персонажи");
        setContentView(R.layout.third_activity_persons);
        RecyclerView recyclerView = findViewById(R.id.list3);
        setInitialData();
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        Intent intentDet = new Intent(this, PersonActDetail.class);
        PersonsAdapter.OnStateClickListener stateClickListener = new PersonsAdapter.OnStateClickListener() {
            @Override
          public void onStateClick(Persons state, int position) {
    boo = 0;
    switch (state.getName()) {
        case "Ділюк":
            boo = 1;
            intentDet.putExtra("pers", "Ділюк");
            startActivity(intentDet);
            break;
        case "Джинн":
            boo = 1;
            intentDet.putExtra("pers", "Джинн");
            startActivity(intentDet);
            break;
        case "Ке Цін":
            intentDet.putExtra("pers", "Ке Цін");
            boo = 1;
            startActivity(intentDet);
            break;
        case "Мона":
            intentDet.putExtra("pers", "Мона");
            boo = 1;
            startActivity(intentDet);
            break;
        case "Ці-ці":
            intentDet.putExtra("pers", "Ці-ці");
            boo = 1;
            startActivity(intentDet);
            break;
        case "Сяо":
            intentDet.putExtra("pers", "Сяо");
            boo = 1;
            startActivity(intentDet);
            break;
        case "Гань Юй":
            intentDet.putExtra("pers", "Гань Юй");
            boo = 1;
            startActivity(intentDet);
            break;
        case "Розарія":
            intentDet.putExtra("pers", "Розарія");
            boo = 1;
            startActivity(intentDet);
            break;
        case "Саю":
            intentDet.putExtra("pers", "Саю");
            boo = 1;
            startActivity(intentDet);
            break;
    }
}

        };
        adapter = new PersonsAdapter(this, states, stateClickListener);
        recyclerView.setAdapter(adapter);
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
    private void setInitialData(){
        states.add(new Persons ("Дилюк" ,"Двуручный меч","Пиро" , R.drawable.diluc));
        states.add(new Persons ("Джинн", "Меч","Анемо" , R.drawable.jean));
        states.add(new Persons ("Кэ Цин", "Меч","Электро" , R.drawable.keqing));
        states.add(new Persons ("Мона", "Катализатор","Гидро" , R.drawable.mona));
        states.add(new Persons ("Ци-ци","Меч","Крио" , R.drawable.qiqi));
        states.add(new Persons ("Сяо" ,"Копьё","Анемо" , R.drawable.xiaopng));
        states.add(new Persons ("Гань Юй", "Лук","Крио" , R.drawable.ganyupng));
        states.add(new Persons ("Розария", "Копьё","Крио" , R.drawable.rosariapng));
        states.add(new Persons ("Саю", "Двуручный меч","Анемо" , R.drawable.sayupng));
    }
}


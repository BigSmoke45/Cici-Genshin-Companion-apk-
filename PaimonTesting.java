package com.example.myapplication4new;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class PaimonTesting extends AppCompatActivity {
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
    public void onBackPressed() {
        super.onBackPressed();
        boo = 1;
    }
String[] questioins = {"Яке Око Бога у Мони?",
        "Кого називають \"Нефритова Рівновага Групи Цисін\"?",
        "Учениця і збирачка трав з хижі Бубу - це?..",
        "З якого регіону Мона?",
        "Якою зброєю користується Джинн?",
        "Яке Око Бога у Ділюка?"};
String[] answers = { "Анемо", "Піро", "Електро", "Гідро",
        "Ке Цін", "Мона", "Ці-ці", "Ембер",
        "Ділюк", "Ці-ці", "Мона", "Розарія",
        "Розлом", "Інадзума", "Лі Юе", "Монштадт",
        "Лук", "Каталізатор", "Меч", "Двосічний меч",
        "Гідро", "Піро", "Електро", "Дендро"};
String[] TrueAnswers = { "Гідро", "Ке Цін", "Ці-ці", "Монштадт", "Меч", "Піро"};
public int iter = 0;

    public int iter2 = 0;
    boolean bool = false;
    public int rez = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paimon_testing);
        setTitle("Тест");
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Window window = this.getWindow();
window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        RadioButton radioButton1 = findViewById(R.id.rbfirst);
        RadioButton radioButton2 = findViewById(R.id.rbtwo);
        RadioButton radioButton3 = findViewById(R.id.rbthree);
        RadioButton radioButton4 = findViewById(R.id.rbfour);
        TextView selection = findViewById(R.id.selection);
        boo = 0;
        RadioGroup radGrp = (RadioGroup)findViewById(R.id.radios);
        selection.setText("Питання №" + (iter+1) + "/6\n"+ questioins[iter]);
        radioButton1.setText(answers[iter2]);
        radioButton2.setText(answers[iter2 + 1]);
        radioButton3.setText(answers[iter2 + 2]);
        radioButton4.setText(answers[iter2 + 3]);
        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int id) {
                switch (id) {
                    case R.id.rbfirst:
                        bool = true;
                        break;
                    case R.id.rbtwo:
                        bool = true;
                        break;
                    case R.id.rbthree:
                        bool = true;
                        break;
                    case R.id.rbfour:
                        bool = true;
                        break;
                    default:
                        bool = false;
                        break;
                }
            }});
    }
    public void sendMessage(View view) {
        RadioButton radioButton1 = findViewById(R.id.rbfirst);
        RadioButton radioButton2 = findViewById(R.id.rbtwo);
        RadioButton radioButton3 = findViewById(R.id.rbthree);
        RadioButton radioButton4 = findViewById(R.id.rbfour);
        TextView selection = findViewById(R.id.selection);
        TextView tw2 = findViewById(R.id.tw2);
        Button button = findViewById(R.id.but1);
        if(iter < 6) {
            if (bool) {
                if (iter == 0) {
                    if (radioButton4.isChecked()) {
                        rez += 1;
                    }
                } else if (iter == 1) {
                    if (radioButton1.isChecked()) {
                        rez += 1;
                    }
                } else if (iter == 2) {
                    if (radioButton2.isChecked()) {
                        rez += 1;
                    }
                } else if (iter == 3) {
                    if (radioButton4.isChecked()) {
                        rez += 1;
                    }
                } else if (iter == 4) {
                    if (radioButton3.isChecked()) {
                        rez += 1;
                    }
                } else if (iter == 5) {
                    if (radioButton2.isChecked()) {
                        rez += 1;
                    }
                }
                if(iter < 5) {
                    iter2 += 4;
                    selection.setText("Питання №" + (iter + 2) + "/6\n" + questioins[iter + 1]);
                    radioButton1.setText(answers[0 + iter2]);
                    radioButton2.setText(answers[1 + iter2]);
                    radioButton3.setText(answers[2 + iter2]);
                    radioButton4.setText(answers[3 + iter2]);
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radios);
                    radioGroup.clearCheck();
                    bool = false;
                }
                else {
                    button.setText("Показати результати");
                }
                iter += 1;
            }
        }else{
            tw2.append("\n\n1. " + questioins[0] + " " + TrueAnswers[0] +
                        "\n\n2. " + questioins[1] + " " + TrueAnswers[1] +
                        "\n\n3. " + questioins[2] + " " + TrueAnswers[2] +
                        "\n\n4. " + questioins[3] + " " + TrueAnswers[3] +
                        "\n\n5. " + questioins[4] + " " + TrueAnswers[4] +
                        "\n\n6. " + questioins[5] + " " + TrueAnswers[5]);
        }
    }
}

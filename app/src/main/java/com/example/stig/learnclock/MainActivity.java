package com.example.stig.learnclock;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static float hour = 0;
    private int hourQuiz = 0;
    public static float minute = 0;
    private int minuteQuiz = 0;

    private Map<Integer, String[]> hourMap;
    private Map<Integer, String[]> minuteMap;
    private Map<Integer, Integer> minuteFiveMap;
    private Map<Integer, Integer> verificatonMap;

    private Menu menu;
    private boolean english = true;

    public MainActivity() {
        hourMap = new HashMap<Integer, String[]>();
        minuteMap = new HashMap<Integer, String[]>();
        minuteFiveMap = new HashMap<Integer, Integer>();
        verificatonMap = new HashMap<Integer, Integer>();
        setHour();
        setMinute();
        setMapFiveMap();
        setVerificatonMap();

    }

    private void setHour() {
        hourMap.put(0, new String[] {"twelve", "tolv"});
        hourMap.put(1, new String[] {"one", "ett"});
        hourMap.put(2, new String[] {"two", "to"});
        hourMap.put(3, new String[] {"three", "tre"});
        hourMap.put(4, new String[] {"four", "fire"});
        hourMap.put(5, new String[] {"five", "fem"});
        hourMap.put(6, new String[] {"six", "seks"});
        hourMap.put(7, new String[] {"seven", "syv"});
        hourMap.put(8, new String[] {"eight", "åtte"});
        hourMap.put(9, new String[] {"nine", "ni"});
        hourMap.put(10, new String[] {"ten", "ti"});
        hourMap.put(11, new String[] {"eleven", "elve"});
        hourMap.put(12, new String[] {"twelve", "tolv"});
        hourMap.put(13, new String[] {"one", "ett"});
        hourMap.put(14, new String[] {"two", "to"});
        hourMap.put(15, new String[] {"three", "tree"});
        hourMap.put(16, new String[] {"four", "fire"});
        hourMap.put(17, new String[] {"five", "fem"});
        hourMap.put(18, new String[] {"six", "seks"});
        hourMap.put(19, new String[] {"seven", "syv"});
        hourMap.put(20, new String[] {"eight", "åtte"});
        hourMap.put(21, new String[] {"nine", "ni"});
        hourMap.put(22, new String[] {"ten", "ti"});
        hourMap.put(23, new String[] {"eleven", "elve"});
    }

    private void setMinute() {
        minuteMap.put(0, new String[]{"", ""});
        minuteMap.put(5, new String[]{"It's five minutes past", "Fem over"});
        minuteMap.put(10, new String[]{"It's ten minutes past", "Ti over"});
        minuteMap.put(15, new String[]{"It's a quarter past", "Kvart over"});
        minuteMap.put(20, new String[]{"It's twenty minutes past", "Ti på halv"});
        minuteMap.put(25, new String[]{"It's twentyfive minutes past", "Fem på halv"});
        minuteMap.put(30, new String[]{"It's half past", "Halv"});
        minuteMap.put(35, new String[]{"It's twentyfive minutes to", "Fem over halv"});
        minuteMap.put(40, new String[]{"It's twenty minutes to", "Ti over halv"});
        minuteMap.put(45, new String[]{"It's a quarter to", "Kvart på"});
        minuteMap.put(50, new String[]{"It's ten minutes to", "Ti på"});
        minuteMap.put(55, new String[]{"It's five minutes to", "Fem på"});
    }

    private void setMapFiveMap() {
        minuteFiveMap.put(0, 0);
        minuteFiveMap.put(1, 5);
        minuteFiveMap.put(2, 10);
        minuteFiveMap.put(3, 15);
        minuteFiveMap.put(4, 20);
        minuteFiveMap.put(5, 25);
        minuteFiveMap.put(6, 30);
        minuteFiveMap.put(7, 35);
        minuteFiveMap.put(8, 40);
        minuteFiveMap.put(9, 45);
        minuteFiveMap.put(10, 50);
        minuteFiveMap.put(11, 55);
    }

    private void setVerificatonMap() {
        verificatonMap.put(0, 12);
        verificatonMap.put(1, 13);
        verificatonMap.put(2, 14);
        verificatonMap.put(3, 15);
        verificatonMap.put(4, 16);
        verificatonMap.put(5, 17);
        verificatonMap.put(6, 18);
        verificatonMap.put(7, 19);
        verificatonMap.put(8, 20);
        verificatonMap.put(9, 21);
        verificatonMap.put(10, 22);
        verificatonMap.put(11, 23);
        verificatonMap.put(12, 0);
        verificatonMap.put(13, 1);
        verificatonMap.put(14, 2);
        verificatonMap.put(15, 3);
        verificatonMap.put(16, 4);
        verificatonMap.put(17, 5);
        verificatonMap.put(18, 6);
        verificatonMap.put(19, 7);
        verificatonMap.put(20, 8);
        verificatonMap.put(21, 9);
        verificatonMap.put(22, 10);
        verificatonMap.put(23, 11);
    }

    private int randomHour() {
        Random rand = new Random();
        return rand.nextInt(23);
    }

    private int randomMinute() {
        Random rand = new Random();
        int index = rand.nextInt(11);
        return minuteFiveMap.get(index);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setQuiz();
    }

    private void setQuiz() {
        minuteQuiz = randomMinute();
        hourQuiz = randomHour();

        minuteQuiz = 35;
        hourQuiz = 0;

        updateQuiz();
        resetClock();
    }

    private void updateQuiz() {
        String[] minuteArrayStr = minuteMap.get(minuteQuiz);
        String minuteStr;
        if (this.english) {
            minuteStr = minuteArrayStr[0];
        } else {
            minuteStr = minuteArrayStr[1];
        }

        String[] hourArrayStr;

        int hourQuizCalc = hourQuiz;
        if (this.english) {
            if ((minuteQuiz == 20) || (minuteQuiz == 25) || (minuteQuiz == 30)) {
                --hourQuizCalc;
            }
        }

        hourArrayStr = hourMap.get(hourQuizCalc);


        String hourStr;
        if (this.english) {
            hourStr = hourArrayStr[0];
        } else {
            hourStr = hourArrayStr[1];
        }


        // String quizStr = minuteStr + "(" +  String.valueOf(minuteQuiz) + ") " + hourStr + "(" +  String.valueOf(hourQuiz) + ") ";
        String quizStr = minuteStr + " " + hourStr;
        final TextView quiz = (TextView) findViewById(R.id.quiz);
        quiz.setText(String.valueOf(quizStr));
    }

    private void resetClock() {
        hour = 0;
        minute = 0;
        formateTime(0, 0);
    }

    public void incrementHour(View view) {

        if (hour == 23) {
            hour = 0;
        }
        else {
            hour++;
        }

        formateTime(hour, minute);
    }

    public void decrementHour(View view) {

        if (hour == 0) {
            hour = 23;
        }
        else {
            hour--;
        }

        formateTime(hour, minute);
    }

    private String formateTime(float hour, float minute) {
        String time;
        if (hour < 10) {
            time = "0" + String.valueOf((int)hour);
        }
        else {
            time = String.valueOf((int)hour);
        }

        final TextView digitalHour = (TextView) findViewById(R.id.digitalClockHour);
        digitalHour.setText(String.valueOf(time));

        String min;
        if (minute < 10) {
            min = "0" + String.valueOf((int)minute);
            time += "0" + String.valueOf((int)minute);
        }
        else {
            min = String.valueOf((int)minute);
            time += String.valueOf((int)minute);
        }

        final TextView digitalMinute = (TextView) findViewById(R.id.digitalClockMinute);
        digitalMinute.setText(String.valueOf(min));

        return time;
    }

    public void incrementMinute(View view) {

        if (minute == 55) {
            minute = 0;
            if (hour == 23) {
                hour = 0;
            }
            else {
                hour++;
            }
        }
        else {
            minute = minute + 5;
        }

        formateTime(hour, minute);
    }

    public void decrementMinute(View view) {
        if (minute == 0) {
            minute = 55;
            if (hour == 0) {
                hour = 23;
            }
            else {
                hour--;
            }
        }
        else {
            minute = minute - 5;
        }

        formateTime(hour, minute);
    }

    public void checkTime(View view) {
        int hourCalc = hourQuiz;


        if (minuteQuiz > 15) {

            --hourCalc;
        }

        if (hourCalc < 0)
        {
            hourCalc = 23;
        }


        Log.i("Debug hour: ", String.valueOf((int) hour));
        Log.i("Debug hour calc: ", String.valueOf((int) hourCalc));

        if (((hourCalc == (int)hour) || (hourCalc == verificatonMap.get((int)hour))) && (minuteQuiz == (int)minute)) {
            Toast.makeText(getApplicationContext(),"CORRECT", Toast.LENGTH_LONG).show();// Set your own toast  message

            updateScore(R.id.correctCount);

            setQuiz();
        } else {
            Toast.makeText(getApplicationContext(),"FAULT", Toast.LENGTH_LONG).show();// Set your own toast  message

            updateScore(R.id.faultCount);
        }

    }

    private void updateScore(int widgetId) {
        final TextView countView = (TextView) findViewById(widgetId);
        String count = String.valueOf(countView.getText());
        countView.setText(String.valueOf(Integer.parseInt(count) + 1));

        checkScore();
    }

    private void checkScore() {
        final TextView correctCountView = (TextView) findViewById(R.id.correctCount);
        int correctCount = Integer.parseInt(String.valueOf(correctCountView.getText()));

        final TextView faultcountView = (TextView) findViewById(R.id.faultCount);
        int faultCount = Integer.parseInt(String.valueOf(faultcountView .getText()));

        int sum = faultCount + correctCount;
        if (sum >= 10)
        {
            String gameOverStr = "Game over, your score: " + String.valueOf(correctCount) + " of 10";
            Toast.makeText(getApplicationContext(),gameOverStr, Toast.LENGTH_LONG).show();


            // reset score.
            correctCountView.setText("0");
            faultcountView.setText("0");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.languageButton) {
            if (this.english) {
                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.norway));
            } else {
                menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.unitedkingdom));
            }

            this.english = !this.english;

            updateQuiz();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

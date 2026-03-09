package mad.chineseinputmethodforbeginners;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Simplified_Cangjie extends AppCompatActivity {

    private TextView question, score;
    private EditText answer;
    private Button click;
    private int news = 0;
    private int currentquestionindex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplified_cangjie);

        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        answer = findViewById(R.id.answer);
        click = findViewById(R.id.click);

        loadQuestion();

        click.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String word = answer.getText().toString();
                if (word.equals(QSCangjie.answer[currentquestionindex])){
                    news = news + 1;
                    String score1 = Integer.toString(news);
                    score.setText(score1);
                    currentquestionindex++;
                    loadQuestion();

                }else {
                    news = news - 1;
                    String score1 = Integer.toString(news);
                    score.setText(score1);
                    currentquestionindex++;
                    loadQuestion();

                }
            }
        });
    }void loadQuestion(){

        if (currentquestionindex == 3){
            finishgame();
            return;
        }

        question.setText(QSCangjie.question[currentquestionindex]);
    }

    void finishgame(){
        new AlertDialog.Builder(this)
                .setMessage("Your score is " + news)
                .setPositiveButton("Restart",(dialogInterface, i) -> back())
                .setCancelable(false)
                .show();
    }
    void back(){
        news = 0;
        currentquestionindex = 0;
        loadQuestion();
    }
}
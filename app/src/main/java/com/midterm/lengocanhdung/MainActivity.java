package com.midterm.lengocanhdung;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.midterm.lengocanhdung.dao.QuestionDao;
import com.midterm.lengocanhdung.model.Question;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private QuestionDao questionDAO;
    private Button btn1;
    private List<Question> questionList;
    private int currentQuestionIndex;
    private TextView questionTextView;
    private Button trueButton;
    private Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionList = new ArrayList<Question>();
        questionList.add(new Question("Question 1", true));
        questionList.add(new Question("Question 2", false));
        questionList.add(new Question("Question 3", true));
        questionList.add(new Question("Question 4", false));
        questionList.add(new Question("Question 5", false));
        currentQuestionIndex = 0;
        questionTextView = findViewById(R.id.textView);
        ImageButton previousButton = findViewById(R.id.btn_comback);
        ImageButton nextButton = findViewById(R.id.btn_forward);
        trueButton = findViewById(R.id.btn_true);
        falseButton = findViewById(R.id.btn_false);
        showCurrentQuestion();
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToPreviousQuestion();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToNextQuestion();
            }
        });
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }
    private void showCurrentQuestion() {
        questionTextView.setText(questionList.get(currentQuestionIndex).getContent());
        trueButton.setBackgroundColor(Color.LTGRAY);
        falseButton.setBackgroundColor(Color.LTGRAY);
    }
    private void moveToNextQuestion() {
        if (currentQuestionIndex < questionList.size() - 1) {
            currentQuestionIndex++;
            showCurrentQuestion();
        }
    }
    private void moveToPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            showCurrentQuestion();
        }
    }
    private void checkAnswer(boolean selectedAnswer) {
        boolean correctAnswer = questionList.get(currentQuestionIndex).getCheck();
        if (selectedAnswer == correctAnswer) {
            if (selectedAnswer) {
                trueButton.setBackgroundColor(Color.GREEN);
            } else {
                falseButton.setBackgroundColor(Color.GREEN);
            }
        } else {
            if (selectedAnswer) {
                trueButton.setBackgroundColor(Color.RED);
            } else {
                falseButton.setBackgroundColor(Color.RED);
            }
        }
    }
}

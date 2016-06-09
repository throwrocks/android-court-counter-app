package rocks.athrow.android_court_counter_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPrefs;
    TextView team1Score;
    TextView team2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPrefs = getPreferences(Context.MODE_PRIVATE);

        String team1ScoreString = mPrefs.getString("team1_score", "0");
        String team2ScoreString = mPrefs.getString("team2_score", "0");

        TextView team1Score = (TextView) this.findViewById(R.id.team_1_score);
        TextView team2Score = (TextView) this.findViewById(R.id.team_2_score);

        // Set scores from shared preferences if they exist to handle rotations and coming back
        // to the app from a pause
        if (team1Score != null) {
            team1Score.setText(team1ScoreString);
        }
        if (team2Score != null) {
            team2Score.setText(team2ScoreString);
        }

        Button team1Score1 = (Button) this.findViewById(R.id.team_1_points1);
        Button team1Score2 = (Button) this.findViewById(R.id.team_1_points2);
        Button team1Score3 = (Button) this.findViewById(R.id.team_1_points3);

        Button team2Score1 = (Button) this.findViewById(R.id.team_2_points1);
        Button team2Score2 = (Button) this.findViewById(R.id.team_2_points2);
        Button team2Score3 = (Button) this.findViewById(R.id.team_2_points3);

        Button resetScores = (Button) this.findViewById(R.id.reset_scores);

        //------------------------------------------------------------------------------------------
        // TEAM 1 ONCLICK LISTENERS
        //------------------------------------------------------------------------------------------
        if (team1Score1 != null) {
            team1Score1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateScore(1, 1);
                }
            });
        }
        if (team1Score2 != null) {
            team1Score2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateScore(1, 2);
                }
            });
        }
        if (team1Score3 != null) {
            team1Score3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateScore(1, 3);
                }
            });
        }
        //------------------------------------------------------------------------------------------
        // TEAM 2 ONCLICK LISTENERS
        //------------------------------------------------------------------------------------------
        if (team2Score1 != null) {
            team2Score1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateScore(2, 1);
                }
            });
        }
        if (team2Score2 != null) {
            team2Score2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateScore(2, 2);
                }
            });
        }
        if (team2Score3 != null) {
            team2Score3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateScore(2, 3);
                }
            });
        }
        //------------------------------------------------------------------------------------------
        // RESET ONCLICK LISTENERS
        //------------------------------------------------------------------------------------------
        if (resetScores != null) {
            resetScores.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetScores();
                }
            });
        }
    }

    /**
     * updateScores
     * This method handles updating the given team's score by the specified amount of points
     *
     * @param team   1 or 2, the team to update
     * @param points the number of points to add (1, 2, or 3)
     */
    public void updateScore(int team, int points) {
        SharedPreferences.Editor ed = mPrefs.edit();
        if (team == 1) {
            team1Score = (TextView) this.findViewById(R.id.team_1_score);
            if (team1Score != null) {
                int team1CurrentScore = Integer.parseInt(team1Score.getText().toString());
                int newScore = team1CurrentScore + points;
                String newScoreString = Integer.toString(newScore);
                team1Score.setText(newScoreString);
                ed.putString("team1_score", newScoreString);
            }
        } else if (team == 2) {
            team2Score = (TextView) this.findViewById(R.id.team_2_score);
            if (team2Score != null) {
                int team2CurrentScore = Integer.parseInt(team2Score.getText().toString());
                int newScore = team2CurrentScore + points;
                String newScoreString = Integer.toString(newScore);
                team2Score.setText(newScoreString);
                ed.putString("team2_score", newScoreString);
            }
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Error: team argument is empty";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        ed.apply();
    }

    /**
     * resetScores
     * This method resets the scores
     */
    private void resetScores() {
        TextView team1Score = (TextView) this.findViewById(R.id.team_1_score);
        TextView team2Score = (TextView) this.findViewById(R.id.team_2_score);
        if (team1Score != null && team2Score != null) {
            team1Score.setText("0");
            team2Score.setText("0");
        }
    }
}

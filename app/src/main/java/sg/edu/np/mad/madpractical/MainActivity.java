package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Create");

        User user = new User(
                "Hello World!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                0,
                false
                );

        TextView userName = findViewById(R.id.userName);
        userName.setText(user.getName());

        TextView userDescription = findViewById(R.id.userDescription);
        userDescription.setText(user.getDescription());

        Button followButton = findViewById(R.id.followButton);

        if (user.isFollowed()) {
            followButton.setText("Followed");
        }

        else {
            followButton.setText("Follow");
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Pressed!");

                if (user.isFollowed()) {
                    user.setFollowed(false);
                    followButton.setText("Follow");
                    Log.v(TAG, "User is Followed: " + String.valueOf(user.isFollowed()));
                }

                else {
                    user.setFollowed(true);
                    followButton.setText("Followed");
                    Log.v(TAG, "User is Followed: " + String.valueOf(user.isFollowed()));
                }
            }
        });

    }
}
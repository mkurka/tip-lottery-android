package cz.tipsport.lottery.android;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.jetbrains.annotations.NotNull;

public class TipLosAndroidActivity extends AppCompatActivity {
    private TextView message;
    private int counter = 0;

    private BottomNavigationView navigationView;
    private FrameLayout frameLayout;

    private FragmentSession fragmentSession;
    private FragmentDailyStatement fragmentDailyStatement;
    private FragmentShipments fragmentShipments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.clickCounter);
        ImageView droid = findViewById(R.id.droidImage);

        //Define and attach click listener
        droid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDroid();
            }
        });

        navigationView = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.frameLayout);

        fragmentSession = new FragmentSession();
        fragmentDailyStatement = new FragmentDailyStatement();
        fragmentShipments = new FragmentShipments();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_session:
                        initializeFragment(fragmentSession);
                        return true;
                    case R.id.navigation_daily_statement:
                        initializeFragment(fragmentDailyStatement);
                        return true;
                    case R.id.navigation_shipments:
                        initializeFragment(fragmentShipments);
                        return true;
                }
                return false;
            }
        });
    }

    private void initializeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }

    private void tapDroid() {
        counter++;
        String countAsText;
        /*
         * In real applications you should not write switch like the one below.
         * Use resource of type "Quantity strings (plurals)" instead.
         * See https://developer.android.com/guide/topics/resources/string-resource#Plurals
         */
        switch (counter) {
            case 1:
                countAsText = "once";
                break;
            case 2:
                countAsText = "twice";
                break;
            case 3:
                countAsText = "tree";
                break;
            default:
                countAsText = String.format("%d times", counter);
        }
        message.setText(String.format("You touched the droid %s", countAsText));
    }
}

package com.example.nakilnat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavigationView)
    AHBottomNavigation bottomNavigation;

    @BindView(R.id.text_toolbar)
    TextView text_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Anasayfa", R.drawable.home_stuff, R.color.grey);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Tasimalanm", R.drawable.location_icon, R.color.grey);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(" ",  R.color.grey);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("IIan Ekle", R.drawable.plus_icon, R.color.grey);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("Profilim", R.drawable.user_stuff, R.color.grey);
        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);

        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.colorTransparent));
        bottomNavigation.setSoundEffectsEnabled(true);

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(true);
        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

// Change colors
        bottomNavigation.setAccentColor(getResources().getColor(R.color.colorPrimaryDark));
        bottomNavigation.setInactiveColor(getResources().getColor(R.color.bottomSheetInActiveColor));


        // Customize notification (title, background, typeface) bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));
        // Add or remove notification for each item bottomNavigation.setNotification("1", 3);
        // OR




        // Set current item programmatically

        // Set listeners
        bottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {
            // Do something cool here...
            switch (position) {
                case 0:
                   // fragment = new HomeFragment();
                    text_toolbar.setText("Anasayfa");

                    break;
                case 1:
                   // fragment = new PreOrdersFragment();
                    text_toolbar.setText("Tasimalanm");
                    break;
                case 2:
                   // fragment = new RevenueFragment();

                    break;
                case 3:
                   // fragment = new DishesFragment();
                    text_toolbar.setText("IIan Ekle");
                    break;
                case 4:
                   // fragment = new SettingFragment();
                    text_toolbar.setText("Profilim");
                    break;
            }

        /*    transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, fragment).commit();*/

            return true;
        });

    }


    private void removeItemsUnderline(BottomNavigationView bottomNavigationView) {
        for (int i = 0; i <  bottomNavigationView.getMenu().size(); i++) {
            MenuItem item = bottomNavigationView.getMenu().getItem(i);
            item.setTitle(item.getTitle().toString());
        }
    }

    private void underlineMenuItem(MenuItem item) {
        SpannableString content = new SpannableString(item.getTitle());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        item.setTitle(content);

    }
}
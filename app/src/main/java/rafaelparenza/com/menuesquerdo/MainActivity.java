package rafaelparenza.com.menuesquerdo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView menuNavegationView;
    private FrameLayout containerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.sharp_menu_white_24);

        drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        menuNavegationView = findViewById(R.id.activity_main_menu_navigation_view);
        containerFrameLayout = findViewById(R.id.main_activity_container_frame_layout);
        menuNavegationView.setNavigationItemSelectedListener(this);

        changeContainer(new Item1Fragment());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(Gravity.START);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(Gravity.START);

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.main_menu_item_1:
                fragment = new Item1Fragment();
                break;
            case R.id.main_menu_item_2:
                fragment = new Item2Fragment();
                break;
            case R.id.main_menu_item_3:
                fragment = new Item3Fragment();
                break;
        }
        if(fragment != null)
        {
            changeContainer(fragment);
        }

        return false;
    }

    private void changeContainer(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerFrameLayout.getId(), fragment);
        transaction.commit();


    }
}

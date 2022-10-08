package mao.android_menu;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.CYAN;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(1, RED, 4, "红色");
        menu.add(1, GREEN, 2, "绿色");
        menu.add(1, BLUE, 3, "蓝色");
        menu.add(1, YELLOW, 1, "黄色");
        menu.add(1, GRAY, 5, "灰色");
        menu.add(1, CYAN, 6, "蓝绿色");
        menu.add(1, BLACK, 7, "黑色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case RED:
                textView.setTextColor(Color.RED);
                break;
            case GREEN:
                textView.setTextColor(Color.GREEN);
                break;
            case BLUE:
                textView.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                textView.setTextColor(Color.YELLOW);
                break;
            case GRAY:
                textView.setTextColor(Color.GRAY);
                break;
            case CYAN:
                textView.setTextColor(Color.CYAN);
                break;
            case BLACK:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu)
    {
        toastShow("菜单关闭");
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        toastShow("菜单打开前");
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu)
    {
        toastShow("菜单打开后");
        return true;
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        registerForContextMenu(textView);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        unregisterForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.add(1, 16, 1, "16sp");
        menu.add(1, 24, 2, "24sp");
        menu.add(1, 30, 3, "30sp");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();
        switch (itemId)
        {
            case 16:
                textView.setTextSize(16);
                break;
            case 24:
                textView.setTextSize(24);
                break;
            case 30:
                textView.setTextSize(30);
                break;
        }
        return true;
    }

    /**
     * 显示消息
     *
     * @param message 消息
     */
    private void toastShow(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
package mcssoft.com.gsonparsetestbed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String bp;
        InputStream is = null;
        try {
            is = getResources().getAssets().open("test_data.txt");

            if(is != null) {
                reader = new JsonReader( new InputStreamReader(is, "UTF-8"));

                parse();

                is.close();
            }
        } catch(Exception ex) {
            bp = "";
        } finally {
        }

    }

    private void parse() {
        String bp;
        String key;
        JsonToken token;
        try {
            while (reader.hasNext()) {
                token = reader.peek();
                switch(token) {
                    case BEGIN_OBJECT:
                        reader.beginObject();
                        break;
                    case END_OBJECT:
                        reader.endObject();
                        break;
                    case BEGIN_ARRAY:
                        reader.beginArray();
                        break;
                    case END_ARRAY:
                        reader.endArray();
                        break;
                    case NAME:
                        key = reader.nextName();
                        bp="";
                        break;
                    case BOOLEAN:
                        boolean b = reader.nextBoolean();
                        bp="";
                        break;
                    case NUMBER:
                        long l = reader.nextLong();
                        bp="";
                        break;
                    case STRING:
                        String s = reader.nextString();
                        bp="";
                        break;
                    case NULL:
                        reader.nextNull();
                        bp="";
                        break;
                    case END_DOCUMENT:
                        bp="";
                        break;
                }
            }
        } catch (Exception ex) {
            bp = "";
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private JsonReader reader;
}

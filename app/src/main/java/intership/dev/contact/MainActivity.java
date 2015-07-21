package intership.dev.contact;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import model.Contact;


public class MainActivity extends Activity {

    private CustomHeader mHeader;
    private ListView lvContact;
    private ArrayList<Contact> mContacts;
    private Contact mContact;
    private ContactAdapter mContactAdapter;

    private int [] arrAvatars = {R.mipmap.img_contact1, R.mipmap.img_contact2, R.mipmap.img_contact1, R.mipmap.img_contact2,R.mipmap.img_contact1, R.mipmap.img_contact2, R.mipmap.img_contact1, R.mipmap.img_contact2, R.mipmap.img_contact1, R.mipmap.img_contact2, R.mipmap.img_contact1, R.mipmap.img_contact2};
    private String [] arrContact = {"Brunch this weekend?", "Summer BBQ", "Oui Oui", "Birthday Gift", "Recipe to try", "Giants game", "Brunch this weekend?", "Summer BBQ", "Oui Oui", "Birthday Gift", "Recipe to try", "Giants game"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeader = (CustomHeader) findViewById(R.id.rlHeader);
        lvContact = (ListView) findViewById(R.id.lvContact);

        mContacts = new ArrayList<Contact>();

        for (int contactIndex = 0; contactIndex < arrContact.length; contactIndex++) {
            mContact = new Contact();
            mContact.setmAvatar(arrAvatars[contactIndex]);
            mContact.setmName(arrContact[contactIndex]);
            mContacts.add(mContact);
        }

        mContactAdapter = new ContactAdapter(this, mContacts);
        lvContact.setAdapter(mContactAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.mitu.realcontactbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    ListView lvContactList;
    private Realm realm;
    RealmResults<ContactModel> timeStamps;
    AddContact addContact = new AddContact();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* lvContactList = (ListView) findViewById(R.id.listView);
        if (addContact.results1 !=null){
            timeStamps = addContact.results1;
            lvContactList.setAdapter(new ContactAdapter());
        }*/







    }





   /* class ContactAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return timeStamps.size();
        }

        @Override
        public Object getItem(int position) {
            return timeStamps.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.layout_phonebook,parent,false);

            TextView tvName = (TextView) convertView.findViewById(R.id.textView);
            TextView tvPhone = (TextView) convertView.findViewById(R.id.textView2);

            ContactModel ch = (ContactModel) getItem(position);
            tvName.setText(ch.mName);
            tvPhone.setText(ch.mPhone);

            return convertView;
        }
    }*/

    public void goToAdd(View v){
        startActivityForResult(new Intent(getApplicationContext(),AddContact.class),100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100){
            if(resultCode == RESULT_OK){
               // clicklist();
            }
        }
        else if(requestCode == 101){
            if(resultCode == RESULT_OK){
              //  clicklist();
            }
        }
        if(requestCode == 102){
            if(resultCode == RESULT_OK){
                //clicklist();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

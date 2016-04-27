package com.example.mitu.realcontactbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class AddContact extends AppCompatActivity {
    EditText etName, etPhone;
    ContactModel contactModel;
    Button addbutton,button;
    public  Realm myRealm;
    ListView lvContactList;
    public  RealmResults<ContactModel> results1;
    LinearLayout linearLayout;
    private ContactAdapter contactAdapter;


    int _id;
    TextView tv;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        etName = (EditText) findViewById(R.id.editText);
        etPhone = (EditText) findViewById(R.id.editText2);
        lvContactList = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button2);
        addbutton = (Button) findViewById(R.id.addcontact);
        linearLayout = (LinearLayout) findViewById(R.id.layoutaddcontact);
        linearLayout.setVisibility(View.GONE);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();

        myRealm = Realm.getInstance(realmConfig);

        myRealm.beginTransaction();
        contactModel = new ContactModel();

        ///Query
        results1 = myRealm.where(ContactModel.class).findAll();

        /*for(ContactModel c:results1) {
            Log.d("results1", c.getmName() + c.getmPhone() + " ");
        }*/
        contactAdapter = new ContactAdapter();

        lvContactList.setAdapter(contactAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();


                contactModel.setmName(name);
                contactModel.setmPhone(phone);
                myRealm.copyToRealm(contactModel);
                myRealm.commitTransaction();


                linearLayout.setVisibility(v.GONE);
                addbutton.setVisibility(v.VISIBLE);
                results1 = myRealm.where(ContactModel.class).findAll();
                contactAdapter = new ContactAdapter();

                lvContactList.setAdapter(contactAdapter);

            }
        });



    }

    public void newcontact(View v){
        addbutton.setVisibility(v.GONE);
        linearLayout.setVisibility(v.VISIBLE);

    }
  /*  public void addContact(View v){
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();


        contactModel.setmName(name);
        contactModel.setmPhone(phone);
        myRealm.copyToRealm(contactModel);
        myRealm.commitTransaction();


        linearLayout.setVisibility(v.GONE);
        addbutton.setVisibility(v.VISIBLE);
        results1 = myRealm.where(ContactModel.class).findAll();
        contactAdapter = new ContactAdapter();

        lvContactList.setAdapter(contactAdapter);

       // myRealm.close();



    }*/



    class ContactAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return results1.size();
        }

        @Override
        public Object getItem(int position) {
            return results1.get(position);
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
    }






}

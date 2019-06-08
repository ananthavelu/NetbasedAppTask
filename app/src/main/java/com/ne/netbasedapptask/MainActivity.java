package com.ne.netbasedapptask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView text;
    HttpHelper httpHelper;
    String serveraddress="https://api.androidhive.info/contacts/";
    ProgressDialog progressDialog;
    String jsonstring="",name,name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textview);
    }

    public void savenetbased(View view) {
        Asynclass asynclass=new Asynclass();
        asynclass.execute();

    }

    private class Asynclass extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            httpHelper=new HttpHelper();
             jsonstring= httpHelper.makeServiceCall(serveraddress);
            try {
                JSONObject jsonObject=new JSONObject(jsonstring);
                JSONArray jsonArray=jsonObject.getJSONArray("contacts");
                JSONObject jsonObject1= jsonArray.getJSONObject(0);
                name=jsonObject1.getString("name");
                JSONObject jsonObject2= jsonArray.getJSONObject(1);
                name1=jsonObject2.getString("name");
                JSONObject jsonObject3= jsonArray.getJSONObject(2);
                name2=jsonObject3.getString("name");
                JSONObject jsonObject4= jsonArray.getJSONObject(3);
                name3=jsonObject4.getString("name");
                JSONObject jsonObject5= jsonArray.getJSONObject(4);
                name4=jsonObject5.getString("name");
                JSONObject jsonObject6= jsonArray.getJSONObject(5);
                name5=jsonObject6.getString("name");
                JSONObject jsonObject7= jsonArray.getJSONObject(6);
                name6=jsonObject7.getString("name");
                JSONObject jsonObject8= jsonArray.getJSONObject(7);
                name7=jsonObject8.getString("name");
                JSONObject jsonObject9= jsonArray.getJSONObject(8);
                name8=jsonObject9.getString("name");
                JSONObject jsonObject10= jsonArray.getJSONObject(9);
                name9=jsonObject10.getString("name");
                JSONObject jsonObject11= jsonArray.getJSONObject(10);
                name10=jsonObject11.getString("name");
                JSONObject jsonObject12= jsonArray.getJSONObject(11);
                name11=jsonObject12.getString("name");
                JSONObject jsonObject13= jsonArray.getJSONObject(12);
                name12=jsonObject13.getString("name");


            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("abcd",jsonstring+"");
                return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            progressDialog.cancel();
             text.setText(name+"\n"+name1+"\n"+name2+"\n"+name3+"\n"+name4+"\n"+name5+"\n"+name6+"\n"
                     +name7+"\n"+name8+"\n"+name9+"\n"+name10+"\n"+name11+"\n"+name12);
        }
    }
}

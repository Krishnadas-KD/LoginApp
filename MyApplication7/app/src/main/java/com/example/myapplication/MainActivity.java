package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.sql.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("Newapi")
    public Connection connectionclass(){

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection=null;
        String ConnectionURl=null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURl="jdbc:jtds:sqlserver://testserverlogin001.database.windows.net:1433;tester;user=db6001@testserverlogin001;password=Kd789/*-;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection= DriverManager.getConnection(ConnectionURl);
            System.out.println("hi");
        }
        catch (SQLException se)
        {
            Log.e("error :",se.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error :",e.getMessage());
        }
        return connection;
    }

    public void logcheck(View view) throws SQLException {
        String qua="select * from Users";
        Connection con=connectionclass();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(qua);
        while(rs.next()){
            String name1=rs.getString(1);
            String name2=rs.getString(2);
            System.out.println(name1+"+"+name2);
        }
    }
}
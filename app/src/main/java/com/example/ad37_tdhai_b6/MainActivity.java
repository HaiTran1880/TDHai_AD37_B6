package com.example.ad37_tdhai_b6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextPass;
    Button buttonLogIn;
    TextView tvMessErrorUser, tvMessErrorPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessErrorPass=findViewById(R.id.tvMessErrorPass);
        tvMessErrorUser=findViewById(R.id.tvMessErrorUser);
        editTextName=findViewById(R.id.etUserName);
        editTextPass=findViewById(R.id.etPass);
        buttonLogIn=findViewById(R.id.btLogIn);

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= editTextName.getText().toString();
                String pass= editTextPass.getText().toString();
                if(checkPass(pass)==false){
                    tvMessErrorPass.setText("Error Pass!");
                }
                if(checkUserName(user)==false){
                    tvMessErrorUser.setText("Error UserName!");
                }
                if(checkPass(pass) ==true&& checkUserName(user)==true){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }

            }
        });

    }

    public boolean checkUserName(String userName){

        if(userName.compareToIgnoreCase("admin")==0)
            return true;
        else
        {
            return false;
        }
    }

    public boolean checkPass(String passWord){

        boolean checkChuHoa=false;
        boolean checkChuThuong=false;
        boolean checkso=false;
        boolean checkkitu= false;
        int length= passWord.length();


        if(passWord==null||passWord.length()<6)
            return false;
        else
            return true;


    }
}

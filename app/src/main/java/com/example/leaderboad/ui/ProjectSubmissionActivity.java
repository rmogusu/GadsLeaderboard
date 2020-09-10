package com.example.leaderboad.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.leaderboad.R;
import com.example.leaderboad.services.RetrofitPost;
import com.example.leaderboad.networks.SendPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity  implements View.OnClickListener {
    ImageView background;
    ImageView icon;
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText githublink;
    private Button mSubmitBtn;
    private Button confirmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_submission);
        background = (ImageView) findViewById(R.id.imageView);
        icon = (ImageView) findViewById(R.id.icon);
        icon.setOnClickListener(this);
        mSubmitBtn = (Button) findViewById(R.id.submitBtn);
        mSubmitBtn.setOnClickListener(this);
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        email = findViewById(R.id.email_address);
        githublink = findViewById(R.id.submit_githublink);

    }

    @Override
    public void onClick(View view) {
        if (view == icon) {
            Intent intent = new Intent(ProjectSubmissionActivity.this, LeaderboardListActivity.class);
            startActivity(intent);
        }  if (view == mSubmitBtn) {
            confirmSubmit();

        }

    }

    private void confirmSubmit(){
        final String fname = firstname.getText().toString().trim();
        final String lname = lastname.getText().toString().trim();
        final String emailAddress = email.getText().toString().trim();
        final String link = githublink.getText().toString().trim();

        boolean validEmail = isValidEmail(emailAddress);
        boolean validFName = isValidFName(fname);
        boolean validLName = isValidLName(lname);
        boolean validLink = isValidLink(link);

        if (!validEmail || !validFName || !validLName || !validLink) return;
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this,R.style.AlertDialog);
        View view=getLayoutInflater().inflate(R.layout.submission_confirm_submit,null);
        alertDialog.setView(view);
        final AlertDialog alert=alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.setCancelable(false);
        Button confirmBtn=view.getRootView().findViewById(R.id.submit_yes);
        ImageView img_cancel=view.getRootView().findViewById(R.id.submit_cancel);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RetrofitPostRequest();
                alert.hide();
            }

        });
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.cancel();
            }
        });
        alert.show();
    }
    private boolean isValidFName(String name) {
        if (name.equals("")) {
            firstname.setError("Please enter your first name");
            return false;
        }
        return true;
    }
    private boolean isValidLName(String name) {
        if (name.equals("")) {
            lastname.setError("Please enter your last name");
            return false;
        }
        return true;
    }
    private boolean isValidLink(String gLink) {
        if (gLink.equals("")) {
            githublink.setError("Please enter your Github Link ");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String emailAdress) {
        boolean isGoodEmail =
                (emailAdress != null && android.util.Patterns.EMAIL_ADDRESS.matcher(emailAdress).matches());
        if (!isGoodEmail) {
            email.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private void alertSendFailed(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this,R.style.AlertDialog);
        View view=getLayoutInflater().inflate(R.layout.submission_not_successful,null);
        alertDialog.setView(view);
        AlertDialog alert=alertDialog.create();
        alert.setCanceledOnTouchOutside(true);
        alert.setCancelable(true);
        alert.show();
    }

    private void alertSendSuccessful(){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this,R.style.AlertDialog);
        View view=getLayoutInflater().inflate(R.layout.submission_successful,null);
        alertDialog.setView(view);
        AlertDialog alert=alertDialog.create();
        alert.setCanceledOnTouchOutside(true);
        alert.setCancelable(true);
        alert.show();
    }
    public class RetrofitPostRequest {
        public RetrofitPostRequest() {
            final String fname = firstname.getText().toString().trim();
            final String lname = lastname.getText().toString().trim();
            final String emailAddress = email.getText().toString().trim();
            final String link = githublink.getText().toString().trim();
            SendPost sendpost = RetrofitPost.getRetrofit().create(SendPost.class);
            Call<Void> call = sendpost.sendPost(fname,lname,emailAddress,link);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful()){
                        alertSendSuccessful();
                    }
                    else{
                        alertSendFailed();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    alertSendFailed();
                }
            });
        }
    }


}

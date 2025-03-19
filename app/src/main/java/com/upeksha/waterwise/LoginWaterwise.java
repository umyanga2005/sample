package com.upeksha.waterwise;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginWaterwise extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_waterwise);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        MaterialButton btnLogin = findViewById(R.id.btn_login);
        TextView tvSignUp = findViewById(R.id.tv_sign_up);

        btnLogin.setOnClickListener(v -> loginUser());
        tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginWaterwise.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        String email = Objects.requireNonNull(etEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(etPassword.getText()).toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            return;
        }

        // Simulated login logic
        if (email.equals("user@example.com") && password.equals("password123")) {
            Toast.makeText(LoginWaterwise.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginWaterwise.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginWaterwise.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}

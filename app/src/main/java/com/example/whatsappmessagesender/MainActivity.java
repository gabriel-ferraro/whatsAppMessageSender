package com.example.whatsappmessagesender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutMessage;

    private TextInputEditText inputEditTextPhoneNumber;
    private TextInputEditText inputEditTextMessage;
    private Button btnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutMessage = findViewById(R.id.text_input_layout_message);

        inputEditTextPhoneNumber = findViewById(R.id.input_edit_text_phone_number);
        inputEditTextMessage = findViewById(R.id.input_edit_text_message);
        btnSendMessage = findViewById(R.id.btn_send_message);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = inputEditTextPhoneNumber.getText().toString();
                String message = inputEditTextMessage.getText().toString();

                try {
                    Uri webpage = Uri.parse("https://wa.me/" + 55 + phoneNumber + "?text=" + message);
                    Intent i = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(i);
                } catch (Exception e) {
                    textInputLayoutMessage.setError("Erro - o dispositivo não possuí uma versão válida do whatsApp ou algum problema desconhecido ocorreu.");
                }
            }
        });
    }
}
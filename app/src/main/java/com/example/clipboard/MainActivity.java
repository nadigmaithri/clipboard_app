package com.example.clipboard;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtCopy, txtPaste;
    Button btnCopy, btnPaste;
    ClipboardManager myClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCopy = (EditText)findViewById(R.id.copy);
        txtPaste = (EditText)findViewById(R.id.paste);
        btnCopy = (Button)findViewById(R.id.button);
        btnCopy.setOnClickListener(this);
        btnPaste = (Button)findViewById(R.id.button2);
        btnPaste.setOnClickListener(this);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
    }
    @Override
    public void onClick(View v) {
        if (v.equals(btnCopy)) {
            ClipData myClip;
            String data = txtCopy.getText().toString();
            myClip = ClipData.newPlainText("text", data);
            myClipboard.setPrimaryClip(myClip);
            Toast.makeText(getBaseContext(), "Copied...", Toast.LENGTH_LONG).show();
        } else if (v.equals(btnPaste)) {
            ClipData abc = myClipboard.getPrimaryClip();
            ClipData.Item item = abc.getItemAt(0);
            txtPaste.setText(item.getText().toString());
        }
    }
}
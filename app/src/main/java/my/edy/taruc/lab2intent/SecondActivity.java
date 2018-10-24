package my.edy.taruc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String TAG_REPLY = "my.edy.taruc.lab2intent.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Create an instance of Intent
        Intent intent = getIntent();  // Who called me ?
        if(intent.hasExtra(MainActivity.TAG_MESSAGE)){
            TextView textViewMessage;
            textViewMessage = findViewById(R.id.textViewMessage);
            String stringMsg;
            stringMsg = intent.getStringExtra(MainActivity.TAG_MESSAGE);
            textViewMessage.setText(stringMsg);
        }
    }

    public void sendReply(View view){
        // TODO: Link UI to program, get the text from EditText
        EditText editTextReply;
        editTextReply = findViewById(R.id.editTextReply);

        if(TextUtils.isEmpty(editTextReply.getText())){
            editTextReply.setError(getString(R.string.error_reply));
            return;
        }
        String stringReply;
        stringReply = editTextReply.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(TAG_REPLY, stringReply);
        setResult(RESULT_OK);
        finish();
    }
}

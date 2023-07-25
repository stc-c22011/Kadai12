package jp.suntech.c22011.example.kadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //クリアボタンの呼び出し
        Button btClear = findViewById(R.id.btClear);
        //確認ボタンの呼び出し
        Button btConfirm = findViewById(R.id.btConfirm);
        //送信ボタンの呼び出し
        Button btSend = findViewById(R.id.btSend);

        //リスナオブジェクトの用意
        HelloListener listener = new HelloListener();

        //クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
        //確認ボタンにリスナを設定
        btConfirm.setOnClickListener(listener);
        //送信ボタンにリスナを設定
        btSend.setOnClickListener(listener);
    }


    //ボタンをクリックしたときのリスナクラス
    private class HelloListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //名前入力欄であるEditTextオブジェクトを取得
            EditText inputN = findViewById(R.id.etName);
            //メールタイトル入力欄であるEditTextオブジェクトを取得
            EditText inputMt = findViewById(R.id.etMailT);
            //メール入力欄であるEditTextオブジェクトを取得
            EditText inputM = findViewById(R.id.etMail);
            //質問内容入力欄であるEditTextオブジェクトを取得
            EditText inputC = findViewById(R.id.etComment);

            //タップされた画面部品のidのＲ値を取得
            int id = v.getId();

            //送信ボタンの時
            if (id == R.id.btSend) {
                //入力された名前、メールタイトル、メール、質問内容の文字列を取得
                String inputStrN = inputN.getText().toString();
                String inputStrMt = inputMt.getText().toString();
                String inputStrM = inputM.getText().toString();
                String inputStrC = inputC.getText().toString();

                String show = "お名前 " + inputStrN  + "メールタイトル "+inputStrMt+"\n"+"メール内容 " + inputStrM + "質問内容 " + inputStrC;
                Snackbar.make(v, show, Snackbar.LENGTH_LONG).show();//すべて表示されない


            }
            //確認ボタンの時
            if (id == R.id.btConfirm) {
                //入力された名前、メールタイトル、メール、質問内容の文字列を取得
                String inputStrN = inputN.getText().toString();
                String inputStrMt = inputMt.getText().toString();
                String inputStrM = inputM.getText().toString();
                String inputStrC = inputC.getText().toString();
                OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");

                String show = "お名前 " + inputStrN  + "メールタイトル "+inputStrMt+"\n"+"メール内容 " + inputStrM + "質問内容 " + inputStrC;
                Snackbar.make(v, show, Snackbar.LENGTH_LONG).show();//すべて表示されない
            }

            //クリアボタンの時
            if (id == R.id.btClear) {
                //入力欄に空文字を設定
                inputN.setText("");
                inputMt.setText("");
                inputM.setText("");
                inputC.setText("");


            }
        }
    }
}
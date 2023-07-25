package jp.suntech.c22011.example.kadai12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定
        builder.setTitle("確認");
        //メッセージ設定
        builder.setMessage("この内容で送信して良いですか？");
        //ボタン設定
        builder.setPositiveButton("OK", new DialogButtonClickListener());
        builder.setNegativeButton("Cancel", new DialogButtonClickListener());

        //ダイアログオブジェクトを生成し、リターン。
        AlertDialog dialog = builder.create();
        return dialog;
    }

    //ダイアログのアクションボタンが押された時の処理をする
    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            //トーストメッセージ用文字列変数を用意
            String msg = "";
            //タップされたアクションボタンで分岐
            switch (which) {

                case DialogInterface.BUTTON_POSITIVE:
                    msg = "送信しました";
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    msg = "キャンセルしました";
                    break;

            }
            //トースト表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}









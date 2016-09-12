package ailatrieuphu.trungns.com.ailatrieuphu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import org.apache.http.conn.scheme.HostNameResolver;



public class FinishActivity extends Activity {
    private static final int CHOI_LAI = 101;
    private TextView mTxtNumberQuestion, mTxtMoney;
    private MyDialogAnswerWrong myDialogAnswerWrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_game);
        initView();
    }

    private void initView() {
        myDialogAnswerWrong = new MyDialogAnswerWrong(this);
        mTxtMoney = (TextView) findViewById(R.id.tv_finish_money_vnd);
        mTxtNumberQuestion = (TextView) findViewById(R.id.tv_finish_tai_cau_hoi);

        Intent intentResult = getIntent();
        mTxtNumberQuestion.setText("BẠN ĐÃ DỪNG CUỘC CHƠI TẠI CÂU HỎI SỐ " + intentResult.getStringExtra(MainGameActivity.KEY_NUMBER_QUESTION));
        mTxtMoney.setText(intentResult.getStringExtra(MainGameActivity.KEY_MONEY));
        myDialogAnswerWrong.setOwnerActivity(this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myDialogAnswerWrong.show();
            }
        }, 5000);
    }
}

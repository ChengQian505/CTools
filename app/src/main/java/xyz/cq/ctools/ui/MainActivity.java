package xyz.cq.ctools.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.cq.clog.CLog;
import xyz.cq.clog.dialog.BottomDialog;
import xyz.cq.clog.dialog.CommonDialog;
import xyz.cq.clog.dialog.LoadingDialog;
import xyz.cq.ctools.BuildConfig;
import xyz.cq.ctools.R;

public class MainActivity extends Activity {
    private String[] itemStr = new String[]{"CLog初始化", "设置logFile", "Toast", "打印到文件", "Loading Dialog", "CommonDialog", "BottomDialog","存储地址"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        for (int i = 0; i < itemStr.length; i++) {
            ViewGroup base_main = (ViewGroup) findViewById(R.id.base_main);
            LayoutInflater.from(this).inflate(R.layout.item, base_main);
            ((TextView) base_main.getChildAt(i).findViewById(R.id.item_text1)).setText(itemStr[i]);
            final int finalI = i;
            base_main.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (finalI) {
                        case 0:
                            CLog.init("Ctools", BuildConfig.DEBUG);
                            break;
                        case 1:
                            CLog.logFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Clog");
                            break;
                        case 2:
                            CLog.show(CLog.packageName());
                            break;
                        case 3:
                            CLog.log().iFile(CLog.packageName());
                            break;
                        case 4:
                            tipDialog();
                            break;
                        case 5:
                            common();
                            break;
                        case 6:
                            bottom();
                            break;
                        case 7:
                            Storage.Companion.launch(MainActivity.this);
                            break;
                    }
                }
            });
        }
    }

    private void tipDialog() {
        final LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this);
        loadingDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loadingDialog.dismiss();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void bottom() {
        new BottomDialog(MainActivity.this)
                .setText("第一个", "第二个", "第三个")
                .setOnClickListener(new BottomDialog.OnClickListener() {
                    @Override
                    public void onClick(View positionV, int position) {
                        CLog.show("点击了第" + (position + 1) + "个按钮");
                    }
                }).show();
    }

    private void common() {
        new CommonDialog(MainActivity.this)
                .setTitle("标题")
                .setContent("内容")
                .setLeftBtnText("左边按钮")
                .setRightBtnText("右边按钮")
                .setOnBtnClickListener(new CommonDialog.OnDialogBtnClickListener() {
                    @Override
                    public void onLeftBtnClicked(CommonDialog paramTipDialog) {
                        paramTipDialog.dismiss();
                    }

                    @Override
                    public void onRightBtnClicked(CommonDialog paramTipDialog) {
                        paramTipDialog.dismiss();
                    }
                }).show();
    }

}

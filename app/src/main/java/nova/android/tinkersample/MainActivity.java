package nova.android.tinkersample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        Button btn_repair = findViewById(R.id.btn_repair);
        btn_repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "修复Bug!", Toast.LENGTH_SHORT).show();
                TinkerInstaller.onReceiveUpgradePatch(
                        getApplication().getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch.patch"
                );
            }
        });
        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setText("测试再次修复-！@#￥%……%……Z");

        tv_content.setText(tv_content.getText() + "\n 不能再次在原版基础上修复吗");
        tv_content.setText(tv_content.getText() + "\n 测试在上次patch包打完之后，不能在这一版基础上修复吗");
        tv_content.setText(tv_content.getText() + "\n 看来真的不行，必须拿第一版作为基础");
        tv_content.setText(tv_content.getText() + "\n 不过这样大部分情况下不发布新的包，都只需要拿第一个包做基础就行");
        tv_content.setText(tv_content.getText() + "\n 测试重命名");
    }
}

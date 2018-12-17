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
        tv_content.setText("修复了----------！！！！！");
    }
}

package tslaboratory.listview.sample.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_message);

        // Listが空の場合のviewをセットする
        listView.setEmptyView(findViewById(R.id.no_message));

        // Listの中身をセットする
        messageAdapter = new MessageAdapter(this);
        messageAdapter.addMessageList(getMessageList());
        listView.setAdapter(messageAdapter);

        // スクロールを検知するリスナー
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

                // ListViewの最後に表示されているインデックスとAdapterのmessageListの要素数が等しければ最後尾
                if(listView.getLastVisiblePosition() == (messageAdapter.getCount() - 1)){

                    // AdapterのmessageListに追加
                    messageAdapter.addMessageList(getMessageList());

                    // ListViewを更新させる
                    messageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {}
        });
    }

    // リストの中身を生成するメソッド
    // 普通はサーバーから取得するが今回はローカルで10カラム返す
    private List<Message> getMessageList(){

        List<Message> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Message message = new Message();
            message.setTitle("タイトル" + String.valueOf(i));
            message.setMessage("メッセージ" + String.valueOf(i));
            list.add(message);
        }
        return list;
    }
}

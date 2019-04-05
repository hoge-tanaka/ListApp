package tslaboratory.listview.sample.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Message> messageList = new ArrayList<>();

    public MessageAdapter(Context context){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Listの要素数を返す
    @Override
    public int getCount() {
        return messageList.size();
    }

    // i番目のオブジェクトを返す(今回は使わない)
    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    // 何か特別なIDを返したいときに使う(今回は使わない)
    @Override
    public long getItemId(int position) {
        return position;
    }

    // ListViewの1行分のレイアウトを指定する。
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.item_message, viewGroup, false);
        ((TextView) view.findViewById(R.id.text_title)).setText(messageList.get(position).getTitle());
        ((TextView) view.findViewById(R.id.text_message)).setText(messageList.get(position).getMessage());
        return view;
    }

    // messageListに追加
    public void addMessageList(List<Message> message) {
        this.messageList.addAll(message);
    }
}

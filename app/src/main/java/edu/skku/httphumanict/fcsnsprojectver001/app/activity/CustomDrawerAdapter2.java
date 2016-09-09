package edu.skku.httphumanict.fcsnsprojectver001.app.activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.skku.httphumanict.fcsnsprojectver001.R;
import edu.skku.httphumanict.fcsnsprojectver001.app.FCSNSAppManager;

/**
 * Created by say on 2016-09-09.
 */
public class CustomDrawerAdapter2 extends ArrayAdapter<noticeItem> { //공지화면 어댑터

    Context context2;
    List<noticeItem> drawerItemList2;
    int layoutResID2;

    public CustomDrawerAdapter2(Context context, int layoutResourceID, ArrayList<noticeItem> listItems) {
        super(context, layoutResourceID, listItems);
        this.context2 = context;
        this.drawerItemList2 = listItems;
        this.layoutResID2 = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        DrawerItemHolder drawerHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context2).getLayoutInflater();
            drawerHolder = new DrawerItemHolder();

            view = inflater.inflate(layoutResID2, parent, false);
            drawerHolder.ItemName = (TextView) view.findViewById(R.id.drawer_itemName2);

            view.setTag(drawerHolder);

        } else {
            drawerHolder = (DrawerItemHolder) view.getTag();
        }
        final ArrayList<String> items = new ArrayList<>();
        final ArrayAdapter notice_semiAdapter = new ArrayAdapter(FCSNSAppManager.getInstance().getRoomActivity().getApplicationContext(), R.layout.simple_item, items);
        final ListView notice_semiView = (ListView) view.findViewById(R.id.notice_drawer_listview);
        notice_semiView.setAdapter(notice_semiAdapter);
        final EditText notice_chat = (EditText)view.findViewById(R.id.notice_chat);

        Button noticeButton = (Button) view.findViewById(R.id.notice_button);
        noticeButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                items.add(notice_chat.getText().toString());
                notice_semiView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
                notice_chat.setText("");
                notice_semiAdapter.notifyDataSetChanged();
            }
        });
        noticeItem dItem = (noticeItem) this.drawerItemList2.get(position);
        drawerHolder.ItemName.setText(dItem.getItemName());
        return view;
    }

    private static class DrawerItemHolder {
        TextView ItemName;
    }
}

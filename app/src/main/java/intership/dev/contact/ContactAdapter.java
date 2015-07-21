package intership.dev.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Contact;

/**
 * Created by lenhat on 21/07/2015.
 */
public class ContactAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Contact> mContacts;

    public ContactAdapter(Context mContext, ArrayList<Contact> mContacts) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        this.mContacts = mContacts;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return mContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder mViewHolder = null;

        if (view == null) {
            view = mInflater.inflate(R.layout.item_list_people, viewGroup, false);

            mViewHolder = new ViewHolder();

            mViewHolder.imgAvatar = (CustomCircleImageView) view.findViewById(R.id.imgAvatar);
            mViewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            mViewHolder.imgEditContact = (ImageView) view.findViewById(R.id.imgEdit);
            mViewHolder.imgDeleteContact = (ImageView) view.findViewById(R.id.imgDelete);

            view.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) view.getTag();
        }

        Contact mContact = mContacts.get(i);

        mViewHolder.imgAvatar.setImageResource(mContact.getmAvatar());
        mViewHolder.tvName.setText(mContact.getmName());

        setListener(mViewHolder, mContact);

        return  view;
    }

    private void setListener(ViewHolder mViewHolder, final Contact mContact) {

        mViewHolder.imgEditContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mViewHolder.imgDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Do you want delete contact?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mContacts.remove(mContact);
                        notifyDataSetChanged();
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.create();
                builder.show();
            }
        });
    }

    private class ViewHolder {
        CustomCircleImageView imgAvatar;
        ImageView imgEditContact, imgDeleteContact;
        TextView tvName;
    }
}

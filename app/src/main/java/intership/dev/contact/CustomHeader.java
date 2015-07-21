package intership.dev.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by lenhat on 21/07/2015.
 */
public class CustomHeader extends RelativeLayout{

    private RelativeLayout rlHeader;

    private ImageView imgBack;
    private TextView tvTitle;

    LayoutInflater layoutInflater;

    public CustomHeader(Context context) {
        super(context);
        init(context);
    }

    public CustomHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        rlHeader = (RelativeLayout) layoutInflater.from(context).inflate(R.layout.custom_header,null);

        addView(rlHeader);
        imgBack = (ImageView) rlHeader.findViewById(R.id.imgBack);
        tvTitle = (TextView) rlHeader.findViewById(R.id.tvTitle);

        setListener();
    }

    private void setListener() {
        imgBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Event for button back
            }
        });
    }
}

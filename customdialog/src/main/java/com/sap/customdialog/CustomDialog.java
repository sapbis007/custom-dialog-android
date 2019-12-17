package com.sap.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

public class CustomDialog extends Dialog {

    public interface OnCustomDialogButtonClickListener {
        void onAgreeButtonClicked();
        void onDisAgreeButtonClicked();
    }

    public interface OnListCustomDialogButtonClickListener {
        void onAgreeButtonClicked(int position);
        void onDisAgreeButtonClicked(int position);
    }

    public static final int BOLD = Typeface.BOLD;
    public static final int ITALIC = Typeface.ITALIC;
    public static final int BOLD_ITALIC = Typeface.BOLD_ITALIC;
    public static final int NORMAL = Typeface.NORMAL;

    private TextView questionText;
    private Button agreeButton, disAgreeButton;
    private RelativeLayout parentLayout;
    private CardView dialogBox;
    private OnCustomDialogButtonClickListener onCustomDialogButtonClickListener;
    private OnListCustomDialogButtonClickListener onListCustomDialogButtonClickListener;
    private int position = Integer.MIN_VALUE;

    protected void setOnCustomDialogButtonClickListener(OnCustomDialogButtonClickListener onCustomDialogButtonClickListener) {
        this.onCustomDialogButtonClickListener = onCustomDialogButtonClickListener;
    }

    protected void setOnListCustomDialogButtonClickListener(OnListCustomDialogButtonClickListener onListCustomDialogButtonClickListener) {
        this.onListCustomDialogButtonClickListener = onListCustomDialogButtonClickListener;
    }

    public CustomDialog(Context context) {
        super(context);
        inflateView();
    }

    public CustomDialog(Context context, int position) {
        super(context);
        this.position = position;
        inflateView();
    }

    private void inflateView() {
        setContentView(R.layout.layout_custom_dialog);

        parentLayout = findViewById(R.id.parent_layout);
        dialogBox = findViewById(R.id.parent_card_layout);
        questionText = findViewById(R.id.question_text);
        agreeButton = findViewById(R.id.btn_agree);
        disAgreeButton = findViewById(R.id.btn_disagree);

        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( position != Integer.MIN_VALUE ) {
                    if( onListCustomDialogButtonClickListener != null )
                        onListCustomDialogButtonClickListener.onAgreeButtonClicked(position);
                } else {
                    if( onCustomDialogButtonClickListener != null )
                        onCustomDialogButtonClickListener.onAgreeButtonClicked();
                }
            }
        });

        disAgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( position != Integer.MIN_VALUE ) {
                    if( onListCustomDialogButtonClickListener != null )
                        onListCustomDialogButtonClickListener.onDisAgreeButtonClicked(position);
                } else {
                    if( onCustomDialogButtonClickListener != null )
                        onCustomDialogButtonClickListener.onDisAgreeButtonClicked();
                }
            }
        });

        parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /** Setting Question Text **/

    protected void setQuestionText( String text ) {
        this.questionText.setText(text);
    }

    protected void setQuestionTextColor( String color ) {
        this.questionText.setTextColor(Color.parseColor(color));
    }

    protected void setQuestionTextColor( int color ) {
        this.questionText.setTextColor(color);
    }

    protected void setQuestionTextSize(float textSize) {
        this.questionText.setTextSize(textSize);
    }

    protected void setQuestionTextFont(String fontPath) {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), fontPath);
        this.questionText.setTypeface(font);
    }

    protected void setQuestionTextStyle(int style) {
        this.questionText.setTypeface(this.questionText.getTypeface(), style);
    }

    /** Setting Disagree Button **/

    protected void setDisagreeButtonText( String text ) {
        this.disAgreeButton.setText(text);
    }

    protected void setDisagreeButtonTextColor( String color ) {
        this.disAgreeButton.setTextColor(Color.parseColor(color));
    }

    protected void setDisagreeButtonTextColor( int color ) {
        this.disAgreeButton.setTextColor(color);
    }

    protected void setDisagreeButtonBg( String color ) {
        this.disAgreeButton.setBackgroundColor(Color.parseColor(color));
    }

    protected void setDisagreeButtonBg( int color ) {
        this.disAgreeButton.setBackgroundColor(color);
    }

    protected void setDisagreeButtonBg( Drawable drawable ) {
        this.disAgreeButton.setBackground(drawable);
    }

    protected void setDisagreeButtonTextSize(float textSize) {
        this.disAgreeButton.setTextSize(textSize);
    }

    protected void setDisagreeButtonFont(String fontPath) {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), fontPath);
        this.disAgreeButton.setTypeface(font);
    }

    protected void setDisagreeButtonTextStyle(int style) {
        this.disAgreeButton.setTypeface(this.questionText.getTypeface(), style);
    }

    /** Setting Agree Button **/

    protected void setAgreeButtonText( String text ) {
        this.agreeButton.setText(text);
    }

    protected void setAgreeButtonTextColor( String color ) {
        this.agreeButton.setTextColor(Color.parseColor(color));
    }

    protected void setAgreeButtonTextColor( int color ) {
        this.agreeButton.setTextColor(color);
    }

    public void setAgreeButtonBg( String color ) {
        this.agreeButton.setBackgroundColor(Color.parseColor(color));
    }

    protected void setAgreeButtonBg( int color ) {
        this.agreeButton.setBackgroundColor(color);
    }

    protected void setAgreeButtonBg( Drawable drawable ) {
        this.agreeButton.setBackground(drawable);
    }

    protected void setAgreeButtonTextSize(float textSize) {
        this.agreeButton.setTextSize(textSize);
    }

    protected void setAgreeButtonFont(String fontPath) {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), fontPath);
        this.agreeButton.setTypeface(font);
    }

    protected void setAgreeButtonTextStyle(int style) {
        this.agreeButton.setTypeface(this.questionText.getTypeface(), style);
    }

    /** Setting Background **/

    protected void setDialogBg( String color ) {
        this.dialogBox.setBackgroundColor(Color.parseColor(color));
    }

    protected void setDialogBg( int color ) {
        this.dialogBox.setBackgroundColor(color);
    }

    protected void setDialogBg( Drawable drawable ) {
        this.dialogBox.setBackground(drawable);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void setDialogElevation(float elevation) {
        this.dialogBox.setElevation(elevation);
    }

    protected void setDialogCornerRadius(float radius) {
        this.dialogBox.setRadius(radius);
    }
}

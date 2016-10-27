package cn.bluemobi.dylan;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Android自定义标题栏
 * Created by yuandl on 2016-10-27.
 */

public class CustomTitleBar extends LinearLayout {
    /**
     * 标题栏的根布局
     */
    private LinearLayout ll;
    /**
     * 标题栏的左边按返回按钮
     */
    private TextView left_button;
    /**
     * 标题栏的右边按保存按钮
     */
    private TextView right_button;
    /**
     * 标题栏的中间的文字
     */
    private TextView title;
    /**
     * 标题栏的背景颜色
     */
    private int title_background_color;
    /**
     * 标题栏的显示的标题文字
     */
    private String title_text;
    /**
     * 标题栏的显示的标题文字颜色
     */
    private int title_textColor;
    /**
     * 标题栏的显示的标题文字大小
     */
    private int title_textSize;


    /**
     * 返回按钮的资源图片
     */
    private int left_button_imageId;
    /**
     * 返回按钮上显示的文字
     */
    private String left_button_text;
    /**
     * 返回按钮上显示的文字颜色
     */
    private int left_button_textColor;
    /**
     * 返回按钮上显示的文字大小
     */
    private int left_button_textSize;
    /**
     * 是否显示返回按钮
     */
    private boolean show_left_button;


    /**
     * 右边保存按钮的资源图片
     */
    private int right_button_imageId;
    /**
     * 右边保存按钮的文字
     */
    private String right_button_text;
    /**
     * 右边保存按钮的文字颜色
     */
    private int right_button_textColor;
    /**
     * 右边保存按钮的文字大小
     */
    private int right_button_textSize;
    /**
     * 是否显示右边保存按钮
     */
    private boolean show_right_button;

    /**
     * 标题的点击事件
     */
    private TitleOnClickListener titleOnClickListener;

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.pub_titlebar, this, true);
        ll = (LinearLayout) findViewById(R.id.ll);
        left_button = (TextView) findViewById(R.id.left_button);
        right_button = (TextView) findViewById(R.id.right_button);
        title = (TextView) findViewById(R.id.title);

        /**获取属性值*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
        /**标题相关*/
        title_background_color = typedArray.getColor(R.styleable.CustomTitleBar_title_background, Color.WHITE);
        title_text = typedArray.getString(R.styleable.CustomTitleBar_title_text);
        title_textColor = typedArray.getColor(R.styleable.CustomTitleBar_title_textColor, Color.BLACK);
        title_textSize = typedArray.getColor(R.styleable.CustomTitleBar_title_textSize, 22);
        /**返回按钮相关*/
        left_button_imageId = typedArray.getResourceId(R.styleable.CustomTitleBar_left_button_image, R.mipmap.arrow_left);
        left_button_text = typedArray.getString(R.styleable.CustomTitleBar_left_button_text);
        left_button_textColor = typedArray.getColor(R.styleable.CustomTitleBar_left_button_textColor, Color.WHITE);
        left_button_textSize = typedArray.getColor(R.styleable.CustomTitleBar_left_button_textSize, 20);
        show_left_button = typedArray.getBoolean(R.styleable.CustomTitleBar_show_left_button, true);
        /**右边保存按钮相关*/
        right_button_imageId = typedArray.getResourceId(R.styleable.CustomTitleBar_right_button_image, 0);
        right_button_text = typedArray.getString(R.styleable.CustomTitleBar_right_button_text);
        right_button_textColor = typedArray.getColor(R.styleable.CustomTitleBar_right_button_textColor, Color.WHITE);
        right_button_textSize = typedArray.getColor(R.styleable.CustomTitleBar_right_button_textSize, 20);
        show_right_button = typedArray.getBoolean(R.styleable.CustomTitleBar_show_right_button, true);
        /**设置值*/

        setTitle_background_color(title_background_color);
        setTitle_text(title_text);
        setTitle_textSize(title_textSize);
        setTitle_textColor(title_textColor);
        setShow_left_button(show_left_button);
        setShow_right_button(show_right_button);
        if (!TextUtils.isEmpty(left_button_text)) {//返回按钮显示为文字
            setLeft_button_text(left_button_text);
            setLeft_button_textColor(left_button_textColor);
            setLeft_button_textSize(left_button_textSize);
        } else {
            setLeft_button_imageId(left_button_imageId);
        }

        if (!TextUtils.isEmpty(right_button_text)) {//返回按钮显示为文字
            setRight_button_text(right_button_text);
            setRight_button_textColor(right_button_textColor);
            setRight_button_textSize(right_button_textSize);
        } else {
            setRight_button_imageId(right_button_imageId);
        }
        left_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleOnClickListener != null) {
                    titleOnClickListener.onLeftClick();
                }
            }
        });
        right_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleOnClickListener != null) {
                    titleOnClickListener.onRightClick();
                }
            }
        });
    }

    /**
     * 获取左边的返回按钮
     *
     * @return Button
     */
    public TextView getLeft_button() {
        return left_button;
    }

    /**
     * 获取标题栏的跟布局
     *
     * @return LinearLayout
     */
    public LinearLayout getLl() {
        return ll;
    }

    /**
     * 获取标题栏标题TextView
     *
     * @return TextView
     */
    public TextView getTitle() {
        return title;
    }

    /**
     * 获取右边的保存按钮
     *
     * @return Button
     */
    public TextView getRight_button() {
        return right_button;
    }

    /**
     * 设置返回按钮的资源图片id
     *
     * @param left_button_imageId 资源图片id
     */
    public void setLeft_button_imageId(int left_button_imageId) {
        left_button.setBackgroundResource(left_button_imageId);
    }

    /**
     * 设置返回按钮的文字
     *
     * @param left_button_text
     */
    public void setLeft_button_text(String left_button_text) {
        left_button.setText(left_button_text);
    }

    /**
     * 设置返回按钮的文字颜色
     *
     * @param left_button_textColor
     */
    public void setLeft_button_textColor(int left_button_textColor) {
        left_button.setTextColor(left_button_textColor);
    }

    /**
     * 设置返回按钮的文字大小
     *
     * @param left_button_textSize
     */
    public void setLeft_button_textSize(int left_button_textSize) {
        left_button.setTextSize(left_button_textSize);
    }

    /**
     * 设置是否显示返回按钮
     *
     * @param show_left_button
     */
    public void setShow_left_button(boolean show_left_button) {
        left_button.setVisibility(show_left_button ? VISIBLE : INVISIBLE);
    }


    /**
     * 设置右边保存按钮的资源图片
     *
     * @param right_button_imageId
     */
    public void setRight_button_imageId(int right_button_imageId) {
        right_button.setBackgroundResource(right_button_imageId);
    }

    /**
     * 设置右边的保存按钮的文字
     *
     * @param right_button_text
     */
    public void setRight_button_text(String right_button_text) {
        right_button.setText(right_button_text);
    }

    /**
     * 设置右边保存按钮的文字颜色
     *
     * @param right_button_textColor
     */
    public void setRight_button_textColor(int right_button_textColor) {
        right_button.setTextColor(right_button_textColor);
    }

    /**
     * 设置右边保存按钮的文字大小
     *
     * @param right_button_textSize
     */
    public void setRight_button_textSize(int right_button_textSize) {
        right_button.setTextSize(right_button_textSize);
    }

    /**
     * 设置是显示右边保存按钮
     *
     * @param show_right_button
     */
    public void setShow_right_button(boolean show_right_button) {
        right_button.setVisibility(show_right_button ? VISIBLE : INVISIBLE);
    }


    /**
     * 设置标题背景的颜色
     *
     * @param title_background_color
     */
    public void setTitle_background_color(int title_background_color) {
        ll.setBackgroundColor(title_background_color);
    }

    /**
     * 设置标题的文字
     *
     * @param title_text
     */
    public void setTitle_text(String title_text) {
        title.setText(title_text);
    }

    /**
     * 设置标题的文字颜色
     *
     * @param title_textColor
     */
    public void setTitle_textColor(int title_textColor) {
        title.setTextColor(title_textColor);
    }

    /**
     * 设置标题的文字大小
     *
     * @param title_textSize
     */
    public void setTitle_textSize(int title_textSize) {
        title.setTextSize(title_textSize);
    }


    /**
     * 设置标题的点击监听
     *
     * @param titleOnClickListener
     */
    public void setOnTitleClickListener(TitleOnClickListener titleOnClickListener) {
        this.titleOnClickListener = titleOnClickListener;
    }

    /**
     * 监听标题点击接口
     */
    public interface TitleOnClickListener {
        /**
         * 返回按钮的点击事件
         */
        void onLeftClick();

        /**
         * 保存按钮的点击事件
         */
        void onRightClick();

    }
}

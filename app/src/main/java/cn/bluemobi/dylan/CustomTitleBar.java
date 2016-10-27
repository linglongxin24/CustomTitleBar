package cn.bluemobi.dylan;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Android自定义标题栏
 * Created by yuandl on 2016-10-27.
 */

public class CustomTitleBar extends RelativeLayout {
    /**
     * 标题栏的根布局
     */
    private LinearLayout ll;
    /**
     * 标题栏的左边按返回按钮
     */
    private Button left_button;
    /**
     * 标题栏的右边按保存按钮
     */
    private Button right_button;
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

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.pub_titlebar, this, true);
        ll = (LinearLayout) findViewById(R.id.ll);
        left_button = (Button) findViewById(R.id.left_button);
        right_button = (Button) findViewById(R.id.right_button);
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
        /**右边保存按钮相关*/
        right_button_imageId = typedArray.getResourceId(R.styleable.CustomTitleBar_right_button_image, 0);
        right_button_text = typedArray.getString(R.styleable.CustomTitleBar_right_button_text);
        right_button_textColor = typedArray.getColor(R.styleable.CustomTitleBar_right_button_textColor, Color.WHITE);
        right_button_textSize = typedArray.getColor(R.styleable.CustomTitleBar_right_button_textSize, 20);
        /**设置值*/

        setTitle_background_color(title_background_color);
        setTitle_text(title_text);
        setTitle_textSize(title_textSize);
        setTitle_textColor(title_textColor);

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

    }

    /**
     * 获取左边的返回按钮
     *
     * @return Button
     */
    public Button getLeft_button() {
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
    public Button getRight_button() {
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
}

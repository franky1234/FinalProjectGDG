package cel.franklin.com.textmanipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public static String LOG_MAIN = MainActivity.class.getSimpleName();
    public float currentDefaultSize;
    public float defaultSize;
    public EditText textEditor;
    public boolean STATE_COLOR_TEXT = true;
    public boolean STATE_COLOR_BACKGROUND = true;
    public String TITLE_BAR = "<font color='#000000'>S[m]T</font>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml(TITLE_BAR));//changing color title
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        fillButtonsHalfMatchParent(width);//resize the button on the size of screen
        textEditor = (EditText) findViewById(R.id.edit_text);
        currentDefaultSize = textEditor.getTextSize();
        defaultSize = currentDefaultSize;
    }

    /**
     * This method Resize all buttons in five equivalent which is give for us.
     *
     * @param width is the with of the screen .
     */
    public void fillButtonsHalfMatchParent(int width) {
        int NUMBER_OF_BUTTONS = 5;
        float PERCENT_OF_BUTOONS = 0.2f;
        LinearLayout layoutButtons = (LinearLayout) findViewById(R.id.buttons_layout);

        for (int i = 0; i < layoutButtons.getChildCount(); ++i) {
            View myView = layoutButtons.getChildAt(i);

            if (myView instanceof Button) {
                Button myButton = (Button) findViewById(myView.getId());
                ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) findViewById(R.id.buttons_layout).getLayoutParams();
                assert myButton != null;
                myButton.setLayoutParams(new LinearLayout.LayoutParams(width / NUMBER_OF_BUTTONS, params.height, PERCENT_OF_BUTOONS));
            } else {
                Log.v(LOG_MAIN, "This not a button");
            }
        }
    }

    /**
     * this Method change the position of text to left and its by default alignment.
     */
    public void setTextLeft(View view) {
        setAlignment(Gravity.LEFT);
    }

    /**
     * this Method change the position of text to right alignment.
     */
    public void setTextRight(View view) {
        setAlignment(Gravity.RIGHT);
    }

    /**
     * this Method change the position of text to center horizontal alignment.
     */
    public void setTextCenter(View view) {
        setAlignment(Gravity.CENTER_HORIZONTAL);
    }

    /**
     * this method change the alignment given an parameter of Gravity.
     *
     * @param alignment which is give for gravity properties.
     */
    public void setAlignment(int alignment) {
        textEditor.setGravity(alignment);
    }

    /**
     * this method increase the size text in one.
     */
    public void upTextSize(View view) {
        textEditor.setTextSize(++currentDefaultSize);
    }

    /**
     * this method decrease the size text in one.
     */
    public void downTextSize(View view) {
        textEditor.setTextSize(--currentDefaultSize);
    }

    /**
     * this method change the Color of text black = false , white = true
     */
    public void changeColorText(View view) {
        if (STATE_COLOR_TEXT) {
            STATE_COLOR_TEXT = false;
            textEditor.setTextColor(getResources().getColor(R.color.white_color));
        } else {
            STATE_COLOR_TEXT = true;
            textEditor.setTextColor(getResources().getColor(R.color.black_color));
        }
    }

    /**
     * this method change the Background Color  black = false , white = true
     */
    public void changeBackGroundColor(View view) {
        if (STATE_COLOR_BACKGROUND) {
            STATE_COLOR_BACKGROUND = false;
            textEditor.setBackgroundColor(getResources().getColor(R.color.black_color));
        } else {
            STATE_COLOR_BACKGROUND = true;
            textEditor.setBackgroundColor(getResources().getColor(R.color.white_color));
        }
    }

    /**
     * This method reset by Default values in Text Editor.
     */
    public void resetValues(View view) {
        textEditor.setBackgroundColor(getResources().getColor(R.color.lightBlack));
        textEditor.setTextSize(defaultSize);
        setAlignment(Gravity.LEFT);
        textEditor.setTextColor(getResources().getColor(R.color.black_color));
        textEditor.setText("");
    }
}

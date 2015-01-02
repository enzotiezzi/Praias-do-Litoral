package Utils;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by enzo on 23/12/2014.
 */
public class UtilShowInformation
{
    public static void showInformation(Context _context, String _title, String _message)
    {
        AlertDialog.Builder _alert = new AlertDialog.Builder(_context);
        _alert.setTitle(_title);
        _alert.setMessage(_message);
        _alert.setNeutralButton("OK", null);
        _alert.show();
    }
}

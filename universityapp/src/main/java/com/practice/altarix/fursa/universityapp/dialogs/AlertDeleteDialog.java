package com.practice.altarix.fursa.universityapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.dto.DbManager;


public class AlertDeleteDialog extends DialogFragment {
    private DbManager dbManager;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.attention);
        builder.setIcon(R.mipmap.icon);
        builder.setMessage(R.string.alert_delete_message);
        builder.setPositiveButton(R.string.CONTUNUE, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbManager = new DbManager();
                dbManager.deleteAll(getActivity());
                Toast.makeText(getActivity(), "Бд очищена!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.CANCEL, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return builder.create();
    }
}

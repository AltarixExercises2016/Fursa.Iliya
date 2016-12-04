package com.practice.altarix.fursa.universityapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;

import com.practice.altarix.fursa.universityapp.R;

import java.util.zip.Inflater;

/**
 * Created by xxx on 04.12.16.
 */

public class InfoDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_info);
        builder.setMessage(R.string.dialog_about)
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();

    }


}

package com.example.paulbonenfant.sqliteexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;



import com.example.paulbonenfant.sqliteexample.model.Student;


public class MainActivity extends Activity {

    // set up data fields
    EditText edtName;
    EditText edtEmail;
    CheckBox chkFullTime;
    ListView lstDisplay;
    RadioButton radByName;
    Button save;
    // Enum to know if we're displaying or deleting
    enum Mode {
        MODE_DISPLAY,
        MODE_DELETE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize data fields
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        chkFullTime = (CheckBox) findViewById(R.id.chkFullTime);
        lstDisplay = (ListView) findViewById(R.id.lstDisplay);
        radByName = (RadioButton) findViewById(R.id.radByName);
        save = findViewById(R.id.save_button);

    }
    public void save(View view){

    }


    /**
     * Method to create an instance of Student from what user entered
     *
     * @return the created Student
     */
    private Student loadStudent() {

        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        boolean fullTime = chkFullTime.isChecked();

        return new Student(name, email, fullTime);
    }

    public void show(View view) {
        if (radByName.isChecked()) {
            // we're also using the method for deleting...
            getNameFromUser(Mode.MODE_DISPLAY);
        } else {
            displayStudents(null);
        }
    }

    /**
     * Displays student records from the database
     * @param name the name to match for displaying students. If null or
     *             empty String is passed in then all records are displayed
     */
    private void displayStudents(String name) {


    }

    /**
     * Helper method to get an input from the user. Used for both displaying and
     * deleting specific records
     * @param mode either MODE_DISPLAY or MODE_DELETE
     */
    private void getNameFromUser(final Mode mode) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final EditText edtInput = new EditText(this);
        edtInput.setHint("Name");
        builder.setView(edtInput)
                .setTitle("Enter Name to search for")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edtInput.getText().toString();
                        if (mode == Mode.MODE_DISPLAY) {
                            displayStudents(name);
                        } else {
                            deleteStudents(name);
                        }

                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }


    public void delete(View view) {
        if (radByName.isChecked()) {
            // we're also using the method for displaying...
            getNameFromUser(Mode.MODE_DELETE);
        } else {
            deleteStudents(null);
        }
    }

    /**
     * Deletes student records from the database.
     * @param name the student records to delete by name. If null or
     *             empty String is passed in then all records are deleted
     */
    private void deleteStudents(String name) {


    }
} // end of MainActivity class



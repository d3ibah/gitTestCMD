package by.testsqlite1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import by.testsqlite1.data.HotelContract;

public class EditorActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText cityEditText;
    private EditText ageEditText;

    private Spinner genderSpinner;
    private int gender = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        nameEditText = findViewById(R.id.edit_guest_name);
        cityEditText = findViewById(R.id.edit_guest_city);
        ageEditText = findViewById(R.id.edit_guest_age);
        genderSpinner = findViewById(R.id.spinner_gender);

        setupSpinner();
    }

    private void setupSpinner() {

        ArrayAdapter genderSpinnerAdapter = ArrayAdapter
                .createFromResource(this, R.array.array_gender_options, android.R.layout.simple_spinner_item);
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        genderSpinner.setAdapter(genderSpinnerAdapter);
        genderSpinner.setSelection(2);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)){
                    if (selection.equals(getString(R.string.gender_female))){
                        gender = HotelContract.GuestEntry.GENDER_FEMALE; // koshka
                    } else if (selection.equals(getString(R.string.gender_male))){
                        gender = HotelContract.GuestEntry.GENDER_MALE; // kot
                    } else {
                        gender = HotelContract.GuestEntry.GENDER_UNKNOWN; // ne opredelen
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = HotelContract.GuestEntry.GENDER_UNKNOWN; // pol ne opredelen
            }
        });
    }
}

package com.example.cal_mvp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cal_mvp.R;
import com.example.cal_mvp.interfaces.OperationPresenter;
import com.example.cal_mvp.interfaces.OperationView;
import com.example.cal_mvp.presenters.OperationPresenterImpl;

public class OperationActivyView extends AppCompatActivity implements OperationView {

    private EditText nunber1;
    private EditText nunber2;
    private TextView txtResult;
    private OperationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activy_operation);


        nunber1 = findViewById(R.id.txtNumber1);
        nunber2 = findViewById(R.id.txtNumber2);
        txtResult = findViewById(R.id.txtResult);
        presenter = new OperationPresenterImpl(this);

    }


    public void doAdd(View view) {
        try {
            int nun1 = Integer.parseInt(nunber1.getText().toString());
            int nun2 = Integer.parseInt(nunber2.getText().toString());
            presenter.add(nun1, nun2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doMultiply(View view) {
        try {
            int nun1 = Integer.parseInt(nunber1.getText().toString());
            int nun2 = Integer.parseInt(nunber2.getText().toString());
            presenter.multiply(nun1, nun2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }

    public void doDive(View view) {
        try {
            int nun1 = Integer.parseInt(nunber1.getText().toString());
            int nun2 = Integer.parseInt(nunber2.getText().toString());
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }


    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "operazione non valida ", Toast.LENGTH_LONG).show();

    }
}
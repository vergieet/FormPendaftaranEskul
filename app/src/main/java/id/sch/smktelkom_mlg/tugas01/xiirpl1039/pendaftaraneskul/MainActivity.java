package id.sch.smktelkom_mlg.tugas01.xiirpl1039.pendaftaraneskul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etEmail;
    Button proses;
    TextView textNama;
    TextView textEmail;
    TextView textKelas;
    TextView textJenis;
    TextView textHobi;
    TextView textPenjelasan;
    TextView trims;
    TextView telreg;
    RadioButton rbLK , rbPR;
    Spinner spKelas;
    CheckBox cbBAS,cbBER,cbMEN,cbMEM,cbMUS,cbFUS;
    String hobi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama  = (EditText) findViewById(R.id.edNama);
        etEmail = (EditText) findViewById(R.id.edEmail);
        proses = (Button) findViewById(R.id.button);
        textNama = (TextView) findViewById(R.id.Tnama);
        textEmail = (TextView) findViewById(R.id.Temail);
        textHobi = (TextView) findViewById(R.id.Thobi);
        textJenis = (TextView) findViewById(R.id.Tjeniskelamin);
        textKelas = (TextView) findViewById(R.id.Tkelas);
        textPenjelasan = (TextView) findViewById(R.id.Tpenjelasan);

        trims = (TextView) findViewById(R.id.Tjeniskelamin);
        telreg = (TextView) findViewById(R.id.Tkelas);

        rbLK = (RadioButton) findViewById(R.id.rblk);
        rbPR = (RadioButton) findViewById(R.id.rbpr);
        spKelas = (Spinner) findViewById(R.id.spkelas);

        cbBAS = (CheckBox) findViewById(R.id.cbBA);
        cbBER = (CheckBox) findViewById(R.id.cbBE);
        cbFUS = (CheckBox) findViewById(R.id.cbFU);
        cbMEM = (CheckBox) findViewById(R.id.cbME);
        cbMEN = (CheckBox) findViewById(R.id.cbMEN);
        cbMUS = (CheckBox) findViewById(R.id.cbMU);
        trims.setVisibility(View.INVISIBLE);
        telreg.setVisibility(View.INVISIBLE);
        textPenjelasan.setVisibility(View.INVISIBLE);
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(isValid()){
              trims.setText("ISILAH DATA ANDA DENGAN BENAR");
                  trims.setVisibility(View.VISIBLE);
              }else{
                  trims.setText("TERIMA KASIH !!!");
                  trims.setVisibility(View.VISIBLE);
                  telreg.setVisibility(View.VISIBLE);
                  textPenjelasan.setVisibility(View.VISIBLE);
             textNama.setText("Nama : " + etNama.getText().toString());
             textEmail.setText("Email : " + etEmail.getText().toString());

                if(rbLK.isChecked()){
                textJenis.setText("Jenis Kelamin : " + rbLK.getText().toString());
                }else if (rbPR.isChecked()){
                textJenis.setText("Jenis Kelamin : " + rbPR.getText().toString());
                }
            textKelas.setText("Kelas : " + spKelas.getSelectedItem().toString());

                  if(cbBAS.isChecked()){hobi+="> " + cbBAS.getText().toString() + "\n";}
                  if(cbFUS.isChecked()){hobi+="> " + cbFUS.getText().toString() + "\n";}
                  if(cbBER.isChecked()){hobi+="> " + cbBER.getText().toString() + "\n";}
                  if(cbMEM.isChecked()){hobi+="> " + cbMEM.getText().toString() + "\n";}
                  if(cbMUS.isChecked()){hobi+="> " + cbMUS.getText().toString() + "\n";}
                  if(cbMEN.isChecked()){hobi+="> " + cbMEN.getText().toString();}
                  textHobi.setText("Hobi : \n" + hobi);
            textPenjelasan.setText("Hasil Penerimaan Akan Dikirimkan Ke Email Anda (" + textEmail.getText() + ")");
            }}
        });
    }

    private boolean isValid() {
        boolean valid = true;
        if(etNama.getText().toString().isEmpty()){
            etNama.setError("Nama Belum Diisi");
            valid = false;
        }else if (etNama.getText().toString().length()<3){
            etNama.setError("Nama Harus Lebih Dari 3");
            valid = false;
        }else{
            etNama.setError(null);
        }
        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("Email Belum Diisi");
            valid = false;
        }else{
            etEmail.setError(null);
        }
        return valid;
    }
//etEmail.getText().toString() == "" && etNama.getText().toString() == "" && spKelas.getSelectedItem().toString() == "Pilih Kelas Anda"
}

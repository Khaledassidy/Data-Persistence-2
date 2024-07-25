package com.example.datapersistance2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
haw toro2 l tnene le shofnehoun l file bekoun sebet ma berou7 ela iza l application n3amlo delete 2aw rou7t 3ala setting 3al app 3mlt clear data fe no3 tene esmo temporary file l malaf le bekoun bel cashe malaf mo2kat law l operating system 7tej la mase7a zyede berou7 la7alo byem7e bedoun ma ye7kelak ana bade 2a3melo delete

bel 3ade byesta3mal la 3amlyet l cashing metl lama tefta7 application l facebook ykoun fe internet ba3den yrou7 l internet w teje tefta7o 2am tle2e l post mawjoude w l sowar mawjoude kel haw l eshya ba3da mawjoude mnsameha cashing ya3ne m5zane bel cashe ta3el l mobile
 w kamen men la7ez eno iza rej3 fata7t l facebook w keen mawjoude fe l files mawjoude fe l post w sowar w ro7t ba3d heek fat7t le3be a5det mn l memory w mn l storage she kbeer rje3t fata7t l facebook 7a tle2e l data le kenet bel cashe ra7et l2no l operating system 7tej data zyede fa la wa7do ra7 3mel delete la haw l file le 5asa bel cashe bala ma ye7kelak metl sha8le eno ana fat7t isnta rje3t tel3t meno w fata7t eshya kteer w bas rje3telo la2et eno 3mlt refresh w rje3 ra7 ma7al ma kent fete7

 le bey5tlef houn  bel implementation esm l folder mesh getfiledir() heda 5aso bel internal storage

ne7na 3ana bel internal strorage mojalden mojalad 5as bel internal stroage bel mojldet de2me w mojalad 5as bel chashe bel mojalated l mo2akate
ya3ne zekra de5leye l internal storage 3teber feha ma7len maken lal mojaladet l mo2akate w maken lal mojaldet l de2me


esm l file le 5as bel cashe bel mojladet l mo2akte esmo getCasheDir();



iza badak tem7e l file feek ta3mel f.delete();



iza bel interanl storage metl toro2 l 2awlanye bta3mel deleteFile(FILE_NAME); hay bas btem7elak l file mn zekra de5leye btrje3lak true iza 3mlet delete w false iza la2





 */








public class INTERNAL_STORAGE_TEMPORARY extends AppCompatActivity {

    public final static String FILE_NAME="KHALED";

    EditText name,pass,birth;
    Button save,read;
    String name_user, pass_user,birth_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_temporary);
        name=findViewById(R.id.editTextText4);
        pass=findViewById(R.id.editTextText5);
        birth=findViewById(R.id.editTextText6);
        save=findViewById(R.id.button_save1);
        read=findViewById(R.id.button_read1);

        save.setOnClickListener(v->{
            name_user=name.getText().toString();
            pass_user=pass.getText().toString();
            birth_user=birth.getText().toString();
            try {
                File f=new File(getCacheDir(),FILE_NAME);
                if(!f.exists()){
                    f.createNewFile();

                }
                FileOutputStream fos= new FileOutputStream(f,true);
                PrintWriter pw=new PrintWriter(fos);
                pw.println(name_user+" "+pass_user+" "+birth_user);
                pw.close();;
                fos.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });


        read.setOnClickListener(v->{
            try {
                File f=new File(getCacheDir(),FILE_NAME);
                FileInputStream fis= new FileInputStream(f);
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                String alltext="";
                String temp="";
                while ((temp=br.readLine())!=null){
                    alltext+=temp;
                }
                br.close();
                isr.close();
                fis.close();
                Toast.makeText(this, ""+alltext, Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }


        });


    }

    }

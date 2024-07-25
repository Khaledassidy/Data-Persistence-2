package com.example.datapersistance2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*
TARE2A TENYE:
hala2 ne7na 3refna eno openfileoutput bta3mel sha8lten l2ola iza l file mesh mawjoud be23rebar hay 2awl mara btektob 3a malaf btenshe2 l mlaf w btraje3 l stream l 5as feh
fa badel ma 2a3ml hay l 7arake FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
ba3mel fe class 3ana esmo File be3ber 3an file 2aw folder bta3mel file jdeed File f=new File() houn badak t2olo sho l ma7al l file le badak t5azno feh ana l mafroud bade 5azno bel internal storage zekra de5leye w 2abl shway 2olna iza badna nosal lal folder ta3el l zekra de5le fe 3ande function esma getFileDir() 2awl parameter tene parameter bta3te esm l file le bado y7oto bel internal storage FILE_NAME
File f=new File(getFilesDir(),FILE_NAME);

ba3den bta3mel FileOutputStream fos=FileOutputStream(f); w bta3te l file ya3ne l far2 badel ma testa3mel l method jehze la2 3mlt l file b2edak
fa houn feek ta3mel iza l file mano mawjoud 3meel file jdeed:if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
ba3den bta3mel l fileoutputstream:try {
            FileOutputStream fos= new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        w l be2e nafs she 3meel l 3amlye write

 File f=new File(getFilesDir(),FILE_NAME);:houn le 3mlto eno aansh2t mo2sher 3ala l file eno mawjoud bel getfiledir() bel zekra de5leye w esmo khaled law mawjoud l file 5als kamel 3ande iza la2 mano mawjoud ensh2o lal file w ba3den 3mell mo2sher 3al stream ta3elo w kamel 3ade




w 3ande sha8le 7elwe bel FileOutputStream fos= new FileOutputStream(f,true); eno tene argument append true 3ashen lama tseer ta3mel println yseer ydeflak l bayenet le enta bt7ota 3ala l file ya3ne law fee kaza println bseer be7otoun 7ed ba3d l2no iza false bseer bema7e le kont ketbo w bya3mel 3lee overwrite ama houn la n2ol 3mlt println("khaled) rje3t 3mlt println("Assidi") fa 7a yetla3lk khaled assidi l2no true ama law false keen 3atoul tal3lk e5er wa7de pritln assidi
appeand ma3neta damj eno yedmejlk l adem ma3 l jdeed eno ma yel8e l nous l adem la2 yedmjo ma3 l addem ama metl abl shway keen bya3mel 3ala le ketbo overide byem7e w byektob badelo l jdeed


haw toro2 l tnene le shofnehoun l file bekoun sebet ma berou7 ela iza l application n3amlo delete 2aw rou7t 3ala setting 3al app 3mlt clear data fe no3 tene esmo temporary file



*/






public class INTERNAL_STORAGE_NUMBER_TWO extends AppCompatActivity {

    public final static String FILE_NAME="KHALED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_number_two);

        try {
            File f=new File(getFilesDir(),FILE_NAME);
            if(!f.exists()){
                f.createNewFile();

            }
            FileOutputStream fos= new FileOutputStream(f,true);
            PrintWriter pw=new PrintWriter(fos);
            pw.println("khaled");
            pw.println("Assidi");
            pw.close();;
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
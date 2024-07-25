
package com.example.datapersistance2;

import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*

hala2 iza bade sayef file 2aw soura 2aw she bel external storage l 5asa l mawdo3 sahl sha8le wa7de bterfere2 bas ta3eml file enta ma bet7ot ween badak tsayef l file kouna n2ol iza l external storage l 3ame esma enviroments.getexternalStoragePublicDirectory()
ama iza kenet 5asa le btefere2 l esm eno bala public :Environment.getExternalStorageDirectory hay l method betraje3lk l file l 5as bel external storage l 5asa le heye 5asa bel application ama le abl shway btraj3lk l 3ame

sho l far2 baynetoun:
l3ame:externalstoragepublic hay lal kol law 3melt delete lal application unistall l file le b2alba bedalo metl iza 7azft l facebook sowar le jeyeba meno bedala bel gallary
l5asa:law enta 3mlt unstall lal app kel le feha byen7ezef ma3a a7yenan betle2e metl application ta3del sowar w 8ayro iza 7azft l application kel data le feha btene7zef ya3ne bekoun feha sowar met3le2 feha bel gallary betle2eha n7azafet ma3a bekoun fe malefet bel downloads n7azafet ma3a hay bekoun m sayave 3al zekra l 5arejeye l 5asa bekoun l programmer 3ando hadaf eno ma bado hay data dal la momsta5dem ba3d ma ya3mel delete lal application bado yeha trou7 bas l application yen3mala unstall fa bye7zefa 2aw be3refa eno 5asa

metl l 3ade fe toro2 tenye feek tosal lal zekra l 5arejeye mn 5elel l methods:
l methods hawde bte2dar tet3mal ma3oun ba3d l android version 4.4 ama abl 4.4 keen fe method b2lb l contextCompat.getexternalcashedir()..etc
getExternalChachedir():hay betrj3lk l directory ta3el l external storage l 5as bel cashe metl ma fe malefet mo2akate lal zekra de5leye fe malafet mo2kate lal zekra l 5arejeye
getExternalChachedirs():hay btrj3lak array of files btrjalk array feha kel l files l b2lab l external storage l 5asa bel chashe
getexternalifileDir(String type):hay bta3teha esm l file le b2alb l external storage directory  btraj3lk l file le heda l esm
getexternalfiledirs(Sting type):hay n2ol 3ana file feha b2labo kaza file fa bt3teha esm l file l kbeer le fe b2lbo kel filet btrje3lk array of file b2lbo kel she filet le mawjouden de5el heda l file l kbeer
getExternalMediaDirs():hay btrje3lk array of file b2alb l external storage ma7al ma fe media btrj3lk array of file feh kel l media file

hawde l method tnaynetoun le zekra l 5erjeye l 5asa kel hawde l method l get houn zekra 5asa
getexternalfiledir(Sting type):
context.compat.getexternalcashedirs


enta 5oda ka3ede kel l method le mar2o ma3na kena 3am nosala mn 5elel l get 2aw l contextcompat metl l getcashe directory w hade keloun 5asa ya3ne teb3a lal aplication  fe she bas external fe she internal










*/














public class EXTERNAL_STORAGE_PRIVATE extends AppCompatActivity {

    public static final String FILE_NAME = "KHALED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage_private);

        try {
            File ext_st = Environment.getExternalStorageDirectory();
            File f = new File(ext_st, FILE_NAME);
            //make folder
            //f.mkdir();
            if (!f.exists()) {
                f.createNewFile();

            }
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println("khaled Assidi");
            pw.close();
            ;
            fos.close();

        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }




    public boolean isExternalStorageWritable(){
        String state= Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
    public boolean isExternalStorageReadable(){
        String state=Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY) || state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }

}
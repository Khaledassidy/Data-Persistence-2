package com.example.datapersistance2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*

External stroage:zekra 5arjeye

metl ma 2olna l external stroage momken tkoun bultin bel telephone bzeet nafso l heye btkoun ma3 l memory l intenal stroage metl ma 2olna l internal btet2asm 2osmen 2esm external w esm internal
w momken tkoun l external stroage heye l sd card
fe telephonet bte3tebr l external stroage heye l sd card bas w fe telephonet l external stroage bteje bultin mwjoude bel mobile nafso
w kamen eno l external storage l bult in heye 3ebra 3an l interanl stroage bten2esem 2osmen esm internal stroage esm external storage

w 2olna eno kamen l external stroage btene2esem 2osmen sawe2 bult in 2aw sd card :esm 3am esm 5as
5as:ya3ne 5asa lal application
3am:ya3ne btkoun 3ama lal koul l koul fe yet3emal ma3a



hala2 iza 3mlt code be5zen 3ala l external storage w keen l shelna mn telephone l sd card w keen telephone 2adem 2aw keen shebko la telephone 3ala jehez 3an tare2 waslet l usb bel 7ale hay l zekra l 5arejeye btkoun mesh mawjoude mn wejehet nazal l application proagraming eno befaker ma fe external stroage fa momken ya3tek error fa 3ashen heek 5oda ka3ede:
aye  ta3amoul ma3 zekra l 5arejeye lezm tef7as abl hal heye mawjoude 2aw mesh mawjoude
-fa 2awl method bel external stroage bade 2a3ml method ef7as iza l external stroage mawjoude 2aw la2
 public boolean isExternalStorageAvailable(){

    }
    hay l method iza raj3tle true ya3ne fe external stroage iza la2 ya3ne ma fe external stroage

fe 3ande class esmo Enviroments mn 5elelo bet3emal ma3 l be2a l 5asa bel android sawe2 mn ne7ye zekra l 5arjeye l folders l mawjoude feha l files l be2eye le 5asa bel operating system...etc ya3ne feek te3tebro metl system class 5as bel operating system
ba3den 3ande method b2alb l enviroment esma getExternalStorageState() btraje3le string  String state=Environment.getExternalStorageState(); sho ya3ne btraj3le l state l 5asa bel external stroage 3ala shakl string l state le bada terja3 lezm t3aber 3an 7alet l external stroage law reje3t :
Media_mounted:eno eno mawjoude mote7a w kabele lal kera2a w l ketebe
unmounted:ya3ne ma fe zekra 5erjeye
readonly:ma3neta mote7a lal kera2a bas

fa ana bade eje ef7as bade 2elo law l state le ejetle hayde .equals l2no ana 3am karen string b string Enviroments.Media.Media_Mounted

 if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }

        5alene 2a3mel hay l medthod bas Writable ya3ne isExternalStorageWritable(){
        }

ya3ne iza kenet l state ta3et l external storage Media_Mounted mote7a lal kera2a w l ketebe raj3le true
else raj3le false;


tyeb iza bade 2a3ml wa7de lal kera2a bas ya3ne bade shof iza l external storage mote7a lal 5era2a 2aw la2

le 7a yet5ayar eno iza heye Media_Mounted_Read_only
fa ana bade 2olo iza kenet l state Media_Mounted_Read_only or Media_mounted return true
lesh ana 2oltelo Media_Mounted_Read_only or Media_mounted l2no law kenet Media_mounted fa heye mote7a lal kera2a w l ketebe w law kenet Media_mounted_Read_only 7a tkoun mote7a lal kera2a fa bel 7alten 7a tkoun mote7a lal kera2a bas barke kenet mounted sa3eta ma 7a ykout bel if statememt fa enta bte5od b3een l 2e3tebar eno momken toun mote7a lal kera2a w l ketebe bel 7alten lezm return true

public boolean isExternalStorageReadable(){
        String state=Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY) || state.equals(Environment.MEDIA_MOUNTED)){
                return true;
        }
        return false;
    }


    fa hala2 5als brou7 3ade 3al craate b2olo law kenet iswriatable kotble 3ade 3al external storage law kenet isreadable 3mele read mn l external stroage

    fa 2awl she bade ef7as iza keen isExternalStorageWritable() ya3ne iza l external stroage mote7a 3ande lal ketebe fa ana bade rou7 nafez l code ta3el l katebe  if(isExternalStorageWritable()){}:
    2awl she bade 2a3ml file 3ala l external storage  File f=new File() 2awl parameter 2olna directory ma7al ma bade enshe2 l malaf sho esm directory ta3el l external storage? la7za ne7na mna3ref abl eno zekra l 5arejeye feha kesmen zekra 5arejeye 3ama w zekra 5arejeye 5asa
    fa enta ween badak t5azen bel 5asa 2aw bel 3ama?
    sho l far2 baynetoun ba3d shway 3a ne7ke 3anoun
    bas la nefred eno bade l zekra:
    l 3ame:Environment.getExternalStoragePublicDirectory()
    l 5asa:Environment.getExternalStorageDirectory()

    fa 5alene 2a3mela 3ala l external storage l3am bas 5alene 2a3mela b parameter la7ala:File ext_st = Environment.getExternalStoragePublicDirectory();hala2 been praces be2olak sho esma mazel enta bte7ke bel zekra l 5arejeye l 3ama fa 7a tkoun wa7de mn l mojaladet l 3ame l hye sowar 2aw malaf downloaded 2aw malefet l camera malaf l pictures sha8let l 3ama
    fa enta la tshof kel l asme2 l mojldet l 3ame 7ot Enviroments. w betshof kel asme2 l mojalet l 3ame:
    Environment.DIRECTORY_ALARMS
    Environment.DIRECTORY_DOCUMENTS
    Environment.DIRECTORY_DCIM
    Environment.DIRECTORY_DOWNLOADS
    Environment.DIRECTORY_MUSIC
    Environment.DIRECTORY_PICTURES
    Environment.DIRECTORY_NOTIFICATIONS
    Environment.DIRECTORY_MOVIES
    ....etc
    masaln ana 7a e5tar bel downloads:File ext_st = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); fa hala2 l file le 7a tensh2o 7a ykoun b malaf downloads
    File f = new File(ext_st,FILE_NAME);
    3am t2olo 3mele file 5azno  bel downalods esmo l file khaled

    feek enta ta3mel folder b2alb l downloads esmo khaled w ba3den t5azen b2alab heda l folder malfet la ta3mel folder bta3mel heek f.mkdir();  mkdir:make directory


    bas ana bade 2a3mel file so:f.createNewFile();



 File ext_st = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
 File f = new File(ext_st,FILE_NAME);
 f.createNewFile();

 hala2 enta bhay l 3 tostour:
 2awl satr 3atene mo2asher 3ala l mojalad l mawjoud bel external stroage l 3am le mawjoud bel download
 w tene satr bade file esmo khaled b2alb l dowanlod bas lesa ma 3mltelo create 3atene  mo2sher 3lee la heda l file
 w telet satr enshe2 l file


 ba3den law bade ektob bkafe 3ade inputstram,prinwriter...etc


 if (isExternalStorageWritable()) {

            try {
                File ext_st = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File f = new File(ext_st,FILE_NAME);
                //make folder
                //f.mkdir();
                if(!f.exists()){
                    f.createNewFile();

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

hala2 iza jeet la ta3mel run la heda l code b7yeto ma 7a yeshte8l lesh l2no nseet ahama sha8le ta3mela bel manifict l heye l permission l sala7yet:
lezm aye ta3moul ma3 zekra l 5arejeye lezm te5od sal7ye mn l user eno badak teat3mel l external stroage lesh?
l2no momken bkel basata aye programmmer ya3mel application lal nes w ynazlo w yes7ab kel l data le b2alb telephonetouun
fa ejet google alet la2 lezm enta lama tet3mel ma3 l bayanet l 7asese ta3et l user lezm te5od ezn mn l user bel mosoul la hay l data
3ashen heek lama teje tnazel application mn google play be2olak deer belek heda l application bado yosal la sal7yet kaza w kaza w kaza badak 2aw ma badak bt2olo eh bade bkamel 3ade
7alyen bel version ba3d l marshmellow sar l permission yete5ad ba3d ma yenzal l application ya3ne sar bas yenzal l applciation sar yenzal mobashratan bas la teje tefta7o sar yes2alk ytale3lk moraba3 z8eer eno allow acces to external strorage bt2olo eh bekamel 3ade
eno be2olak heda l application bado yosal lal permission kaza tesma7lo 2aw la2
l2no hay tare2a 3mloha eno 2aw2at ana bade nazel application bade esta5dem meno jez2eye ma byelzamla permission lesh la temna3ne nazel l application
<!--    hala2 law sha8lt l app 3ala version 2a2l mn marshmellow byeshte8l 3ade aktar ma bymshe l 7al bya3mel error l2no iza 2a3la lezm tet5ed l persmission btare2a tenye 8eer l manifist-->
<!--    aktr mn marshmellow version 6 sar yotlob l permission t3arefa bel code 3ashen 3end sta5dema yetlob mn l user eno ya3mel ok lal permission mesh 2awl ma efta7 l app le2e l permission ma3mole w ana lisa ma bade yeha hala2-->
<!--    l permission bel manifist ytem este5dema 3end tanzel l application-->




tare2a lezm ta3mela bel code la version aktar mn 6 l marshmello 3ashen l permission w hay sha8le darore net3alama:
tare2a lezm ta3mela bel code bas tet3emal ma3 aye permission bas ykoun l version aktar mn marshemello
mn l version marmshemmellow w enta tale3 btetlob l permission lama yenzal l app ya3ne code talab l permision mesh bas bekoun bel manifist lezm ykoun bel activity nafsa
ya3ne enta houn badak yeh 2awl ma ykout 3al activity esma external_strorage me7tej yetlob mn l user l permission keef badak l 7arake hay:

-2awl sha8le badak 2awl ma tfout 3al activity tef7as hal l permission tam 2a5do wala la2 lesh l2no law deyeman enta badak totloba yemken l user yfout mara tenye 3al activity kel mara bado yetlob permission l2no l user yemken yfout 2awl mara ya3te permission a5ad l permission reje3 tele3 bas yerja3 lezm ma yerja3 yetloba l2no a5ada so lezm nef7as hal l permission mete5ed :
fe class 3ande esmo ContextCompat 3bara 3an class 5as bel context bel support library
b2alb heed l class fe method esma checkSelfPermission() hay l method bte5od l context le enta fe w tene parameter esm l permission le howe esmo Write_external storage  bfout 3lee mn l manifist->permission->Write_external_storage
 ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE); hayde l method btrje3lk integer heda l integer be3berlak 3ala hal tam a5ad l permission wala la2 ya3ne ana 3ande majmo3a mn l final m2aren feha metl
 permission mete5ed:integer=1
 permission mano mete5ed:integer=2
 permission marfoud:integer=3

 bas ana 3ande sawemet tenye jehze bel PackageManager:
 Permission_Granted=0 ya3ne l permission mete5ed
 permission_denied=-1 ya3ne tam rafdo

 fa hala2 bet2olo iza keen l checkpermission mano equll la permission grandted nafez heda l code ya3ne iza keen l permission mano ma25od nafez heda l code

if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
heda l if 3ashen te7kelo sha8le wa7de bas:
hal l permission le esmo write_external_strorage heye granted wala mesh granted granted ma3neta mete5ed not granted mano mete5ed fa bel if iza heda l permission lam yatem l 7osoul 3lee b2alab l if wazefte 2otlob sal7eye
keef bade etlob sal7eye b class l ActivityCompat class 5aso bel activity howe bel support library fe method b2albo esma requestPermission():
 ActivityCompat.requestPermissions();:lesh esma activitycompat l2no hay l method requestPermissions() heye shshe btetla3 lal user fa lezm tkoun mertebta b activity
ContextCompat:lesh contextcompat l2no l permission howe met3le2 bel context ta3el l apllication kolo fa 3ashen heek contextcompat

ActivityCompat.requestPermissions();:heye shehshe btetla3 lal user 3ashen ywefe2 3al permission hay l method bte5od 2awl parameter l context this,tene parameter bet5od l array ta3et l permission le badak tetloba l2no be2mkenak totlob kaza permission bnafs l wa2t bt2ot b2alb array kaza permission w bt7ota bel requstpersmission
fa ana hala2 bade 2a3te l array momken t3arefa mara 2aw t3arefa mobeshar:
new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE} badak tzeed bta3mel fasle b2alb l list w bdeef permission
or
eza badak yeha sebte:String [] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};badak tzeed bta3mel fasle b2alb l list w bdeef permission

w 2e5er argument howe requset_code le howe 3ashen lama terja3 ta3ref mn ween raje3 mesh enta byetla3lak moraba3 7ewar lama tekbous ok 2aw denied la7 yerja3 lal activity fa 3ashen ta3ref mn ween reje3 badak ta3mel requset_code
b3ref req code 2aw besta3mel she jehez:public static final int WRITE_EXTERNAL_REQ_CODE=1;

enta l method hay ActivityCompat.requestPermissions();:byetla3lak moraba3 7ewar dialog eno l application byotlob permssion kaza w kaza badak wala la2 fe zeren allow ya3ne 3ate permmison denied ya3ne la2 ma ta3te
 if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            //permison ma te5ad
            //String [] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},WRITE_EXTERNAL_REQ_CODE);

            5od belak ba3d kol haw mesh ya3ne sal7eye tam 2a5da la2 ma3neta betal3 morabe3 7ewar byema7 lal application eno yotlob permission  w beysma7 lal mosta5dem eno ya3te permission wala la2 ya3ne momken ya3te permission yemken la2 ma ya3te

            keef ba3ref eno l mosta5dem kabas hay l kabse wala la2 fe 3ande method call back mawjoude bel life cycle esma onrequsetPermissionResult hay l method betem ested3e2a 3end da8ta 3ala l button le beytla3olak allow 2aw denied law tekbous 3ala wa7de mn haw zeren btestad3a hay l method w byab3tlk l requset code w yeba3tlk l array ta3et l permission kolha le kont enta talebha w byab3tlk kel wa7de mn l permission le kont enta taleboun mete5de wala la2 mana mete25de ya3ne n2abelt wala la2  3ala shakl array of grantResult byerja3lk 2 array nafs toul wa7de feha l permission wa7de feha l grantedResult lan2ol enta talbt 5 permission bel arrray byerja3lk array b2lab l 5amse permsiion le talbtoun w tene array of integer bt2olak eno hay l permission granted wala la2 l2awal masln bel array of permission howe of index 0 w l grntedRsult ta3elo b2alb l array of grantedResult of index 0 ya3ne l2no l 2awl permission granted ba3tlk 0 tene -1 meshgranted


        }

hala2 else ya3ne l permission te5det{
so tba3 toast eno ma te5det

bas ba3d l android 10 batal fe l wa7ad ya3mel acces directly 3ala external stroge ya3ne enta feek ta3mel file mn l code w t5azen fe data w ba3den te2ra meno bas ma feek te2ra aye file mn download 2aw tektob 3ala aye file mn dowanlod hay la8oha w ba3den mn ba3d andoid 10 ba3d feek te2ra file enta 3emlo 2aw toktob 3ala file enta 3mlo w bala permistion batal badak permition w nafs she 3al image ,vedios audion keef te2ra aye soura vedio t5azen aye soura without permisstion
bas la7 ta3mel acces 3ala aye she bel download 3mlo she esmo saf allow user to grants acces to specific file and directories through system provided ui
eno sar hay saf masln l application bado y3ouz file b2alb download bye2slo lal user bt5le yesta3mlo la heda l file
}



hala2 enta azbat t7ot l code b2alb l l function ta3el eno bas ywefe2 3al permistion lesh l2no bhay l 7ale enta 2oltelo eno bada permition w ba3den 5azan file de8re bel download ma natark la twefe2 ba3den 2olelo eno create file bel doeanloads

hal2 2aw2at enta b7aje to3oroud description lal permtion wasf lal permistion eno enta la sho badak ta3mel acces fa 3ana bel ActivityCompat function:ActivityCompat.shouldShowRequestPermissionRationale() 2awl parameter be5oda l activty heye this tene parameter l permistion

ba3d sha8le iza enta badak tefta7 l file 7a y2olak ma fe yefta7o l2no mane 7atetlo extention metl khaled.html 2aw xml
    public static final String FILE_NAME="KHALED.html";




    tare2a tenye bas badak ta3mel file w tekteb 3lee from android 10+ sar be2ste3mer sar ipi new storage bt5lek tektob 3al external storage
     ContentValues contentValues = new ContentValues();
                    contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, "file" + ".html");
                    contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "txt/plain");
                    contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
                    Uri uri = resolver.insert(MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY), contentValues);
                    if (uri != null) {
                        try {
                            FileOutputStream fos = (FileOutputStream) resolver.openOutputStream(uri);
                            PrintWriter pw = new PrintWriter(fos);
                            pw.println("khaled Assidi");
                            pw.close();
                            ;
                            fos.close();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    2awl she sta3mlna class esmo content resoulver 3ashen bas badna na3mel create file read file aye file bel external storage badna nesta3mel content resoulver class la na3mel file mna3mel contentresoulver.insert weenbadak ta3mel insert bel external storage l 3ame MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY This constant represents the primary external storage volume, typically the device's internal shared storage that is accessible to all apps and the user.  getcontenturi RI for a specific storage volume within the MediaStore.
                    ba3den badna nest3ml class ContentValues contentValues=new ContentValues(); heda l file mnesta3mlo la mowasafet l file l soura mnbalesh bel name,extention ween bado yetsayf
                    ba3den mnkamel 3ade metl l file write w kaza

                    kol haw l eshya bas lal file l app bta3meloun mesh la aye file mwjoud

 iza bade 2e2ra file 2aw 2a3ml write 3ala file that app dosnt created besta3ml 2 method createwriteRequset,CreateDeleteRequest




bel nesbe lal read nafs sheee keef kona na3mel bel internal
 */













public class EXTERNAL_STORAGE_PUBLIC extends AppCompatActivity {

    public static final String FILE_NAME="KHALED";
    public static final int WRITE_EXTERNAL_REQ_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        ActivityResultLauncher<String> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean o) {
                if(o){
                    Toast.makeText(getApplicationContext(), "permission acces", Toast.LENGTH_SHORT).show();
                    if (isExternalStorageWritable()) {

                        try {
                            File ext_st = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                            File f = new File(ext_st,FILE_NAME);
                            //make folder
                            //f.mkdir();
                            if(!f.exists()){
                                f.createNewFile();

                            }
                            FileOutputStream fos= new FileOutputStream(f,true);
                            PrintWriter pw=new PrintWriter(fos);
                            pw.println("khaled Assidi");
                            pw.close();;
                            fos.close();
                        } catch (FileNotFoundException e){
                            throw new RuntimeException(e);

                        }
                        catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }

//                ContentValues contentValues=new ContentValues();
//                ContentResolver resolver=getContentResolver();
//                contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,"file"+".html");
//                contentValues.put(MediaStore.MediaColumns.MIME_TYPE,"txt/plain");
//                contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH,Environment.DIRECTORY_DOWNLOADS);
//                Uri uri=resolver.insert(MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY),contentValues);
//                if (uri!=null){
//                    try {
//                        FileOutputStream fos= (FileOutputStream) resolver.openOutputStream(uri);
//                        PrintWriter pw=new PrintWriter(fos);
//                        pw.println("khaled Assidi");
//                        pw.close();;
//                        fos.close();
//                    } catch (FileNotFoundException e) {
//                        throw new RuntimeException(e);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);

//                    }
//                }






            }
        });



        //permition in manifist from android 1 to 5

        //this method from android 6 to 10
         //from 10 to 14 use activity luncher

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                //permison ma te5ad
                //String [] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                //bta3te wasf houn lal permtion metl aplication l facebook be2olak wala badak ta3tene permition 3ashen bas badak tnazel soura 2e2dar 2a3mel acces la gallry...etc w tnazel post
                //ya3ne houn feek ta3mel dialog w te7kelo sho bye7ke l permistion w sho bya3mel
//                When you request the CAMERA permission for the first time, the user hasn't had a chance to deny it yet.
//                In this scenario, shouldShowRequestPermissionRationale() returns false because there's no previous denial to explain.
//                Therefore, the code execution goes directly to the else block, requesting the permission without showing a rationale.
                // ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA hay return boolean 2awl mara false fa 7yfout 3ala l else iza 3mlt denied 7a yerja3 tseer ture fa tene mara 7tfout 3al if
//                The purpose of shouldShowRequestPermissionRationale() is to help you decide whether to show an explanation (rationale) to the user only when they have previously denied the permission.
                Toast.makeText(this, "khaled", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, WRITE_EXTERNAL_REQ_CODE);
                activityResultLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, WRITE_EXTERNAL_REQ_CODE);
                activityResultLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }

            } else {
                Toast.makeText(this, "permission are granted", Toast.LENGTH_SHORT).show();
            }











    }





    public boolean isExternalStorageWritable(){
        String state=Environment.getExternalStorageState();
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //beje ba3mel switch 3ala requset code lesh l2no momken ykoun 3andak kaza permission w badak bas ta3mel permission ta3ref mn aye activity reje3
        switch (requestCode){
            case WRITE_EXTERNAL_REQ_CODE:
                // bade shof hala2 iza granted ya3ne tam a5ad l permission iza la2 ma a5det l permission
                //2wl she lezm nef7as l array iza akabr mn 0 lesh l2no law l user 3emel denied 7a yetla3 l size taba3 l aaray 0 tela3 fadye
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //iza l array akbar mn sefr w l permission met5ed 3meel toast
                    Toast.makeText(this, "permission acces", Toast.LENGTH_SHORT).show();
                    //hala2 momken yela3 l array mesh fade bas mesh granted law tel3lak dialog w enta ma kabst she 7a yetla3  l array mesh fade bas l franresult mesh granted



                    //hala2 houn 7ot code ta7zen l file bel dowanlods
                    if (isExternalStorageWritable()) {

                        try {
                            File ext_st = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                            File f = new File(ext_st,FILE_NAME);
                            //make folder
                            //f.mkdir();
                            if(!f.exists()){
                                f.createNewFile();

                            }
                            FileOutputStream fos= new FileOutputStream(f,true);
                            PrintWriter pw=new PrintWriter(fos);
                            pw.println("khaled Assidi");
                            pw.close();;
                            fos.close();

                        } catch (FileNotFoundException e){
                            throw new RuntimeException(e);

                        }
                        catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                return;
        }
    }
}
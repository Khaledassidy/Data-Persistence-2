package com.example.datapersistance2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;
/*

2awl sha8le bas ne7ke 3an zekra de5leye l internal storage badna netzakar eno heye 5asa bel tatabe2 bel application sho ya3ne 5asa bel tatabe2 ya3ne wala 7ada 5erej tatabe2 ta3elak be2dar yet3emal ma3 l malafet le betkounn m5azane b zekra hay

hala2 7a 2a3ml 3 edit text b2alba name,pass,birthdate,w 2 button w2t 2a3ml save save le b2alb l edit text wa2t 2a3ml read 2e2ra le sayvtoun

2awl she bas ekbous save bade sayev le b2alb l edit text bel internal storage
lezm 2awl she tefham eno l internal storage howe mesh malaf wa7ad howe feek te3tebra folder b2albo kteer malafet ya3ne bte2dar tenshe2 joweto majmo3a mn l files

l folder heda bte2dar tshofa mn 5elel function iza badak tshof sho feha mn 5elel function esma    getFilesDir()
getFilesDir():btejeblak l directory kola 3ala shakl file w bte2dar testa3lem mena w ta3ref sho asme2 l malefet le joweta w adesh 7ajma w adesh dal feha space..etc

3ashen ana 5azen bel internal storage lezm 2a3ml file ba3den 5azen de5el heda l file majmo3a mn l bayanet ba3den sayfo bel intrnal storage

-2awl she 5alene jeeb data b2alb l edit text:
 String name_user=name.getText().toString();
 String pass_user=pass.getText().toString();
 String birth_user=birth.getText().toString();


 -ba3den b same esme l file final static ykoun 3am
 public final  static String FILE_NAME="user";


-hala2 keef bade et3emal ma3 l file:
aye ta3amoul ma3 l file bel java 2aw bel android lezm tet3emal ma3 she mn same Stream
Stream:ma3neta majra majra ma3neta aye majra majra may ya3ne law ana 3ande 7anafeye  w hay l 7anafeye mashbok feha majra may w heda l majra wasel la zar3a m3ayane fa heda le meshe mn l 7anfeye la zra3a  heda mn same stream 2aw majra howe 3ebra 3an 5at been no2ten no2ten hawde wa7de btetwasl ma3 no2ta tenye heda ma3na stream 2aw majra
ta3amoul ma3 l file bel java 2aw bel android ta7dedan btem ta3amoul ma3o ana be7ke bel internal storage fe 3ande 2 function:
first function esma:openFileInput()  lama ana bade 2e2ra data mn file fa lezm et3emal ma3 she inputstream
lama ana bade 2e2ra she mn malaf 3ala l internal storage meen ana l application w l malaf mawjoud 3ala l internal stroage lama l data tejene mn l mlaf lal application fa ele ka application jeytne ele ka application ka input 3ashen heek esma input stream
fa ka3ede lama enta badak te2ra 2eraye mn malaf inputstream




tene function esma:openFileOutput() lama bade ektob she 3ala malaf outputstream
ama ana bas bade ektob mn tatabe2e l application ta3ele 3ala file bel internal storage fa ana btale3 data mn l application ta3ele 3al internal storage fa 3ashen heek esma output stream
fa ka3ede lama enta badak tektob 2aw t3adel 3ala malaf btet3mela ma3 outputstream



fa mabdaeyan badna noktob 3ala l inernal storage fa bade et3mela ma3 openfileoutput():

openfileoutput():ya3ne fta7le stream majra 3al malaf l esmo kaza fta7le majra 3ala malaf l esmo kaza 3ashen ektob mn 5elelo
bas fe no2ta moheme mesh ya3ne iza fata7t stream eno balsht tektob la2 houn enta ka2no fat7t l 5at bas lisa ma balsht da5el mn 5elelo may 2aw aye she enta lama tefta7 stream k2no fat7t 5at bas ma balsht t5azen bayanet
fa openfileoutput() rou7 fta7le stream


openfileoutput():fa 2awl argument bade ektob esm l file exmple "users",tene argument howe l mode private le howe 3ebra 3an sal7yet w 2olna l mode private howe la yomken le aye 7ada 5erj l application yshof l file 2aw yet3emal ma3o zamen keef aktar mn mode metl masaln mode_word_readable heda l mode byesma7 la heda l malaf aye tatabe2 tene by programing yosal la heda l file bas ne7na 7kena l internal storage ma bye2dar l user b3eno yshofa la fata7 file 3al file 3al telephone ma bye2dar yshofa bas law fe application tene wesel katab esm l activity ta3ele w 3emel code ye2ra l mlaf ta3ele zamen keen heda l kalem mawjoud keen be2ydar ye2ra l data law keen l mode mode_world_readable w y3adel 3lee law keen mode_world_writable law sta3mlta 7a yetla3 expection ama iza badak hala2 tsherek l malaf ma3 be2e l application fe she esmo sharedfile,
 openFileOutput(FILE_NAME,MODE_PRIVATE);:bhedd satr ka2no 2oltelo fta7le majra 3ala l file le esmo user w 5ale mode ta3elo private
 bas heeda l malaf mesh mawjoud iza heda l malaf mesh mawjoud l function hayde betrou7 bta3melk create la heda l file iza mawjoud bas bet3ytlo la heda l mlaf
 openFileOutput(FILE_NAME,MODE_PRIVATE);:fa l function hay sho bta3mel btrou7 btshof l malaf iza l malaf mmawjoud btefta7 majra w btraj3 l majra  iza la2 mesh mawjoud btenshe2 heda l malaf w btefta7 majra w btrja3lk l majra le howe mo2asher 3ala l majra
openFileOutput(FILE_NAME,MODE_PRIVATE);:fa hay l function btrje3lk l majra fa mn7oto b variable fileoutputstream le howe mo2sher 3ala l majra
FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);

fa ba3d fe error 7atet l openFileOutput lesh l2no momken ytale3 expetion
l expetion howe 5ata2 2aw estesna2 momken yseer 5erej3 3an eratak metl sho yrou7 yenshe2 l file w yle2e l storage full momken yseer 5ata2 mo3ayan 2am system yel8e l file 2am yrou7 ma yle2e l file

fa berou7 be2olak 3meel mo3elaje la heda l expetion wa7de mn toro2 l mo3alaje heye try catch
le heye ta3mel try{FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);} ya3ne try eno traje3 l stream
ba3den iza sar expetion catch heda l expetion le howe FileNotFoundException e
  try {
            FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Creates a RuntimeException Object: It creates a new instance of the RuntimeException class, which is a type of unchecked exception in Java. Unchecked exceptions don't need to be explicitly declared in a method's throws clause.
Passes the Cause: It passes the existing exception e as an argument to the RuntimeException constructor. This means the new RuntimeException will "wrap" the original exception, preserving information about the underlying cause of the error.
Throws the Exception: It immediately throws the newly created RuntimeException object, interrupting the normal flow of execution.

iza sar l expetion catch w 3mell  throw new RuntimeException(e);





hala2 hal bhay tare2a enta balst tektob la2 enta bas 3mlt file esmo user w raj3t l majra ta3elo w jahzto
 try {
            FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


3ashen ektob 3al malaf lezm esta3mel class tene lal ketbe esmo PrintWriter:
eja 2alak l majra le enta fat7to heda fileoutputstream f3lyan lama l program yblesh b low level language 2aw lama yebda2 ynafez eshya l 3amle eno yektob 3ala l file aye ketbe 3ala file byektob bites w bye2ra bites enta ma 2elak 3ela2 bheda she enta l mafroud bas t2olo 3mle println() yrou7 yetba3 heda satr w yenzal satr jdeed law enta badak tektob 3ala l fileoutputstream mobasharatan lezm tektob bel bites fos.write(houn badak tektob bel bites) ma byenfa3 tektob string,float,int..etc
fa eja class waset esmo PrinWriter howe waset ma benak w been l output stream badel ma ektob bites la2 kteble string,int,double w ana brou7 b7awela la bites
fa beje be7kelo  PrintWriter pw=new PrintWriter(fos); ba3mel object mn l prinwriter w ba3te l outputstream howe be7wlo la bites fa hala2 bade ektob bektob 3ala l printwirter w ana 3ate l file howe be7wlo la bites

 pw.println("khaled");:3am 2olo tba3le 3al malaf khaled

pw.println("khaled");fe3lyan heek 7ayro7 yzedlak 3ala file l kalem le 7aytto houn
fa enta katbt khaled 3al file w howe la7lo 7awla la bites

println()"ma3neta tba3le lkalem l b2alab 3al malaf mesh 3ala l shshe



w e5er she lan2ol 3mlt println ad ma badak e5er she lezm ta3ml close la resources
sho ya3ne close la resources enta fat7t sha8lten class l ketebe w class l majra badak tsakeroun lesh l2no law l malaf dal maftou7 ma bye2dar 8ayrak yesta5dmo ya3ne bebtel te2dal ta3mel 3lee be2e l operation  metl read akeed mjreb tefta7 l word tektob 3lee ba3den teje la ta3mlo delete lal file be2olak ma fek lezm tsakro 2awl she l2no ba3do b ram fa fe3layn law l file ta3elak mosta5dam maftou7 ma bte2dar terja3  ta3mlo delete 2aw te2ra meno 2aw t3adel 3lee w 2aw2at iza ma sakrt l file fa data momken ma tenkatab 3al file bte5od data bshe esmo  buffer (ya3ne jez2 mn data) ma bte5oda kola bt5zena 3ashen ma yseer to2l 3al cpu barke data le badak t5zena kebere 1 gb  l2no data byen3amala buffer ba3den byen3amla flush w ten2al 3al file fa bas tsaker resources heek 3am t2aked eno kel data n3amla buffer 3am yente2l 3ala l file bas ta3mel write
fa bta3mle prinwriter close:pw.close();
w bta3mel file outoutstream close:fos.close(); bas hay momekn ta3mel expetion inputoutput expecpstion fa ba3mela try catch yemken ta3mel expection l2no momken enta w 3am ten2el l data mn l buffer 3ala file bas ta3mel close fa yemken yseer meshkle masln bel hardware


w tareteb mohem ma fek ta3mel
fos.close();
pw.close();

8alat lesh?
l2no howe fata7 l majra
ba3den rakab l bayanet 3ala l majra
fa enta lezm tsaker tshel l mawjoud 3ala l majra pw.close()
ba3den tefsel l majra fos.clos();

t5ayal majra mey narbesh
w heda l majra feh may
fa iza enta jeet tshelo la narbesh w l may sha8ale ma byenfa3 heda she
lezm tsaker l may ba3den tshel l narbesh


fa howe heek jehez la aye wa7ad tene yet3emal ma3o
iza jeet mara tenye la t2ra meno bte2dar


*/



/*
code l read mn l file 2awl sha8le badna n3ouz openfileInput l2no howe byejena l file ka input bel nesbe lal application
-fa 2awln ba3mel penfileinput b7ot esm l malaf ma elo mode l mode bas mnesta3mlo bas 2a3mel create lal malaf 7aded sal7eto eno private ma fe application tene ya3mlo acces ama houn enta badak te2ra mn malaf ya3ne l malf majoud fa ba3mel heek  FileInputStream fis=openFileInput(FILE_NAME); berj3le l stream ta3el l file le 3mlto ana kamen bas 2a3ml fileinputstream kamen momken yseer exepetion metl eno l file mano mawjoud fa ba3mel kamen try catch fa bteer heek try {
                FileInputStream fis=openFileInput(FILE_NAME);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

hala2 ana heek raj3t l majra l stream ta3el l file ba3den bade 2a3mel read lal file mn l majra nafs she ma fene 2e2ra mn l file directly l2no iza bade 2e2ra mn l file bado yerdele bites fa best3mel class waset BufferedReader
BufferedReader:buffer ma3neta joz2eyet joz2eyet 2aw ma3neta ta5zen joz2e bas l fekra eno law l malaf ta3ele kbeer t5ayal eno malaf 7ajmo 1 gb fa hal mante2e eno trou7 te2ra l 1 gb darbe wa7e w to3roda akked la2 l fekra eno trou7 te2ra joz2 jozo2 mn l file 3ashen ram le 5asa ta3et cpu ma testahlek bshkl kemel w ma tkoun bate2a fa sa7 eno 2e2ra jez2 jez2 fa bade jeblak jez2 wa2t t5ales t3ardo bkoun jebtelak jez2 tene hay l 3amlye esma buffering 2aw tajze2 l bayanet eno yjeblak jez2 jez2 mn l bayanet class l buffer byesma7lk te2ra jez2 jez2 mn l data badel ma te2raha kola darbe wa7de tab3an fe 7ajm mo3ayan lal buffer fe code tene masaln t7aded eno badak 7ajm l buffer ykoun 10 mb ya3ne bade kel na2le la data yjeble yeha tkoun b7ajm 10 mb momken tkoun badak tkaber l buffer badak tza8er l buffer bas heda she ma badna yeh
BufferedReader br=new BufferedReader();:l buffered reader ma byet3emla de8re ma3 l input stream la2 howe bas l role ta3elo eno ye2ra data jez2 jez2 bas bade 2a3te data l file la ye2ra fa 2awln lezm 7awel data mn bite la charcter  byet3mela ma3 she esmo InputStreamReader
InputStreamReader:class waset bade 7awlo 3ashen yerkab 3ala l buffered reader:InputStreamReader isr=new InputStreamReader(fis); l InputStreamReader bye5od l inputstream ka input 3ashen y7wel l data le bel file mn bite to string  ba3den
l buffered reader bye5od input l inputstreamreader w bye2ra data jez2 jez2


fa le 3mlto ana fileinputstream fo7t 7awlto la class inputstreamreader 3ashen y7awel mn bite to charachter 2aw kare2 3ashen eb3ato lal bufferedReader 3ashen ye2ra data jez2 jez2



hala2 iza bade 2e2ra be2ra mn l buffered reader keef metl l scanner feek te2ra mn l scanner class kamen:br.readLine();
bas hal mante2 2e2ra satr la2 mafroud 2a3mel loop w hay loop tadala 3am te2ra la7ed ma te5las data ya3ne ydalo ye2ra ba3den wesel la 2e5er l file rou7 wa2ef loop w 3atene data le enta jebto

fa besta3mel while loop
fe function 3ande esma br.readline() btraje3 string;ya3ne law fee bel malaf 5ams astour bte2ra satr satr
fa enta bta3mel:while(br.readline!=null):fa bedalo 3am tlof bte2ra 2awl satr bterja3 bte2ra tene satr heeek la7ed ma t5les keef bta3ref iza 5alset iza ejet la te2ra satr w keen fade fa br.readline 7a yraje3 null fa toul ma howe mano null raje3 l astour fa iza keen null ya3ne ntaha l file


fa le la7 2a3mlo 2awl she eno 3aref string fade esmo temp:String temp="";
enta byenfa3 ta3mel assigment bel while
ba3den 7ot b2alb l while((temp=br.readline())!=null){ le 3mlto houn l 2awlaweye lal praces fa ana 2olt rou7 2e2ra satr w 7azno b temp ba3den shof temp heye null iza null wa2ef iza la2 7azno b temp ma3neto toul ma fe satr jdeed enta bte2ra mn l malaf dalak nzal w 2e2ra mn l malaf la7ed ma tosal la satr fade

w readline momken tale3 expecption inputoutputexpexpetion lesh l2no momekn ana w 3am be2ra mn l file yseer fe meshkle barke l file le bade 2e2ra meno n3amlo delete 3mltelo delete

enta houn ma byenfa3 ta3mel
eno t3aref variable :String alltext="";
while(br.readline()!=null{
alltext+=br.readline()

lesh l2no heek howe 7a y5zen satr le ba3do l2no enta 2awl mara 3mlt readline rje3t 3mlt readline fa 7a yenzal satr ma 7a y5azen l 2awl fa 8alat w ba3den bas yeje tene mara 7a ye2ra teelet iza = null ma yshof tene iza null l2no 3am be2ra marten fa l 2as7san 5azno b variable ana w 3am 2a3mle while



fa houn b3ref String all text=""
w b2alb l while bejma3 ma3 temp sa3eta
ya3ne"alltext+=temp

w 2e5er she bas y5les l file ya3ne yetla3 temp==null byetla3 mn loop

bsaker kel le fat7toun resources btarteb bel 3aks 2awl she l buffered ba3den inputstream,ba3den l fileopeninputstream


hala2 momken enta bel expetion t7ot eno iza sar expetion 3meel toast file not found 2aw aye she tene



iza shelt l close bel write w jeet la ta3mel read ba3den 7a yseer expection bel br.readline() lesh l2no 7a yeje la ye2ra 7a le2e eno l file 3am yesta3mal lisa 2aw iza ma 3mele expetion 7a yerdelak null


hala2 iza bade 7ayer l buffer size heeek
// Specify the buffer size in bytes (10 KB = 10 * 1024 bytes)
BufferedReader br = new BufferedReader(isr, 10 * 1024);

 */






public class INTERNAL_STORAGE extends AppCompatActivity {

    EditText name,pass,birth;
    Button save,read;
    String name_user, pass_user,birth_user;


    public final  static String FILE_NAME="user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        name=findViewById(R.id.editTextText1);
        pass=findViewById(R.id.editTextText2);
        birth=findViewById(R.id.editTextText3);
        save=findViewById(R.id.button_save);
        read=findViewById(R.id.button_read);
        save.setOnClickListener(v->{
           name_user=name.getText().toString();
           pass_user=pass.getText().toString();
           birth_user=birth.getText().toString();

            try {
                FileOutputStream fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
                PrintWriter pw=new PrintWriter(fos);
                pw.println(name_user+" "+pass_user+" "+birth_user);
//                momken houn kamen t5azen data serializble metl ma kona na3mel ya3ne metl ma kona na3mel object w na3melo implement serialization w ba3den njeebo w fena n5azno 3ala l malaf
                pw.close();
                fos.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            //heda code l write 3ala file law da8t 3ala save 7a ya3mel save

        });





        read.setOnClickListener(v->{
            try {
                FileInputStream fis=openFileInput(FILE_NAME);
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
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

    }

//    e.printStackTrace(): This method merely outputs the stack trace to the console for diagnostic purposes. It doesn't alter the control flow or cause the program to terminate.
//            throw new RuntimeException(e);: This statement throws a new exception (RuntimeException) which, if not caught further up the call stack, can lead to an uncaught exception and program termination (i.e., crash).


//    Handling the Original Exception: When you use throw new RuntimeException(e);, it doesn't handle the original exception (FileNotFoundException) directly. It creates a new exception (RuntimeException) with FileNotFoundException as its cause.

    //2aw 3ashen ma ta3mel crush feek tshel l throw new rintimeexeption heye hay bas la debugging 3ashen ta3ref ween sar fe error ma3ak
}
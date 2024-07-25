package com.example.datapersistance2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/*
ne7na 7kena 3an anwa3 zekra mn demna zekra l 5arejye w zekra de5leye b 2a2sama l 5asa w l 3ame

 internal storage vs external storage: l 5asa w l 3ame
1-
 internal storage:deyman mawjoude ya3ne ma fe she esmo eno tzeda 2aw tendaf 2aw tertefe3 2aw tshela 2aw portable 2aw tefselha deymn heye mote7a lesh l2no bultin bel jehez nafso
 external storage:ama l external storage momken tkoun 8ayr mote7a beb3d l 7alet metl ya3ne l user yeje yefselha mn jehez yshel l sd card 2aw yeje yoshbok wasle mn l telephone 3ala laptop fa bye3teber l operating system eno l telephone ma fe zekra 5arejeye

 fa de5leye deymn mawjoude w l 5erjeye momken tkoun mawjoude  yemken la2 w metl ma 2olna mnef7as abl ma nesta3mla


 2-
 internal storage:l files le btet5azan bel zekra l de5leye la yomken 7ada yosala la user wala application tene wala mne2dar nshofa ela mn 5elel l application nafso  ma 7ada byosala ela l application nafsha w metl ma 2olna l mode mna3mlo private 3ashen ma 7ada ye2dar yosala law bedna files nshereka ma3 nes tenye mna3mel she esmo sharedfiles
 external storage:l files le btet5azan bel zekra l 5arejeye bye2dar aye 7ada 5erej l application yet3emal ma3a bye2dar l user yshofa ya3ne mar2eye la jame3 sawe2 kenet bel zekra l 5asa 2aw l 3ama l kol bye2dar yshofa w yet3emal ma3a metl l sowar,vedios,music..etc

 fa l internal storage bas l application bey2dar yshofa w yet3emal ma3a l external l kol bey2dar yshofa w yet3mal ma3a

3-
 internal storage:bas ta3mel lal application unistall l operating system telk2yen be2om bya3mel delete la kel l files l 5asa bel application bel zekra de5leye l2no 5als mazel l application nmaa7a y3ne batal ye2dar yet3emal ma3a fa ma ela lzoum tkoun mawjoude
 external storage:bas ta3mel lal application unstall l operating system telk2ayen be2om bya3mel delete la kel l files l le mawjoude 3ala l external stroage l 5asa l met3al2a bel application ama l files le bekouno 3ala l external stroage l 3ame ma btenma7a

 bel internal stroage bas ta3mel unstall lal app kel l files le bel internal storage byenma7o sawe2 temporary files 2aw not temorary files ama bel external stroage bas tem7e l application l data le betkoun bel external storage l 5asa betrou7 ama data le bel external stroage l 3ame ma btema7a


 4-
 internal storage:testa5dem heek no3 bel l storage bas badna n5azen files 5asa bel application ma badna nshereka ma3 7ada 2aw l user yshofa ma badna 7ada 5erej l application ye2dar yosala sawe2 keen user 2aw application tene,metl kawe3ed baynet 2aw malefet 5asa be3mal l application
 external storage:esta5dem heek no3 bel l storage bas badna n5azen files aye 7ada bado yosala 2aw yet3mal ma3a sawe2 kenet 5asa 2aw 3ame metl l vedios sowar..etc

 */


/*
install location:
hala2 enta 7ebeb ta3mel application tnazlo 3ala l playstore laken heda l application metwa2e3 eno ykoun 7ajmo kbeer 20 gb w ma badak l user bas ynzalo y2aserlo 3al intenal storage l2no 2aw2at btle2e eno ma fe space bsser l wa7ad bado yle2e application yn2ol programs mn internal stroage la external storage fa enta feek t7ola mn l application:
btfout 3ala l manifict file w be tag l 5as bel manifics tektob tag esmo android:installLocation="" houn enta bt7aded l maken taba3 l install eno ween bado yeh yenzal heda l application

auto:7asab l user keef b7aded ya3ne iza fe wasa3 bel internal stroage benalo hounek iza fe wasa3 bel internal stroage benzlo bel external storage
internalonly:eno deymn yenzal 3al internal stroage mamno3 man3an betan yenzal 3al 5arejeye
preferExternal:eno yofadal enzal 3al external storage mn demna l sd card 3al external storage bas mesh darore yenzal tbe2a heda l requset bas howe befdel yenzal 3al external stroage l2no momekn ma ykoun fe wasa3 bel sd card yemken ma ykoun fe sd card yemken l external stroage ma tkoun mote7a bas tafdel 7a ykoun lal external stroage ne7na mn7ot tag bel manifict fa byefham l operating system mobashratan eno wala yofdal yenzal bel external storage













*/












public class DIFFER_BETWEEN_INTERNAL_STORAGE_EXTERNAL_STORAGE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_differ_between_internal_storage_external_storage);

    }
}
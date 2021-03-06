package com.umut.nakli.umutnakli.polarity;

import com.umut.nakli.umutnakli.submit.Submit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PolarityServiceImpl implements PolarityService {

    //@Autowired
    //SMORepository smoRepository;
    Map smowords = new HashMap();

    PolarityServiceImpl(){
        smowords.put("acar",-0.5);
        smowords.put("aci",0.4944);
        smowords.put("adim",-1.9918);
        smowords.put("ailem",-0.9199);
        smowords.put("aksamlar",-0.9593);
        smowords.put("aldim",0.1682);
        smowords.put("allah",-1.5515);
        smowords.put("allahim",-0.3378);
        smowords.put("almaya",-1.4404);
        smowords.put("ama",-0.5081);
        smowords.put("ameliyat",0.7974);
        smowords.put("an",-0.1031);
        smowords.put("anda",-0.4199);
        smowords.put("ani",-0.7316);
        smowords.put("arkadas",-1.0185);
        smowords.put("arkadaslar",0.4104);
        smowords.put("artik",0.7975);
        smowords.put("ask",-1.4814);
        smowords.put("asla pes",-0.9588);
        smowords.put("aslinda",0.7973);
        smowords.put("ay",-0.3386);
        smowords.put("ayakta",-0.5729);
        smowords.put("ayni",-0.2366);
        smowords.put("bahar",-0.4814);
        smowords.put("bakin",-0.6239);
        smowords.put("baknediyorum",0.0996);
        smowords.put("basima",-0.36);
        smowords.put("baska",-0.2896);
        smowords.put("basladim",-0.3644);
        smowords.put("baslar",-1.7227);
        smowords.put("bazen",0.9108);
        smowords.put("bazi",2.0206);
        smowords.put("bekliyorum",-0.1799);
        smowords.put("belki",-0.4175);
        smowords.put("ben bu",-1);
        smowords.put("bence",-0.171);
        smowords.put("bencehayat",0.1227);
        smowords.put("bende",-0.1586);
        smowords.put("beraber",-1.1039);
        smowords.put("bi",0.3272);
        smowords.put("biliyorum",-0.8879);
        smowords.put("bilmek",-0.7552);
        smowords.put("bir daha",0.1248);
        smowords.put("bir gun",-1.3498);
        smowords.put("bir hayat",-0.7153);
        smowords.put("bir sekilde",-1.0366);
        smowords.put("bir sey",0.4223);
        smowords.put("birsey",0.8304);
        smowords.put("bitti",-0.5564);
        smowords.put("bos",1.3665);
        smowords.put("boyle",0.3953);
        smowords.put("bu hayatta",-0.6821);
        smowords.put("bu kadar",0.6006);
        smowords.put("bu yuzden",0.031);
        smowords.put("bugun",-1.2257);
        smowords.put("butun",-0.7006);
        smowords.put("buyuk",-0.2569);
        smowords.put("can",-0.2424);
        smowords.put("canim",0.2953);
        smowords.put("cicek",-0.7348);
        smowords.put("cikti",0.682);
        smowords.put("cok",0.7353);
        smowords.put("cok guzel",-0.2858);
        smowords.put("cok kisa",-0.8131);
        smowords.put("cok seviyorum",-0.5185);
        smowords.put("cok sukur",-0.6785);
        smowords.put("cunku",-0.7006);
        smowords.put("daha cok",-0.6706);
        smowords.put("daha da",-0.7308);
        smowords.put("daha guzel",-0.5254);
        smowords.put("daha iyi",-0.4313);
        smowords.put("dans",-1.0342);
        smowords.put("dedim",-0.8583);
        smowords.put("deger",-0.469);
        smowords.put("degerli",-1.8928);
        smowords.put("degil",0.5082);
        smowords.put("degildir",-0.0719);
        smowords.put("degilim",0.6021);
        smowords.put("demek",-0.7546);
        smowords.put("demektir",-1.2339);
        smowords.put("dert",0.216);
        smowords.put("devam",-1.4432);
        smowords.put("devam et",-0.9697);
        smowords.put("diyorum",-0.6648);
        smowords.put("dogru",-0.1904);
        smowords.put("dolu",-0.2849);
        smowords.put("doya",-0.8276);
        smowords.put("dua",-0.4138);
        smowords.put("dunya",-0.5053);
        smowords.put("ediyorum",0.0148);
        smowords.put("eger",-1.5398);
        smowords.put("elbet",-1.0722);
        smowords.put("en buyuk",-0.1056);
        smowords.put("en guzel",-0.2246);
        smowords.put("en guzeli",-0.7488);
        smowords.put("enguzeli",-0.3752);
        smowords.put("et",-0.4697);
        smowords.put("etme",-0.9716);
        smowords.put("etmek",0.1691);
        smowords.put("etmeyi",-0.3437);
        smowords.put("etsin",0.5987);
        smowords.put("evet",-1.3003);
        smowords.put("fakat",0.1766);
        smowords.put("fazla",-0.0914);
        smowords.put("gec",-0.1877);
        smowords.put("gece",-0.1889);
        smowords.put("gececek",-0.1257);
        smowords.put("gecen",0.1759);
        smowords.put("gecer",0.0541);
        smowords.put("geciyor",0.0842);
        smowords.put("gecmis",-0.8648);
        smowords.put("geldi",0.3621);
        smowords.put("gelecek",-0.358);
        smowords.put("gelen",-0.4688);
        smowords.put("gelir",-0.7893);
        smowords.put("geliyor",0.5238);
        smowords.put("gercek",0.5752);
        smowords.put("gercekten",-0.0819);
        smowords.put("geri",-0.4098);
        smowords.put("gerisi",-0.8785);
        smowords.put("gibiyim",0.5031);
        smowords.put("gidiyor",-0.0272);
        smowords.put("gore",-0.8075);
        smowords.put("gormek",-0.9974);
        smowords.put("guc",-1);
        smowords.put("guclu",-2.0176);
        smowords.put("gulmek",-2.8625);
        smowords.put("gulumse",-2.1976);
        smowords.put("gulumsemek",-0.8205);
        smowords.put("gun",0.4886);
        smowords.put("gunaydin",-1.4796);
        smowords.put("gune",-0.5415);
        smowords.put("gunes",-1.6727);
        smowords.put("gunesli",-1.6555);
        smowords.put("gunler",-1.1488);
        smowords.put("gunu",-0.3115);
        smowords.put("guzel",-2.6359);
        smowords.put("guzel bir",0.2954);
        smowords.put("guzel gunler",0.0422);
        smowords.put("guzel seyler",-0.0153);
        smowords.put("guzeldir",-2.7684);
        smowords.put("guzeli",-0.7488);
        smowords.put("hadi",-1.0394);
        smowords.put("hafta",-0.4651);
        smowords.put("harika",-1.3136);
        smowords.put("hayal",-0.0015);
        smowords.put("hayat",-0.3067);
        smowords.put("hayata",-1.2101);
        smowords.put("hayati",-0.0379);
        smowords.put("hayatim",0.2538);
        smowords.put("hayatin",0.3335);
        smowords.put("hayatta",-0.5785);
        smowords.put("hayirli",-1.1524);
        smowords.put("hayirlisi",-1.1229);
        smowords.put("henuz",-0.5529);
        smowords.put("hep",0.7644);
        smowords.put("hepsi",0.1345);
        smowords.put("her sey",-0.283);
        smowords.put("her seye",-0.2448);
        smowords.put("her seye ragmen",0.1992);
        smowords.put("her seyi",-0.0107);
        smowords.put("her zaman",0.3518);
        smowords.put("herkes",0.3572);
        smowords.put("herkese",-0.271);
        smowords.put("hersey",-0.2407);
        smowords.put("herseye",-0.6689);
        smowords.put("herseye ragmen",-0.5);
        smowords.put("herseyi",0.2518);
        smowords.put("herseyin",-0.812);
        smowords.put("hic",0.4314);
        smowords.put("hic bir",-1.1204);
        smowords.put("hic bir sey",-0.3564);
        smowords.put("hicbir",-0.0351);
        smowords.put("hissediyorum",-0.1746);
        smowords.put("huzur",-1.2914);
        smowords.put("huzurlu",-1.7991);
        smowords.put("icin",-0.4449);
        smowords.put("icinde",-0.0716);
        smowords.put("ilk",-0.2541);
        smowords.put("inaniyorum",-1.4763);
        smowords.put("inat",-1.844);
        smowords.put("insallah",-1.2001);
        smowords.put("insan",-0.3836);
        smowords.put("insana",-0.0897);
        smowords.put("insani",-0.2705);
        smowords.put("insanin",-0.3221);
        smowords.put("insanlar",-0.4195);
        smowords.put("insanlara",0.7973);
        smowords.put("insanlari",0.5025);
        smowords.put("insanlarin",0.2332);
        smowords.put("iste",-0.2249);
        smowords.put("istiyorum",0.6542);
        smowords.put("iyi",-1.7758);
        smowords.put("iyi ki",-0.2361);
        smowords.put("iyi seyler",0.1406);
        smowords.put("iyisi",-1);
        smowords.put("iyiyim",-1.2974);
        smowords.put("izniyle",-0.4509);
        smowords.put("kaldi",0.7968);
        smowords.put("kalp",-0.3779);
        smowords.put("kan",-0.2647);
        smowords.put("kanser",-0.5637);
        smowords.put("kanserle",-1.8878);
        smowords.put("karanlik",-0.7001);
        smowords.put("kemoterapi",-0.1272);
        smowords.put("kemoterapim",-0.2116);
        smowords.put("kendime",-0.4917);
        smowords.put("kendimi",0.5967);
        smowords.put("keyif",-1.6204);
        smowords.put("kisa",-0.3794);
        smowords.put("kisi",-0.7344);
        smowords.put("kiymetini",-0.6277);
        smowords.put("kotu",0.8473);
        smowords.put("kucuk",-1.0848);
        smowords.put("lazim",-0.6843);
        smowords.put("mucadele",-1.6533);
        smowords.put("mucizeler",-1.5602);
        smowords.put("muhtesem",-1.3875);
        smowords.put("mukemmel",-1.2881);
        smowords.put("mutlu",-1.1294);
        smowords.put("mutlu olmak",-0.0666);
        smowords.put("mutluluk",-1.3394);
        smowords.put("mutluyum",-1.8291);
        smowords.put("nasil",0.795);
        smowords.put("nasip",-1);
        smowords.put("nasip etsin",0);
        smowords.put("ne de",-0.3649);
        smowords.put("ne guzel",-0.4751);
        smowords.put("ne kadar",0.3838);
        smowords.put("ne olursa",-0.1806);
        smowords.put("ne olursa olsun",-0.1806);
        smowords.put("ne zaman",-0.107);
        smowords.put("nefes",-0.1696);
        smowords.put("neler",-1.3933);
        smowords.put("o kadar",-0.0032);
        smowords.put("ol",-1.2267);
        smowords.put("olabilir",-0.0747);
        smowords.put("olacak",-0.8699);
        smowords.put("olalim",-0.8916);
        smowords.put("olan",-1.1342);
        smowords.put("olarak",0.0388);
        smowords.put("oldu",0.4396);
        smowords.put("oldugu",-0.0005);
        smowords.put("oldugunu",0.1834);
        smowords.put("oldum",-0.0028);
        smowords.put("olmadan",-1.0112);
        smowords.put("olmak",-1.6077);
        smowords.put("olmak icin",0.6309);
        smowords.put("olmasi",0.2486);
        smowords.put("olmaya",0.0171);
        smowords.put("olmayi",-0.5442);
        smowords.put("olsa",0.0469);
        smowords.put("olsun",-0.8395);
        smowords.put("olumlu",-1.1543);
        smowords.put("olumluluk",-1);
        smowords.put("olumluyum",-1.4629);
        smowords.put("olun",-0.2249);
        smowords.put("olur",-0.4884);
        smowords.put("olursa",-0.4056);
        smowords.put("olursa olsun",-0.3102);
        smowords.put("oluyor",0.0529);
        smowords.put("once",0.2701);
        smowords.put("onemli",-0.6351);
        smowords.put("onemli olan",-1.2619);
        smowords.put("oyle",0.2509);
        smowords.put("pes",-2.0767);
        smowords.put("rabbim",0.2233);
        smowords.put("ragmen",-1.6162);
        smowords.put("rahat",-0.4754);
        smowords.put("sabah",-0.0002);
        smowords.put("sabir",-1.0893);
        smowords.put("saclarim",-0.8214);
        smowords.put("sadece",0.5625);
        smowords.put("saglik",-0.8029);
        smowords.put("saglikli",-0.5499);
        smowords.put("sahip",-1.309);
        smowords.put("sakin",-0.6828);
        smowords.put("sanki",0.2809);
        smowords.put("saygi",-0.2989);
        smowords.put("sebep",0);
        smowords.put("sekilde",0.0114);
        smowords.put("sev",-1);
        smowords.put("sevgi",-2.6927);
        smowords.put("sevgili",-0.8497);
        smowords.put("sevilmek",-0.7451);
        smowords.put("sevin",-1.4982);
        smowords.put("sevince",-1.6201);
        smowords.put("seviyorum",-2.211);
        smowords.put("sevmek",-1.1926);
        smowords.put("sey",-0.2151);
        smowords.put("seyden",-1.0428);
        smowords.put("seye",-0.2448);
        smowords.put("seye ragmen",-0.8008);
        smowords.put("seyi",0.0034);
        smowords.put("seyin",0.9634);
        smowords.put("seyler",-0.5112);
        smowords.put("seyler olacak",-0.1739);
        smowords.put("seyleri",-0.3683);
        smowords.put("sifa",-0.0432);
        smowords.put("simdi",-0.1797);
        smowords.put("son",0.1733);
        smowords.put("sonrasi",-1.4175);
        smowords.put("sonsuz",-0.5893);
        smowords.put("sonunda",-1.0435);
        smowords.put("soz",-0.9061);
        smowords.put("su",0.0644);
        smowords.put("sukur",-2.231);
        smowords.put("sukurler",-0.9305);
        smowords.put("sukurler olsun",-0.8611);
        smowords.put("surece",-0.4365);
        smowords.put("tadini",-1.62);
        smowords.put("tam",0.306);
        smowords.put("tatli",-1.5414);
        smowords.put("tedavim",0.0837);
        smowords.put("tek",0.7098);
        smowords.put("temiz",-0.2049);
        smowords.put("tesekkur",-0.6433);
        smowords.put("tum",-1.0461);
        smowords.put("uc",0.0503);
        smowords.put("umudun",-0.4538);
        smowords.put("umut",-1.0629);
        smowords.put("umut var",-0.3077);
        smowords.put("unutma",-0.5363);
        smowords.put("unutmayin",-1.4281);
        smowords.put("uzun",-0.1416);
        smowords.put("vardir",-1.1155);
        smowords.put("varsa",-0.6995);
        smowords.put("vazgecme",-2.3731);
        smowords.put("ve ben",-0.0343);
        smowords.put("ve bu",-0.1464);
        smowords.put("ve her",-1.0938);
        smowords.put("versin",0.5095);
        smowords.put("yanimda",-0.4503);
        smowords.put("yaninda",-0.9335);
        smowords.put("yapmak",-0.7186);
        smowords.put("yarin",0.1794);
        smowords.put("yasa",-0.6309);
        smowords.put("yasam",0.5215);
        smowords.put("yasama",-1.1336);
        smowords.put("yasamak",-0.9333);
        smowords.put("yasamaktir",-0.67);
        smowords.put("yasamaya",-0.9944);
        smowords.put("yasamaya deger",-0.054);
        smowords.put("yasiyorum",-1.4736);
        smowords.put("yavas",0.3293);
        smowords.put("yemek",-0.5171);
        smowords.put("yeni",-0.6528);
        smowords.put("yeniden",-1.5263);
        smowords.put("yerde",-0.2285);
        smowords.put("yere",-0.294);
        smowords.put("yeter",-0.8305);
        smowords.put("yeterki",-1.0602);
        smowords.put("yil",0.613);
        smowords.put("yok",0.4984);
        smowords.put("yoktur",-0.8351);
        smowords.put("yol",-0.0625);
        smowords.put("yuzden",0.0003);
        smowords.put("zaman",-0.1226);
        smowords.put("zamanda",-0.9699);
        smowords.put("zaten",0.1896);
        smowords.put("zor",1.8943);
        smowords.put("ðÿ˜š",-1.4519);
        smowords.put("ðÿ˜�",0.1194);
        smowords.put("ðÿ™�",-1.4007);
        smowords.put("ılk",-1.0165);
        smowords.put("ınsan",-0.0017);
        smowords.put("ıyi",-1.2237);
        smowords.put("acilar",0.5017);
        smowords.put("acimasiz",1.2141);
        smowords.put("aciyor",0.6309);
        smowords.put("agir",0.9586);
        smowords.put("aglamak",0.6083);
        smowords.put("alip",0.4444);
        smowords.put("aliyorum",0.1801);
        smowords.put("anladim",0.1291);
        smowords.put("anlami",0.9294);
        smowords.put("aralar",0.3574);
        smowords.put("arasinda",0.448);
        smowords.put("basina",0.7715);
        smowords.put("basliyor",0.3044);
        smowords.put("be",1.3444);
        smowords.put("belki de",1.3239);
        smowords.put("belli",0.5396);
        smowords.put("bencehayat bir",0.612);
        smowords.put("bencehayat cok",0.8153);
        smowords.put("benim icin",0.8212);
        smowords.put("berbat",1);
        smowords.put("biktim",0.8355);
        smowords.put("bile bile",1.2659);
        smowords.put("biliyor",0.7848);
        smowords.put("bilmiyorum",-0.1986);
        smowords.put("bir yer",1.1716);
        smowords.put("birer",0.2925);
        smowords.put("birini",-0.0195);
        smowords.put("bisey",0.3084);
        smowords.put("bitse",1);
        smowords.put("bok",0.6221);
        smowords.put("bosa",0.2187);
        smowords.put("cabuk",0.8393);
        smowords.put("canimi",0.0436);
        smowords.put("caresizlik",0.9148);
        smowords.put("cevap",0.5571);
        smowords.put("cocuk",0.7964);
        smowords.put("cok acimasiz",0.0659);
        smowords.put("cok kotu",0.2534);
        smowords.put("cok zor",0.3242);
        smowords.put("dedi",0.3351);
        smowords.put("dedigin",-0.0963);
        smowords.put("degil mi",0.8713);
        smowords.put("derken",-0.2371);
        smowords.put("dersin",0.4719);
        smowords.put("devam ediyor",1.171);
        smowords.put("diyorlar",1.0806);
        smowords.put("dualarinizi",1.6827);
        smowords.put("dun",0.8205);
        smowords.put("dunyada",0.4565);
        smowords.put("dunyanin",0.121);
        smowords.put("eksik",-0.169);
        smowords.put("en cok",0.9777);
        smowords.put("eski",0.3554);
        smowords.put("etmeye",-0.0426);
        smowords.put("fark",0.0709);
        smowords.put("galiba",0.4008);
        smowords.put("garip",-0.0178);
        smowords.put("geceler",1.5237);
        smowords.put("gecmiyor",1);
        smowords.put("gelmiyor",0.8012);
        smowords.put("gercekler",1);
        smowords.put("gereken",0.2896);
        smowords.put("gibi geliyor",0.1723);
        smowords.put("gibi hissediyorum",0.7218);
        smowords.put("giden",0.5652);
        smowords.put("git",0.4004);
        smowords.put("gitti",0.7547);
        smowords.put("goz",0.6242);
        smowords.put("gunlere",0.0078);
        smowords.put("hak",1.0703);
        smowords.put("halim",0.3029);
        smowords.put("hayat bu",0.1351);
        smowords.put("hayatimda",0.295);
        smowords.put("hayattan",0.0012);
        smowords.put("her gun",-0.5451);
        smowords.put("herkesin",1.1432);
        smowords.put("herkesten",1);
        smowords.put("herseyden",0.3531);
        smowords.put("hicbir sey",1.1985);
        smowords.put("hicbirsey",0.5029);
        smowords.put("ibaret",0.3961);
        smowords.put("icine",0.3892);
        smowords.put("ihtiyacim",1.2494);
        smowords.put("insanlarla",0.5601);
        smowords.put("isin",0.0758);
        smowords.put("istemiyorum",1.2669);
        smowords.put("izin",0.1278);
        smowords.put("kac",0.9563);
        smowords.put("kadar cok",-0.7502);
        smowords.put("kalan",-0.0952);
        smowords.put("kalmadi",0.503);
        smowords.put("kalmak",0.6576);
        smowords.put("kalmamis",1);
        smowords.put("karsi",0.2011);
        smowords.put("kaybettim",0.9326);
        smowords.put("kemoterapi tedavim",0);
        smowords.put("kendim",0.7957);
        smowords.put("kendimi cok",-0.3007);
        smowords.put("kere",-0.3409);
        smowords.put("keske",1.5052);
        smowords.put("kimsenin",0.5939);
        smowords.put("kimseye",1.2642);
        smowords.put("kimseyi",1.1152);
        smowords.put("koca",0.5027);
        smowords.put("koca bir",1);
        smowords.put("kocaman",0.4013);
        smowords.put("korkuyorum",0.9548);
        smowords.put("lanet",0.5213);
        smowords.put("maalesef",1.0669);
        smowords.put("meme",0.6418);
        smowords.put("merhaba",0.115);
        smowords.put("mide",0.914);
        smowords.put("mucize",0.2675);
        smowords.put("mutsuz",0.5527);
        smowords.put("mutsuzluk",2);
        smowords.put("nasil bir",0.7415);
        smowords.put("ne olur",1.4355);
        smowords.put("ne varsa",0.6137);
        smowords.put("nefret",0.3933);
        smowords.put("o kadar cok",1.0214);
        smowords.put("ogrendim",0.3691);
        smowords.put("oldugum",0.7304);
        smowords.put("oldugumu",0.9857);
        smowords.put("olmadi",1.4189);
        smowords.put("olmadigi",-0.38);
        smowords.put("olmayacak",1.8594);
        smowords.put("olmayan",0.3448);
        smowords.put("olmaz",-0.1629);
        smowords.put("olmek",0.4781);
        smowords.put("olmus",0.8889);
        smowords.put("olmuyor",0.5767);
        smowords.put("olum",1.6219);
        smowords.put("olum var",0.0154);
        smowords.put("olume",1.6621);
        smowords.put("olumu",1.2619);
        smowords.put("olumun",0.5752);
        smowords.put("olup",0.4681);
        smowords.put("oluyorum",-0.2082);
        smowords.put("omur",0.5223);
        smowords.put("oyun",0.5021);
        smowords.put("oyunu",0.9565);
        smowords.put("ozluyorum",1.1629);
        smowords.put("ruh",0.4013);
        smowords.put("ruh halim",-0.1988);
        smowords.put("sahte",0.7265);
        smowords.put("sanirim",-0.4542);
        smowords.put("sikinti",0.4527);
        smowords.put("sonu",1.1485);
        smowords.put("suan",0.5739);
        smowords.put("tedavi",0.2328);
        smowords.put("tekrar",0.2512);
        smowords.put("turlu",0.3978);
        smowords.put("uzerine",-0.1873);
        smowords.put("uzgunum",1.3861);
        smowords.put("var ki",-0.0841);
        smowords.put("var mi",0);
        smowords.put("vardi",1.4479);
        smowords.put("verip",1);
        smowords.put("verir",0.6558);
        smowords.put("ya da",1.1703);
        smowords.put("yada",1.6643);
        smowords.put("yalan",1.3815);
        smowords.put("yalniz",0.7965);
        smowords.put("yanlis",0.3069);
        smowords.put("yarim",0.6622);
        smowords.put("yasarken",0.3325);
        smowords.put("yasayan",1.1464);
        smowords.put("yasiyoruz",0.6089);
        smowords.put("yer",-0.8917);
        smowords.put("yerden",0.1893);
        smowords.put("yillar",0.3792);
        smowords.put("yinede",0.4006);
        smowords.put("yokmus",0.9882);
        smowords.put("yolunda",0.2479);
        smowords.put("yorgun",0.795);
        smowords.put("yorgunum",0.2198);
        smowords.put("yoruldum",1.1202);
        smowords.put("yoruyor",0.7724);
        smowords.put("yuzunden",0.6501);
        smowords.put("zamani",0.3223);
        smowords.put("zamanlar",0.9137);
        smowords.put("zorunda",0.7914);
        smowords.put("â€�",1.3135);
        smowords.put("ıki",0.7185);
        smowords.put("ınsanlar",0.8587);
    }

    @Override
    public String decidePolarity(Submit submit) {
        //Burda submit'i alup hesaplama işlemi yapcak
        //float weight = 0.4976f;
        double weight = 0.0f;
        System.out.println("isler yolunda");
        System.out.println(submit.getText());
        List<String> words = new ArrayList<String>();
        // keliemeler parcalara ayrılıyor.
        String[] result = submit.getText()
                .toLowerCase()
                .replace('ı','i')
                .replace('ö', 'o')
                .replace('ü','u').split("\\W");
        System.out.println("word listesine ekleme yapılıyor.");
        for (int x=0; x<result.length; x++){
            if(!result[x].isEmpty())
                words.add(result[x]);
        }
        System.out.println("word listesineki kelimeler veritabanında aranıyor.");
        for (String word: words) {
            if(smowords.get(word) != null){
                System.out.println(word + " bulundu " + "agirligi : " + smowords.get(word));
                weight = weight + (double) smowords.get(word);
            }
            else{
                System.out.println("Bulunamadi");
            }
        }
        System.out.println("Toplam agirligi :" + weight);
        String pol;
        if(weight > 0){
            pol = "olumsuz";
            return pol;
        }
        else if(weight < 0){
            pol = "olumlu";
            return pol;
        }
        else {
            return "notr";
        }
    }
}
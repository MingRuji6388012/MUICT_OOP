import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegEx {
    public static void main(String[] args)
    {	String a = "";
        a += "ABC";
        a += "-DEF";
        //System.out.println(a == null);
        System.out.println(a);

        //Using Patterns
        //Check email address format Suppawong_1234@gmail.com // . is a metachatacter, you must escape it first
        Pattern p = Pattern.compile("[a-z0-9A-Z_]+@[a-z]+\\.com");
        String[] emails = {"Suppawong_1234@gmail.com", "suppawong.tuarob@gmail.com",
                "Suppawong_1234@gmail.net", "Suppawong_1234#gmail.com"};
        for(String email: emails)
        {
            Matcher m = p.matcher(email);
            System.out.println(email+":"+m.matches());
        }

        //Using String.matches
        System.out.println("using String.matches()");
        for(String email: emails)
        {
            System.out.println(email+":"+email.matches("[a-z0-9A-Z_]+@[a-z]+\\.com"));
        }

        //cool thing .. extracting all the emails
        String muictPage = "Computer Science Academic Group     Emeritus Professor Dr. Supachai Tangwongsan  Position: Emeritus Professor  E-mail: supachai.tws@mahidol.ac.th  CV      Acting Head of the Computer Science Academic Group  Lect. Dr. Pattanasak Mongkolwat  Position: Instructor  E-mail: pattanasak.mon@mahidol.ac.th       Professor Dr. Peter Fereed Haddawy  Position: Professor  E-mail: peter.had@mahidol.ac.th  Personal Website  CV       Assoc. Prof. Dr. Jarernsri L. Mitrpanont  Position: Associate Professor  E-mail: jarernsri.mit@mahidol.ac.th       Assoc. Prof. Dr. Chomtip Pornpanomchai  Position: Associate Professor  E-mail: chomtip.por@mahidol.ac.th  CV       Assoc. Prof. Dr. Damras Wongsawang  Position: Associate Professor  E-mail: damras.won@mahidol.ac.th  CV      Assoc. Prof. Dr. Worapan Kusakunniran  Position: Associate Professor  E-mail: worapan.kus@mahidol.ac.th, worapan.kun@mahidol.ac.th  Personal Website  CV       Assoc. Prof. Dr. Vasaka Visoottiviseth  Position: Associate Professor  E-mail: vasaka.vis@mahidol.ac.th  Personal Website  CV       Assoc. Prof. Dr. Sudsanguan Ngamsuriyaroj  Position: Associate Professor  E-mail: sudsanguan.nga@mahidol.ac.th  Personal Website  CV       Asst. Prof. Dr. Charnyote Pluempitiwiriyawej  Position: Assistant Professor  E-mail: charnyote.plu@mahidol.ac.th       Asst. Prof. Dr. Thitinan Tantidham  Position: Assistant Professor  E-mail: thitinan.tan@mahidol.ac.th  Personal Website  CV       Asst. Prof. Dr. Songsri Tangsripairoj  Position: Assistant Professor  E-mail: songsri.tan@mahidol.ac.th  Personal Website  CV       Asst. Prof. Dr. Thanwadee Sunetnanta  Position: Assistant Professor  E-mail: thanwadee.sun@mahidol.ac.th  Personal Website  CV       Asst. Prof. Dr. Boonsit Yimwadsana  Position: Assistant Professor  E-mail: boonsit.yim@mahidol.ac.th  Personal Websiter       Asst. Prof. Dr. Preecha Tangworakitthaworn  Position: Assistant Professor  E-mail: preecha.tan@mahidol.ac.th  CV       Asst. Prof. Dr. Piyanuch Silapachote  Position: Assistant Professor  E-mail: piyanuch.silmahidol.edu  CV       Asst. Prof. Dr. Mores Prachyabrued  Position: Assistant Professor  E-mail: mores.pra@mahidol.ac.th  Personal Website  CV       Asst. Prof. Dr. Rawesak Tanawongsuwan  Position: Assistant Professor  E-mail: rawesak.tan@mahidol.ac.th  CV       Asst. Prof. Dr. Srisupa Palakvangsa Na Ayudhya  Position: Assistant Professor  E-mail: srisupa.palmahidol.edu  Personal Website      Asst. Prof. Dr. Suppawong Tuarob  Position: Assistant Professor  E-mail: suppawong.tuamahidol.edu  Personal Website       Asst. Prof. Dr. Sukanya Phongsuphap  Position: Assistant Professor  E-mail: sukanya.pho@mahidol.ac.th       Asst. Prof. Dr. Ananta Srisuphab  Position: Assistant Professor  E-mail: ananta.srimahidol.edu  CV       Asst. Prof. Dr. Apirak Hoonlor  Position: Assistant Professor  E-mail: apirak.hoo@mahidol.ac.th  CV       Asst. Prof. Dr. Robert Edward Lucien Egrot  Position: Assistant Professor  E-mail: robert.egr@mahidol.ac.th  Personal Website  CV       Lect. Dr. Jidapa Kraisangka  Position: Instructor  E-mail: jidapa.kra@mahidol.ac.th  CV       Lect. Dr. Chaiyong Ragkhitwetsagul  Position: Instructor  E-mail: chaiyong.rag@mahidol.ac.th  Personal Website  CV       Lect. Dr. Thitivatr Patanasakpinyo  Position: Instructor  E-mail: thitivatr.pat@mahidol.ac.th  Personal Website  CV       Lect. Dr. Dolvara Guna-Tilaka  Position: Instructor  E-mail: dolvara.gun@mahidol.ac.th  CV      Lect. Dr. Thanapon Noraset  Position: Instructor  E-mail: thanapon.normahidol.edu  CV       Lect. Dr. Pawitra Liamruk  Position: Instructor  E-mail: pawitra.lia@mahidol.ac.th  CV       Lect. Dr. Pilailuck Panphattarasap  Position: Instructor  E-mail: pilailuck.pan@mahidol.ac.th  CV       Lect. Dr. Pisit Praiwattana  Position: Instructor  E-mail: pisit.pra@mahidol.ac.th    Lect. Dr. Petch Sajjacholapunt  Position: Instructor  E-mail: petch.saj@mahidol.ac.th  CV       Lect. Dr. Morakot Choetkiertikul  Position: Instructor  E-mail: morakot.cho@mahidol.ac.th  Personal Website  CV       Lect. Dr. Woraluck Wongse-Ek  Position: Instructor  E-mail: woraluck.won@mahidol.ac.th       Lect. Dr. Wudhichart Sawangphol  Position: Instructor  E-mail: wudhichart.saw@mahidol.ac.th  CV       Lect. Dr. Siripen Pongpaichet  Position: Instructor  E-mail: siripen.pon@mahidol.ac.th  CV       Lect. Dr. Akara Supratak  Position: Instructor  E-mail: akara.supmahidol.edu  CV       Lect. Dr. Assadarat Khurat  Position: Instructor  E-mail: assadarat.khu@mahidol.ac.th  CV       Lect. Dr. Ittipon Rassameeroj  Position: Instructor  E-mail: ittipon.ras@mahidol.ac.th  Personal Website      Lect. Pagaporn Pengsart  Position: Instructor  E-mail: pagaporn.pen@mahidol.ac.th       Lect. Snit Sanghlao  Position: Instructor  E-mail: snit.san@mahidol.ac.th       Miss Tipajin Thaipisutikul (Studying abroad)  Position: Instructor  E-mail: tipajin.tha@mahidol.ac.th       Miss Pattaraporn Sangaroonsilp (Studying abroad)  Position: Instructor  E-mail: pattaraporn.san@mahidol.ac.th  CV      Mr. Atthapan Daramas (Studying abroad)  Position: Instructor  E-mail: atthapan.dar@mahidol.ac.th";
        Pattern muemailp = Pattern.compile("([a-z0-9A-Z_\\.]+)@([a-z]+)\\.(com|ac\\.th)");
        //Matcher m = muemailp.matcher("songsri.tan@mahidol.ac.th");
        //System.out.println(m.matches());
        Matcher mum = muemailp.matcher(muictPage);
        while(mum.find())
        {
            String email = mum.group(0);
            System.out.println("Group0:"+mum.group(0));	//all the email
            System.out.println("Group1:"+mum.group(1));	//username
            System.out.println("Group2:"+mum.group(2));	//hostname
            System.out.println("Group3:"+mum.group(3)+"\n");	//com or ac.th
        }
    }
}
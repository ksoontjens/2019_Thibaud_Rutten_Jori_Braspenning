package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.event.*;
import java.util.Random.*;
import org.dvb.event.*;
import org.havi.ui.event.*;
import org.havi.ui.*;
import java.awt.*;

public class HelloTVXlet implements Xlet, HActionListener, ActionListener,UserEventListener {
    
    static HScene scene;
    private HText start;
    private HText einde;
    private HText resultaat;
    private HText opnieuw;
    private boolean quizIsBezig = false;
    private boolean quizIsGedaan = false;
    private HTextButton a;
    private HTextButton b;
    private HTextButton c;
    private HTextButton d;
    private boolean AisSelected = true;
    private boolean BisSelected;
    private boolean CisSelected;
    private boolean DisSelected;
    private HText vraag;
    private HText puntenTekst;
    private HText validpopup;
    int huidigeVraag = 1;
    int punten = 0;
    Vraag[] vragen = new Vraag[20];
   

    public HelloTVXlet() {
        
    }
    
    public static HScene getScene(){
        return scene;
    }
    
    public void initXlet(XletContext context) {
        vragen[1] = new Vraag("Op welke planeet trouwden Bird Person en Tammy?");
        
        vragen[1].setA("C-302");
        vragen[1].setB("Pluto");
        vragen[1].setC("C-35");   
        vragen[1].setD("Planet Squanch");
        vragen[1].setCorrect("d");
        
        
        vragen[2] = new Vraag("Wat gebruikt Rick om door de ruimte te reizen?");
        
        vragen[2].setA("Space Laser");
        vragen[2].setB("Portal Gun");
        vragen[2].setC("Tardis");   
        vragen[2].setD("Universe Key");
        vragen[2].setCorrect("b");
        
        
        vragen[3] = new Vraag("Op wie is Morty gebaseerd?");
        
        vragen[3].setA("Frankenstein");
        vragen[3].setB("Marty Mcfly");
        vragen[3].setC("Hugo Strange");   
        vragen[3].setD("Adam Webber");
        vragen[3].setCorrect("b");
        
        
        vragen[4] = new Vraag("Wat zijn de 'Ball Fondlers'?");
        
        vragen[4].setA("Televisie serie");
        vragen[4].setB("Vijanden");
        vragen[4].setC("Vrienden");
        vragen[4].setD("Een muziekgroep");
        vragen[4].setCorrect("a");
        
        
        vragen[5] = new Vraag("Op wie is Morty verliefd?");
        
        vragen[5].setA("Annie");
        vragen[5].setB("Jessica");
        vragen[5].setC("Sophie");
        vragen[5].setD("Jackie");
        vragen[5].setCorrect("b");
         
        
        vragen[6] = new Vraag("Wat is de catchphrase van Scary Terry?");
        
        vragen[6].setA("Boo");
        vragen[6].setB("Kablam");
        vragen[6].setC("Bitch");
        vragen[6].setD("Dickhead");
        vragen[6].setCorrect("c");

        
        vragen[7] = new Vraag("Wie was de zogenaamde beste arts van het heelal?");
        
        vragen[7].setA("Shleemypants");
        vragen[7].setB("Courier Flap");
        vragen[7].setC("Red Line");
        vragen[7].setD("St. Gloopy Noobs");
        vragen[7].setCorrect("d");

        
        vragen[8] = new Vraag("Hoe heet de auto batterij van Rick?");
        
        vragen[8].setA("Multiverse");
        vragen[8].setB("Teenyverse");
        vragen[8].setC("Ultraverse");
        vragen[8].setD("Microverse");
        vragen[8].setCorrect("d");
        
         
        vragen[9] = new Vraag("Wie veraadt Rick op het einde van seizoen 2?");
        
        vragen[9].setA("Jessica");
        vragen[9].setB("Beth");
        vragen[9].setC("Jerry");
        vragen[9].setD("Morty");
        vragen[9].setCorrect("c");


        vragen[10] = new Vraag("Waar is Rick bang van?");
        
        vragen[10].setA("Eekhoorns");
        vragen[10].setB("Piraten");
        vragen[10].setC("Duivels");
        vragen[10].setD("Jelly beans");
        vragen[10].setCorrect("b");

        
        vragen[11] = new Vraag("Hoeveel knoppen heeft Rick Sachhez zijn portel gun?");
        
        vragen[11].setA("4");
        vragen[11].setB("1");
        vragen[11].setC("3");
        vragen[11].setD("2");
        vragen[11].setCorrect("b");


        vragen[12] = new Vraag("Hoe heet de saus waar Rick zot van is?");
        
        vragen[12].setA("Szechuan sauce");
        vragen[12].setB("Mayonaise");
        vragen[12].setC("Ketchup");
        vragen[12].setD("Tabasco");
        vragen[12].setCorrect("a");
         
        
        vragen[13] = new Vraag("Op wie was Summer verliefd in de eerste aflevering?"); 
        
        vragen[13].setA("Ash");
        vragen[13].setB("Nathan");
        vragen[13].setC("Frank");
        vragen[13].setD("Jason");
        vragen[13].setCorrect("c");

        
        vragen[14] = new Vraag("Wie spreekt de stem in van Jerry Smith?");
        
        vragen[14].setA("Justin Roiland");
        vragen[14].setB("Spencer Grammer"); 
        vragen[14].setC("Dan Harmon"); 
        vragen[14].setD("Chris Parnell"); 
        vragen[14].setCorrect("d");
        
        
        vragen[15] = new Vraag("Wat zijn de eerste woorden van Morty Jr. ?");
        
        vragen[15].setA("Domination");
        vragen[15].setB("Destroy"); 
        vragen[15].setC("Decimate"); 
        vragen[15].setD("Democrats"); 
        vragen[15].setCorrect("a");
         
         
         
        scene = HSceneFactory.getInstance().getDefaultHScene();
        startScreen(); 
    }
    
    public void startScreen(){
        scene.removeAll();
        AisSelected = true;
        huidigeVraag = 1;
        punten = 0;
        quizIsBezig = false;
        quizIsGedaan = false;
        start = new HText("Druk enter om de Rick en Morty Quiz te starten");
        start.setBackground(Color.CYAN);
        start.setBackgroundMode(HVisible.BACKGROUND_FILL);
        start.setLocation(100,10);
        start.setSize(500,100);
        start.setBordersEnabled(false);
        scene.add(start);
        
        scene.repaint();
        scene.validate();
        scene.setVisible(true);
    }
    
    public void StelEenVraag(){
        scene.removeAll();
        AisSelected = true;
        BisSelected = false;
        CisSelected = false;
        DisSelected = false;
        scene = HSceneFactory.getInstance().getDefaultHScene();
        vraag = new HText(vragen[huidigeVraag].getStel());
        vraag.setBackground(Color.CYAN);
        vraag.setBackgroundMode(HVisible.BACKGROUND_FILL);
        vraag.setBordersEnabled(false);
        vraag.setLocation(100,100);
        vraag.setSize(500,80);
        
        
        scene.add(vraag);
        
        puntenTekst = new HText("Punten: " + punten);
        puntenTekst.setLocation(600,10);
        puntenTekst.setSize(120,60);
        puntenTekst.setBackground(Color.BLUE);
        puntenTekst.setBackgroundMode(HVisible.BACKGROUND_FILL);
        puntenTekst.setBordersEnabled(false);
        scene.add(puntenTekst);
        
        a = new HTextButton(vragen[huidigeVraag].getA());
        a.setLocation(125,250);
        a.setSize(200,100);
        a.setBackground(Color.PINK);
        a.setBackgroundMode(HVisible.BACKGROUND_FILL);
        a.setActionCommand("a");
        a.addHActionListener(this);
        scene.add(a);
        
        
        b = new HTextButton(vragen[huidigeVraag].getB());
        b.setLocation(375,250);
        b.setSize(200,100);
        b.setBackground(Color.MAGENTA);
        b.setBackgroundMode(HVisible.BACKGROUND_FILL);
        b.setActionCommand("b");
        b.addHActionListener(this);
        scene.add(b);

        c = new HTextButton(vragen[huidigeVraag].getC());
        c.setLocation(125,400);
        c.setSize(200,100);
        c.setBackground(Color.MAGENTA);
        c.setBackgroundMode(HVisible.BACKGROUND_FILL);
        c.setActionCommand("a");
        c.addHActionListener(this);
        scene.add(c);
        
        d = new HTextButton(vragen[huidigeVraag].getD());
        d.setLocation(375,400);
        d.setSize(200,100);
        d.setBackground(Color.MAGENTA);
        d.setBackgroundMode(HVisible.BACKGROUND_FILL);
        d.setActionCommand("a");
        d.addHActionListener(this);
        scene.add(d);
        
        scene.repaint();
        scene.validate();
        scene.setVisible(true);
    }
   
    
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        if(action.equals("a")){
            a.setBackground(Color.MAGENTA);
            a.repaint();
            scene.add(a);
        scene.validate();
        scene.repaint();
        }
    }

    public void startXlet()  {
        EventManager manager = EventManager.getInstance();
        UserEventRepository repos = new UserEventRepository("Keys");
        repos.addAllArrowKeys();
        repos.addKey(HRcEvent.VK_ENTER);
        manager.addUserEventListener(this,repos);
        
    }
    
      public void userEventReceived(UserEvent e){
        if(e.getType() == KeyEvent.KEY_PRESSED){
            switch(e.getCode()){
                case HRcEvent.VK_LEFT:
                    if(BisSelected){
                        a.setBackground(Color.PINK); a.repaint();
                        b.setBackground(Color.MAGENTA); b.repaint();
                        BisSelected = false;
                        AisSelected = true;
                        CisSelected = false;
                        DisSelected = false;
                    }
                    if(DisSelected){
                        d.setBackground(Color.MAGENTA); d.repaint();
                        c.setBackground(Color.PINK); c.repaint();
                        CisSelected = true;
                        DisSelected = false;
                        AisSelected = false;
                        BisSelected = false;
                    }
                    break;
                case HRcEvent.VK_RIGHT:
                    if(AisSelected){
                        a.setBackground(Color.MAGENTA); a.repaint();
                        b.setBackground(Color.PINK); b.repaint();
                        BisSelected = true;
                        AisSelected = false;
                        CisSelected = false;
                        DisSelected = false;
                    }
                    if(CisSelected){
                        c.setBackground(Color.MAGENTA); c.repaint();
                        d.setBackground(Color.PINK); d.repaint();
                        DisSelected = true;
                        CisSelected = false;
                        AisSelected = false;
                        BisSelected = false;
                    }
                    break;
                case HRcEvent.VK_UP:
                    if(CisSelected){
                        a.setBackground(Color.PINK); a.repaint();
                        c.setBackground(Color.MAGENTA); c.repaint();
                        AisSelected = true;
                        CisSelected = false;
                        BisSelected = false;
                        DisSelected = false;
                    }
                    if(DisSelected){
                        d.setBackground(Color.MAGENTA); d.repaint();
                        b.setBackground(Color.PINK); b.repaint();
                        BisSelected = true;
                        DisSelected = false;
                        CisSelected = false;
                        AisSelected = false;
                    }
                    break;
                case HRcEvent.VK_DOWN:
                    if(AisSelected){
                        a.setBackground(Color.MAGENTA); a.repaint();
                        c.setBackground(Color.PINK); c.repaint();
                        CisSelected = true;
                        AisSelected = false;
                        DisSelected = false;
                        BisSelected = false;
                    }
                    if(BisSelected){
                        b.setBackground(Color.MAGENTA); b.repaint();
                        d.setBackground(Color.PINK); d.repaint();
                        DisSelected = true;
                        BisSelected = false;
                        AisSelected = false;
                        CisSelected = false;
                    }
                    break;
                case HRcEvent.VK_ENTER:
                    if(quizIsGedaan){
                        startScreen();
                    }
                    if(quizIsBezig){
                        antwoord();
                    } 
                    if(!quizIsBezig){
                        StelEenVraag();
                        quizIsBezig = true;
                    }
                    
                    break;
            }
        }
    }
      
    public void update(){
        if(a.hasFocus()){
            System.out.println("a is focus");
        }
    }
    
    public void antwoord(){
        String userAnswer = new String("");
        String correctAntwoord;
        correctAntwoord = vragen[huidigeVraag].Correct;
        String A = vragen[huidigeVraag].getA();
        String B = vragen[huidigeVraag].getB();
        String C = vragen[huidigeVraag].getC();
        String D = vragen[huidigeVraag].getD();
        scene.removeAll();
        
        if(AisSelected){
            userAnswer = "a";
        }
        if(BisSelected){
            userAnswer = "b";
        }
        if(CisSelected){
            userAnswer = "c";
        }
        if(DisSelected){
            userAnswer = "d";
        }
        if(userAnswer.equals(correctAntwoord)){
            
           punten = punten + 1;
            huidigeVraag++;
            validpopup = new HText("Correct !");
            validpopup.setLocation(200,300);
            validpopup.setBordersEnabled(false);
            validpopup.setSize(250,150);
            validpopup.setBackground(Color.GREEN);
            validpopup.setBackgroundMode(HVisible.BACKGROUND_FILL);
            scene.add(validpopup);
            System.out.println(huidigeVraag);
            scene.repaint();
            scene.validate();
            scene.setVisible(true);
            try{
            Thread.sleep(1000);
            } catch(InterruptedException ex){eindeSpel();};
            scene.validate();
            scene.setVisible(true);
            if(huidigeVraag < 16){
                AisSelected = true;
                StelEenVraag();
            } else{eindeSpel(); quizIsGedaan = true;};
             
            
        } else{
            if(correctAntwoord.equals("a")){
            validpopup = new HText("Fout! Het juiste antwoord was " + A + ".");
            
            } 
            if(correctAntwoord.equals("b")){
                validpopup = new HText("Fout! Het juiste antwoord was " + B + ".");
            }
            if(correctAntwoord.equals("c")){
                validpopup = new HText("Fout! Het juiste antwoord was " + C + ".");
            }
            if(correctAntwoord.equals("d")){
                validpopup = new HText("Fout! Het juiste antwoord was " + D + ".");
            }
            
            validpopup.setLocation(100,300);
            validpopup.setBordersEnabled(false);
            validpopup.setSize(500,150);
            validpopup.setBackground(Color.RED);
            validpopup.setBackgroundMode(HVisible.BACKGROUND_FILL);
            scene.popToFront(validpopup);
            scene.add(validpopup);
            punten = punten + 0;
            huidigeVraag++;
            
            System.out.println(huidigeVraag);
            scene.repaint();
            scene.validate();
            scene.setVisible(true);
            try{
            Thread.sleep(1000);
            } catch(InterruptedException ex){eindeSpel();};
            scene.validate();
            scene.setVisible(true);
            if(huidigeVraag < 16){
                AisSelected = true;
                StelEenVraag();
            } else{eindeSpel(); quizIsGedaan = true;};
                
        }
        
    }
    
    public void eindeSpel(){
        System.out.println("eindeSpel()");
        scene.removeAll();
        scene.popToFront(einde);
        scene.remove(validpopup);
        einde = new HText("De quiz is over.");
        einde.setBackground(Color.BLUE);
        einde.setBackgroundMode(HVisible.BACKGROUND_FILL);
        einde.setLocation(100,100);
        einde.setSize(500,100);
        einde.setBordersEnabled(false);
        scene.add(einde);
        
        if(punten > 0 && punten < 5){
            resultaat = new HText("Je behaalde " + punten + " punten.\nNoem jij jezelf een fan?");
            resultaat.setBackground(Color.RED);
            resultaat.setBackgroundMode(HVisible.BACKGROUND_FILL);
        } 
        if(punten >= 5 && punten < 10){
            resultaat = new HText("Je behaalde " + punten + " punten.\nIk denk dat jij de serie nog is moet zien!");
            resultaat.setBackground(Color.RED);
            resultaat.setBackgroundMode(HVisible.BACKGROUND_FILL);
        }
        if(punten >= 10 && punten < 15){
            resultaat = new HText("Je behaalde " + punten + " punten.\nGoed gedaan, jij weet bijna alles!");
            resultaat.setBackground(Color.GREEN);
            resultaat.setBackgroundMode(HVisible.BACKGROUND_FILL);
        }
        if(punten == 15){
            resultaat = new HText("Je behaalde " + punten + " punten.\nJe hebt alles Juist! Jij bent echt een Superfan!");
            resultaat.setBackground(Color.GREEN);
            resultaat.setBackgroundMode(HVisible.BACKGROUND_FILL);
        }
        
        
        resultaat.setLocation(100,200);
        resultaat.setSize(500,100);
        resultaat.setBordersEnabled(false);
        scene.add(resultaat);
        
        opnieuw = new HText("Druk op enter om opnieuw te proberen.");
        opnieuw.setBackground(Color.BLUE);
        opnieuw.setBackgroundMode(HVisible.BACKGROUND_FILL);
        opnieuw.setLocation(100,300);
        opnieuw.setSize(500,100);
        opnieuw.setBordersEnabled(false);
        scene.add(opnieuw);
        
        scene.repaint();
        scene.validate();
        scene.setVisible(true);
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
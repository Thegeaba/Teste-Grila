
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Color;

public class Test extends javax.swing.JFrame {
    
    int intrebari=0;//pt a tine minte la ce intrebare sunt
    int start=0;//da semnalul cand sa inceapa progressbar-ul
    int scor=0;//mentine scorul
    int domeniu=0;// valoarea ce corespunde alegerii domeniului
    int dificultate=0;// valoarea ce corespunde alegerii dificultatii
    /*Verificarile a,b,c,d sunt folosite pentru a-mi permite sa contorizez o singura data alegerea raspunsului corect
    in cazul in care este bifat a,b,a,c,a(a fiind raspunsul corect), sa nu se ia in calcul si sa se adauge la scor de mai multe ori*/
    int verificare_a=0;
    int verificare_a1=0;
    int verificare_b=0;
    int verificare_c=0;
    int verificare_d=0;
    int dacaserazgandeste=0;//variabila care imi tine minte scorul precedent cand o intrebare este gresita, respectiv schimbata din cea corecta.
    
    private Timer t;
    private ActionListener al;
     
    // Crearea Testului

    public Test() {
        initComponents();
    }
    
    public Test(int domeniu, int dificultate) {//constructor personalizat
        /*
        Se preiau domeniul si dificultatea din frame-ul precedent si se atribuie aici.
        ActionListener-ul al se ocupa de progressbar, daca intra pe ramura else se termina timpul si suntem "scosi" din joc
        */
        this.domeniu=domeniu;
        this.dificultate=dificultate;
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        al=new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(jProgressBar1.getValue()<100){
                    jProgressBar1.setValue(jProgressBar1.getValue()+5);
                }
                else
                {
                t.stop();
                if(jProgressBar1.isVisible()){
                lblQuestion.setText("Timpul a expirat! Scor: "+scor);
                }
                jRadioButtonA.setText("");
                jRadioButtonB.setText("");
                jRadioButtonC.setText("");
                jRadioButtonD.setText("");  
                jRadioButtonB.setVisible(false);
                jRadioButtonC.setVisible(false);
                jRadioButtonD.setVisible(false);
                jRadioButtonA.setVisible(false);
                jButtonNextQ.setVisible(false);
                    
                }
            }
        };
        
        t=new Timer(1500,al);
    }

    //@SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        jButtonNextQ = new javax.swing.JButton();
        jRadioButtonA = new javax.swing.JRadioButton();
        jRadioButtonB = new javax.swing.JRadioButton();
        jRadioButtonC = new javax.swing.JRadioButton();
        jRadioButtonD = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        lblQuestion.setFont(new java.awt.Font("Arial", 0, 14));
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("Press Next to Start ");

        jButtonNextQ.setText("Next");
        jButtonNextQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextQActionPerformed(evt);
            }
        });

        jRadioButtonA.setFont(new java.awt.Font("Arial", 0, 14));
        jRadioButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAActionPerformed(evt);
            }
        });

        jRadioButtonB.setFont(new java.awt.Font("Arial", 0, 14));
        jRadioButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBActionPerformed(evt);
            }
        });

        jRadioButtonC.setFont(new java.awt.Font("Arial", 0, 14));
        jRadioButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCActionPerformed(evt);
            }
        });

        jRadioButtonD.setFont(new java.awt.Font("Arial", 0, 14));
        jRadioButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDActionPerformed(evt);
            }
        });

        jProgressBar1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButtonB)
                    .addComponent(jRadioButtonA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonC, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButtonD, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNextQ, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonA)
                    .addComponent(jRadioButtonC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonD)
                    .addComponent(jRadioButtonB))
                .addGap(42, 42, 42)
                .addComponent(jButtonNextQ)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void jButtonNextQActionPerformed(java.awt.event.ActionEvent evt) {
        if(start==0){ // se ocupa de progressbar
            t.start();
        }
        jRadioButtonA.setSelected(false); // ma lasa sa aleg doar una din ele, nu mai multe
        jRadioButtonB.setSelected(false);
        jRadioButtonC.setSelected(false);
        jRadioButtonD.setSelected(false);
        
        intrebari=intrebari+1;// la fiecare next se incrementeaza, intrebari+1 reprezinta urmatoarea intrebare
        /* Mai jos sunt seturi de intrebari , de exemplu intrebari==1, domeniu== 1, dificultate ==2 
        inseamna prima intrebare din setul de geografie avanasat 
        daca se razgandeste e pentru a salva scorul precedent in cazul in care se alege un raspuns gresit*/
        if(intrebari==1 && domeniu==0 && dificultate==0) //cultura usor
        {
            lblQuestion.setText("Anul are ... anotimpuri");
            jRadioButtonA.setText("4");
            jRadioButtonB.setText("3");
            jRadioButtonC.setText("2");
            jRadioButtonD.setText("1");
           dacaserazgandeste=0;
        }
        
        if(intrebari==2 && domeniu==0 && dificultate==0) 
        {
            lblQuestion.setText("Luna Iunie este luna de ...");
            jRadioButtonA.setText("Iarna");
            jRadioButtonB.setText("Vara");
            jRadioButtonC.setText("Toamna");
            jRadioButtonD.setText("Primavara");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==0 && dificultate==0) 
        {
            lblQuestion.setText("Ce mananca ursii panda?");
            jRadioButtonA.setText("Orez");
            jRadioButtonB.setText("Ciorba");
            jRadioButtonC.setText("Bambus");
            jRadioButtonD.setText("Inghetata");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==0 && dificultate==0) 
        {
            lblQuestion.setText("Ce culoare are Shrek?");
            jRadioButtonA.setText("Negru");
            jRadioButtonB.setText("Roz");
            jRadioButtonC.setText("Gri");
            jRadioButtonD.setText("Verde");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==0 && dificultate==0) 
        {
            lblQuestion.setText("Cate picioare are un paianjen?");
            jRadioButtonA.setText("8");
            jRadioButtonB.setText("20");
            jRadioButtonC.setText("10");
            jRadioButtonD.setText("4");
            dacaserazgandeste=scor;
        }
          if(intrebari>5 && (domeniu==0 || domeniu==1 || domeniu==2)  && (dificultate==0 || dificultate==1 || dificultate==2)){
            lblQuestion.setText("Scor final: "+scor);
            jProgressBar1.setVisible(false);
            jProgressBar1.setEnabled(false);
            jRadioButtonA.setText("");
            jRadioButtonB.setText("");
            jRadioButtonC.setText("");
            jRadioButtonD.setText("");  
            jRadioButtonB.setVisible(false);
            jRadioButtonC.setVisible(false);
            jRadioButtonD.setVisible(false);
            jRadioButtonA.setVisible(false);
            jButtonNextQ.setVisible(false);
            
          }
        
           if(intrebari==1 && domeniu==0 && dificultate==1) //cultura mediu
        {
            lblQuestion.setText("Numele ursului din Cartea Junglei");
            jRadioButtonA.setText("Baloo");
            jRadioButtonB.setText("Andrei");
            jRadioButtonC.setText("Ion");
            jRadioButtonD.setText("Rex");
            dacaserazgandeste=0;
           }
        
        if(intrebari==2 && domeniu==0 && dificultate==1) 
        {
            lblQuestion.setText("Cati ani are un deceniu?");
            jRadioButtonA.setText("100");
            jRadioButtonB.setText("10");
            jRadioButtonC.setText("1000");
            jRadioButtonD.setText("50");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==0 && dificultate==1) 
        {
            lblQuestion.setText("Ani de liceu/ ... ");
            jRadioButtonA.setText("Ani grei");
            jRadioButtonB.setText("Ani de facultate");
            jRadioButtonC.setText("Cu emotii la romana");
            jRadioButtonD.setText("Stefan Banica");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==0 && dificultate==1) 
        {
            lblQuestion.setText("... are gatul lung");
            jRadioButtonA.setText("Pestele");
            jRadioButtonB.setText("Melcul");
            jRadioButtonC.setText("Iepurele");
            jRadioButtonD.setText("Girafa");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==0 && dificultate==1) 
        {
            lblQuestion.setText("... de oi");
            jRadioButtonA.setText("Turma");
            jRadioButtonB.setText("Stol");
            jRadioButtonC.setText("Grup");
            jRadioButtonD.setText("Banc");
            dacaserazgandeste=scor;
        }
           
          if(intrebari==1 && domeniu==0 && dificultate==2) //cultura avansat
        {
            lblQuestion.setText("Autorul seriei Harry Potter");
            jRadioButtonA.setText("J.K. Rowling");
            jRadioButtonB.setText("C. Dickens");
            jRadioButtonC.setText("O. Bowden");
            jRadioButtonD.setText("F. Nietzsche");
            dacaserazgandeste=0;
          }   
        
        if(intrebari==2 && domeniu==0 && dificultate==2) 
        {
            lblQuestion.setText("Al cui caine este Scooby Doo?");
            jRadioButtonA.setText("Freddie");
            jRadioButtonB.setText("Shaggy");
            jRadioButtonC.setText("Daphne");
            jRadioButtonD.setText("Velma");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==0 && dificultate==2) 
        {
            lblQuestion.setText("Amnezia este pierderea ...");
            jRadioButtonA.setText("Auzului");
            jRadioButtonB.setText("Simtului");
            jRadioButtonC.setText("Memoriei");
            jRadioButtonD.setText("Vederii");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==0 && dificultate==2) 
        {
            lblQuestion.setText("H20 este ...");
            jRadioButtonA.setText("Petrol");
            jRadioButtonB.setText("Oxigen");
            jRadioButtonC.setText("Carbon");
            jRadioButtonD.setText("Apa");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==0 && dificultate==2) 
        {
            lblQuestion.setText("Zeul fulgerului in mitologia nordica");
            jRadioButtonA.setText("Thor");
            jRadioButtonB.setText("Zeus");
            jRadioButtonC.setText("Hercule");
            jRadioButtonD.setText("Fenrir");
            dacaserazgandeste=scor;
        }
          
           if(intrebari==1 && domeniu==1 && dificultate==0) //geografie usor
        {
            lblQuestion.setText("Celebrul croissant a fost inventat in ...");
            jRadioButtonA.setText("Franta");
            jRadioButtonB.setText("Olanda");
            jRadioButtonC.setText("America");
            jRadioButtonD.setText("Anglia");
            dacaserazgandeste=0;
           }   
        
        if(intrebari==2 && domeniu==1 && dificultate==0) 
        {
            lblQuestion.setText("Care este capitala Romaniei?");
            jRadioButtonA.setText("Budapesta");
            jRadioButtonB.setText("Bucuresti");
            jRadioButtonC.setText("Helsinki");
            jRadioButtonD.setText("Chisinau");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==1 && dificultate==0) 
        {
            lblQuestion.setText("Craiova se afla in jud. ...");
            jRadioButtonA.setText("Teleorman");
            jRadioButtonB.setText("Olt");
            jRadioButtonC.setText("Dolj");
            jRadioButtonD.setText("Maramures");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==1 && dificultate==0) 
        {
            lblQuestion.setText("Pe Muntele Rushmore sunt sculptati:");
            jRadioButtonA.setText("Queen");
            jRadioButtonB.setText("The Beatles");
            jRadioButtonC.setText("Doi vulturi");
            jRadioButtonD.setText("Presedintii SUA");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==1 && dificultate==0) 
        {
            lblQuestion.setText("Cea mai mica tara din Europa?");
            jRadioButtonA.setText("Vatican");
            jRadioButtonB.setText("Suedia");
            jRadioButtonC.setText("Norvegia");
            jRadioButtonD.setText("Danemarca");
            dacaserazgandeste=scor;
        }
          
        
           if(intrebari==1 && domeniu==1 && dificultate==1) //geografie mediu
        {
            lblQuestion.setText("Altitudinea maxima in Romania?");
            jRadioButtonA.setText("2544m");
            jRadioButtonB.setText("2342m");
            jRadioButtonC.setText("2690m");
            jRadioButtonD.setText("3000m");
            dacaserazgandeste=0;
           }   
        
        if(intrebari==2 && domeniu==1 && dificultate==1) 
        {
            lblQuestion.setText("Oltul izvoraste din:");
            jRadioButtonA.setText("Carpatii Meridionali");
            jRadioButtonB.setText("Carpatii Orientali");
            jRadioButtonC.setText("Carpatii Occidentali");
            jRadioButtonD.setText("Subcarpatii Getici");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==1 && dificultate==1) 
        {
            lblQuestion.setText("Dunarea izvoraste din:");
            jRadioButtonA.setText("Muntii Balcani");
            jRadioButtonB.setText("Mont Blanc");
            jRadioButtonC.setText("Muntii Padurea Neagra");
            jRadioButtonD.setText("Muntele Olimp");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==1 && dificultate==1) 
        {
            lblQuestion.setText("Ce rau traverseaza Parisul?");
            jRadioButtonA.setText("Moldou");
            jRadioButtonB.setText("Neva");
            jRadioButtonC.setText("Dunarea");
            jRadioButtonD.setText("Sena");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==1 && dificultate==1) 
        {
            lblQuestion.setText("Dunarea trece prin ... tari");
            jRadioButtonA.setText("10");
            jRadioButtonB.setText("7");
            jRadioButtonC.setText("1");
            jRadioButtonD.setText("4");
            dacaserazgandeste=scor;
        }
           
         if(intrebari==1 && domeniu==1 && dificultate==2) //geografie avansat
        {
            lblQuestion.setText("Cel mai lung fluviu din Europa?");
            jRadioButtonA.setText("Volga");
            jRadioButtonB.setText("Nilul");
            jRadioButtonC.setText("Dunarea");
            jRadioButtonD.setText("Sena");
            dacaserazgandeste=0;
        }   
        
        if(intrebari==2 && domeniu==1 && dificultate==2) 
        {
            lblQuestion.setText("Care este capitala Islandei?");
            jRadioButtonA.setText("Ankara");
            jRadioButtonB.setText("Reykjavik");
            jRadioButtonC.setText("Ljubljana");
            jRadioButtonD.setText("Erevan");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==1 && dificultate==2) 
        {
            lblQuestion.setText("Cate state se gasesc in SUA?");
            jRadioButtonA.setText("52");
            jRadioButtonB.setText("54");
            jRadioButtonC.setText("50");
            jRadioButtonD.setText("48");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==1 && dificultate==2) 
        {
            lblQuestion.setText("Capitala Australiei:");
            jRadioButtonA.setText("Brisbane");
            jRadioButtonB.setText("Melbourne");
            jRadioButtonC.setText("Sydney");
            jRadioButtonD.setText("Canberra");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==1 && dificultate==2) 
        {
            lblQuestion.setText("Capitala Canadei:");
            jRadioButtonA.setText("Ottawa");
            jRadioButtonB.setText("Vancouver");
            jRadioButtonC.setText("Montreal");
            jRadioButtonD.setText("Toronto");
            dacaserazgandeste=scor;
        }
        
          if(intrebari==1 && domeniu==2 && dificultate==0) //matematica usor
        {
            lblQuestion.setText("1+1=?");
            jRadioButtonA.setText("2");
            jRadioButtonB.setText("6");
            jRadioButtonC.setText("3");
            jRadioButtonD.setText("1");
            dacaserazgandeste=0;
        }   
        
        if(intrebari==2 && domeniu==2 && dificultate==0) 
        {
            lblQuestion.setText("1-1=?");
            jRadioButtonA.setText("1");
            jRadioButtonB.setText("0");
            jRadioButtonC.setText("Eroare");
            jRadioButtonD.setText("-2");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==2 && dificultate==0) 
        {
            lblQuestion.setText("(1+2)*2+3=?");
            jRadioButtonA.setText("12");
            jRadioButtonB.setText("6");
            jRadioButtonC.setText("9");
            jRadioButtonD.setText("10");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==2 && dificultate==0) 
        {
            lblQuestion.setText("x-7=10");
            jRadioButtonA.setText("x=-10");
            jRadioButtonB.setText("x=7");
            jRadioButtonC.setText("x=10");
            jRadioButtonD.setText("x=17");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==2 && dificultate==0) 
        {
            lblQuestion.setText("-(-3*(-2))=?");
            jRadioButtonA.setText("-6");
            jRadioButtonB.setText("6");
            jRadioButtonC.setText("5");
            jRadioButtonD.setText("1");
            dacaserazgandeste=scor;
        }
        
           if(intrebari==1 && domeniu==2 && dificultate==1) //matematica mediu
        {
            lblQuestion.setText("1*1=?");
            jRadioButtonA.setText("1");
            jRadioButtonB.setText("6");
            jRadioButtonC.setText("3");
            jRadioButtonD.setText("1");
            dacaserazgandeste=0;
        }   
        
        if(intrebari==2 && domeniu==2 && dificultate==1) 
        {
            lblQuestion.setText("1*(-1)=?");
            jRadioButtonA.setText("1");
            jRadioButtonB.setText("-1");
            jRadioButtonC.setText("0");
            jRadioButtonD.setText("-2");
            dacaserazgandeste=scor;
        }
        
        if(intrebari==3 && domeniu==2 && dificultate==1) 
        {
            lblQuestion.setText("(1+2)*2*3-(2*3)=? ");
            jRadioButtonA.setText("14");
            jRadioButtonB.setText("6");
            jRadioButtonC.setText("12");
            jRadioButtonD.setText("10");
            dacaserazgandeste=scor;
        }
        
         if(intrebari==4 && domeniu==2 && dificultate==1) 
        {
            lblQuestion.setText("x*7+13=62");
            jRadioButtonA.setText("x=8");
            jRadioButtonB.setText("x=2,7");
            jRadioButtonC.setText("x=10");
            jRadioButtonD.setText("x=7");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==2 && dificultate==1) 
        {
            lblQuestion.setText("-(-3*(-2)*5^4)=?");
            jRadioButtonA.setText("-3750");
            jRadioButtonB.setText("-3756");
            jRadioButtonC.setText("-3674");
            jRadioButtonD.setText("-3570");
            dacaserazgandeste=scor;
        }
          
           if(intrebari==1 && domeniu==2 && dificultate==2) //matematica avansat
        {
            lblQuestion.setText("Cate laturi are un patrat?");
            jRadioButtonA.setText("2*2-2+2-4+2*2");
            jRadioButtonB.setText("8670-4254*2+3125-4000");
            jRadioButtonC.setText("3");
            jRadioButtonD.setText("1");
            dacaserazgandeste=0;
            
        }   
        
        if(intrebari==2 && domeniu==2 && dificultate==2) 
        {
            lblQuestion.setText("Cate laturi are un hexagon?");
            jRadioButtonA.setText("5");
            jRadioButtonB.setText("5+1");
            jRadioButtonC.setText("6-0.3");
            jRadioButtonD.setText("3");
            dacaserazgandeste=scor;
            
        }
        
        if(intrebari==3 && domeniu==2 && dificultate==2) 
        {
            lblQuestion.setText("30^3=?");
            jRadioButtonA.setText("16.000");
            jRadioButtonB.setText("18.000");
            jRadioButtonC.setText("27.000");
            jRadioButtonD.setText("12.000");
            dacaserazgandeste=scor;
            
        }
        
         if(intrebari==4 && domeniu==2 && dificultate==2) 
        {
            lblQuestion.setText("sqrt(3)=?");
            jRadioButtonA.setText("1.71");
            jRadioButtonB.setText("1.74");
            jRadioButtonC.setText("1.72");
            jRadioButtonD.setText("1.73");
            dacaserazgandeste=scor;
        }
         
          if(intrebari==5 && domeniu==2 && dificultate==2) 
        {
            lblQuestion.setText("cos(4)=?");
            jRadioButtonA.setText("-0.65");
            jRadioButtonB.setText("-0.63");
            jRadioButtonC.setText("0.65");
            jRadioButtonD.setText("0.63");
            dacaserazgandeste=scor;
        }
        
          
          
    }
        
    private void jRadioButtonAActionPerformed(java.awt.event.ActionEvent evt) {
        if(jRadioButtonA.isSelected()){ //daca se alege a nu putem alege simultan B sau altceva
            jRadioButtonB.setSelected(false);
            jRadioButtonC.setSelected(false);
            jRadioButtonD.setSelected(false);
        }
         if(intrebari==1 && jRadioButtonA.isSelected() && verificare_a==0){ //permite incrementarea scor doar o singura data cand apasam pe A 
         
                verificare_a++;
                scor++;
                //System.out.println("Scor la prima intrebare "+scor);
            }
         
         if((intrebari==2 || intrebari==3 || intrebari==4)  && jRadioButtonA.isSelected()){
             scor=dacaserazgandeste;
             //System.out.println("Alegi gresit  scorul devine "+dacaserazgandeste);
         } 
              
         if(intrebari==5 && jRadioButtonA.isSelected() && verificare_a1==0){
             verificare_a1++;
             scor++;
             //System.out.println("Scor la a cincea intrebare "+scor);
         }
         
              
    }

    private void jRadioButtonCActionPerformed(java.awt.event.ActionEvent evt) {
        if(jRadioButtonC.isSelected()){
            jRadioButtonB.setSelected(false);
            jRadioButtonA.setSelected(false);
            jRadioButtonD.setSelected(false);
        }
        
        if(intrebari==3 && jRadioButtonC.isSelected() && verificare_c==0){
                verificare_c++;
                scor++;
               // System.out.println("Scor la a 3 intrebare "+scor);
            }
        if((intrebari==1 || intrebari==2 || intrebari==4 || intrebari==5)  && jRadioButtonC.isSelected()){
             //verificare_c=0;
             scor=dacaserazgandeste;
             //System.out.println("Alegi gresit , scorul devine "+dacaserazgandeste);
         }
        
    }

    private void jRadioButtonBActionPerformed(java.awt.event.ActionEvent evt) {
        if(jRadioButtonB.isSelected()){
            jRadioButtonA.setSelected(false);
            jRadioButtonC.setSelected(false);
            jRadioButtonD.setSelected(false);
        }
        
        if(intrebari==2 && jRadioButtonB.isSelected() && verificare_b==0){
                verificare_b++;
                scor++;
               // System.out.println("Scor la a 2 intrebare"+scor);
            }
        if((intrebari==1 || intrebari==3 || intrebari==4 || intrebari==5)  && jRadioButtonB.isSelected()){
             scor=dacaserazgandeste;
             //System.out.println("Alegi gresit  scorul devine"+dacaserazgandeste);
         }
        
    }

    private void jRadioButtonDActionPerformed(java.awt.event.ActionEvent evt) {
       if(jRadioButtonD.isSelected()){
            jRadioButtonB.setSelected(false);
            jRadioButtonC.setSelected(false);
            jRadioButtonA.setSelected(false);
        }
       
       if(intrebari==4 && jRadioButtonD.isSelected() && verificare_d==0){
                verificare_d++;
                scor++;
               // System.out.println(scor);
            }
       if((intrebari==1 || intrebari==2 || intrebari==3 || intrebari==5)  && jRadioButtonD.isSelected()){
             //verificare_c=0;
             scor=dacaserazgandeste;
             //System.out.println("Alegi gresit , scorul devine "+dacaserazgandeste);
         }
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crearea si afisarea frame-ului */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Declararea variabilelor
    private javax.swing.JButton jButtonNextQ;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    private javax.swing.JLabel lblQuestion;
}
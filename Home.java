
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Home extends javax.swing.JFrame {
    
    /**
     * Creare Home
     * Tot ca la Login... Se centreaza fereastra.
     */
    public Home() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        
    }

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButtonNextQ = new javax.swing.JButton();
        jComboBoxDomeniu = new javax.swing.JComboBox<>();
        jComboBoxDificultate = new javax.swing.JComboBox<>();
        lblHomePickDomeniu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jButtonNextQ.setText("Next");
        jButtonNextQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextQActionPerformed(evt);
            }
        });

        jComboBoxDomeniu.setFont(new java.awt.Font("Arial", 0, 15));
        jComboBoxDomeniu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cultura", "Geografie", "Matematica" }));
        jComboBoxDomeniu.setSelectedItem(null);

        jComboBoxDificultate.setFont(new java.awt.Font("Arial", 0, 15));
        jComboBoxDificultate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usor", "Mediu", "Avansat" }));
        jComboBoxDificultate.setSelectedItem(null);

        lblHomePickDomeniu.setFont(new java.awt.Font("Arial", 0, 18));
        lblHomePickDomeniu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHomePickDomeniu.setText("Domeniul");
        lblHomePickDomeniu.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18));
        jLabel1.setText("Dificultatea");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jButtonNextQ, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHomePickDomeniu)
                    .addComponent(jComboBoxDomeniu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxDificultate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDificultate)
                    .addComponent(jComboBoxDomeniu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHomePickDomeniu)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButtonNextQ, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public int dom;//variabila folosita pentru a retine domeniul ales
     public int dif;//variabila folosita pentru a retine dificultatea aleasa
    private void jButtonNextQActionPerformed(java.awt.event.ActionEvent evt) {
         dom = jComboBoxDomeniu.getSelectedIndex();// preiau index-ul combo box-ului ce reprezinta domeniul
        dif=jComboBoxDificultate.getSelectedIndex();//preiau index-ul combo box-ului ce reprezinta dificultatea
       /*Verific daca au fost selectate valori din combo box-uri, daca au fost se trece la urmatorul frame
        Daca nu, se afiseaza o casuta prin care esti indemnat sa alegi un domeniu si o dificultate*/
        if((dom==1 || dom==2 || dom==0)&&(dif==0 || dif==1 || dif==2)){
        Test test= new Test(dom,dif);
        test.setVisible(true);
        this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Trebuie sa alegi domeniul si dificultatea", "Alegere esuata!", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Crearea si afisarea frame-ului. 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    
    

    // Declararea variabilelor
    private javax.swing.JButton jButtonNextQ;
    private javax.swing.JComboBox<String> jComboBoxDificultate;
    private javax.swing.JComboBox<String> jComboBoxDomeniu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHomePickDomeniu;
}

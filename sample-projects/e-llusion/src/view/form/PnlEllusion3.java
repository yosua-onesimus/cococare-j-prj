package view.form;

public class PnlEllusion3 extends javax.swing.JPanel {

    public PnlEllusion3() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabStep = new javax.swing.JTabbedPane();
        pnlStep0 = new javax.swing.JPanel();
        lblStep0Left = new javax.swing.JLabel();
        lblStep0Right = new javax.swing.JLabel();
        pnlStep1 = new javax.swing.JPanel();
        lblStep1A = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnShuffle = new javax.swing.JButton();
        cmbMethod = new javax.swing.JComboBox();
        btnOk = new javax.swing.JButton();
        lblStep1BLeft = new javax.swing.JLabel();
        lblStep1BRight = new javax.swing.JLabel();
        pnlStep2 = new javax.swing.JPanel();
        lblDisabled = new javax.swing.JLabel();
        lblEnabled = new javax.swing.JLabel();
        lblStep2Left = new javax.swing.JLabel();
        lblStep2Right = new javax.swing.JLabel();
        pnlStep3 = new javax.swing.JPanel();
        lblDisabled1 = new javax.swing.JLabel();
        lblEnabled1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblSpan = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        tabStep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "(e)llusion III", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tabStep.setEnabled(false);

        pnlStep0.setOpaque(false);

        lblStep0Left.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep0Left.setText("<html>\nWelcome to the (e)llusion III, ie an illusion shows in electronic media.<br/><br/>\nIn this application, you will be given eight random letters, which then will be separated into two words by one of three ways that you choose.<br/><br/>\nClick [Next] to start the game.\n</html>");

        lblStep0Right.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep0Right.setText("<html>\nSelamat datang di (e)llusion III, yaitu sebuah pertunjukkan ilusi di media elektronik.<br/><br/>\nDi aplikasi ini, Anda akan diberikan 8 huruf acak, yang kemudian akan dipisahkan menjadi dua kata berdasarkan satu dari tiga cara yang Anda pilih.<br/><br/>\nKlik [Next] untuk memulai permainan.\n</html>");

        javax.swing.GroupLayout pnlStep0Layout = new javax.swing.GroupLayout(pnlStep0);
        pnlStep0.setLayout(pnlStep0Layout);
        pnlStep0Layout.setHorizontalGroup(
            pnlStep0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep0Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblStep0Left, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblStep0Right, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlStep0Layout.setVerticalGroup(
            pnlStep0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep0Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlStep0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStep0Left, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStep0Right, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabStep.addTab("Instruction", pnlStep0);

        pnlStep1.setOpaque(false);
        pnlStep1.setLayout(null);

        lblStep1A.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep1A.setText("<html>\nClick Shuffle to randomize letters.<br/>\nChoose a number, then click OK to divide the letters into two groups.<br/>\n<hr>\nKlik Shuffle untuk mengacak huruf.<br/>\nPilih angka, lalu klik OK untuk membagi huruf menjadi dua kelompok.<br/>\n</html>");
        pnlStep1.add(lblStep1A);
        lblStep1A.setBounds(10, 10, 480, 80);

        btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1.setFocusable(false);
        pnlStep1.add(btn1);
        btn1.setBounds(350, 90, 60, 60);

        btn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2.setText("!");
        btn2.setFocusable(false);
        pnlStep1.add(btn2);
        btn2.setBounds(420, 120, 60, 60);

        btn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3.setFocusable(false);
        pnlStep1.add(btn3);
        btn3.setBounds(470, 190, 60, 60);

        btn4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn4.setFocusable(false);
        pnlStep1.add(btn4);
        btn4.setBounds(460, 260, 60, 60);

        btn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn5.setFocusable(false);
        pnlStep1.add(btn5);
        btn5.setBounds(390, 320, 60, 60);

        btn6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn6.setFocusable(false);
        pnlStep1.add(btn6);
        btn6.setBounds(310, 320, 60, 60);

        btn7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn7.setFocusable(false);
        pnlStep1.add(btn7);
        btn7.setBounds(240, 260, 60, 60);

        btn8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn8.setFocusable(false);
        pnlStep1.add(btn8);
        btn8.setBounds(230, 190, 60, 60);

        btn9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn9.setFocusable(false);
        pnlStep1.add(btn9);
        btn9.setBounds(280, 120, 60, 60);

        btnShuffle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnShuffle.setText("Shuffle");
        btnShuffle.setFocusable(false);
        pnlStep1.add(btnShuffle);
        btnShuffle.setBounds(340, 190, 80, 40);

        cmbMethod.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cmbMethod.setMaximumRowCount(3);
        cmbMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5" }));
        cmbMethod.setFocusable(false);
        pnlStep1.add(cmbMethod);
        cmbMethod.setBounds(320, 240, 60, 40);

        btnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOk.setText("OK");
        btnOk.setFocusable(false);
        pnlStep1.add(btnOk);
        btnOk.setBounds(380, 240, 60, 40);

        lblStep1BLeft.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep1BLeft.setText("<html>\nThe letters were divided into two groups.<br>\nGroup \"enabled\" and group \"disabled\".<br><br>\nClick [Next] to continue the game.\n</html>");
        lblStep1BLeft.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlStep1.add(lblStep1BLeft);
        lblStep1BLeft.setBounds(10, 180, 220, 200);

        lblStep1BRight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep1BRight.setText("<html>\n<p align=\"right\">Huruf-huruf pun terbagi menjadi dua kelompok.<br>\nKelompok \"enabled\" dan kelompok \"disabled\".<br><br>\nClick [Next] to continue the game.</p>\n</html>");
        lblStep1BRight.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlStep1.add(lblStep1BRight);
        lblStep1BRight.setBounds(530, 180, 220, 200);

        tabStep.addTab("Step I", pnlStep1);

        lblDisabled.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblDisabled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisabled.setText("XXXXX");

        lblEnabled.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblEnabled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnabled.setText("XXXXX");

        lblStep2Left.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep2Left.setText("<html>\nGroup \"disabled\" consists of the letters:<br><br><br><br>\nWhile Group \"enabled\" consists of the letters:<br><br><br><br>\nLetters in each group can be formed into a word, that is..<br><br>\nClick [Next] to continue the game.\n</html>");
        lblStep2Left.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblStep2Right.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep2Right.setText("<html>\nKelompok D terdiri dari huruf:<br><br><br><br>\nSedangkan Kelompok E terdiri dari huruf:<br><br><br><br>\nHuruf di tiap kelompok dapat dibentuk menjadi sebuah kata, yaitu..<br><br>\nClick [Next] to continue the game.\n</html>");
        lblStep2Right.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlStep2Layout = new javax.swing.GroupLayout(pnlStep2);
        pnlStep2.setLayout(pnlStep2Layout);
        pnlStep2Layout.setHorizontalGroup(
            pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblStep2Left, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(lblEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(lblStep2Right, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(lblDisabled, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlStep2Layout.setVerticalGroup(
            pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblStep2Left, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblEnabled))
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblStep2Right, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblDisabled))
        );

        tabStep.addTab("Step II", pnlStep2);

        lblDisabled1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblDisabled1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisabled1.setText("XXXXX");

        lblEnabled1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblEnabled1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnabled1.setText("XXXXX");

        javax.swing.GroupLayout pnlStep3Layout = new javax.swing.GroupLayout(pnlStep3);
        pnlStep3.setLayout(pnlStep3Layout);
        pnlStep3Layout.setHorizontalGroup(
            pnlStep3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep3Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(pnlStep3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDisabled1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnabled1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlStep3Layout.setVerticalGroup(
            pnlStep3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblDisabled1)
                .addGap(26, 26, 26)
                .addComponent(lblEnabled1))
        );

        tabStep.addTab("Step III", pnlStep3);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BackG.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusable(false);
        btnBack.setIconTextGap(0);

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/NextG.png"))); // NOI18N
        btnNext.setBorderPainted(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setFocusable(false);
        btnNext.setIconTextGap(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblSpan, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tabStep)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabStep, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnShuffle;
    private javax.swing.JComboBox cmbMethod;
    private javax.swing.JLabel lblDisabled;
    private javax.swing.JLabel lblDisabled1;
    private javax.swing.JLabel lblEnabled;
    private javax.swing.JLabel lblEnabled1;
    private javax.swing.JLabel lblSpan;
    private javax.swing.JLabel lblStep0Left;
    private javax.swing.JLabel lblStep0Right;
    private javax.swing.JLabel lblStep1A;
    private javax.swing.JLabel lblStep1BLeft;
    private javax.swing.JLabel lblStep1BRight;
    private javax.swing.JLabel lblStep2Left;
    private javax.swing.JLabel lblStep2Right;
    private javax.swing.JPanel pnlStep0;
    private javax.swing.JPanel pnlStep1;
    private javax.swing.JPanel pnlStep2;
    private javax.swing.JPanel pnlStep3;
    private javax.swing.JTabbedPane tabStep;
    // End of variables declaration//GEN-END:variables
}
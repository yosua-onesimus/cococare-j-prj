package view.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.fb.FableLanguage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlAction extends javax.swing.JPanel {

    public PnlAction() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        tabAction = new javax.swing.JTabbedPane();
        pnlGenerator = new javax.swing.JPanel();
        pnlAttribute = new javax.swing.JPanel();
        pnlCondition = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(600, 200));
        setPreferredSize(new java.awt.Dimension(600, 200));

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        tabAction.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        javax.swing.GroupLayout pnlGeneratorLayout = new javax.swing.GroupLayout(pnlGenerator);
        pnlGenerator.setLayout(pnlGeneratorLayout);
        pnlGeneratorLayout.setHorizontalGroup(
            pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        pnlGeneratorLayout.setVerticalGroup(
            pnlGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        tabAction.addTab(FableLanguage.turn(FableLanguage.Action), pnlGenerator);

        javax.swing.GroupLayout pnlAttributeLayout = new javax.swing.GroupLayout(pnlAttribute);
        pnlAttribute.setLayout(pnlAttributeLayout);
        pnlAttributeLayout.setHorizontalGroup(
            pnlAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        pnlAttributeLayout.setVerticalGroup(
            pnlAttributeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        tabAction.addTab(FableLanguage.turn(FableLanguage.Attribute), pnlAttribute);

        javax.swing.GroupLayout pnlConditionLayout = new javax.swing.GroupLayout(pnlCondition);
        pnlCondition.setLayout(pnlConditionLayout);
        pnlConditionLayout.setHorizontalGroup(
            pnlConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        pnlConditionLayout.setVerticalGroup(
            pnlConditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        tabAction.addTab(FableLanguage.turn(FableLanguage.Condition), pnlCondition);

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tabAction)
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(tabAction))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JPanel pnlAttribute;
    private javax.swing.JPanel pnlCondition;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JPanel pnlGenerator;
    private javax.swing.JTabbedPane tabAction;
    // End of variables declaration//GEN-END:variables
}
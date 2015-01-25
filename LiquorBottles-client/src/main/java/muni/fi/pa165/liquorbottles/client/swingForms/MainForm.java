package muni.fi.pa165.liquorbottles.client.swingForms;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.ProcessingException;
import muni.fi.pa165.liquorbottles.api.dto.BottleDTO;
import muni.fi.pa165.liquorbottles.api.dto.BottleTypeDTO;
import muni.fi.pa165.liquorbottles.api.dto.ProducerDTO;
import muni.fi.pa165.liquorbottles.api.dto.StoreDTO;
import muni.fi.pa165.liquorbottles.client.rest.BottleRestClient;
import muni.fi.pa165.liquorbottles.client.rest.BottleTypeRestClient;
import muni.fi.pa165.liquorbottles.client.rest.ProducerRestClient;
import muni.fi.pa165.liquorbottles.client.rest.StoreRestClient;
import muni.fi.pa165.liquorbottles.client.swingWorkers.DeleteBottleSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.DeleteBottleTypeSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.EditBottleSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.EditBottleTypeSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.FindAllBottleTypesSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.FindAllBottlesSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.NewBottleSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.NewBottleTypeSwingWorker;
import muni.fi.pa165.liquorbottles.client.tableModels.BottleTableModel;
import muni.fi.pa165.liquorbottles.client.tableModels.BottleTypeTableModel;

/**
 *
 * @author Jakub Lipcak,Michal Taraj Masaryk University
 */
public class MainForm extends javax.swing.JFrame {

    //data
    List<BottleDTO> allBottles;
    List<BottleTypeDTO> allBottleTypes;
    List<ProducerDTO> allProducers;
    List<StoreDTO> allStores;

    //table models
    BottleTableModel bottleTableModel;
    BottleTypeTableModel bottleTypeTableModel;

    //rest clients
    BottleTypeRestClient bottleTypeRestClient;
    BottleRestClient bottleRestClient;
    ProducerRestClient producerRestClient;
    StoreRestClient storeRestClient;
    //swing workers
    private FindAllBottlesSwingWorker findAllBottlesSwingWorker;
    private FindAllBottleTypesSwingWorker findAllBottleTypesSwingWorker;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        bottleTypeRestClient = new BottleTypeRestClient();
        bottleRestClient = new BottleRestClient();
        producerRestClient = new ProducerRestClient();
        storeRestClient = new StoreRestClient();

        allBottles = new ArrayList<>();
        allBottleTypes = new ArrayList<>();
        allProducers = new ArrayList<>();
        allStores = new ArrayList<>();

        bottleTableModel = new BottleTableModel(allBottles);
        bottleTypeTableModel = new BottleTypeTableModel(allBottleTypes);

        initComponents();

        refreshData();

    }

    private void refreshData() {
        bottleTypeRestClient = new BottleTypeRestClient();
        bottleRestClient = new BottleRestClient();
        producerRestClient = new ProducerRestClient();
        storeRestClient = new StoreRestClient();

        findAllBottlesSwingWorker = new FindAllBottlesSwingWorker(bottleRestClient, bottleTableModel, bottlesTable);
        findAllBottleTypesSwingWorker = new FindAllBottleTypesSwingWorker(bottleTypeRestClient, bottleTypeTableModel, bottleTypeTable);

        findAllBottlesSwingWorker.execute();
        findAllBottleTypesSwingWorker.execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bottleTypeTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        bottlesTable = new javax.swing.JTable();
        createBottleButton = new javax.swing.JButton();
        updateBottleButton = new javax.swing.JButton();
        deleteBottleButton = new javax.swing.JButton();
        createBottleTypeButton = new javax.swing.JButton();
        updateBottleTypeButton = new javax.swing.JButton();
        deleteBottleTypeButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bottleTypeTable.setModel(bottleTypeTableModel);
        jScrollPane1.setViewportView(bottleTypeTable);

        bottlesTable.setModel(bottleTableModel);
        jScrollPane2.setViewportView(bottlesTable);

        createBottleButton.setText("Create Bottle");
        createBottleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBottleButtonActionPerformed(evt);
            }
        });

        updateBottleButton.setLabel("Update Bottle");
        updateBottleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBottleButtonActionPerformed(evt);
            }
        });

        deleteBottleButton.setText("Delete Bottle");
        deleteBottleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBottleButtonActionPerformed(evt);
            }
        });

        createBottleTypeButton.setText("Create Bottle type");
        createBottleTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBottleTypeButtonActionPerformed(evt);
            }
        });

        updateBottleTypeButton.setText("Update Bottle type");
        updateBottleTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBottleTypeButtonActionPerformed(evt);
            }
        });

        deleteBottleTypeButton.setText("Delete Bottle type");
        deleteBottleTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBottleTypeButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createBottleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateBottleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBottleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createBottleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBottleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBottleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(98, 98, 98))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBottleButton)
                    .addComponent(updateBottleButton)
                    .addComponent(deleteBottleButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBottleTypeButton)
                    .addComponent(updateBottleTypeButton)
                    .addComponent(deleteBottleTypeButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        createBottleButton.getAccessibleContext().setAccessibleName("createBottleButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBottleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBottleButtonActionPerformed
        try {
            BottlePanel bottlePanel = new BottlePanel(storeRestClient.getAllStores(), bottleTypeTableModel.getBottleTypes());
            int result = JOptionPane.showConfirmDialog(this, bottlePanel, "New Bottle", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                if (bottlePanel.validatePanel()) {
                    refreshData();
                    for (int i = 0; i < bottleTableModel.getRowCount(); i++) {
                        if (bottlePanel.returnBottle().getStamp() == bottleTableModel.getBottleAt(i).getStamp()) {
                            JOptionPane.showMessageDialog(null, "Stamp must be unique!");
                            createBottleButtonActionPerformed(evt);
                            return;
                        }
                    }
                    NewBottleSwingWorker newBottleSwingWorker = new NewBottleSwingWorker(bottleRestClient, bottleTableModel, bottlePanel.returnBottle(), bottlesTable);
                    newBottleSwingWorker.execute();
                    refreshData();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid data");
                    createBottleButtonActionPerformed(evt);
                }
            }
        } catch (ProcessingException ex) {
            JOptionPane.showMessageDialog(this, "Server connection was not established correctly. Application is closing.", "No server connection.", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }//GEN-LAST:event_createBottleButtonActionPerformed

    private void updateBottleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBottleButtonActionPerformed
        try {
            boolean isRowSelected = false;
            for (int x = 0; x < bottlesTable.getRowCount(); x++) {
                isRowSelected = isRowSelected || bottlesTable.isRowSelected(x);
            }

            if (!isRowSelected) {
                JOptionPane.showMessageDialog(this, "No bottle selected!");
            } else {
                BottlePanel bottlePanel = new BottlePanel(storeRestClient.getAllStores(), bottleTypeTableModel.getBottleTypes());
                bottlePanel.setBottle(bottleTableModel.getBottleAt(bottlesTable.getSelectedRow()));
                int result = JOptionPane.showConfirmDialog(this, bottlePanel, "Edit Bottle", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    if (bottlePanel.validatePanel()) {
                        BottleDTO bottle = bottlePanel.returnBottle();
                        bottle.setId(Long.valueOf(bottlesTable.getValueAt(bottlesTable.getSelectedRow(), 0).toString()));
                        EditBottleSwingWorker editBottleSwingWorker = new EditBottleSwingWorker(bottleRestClient, bottleTableModel, bottle, bottlesTable);
                        editBottleSwingWorker.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid data");
                        updateBottleButtonActionPerformed(evt);
                    }
                }
            }
        } catch (ProcessingException ex) {
            JOptionPane.showMessageDialog(this, "Server connection was not established correctly. Application is closing.", "No server connection.", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }//GEN-LAST:event_updateBottleButtonActionPerformed

    private void deleteBottleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBottleButtonActionPerformed
        boolean isRowSelected = false;
        for (int x = 0; x < bottlesTable.getRowCount(); x++) {
            isRowSelected = isRowSelected || bottlesTable.isRowSelected(x);
        }

        if (!isRowSelected) {
            JOptionPane.showMessageDialog(this, "No bottle selected!");
        } else {
            DeleteBottleSwingWorker deleteBottleSwingWorker;
            deleteBottleSwingWorker = new DeleteBottleSwingWorker(bottleRestClient, bottleTableModel,
                    bottleTableModel.getBottleAt(bottlesTable.getSelectedRow()), bottlesTable);
            

            deleteBottleSwingWorker.execute();
           refreshData();
        }
    }//GEN-LAST:event_deleteBottleButtonActionPerformed

    private void createBottleTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBottleTypeButtonActionPerformed
        try {
            BottleTypePanel bottleTypePanel = new BottleTypePanel(producerRestClient.getProducers());
            int result = JOptionPane.showConfirmDialog(this, bottleTypePanel, "New BottleType", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                if (bottleTypePanel.validatePanel()) {
                    NewBottleTypeSwingWorker newBottleTypeSwingWorker = new NewBottleTypeSwingWorker(bottleTypeRestClient, bottleTypeTableModel, bottleTypePanel.returnBottleType(), bottleTypeTable);
                    newBottleTypeSwingWorker.execute();
                    refreshData();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid data");
                    createBottleTypeButtonActionPerformed(evt);
                }
            }
        } catch (ProcessingException ex) {
            JOptionPane.showMessageDialog(this, "Server connection was not established correctly. Application is closing.", "No server connection.", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }//GEN-LAST:event_createBottleTypeButtonActionPerformed

    private void updateBottleTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBottleTypeButtonActionPerformed
        try {
            boolean isRowSelected = false;
            for (int x = 0; x < bottleTypeTable.getRowCount(); x++) {
                isRowSelected = isRowSelected || bottleTypeTable.isRowSelected(x);
            }

            if (!isRowSelected) {
                JOptionPane.showMessageDialog(this, "No bottleType selected!");
            } else {

                BottleTypePanel bottleTypePanel = new BottleTypePanel(producerRestClient.getProducers());

                bottleTypePanel.setBottleType(bottleTypeTableModel.getBottleAt(bottleTypeTable.getSelectedRow()));
                int result = JOptionPane.showConfirmDialog(this, bottleTypePanel, "Edit Bottle Type", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    if (bottleTypePanel.validatePanel()) {
                        BottleTypeDTO bottleTypeDTO = bottleTypePanel.returnBottleType();
                        bottleTypeDTO.setId(Long.valueOf(bottleTypeTable.getValueAt(bottleTypeTable.getSelectedRow(), 0).toString()));
                        EditBottleTypeSwingWorker editBottleTypeSwingWorker = new EditBottleTypeSwingWorker(bottleTypeRestClient, bottleTypeTableModel, bottleTypeDTO, bottleTypeTable);
                        editBottleTypeSwingWorker.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid data");
                        updateBottleTypeButtonActionPerformed(evt);
                    }

                }
            }
        } catch (ProcessingException ex) {
            JOptionPane.showMessageDialog(this, "Server connection was not established correctly. Application is closing.", "No server connection.", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }//GEN-LAST:event_updateBottleTypeButtonActionPerformed

    private void deleteBottleTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBottleTypeButtonActionPerformed
        boolean isRowSelected = false;
        for (int x = 0; x < bottleTypeTable.getRowCount(); x++) {
            isRowSelected = isRowSelected || bottleTypeTable.isRowSelected(x);
        }

        if (!isRowSelected) {
            JOptionPane.showMessageDialog(this, "No bottle type selected!");
        } else {
            DeleteBottleTypeSwingWorker deleteBottleTypeSwingWorker;
            deleteBottleTypeSwingWorker = new DeleteBottleTypeSwingWorker(bottleTypeRestClient, bottleTypeTableModel,
                   bottleTypeTableModel.getBottleAt(bottleTypeTable.getSelectedRow()), bottleTypeTable);

            deleteBottleTypeSwingWorker.execute();
            refreshData();
        }
    }//GEN-LAST:event_deleteBottleTypeButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        refreshData();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bottleTypeTable;
    private javax.swing.JTable bottlesTable;
    private javax.swing.JButton createBottleButton;
    private javax.swing.JButton createBottleTypeButton;
    private javax.swing.JButton deleteBottleButton;
    private javax.swing.JButton deleteBottleTypeButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton updateBottleButton;
    private javax.swing.JButton updateBottleTypeButton;
    // End of variables declaration//GEN-END:variables
}

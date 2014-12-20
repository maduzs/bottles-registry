package muni.fi.pa165.liquorbottles.client.swingForms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import muni.fi.pa165.liquorbottles.api.dto.BottleDTO;
import muni.fi.pa165.liquorbottles.api.dto.BottleTypeDTO;
import muni.fi.pa165.liquorbottles.api.dto.ProducerDTO;
import muni.fi.pa165.liquorbottles.api.dto.StoreDTO;
import muni.fi.pa165.liquorbottles.api.dto.ToxicityDTO;
import muni.fi.pa165.liquorbottles.api.services.BottleService;
import muni.fi.pa165.liquorbottles.api.services.BottleTypeService;
import muni.fi.pa165.liquorbottles.client.rest.BottleRestClient;
import muni.fi.pa165.liquorbottles.client.swingWorkers.DeleteBottleSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.DeleteBottleTypeSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.EditBottleSwingWorker;
import muni.fi.pa165.liquorbottles.client.swingWorkers.EditBottleTypeSwingWorker;
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

    List<BottleDTO> allBottles;
    List<BottleTypeDTO> allBottleTypes;
    BottleTableModel bottleTableModel;
    BottleTypeTableModel bottleTypeTableModel;
    BottleRestClient bottleRest;
    BottleTypeService bottleTypeService;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        allBottles = new ArrayList<>();
        allBottleTypes = new ArrayList<>();
        bottleTableModel = new BottleTableModel(allBottles);
        bottleTypeTableModel = new BottleTypeTableModel(allBottleTypes);

        /*
         Testing data, delete later...
         */
       /* BottleTypeDTO bottleType = new BottleTypeDTO();
        bottleType.setName("Vodka");
        bottleType.setId(1);
        BottleTypeDTO bottleType2 = new BottleTypeDTO();
        bottleType2.setName("Rum");
        bottleType2.setId(2);

        StoreDTO store = new StoreDTO();
        store.setName("Liehoviny Peter");
        store.setId(1);

        StoreDTO store2 = new StoreDTO();
        store2.setName("Liehoviny Fero");
        store2.setId(2);

        BottleDTO bottle = new BottleDTO();
        bottle.setBatchNumber(123);
        bottle.setBottleType(bottleType);
        bottle.setDateOfBirth(new Date(new Date().getTime()));
        bottle.setId(1);
        bottle.setStamp(444);
        bottle.setToxicity(ToxicityDTO.UNCHECKED);
        bottle.setStore(store);
        bottle.setId(0);

        BottleDTO bottle1 = new BottleDTO();
        bottle1.setBatchNumber(123);
        bottle1.setBottleType(bottleType2);
        bottle1.setDateOfBirth(new Date(new Date().getTime()));
        bottle1.setId(1);
        bottle1.setStamp(444);
        bottle1.setToxicity(ToxicityDTO.TOXIC);
        bottle1.setStore(store2);
        bottle1.setId(1);

        bottleTableModel.addBottle(bottle);
        bottleTableModel.addBottle(bottle1);

        ProducerDTO producer = new ProducerDTO();
        producer.setName("Modry strom");
        producer.setAddress("tralalatralala");
        producer.setId(1);

        ProducerDTO producer1 = new ProducerDTO();
        producer1.setName("Bozkov");
        producer1.setAddress("ututudhsdhs");
        producer1.setId(2);

        BottleTypeDTO bottleType1 = new BottleTypeDTO();
        bottleType1.setAlcType("Rum");
        bottleType1.setId(1);
        bottleType1.setName("Modry Strom Rum");
        bottleType1.setPower(40);
        bottleType1.setProducer(producer);
        bottleType1.setVolume(70);

        BottleTypeDTO bottleType3 = new BottleTypeDTO();
        bottleType3.setAlcType("Vodka");
        bottleType3.setId(2);
        bottleType3.setName("Bozkov vodka");
        bottleType3.setPower(38);
        bottleType3.setProducer(producer1);
        bottleType3.setVolume(50);

        bottleTypeTableModel.addBottleType(bottleType1);
        bottleTypeTableModel.addBottleType(bottleType3);*/
        /*
         end of testing data
         */

        initComponents();
        bottleRest = new BottleRestClient();
        FindAllBottlesSwingWorker findAllBottlesSwingWorker = new FindAllBottlesSwingWorker(bottleRest, bottleTableModel, bottlesTable);
        findAllBottlesSwingWorker.execute();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bottleTypeTable.setModel(new BottleTypeTableModel(allBottleTypes));
        jScrollPane1.setViewportView(bottleTypeTable);

        bottlesTable.setModel(new BottleTableModel(allBottles));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createBottleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateBottleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBottleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createBottleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateBottleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBottleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(deleteBottleTypeButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        createBottleButton.getAccessibleContext().setAccessibleName("createBottleButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBottleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBottleButtonActionPerformed
        BottlePanel bottlePanel = new BottlePanel(bottleTableModel.getStores(), bottleTableModel.getBottleTypes());
        int result = JOptionPane.showConfirmDialog(this, bottlePanel, "New Bottle", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            NewBottleSwingWorker newBottleSwingWorker = new NewBottleSwingWorker(bottleRest, bottleTableModel, bottlePanel.returnBottle(), bottlesTable);
            newBottleSwingWorker.execute();

        }

    }//GEN-LAST:event_createBottleButtonActionPerformed

    private void updateBottleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBottleButtonActionPerformed
        boolean isRowSelected = false;
        for (int x = 0; x < bottlesTable.getRowCount(); x++) {
            isRowSelected = isRowSelected || bottlesTable.isRowSelected(x);
        }

        if (!isRowSelected) {
            JOptionPane.showMessageDialog(this, "No bottle selected!");
        } else {
            BottlePanel bottlePanel = new BottlePanel(bottleTableModel.getStores(), bottleTableModel.getBottleTypes());
            bottlePanel.setBottle(bottleTableModel.getBottleAt(bottlesTable.getSelectedRow()));
            int result = JOptionPane.showConfirmDialog(this, bottlePanel, "Edit Bottle", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                BottleDTO bottle = bottlePanel.returnBottle();
                bottle.setId(Long.valueOf(bottlesTable.getValueAt(bottlesTable.getSelectedRow(), 0).toString()));
                EditBottleSwingWorker editBottleSwingWorker = new EditBottleSwingWorker(bottleRest, bottleTableModel, bottle, bottlesTable);
                editBottleSwingWorker.execute();
            }
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
            deleteBottleSwingWorker = new DeleteBottleSwingWorker(bottleRest, bottleTableModel,
                    (Long) bottlesTable.getValueAt(bottlesTable.getSelectedRow(), 0), bottlesTable);

            deleteBottleSwingWorker.execute();
        }
    }//GEN-LAST:event_deleteBottleButtonActionPerformed

    private void createBottleTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBottleTypeButtonActionPerformed
        BottleTypePanel bottleTypePanel = new BottleTypePanel(bottleTypeTableModel.getProducers());
        int result = JOptionPane.showConfirmDialog(this, bottleTypePanel, "New BottleType", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            NewBottleTypeSwingWorker newBottleTypeSwingWorker = new NewBottleTypeSwingWorker(bottleTypeService, bottleTypeTableModel, bottleTypePanel.returnBottleType(), bottleTypeTable);
            newBottleTypeSwingWorker.execute();
        }
    }//GEN-LAST:event_createBottleTypeButtonActionPerformed

    private void updateBottleTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBottleTypeButtonActionPerformed
        boolean isRowSelected = false;
        for (int x = 0; x < bottleTypeTable.getRowCount(); x++) {
            isRowSelected = isRowSelected || bottleTypeTable.isRowSelected(x);
        }

        if (!isRowSelected) {
            JOptionPane.showMessageDialog(this, "No bottleType selected!");
        } else {

            BottleTypePanel bottleTypePanel = new BottleTypePanel(bottleTypeTableModel.getProducers());

            bottleTypePanel.setBottleType(bottleTypeTableModel.getBottleAt(bottleTypeTable.getSelectedRow()));
            int result = JOptionPane.showConfirmDialog(this, bottleTypePanel, "Edit Bottle Type", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                BottleTypeDTO bottleTypeDTO = bottleTypePanel.returnBottleType();
                bottleTypeDTO.setId(Long.valueOf(bottleTypeTable.getValueAt(bottleTypeTable.getSelectedRow(), 0).toString()));
                EditBottleTypeSwingWorker editBottleTypeSwingWorker = new EditBottleTypeSwingWorker(bottleTypeService, bottleTypeTableModel, bottleTypeDTO, bottleTypeTable);
                editBottleTypeSwingWorker.execute();

            }
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
            deleteBottleTypeSwingWorker = new DeleteBottleTypeSwingWorker(bottleTypeService, bottleTypeTableModel,
                    (Long) bottleTypeTable.getValueAt(bottleTypeTable.getSelectedRow(), 0), bottleTypeTable);

            deleteBottleTypeSwingWorker.execute();
        }
    }//GEN-LAST:event_deleteBottleTypeButtonActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton updateBottleButton;
    private javax.swing.JButton updateBottleTypeButton;
    // End of variables declaration//GEN-END:variables
}

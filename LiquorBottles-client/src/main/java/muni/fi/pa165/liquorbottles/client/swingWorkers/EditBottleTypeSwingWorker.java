package muni.fi.pa165.liquorbottles.client.swingWorkers;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import muni.fi.pa165.liquorbottles.api.dto.BottleTypeDTO;
import muni.fi.pa165.liquorbottles.client.rest.BottleTypeRestClient;
import muni.fi.pa165.liquorbottles.client.tableModels.BottleTypeTableModel;

/**
 *
 * @author Matus Novak, Masaryk University
 */
public class EditBottleTypeSwingWorker extends SwingWorker<BottleTypeDTO, Integer> {

    BottleTypeRestClient bottleTypeRestClient;
    BottleTypeTableModel bottleTypeTableModel;
    BottleTypeDTO bottleType;
    JTable bottleTypeTable;

    public EditBottleTypeSwingWorker(BottleTypeRestClient bottleTypeRestClient, BottleTypeTableModel bottleTypeTableModel, BottleTypeDTO bottleType, JTable bottleTypeTable) {
        this.bottleTypeRestClient = new BottleTypeRestClient();
        this.bottleTypeTableModel = bottleTypeTableModel;
        this.bottleType = bottleType;
        this.bottleTypeTable = bottleTypeTable;
    }

    @Override
    protected BottleTypeDTO doInBackground() throws Exception {
        bottleTypeRestClient.update(bottleType);
        bottleTypeRestClient.close();
        //bottleService.updateBottle(bottle);
        return bottleType;
    }

    @Override
    protected void done() {
        try {
            // gets the result from doInBackground and invokes exception from it if happened
            get();
            bottleTypeTableModel.updateBottleType(bottleType);
            bottleTypeTable.revalidate();
            bottleTypeTable.repaint();
        } catch (ExecutionException ex) {
            JOptionPane.showMessageDialog(null, "Error while inserting Bottle Type!", "Bottle Type insert error", JOptionPane.WARNING_MESSAGE);
        } catch (InterruptedException ex) {
            Logger.getLogger(FindAllBottlesSwingWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

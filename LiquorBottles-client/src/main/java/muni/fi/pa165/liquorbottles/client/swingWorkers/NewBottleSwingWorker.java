package muni.fi.pa165.liquorbottles.client.swingWorkers;

import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import muni.fi.pa165.liquorbottles.api.dto.BottleDTO;
import muni.fi.pa165.liquorbottles.api.services.BottleService;
import muni.fi.pa165.liquorbottles.client.rest.BottleRestClient;
import muni.fi.pa165.liquorbottles.client.tableModels.BottleTableModel;

/**
 *
 * @author Jakub Lipcak, Masaryk University
 */
public class NewBottleSwingWorker extends SwingWorker<BottleDTO, Integer> {
    
    BottleRestClient bottleRest;
    BottleTableModel bottleTableModel;
    BottleDTO bottle;
    JTable bottleTable;

    public NewBottleSwingWorker(BottleRestClient bottleRest, BottleTableModel bottleTableModel, BottleDTO bottle, JTable bottleTable) {
        this.bottleRest = bottleRest;
        this.bottleTableModel = bottleTableModel;
        this.bottle = bottle;
        this.bottleTable = bottleTable;
    }
    

    @Override
    protected BottleDTO doInBackground() throws Exception {
        bottleRest.add(bottle);
        bottleRest.close();
        return bottle;
    }

    @Override
    protected void done() {
        bottleTableModel.addBottle(bottle);
        bottleTable.revalidate();
        bottleTable.repaint();
        
    }
   
    
}

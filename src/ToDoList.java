import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.WindowConstants;


public class ToDoList extends JFrame {

    JTextField field;
    DefaultListModel model;

    public ToDoList() {

        setTitle("To Do List");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));

        JScrollPane pane = new JScrollPane();
        pane.setPreferredSize(new Dimension(180, 150));

        model = new DefaultListModel();
        JList list = new JList(model);

        list.setDropMode(DropMode.INSERT);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setTransferHandler(new ListHandler());

        field = new JTextField("");
        field.setPreferredSize(new Dimension(150, 25));
        field.setDragEnabled(true);

        panel.add(field);
        pane.getViewport().add(list); 
        panel.add(pane);

        add(panel);

        pack();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private class ListHandler extends TransferHandler {
        @Override
		public boolean canImport(TransferSupport support) {
             if (!support.isDrop()) {
                 return false;
             }

             return support.isDataFlavorSupported(DataFlavor.stringFlavor);
         }

         @Override
		public boolean importData(TransferSupport support) {
             if (!canImport(support)) {
               return false;
             }

             Transferable transferable = support.getTransferable();
             String line;
             try {
               line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
             } catch (Exception e) {
               return false;
             }

             JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
             int index = dl.getIndex();

             String[] data = line.split(",");
             for (String item: data) {
                 if (!item.isEmpty())
                    model.add(index++, item.trim());
             }
             return true;
         }
    }

    public static void main(String[] args) {
        new ToDoList();
    }
}
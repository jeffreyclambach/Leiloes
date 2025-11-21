import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendidos();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Nome", "Valor", "Status" }
        ));
        jScrollPane1.setViewportView(tabelaVendidos);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 20)); 
        jLabel1.setText("Produtos Vendidos");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(evt -> this.dispose());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(jLabel1))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVoltar)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(20)
            .addComponent(jLabel1)
            .addGap(10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10)
            .addComponent(btnVoltar)
            .addGap(10)
        );

        pack();
    }

    private void listarVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();

        DefaultTableModel model = (DefaultTableModel) tabelaVendidos.getModel();
        model.setNumRows(0);

        for (ProdutosDTO p : lista) {
            model.addRow(new Object[]{
                p.getId(), p.getNome(), p.getValor(), p.getStatus()
            });
        }
    }

    // Variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVendidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton btnVoltar;
}

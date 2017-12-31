package possystem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;
public class mainFrame extends javax.swing.JFrame {
    String[] productArray = new String[18];
    float[] priceArray = new float[18];
    DefaultListModel<String> qtyModel = new DefaultListModel<>();//list1 model
    DefaultListModel<String> nameModel = new DefaultListModel<>();//list2 model
    DefaultListModel<String> priceModel = new DefaultListModel<>();//list3 model
    /*
    FOR BUTTONS
    */
    private int n;//Array Selector
    private String m;//Product Name Checker
    private int i;//index checker for duplicate products
    private int qty;//qty to be entered
    private int tempQty;//temporary qty number
    private int newQty;//new qty for duplicates
    private int element;
    private float subtotal;
    private double discount;
    private float tax;
    private float total;
    private double taxPercentage = 0.12;
    private float amountTendered;
    private float change;
    
    public mainFrame() {
        initComponents();
        /*
        SETTING OF LIST MODELS
        */
        qtyList.setModel(qtyModel);//list 1
        productNameList.setModel(nameModel); //list 2
        productTotalList.setModel(priceModel); //list 3
        /*
        ARRAY DATA INPUT
        */
        //Just made all product IDs increment to 1
        for(int x=0;x<productArray.length;x++){
            productArray[x] = "Product"+(x+1);
        }
        //Random Prices
        for(int x=0;x<priceArray.length;x++){
            priceArray[x] = 150+(x*10);
        }
    }
    
    public void computeTotal(){
        subtotal = 0;
        for(int x=0;x<priceModel.size();x++){
            subtotal = subtotal + Float.parseFloat(priceModel.get(x));
        }
        total = subtotal - subtotal* Float.parseFloat(Double.toString(discount));
        tax = Float.parseFloat(String.valueOf(Double.parseDouble(String.valueOf(total))*taxPercentage));
        subtotalPriceLabel.setText(Float.toString(subtotal));
        taxamtPriceLabel.setText(Float.toString(tax));
        totalPriceLabel.setText("Php "+Float.toString(total));
    }
    
    public void productButtonMethod(){//Actions to be done by the Product Buttons
        try{
            qty = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Quantity",null,JOptionPane.QUESTION_MESSAGE));
            if(nameModel.contains(m)){
                i = nameModel.indexOf(m);
                tempQty = Integer.parseInt(qtyModel.getElementAt(i));
                newQty = qty+tempQty;
                qtyModel.setElementAt(String.valueOf(newQty), i);
                float totalPrice = newQty*priceArray[n];
                priceModel.setElementAt(String.valueOf(totalPrice), i);
            }
            else{
                float totalPrice = qty*priceArray[n];
                qtyModel.addElement(String.valueOf(qty));
                nameModel.addElement(productArray[n]);
                priceModel.addElement(String.valueOf(totalPrice));
            }
            computeTotal();
        }
        catch(Exception e){
            showError();
        }
    }

    public void showError(){
        JOptionPane.showMessageDialog(null, "Error in Input",null,JOptionPane.WARNING_MESSAGE);
    }
    
    public void clearElements(){
        qtyModel.removeAllElements();
        nameModel.removeAllElements();
        priceModel.removeAllElements();
        int n;//Array Selector
        String m;//Product Name Checker
        i=0;//index checker for duplicate products
        qty=0;//qty to be entered
        tempQty=0;//temporary qty number
        newQty=0;//new qty for duplicates
        element=0;
        subtotal=0;
        discount=0;
        tax=0;
        total=0;
        discountPriceLabel.setText(Double.toString(discount));
        computeTotal();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        productPanel = new javax.swing.JPanel();
        prodButton1 = new javax.swing.JButton();
        prodButton2 = new javax.swing.JButton();
        prodButton3 = new javax.swing.JButton();
        prodButton4 = new javax.swing.JButton();
        prodButton5 = new javax.swing.JButton();
        prodButton6 = new javax.swing.JButton();
        prodButton7 = new javax.swing.JButton();
        prodButton8 = new javax.swing.JButton();
        prodButton9 = new javax.swing.JButton();
        prodButton10 = new javax.swing.JButton();
        prodButton11 = new javax.swing.JButton();
        prodButton12 = new javax.swing.JButton();
        prodButton13 = new javax.swing.JButton();
        prodButton14 = new javax.swing.JButton();
        prodButton15 = new javax.swing.JButton();
        prodButton16 = new javax.swing.JButton();
        prodButton17 = new javax.swing.JButton();
        prodButton18 = new javax.swing.JButton();
        informationPanel = new javax.swing.JPanel();
        salesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        qtyList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        productNameList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTotalList = new javax.swing.JList<>();
        paymentPanel = new javax.swing.JPanel();
        subtotalLabel = new javax.swing.JLabel();
        subtotalPriceLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        discountPriceLabel = new javax.swing.JLabel();
        taxamtLabel = new javax.swing.JLabel();
        taxamtPriceLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        payButton = new javax.swing.JButton();
        voidButton = new javax.swing.JButton();
        discountButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Point of Sale");
        setResizable(false);

        productPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        productPanel.setToolTipText("");
        productPanel.setName("asd"); // NOI18N

        prodButton1.setText("Product 1");
        prodButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton1ActionPerformed(evt);
            }
        });

        prodButton2.setText("Product 2");
        prodButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton2ActionPerformed(evt);
            }
        });

        prodButton3.setText("Product 3");
        prodButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton3ActionPerformed(evt);
            }
        });

        prodButton4.setText("Product 4");
        prodButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton4ActionPerformed(evt);
            }
        });

        prodButton5.setText("Product 5");
        prodButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton5ActionPerformed(evt);
            }
        });

        prodButton6.setText("Product 6");
        prodButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton6ActionPerformed(evt);
            }
        });

        prodButton7.setText("Product 7");
        prodButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton7ActionPerformed(evt);
            }
        });

        prodButton8.setText("Product 8");
        prodButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton8ActionPerformed(evt);
            }
        });

        prodButton9.setText("Product 9");
        prodButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton9ActionPerformed(evt);
            }
        });

        prodButton10.setText("Product 10");
        prodButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton10ActionPerformed(evt);
            }
        });

        prodButton11.setText("Product 11");
        prodButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton11ActionPerformed(evt);
            }
        });

        prodButton12.setText("Product 12");
        prodButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton12ActionPerformed(evt);
            }
        });

        prodButton13.setText("Product 13");
        prodButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton13ActionPerformed(evt);
            }
        });

        prodButton14.setText("Product 14");
        prodButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton14ActionPerformed(evt);
            }
        });

        prodButton15.setText("Product 15");
        prodButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton15ActionPerformed(evt);
            }
        });

        prodButton16.setText("Product 16");
        prodButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton16ActionPerformed(evt);
            }
        });

        prodButton17.setText("Product 17");
        prodButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton17ActionPerformed(evt);
            }
        });

        prodButton18.setText("Product 18");
        prodButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(prodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(prodButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(prodButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(prodButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(prodButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(prodButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prodButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prodButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        informationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        salesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sales"));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        qtyList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        qtyList.setAutoscrolls(false);
        jScrollPane1.setViewportView(qtyList);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productNameList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productNameList.setAutoscrolls(false);
        jScrollPane2.setViewportView(productNameList);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        productTotalList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTotalList.setAutoscrolls(false);
        jScrollPane3.setViewportView(productTotalList);

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );

        paymentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        subtotalLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        subtotalLabel.setText("Sub-total:");

        subtotalPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        subtotalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        subtotalPriceLabel.setText("0.0");

        discountLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        discountLabel.setText("Discount:");

        discountPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        discountPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        discountPriceLabel.setText("0.0");

        taxamtLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        taxamtLabel.setText("Tax Amount:");

        taxamtPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        taxamtPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        taxamtPriceLabel.setText("0.0");

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(subtotalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subtotalPriceLabel))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(discountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discountPriceLabel))
                    .addGroup(paymentPanelLayout.createSequentialGroup()
                        .addComponent(taxamtLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taxamtPriceLabel)))
                .addContainerGap())
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discountPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taxamtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxamtPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalLabel.setText("TOTAL:");

        totalPriceLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalPriceLabel.setText("PHP 0.0");

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(paymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, informationPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(totalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalPriceLabel)
                                .addGap(9, 9, 9)))
                        .addContainerGap())))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalPriceLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Buttons"));

        logoutButton.setText("Log-out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        payButton.setText("PAY");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        voidButton.setText("VOID");
        voidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voidButtonActionPerformed(evt);
            }
        });

        discountButton.setText("DISCOUNT");
        discountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountButtonActionPerformed(evt);
            }
        });

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(voidButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(discountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(voidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(discountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//PRODUCT BUTTON CLICK FUNCTIONS START HERE
    private void prodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton1ActionPerformed
        n = 0;
        m = "Product1";
       productButtonMethod();
    }//GEN-LAST:event_prodButton1ActionPerformed
    private void prodButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton2ActionPerformed
        n = 1;
        m = "Product2";
        productButtonMethod();
    }//GEN-LAST:event_prodButton2ActionPerformed
    private void prodButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton3ActionPerformed
        n = 2;
        m = "Product3";
        productButtonMethod();
    }//GEN-LAST:event_prodButton3ActionPerformed
    private void prodButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton4ActionPerformed
        n = 3;
        m = "Product4";
        productButtonMethod();
    }//GEN-LAST:event_prodButton4ActionPerformed
    private void prodButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton5ActionPerformed
        n = 4;
        m = "Product5";
        productButtonMethod();
    }//GEN-LAST:event_prodButton5ActionPerformed
    private void prodButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton6ActionPerformed
        n = 5;
        m = "Product6";
        productButtonMethod();
    }//GEN-LAST:event_prodButton6ActionPerformed
    private void prodButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton7ActionPerformed
        n = 6;
        m = "Product7";
        productButtonMethod();
    }//GEN-LAST:event_prodButton7ActionPerformed
    private void prodButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton8ActionPerformed
        n = 7;
        m = "Product8";
        productButtonMethod();
    }//GEN-LAST:event_prodButton8ActionPerformed
    private void prodButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton9ActionPerformed
        n = 8;
        m = "Product9";
        productButtonMethod();
    }//GEN-LAST:event_prodButton9ActionPerformed
    private void prodButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton10ActionPerformed
        n = 9;
        m = "Product10";
        productButtonMethod();
    }//GEN-LAST:event_prodButton10ActionPerformed
    private void prodButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton11ActionPerformed
        n = 10;
        m = "Product11";
        productButtonMethod();
    }//GEN-LAST:event_prodButton11ActionPerformed
    private void prodButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton12ActionPerformed
        n = 11;
        m = "Product12";
        productButtonMethod();
    }//GEN-LAST:event_prodButton12ActionPerformed
    private void prodButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton13ActionPerformed
        n = 12;
        m = "Product13";
        productButtonMethod();
    }//GEN-LAST:event_prodButton13ActionPerformed
    private void prodButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton14ActionPerformed
        n = 13;
        m = "Product14";
        productButtonMethod();
    }//GEN-LAST:event_prodButton14ActionPerformed
    private void prodButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton15ActionPerformed
        n = 14;
        m = "Product15";
        productButtonMethod();
    }//GEN-LAST:event_prodButton15ActionPerformed

//NAVIGATION BUTTON CLICK FUNCTIONS START HERE    
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Object[] options = {"Yes", "No"};
        int y = JOptionPane.showOptionDialog(null, "Continue Exit?", "Logging-Out",
             JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
             null, options, null);
        if(y==0){
            this.dispose();
            loginFrame f = new loginFrame();
            f.setVisible(true);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed
    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        try{
            amountTendered = Float.parseFloat(JOptionPane.showInputDialog(null,"Enter Amount Tendered",null,JOptionPane.QUESTION_MESSAGE));
            if(amountTendered < total){
                JOptionPane.showMessageDialog(null, "Not Enough Cash",null,JOptionPane.WARNING_MESSAGE);
            }
            else{
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String items="";
                change = amountTendered - total;
                for(int x=0;x<qtyModel.size();x++){
                    items = items+qtyModel.get(x)+"   "+nameModel.get(x)+"   "+priceModel.get(x)+"\n";
                }
                String str = "------------------------------\n"
                           + "            RECEIPT           \n"
                           + "------------------------------\n"
                           + items + "Total: "+total+"\n"
                           + "------------------------------\n"
                           + "Amount Tendered: "+amountTendered+"\n"
                           + "Change: "+ change +"\n"
                           + dateFormat.format(date)+"\n"
                           + "------------------------------";
                JOptionPane.showMessageDialog(null, str,"Receipt",JOptionPane.INFORMATION_MESSAGE);
                clearElements();
            }
        }
        catch(Exception e){
            showError();
        }
    }//GEN-LAST:event_payButtonActionPerformed
    private void voidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voidButtonActionPerformed
        element = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Product to be Voided",null,JOptionPane.QUESTION_MESSAGE));
        if(nameModel.isEmpty()){
            JOptionPane.showMessageDialog(null, "List is Empty");
        }
        else{
            try{
                qtyModel.remove(element-1);
                nameModel.remove(element-1);
                priceModel.remove(element-1);
            }
            catch(Exception e){
                showError();
            }
        }
        computeTotal();
    }//GEN-LAST:event_voidButtonActionPerformed
    private void discountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountButtonActionPerformed
        Object[] options = {"Senior Citizen/PWD", "Voucher", "Privilege Card"};
        int y = JOptionPane.showOptionDialog(null, "Enter Discount Type", "Discount Type",
             JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
             null, options, null);
        try{
            if(y==0){
            discount = 0.20;
            JOptionPane.showMessageDialog(null, "20% Discount Applied!");
            }
            else if(y==1){
                Object[] options2 = {"5%", "10%", "15%", "20%"};
                int z = JOptionPane.showOptionDialog(null, "Enter Percentage", "Voucher",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options2, null);
                if(z==0){
                    discount = 0.05;
                    JOptionPane.showMessageDialog(null, "5% Discount Applied!");
                }
                else if(z==1){
                    discount = 0.1;
                    JOptionPane.showMessageDialog(null, "10% Discount Applied!");
                }
                else if(z==2){
                    discount = 0.15;
                    JOptionPane.showMessageDialog(null, "15% Discount Applied!");
                }
                else if(z==3){
                    discount = 0.2;
                    JOptionPane.showMessageDialog(null, "20% Discount Applied!");
                }
            }
            else if(y==2){
                discount = 0.1;
                JOptionPane.showMessageDialog(null, "10% Discount Applied!");
            } 
        }
        catch(Exception e){
            showError();
        }
        discountPriceLabel.setText(Double.toString(discount));
        computeTotal();
    }//GEN-LAST:event_discountButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearElements();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void prodButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton16ActionPerformed
        n = 15;
        m = "Product16";
        productButtonMethod();
    }//GEN-LAST:event_prodButton16ActionPerformed

    private void prodButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton17ActionPerformed
        n = 16;
        m = "Product17";
        productButtonMethod();
    }//GEN-LAST:event_prodButton17ActionPerformed

    private void prodButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButton18ActionPerformed
        n = 17;
        m = "Product18";
        productButtonMethod();
    }//GEN-LAST:event_prodButton18ActionPerformed

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
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton discountButton;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JLabel discountPriceLabel;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton payButton;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JButton prodButton1;
    private javax.swing.JButton prodButton10;
    private javax.swing.JButton prodButton11;
    private javax.swing.JButton prodButton12;
    private javax.swing.JButton prodButton13;
    private javax.swing.JButton prodButton14;
    private javax.swing.JButton prodButton15;
    private javax.swing.JButton prodButton16;
    private javax.swing.JButton prodButton17;
    private javax.swing.JButton prodButton18;
    private javax.swing.JButton prodButton2;
    private javax.swing.JButton prodButton3;
    private javax.swing.JButton prodButton4;
    private javax.swing.JButton prodButton5;
    private javax.swing.JButton prodButton6;
    private javax.swing.JButton prodButton7;
    private javax.swing.JButton prodButton8;
    private javax.swing.JButton prodButton9;
    private javax.swing.JList<String> productNameList;
    private javax.swing.JPanel productPanel;
    private javax.swing.JList<String> productTotalList;
    private javax.swing.JList<String> qtyList;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JLabel subtotalLabel;
    private javax.swing.JLabel subtotalPriceLabel;
    private javax.swing.JLabel taxamtLabel;
    private javax.swing.JLabel taxamtPriceLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JButton voidButton;
    // End of variables declaration//GEN-END:variables
}

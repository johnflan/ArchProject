package simple;

import javax.swing.JFrame;

import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.componentDecorator.ComputerModificator;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.CpuInterface;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.MonitorInterface;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.RamInterface;
import ie.ul.csis.cs4135.pcshop.factory.AbstractProductFactory;
import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerFactory;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Cpu;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Monitor;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Ram;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Cpu;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxRegionEnum;

public class SimpleGUI2 extends javax.swing.JPanel {
	SimpleGUI1 parent;
	private ProductsEnum[] allProducts;
	private TaxRegionEnum[] allRegions;
	private OrderManager orderManager;
	private ComponentInterface currentProduct;
	
	private Integer ramCount;
	private Integer cpuCount;
	private Integer monitorCount;
	
	private int test;
	
    public SimpleGUI2(SimpleGUI1 parentWindow) {
    	
    	ramCount = 1;
    	cpuCount = 1;
    	monitorCount = 1;
    	test = 0;
    	//populate Enum lists
    	allProducts = ProductsEnum.values();
    	allRegions  = TaxRegionEnum.values();
    	try {
			orderManager = new OrderManager(TaxRegionEnum.IRELAND);
		} catch (Exception e) {
			e.printStackTrace();
		}
        initComponents();
        parent = parentWindow;
        
        //redraw window with first product
        assignCurrentProduct();
    	redrawProductInfo();

    }

    public void assignCurrentProduct(){
    	try {
			currentProduct = orderManager.addProduct((ProductsEnum) productTypeCombobox.getSelectedItem());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void redrawProductInfo(){
    	ComponentComposite curProduct = (ComponentComposite)currentProduct;
    	
    	chassisValueLabel.setText(
    			((ComponentComposite)curProduct.getCompositeByStringRecursively("chassis")).getCompositePrice().toString()
    			);
    	cpuValueLabel.setText(
    			(curProduct.getComponentByStringRecursively("cpu")).getPrice().toString() 
   			);
    	ramValueLabel.setText(
    			curProduct.getComponentByStringRecursively("ram").getPrice().toString()
    			);
    	monitorValueLabel.setText(
    			curProduct.getComponentByStringRecursively("monitor").getPrice().toString()
    			);
    }

    public void decorateComponent(String componentType){
    	try {
    		ComponentComposite head = (ComponentComposite) currentProduct;
    		ComputerModificator decorator = orderManager.modifyComputerProduct(currentProduct);
    	
    		if(componentType.equalsIgnoreCase("ram")){    		
	    		RamInterface ram = (RamInterface)head.getComponentByStringRecursively(componentType);
	    		decorator.addRam(ram.getBrandName(), ram.getProductName(), ram.getBaseItem().getPrice(), ram.getRamType() , ram.getRamSize());
	    		ramCounterLabel.setText((++ramCount).toString());
    		}else if(componentType.equalsIgnoreCase("cpu")){
    			CpuInterface cpu = (CpuInterface)head.getComponentByStringRecursively(componentType);
	    		decorator.addCpu(cpu.getBrandName(), cpu.getProductName(), cpu.getBaseItem().getPrice(), cpu.getCpuType(), cpu.getCoreSpeed(), cpu.getNumCores());
	    		cpuCounterLabel.setText((++cpuCount).toString());
    		}else if(componentType.equalsIgnoreCase("monitor")){
    			MonitorInterface monitor = (MonitorInterface)head.getComponentByStringRecursively(componentType);
	    		decorator.addMonitors(monitor.getBrandName(), monitor.getProductName(), monitor.getBaseItem().getPrice(), monitor.getScreenType(), monitor.getScreenSize());
	    		monitorCounterLabel.setText((++monitorCount).toString());
    		}
    		
    		redrawProductInfo();
    		
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void undecorateComponent(String componentType){
    	try {
    		ComponentComposite head = (ComponentComposite) currentProduct;
    		ComputerModificator decorator = orderManager.modifyComputerProduct(currentProduct);
    		decorator.stripComponentItemOfDecorators(componentType, head);
    		
    		if(componentType.equalsIgnoreCase("ram")){
    			ramCount = 1;
	    		ramCounterLabel.setText("1");
    		}else if(componentType.equalsIgnoreCase("cpu")){
    			cpuCount = 1;
	    		cpuCounterLabel.setText("1");
    		}else if(componentType.equalsIgnoreCase("monitor")){
    			monitorCount = 1;
	    		monitorCounterLabel.setText("1");
    		}
    		
    		redrawProductInfo();
    		
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        computerCorpLabel = new javax.swing.JLabel();
        customerDetailLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerDetailsTextbox = new javax.swing.JTextArea();
        orderMgrLabel = new javax.swing.JLabel();
        upperSeparator = new javax.swing.JSeparator();
        selectProductLabel = new javax.swing.JLabel();
        productTypeCombobox = new javax.swing.JComboBox();
        monitorLabel = new javax.swing.JLabel();
        KeyboardLabel = new javax.swing.JLabel();
        speakersLabel = new javax.swing.JLabel();
        chassisLabel = new javax.swing.JLabel();
        hardDiskLabel = new javax.swing.JLabel();
        psuLabel = new javax.swing.JLabel();
        moboLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        addProductBtn = new javax.swing.JButton();
        cpuLabel = new javax.swing.JLabel();
        gpuLabel = new javax.swing.JLabel();
        ramLabel = new javax.swing.JLabel();
        monitorValueLabel = new javax.swing.JLabel();
        KeyboardValueLabel = new javax.swing.JLabel();
        speakersValueLabel = new javax.swing.JLabel();
        chassisValueLabel = new javax.swing.JLabel();
        hardDiskValueLabel = new javax.swing.JLabel();
        psuValueLabel = new javax.swing.JLabel();
        moboValueLabel = new javax.swing.JLabel();
        cpuValueLabel = new javax.swing.JLabel();
        gpuValueLabel = new javax.swing.JLabel();
        ramValueLabel = new javax.swing.JLabel();
        dvdLabel = new javax.swing.JLabel();
        dvdValueLabel = new javax.swing.JLabel();
        addMonitorBtn = new javax.swing.JButton();
        addKeyboardBtn = new javax.swing.JButton();
        addSpeakersBtn = new javax.swing.JButton();
        addChassisBtn = new javax.swing.JButton();
        addHardDiskBtn = new javax.swing.JButton();
        addPsuBtn = new javax.swing.JButton();
        addDVDBtn = new javax.swing.JButton();
        addMoboBtn = new javax.swing.JButton();
        addCpuBtn = new javax.swing.JButton();
        addGpuBtn = new javax.swing.JButton();
        addRamBtn = new javax.swing.JButton();
        clearMonitorBtn = new javax.swing.JButton();
        clearKeyboardBtn = new javax.swing.JButton();
        clearSpeakersBtn = new javax.swing.JButton();
        clearHardDiskBtn = new javax.swing.JButton();
        clearPsuBtn = new javax.swing.JButton();
        clearChassiaBtn = new javax.swing.JButton();
        clearMoboBtn = new javax.swing.JButton();
        clearCpuBtn = new javax.swing.JButton();
        clearDVDBtn = new javax.swing.JButton();
        clearRamBtn = new javax.swing.JButton();
        clearGpuBtn = new javax.swing.JButton();
        monitorCounterLabel = new javax.swing.JLabel();
        keyboardCounterLabel = new javax.swing.JLabel();
        speakersCounterLabel = new javax.swing.JLabel();
        chassisCounterLabel = new javax.swing.JLabel();
        hardDiskCounterLabel = new javax.swing.JLabel();
        psuCounterLabel = new javax.swing.JLabel();
        DVDCounterLabel = new javax.swing.JLabel();
        moboCounterLabel = new javax.swing.JLabel();
        cpuCounterLabel = new javax.swing.JLabel();
        gpuCounterLabel = new javax.swing.JLabel();
        ramCounterLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        totalCostValueLabel = new javax.swing.JLabel();
        totalCostLabel = new javax.swing.JLabel();

        computerCorpLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computerCorpLabel.setText("Computer Corp");

        customerDetailLabel.setText("CustomerDetails");

        customerDetailsTextbox.setColumns(20);
        customerDetailsTextbox.setRows(5);
        jScrollPane1.setViewportView(customerDetailsTextbox);

        orderMgrLabel.setText("Order Manager");

        selectProductLabel.setText("Select Product Type");

        productTypeCombobox.setModel(new javax.swing.DefaultComboBoxModel(allProducts));
        productTypeCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productTypeComboboxActionPerformed(evt);
            }
        });

        

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addProductBtn.setText("Add a Product");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        monitorLabel.setText("Monitor:");
        KeyboardLabel.setText("Keyboard:");
        speakersLabel.setText("Speakers:");
        chassisLabel.setText("Chassis:");
        hardDiskLabel.setText("Hard Disk:");
        psuLabel.setText("Power Supply:");
        moboLabel.setText("Motherboard:");
        cpuLabel.setText("CPU:");
        gpuLabel.setText("GPU:");
        ramLabel.setText("RAM:");
        monitorValueLabel.setText("");
        KeyboardValueLabel.setText("");
        speakersValueLabel.setText("");
        chassisValueLabel.setText("");
        hardDiskValueLabel.setText("");
        psuValueLabel.setText("");
        moboValueLabel.setText("");
        cpuValueLabel.setText("");
        gpuValueLabel.setText("");
        ramValueLabel.setText("");
        dvdLabel.setText("DVD:");
        dvdValueLabel.setText("");
        monitorCounterLabel.setText("1");
        keyboardCounterLabel.setText("1");
        speakersCounterLabel.setText("1");
        chassisCounterLabel.setText("1");
        hardDiskCounterLabel.setText("1");
        psuCounterLabel.setText("1");
        DVDCounterLabel.setText("1");
        moboCounterLabel.setText("1");
        cpuCounterLabel.setText("1");
        gpuCounterLabel.setText("1");
        ramCounterLabel.setText("1");
        totalCostValueLabel.setText("");
        totalCostLabel.setText("Total Cost:");
        
        
        addMonitorBtn.setText("+");
        addMonitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMonitorBtnActionPerformed(evt);
            }
        });

        addKeyboardBtn.setText("+");
        addKeyboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKeyboardBtnActionPerformed(evt);
            }
        });

        addSpeakersBtn.setText("+");
        addSpeakersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSpeakersBtnActionPerformed(evt);
            }
        });

        addChassisBtn.setText("+");
        addChassisBtn.setEnabled(false);
        addChassisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChassisBtnActionPerformed(evt);
            }
        });

        addHardDiskBtn.setText("+");
        addHardDiskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHardDiskBtnActionPerformed(evt);
            }
        });

        addPsuBtn.setText("+");
        addPsuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPsuBtnActionPerformed(evt);
            }
        });

        addDVDBtn.setText("+");
        addDVDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDVDBtnActionPerformed(evt);
            }
        });

        addMoboBtn.setText("+");
        addMoboBtn.setEnabled(false);
        addMoboBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoboBtnActionPerformed(evt);
            }
        });

        addCpuBtn.setText("+");
        addCpuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCpuBtnActionPerformed(evt);
            }
        });

        addGpuBtn.setText("+");
        addGpuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGpuBtnActionPerformed(evt);
            }
        });

        addRamBtn.setText("+");
        addRamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRamBtnActionPerformed(evt);
            }
        });

        clearMonitorBtn.setText("-");
        clearMonitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMonitorBtnActionPerformed(evt);
            }
        });

        clearKeyboardBtn.setText("-");
        clearKeyboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearKeyboardBtnActionPerformed(evt);
            }
        });

        clearSpeakersBtn.setText("-");
        clearSpeakersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSpeakersBtnActionPerformed(evt);
            }
        });

        clearHardDiskBtn.setText("-");
        clearHardDiskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHardDiskBtnActionPerformed(evt);
            }
        });

        clearPsuBtn.setText("-");
        clearPsuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPsuBtnActionPerformed(evt);
            }
        });

        clearChassiaBtn.setText("-");
        clearChassiaBtn.setEnabled(false);
        clearChassiaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearChassiaBtnActionPerformed(evt);
            }
        });

        clearMoboBtn.setText("-");
        clearMoboBtn.setEnabled(false);
        clearMoboBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearMoboBtnActionPerformed(evt);
            }
        });

        clearCpuBtn.setText("-");
        clearCpuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCpuBtnActionPerformed(evt);
            }
        });

        clearDVDBtn.setText("-");
        clearDVDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDVDBtnActionPerformed(evt);
            }
        });

        clearRamBtn.setText("-");
        clearRamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRamBtnActionPerformed(evt);
            }
        });

        clearGpuBtn.setText("-");
        clearGpuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearGpuBtnActionPerformed(evt);
            }
        });

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(upperSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(computerCorpLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(selectProductLabel)
                                .addComponent(orderMgrLabel)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(customerDetailLabel)
                                        .addGap(238, 238, 238))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(productTypeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 465, Short.MAX_VALUE)
                        .addComponent(addProductBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(keyboardCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KeyboardLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(speakersCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(speakersLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chassisCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chassisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hardDiskCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hardDiskLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(psuCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(psuLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DVDCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dvdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(moboCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moboLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpuCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpuLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gpuCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gpuLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ramCounterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ramLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monitorCounterLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(monitorLabel))
                                    .addComponent(totalCostLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(monitorValueLabel)
                                            .addComponent(KeyboardValueLabel)
                                            .addComponent(speakersValueLabel)
                                            .addComponent(chassisValueLabel)
                                            .addComponent(hardDiskValueLabel)
                                            .addComponent(psuValueLabel)
                                            .addComponent(dvdValueLabel)
                                            .addComponent(moboValueLabel)
                                            .addComponent(cpuValueLabel)
                                            .addComponent(gpuValueLabel)
                                            .addComponent(ramValueLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addMonitorBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearMonitorBtn))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addKeyboardBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearKeyboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addSpeakersBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearSpeakersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addChassisBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearChassiaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addHardDiskBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearHardDiskBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addPsuBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearPsuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addDVDBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearDVDBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addMoboBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearMoboBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addCpuBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearCpuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(addGpuBtn)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(clearGpuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(addRamBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearRamBtn))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(98, 98, 98)
                                        .addComponent(totalCostValueLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(computerCorpLabel)
                    .addComponent(customerDetailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderMgrLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectProductLabel)
                    .addComponent(productTypeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(upperSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monitorValueLabel)
                        .addComponent(monitorCounterLabel)
                        .addComponent(monitorLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addMonitorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearMonitorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(keyboardCounterLabel)
                        .addComponent(KeyboardLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(KeyboardValueLabel)
                        .addComponent(addKeyboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearKeyboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(speakersCounterLabel)
                        .addComponent(speakersLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(speakersValueLabel)
                        .addComponent(addSpeakersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearSpeakersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chassisCounterLabel)
                        .addComponent(chassisLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chassisValueLabel)
                        .addComponent(addChassisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearChassiaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hardDiskCounterLabel)
                        .addComponent(hardDiskLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hardDiskValueLabel)
                        .addComponent(addHardDiskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearHardDiskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(psuCounterLabel)
                        .addComponent(psuLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(psuValueLabel)
                        .addComponent(addPsuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearPsuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DVDCounterLabel)
                        .addComponent(dvdLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dvdValueLabel)
                        .addComponent(addDVDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearDVDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moboCounterLabel)
                    .addComponent(moboLabel)
                    .addComponent(moboValueLabel)
                    .addComponent(addMoboBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearMoboBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpuCounterLabel)
                    .addComponent(cpuLabel)
                    .addComponent(cpuValueLabel)
                    .addComponent(addCpuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearCpuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gpuCounterLabel)
                    .addComponent(gpuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gpuValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addGpuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearGpuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ramCounterLabel)
                    .addComponent(ramLabel)
                    .addComponent(ramValueLabel)
                    .addComponent(addRamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearRamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCostLabel)
                    .addComponent(totalCostValueLabel))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(addProductBtn))
                .addContainerGap())
        );
    }// </editor-fold>

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addMonitorBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	decorateComponent("monitor");
    }

    private void addKeyboardBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addSpeakersBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addChassisBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addHardDiskBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addPsuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addDVDBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addMoboBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addCpuBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	decorateComponent("cpu");
    }

    private void addGpuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addRamBtnActionPerformed(java.awt.event.ActionEvent evt) {
        decorateComponent("ram");
    }

    private void clearMonitorBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	undecorateComponent("monitor");
    }

    private void clearKeyboardBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearSpeakersBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearHardDiskBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearPsuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearChassiaBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearMoboBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearCpuBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	undecorateComponent("cpu");
    }

    private void clearDVDBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void clearRamBtnActionPerformed(java.awt.event.ActionEvent evt) {
        undecorateComponent("ram");
    }

    private void clearGpuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	
        parent.addProductToOrderList(currentProduct, (JFrame) this.getParent().getParent().getParent());
        System.out.println(test++);
    }

    private void productTypeComboboxActionPerformed(java.awt.event.ActionEvent evt) {
    	assignCurrentProduct();
    	redrawProductInfo();
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel DVDCounterLabel;
    private javax.swing.JLabel KeyboardLabel;
    private javax.swing.JLabel KeyboardValueLabel;
    private javax.swing.JButton addChassisBtn;
    private javax.swing.JButton addCpuBtn;
    private javax.swing.JButton addDVDBtn;
    private javax.swing.JButton addGpuBtn;
    private javax.swing.JButton addHardDiskBtn;
    private javax.swing.JButton addKeyboardBtn;
    private javax.swing.JButton addMoboBtn;
    private javax.swing.JButton addMonitorBtn;
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton addPsuBtn;
    private javax.swing.JButton addRamBtn;
    private javax.swing.JButton addSpeakersBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel chassisCounterLabel;
    private javax.swing.JLabel chassisLabel;
    private javax.swing.JLabel chassisValueLabel;
    private javax.swing.JButton clearChassiaBtn;
    private javax.swing.JButton clearCpuBtn;
    private javax.swing.JButton clearDVDBtn;
    private javax.swing.JButton clearGpuBtn;
    private javax.swing.JButton clearHardDiskBtn;
    private javax.swing.JButton clearKeyboardBtn;
    private javax.swing.JButton clearMoboBtn;
    private javax.swing.JButton clearMonitorBtn;
    private javax.swing.JButton clearPsuBtn;
    private javax.swing.JButton clearRamBtn;
    private javax.swing.JButton clearSpeakersBtn;
    private javax.swing.JLabel computerCorpLabel;
    private javax.swing.JLabel cpuCounterLabel;
    private javax.swing.JLabel cpuLabel;
    private javax.swing.JLabel cpuValueLabel;
    private javax.swing.JLabel customerDetailLabel;
    private javax.swing.JTextArea customerDetailsTextbox;
    private javax.swing.JLabel dvdLabel;
    private javax.swing.JLabel dvdValueLabel;
    private javax.swing.JLabel gpuCounterLabel;
    private javax.swing.JLabel gpuLabel;
    private javax.swing.JLabel gpuValueLabel;
    private javax.swing.JLabel hardDiskCounterLabel;
    private javax.swing.JLabel hardDiskLabel;
    private javax.swing.JLabel hardDiskValueLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel keyboardCounterLabel;
    private javax.swing.JLabel moboCounterLabel;
    private javax.swing.JLabel moboLabel;
    private javax.swing.JLabel moboValueLabel;
    private javax.swing.JLabel monitorCounterLabel;
    private javax.swing.JLabel monitorLabel;
    private javax.swing.JLabel monitorValueLabel;
    private javax.swing.JLabel orderMgrLabel;
    private javax.swing.JComboBox productTypeCombobox;
    private javax.swing.JLabel psuCounterLabel;
    private javax.swing.JLabel psuLabel;
    private javax.swing.JLabel psuValueLabel;
    private javax.swing.JLabel ramCounterLabel;
    private javax.swing.JLabel ramLabel;
    private javax.swing.JLabel ramValueLabel;
    private javax.swing.JLabel selectProductLabel;
    private javax.swing.JLabel speakersCounterLabel;
    private javax.swing.JLabel speakersLabel;
    private javax.swing.JLabel speakersValueLabel;
    private javax.swing.JLabel totalCostLabel;
    private javax.swing.JLabel totalCostValueLabel;
    private javax.swing.JSeparator upperSeparator;
    // End of variables declaration

}

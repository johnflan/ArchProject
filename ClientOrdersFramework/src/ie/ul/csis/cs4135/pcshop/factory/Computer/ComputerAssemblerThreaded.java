package ie.ul.csis.cs4135.pcshop.factory.Computer;

import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.ComputerComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Cpu;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Monitor;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Ram;

public class ComputerAssemblerThreaded {
	
	private ComputerComposite computer;
	private ComputerComposite motherboard;
	private ComputerComposite chassis;
	private ComputerComponentInterface ram;
	protected ComputerComponentInterface cpu;
	private ComputerComponentInterface monitor;
	private ProductsEnum productType;
	
	private boolean constructedOk;
	
    ComputerAssemblerThreaded(ProductsEnum productType){
    	this.productType = productType;
    }

    private void putPartsTogether(){
    	
    }
    
	public void construct() {
		
	}

	public ComputerComposite getComputer(){
		return computer;
	}
	
	public void createProductsInThreads() throws InterruptedException{
		Thread cpuT 	= new Thread(new cpuThread(this)	);
		Thread ramT 	= new Thread(new ramThread(this)	);
		Thread monitorT = new Thread(new monitorThread(this));
		Thread moboT 	= new Thread(new moboThread(this)	);
		Thread chassisT = new Thread(new chassisThread(this));
		Thread computerT= new Thread(new computerThread(this));

		cpuT.start();
		ramT.start();
		monitorT.start();
		moboT.start();
		chassisT.start();
		computerT.start();
		
		cpuT.join(1000);
		ramT.join(1000);
		monitorT.join(1000);
		moboT.join(1000);
		chassisT.join(1000);
		computerT.join(1000);
		
		if(cpuT.isAlive()){
			cpuT.interrupt();
			constructedOk = false;
		}
		if(ramT.isAlive()){
			ramT.interrupt();
			constructedOk = false;
		}
		if(monitorT.isAlive()){
			monitorT.interrupt();
			constructedOk = false;
		}
		if(moboT.isAlive()){
			moboT.interrupt();
			constructedOk = false;
		}
		if(chassisT.isAlive()){
			chassisT.interrupt();
			constructedOk = false;
		}
		if(computerT.isAlive()){
			computerT.interrupt();
			constructedOk = false;
		}
		assembleComputer();
	}

	public void assembleComputer(){
		motherboard.addComponent("ram", ram);
		motherboard.addComponent("cpu", cpu);
		chassis.addComposite("motherboard", motherboard);
		computer.addComposite("chassis", chassis);
		computer.addComponent("monitor", monitor);
	}
	
	/*
	 * Inner classes implementing Threads
	 */
	public static class cpuThread implements Runnable {
		
		ComputerAssemblerThreaded parent;
		
        public cpuThread(ComputerAssemblerThreaded parent) {
			this.parent = parent;
		}
		public void run() {
            parent.cpu = new Cpu("Intel", "Core2Duo", 220f, "E6800", 2.6f, 4);
        }
    }

	public static class ramThread implements Runnable {
		
		ComputerAssemblerThreaded parent;
		
	    public ramThread(ComputerAssemblerThreaded parent) {
			this.parent = parent;
		}
		public void run() {
	        parent.ram = new Ram("Kingston", "HyperX", 100f, "DDR2", 2048);
		}
	}
	
	public static class chassisThread implements Runnable {
		
		ComputerAssemblerThreaded parent;
		
	    public chassisThread(ComputerAssemblerThreaded parent) {
			this.parent = parent;
		}
		public void run() {
			parent.chassis = new ComputerComposite("Cooltek", "Extreme", 64.80F);       	
	    }
	}
	
	public static class moboThread implements Runnable {
		
		ComputerAssemblerThreaded parent;
		
	    public moboThread(ComputerAssemblerThreaded parent) {
			this.parent = parent;
		}
		public void run() {
			parent.motherboard = new ComputerComposite("Asus", "Npower", 150F);       	
	    }
	}

	public static class computerThread implements Runnable {
		
		ComputerAssemblerThreaded parent;
		
	    public computerThread(ComputerAssemblerThreaded parent) {
			this.parent = parent;
		}
		public void run() {
			parent.computer = new ComputerComposite("Dell", "Optiflex", 0.0f);
		}
	}
	
	public static class monitorThread implements Runnable {
		
		ComputerAssemblerThreaded parent;
		
	    public monitorThread(ComputerAssemblerThreaded parent) {
			this.parent = parent;
		}
		public void run() {
			parent.monitor = new Monitor("Sony", "Visionmaster", 164.20f, "lcd", 22);         	
		}
	}
}
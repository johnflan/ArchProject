public class ComputerAssemblerThreaded {
	
	private ComputerComponentInterface ram;
	private ComputerComponentInterface cpu;
	private ComponentInterface computer;
	private boolean constructedOk;
	
    ComputerAssemblerThreaded(ProductsEnum productType){
    	this.productType = productType;
    }

	public ComponentInterface construct() throws InterruptedException {
		Thread cpuT = new Thread(new cpuThread(this));
		Thread ramT = new Thread(new ramThread(this));

		cpuT.start();
		ramT.start();

		cpuT.join(1000);
		ramT.join(1000);
		
		if(cpuT.isAlive()){
			cpuT.interrupt();
			constructedOk = false;
		}
		if(ramT.isAlive()){
			ramT.interrupt();
			constructedOk = false;
		}

		assembleComputer();
		return computer;	
	}

	public void assembleComputer(){
		motherboard.addComponent("ram", ram);
		motherboard.addComponent("cpu", cpu);
	}
	
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
}

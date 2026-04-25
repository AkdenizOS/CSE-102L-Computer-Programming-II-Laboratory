import java.util.*;

public class FactoryLogisticsSimulator {
    public static void main(String[] args) {
        int factoryX = 0; int factoryY = 0;

        MachineUnit[][] machineGrid = new MachineUnit[2][2];
        machineGrid[0][0] = new WiringMachine("Arm Auto-Wirer");
        machineGrid[0][1] = null; 
        machineGrid[1][0] = new WiringMachine("Core Solderer");
        machineGrid[1][1] = null;

        Queue<TechModule> assemblyQueue = new ArrayDeque<>();
        assemblyQueue.add(new ServerUnit("Enterprise Blade", 10, 15, 4));
        assemblyQueue.add(new DroneUnit("AeroScout Pro", 20, 25, 5.0));

        FactoryFloor floor = new FactoryFloor(machineGrid, assemblyQueue);
        floor.runAssemblyLine();

        System.out.println("--- LOGISTICS SUMMARY ---");
        Stack<TechModule> shippingStack = floor.getReadyModules();
        double totalInvoicedValue = 0.0;
        
        while (!shippingStack.isEmpty()) {
            TechModule module = shippingStack.pop();
            double logisticsFee = module.calculateShippingFee(factoryX, factoryY); 
            double finalInvoicePrice = module.getManufacturingCost() + logisticsFee;
            totalInvoicedValue += finalInvoicePrice;
            
            System.out.printf("Shipping %s. Total: $%.2f\n", module.getModelName(), finalInvoicePrice);
        }
        System.out.printf("Total Value Shipped: $%.2f\n", totalInvoicedValue);
    }
}

interface IShippable{
    public double calculateShippingFee(int startX, int startY);
}

abstract class TechModule implements IShippable{
    private double manufacturingCost=0.0;
    private String modelName;
    private int bayX ,bayY;
    
    public TechModule(String modelName, int bayX, int bayY){
        this.modelName=modelName;
        this.bayX=bayX;
        this.bayY=bayY;
    }
    
    public String getModelName(){
        return modelName;
    }
    public int getBayX(){
        return bayX;
    }
    public int getBayY(){
        return bayY;
    }
    public double getManufacturingCost(){
        return manufacturingCost;
    }
    public void setManufacturingCost(double manufacturingCost){
        this.manufacturingCost=manufacturingCost;
    }
    public void setBayX(int bayX){
        this.bayX=bayX;
    }
    public void setBayY(int bayY){
     this.bayY=bayY;   
    }
    @Override
    public double calculateShippingFee(int startX, int startY){
        return (Math.abs(startX-bayX)+Math.abs(startY-bayY))*15;
    }
}

class ServerUnit extends TechModule{
    private int cpuCount;
    
    public ServerUnit(String modelName, int bayX, int bayY, int cpuCount){
        super(modelName,bayX,bayY);
        this.cpuCount=cpuCount;
    }
    
    public void InitalManufacturingCost(){
       setManufacturingCost(500.0 + (cpuCount * 120.0)); 
   }
    
}

class DroneUnit extends TechModule{ 
    private double cubicFrameSize; 
    
    public DroneUnit(String modelName, int bayX, int bayY, double cubicFrameSize){
        super(modelName,bayX,bayY);
        this.cubicFrameSize=cubicFrameSize;
    }
    
    public void InitalManufacturingCost(){
        setManufacturingCost(100.0 + (cubicFrameSize * cubicFrameSize * cubicFrameSize * 0.2));
    }
    
}

abstract class MachineUnit{
    private String name;
    
    public MachineUnit(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
     public abstract void processHardware(TechModule C);
}

class WiringMachine extends MachineUnit{
    public WiringMachine(String name){
        super(name);
    } 
    @Override
    public void processHardware(TechModule C){
    C.setManufacturingCost(C.getManufacturingCost()+50);
    }
}

class WarehouseBin<T>{
    private Object[] item; 
    private int count=0,capacity;
    
    public WarehouseBin(int capacity){
        this.capacity=capacity;
        this.item=new Object[capacity];
    }
    public void addPart(T part){
        //if(item+)
    }
    
    public void retrievePart(){
        
    }
}

class FactoryFloor{
    private MachineUnit[][] grid; 
    private Queue<TechModule> chassisQueue;
    private Stack<TechModule> readyModules;
    
    public FactoryFloor(MachineUnit[][] grid,Queue<TechModule> chassisQueue){
    //    this.grid=new MachineUnit[][];
      //  this.chassisQueue=new Queue<>();
        this.readyModules=new Stack<>();
    }
    
    public void runAssemblyLine(){
       // while(!chassisQueue.isEmpty()){
     //       chassisQueue.pol
     //   }
        
        
        
    }
    public Stack<TechModule> getReadyModules(){
        return readyModules;
    }
    
    
}
































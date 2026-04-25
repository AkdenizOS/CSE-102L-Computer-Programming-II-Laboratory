public class towerDefense {
    public static void main(String[] args) {

        // TEST 1
        System.out.println("[Wave 1]");
        double[][] wave1 = {
            {10.5, 20.0, 2.0, 50.0},
            {50.0, 50.0, 5.0, 100.0},
            {5.0, 5.0, 0.0, 30.0}
        };
        SniperTower tower1 = new SniperTower(0.0, 0.0, 30.0, 15, 5, 3);
        int defeated1 = tower1.engageEnemies(wave1);
        System.out.println("Enemies Defeated: " + defeated1 + " / 3");
        System.out.println("Remaining Ammo: " + tower1.getAmmo() + "\n");

        // TEST 2
        System.out.println("[Wave 2]");
        double[][] wave2 = {
            {10.0, 10.0, 50.0, 100.0}
        };
        SniperTower tower2 = new SniperTower(0.0, 0.0, 30.0, 15, 5, 3);
        int defeated2 = tower2.engageEnemies(wave2);
        System.out.println("Enemies Defeated: " + defeated2 + " / 1");
        System.out.println("Remaining Ammo: " + tower2.getAmmo() + "\n");

        // TEST 3
        System.out.println("[Wave 3]");
        double[][] wave3 = {
            {0.0, 5.0, 1.0, 10.0},
            {0.0, -5.0, 1.0, 10.0},
            {5.0, 0.0, 1.0, 10.0},
            {-5.0, 0.0, 1.0, 10.0}
        };
        SniperTower tower3 = new SniperTower(0.0, 0.0, 30.0, 15, 5, 3);
        int defeated3 = tower3.engageEnemies(wave3);
        System.out.println("Enemies Defeated: " + defeated3 + " / 4");
        System.out.println("Remaining Ammo: " + tower3.getAmmo());
    }
}
class Tower {
    private double x ,y,range;
    private int baseDamage ;
    
    public Tower(double x, double y, double range, int baseDamage){
        this.x=x;
        this.y=y;
        this.range=range;
        this.baseDamage=baseDamage;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getRange(){
        return range;
    }
    
    public int getBaseDamage(){
        return baseDamage;
    }
    
    
    
    public double calculateDistance(double enemyX, double enemyY) {
     double distance=Math.sqrt(Math.pow((enemyX-x),2)+Math.pow((enemyY-y),2));
     return distance;
        
    }
    
    public boolean canHit(double enemyX, double enemyY) {
        if(calculateDistance(enemyX,enemyY)>range){
            return false;
        }else {
            return true;
        }
    }
    
    
}

class SniperTower extends Tower{
    private int ammo,criticalMultiplier,shotsFired ;
    
    public SniperTower(double x, double y, double range, int baseDamage, int ammo, int criticalMultiplier){
        super(x, y, range,baseDamage);
        this.ammo=ammo;
        this.criticalMultiplier=criticalMultiplier;
    }
    
    public int getAmmo(){
        return ammo;
    }
    
   public int fire(double enemyX, double enemyY, int enemyArmor){
    if(ammo==0){
       return 0;
    }
   if(!canHit(enemyX,enemyY)){
       return 0;
   }else{
       ammo--;
       shotsFired++;
       if(shotsFired>=3&&shotsFired%3==0){
           if(enemyArmor>getBaseDamage()*criticalMultiplier){
             return 0;
             }
             else return getBaseDamage()*criticalMultiplier;
       }
       if(enemyArmor>getBaseDamage()){
           return 0;
          }
        }
        return 0;
     }
    public void reload(int bulletsToAdd){
        ammo+=bulletsToAdd;
    }
    
    public int engageEnemies(double[][] enemies){
        for(int i=0;i<enemies[0].length;i++){
            for(int j=0;j<enemies.length;j++){
            if(enemies[i]==null){
               continue;
            }
            if(ammo==0){
                reload(5);
           }
           
            
            
            }
           
        }
         return 0;
    }
    
}

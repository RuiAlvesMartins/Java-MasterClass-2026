package section8.Composition;
public class PersonalComputer extends Product {

    //  PersonalComputer HAS A ComputerCase;
    private ComputerCase computerCase;
    //  PersonalComputer HAS A Monitor;
    private Monitor monitor;
    //  PersonalComputer HAS A Motherboard;
    private Motherboard motherboard;
    
    public PersonalComputer(String model, String manufacturer, ComputerCase computerCase, Monitor monitor,
            Motherboard motherboard) {
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    //  these getters should be private
    //  they are public for demonstration purposes;
    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    //  because users don't need to have access to this method, we leave it on private;
    private void drawLogo() {
        monitor.drawPixerAt(1200, 50, "yellow");
        System.out.println("Logo printed!");
    }  
    
    public void powerUp() {
        computerCase.pressPowerButton();
        motherboard.loadProgram("Windows OS");
        drawLogo();
    }

}

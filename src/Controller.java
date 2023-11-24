public abstract class Controller
{
    private double setPoint;
    private double kC, tauI, tauD;

    private double controlledVariableLast;

    private Controllable controllable;

    private double integralErrorNow;
    private double integralErrorLast;

    public Controller(double setPoint, double kC, double tauI, double tauD,  Controllable controllable) {
        this.setPoint = setPoint;
        this.kC = kC;
        this.tauI = tauI;
        this.tauD = tauD;
        this.controlledVariableLast = 0;
        this.controllable = controllable.clone();
        this.integralErrorLast = 0;
    }

    public Controller(Controller source)
    {
        if(source==null) System.exit(0);
        this.setPoint = source.setPoint;
        this.kC = source.kC;
        this.tauI = source.tauI;
        this.tauD = source.tauD;
        this.controlledVariableLast = source.controlledVariableLast;
        this.controllable = source.controllable.clone();
        this.integralErrorNow = source.integralErrorNow;
        this.integralErrorLast = source.integralErrorLast;
    }

    public double calculateP()
    {
        return (kC)*(setPoint-this.controllable.readControlledVariable());
    }
    public double calculateI(double timeStep)
    {
        this.integralErrorLast =  integralErrorLast+((kC/tauI)*((setPoint-this.controllable.readControlledVariable()))*(timeStep));
        return this.integralErrorLast;
    }
    public double calculateD(double timeStep)
    {
        this.controlledVariableLast =  -kC*(tauD)*((this.controllable.readControlledVariable()-this.controlledVariableLast)/(timeStep));
        return this.controlledVariableLast;
    }

    public double updateManipulatedVariable(double timeStep)
    {
       return this.controllable.setManipulatedVariable(calculateManipulatedVariable(timeStep));
    }

    public abstract double calculateManipulatedVariable(double timeStep);



}//end of Controller Parent Class

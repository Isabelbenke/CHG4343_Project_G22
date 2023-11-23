//Child class PIController of Parent Class Controller
public class PIController extends Controller
{

    //Constructor 


    public PIController(double setPoint, double kC, double tauI, double tauD, Controllable controllable) {
        super(setPoint, kC, tauI, tauD, controllable);
    }

    //Copy constructor
    public PIController(PIController source)
    {
        super(source);
    }
    
    public Controller clone()
    {
        return new PIController(this);

    }

    //Equals method
    public boolean equals(Object comparator)
    {
        if(!super.equals(comparator)) return false;
        return true;
    }

    @Override
    public double calculateManipulatedVariable(double timeStep)
    {
        return ((setPoint-this.controllable.readControlledVariable())+super.calculateP() + super.calculateI(timeStep));
    }



}//end of PI controller class



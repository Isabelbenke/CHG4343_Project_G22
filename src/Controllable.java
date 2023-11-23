public interface Controllable
{
    double setManipulatedVariable(double manipulatedVariable); //for changing flowrate
    double readControlledVariable(); //for reading concentration

    Controllable clone(); // needs to be copied without revealing its address in memory
    //double getProcessVariable();
    //void calculateControl();
}


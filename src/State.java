/**
 * Created by Karoon on 4/10/2017.
 */
class State {
    // List the characteristics of the states
    private int stateNum = 0;
    private boolean acceptingState = false;
    private int [] outgoingConnection = new int[2];
    public State(){
        stateNum = 0;
        acceptingState = false;
        outgoingConnection[0] = 0;
        outgoingConnection[1] = 0;
    }
    public State(int stateNum, boolean acceptingState, int outgoingZeroSymbol, int outgoingOneSymbol){
        this.stateNum = stateNum;
        this.acceptingState = acceptingState;
        outgoingConnection[0] = outgoingZeroSymbol;
        outgoingConnection[1] = outgoingOneSymbol;
    }
    public void setState(int stateNum, boolean acceptingState, int outgoingZeroSymbol, int outgoingOneSymbol){
        this.stateNum = stateNum;
        this.acceptingState = acceptingState;
        outgoingConnection[0] = outgoingZeroSymbol;
        outgoingConnection[1] = outgoingOneSymbol;
    }
    public void setOutGoingZero (int num){outgoingConnection[0] = num;}
    public void setOutGoingOne  (int num){outgoingConnection[1] = num;}
    public void setAcceptingState(boolean bool){this.acceptingState = bool;}
    public int getStateNum(){return this.stateNum;}
    public boolean getAcceptingState(){return acceptingState;}
    public int getOutGoingZeroState(){return outgoingConnection[0];}
    public int getOutGoingOneState() {return outgoingConnection[1];}
    public void Print(){
        System.out.println("State ID: " + this.stateNum );
        System.out.println("Accepting Status: " + getAcceptingState());
        System.out.println("0 Connection: " + getOutGoingZeroState());
        System.out.println("1 Connection: " + getOutGoingOneState());
    }
}

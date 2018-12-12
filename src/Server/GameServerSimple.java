package Server;

import Client.Avatar;

import java.util.*;

public class GameServerSimple {
    private int available;
    private Grid gGrid;
    int size = 8;
    private Map<Integer, List<String>> positionMap;
    protected GameServerSimple(){
        available=1;
        gGrid = new Grid(size);
        gGrid.displayGrid();
        positionMap = new LinkedHashMap<>();
        for (int i = 0; i < size*size; i++) {
            positionMap.put(i, new ArrayList<String>());
        }
    }

    public GameServerSimple(int state){
        available=state;
    }

    public int connection(String avUsed, Integer position) {

        if(available==0)
            return available;
        List<String> user = positionMap.get(position);
        user.add(avUsed);
        List<String> test = positionMap.get(position);
        System.out.println(test);
        return available;

    }

    public void escape(Avatar avUsed, int position, String goTo) {

    }

    public int move(String avUsed, int position, String goTo) {
        List<String> src = positionMap.get(position);
        src.remove(avUsed);
        Integer x,y;
        x=position/8;
        y=position%8;
        Room r = gGrid.getRoom(x,y);
        Integer dest;
        switch (goTo) {
            case "N" : dest = r.getNorth().dest; break;
            case "W" : dest = r.getWest().dest; break;
            case "E" : dest = r.getEast().dest; break;
            case "S" : dest = r.getSouth().dest; break;
            default : dest = -1; break;
        }
        if(dest==-1)
            return -1;
        List<String> lDest = positionMap.get(dest);
        lDest.add(avUsed);
        return dest;

    }

    public void displayGameInfo() {

    }

    public int getPosition(Avatar av){
        return 0;
    }

    public static void main(String args[]) throws Exception {

    }
}

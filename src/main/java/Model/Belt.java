package model;

public class Belt extends Buffer {
    private Gift [] body;
    private int nextIn=0;
    private int nextOut=0;
    private int available;
    private String name;

    public Belt(int size, Clock c, String name){
        super(size,c,name,true);
    }

}

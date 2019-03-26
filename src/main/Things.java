package main;

public class Things {

    private String name;

    private Number length;
    private String unit;

    public Things(String name, Number length, String unit) {
        this.name = name;
        this.length = length;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getLength() {
        return length;
    }

    public void setLength(Number length) {
        this.length = length;
    }

    private boolean hasSameUnit(Object o) {
        return ((Things) o).unit.equals(this.unit);

    }

    public int compare(Object o) {
        if (!hasSameUnit(o) ) {
            return -2;
        }
        if(((Things)o).getLength().doubleValue() > this.getLength().doubleValue()) {
            return -1;
        } else if (((Things)o).getLength().doubleValue() > this.getLength().doubleValue()) {
            return 1;
        } else {
            System.out.println(((Things)o).getLength().doubleValue());
            return 0;
        }
    }
}

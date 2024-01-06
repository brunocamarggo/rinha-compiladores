package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;

public class Term {

    private String kind;
    private Location location;

    public Term() {
    }

    public Term(Location location) {

    }

    public Term(String kind, Location location) {
        this.kind = kind;
        this.location = location;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

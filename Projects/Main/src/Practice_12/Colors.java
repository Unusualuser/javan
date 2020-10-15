package Practice_12;

public enum Colors {
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    PINK("\u001B[95m"),
    BLACK("\u001B[30m"),
    YELLOW("\u001B[33m"),
    RED("\u001B[31m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


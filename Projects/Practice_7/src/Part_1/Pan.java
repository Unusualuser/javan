package Part_1;

public class Pan extends Dish {
    int volume;

    public Pan(int volume, String material, String type) {
        this.volume = volume;
        this.material = material;
        this.type = type;
    }

    public boolean cookSoup() {
        return this.volume > 30;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean breakability() {
        return false;
    }

    @Override
    public String toString() {
        return "Pan{" +
                "volume=" + volume +
                ", material='" + material + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

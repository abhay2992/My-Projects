
public class Plane {

    private Row rows[];

    public Plane() {
        rows = new Row[3];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row();
        }
    }

    public Row getRow(int row_no) {
        return rows[row_no];
    }
}

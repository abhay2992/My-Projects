
import java.util.Scanner;

public class Input {
    PassengerGroup passengers;
    Plane plane;

    public PassengerGroup getPassengerGroup() {
        return this.passengers;
    }

    public Input() {

        Scanner scan = new Scanner(System.in);
        int no_of_persons = scan.nextInt();

        passengers = new PassengerGroup(no_of_persons);

    }

    public int checkLeftRight(Plane plane, int row_no) {

        for (int i = 0; i < 2; i++) {
            if (!plane.getRow(row_no).left_seats[i]) {
                plane.getRow(row_no).left_seats[i] = true;

                return (i + 1);
            }
        }

        for (int i = 6; i < 8; i++) {
            if (plane.getRow(row_no).right_seats[i - 6] == false) {
                plane.getRow(row_no).right_seats[i - 6] = true;

                return (i + 6);
            }
        }

        for (int i = 2; i < 6; i++) {
            if (plane.getRow(row_no).middle_seats[i - 2] == false) {
                plane.getRow(row_no).middle_seats[i - 2] = true;

                return (i + 2);
            }
        }

        return 0;
    }
    
    public int checkLeftRightForTwo(Plane plane, int row_no) {
        {
            int i = 0;

            if ((plane.getRow(row_no).left_seats[i] == false) && (plane.getRow(row_no).left_seats[i + 1] == false)) {
                plane.getRow(row_no).left_seats[i] = true;
                plane.getRow(row_no).left_seats[i + 1] = true;

                return i;
            }
        }

        {
            int i = 6;
            if ((plane.getRow(row_no).right_seats[i - 6] == false) && (plane.getRow(row_no).right_seats[i - 6 + 1] == false)) {
                plane.getRow(row_no).right_seats[i - 6] = true;
                plane.getRow(row_no).right_seats[i - 6 + 1] = true;

                return i;
            }
        }

        {
            int i = 2;
            while (i < 5) {
                if ((plane.getRow(row_no).middle_seats[i - 2] == false) && (plane.getRow(row_no).middle_seats[i - 2 + 1] == false)) {
                    plane.getRow(row_no).middle_seats[i - 2] = true;
                    plane.getRow(row_no).middle_seats[i - 2 + 1] = true;

                    return i;
                }
            }
        }

        return 0;
    }

    public int checkLeftRightForMore(Plane plane, int row_no) {
        {
            int i = 2;

            if ((plane.getRow(row_no).middle_seats[i - 2] == false) && (plane.getRow(row_no).middle_seats[i - 2 + 1] == false) && (plane.getRow(row_no).middle_seats[i - 2 + 2] == false) && (plane.getRow(row_no).middle_seats[i - 2 + 3] == false)) {
                plane.getRow(row_no).middle_seats[i - 2] = true;
                plane.getRow(row_no).middle_seats[i - 2 + 1] = true;
                plane.getRow(row_no).middle_seats[i - 2 + 2] = true;
                plane.getRow(row_no).middle_seats[i - 2 + 3] = true;

                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Plane plane = new Plane();

        Airline air_india = new Airline();

        air_india.addPlane(plane);

        char seat[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        int seat_no = 0;

        while (true) {
            Input input = new Input();

            {
                for (int i = 0; i < 3; i++) {
                    if (input.getPassengerGroup().getNoOfPersons() == 1) {
                        if ((seat_no = input.checkLeftRight(plane, i)) != 0) {
                            System.out.println("\n" + (i + 1) + seat[seat_no - 1]);
                            break;
                        }
                    } else if (input.getPassengerGroup().getNoOfPersons() == 2) {
                        if ((seat_no = input.checkLeftRightForTwo(plane, i)) != 0) {
                            System.out.print("\n" + (i + 1) + seat[seat_no] + "," + (i + 1) + seat[seat_no + 1]);
                            break;
                        }
                    } else {
                        if ((seat_no = input.checkLeftRightForMore(plane, i)) != 0) {
                            System.out.print("\n" + (i + 1) + seat[seat_no - 1] + "," + (i + 1) + seat[seat_no + 1 - 1] + "," + (i + 1) + seat[seat_no + 2 - 1] + "," + (i + 1) + seat[seat_no + 3 - 1]);
                            break;
                        }
                    }

                }

            }
        }



    } 
    
}

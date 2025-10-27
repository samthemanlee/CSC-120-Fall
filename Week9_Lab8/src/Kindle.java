public class Kindle {

    private int currentPage;
    private int totalPages;

    public Kindle(int pages) {

        currentPage = 1;
        totalPages = pages;

    } // end of the constructor method

    public String toString() {

        return String.format("Page   %3d of  %3d.", currentPage, totalPages);

    } // end of the toString method

    public void turnPage() {

        turnPage(1);

    } // end of the overload turnPage method

    public void turnPage(int pagesToTurn) {

        int newPage = currentPage + pagesToTurn;

        if (newPage > totalPages || newPage == totalPages) {

            System.out.println("Turning " + pagesToTurn + " pages would take you past the last page.");
            currentPage = newPage;
            System.out.print("You are now on             : ");
            System.out.println(this);

        }
        else {

            currentPage = newPage;

        } // end of the if-else statement

    } // end of the turnPage method

} // end of the Kindle Class

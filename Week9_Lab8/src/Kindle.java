public class Kindle {

    private int currentPage;
    private int totalPages;

    public Kindle(int totalPages) {
        this.currentPage = 1;
        this.totalPages = totalPages;
    } // end of the constructor method

    public String toString() {
        return ("Page   " + currentPage + " of  " + totalPages + ".");
    } // end of the toString method

    public void turnPages() {
        turnPages(1);
    } // end of the overload version of the turnPages method

    public void turnPages(int pagesToTurn) {
        int newPage = currentPage + pagesToTurn;

        if (newPage > totalPages || newPage == totalPages) {
            currentPage = totalPages;
            System.out.println("Turning " + pagesToTurn + " pages would take you past the last page.");
            System.out.print("You are now on             : ");
            System.out.println(this);
        }
        else{
            currentPage = newPage;
        } // end of the if-else statements
    } // end of the turnPages method
} // end of the Kindle Class

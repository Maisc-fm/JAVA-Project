/**
 * Learning Module
 * Made by Nashrur Aisyha Hani binti Suphian @ Sharbini (102776) - Class component
 * This class stores learning content in multiple pages.
 * Each page can have text and an image.
 * Users can move between pages and view the content.
 * The class implements Displayable so it can work with the GUI.
 */
public class LearningModule implements Displayable {

    // Stores the text content for each page
    private List<String> pages;

    // Stores the image path for each page
    private List<String> images;

    // Keeps track of the page currently being viewed
    private int currentPage;

    //Default constructor.
    // Creates an empty learning module starting at page 0.
    public LearningModule() {
        this.pages = new ArrayList<>();
        this.images = new ArrayList<>();
        this.currentPage = 0;
    }

    // Constructor that receives pages and images when creating the object.
    public LearningModule(List<String> pages, List<String> images) {
        this.pages = new ArrayList<>(pages);
        this.images = new ArrayList<>(images);
        this.currentPage = 0;
    }

    // Shows the selected page if the page number is valid.
    @Override
    public void showPage(int index) {

        // Check whether the page exists
        if (index < 0 || index >= pages.size()) {
            System.out.println("Invalid page number.");
            return;
        }

        // Update current page
        currentPage = index;

        // Display page information
        System.out.println("--- Page " + (currentPage + 1) + " / " + pages.size() + " ---");
        System.out.println(pages.get(currentPage));
    }

    // Returns the total number of pages.
    @Override
    public int getTotalPages() {
        return pages.size();
    }

    // Returns the title of the learning module.
    @Override
    public String getTitle() {
        return "Learning Module";
    }

    // Returns the image path for the current page.
    @Override
    public String getImagePath() {

        // If no image exists, return an empty string
        if (images == null || currentPage >= images.size()) {
            return "";
        }

        return images.get(currentPage);
    }

    // Moves to the next page.
    public void nextPage() {

        // Make sure we are not already at the last page
        if (currentPage < pages.size() - 1) {
            currentPage++;
        } else {
            System.out.println("Already on the last page.");
        }
    }

    // Moves to the previous page.
    public void prevPage() {

        // Make sure we are not already at the first page
        if (currentPage > 0) {
            currentPage--;
        } else {
            System.out.println("Already on the first page.");
        }
    }

    // Returns all page contents.
    public List<String> getPages() {
        return pages;
    }

    // Updates the list of pages.
    public void setPages(List<String> pages) {
        this.pages = pages;
    }

    // Returns all image paths.
     public List<String> getImages() {
        return images;
    }

    //Updates the list of images.
    public void setImages(List<String> images) {
        this.images = images;
    }

    // Returns the current page number.
    public int getCurrentPage() {
        return currentPage;
    }

    // Sets the current page number.
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    // Adds a new page and its image to the module.
     
    public void addPage(String content, String imagePath) {
        pages.add(content);
        images.add(imagePath);
    }

    // Returns information about this learning module.
    // Useful for testing and debugging.
    @Override
    public String toString() {
        return "LearningModule{" +
                "totalPages=" + pages.size() +
                ", currentPage=" + currentPage +
                '}';
    }
}

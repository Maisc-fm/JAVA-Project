import java.util.ArrayList;
import java.util.List;

// Class: LearningModule
// Purpose: Stores and manages educational content related to SDG 4: Quality Education.
// This class contains:
// - 10 learning pages
// - 10 corresponding images
// - Navigation between pages
// Implements the Displayable interface.
// Created By: Nashrur Aisyha Hani binti Suphian @ Sharbini (102776)

public class LearningModule implements Displayable {

    // Stores learning page contents
    private List<String> pages;

    // Stores image paths for each page
    private List<String> images;

    // Keeps track of the current page being displayed
    private int currentPage;

    // Constructor
    // Initializes lists and loads SDG 4 content.
    public LearningModule() {
        pages = new ArrayList<>();
        images = new ArrayList<>();
        currentPage = 0;

        loadContent();
    }

    // Loads all educational content and image paths into their respective lists.
    private void loadContent() {

        // Page 1: Target 4.1
        pages.add("Target 4.1: Make sure all girls and boys can get free, fair and good-quality primary and secondary education that helps them learn useful knowledge and skills.");
        images.add("images/page1.png");

        // Page 2: Target 4.2
        pages.add("Target 4.2: Make sure all girls and boys can access quality early childhood care and preschool education so they are ready for primary school.");
        images.add("images/page2.png");

        // Page 3: Target 4.3
        pages.add("Target 4.3: Ensure all women and men have equal access to affordable, quality vocational, technical and university education.");
        images.add("images/page3.png");

        // Page 4: Target 4.4
        pages.add("Target 4.4: Increase the number of young people and adults with useful technical and vocational skills for jobs and starting businesses.");
        images.add("images/page4.png");

        // Page 5: Target 4.5
        pages.add("Target 4.5: Remove gender inequality in education and ensure vulnerable groups have equal access to education and vocational training.");
        images.add("images/page5.png");

        // Page 6: Target 4.6
        pages.add("Target 4.6: Ensure all young people and many adults, both men and women can read, write and do basic math.");
        images.add("images/page6.png");

        // Page 7: Target 4.7
        pages.add("Target 4.7: Help everyone learn how to live sustainably, respect others and contribute to a peaceful and inclusive society.");
        images.add("images/page7.png");

        // Page 8: Target 4.8
        pages.add("Target 4.8: Build and improve schools that are safe, inclusive and accessible for children, people with disabilities and all genders.");
        images.add("images/page8.png");

        // Page 9: Target 4.9
        pages.add("Target 4.9: Provide more scholarships to help students from developing countries access higher education and specialized training.");
        images.add("images/page9.png");

        // Page 10: Target 4.A
        pages.add("Target 4.A: Increase the number of qualified teachers through better training and international cooperation especially in developing countries..");
        images.add("images/page10.png");
    }

    // Displays a specific learning page.
    // @param index page number to display
    
    @Override
    public void showPage(int index) {

        // Check whether page index is valid
        if (index >= 0 && index < pages.size()) {

            currentPage = index;

            System.out.println("Page " + (currentPage + 1));
            System.out.println(pages.get(currentPage));
            System.out.println("Image: " + images.get(currentPage));

        } else {

            System.out.println("Invalid page number.");
        }
    }

    //Returns total number of learning pages.
    //@return total pages
    @Override
    public int getTotalPages() {
        return pages.size();
    }

    // Returns module title.
    // @return title of learning module
    @Override
    public String getTitle() {
        return "SDG 4: Quality Education";
    }

    // Returns image path for the current page.
    // @return image file path
    @Override
    public String getImagePath() {
        return images.get(currentPage);
    }

    // Returns content of the current page.
    // @return page content
    public String getPageContent() {
        return pages.get(currentPage);
    }

    // Returns content of a specified page.
    // @param index page number
    // @return page content
    public String getPageContent(int index) {

        if (index >= 0 && index < pages.size()) {
            return pages.get(index);
        }

        return "Invalid page.";
    }

    // Returns current page number.
    // @return current page index
    public int getCurrentPage() {
        return currentPage;
    }

    // Moves to the next page.
    // Does nothing if already on the last page.
    public void nextPage() {

        if (currentPage < pages.size() - 1) {
            currentPage++;
        }
    }

    // Moves to the previous page.
    // Does nothing if already on the first page.
    public void previousPage() {

        if (currentPage > 0) {
            currentPage--;
        }
    }
}

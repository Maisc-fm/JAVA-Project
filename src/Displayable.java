// Interface: Displayable
// Purpose: Defines the methods that any learning content class must implement in order to display educational pages and related images.
// Created By: Nashrur Aisyha Hani binti Suphian @ Sharbini (102776)
public interface Displayable {

    // Displays a specific learning page.
    // @param index the page number to display
    void showPage(int index);

    // Returns the total number of learning pages.
    // @return total number of pages
    int getTotalPages();

    // Returns the title of the learning module.
    // @return learning module title
    String getTitle();

    // Returns the image path associated with the current page.
    // @return image file path
    String getImagePath();
}

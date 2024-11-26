import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI {
    private final SortedList sortedList;
    private final JTextArea textArea;
    private final JTextField inputField;
    private final JButton addButton;
    private final JButton searchButton;

    public SortedListGUI() {
        sortedList = new SortedList();

        // Create main frame
        JFrame frame = new JFrame("Sorted List GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Text area to display list operations
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input panel with text field and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputField = new JTextField(20);
        addButton = new JButton("Add");
        searchButton = new JButton("Search");

        inputPanel.add(new JLabel("Input:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // Add listeners to buttons
        addButton.addActionListener(new AddButtonListener());
        searchButton.addActionListener(new SearchButtonListener());

        frame.setVisible(true);
    }

    // Listener for Add button
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText().trim();
            if (!input.isEmpty()) {
                sortedList.add(input);
                textArea.append("Added: " + input + "\n");
                textArea.append("List: " + sortedList + "\n\n");
                inputField.setText("");
            }
        }
    }

    // Listener for Search button
    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText().trim();
            if (!input.isEmpty()) {
                int result = sortedList.search(input);
                if (result >= 0) {
                    textArea.append("Found: " + input + " at index " + result + "\n\n");
                } else {
                    int insertionPoint = -(result + 1);
                    textArea.append("Not found: " + input + ". Would be at index " + insertionPoint + "\n\n");
                }
                inputField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortedListGUI::new);
    }
}

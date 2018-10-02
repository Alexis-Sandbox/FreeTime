package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.PersonPanelSelectionChangedEvent;
import seedu.address.model.person.TimeTable;

/**
 * TODO ALEXIS: currently morphing this from BrowserPanel into a TimeTablePanel.
 *
 * This is TimeTablePanel, it is a panel where the TimeTable elements reside in:
 * Contains these Classes: (where * represents any number of)
 *
 * TimeTablePanel
 *  |-PanelTop (just a divider in javafx )
 *  |   |-TimeTablePanelTimingGrid (invisible grid to hold the timing objects)
 *  |       |-*TimeTablePanelTimingMarker (visually the timing markers at the top of the grid; eg: 0900 or 1500)
 *  |
 *  |-PanelBottom (just a divider in javafx )
 *  |   |-TimeTablePanelMainGrid (visually the gridlines in the timetable)
 *  |       |---*TimeTablePanelTimeSlot
 *  |       |       (represents a timeSlot; visually a square inside the timetable, just like in NUSMODS)
 *  |       |---*TimeTablePanelDaySlot
 *  |               (represents a daySlot on the leftmost column of timetable; visually a square)
 *  |
 *  |-UI logic:  (handles logic such as: SCALING of grid, ADDING/REMOVAL of timeslots, HANDLING TIMESLOT INDEXES, etc)
 *
 *____________________
 */

public class TimeTablePanel extends UiPart<Region> {

    private static final String FXML = "TimeTablePanel.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private TimeTablePanelTimingGrid timeTablePanelTimingGrid;

    private TimeTablePanelMainGrid timeTablePanelMainGrid;

    @FXML
    private StackPane timeTablePanelTimingGridPlaceholder;

    @FXML
    private StackPane timeTablePanelMainGridPlaceholder;

    public TimeTablePanel() {
        super(FXML);

        // To prevent triggering events for typing inside the loaded Web page.
        getRoot().setOnKeyPressed(Event::consume);

        fillInnerParts();

        loadTimeTable(); // TODO ALEXIS: does nothing now
        registerAsAnEventHandler(this);
    }

    /**
     * Fills up all the placeholders of this TimeTablePanel.
     */
    void fillInnerParts() {
        //TODO ALEXIS
        timeTablePanelTimingGrid = new TimeTablePanelTimingGrid();
        timeTablePanelTimingGridPlaceholder.getChildren().add(timeTablePanelTimingGrid.getRoot());

        timeTablePanelMainGrid = new TimeTablePanelMainGrid();
        timeTablePanelMainGridPlaceholder.getChildren().add(timeTablePanelMainGrid.getRoot());
    }

    /** TODO ALEXIS:
     * Loads a TimeTable from the TimeTable object it is given.
     */
    private void loadTimeTable(TimeTable timeTable) {

    }

    /**
     * Loads empty TimeTable.
     */
    private void loadTimeTable() {

    }

    @Subscribe
    private void handlePersonPanelSelectionChangedEvent(PersonPanelSelectionChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        loadTimeTable(event.getNewSelection().getTimeTable());
    }
}

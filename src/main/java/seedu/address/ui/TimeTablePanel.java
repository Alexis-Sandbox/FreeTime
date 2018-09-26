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
 *  |       |---*TimeTablePanelTimeSlot (represents a timeSlot; visually a square inside the timetable, just like in NUSMODS)
 *  |       |---*TimeTablePanelDaySlot (represents a day marker on the leftmost column of timetable; visually a square that contains the day of the week)
 *  |
 *  |-UI logic:  (just to handle the logic of RENDERING/SCALING and ADDING/REMOVAL of timeslots and HANDLING TIMESLOT INDEXES, ETC)
 *
 *  
 *____________________
 */

public class TimeTablePanel extends UiPart<Region> {

    private static final String FXML = "TimeTablePanel.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    //TODO ALEXIS: time
    //private  TimeTablePanelTimingGrid timeTablePanelTimingGrid;

    private  TimeTablePanelMainGrid timeTablePanelMainGrid;

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
        //timingGrid = new TimeTablePanelTimingGrid();
        //timingGridPlaceholder.getChildren().add(timingGrid.getRoot());

        timeTablePanelMainGrid  = new TimeTablePanelMainGrid();
        timeTablePanelMainGridPlaceholder.getChildren().add(timeTablePanelMainGrid.getRoot());
    }


    /** TODO ALEXIS:
     * Loads a TimeTable visually from the TimeTable object it is given.
     */
    private void loadTimeTable(TimeTable timeTable) {

    }

    /**
     * Loads empty TimeTable.
     */
    private void loadTimeTable() {

    }

    //TODO ALEXIS: decide if this is necessary or not?
    public void freeResources(){

    }


    @Subscribe
    private void handlePersonPanelSelectionChangedEvent(PersonPanelSelectionChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        loadTimeTable(event.getNewSelection().getTimeTable());
    }
}

package fr.lusuva.lusuvair.dtos.apidto;

/**
 * The DebugDto class represents the data transfer object for debug information.
 * It includes the synchronization status as a string.
 */
public class DebugDto {

    private String sync;

    /**
     * Default constructor for DebugDto.
     */
    public DebugDto() {
        super();
    }

    /**
     * Parameterized constructor for DebugDto.
     *
     * @param sync the synchronization status
     */
    public DebugDto(String sync) {
        super();
        this.sync = sync;
    }

    /**
     * Gets the synchronization status.
     *
     * @return the synchronization status
     */
    public String getSync() {
        return sync;
    }

    /**
     * Sets the synchronization status.
     *
     * @param sync the synchronization status to set
     */
    public void setSync(String sync) {
        this.sync = sync;
    }
}

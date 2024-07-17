package fr.lusuva.lusuvair.dtos.apidto;

public class DebugDto {
	private String sync;

	/**
	 * 
	 */
	public DebugDto() {
		super();
	}

	/**
	 * @param sync
	 */
	public DebugDto(String sync) {
		super();
		this.sync = sync;
	}

	/**
	 * @return the sync
	 */
	public String getSync() {
		return sync;
	}

	/**
	 * @param sync the sync to set
	 */
	public void setSync(String sync) {
		this.sync = sync;
	}
}

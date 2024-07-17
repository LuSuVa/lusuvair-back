package fr.lusuva.lusuvair.dtos.apidto;

import java.util.List;

public class waqiDataDto {
	private String status;
	private DataDto dataDto;

	/**
	 * 
	 */
	public waqiDataDto() {
		super();
	}

	/**
	 * @param status
	 * @param dataDto
	 */
	public waqiDataDto(String status, DataDto dataDto) {
		super();
		this.status = status;
		this.dataDto = dataDto;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the dataDto
	 */
	public DataDto getDataDto() {
		return dataDto;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param dataDto the dataDto to set
	 */
	public void setDataDto(DataDto dataDto) {
		this.dataDto = dataDto;
	}

}

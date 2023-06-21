package com.lax.springjwt.models;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UploadImageVO implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte[] file;
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}



}

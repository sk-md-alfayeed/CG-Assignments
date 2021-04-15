package com.cg.casestudy.checkinmanagement.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "checkIns")
public class CheckIn {
	private String id;
	private String pnrNo;
	private String bookingId;
	private boolean status;

}

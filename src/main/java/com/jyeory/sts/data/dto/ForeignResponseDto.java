package com.jyeory.sts.data.dto;

import java.util.List;

import com.jyeory.sts.data.entity.ForeignTourist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ForeignResponseDto {
	private int totCnt;
	private boolean hasMore;
	private List<ForeignTourist> data;
}

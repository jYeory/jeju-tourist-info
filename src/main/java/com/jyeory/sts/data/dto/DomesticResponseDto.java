package com.jyeory.sts.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.jyeory.sts.data.entity.DomesticTourist;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DomesticResponseDto {
	private int totCnt;
	private boolean hasMore;
	private List<DomesticTourist> data;
}

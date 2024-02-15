package com.jyeory.sts.data.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.jyeory.sts.data.dto.DomesticResponseDto;
import com.jyeory.sts.data.dto.ForeignResponseDto;

@FeignClient(name="${feign.domestic.name}", url="${feign.domestic.url}")
public interface JejuDomesticTouristFeign {

	@GetMapping(value = "/{projectKey}", produces = MediaType.APPLICATION_JSON_VALUE)
	DomesticResponseDto getDomesticTouristInfo(
		@PathVariable(value="projectKey") String projectKey,
		@RequestParam(value="startDate") String startDate,
		@RequestParam(value="endDate") String endDate,
		@RequestParam(value="number") int number,
		@RequestParam(value="limit") int limit
	);
}

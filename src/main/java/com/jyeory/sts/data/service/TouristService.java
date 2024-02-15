package com.jyeory.sts.data.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyeory.sts.data.dto.DomesticResponseDto;
import com.jyeory.sts.data.dto.ForeignResponseDto;
import com.jyeory.sts.data.feign.JejuDomesticTouristFeign;
import com.jyeory.sts.data.feign.JejuForeignTouristFeign;
import com.jyeory.sts.data.repository.IDomesticTouristRepository;
import com.jyeory.sts.data.repository.IForeignTouristRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TouristService {

	private final IDomesticTouristRepository domesticRepsitory;
	private final IForeignTouristRepository foreignRepository;

	@Autowired
	private JejuDomesticTouristFeign domesticFeign;
	@Autowired
	private JejuForeignTouristFeign foreignFeign;

	public void run(String[] params) {
		String type = params[0];
		String projectKey = params[1];
		String startDt = params[2];
		String endDt = params[3];

		int pageNumber = 1;
		boolean hasMore = true;
		while (hasMore) {
			boolean hasNext = false;
			if (StringUtils.equals(type, "D")) {
				DomesticResponseDto result = domesticFeign.getDomesticTouristInfo(projectKey, startDt, endDt, pageNumber++, 100);
				// System.out.println(result);

				domesticRepsitory.saveAll(result.getData());
				hasNext = result.isHasMore();
			} else {
				ForeignResponseDto result = foreignFeign.getForeignTouristInfo(projectKey, startDt, endDt, pageNumber++, 100);
				foreignRepository.saveAll(result.getData());
				hasNext = result.isHasMore();
			}
			hasMore = hasNext;
		}

		System.exit(1);
	}

}

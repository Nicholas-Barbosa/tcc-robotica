package com.puc.tcc.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.service.AquariumMetricService;

@Named
@RequestScoped
public class AquariumLastMetricsController {

	private AquariumMetricService aqMetricService;
	private AquariumMetricDTO lastMetric;

	@Inject
	public AquariumLastMetricsController(AquariumMetricService aqMetricService) {
		super();
		this.aqMetricService = aqMetricService;
		this.lastMetric = new AquariumMetricDTO();
	}

	public void loadMetric() {
		lastMetric = aqMetricService.findLastMetric();
	}

	public AquariumMetricDTO getLastMetric() {
		return lastMetric;
	}

}

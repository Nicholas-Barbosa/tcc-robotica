package com.puc.tcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.service.AquariumMetricService;

@Named
@ViewScoped
public class AquariumMetricsController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2742246961385618181L;

	private AquariumMetricService aqMetricService;

	private AquariumMetricDTO lastMetric;

	private List<AquariumMetricDTO> metrics;

	@Inject
	public AquariumMetricsController(AquariumMetricService aqMetricService) {
		super();
		this.aqMetricService = aqMetricService;
		this.lastMetric = new AquariumMetricDTO();
	}

	public void findMetrics() {
		metrics = aqMetricService.findAllOrderByLastMetric();
		lastMetric = metrics.get(0);
	}

	public AquariumMetricDTO getLastMetric() {
		return lastMetric;
	}

	public List<AquariumMetricDTO> getMetrics() {
		return metrics;
	}
}

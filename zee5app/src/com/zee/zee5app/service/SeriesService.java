package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;


public class SeriesService {
	
	private SeriesRepository repository = SeriesRepository.getInstance();
	private static SeriesService service = null;		
	
	public static SeriesService getInstance() {
		if(service == null)
			service = new SeriesService();
		return service;
	}
	
	public String addSeries(Series series) {
		return this.repository.addSeries(series);
	}
	
	public Series getSeriesById(String id) {
		return this.repository.getSeriesById(id);
	}
	
	public Series[] getAllSeries() {
		return repository.getAllSeries();
	}


}
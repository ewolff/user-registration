package com.ewolff.user_registration.service;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;

@Component
public class GraphiteMetricsReporter {

	private Log log = LogFactory.getLog(GraphiteMetricsReporter.class);

	@Value("${graphite.enabled:false}")
	private boolean graphiteEnabled = false;
	
	@Value("${graphite.host:localhost}")
	private String graphiteHost = "";

	@Value("${graphite.port:2003}")
	private Integer graphitePort = 2003;

	@Autowired
	private MetricRegistry metricRegistry;

	@PostConstruct
	private void init() {
		if (graphiteEnabled) {
			log.info("Initializing Metrics Graphite reporting");
			Graphite graphite = new Graphite(new InetSocketAddress(
					graphiteHost, graphitePort));
			GraphiteReporter graphiteReporter = GraphiteReporter
					.forRegistry(metricRegistry)
					.convertRatesTo(TimeUnit.SECONDS)
					.convertDurationsTo(TimeUnit.MILLISECONDS).build(graphite);
			graphiteReporter.start(1, TimeUnit.MINUTES);
		}
	}

}

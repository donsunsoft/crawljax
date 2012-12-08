// Copyright 2010 Google Inc. All Rights Reserved.
package com.crawljax.core;

import static org.junit.Assert.assertEquals;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

import com.crawljax.core.configuration.CrawlSpecification;

/**
 * This test checks that all iframes are ignored using crawlspec call.
 * 
 */
public class DisableCrawlIFrameTest extends IFrameSuper {

	@Override
	protected CrawlSpecification getCrawlSpecification() {
		CrawlSpecification spec = super.getCrawlSpecification();
		spec.disableCrawlFrames();
		return spec;
	}

	@Test
	public void testIFramesNotCrawled() throws ConfigurationException, CrawljaxException {
		crawljax.run();
		assertEquals("Clickables", 3, crawljax.getSession().getStateFlowGraph().getAllEdges()
		        .size());
		assertEquals("States", 4, crawljax.getSession().getStateFlowGraph().getAllStates().size());
	}
}
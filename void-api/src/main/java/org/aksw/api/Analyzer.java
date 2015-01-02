package org.aksw.api;

import com.hp.hpl.jena.rdf.model.Model;

public interface Analyzer {
	public Model analyze(Model model);
}

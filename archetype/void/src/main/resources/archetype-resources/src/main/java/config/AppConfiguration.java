#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import java.util.Calendar;

import ${groupId}.api.Analyzer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;
import com.hp.hpl.jena.rdf.model.impl.StatementImpl;

@Configuration
@ComponentScan(basePackages = "${package}")
public class AppConfiguration {

	@Bean
	public Analyzer analyzer(){
		return new Analyzer(){

			

			@Override
			public Model analyze(Model model) {
				Resource subject = new ResourceImpl("http://example.org/resource/TestAnalyzer");
				Property predicate = new PropertyImpl("http://example.org/analyzedOn");
				RDFNode object = model.createTypedLiteral(Calendar.getInstance());
				model.add(new StatementImpl(subject, predicate,object));
				return model;
			}
			
		};
	}
}

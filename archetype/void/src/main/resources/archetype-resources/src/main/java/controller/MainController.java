#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${groupId}.api.Analyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hp.hpl.jena.rdf.model.Model;

@Controller
public class MainController {
	
	@Autowired
	private Analyzer analyzer;
	
	@RequestMapping(value="/")
	@ResponseBody
	public Model analyze(Model model){
		return analyzer.analyze(model);
	}
}

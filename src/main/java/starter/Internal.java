package starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/portal")
public class Internal {
	
	@RequestMapping(value="/analytics")
	public String getAnalyticsPortal(Model model){
		return "analytics";
	}

	@RequestMapping(value="/dashboard")
	public String getDashboard(Model model){
		return "realtime";
	}
}

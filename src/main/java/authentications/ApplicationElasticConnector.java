package authentications;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import org.springframework.stereotype.Service;


@Service
public class ApplicationElasticConnector {
	
	public JestClient getObject(){
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig
			       .Builder("https://18ukiru5:zf960i6msa23y0av@maple-4019879.us-east-1.bonsai.io")
			       .multiThreaded(true)
			       .build());
	   return factory.getObject();
	}

}

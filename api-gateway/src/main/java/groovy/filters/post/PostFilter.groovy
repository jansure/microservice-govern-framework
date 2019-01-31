package groovy.filters.pre;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import com.netflix.zuul.ZuulFilter;

class PreFilter extends ZuulFilter {
	public boolean shouldFilter() {
		return true;
	}
	
	public Object run() {
		System.out.println("========= POST  这一个是动态加载的过滤器,hahaha");
		return null;
	}

	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	public int filterOrder() {
		return 3;
	}
	
}
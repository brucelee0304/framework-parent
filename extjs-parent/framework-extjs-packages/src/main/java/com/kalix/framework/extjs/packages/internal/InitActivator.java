package com.kalix.framework.extjs.packages.internal;

import com.kalix.framework.core.api.osgi.KalixBundleActivator;
import com.kalix.framework.core.util.SystemUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class InitActivator extends KalixBundleActivator {
    private ServiceReference reference;
    private HttpService httpService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.startBundlePrintln(bundleContext);

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);

        if(deploy){
            httpService.registerResources(contextPath + "/Ext", "/min/packages", null);
        }
        else{
            httpService.registerResources(contextPath + "/Ext", "/packages", null);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.stopBundlePrintln(bundleContext);

        if (reference != null)
            bundleContext.ungetService(reference);

        if(httpService!=null){
            httpService.unregister(contextPath + "/Ext");
        }
    }
}

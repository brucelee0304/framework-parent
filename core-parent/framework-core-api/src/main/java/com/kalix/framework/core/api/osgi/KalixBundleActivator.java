package com.kalix.framework.core.api.osgi;

import com.kalix.framework.core.util.ConfigUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author chenyanxu
 */
public abstract class KalixBundleActivator implements BundleActivator {
    protected String contextPath;
    protected Boolean deploy;
    protected BundleContext bundleContext;

    public KalixBundleActivator() {
        contextPath = (String) ConfigUtil.getConfigProp("path", "ConfigWebContext");
        //if the deploy var is true
        //the child class will deploy the compress version code
        deploy = Boolean.valueOf((String)ConfigUtil.getConfigProp("deploy","ConfigWebContext"));

        if (contextPath.equals("/")) {
            contextPath = "";
        }
    }
}

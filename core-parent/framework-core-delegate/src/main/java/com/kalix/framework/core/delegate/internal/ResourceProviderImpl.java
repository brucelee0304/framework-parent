/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kalix.framework.core.delegate.internal;

import com.kalix.framework.core.delegate.ResourceProvider;
import org.osgi.framework.Bundle;

import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ResourceProviderImpl implements ResourceProvider {
    private Bundle bundle;
    private Set<String> resources;
    private Collection<URL> allResources;

    public ResourceProviderImpl(Bundle bundle, Set<String> resources) {

        this.bundle = bundle;
        this.resources = resources;
    }

    @Override
    public URL loadResource(String name) {
        if (resources.contains(name)) {
            return bundle.getResource(name);
        }
        return null;
    }

    @Override
    public Collection<URL> listResources() {
        if (allResources == null) {
            loadAllResources();
        }
        return new HashSet<URL>(allResources);
    }

    private void loadAllResources() {
        allResources = new HashSet<URL>();
        for (String s : resources) {
            URL resource = bundle.getResource(s);
            allResources.add(resource);
        }
    }

}

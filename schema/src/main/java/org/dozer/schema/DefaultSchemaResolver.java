/*
 * Copyright 2005-2017 Dozer Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dozer.schema;

import java.net.URL;

import org.dozer.schema.osgi.Activator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSchemaResolver implements SchemaResolver {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSchemaResolver.class);

    public URL get(String fileName) {
        LOG.debug("Trying {} class loader for schema/{}", getClass().getCanonicalName(), fileName);

        URL answer = getClass().getClassLoader().getResource("schema/" + fileName);
        if (answer == null) {
            LOG.debug("Trying OSGi bundle context for schema/{}", fileName);

            BundleContext context = Activator.getBundleContext();
            if (context != null) {
                answer = context.getBundle().getResource("schema/" + fileName);
            }
        }

        return answer;
    }
}

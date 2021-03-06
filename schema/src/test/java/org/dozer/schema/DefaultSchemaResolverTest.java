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

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DefaultSchemaResolverTest {

    @Test
    public void canGetBeanMappingWithoutHypon() {
        SchemaResolver resolver = new DefaultSchemaResolver();
        assertNotNull(resolver.get("beanmapping.xsd"));
    }

    @Test
    public void canGetBeanMappingWithHypon() {
        SchemaResolver resolver = new DefaultSchemaResolver();
        assertNotNull(resolver.get("bean-mapping.xsd"));
    }

    @Test
    public void canGetBeanMappingv6() {
        SchemaResolver resolver = new DefaultSchemaResolver();
        assertNotNull(resolver.get("bean-mapping-6.0.0.xsd"));
    }

    @Test
    public void failsGetBeanMapping() {
        SchemaResolver resolver = new DefaultSchemaResolver();
        assertNull(resolver.get("doesnt-exist.xsd"));
    }
}

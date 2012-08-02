/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.ws.rs.container;

import javax.ws.rs.core.Configurable;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.WriterInterceptor;

/**
 * A JAX-RS provider for dynamic registration of <i>post-matching</i> providers
 * during a JAX-RS application setup at deployment time.
 *
 * Dynamic feature provider is used by JAX-RS runtime to register providers
 * that shall be applied to a particular resource class and method and
 * overrides any annotation-based binding definitions defined on the returned
 * resource filter or interceptor instance.
 * <p>
 * Providers implementing this interface MAY be annotated with
 * {@link javax.ws.rs.ext.Provider &#64;Provider} annotation in order to be
 * discovered by JAX-RS runtime when scanning for resources and providers.
 * This provider types is supported only as part of the Server API.
 * </p>
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @author Marek Potociar
 * @see javax.ws.rs.NameBinding
 * @since 2.0
 */
public interface DynamicFeature {

    /**
     * A callback method called by the JAX-RS runtime during the application
     * deployment to register provider instances or classes in a
     * {@link Configurable configurable} scope of a particular (sub)resource method;
     * i.e. the providers that should be dynamically bound to the (sub)resource method.
     * <p>
     * The registered provider instances or classes are expected to be implementing one
     * or more of the following interfaces:
     * </p>
     * <ul>
     * <li>{@link ContainerRequestFilter}</li>
     * <li>{@link ContainerResponseFilter}</li>
     * <li>{@link ReaderInterceptor}</li>
     * <li>{@link WriterInterceptor}</li>
     * </ul>
     * <p>
     * A provider instance or class that does not implement any of the interfaces
     * above may be ignored by the JAX-RS implementation. In such case a
     * {@link java.util.logging.Level#WARNING warning} message must be logged.
     * JAX-RS implementations may support additional extension interfaces that
     * can be registered using a dynamic feature concept.
     * </p>
     * <p>
     * Conceptually, this callback method is called during a (sub)resource method
     * discovery phase (typically once per each discovered (sub)resource method) to
     * register provider instances or classes in a {@code configurable} scope of
     * a particular (sub)resource method identified by the supplied
     * {@link ResourceInfo resource information}.
     * The responsibility of the feature is to properly update the supplied {@code configurable}
     * context.
     * </p>
     *
     * @param resourceInfo resource class and method information.
     * @param configurable a (sub)resource method-level configurable context associated
     *                     with the {@code resourceInfo} in which the feature should be
     *                     enabled.
     */
    public void configure(ResourceInfo resourceInfo, Configurable configurable);
}
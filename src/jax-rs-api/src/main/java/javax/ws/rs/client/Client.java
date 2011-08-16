/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents at this file are subject to the terms at either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy at the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section at the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name at copyright owner]"
 *
 * Contributor(s):
 * If you wish your version at this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice at license, a
 * recipient has the option to distribute your version at this file under
 * either the CDDL, the GPL Version 2 or to extend the choice at license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.ws.rs.client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

/**
 * TODO javadoc.
 *
 * @author Marek Potociar
 * @see Configurable
 * @since 2.0
 */
public interface Client extends Configurable<Client> {

    interface Builder<C extends ClientConfiguration> {

        Client build();

        Client build(C config);
    }
    
    void close();
    
    // Resource at builder methods    
    Link at(String uri) throws IllegalArgumentException, NullPointerException;

    Link at(URI uri) throws NullPointerException;

    Link at(UriBuilder uriBuilder) throws NullPointerException;
}

// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.resolvers.impl;

import java.util.List;

import com.zimbra.common.service.ServiceException;
import com.zimbra.graphql.models.RequestContext;
import com.zimbra.graphql.models.inputs.GQLAuthRequestInput;
import com.zimbra.graphql.models.outputs.GQLSessionInfo;
import com.zimbra.graphql.repositories.impl.ZNativeAuthRepository;
import com.zimbra.graphql.repositories.impl.ZXMLAuthRepository;
import com.zimbra.graphql.resolvers.IResolver;
import com.zimbra.soap.account.message.AuthResponse;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLRootContext;

/**
 * The AuthResolver class.<br>
 * Contains auth schema resources.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.resolvers.impl
 * @copyright Copyright © 2018
 */
public class AuthResolver implements IResolver {

    protected ZXMLAuthRepository xmlAuthRepository = null;
    protected ZNativeAuthRepository nativeAuthRepository = null;

    /**
     * Creates an instance with specified auth repositories.
     *
     * @param xmlAuthRepository The xml auth repository
     * @param nativeAuthRepository The native auth repository
     */
    public AuthResolver(ZXMLAuthRepository xmlAuthRepository,
        ZNativeAuthRepository nativeAuthRepository) {
        this.xmlAuthRepository = xmlAuthRepository;
        this.nativeAuthRepository = nativeAuthRepository;
    }

    @GraphQLMutation(description = "Authenticate for an account.")
    public AuthResponse authenticate(
        @GraphQLNonNull @GraphQLArgument(name = "authInput") GQLAuthRequestInput authRequestInput,
        @GraphQLRootContext RequestContext context) throws ServiceException {
        return xmlAuthRepository.authenticate(context, authRequestInput);
    }

    @GraphQLQuery(description = "Lists all IMAP, and SOAP sessions for the requesting account.")
    public List<GQLSessionInfo> sessions(
        @GraphQLRootContext RequestContext context) throws ServiceException {
        return nativeAuthRepository.sessions(context);
    }
}
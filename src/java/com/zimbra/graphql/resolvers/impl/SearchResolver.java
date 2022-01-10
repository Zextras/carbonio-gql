// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.resolvers.impl;


import com.zimbra.common.gql.GqlConstants;
import com.zimbra.common.service.ServiceException;
import com.zimbra.graphql.models.RequestContext;
import com.zimbra.graphql.models.inputs.GQLGALSearchRequestInput;
import com.zimbra.graphql.models.inputs.GQLSearchBy;
import com.zimbra.graphql.models.inputs.GQLSearchRequestInput;
import com.zimbra.graphql.models.outputs.GQLAutoCompleteResponse;
import com.zimbra.graphql.models.outputs.GQLConversationSearchResponse;
import com.zimbra.graphql.models.outputs.GQLMessageSearchResponse;
import com.zimbra.graphql.repositories.impl.ZXMLSearchRepository;
import com.zimbra.soap.account.message.SearchGalResponse;
import com.zimbra.graphql.resolvers.IResolver;
import com.zimbra.soap.type.GalSearchType;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLRootContext;

/**
 * The SearchResolver class.<br>
 * Contains search schema resources.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.resolvers.impl
 * @copyright Copyright © 2018
 */
public class SearchResolver implements IResolver {

    protected ZXMLSearchRepository searchRepository = null;

    /**
     * Creates an instance with specified search repository.
     *
     * @param searchRepository The search repository
     */
    public SearchResolver(ZXMLSearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @GraphQLQuery(description = "Search for messages with the given properties.")
    public GQLMessageSearchResponse messageSearch(
        @GraphQLNonNull @GraphQLArgument(name=GqlConstants.SEARCH_PARAMS, description="Input parameters for the search") GQLSearchRequestInput searchInput,
        @GraphQLRootContext RequestContext context) throws ServiceException {
        return searchRepository.messageSearch(context, searchInput);
    }

    @GraphQLQuery(description = "Search for conversations with the given properties.")
    public GQLConversationSearchResponse conversationSearch(
        @GraphQLNonNull @GraphQLArgument(name=GqlConstants.SEARCH_PARAMS, description="Input parameters for the search") GQLSearchRequestInput searchInput,
        @GraphQLRootContext RequestContext context) throws ServiceException {
        return searchRepository.conversationSearch(context, searchInput);
    }

    @GraphQLQuery(description = "Search for auto-complete matches.")
    public GQLAutoCompleteResponse autoComplete(
        @GraphQLNonNull @GraphQLArgument(name=GqlConstants.NAME, description="Name") String name,
        @GraphQLArgument(name=GqlConstants.TYPE, description="Type of addresses to auto-complete on") GalSearchType type,
        @GraphQLArgument(name=GqlConstants.INCLUDE_IS_EXPANDABLE, description="Denotes whether to include `isExpandable` flag for group entries", defaultValue="false") Boolean includeIsExpandable,
        @GraphQLArgument(name=GqlConstants.FOLDERS, description="Comma-separated list of folder ids") String folders,
        @GraphQLArgument(name=GqlConstants.INCLUDE_GAL, description="Denotes whether to search the global address list") Boolean includeGal,
        @GraphQLRootContext RequestContext rctxt) throws ServiceException {
        return searchRepository.autoComplete(rctxt, name, type, includeIsExpandable, folders, includeGal);
    }

    @GraphQLQuery(description = "Search GAL based on input parameters.")
    public SearchGalResponse galSearch(
        @GraphQLNonNull @GraphQLArgument(name = GqlConstants.SEARCH_BY, description="Search GAL by REF or Query") GQLSearchBy searchBy,
        @GraphQLNonNull @GraphQLArgument(name = GqlConstants.VALUE, description="Value of query or ref") String value,
        @GraphQLArgument(name=GqlConstants.SEARCH_PARAMS, description="Input parameters for gal search") GQLGALSearchRequestInput searchInput,
        @GraphQLRootContext RequestContext context) throws ServiceException {
        return searchRepository.galSearch(context, searchBy, value, searchInput);
    }

}

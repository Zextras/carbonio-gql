// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.outputs;

import java.util.List;

import com.zimbra.common.gql.GqlConstants;
import com.zimbra.soap.mail.type.AutoCompleteMatch;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLAutoCompleteResponse class.<br>
 * Contains auto-complete response information.
 * @see com.zimbra.soap.mail.message.AutoCompleteResponse
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models.outputs
 * @copyright Copyright © 2018
 */
@GraphQLType(name=GqlConstants.CLASS_AUTO_COMPLETE_RESPONSE, description="Contains auto-complete response information")
public class GQLAutoCompleteResponse {

    protected Boolean isCacheable;
    protected List<AutoCompleteMatch> matches;

    @GraphQLQuery(name=GqlConstants.IS_CACHEABLE, description="Denotes whether this response can be cached")
    public Boolean getIsCacheable() {
        return isCacheable;
    }

    public void setIsCacheable(Boolean isCacheable) {
        this.isCacheable = isCacheable;
    }

    @GraphQLQuery(name=GqlConstants.MATCHES, description="List of matches")
    public List<AutoCompleteMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<AutoCompleteMatch> matches) {
        this.matches = matches;
    }

}

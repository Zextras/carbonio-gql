// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.outputs;

import java.util.Collections;
import java.util.List;

import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLWhiteBlackListResponse class.<br>
 * Contains white and black list response information.
 * @see com.zimbra.soap.account.message.GetWhiteBlackListResponse
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models.outputs
 * @copyright Copyright © 2018
 */
@GraphQLType(name=GqlConstants.CLASS_WHITE_BLACK_LIST_RESPONSE, description="Contains entries for white and black lists")
public class GQLWhiteBlackListResponse {

    protected List<String> whiteListEntries = Collections.emptyList();
    protected List<String> blackListEntries = Collections.emptyList();

    @GraphQLQuery(name=GqlConstants.WHITE_LIST_ENTRIES, description="Whitelisted addresses")
    public List<String> getWhiteListEntries() {
        return whiteListEntries;
    }

    public void setWhiteListEntries(List<String> whiteListEntries) {
        this.whiteListEntries = whiteListEntries;
    }

    @GraphQLQuery(name=GqlConstants.BLACK_LIST_ENTRIES, description="Blacklisted addresses")
    public List<String> getBlackListEntries() {
        return blackListEntries;
    }

    public void setBlackListEntries(List<String> blackListEntries) {
        this.blackListEntries = blackListEntries;
    }

}

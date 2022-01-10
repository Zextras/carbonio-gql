// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.outputs;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterables;
import com.zimbra.common.gql.GqlConstants;
import com.zimbra.soap.mail.type.MessageHitInfo;
import com.zimbra.soap.type.SearchHit;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLMessageSearchResponse class.<br>
 * Contains search response data for a message search.
 * @see com.zimbra.soap.mail.message.SearchResponse
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models.inputs
 * @copyright Copyright © 2018
 */
@GraphQLType(name = GqlConstants.CLASS_MESSAGE_SEARCH_RESPONSE, description = "Search response data for a message search")
public class GQLMessageSearchResponse extends GQLSearchResponse {

    @Override
    public void setSearchHits(Iterable<SearchHit> setHits) {
        this.searchHits.clear();
        if (setHits != null) {
            Iterables.addAll(this.searchHits, setHits);
        }
    }

    public GQLMessageSearchResponse addSearchHit(MessageHitInfo searchHit) {
        this.searchHits.add(searchHit);
        return this;
    }

    @Override
    @GraphQLQuery(name=GqlConstants.SEARCH_HITS, description="Search hits for messages")
    public List<MessageHitInfo> getSearchHits() {
        final List<MessageHitInfo> hits = new ArrayList<MessageHitInfo>();
        for (final SearchHit hit : searchHits) {
            if (hit instanceof MessageHitInfo) {
                hits.add((MessageHitInfo) hit);
            }
        }
        return hits;
    }

}

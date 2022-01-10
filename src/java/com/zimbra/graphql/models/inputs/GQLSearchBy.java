// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.inputs;

import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLSearchBy input class.<br>
 * Contains parameters which decide how search will be done.
 *
 */
@GraphQLType(name = GqlConstants.CLASS_SEARCH_BY, description = "Search by REF or Query")
public enum GQLSearchBy {

    @GraphQLEnumValue(description = "search entry by REF") REF,
    @GraphQLEnumValue(description = "search by query") QUERY;

}

// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.inputs;

import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLOwnerSelector input class.<br>
 * Contains how the owner is identified.
 *
 */
@GraphQLType(name = GqlConstants.CLASS_OWNER_SELECTOR, description = "select owner by id or email address")
public enum GQLOwnerSelector {

    @GraphQLEnumValue(description = "zimbra Id of account") ID,
    @GraphQLEnumValue(description = "email address of account") EMAIL;

}

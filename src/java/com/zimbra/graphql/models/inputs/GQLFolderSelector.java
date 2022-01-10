// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.inputs;

import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLFolderSelector input class.<br>
 * Contains how the folder is identified.
 *
 */
@GraphQLType(name = GqlConstants.CLASS_FOLDER_SELECTOR, description = "select folder by id or path")
public enum GQLFolderSelector {

    @GraphQLEnumValue(description = "folder id") ID,
    @GraphQLEnumValue(description = "folder path") PATH;

}

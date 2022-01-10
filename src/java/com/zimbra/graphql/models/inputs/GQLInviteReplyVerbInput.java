// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.inputs;
import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLInviteReplyVerbInput enum.<br>
 * Contains verbs for calendar invite reply.
 * @see com.zimbra.soap.mail.message.SendInviteReplyRequest
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models.inputs
 * @copyright Copyright © 2018
 */
@GraphQLType(name=GqlConstants.CLASS_INVITE_REPLY_VERB_INPUT, description="Verbs for send invite reply.")
public enum GQLInviteReplyVerbInput {
    @GraphQLEnumValue(description="Accept reply") ACCEPT,
    @GraphQLEnumValue(description="Decline reply") DECLINE,
    @GraphQLEnumValue(description="Tentative reply") TENTATIVE
}

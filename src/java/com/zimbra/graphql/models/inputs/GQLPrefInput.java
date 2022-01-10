// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.inputs;
import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLPrefInput class.<br>
 * Contains prefs which are to be modified.
 * @see com.zimbra.soap.account.message.Pref
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models.inputs
 * @copyright Copyright © 2018
 */
@GraphQLType(name=GqlConstants.CLASS_ACCOUNT_PREF_INPUT, description="Input for prefs.")
public class GQLPrefInput {

    protected String name;
    protected String value;

    public String getName() {
        return name;
    }

    @GraphQLInputField(name=GqlConstants.NAME, description="The preference name to set")
    public void setName(@GraphQLNonNull String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    @GraphQLInputField(name=GqlConstants.VALUE, description="The preference value to set")
    public void setValue(@GraphQLNonNull String value) {
        this.value = value;
    }
}

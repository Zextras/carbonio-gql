// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.utilities;

/**
 * The GQLConstants class.<br>
 * Contains general service constants.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.utilities
 * @copyright Copyright © 2018
 */
public enum GQLConstants {

    /**
     * Service name.
     */
    API_NAME("zm-gql"),

    /**
     * Default encoding to use.
     */
    ENCODING("utf-8"),

    /**
     * Service path.
     */
    DEFAULT_SERVER_PATH("/graphql"),

    /**
     * TODO: see schema wiring
     */
    LC_REPOSITORY_CLASS_PREFIX("");

    /**
     * Enum value.
     */
    private String value;

    /**
     * @param value The value to set
     */
    GQLConstants(String value) {
        this.value = value;
    }

    /**
     * @return The value of this instance
     */
    public String getValue() {
        return value;
    }

}

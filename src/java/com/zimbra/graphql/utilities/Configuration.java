// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.utilities;

import org.apache.commons.lang.StringUtils;

import com.zimbra.common.localconfig.LC;
import com.zimbra.common.util.ZimbraLog;

/**
 * The Configuration class.<br>
 * Configuration wrapper for LC.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.utilities
 * @copyright Copyright © 2018
 */
public class Configuration {

    public Configuration() {

    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        return StringUtils.defaultIfEmpty(LC.get(key), defaultValue);
    }

    public Integer getInt(String key, Integer defaultValue) {
        final String stringValue = LC.get(key);
        Integer value = defaultValue;
        if (stringValue != null) {
            try {
                value = Integer.parseInt(stringValue);
            } catch (final NumberFormatException e) {
                ZimbraLog.extensions.debug("Cannot parse integer from configured LC value for key: '" + key + "'.");
            }
        }
        return value;
    }
}

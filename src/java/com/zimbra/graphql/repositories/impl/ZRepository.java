// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.repositories.impl;

import com.zimbra.common.util.ZimbraLog;

/**
 * The ZRepository class.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.repositories.impl
 * @copyright Copyright © 2018
 */
public abstract class ZRepository {

    public  ZRepository() {
        ZimbraLog.extensions.info("Loading %s . . .", this.getClass().getName());
    }

}

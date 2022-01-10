// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.resources;

import com.zimbra.common.service.ServiceException;
import com.zimbra.common.util.ZimbraLog;
import com.zimbra.cs.extension.ExtensionDispatcherServlet;
import com.zimbra.cs.extension.ExtensionException;
import com.zimbra.cs.extension.ZimbraExtension;
import com.zimbra.graphql.utilities.GQLConstants;

/**
 * GQLExtension class.<br>
 * Extends the ZimbraExtension class.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.resources
 * @copyright Copyright © 2018
 */
public class GQLExtension implements ZimbraExtension {

    @Override
    public void destroy() {
        ExtensionDispatcherServlet.unregister(this);
    }

    @Override
    public String getName() {
        return GQLConstants.API_NAME.getValue();
    }

    @Override
    public void init() throws ExtensionException, ServiceException {
        ZimbraLog.extensions.info("Registering %s", getName());
        ExtensionDispatcherServlet.register(this, new GQLServlet());
    }

}

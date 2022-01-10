// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.utilities;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.QName;

import com.zimbra.common.util.ZimbraLog;
import com.zimbra.soap.DocumentHandler;

public class HandlerManager {
    private static Map<QName, DocumentHandler> handlers = new HashMap<QName, DocumentHandler>();

    public static void registerHandler(QName qName, DocumentHandler handler) {
        StringBuilder sb = new StringBuilder();
        sb.append("Registering handle for ").append(qName.getName())
            .append(" with ").append(handler.getClass().getName());
        ZimbraLog.gql.debug(sb.toString());
        handlers.put(qName, handler);
    }

    public static DocumentHandler getHandler(QName qName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Getting handler for ").append(qName.getName());
        ZimbraLog.gql.debug(sb.toString());
        DocumentHandler handler = handlers.get(qName);
        sb = new StringBuilder();
        if (handler == null) {
            sb.append("Handler not found for ").append(qName.getName());
        } else {
            sb.append("Found handler for ").append(qName.getName()).append(" : ")
                .append(handler.getClass().getName());
        }
        ZimbraLog.gql.debug(sb.toString());
        return handler;
    }
}

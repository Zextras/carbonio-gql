// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.outputs;

import com.zimbra.common.gql.GqlConstants;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLSessionInfo class.<br>
 * Contains session response information.
 * @see com.zimbra.cs.session.Session
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models.outputs
 * @copyright Copyright © 2018
 */
@GraphQLType(name=GqlConstants.CLASS_SESSION_INFO, description="Session information")
public class GQLSessionInfo {
    protected String sessionId;
    protected String browserInfo;
    protected Long createdDate;
    protected Long lastAccessed;
    protected String userAgent;
    protected String requestIPAddress;

    @GraphQLQuery(name=GqlConstants.SESSION_ID, description="The session id")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @GraphQLQuery(name=GqlConstants.BROWSER_INFO, description="The browser information at session creation")
    public String getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    @GraphQLQuery(name=GqlConstants.CREATED_DATE, description="The date of session creation")
    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @GraphQLQuery(name=GqlConstants.LAST_ACCESSED, description="The last time the session was accessed")
    public Long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(Long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    @GraphQLQuery(name=GqlConstants.USER_AGENT, description="The user-agent at session creation")
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @GraphQLQuery(name=GqlConstants.REQUEST_IP_ADDRESS, description="The request IP at session creation")
    public String getRequestIPAddress() {
        return requestIPAddress;
    }

    public void setRequestIPAddress(String requestIPAddress) {
        this.requestIPAddress = requestIPAddress;
    }

}

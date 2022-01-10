// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.leangen.graphql.annotations.GraphQLQuery;

/**
 * The RequestContext class.<br>
 * Contains request context info.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.models
 * @copyright Copyright © 2018
 */
public class RequestContext {

    /**
     * Raw http request.
     */
    protected HttpServletRequest rawRequest;

    /**
     * Raw http response.
     */
    protected HttpServletResponse rawResponse;

    @GraphQLQuery(name = "rawRequest", description = "The raw http request.")
    public HttpServletRequest getRawRequest() {
        return rawRequest;
    }

    /**
     * @param rawRequest The raw http request to set
     */
    public void setRawRequest(HttpServletRequest rawRequest) {
        this.rawRequest = rawRequest;
    }

    @GraphQLQuery(name = "rawResponse", description = "The raw http response.")
    public HttpServletResponse getRawResponse() {
        return rawResponse;
    }

    /**
     * @param rawResponse The raw http response to set
     */
    public void setRawResponse(HttpServletResponse rawResponse) {
        this.rawResponse = rawResponse;
    }

}

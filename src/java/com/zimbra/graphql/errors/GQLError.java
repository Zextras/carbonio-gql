// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.errors;

import java.io.IOException;
import java.util.List;

import com.zimbra.common.service.ServiceException;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

/**
 * The GQLError class.<br>
 * GraphQLError Wrapper for exceptions.<br>
 * Used to generate errors to spec from exceptions not handled
 * by query execution.
 *
 * @author Zimbra API Team
 * @package com.zimbra.graphql.errors
 * @copyright Copyright © 2018
 */
public class GQLError implements GraphQLError {

    /**
     * The error message for this error response.
     */
    protected String message = "";

    /**
     * The exception associated with this error.
     */
    protected Exception exception;

    /**
     * Generates the message.
     *
     * @param e The exception associated with this error
     */
    public GQLError(Exception e) {
        this.exception = e;
        if (e instanceof ServiceException) {
            this.message += ((ServiceException) e).getCode() + " : ";
        }
        this.message += e.getMessage();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        if (exception instanceof IOException) {
            return ErrorType.InvalidSyntax;
        }
        return ErrorType.ValidationError;
    }

}

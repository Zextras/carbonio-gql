// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.repositories.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.zimbra.common.soap.Element;
import com.zimbra.cs.service.account.Auth;
import com.zimbra.graphql.models.RequestContext;
import com.zimbra.graphql.models.inputs.GQLAuthRequestInput;
import com.zimbra.graphql.utilities.GQLAuthUtilities;
import com.zimbra.graphql.utilities.XMLDocumentUtilities;
import com.zimbra.soap.ZimbraSoapContext;


/**
 * Test class for {@link ZXMLAuthRepository}.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({GQLAuthUtilities.class, XMLDocumentUtilities.class, ZimbraSoapContext.class})
public class ZXMLAuthRepositoryTest {

    /**
     * Mock soap context for testing.
     */
    protected ZimbraSoapContext mockZsc;

    /**
     * Mock request element for testing.
     */
    protected Element mockRequest;

    /**
     * Mock response element for testing.
     */
    protected Element mockResponse;

    /**
     * Mock request context for testing.
     */
    protected RequestContext rctxt;

    /**
     * Setup for tests.
     *
     * @throws Exception If there are issues mocking
     */
    @Before
    public void setUp() throws Exception {
        mockZsc = EasyMock.createMock(ZimbraSoapContext.class);
        mockRequest = EasyMock.createMock(Element.class);
        mockResponse = EasyMock.createMock(Element.class);
        rctxt = EasyMock.createMock(RequestContext.class);

        PowerMock.mockStaticPartial(GQLAuthUtilities.class, "getZimbraSoapContext");
        PowerMock.mockStaticPartial(XMLDocumentUtilities.class,
            "executeDocument", "executeDocumentAsGuest", "fromElement", "toElement");
    }


    /**
     * Test method for {@link ZXMLAuthRepository#authenticate}<br>
     * Validates that the authenticate request is executed as a guest with no zsc.
     *
     * @throws Exception If there are issues testing
     */
    @Test
    public void testAuthenticate() throws Exception {
        final ZXMLAuthRepository repository = PowerMock
            .createPartialMockForAllMethodsExcept(ZXMLAuthRepository.class, "authenticate");

        // expect to unmarshall a request
        XMLDocumentUtilities.toElement(anyObject());
        PowerMock.expectLastCall().andReturn(mockRequest);
        // expect to execute an element on the Auth document handler as a guest
        expect(XMLDocumentUtilities
                .executeDocumentAsGuest(anyObject(Auth.class), eq(mockRequest), eq(rctxt)))
            .andReturn(null);

        PowerMock.replay(GQLAuthUtilities.class);
        PowerMock.replay(XMLDocumentUtilities.class);

        repository.authenticate(rctxt, new GQLAuthRequestInput());

        PowerMock.verify(GQLAuthUtilities.class);
        PowerMock.verify(XMLDocumentUtilities.class);
    }

}

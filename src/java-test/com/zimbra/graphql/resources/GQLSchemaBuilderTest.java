// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.resources;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


/**
 * Test class for {@link GQLSchemaBuilder}.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({GQLSchemaBuilder.class})
public class GQLSchemaBuilderTest {

    /**
     * Test method for {@link GQLSchemaBuilder#newInstance}<br>
     * Validates that at least the standard schema builder is loaded.
     *
     * @throws Exception If there are issues testing
     */
    @Test
    public void testNewInstanceStandard() throws Exception {
        PowerMock.mockStaticPartial(
            GQLSchemaBuilder.class, "loadBuilder");

        GQLSchemaBuilder.loadBuilder();
        PowerMock.expectLastCall().andReturn(null);

        PowerMock.replay(GQLSchemaBuilder.class);

        final GQLSchemaBuilder builder = GQLSchemaBuilder.newInstance();
        assertNotNull(builder);

        PowerMock.verify(GQLSchemaBuilder.class);
    }

}

// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.graphql.models.inputs;

import com.zimbra.common.gql.GqlConstants;
import com.zimbra.soap.account.type.EntrySearchFilterInfo;
import com.zimbra.soap.account.type.MemberOfSelector;
import com.zimbra.soap.type.GalSearchType;

import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.types.GraphQLType;

/**
 * The GQLGALSearchRequestInput class.<br>
 * Contains GAL search request properties.
 */
@GraphQLType(name=GqlConstants.CLASS_GAL_SEARCH_REQUEST, description="Input for GAL search.")
public class GQLGALSearchRequestInput extends GQLBasicSearchRequestInput {

    private GalSearchType searchType;
    private Boolean includeIsExpandable;
    private Boolean includeIsOwner;
    private MemberOfSelector includeIsMember;
    private Boolean includeSMIMECerts;
    private String galAccountId;
    private EntrySearchFilterInfo searchFilter;

    public GalSearchType getSearchType() {
        return searchType;
    }

    public Boolean getIncludeIsExpandable() {
        return includeIsExpandable;
    }

    public Boolean getIncludeIsOwner() {
        return includeIsOwner;
    }

    public MemberOfSelector getIncludeIsMember() {
        return includeIsMember;
    }

    public Boolean getIncludeSMIMECerts() {
        return includeSMIMECerts;
    }

    public String getGalAccountId() {
        return galAccountId;
    }

    public EntrySearchFilterInfo getSearchFilter() {
        return searchFilter;
    }

    @GraphQLInputField(name = GqlConstants.SEARCH_TYPE, description="type of addresses to auto-complete on.\n" + 
            "           \"account\" for regular user accounts, aliases and distribution lists, \n" + 
            "           \"resource\" for calendar resources, \n" + 
            "           \"group\" for groups, \n" + 
            "           \"all\" for combination of all types.\n" + 
            "     if omitted, defaults to \"all\"")
    public void setSearchType(GalSearchType searchType) {
        this.searchType = searchType;
    }

    @GraphQLInputField(name = GqlConstants.INCLUDE_IS_EXPANDABLE, description="Denotes whether \"exp\" flag is included in the response for group entries or not. Default is unset.")
    public void setIncludeIsExpandable(Boolean includeIsExpandable) {
        this.includeIsExpandable = includeIsExpandable;
    }

    @GraphQLInputField(name = GqlConstants.INCLUDE_IS_OWNER, description="Denotes whether \"isOwner\" flag is included in the response for group entries or not. Default is unset.")
    public void setIncludeIsOwner(Boolean includeIsOwner) {
        this.includeIsOwner = includeIsOwner;
    }

    @GraphQLInputField(name = GqlConstants.INCLUDE_IS_MEMBER, description="Specify if the \"isMember\" flag is included in the response for group entries.")
    public void setIncludeIsMember(MemberOfSelector includeIsMember) {
        this.includeIsMember = includeIsMember;
    }

    @GraphQLInputField(name = GqlConstants.INCLUDE_SMIME_CERTS, description="Internal attr, for proxied GSA search from GetSMIMEPublicCerts only")
    public void setIncludeSMIMECerts(Boolean includeSMIMECerts) {
        this.includeSMIMECerts = includeSMIMECerts;
    }

    @GraphQLInputField(name = GqlConstants.GAL_ACCOUNT_ID, description="GAL Account ID")
    public void setGalAccountId(String galAccountId) {
        this.galAccountId = galAccountId;
    }

    @GraphQLInputField(name = GqlConstants.SEARCH_FILTER, description="Search filter specification")
    public void setSearchFilter(EntrySearchFilterInfo searchFilter) {
        this.searchFilter = searchFilter;
    }

    @Override
    @GraphQLInputField(name = GqlConstants.SORT_BY, description="SortBy setting. Possible values: none|dateAsc|dateDesc|subjAsc|subjDesc|nameAsc|nameDesc|rcptAsc|rcptDesc|attachAsc|attachDesc|flagAsc|flagDesc|\n" + 
            "      priorityAsc|priorityDesc. If `sortBy` is \"none\" then cursors MUST NOT be used, and some searches are impossible (searches that require intersection of complex sub-ops). Server will throw an IllegalArgumentException if the search is invalid.")
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}

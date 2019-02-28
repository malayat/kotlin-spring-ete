package ec.solmedia.kotlin.spring.ete.cms.domain.repository

import ec.solmedia.kotlin.spring.ete.cms.domain.models.Category
import ec.solmedia.kotlin.spring.ete.cms.domain.models.Role
import ec.solmedia.kotlin.spring.ete.cms.domain.models.User

fun getMockCategories() = mutableSetOf(
    Category("LN", "Local news"),
    Category("N", "News"),
    Category("BN", "Breaking news"),
    Category("GNF", "Global news flow"),
    Category("MMS", "Media monitoring service")
)

fun getMockUsers() = mutableSetOf(
    User("1", "wgeddis0", "Weidar Geddis", Role.AUTHOR),
    User("2", "lhysom1", "Lurlene Hysom", Role.AUTHOR),
    User("3", "nleavold2", "Norine Leavold", Role.REVIEWER),
    User("4", "hlydall3", "Harland Lydall", Role.AUTHOR),
    User("5", "dmapplebeckb", "Dougie Mapplebeck", Role.REVIEWER)
)
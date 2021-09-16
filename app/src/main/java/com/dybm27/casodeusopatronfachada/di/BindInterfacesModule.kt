package com.dybm27.casodeusopatronfachada.di

import com.dybm27.casodeusopatronfachada.home.model.HospitalFacade
import com.dybm27.casodeusopatronfachada.home.model.IHospitalFacade
import com.dybm27.casodeusopatronfachada.home.model.affiliate.ApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.affiliate.IApiAffiliate
import com.dybm27.casodeusopatronfachada.home.model.appointment.dataaccess.ApiAppointment
import com.dybm27.casodeusopatronfachada.home.model.appointment.dataaccess.IApiAppointment
import com.dybm27.casodeusopatronfachada.home.model.notification.ApiNotification
import com.dybm27.casodeusopatronfachada.home.model.notification.IApiNotification
import com.dybm27.casodeusopatronfachada.home.model.specialist.ApiSpecialist
import com.dybm27.casodeusopatronfachada.home.model.specialist.IApiSpecialist
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class BindInterfacesModule {
    @Binds
    abstract fun bindIApiAffiliate(
        apiAffiliate: ApiAffiliate
    ): IApiAffiliate

    @Binds
    abstract fun bindIApiSpecialist(
        apiSpecialist: ApiSpecialist
    ): IApiSpecialist

    @Binds
    abstract fun bindIApiNotification(
        apiNotification: ApiNotification
    ): IApiNotification

    @Binds
    abstract fun bindIApiAppointment(
        apiAppointment: ApiAppointment
    ): IApiAppointment

    @Binds
    abstract fun bindIHospitalFacade(
        hospitalFacade: HospitalFacade
    ): IHospitalFacade
}
package com.dybm27.patternfacade.di

import com.dybm27.patternfacade.home.model.HospitalFacade
import com.dybm27.patternfacade.home.model.IHospitalFacade
import com.dybm27.patternfacade.home.model.affiliate.AffiliateRepositoryRepository
import com.dybm27.patternfacade.home.model.affiliate.IAffiliateRepository
import com.dybm27.patternfacade.home.model.appointment.AppointmentRepository
import com.dybm27.patternfacade.home.model.appointment.IAppointmentRepository
import com.dybm27.patternfacade.home.model.notification.NotificationRepository
import com.dybm27.patternfacade.home.model.notification.INotificationRepository
import com.dybm27.patternfacade.home.model.specialist.SpecialistRepository
import com.dybm27.patternfacade.home.model.specialist.ISpecialistRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class BindInterfacesModule {
    @Binds
    abstract fun bindIAffiliateRepository(
        affiliateRepository: AffiliateRepositoryRepository
    ): IAffiliateRepository

    @Binds
    abstract fun bindISpecialistRepository(
        specialistRepository: SpecialistRepository
    ): ISpecialistRepository

    @Binds
    abstract fun bindINotificationRepository(
        notificationRepository: NotificationRepository
    ): INotificationRepository

    @Binds
    abstract fun bindIAppointmentRepository(
        appointmentRepository: AppointmentRepository
    ): IAppointmentRepository

    @Binds
    abstract fun bindIHospitalFacade(
        hospitalFacade: HospitalFacade
    ): IHospitalFacade
}
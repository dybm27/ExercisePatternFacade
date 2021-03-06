package com.dybm27.patternfacade.di

import android.content.Context
import androidx.room.Room
import com.dybm27.patternfacade.bd.DatabaseHospital
import com.dybm27.patternfacade.home.model.affiliate.dataaccess.dao.AffiliateDao
import com.dybm27.patternfacade.home.model.appointment.dataaccess.dao.AppointmentDao
import com.dybm27.patternfacade.home.model.specialist.dataaccess.dao.SpecialistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): DatabaseHospital =
        Room.databaseBuilder(appContext, DatabaseHospital::class.java, "hospital")
            .createFromAsset("database/hospital.db")
            .build()

    @Provides
    fun provideAffiliateDao(databaseHospital: DatabaseHospital): AffiliateDao =
        databaseHospital.affiliateDao()

    @Provides
    fun provideSpecialistDao(databaseHospital: DatabaseHospital): SpecialistDao =
        databaseHospital.specialistDao()

    @Provides
    fun provideAppointmentDao(databaseHospital: DatabaseHospital): AppointmentDao =
        databaseHospital.appointmentDao()
}
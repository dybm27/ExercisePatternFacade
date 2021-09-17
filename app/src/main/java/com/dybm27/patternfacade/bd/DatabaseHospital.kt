package com.dybm27.patternfacade.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dybm27.patternfacade.home.model.affiliate.dataaccess.dao.AffiliateDao
import com.dybm27.patternfacade.home.model.affiliate.dataaccess.entities.AffiliateEntity
import com.dybm27.patternfacade.home.model.appointment.dataaccess.dao.AppointmentDao
import com.dybm27.patternfacade.home.model.appointment.dataaccess.entities.AppointmentEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.dao.SpecialistDao
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.ScheduleEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.SpecialistEntity
import com.dybm27.patternfacade.home.model.specialist.dataaccess.entities.TypeSpecialistEntity

@Database(
    entities = [AffiliateEntity::class,
        SpecialistEntity::class,
        TypeSpecialistEntity::class,
        ScheduleEntity::class,
        AppointmentEntity::class],
    version = 1
)
@TypeConverters(DateConverters::class)
abstract class DatabaseHospital : RoomDatabase() {
    abstract fun affiliateDao(): AffiliateDao
    abstract fun specialistDao(): SpecialistDao
    abstract fun appointmentDao(): AppointmentDao
}
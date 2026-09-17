package cdm.legaldocumentation.csa;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.NotificationTimeElectionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the notification time election by the respective parties to the agreement.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(iii)" * name "Notification Time"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)(iii)" * name "Notification Time"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(iii)" * name "Notification Time"
 *
 * Provision 
 *
 */
@RosettaDataType(value="NotificationTimeElection", builder=NotificationTimeElection.NotificationTimeElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="NotificationTimeElection", model="cdm", builder=NotificationTimeElection.NotificationTimeElectionBuilderImpl.class, version="6.23.0")
public interface NotificationTimeElection extends RosettaModelObject {

	NotificationTimeElectionMeta metaData = new NotificationTimeElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The Notification Time as a time that is qualified as a standard business center.
	 */
	BusinessCenterTime getNotificationTime();
	/**
	 * The Notification Time as a bespoke election.
	 */
	String getCustomNotification();
	/**
	 * Whether the Notification Time is precluded on the day being a local business day.
	 */
	Boolean getLocalBusinessDay();

	/*********************** Build Methods  ***********************/
	NotificationTimeElection build();
	
	NotificationTimeElection.NotificationTimeElectionBuilder toBuilder();
	
	static NotificationTimeElection.NotificationTimeElectionBuilder builder() {
		return new NotificationTimeElection.NotificationTimeElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotificationTimeElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotificationTimeElection> getType() {
		return NotificationTimeElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processRosetta(path.newSubPath("notificationTime"), processor, BusinessCenterTime.class, getNotificationTime());
		processor.processBasic(path.newSubPath("customNotification"), String.class, getCustomNotification(), this);
		processor.processBasic(path.newSubPath("localBusinessDay"), Boolean.class, getLocalBusinessDay(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotificationTimeElectionBuilder extends NotificationTimeElection, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateNotificationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getNotificationTime();
		NotificationTimeElection.NotificationTimeElectionBuilder setParty(CounterpartyRoleEnum party);
		NotificationTimeElection.NotificationTimeElectionBuilder setNotificationTime(BusinessCenterTime notificationTime);
		NotificationTimeElection.NotificationTimeElectionBuilder setCustomNotification(String customNotification);
		NotificationTimeElection.NotificationTimeElectionBuilder setLocalBusinessDay(Boolean localBusinessDay);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processRosetta(path.newSubPath("notificationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getNotificationTime());
			processor.processBasic(path.newSubPath("customNotification"), String.class, getCustomNotification(), this);
			processor.processBasic(path.newSubPath("localBusinessDay"), Boolean.class, getLocalBusinessDay(), this);
		}
		

		NotificationTimeElection.NotificationTimeElectionBuilder prune();
	}

	/*********************** Immutable Implementation of NotificationTimeElection  ***********************/
	class NotificationTimeElectionImpl implements NotificationTimeElection {
		private final CounterpartyRoleEnum party;
		private final BusinessCenterTime notificationTime;
		private final String customNotification;
		private final Boolean localBusinessDay;
		
		protected NotificationTimeElectionImpl(NotificationTimeElection.NotificationTimeElectionBuilder builder) {
			this.party = builder.getParty();
			this.notificationTime = ofNullable(builder.getNotificationTime()).map(f->f.build()).orElse(null);
			this.customNotification = builder.getCustomNotification();
			this.localBusinessDay = builder.getLocalBusinessDay();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("notificationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notificationTime")
		public BusinessCenterTime getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		@RosettaAttribute("customNotification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customNotification")
		public String getCustomNotification() {
			return customNotification;
		}
		
		@Override
		@RosettaAttribute("localBusinessDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localBusinessDay")
		public Boolean getLocalBusinessDay() {
			return localBusinessDay;
		}
		
		@Override
		public NotificationTimeElection build() {
			return this;
		}
		
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder toBuilder() {
			NotificationTimeElection.NotificationTimeElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotificationTimeElection.NotificationTimeElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getNotificationTime()).ifPresent(builder::setNotificationTime);
			ofNullable(getCustomNotification()).ifPresent(builder::setCustomNotification);
			ofNullable(getLocalBusinessDay()).ifPresent(builder::setLocalBusinessDay);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTimeElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(customNotification, _that.getCustomNotification())) return false;
			if (!Objects.equals(localBusinessDay, _that.getLocalBusinessDay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (customNotification != null ? customNotification.hashCode() : 0);
			_result = 31 * _result + (localBusinessDay != null ? localBusinessDay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTimeElection {" +
				"party=" + this.party + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"customNotification=" + this.customNotification + ", " +
				"localBusinessDay=" + this.localBusinessDay +
			'}';
		}
	}

	/*********************** Builder Implementation of NotificationTimeElection  ***********************/
	class NotificationTimeElectionBuilderImpl implements NotificationTimeElection.NotificationTimeElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected BusinessCenterTime.BusinessCenterTimeBuilder notificationTime;
		protected String customNotification;
		protected Boolean localBusinessDay;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("notificationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notificationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateNotificationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (notificationTime!=null) {
				result = notificationTime;
			}
			else {
				result = notificationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("customNotification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customNotification")
		public String getCustomNotification() {
			return customNotification;
		}
		
		@Override
		@RosettaAttribute("localBusinessDay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localBusinessDay")
		public Boolean getLocalBusinessDay() {
			return localBusinessDay;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("notificationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notificationTime")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setNotificationTime(BusinessCenterTime _notificationTime) {
			this.notificationTime = _notificationTime == null ? null : _notificationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("customNotification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customNotification")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setCustomNotification(String _customNotification) {
			this.customNotification = _customNotification == null ? null : _customNotification;
			return this;
		}
		
		@RosettaAttribute("localBusinessDay")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localBusinessDay")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setLocalBusinessDay(Boolean _localBusinessDay) {
			this.localBusinessDay = _localBusinessDay == null ? null : _localBusinessDay;
			return this;
		}
		
		@Override
		public NotificationTimeElection build() {
			return new NotificationTimeElection.NotificationTimeElectionImpl(this);
		}
		
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder prune() {
			if (notificationTime!=null && !notificationTime.prune().hasData()) notificationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getNotificationTime()!=null && getNotificationTime().hasData()) return true;
			if (getCustomNotification()!=null) return true;
			if (getLocalBusinessDay()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotificationTimeElection.NotificationTimeElectionBuilder o = (NotificationTimeElection.NotificationTimeElectionBuilder) other;
			
			merger.mergeRosetta(getNotificationTime(), o.getNotificationTime(), this::setNotificationTime);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getCustomNotification(), o.getCustomNotification(), this::setCustomNotification);
			merger.mergeBasic(getLocalBusinessDay(), o.getLocalBusinessDay(), this::setLocalBusinessDay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTimeElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(customNotification, _that.getCustomNotification())) return false;
			if (!Objects.equals(localBusinessDay, _that.getLocalBusinessDay())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (customNotification != null ? customNotification.hashCode() : 0);
			_result = 31 * _result + (localBusinessDay != null ? localBusinessDay.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTimeElectionBuilder {" +
				"party=" + this.party + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"customNotification=" + this.customNotification + ", " +
				"localBusinessDay=" + this.localBusinessDay +
			'}';
		}
	}
}

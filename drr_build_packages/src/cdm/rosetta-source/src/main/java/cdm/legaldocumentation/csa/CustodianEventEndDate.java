package cdm.legaldocumentation.csa;

import cdm.base.datetime.CustomisableOffset;
import cdm.legaldocumentation.csa.meta.CustodianEventEndDateMeta;
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
 * A class to specify the Custodian Event.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(iii)" * name "CE End Date"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(m)(ii)" * name "CME End Date"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(iii)" * name "CE End Date"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CustodianEventEndDate", builder=CustodianEventEndDate.CustodianEventEndDateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodianEventEndDate", model="cdm", builder=CustodianEventEndDate.CustodianEventEndDateBuilderImpl.class, version="6.23.0")
public interface CustodianEventEndDate extends RosettaModelObject {

	CustodianEventEndDateMeta metaData = new CustodianEventEndDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Election to specify the number of days after the occurrence of the Custodian Event/Collateral Management Event for the purpose of qualifying the CE/CME End Date.
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(iii)" * name " Custodian Event"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(m)(ii)" * name "Collateral Manager Event"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(iii)" * name " Custodian Event"
	 *
	 * Provision 
	 *
	 */
	CustomisableOffset getDaysAfterCustodianEvent();
	/**
	 * Election to specify the number of days prior to the termination of the Control Agreement /Collateral Management Event for the purpose of qualifying the CE/CME End Date, in the case where advance notice is given.
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 *
	 * Provision 
	 *
	 */
	CustomisableOffset getReleaseDate();
	/**
	 * The parties&#39; election to specify the number of days prior to the end of the safekeeping period (Clearstream CTA) purpose of qualifying the CE/CME End Date, in the case where advance notice is given.
	 */
	CustomisableOffset getSafekeepingPeriodExpiry();
	/**
	 * The parties&#39; election to specify the number of days one party has effectively provided the Timely Statement to the other party.
	 */
	CustomisableOffset getDateOfTimelyStatement();

	/*********************** Build Methods  ***********************/
	CustodianEventEndDate build();
	
	CustodianEventEndDate.CustodianEventEndDateBuilder toBuilder();
	
	static CustodianEventEndDate.CustodianEventEndDateBuilder builder() {
		return new CustodianEventEndDate.CustodianEventEndDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodianEventEndDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodianEventEndDate> getType() {
		return CustodianEventEndDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("daysAfterCustodianEvent"), processor, CustomisableOffset.class, getDaysAfterCustodianEvent());
		processRosetta(path.newSubPath("releaseDate"), processor, CustomisableOffset.class, getReleaseDate());
		processRosetta(path.newSubPath("safekeepingPeriodExpiry"), processor, CustomisableOffset.class, getSafekeepingPeriodExpiry());
		processRosetta(path.newSubPath("dateOfTimelyStatement"), processor, CustomisableOffset.class, getDateOfTimelyStatement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianEventEndDateBuilder extends CustodianEventEndDate, RosettaModelObjectBuilder {
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateDaysAfterCustodianEvent();
		@Override
		CustomisableOffset.CustomisableOffsetBuilder getDaysAfterCustodianEvent();
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateReleaseDate();
		@Override
		CustomisableOffset.CustomisableOffsetBuilder getReleaseDate();
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateSafekeepingPeriodExpiry();
		@Override
		CustomisableOffset.CustomisableOffsetBuilder getSafekeepingPeriodExpiry();
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateDateOfTimelyStatement();
		@Override
		CustomisableOffset.CustomisableOffsetBuilder getDateOfTimelyStatement();
		CustodianEventEndDate.CustodianEventEndDateBuilder setDaysAfterCustodianEvent(CustomisableOffset daysAfterCustodianEvent);
		CustodianEventEndDate.CustodianEventEndDateBuilder setReleaseDate(CustomisableOffset releaseDate);
		CustodianEventEndDate.CustodianEventEndDateBuilder setSafekeepingPeriodExpiry(CustomisableOffset safekeepingPeriodExpiry);
		CustodianEventEndDate.CustodianEventEndDateBuilder setDateOfTimelyStatement(CustomisableOffset dateOfTimelyStatement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("daysAfterCustodianEvent"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getDaysAfterCustodianEvent());
			processRosetta(path.newSubPath("releaseDate"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getReleaseDate());
			processRosetta(path.newSubPath("safekeepingPeriodExpiry"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getSafekeepingPeriodExpiry());
			processRosetta(path.newSubPath("dateOfTimelyStatement"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getDateOfTimelyStatement());
		}
		

		CustodianEventEndDate.CustodianEventEndDateBuilder prune();
	}

	/*********************** Immutable Implementation of CustodianEventEndDate  ***********************/
	class CustodianEventEndDateImpl implements CustodianEventEndDate {
		private final CustomisableOffset daysAfterCustodianEvent;
		private final CustomisableOffset releaseDate;
		private final CustomisableOffset safekeepingPeriodExpiry;
		private final CustomisableOffset dateOfTimelyStatement;
		
		protected CustodianEventEndDateImpl(CustodianEventEndDate.CustodianEventEndDateBuilder builder) {
			this.daysAfterCustodianEvent = ofNullable(builder.getDaysAfterCustodianEvent()).map(f->f.build()).orElse(null);
			this.releaseDate = ofNullable(builder.getReleaseDate()).map(f->f.build()).orElse(null);
			this.safekeepingPeriodExpiry = ofNullable(builder.getSafekeepingPeriodExpiry()).map(f->f.build()).orElse(null);
			this.dateOfTimelyStatement = ofNullable(builder.getDateOfTimelyStatement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("daysAfterCustodianEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("daysAfterCustodianEvent")
		public CustomisableOffset getDaysAfterCustodianEvent() {
			return daysAfterCustodianEvent;
		}
		
		@Override
		@RosettaAttribute("releaseDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("releaseDate")
		public CustomisableOffset getReleaseDate() {
			return releaseDate;
		}
		
		@Override
		@RosettaAttribute("safekeepingPeriodExpiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("safekeepingPeriodExpiry")
		public CustomisableOffset getSafekeepingPeriodExpiry() {
			return safekeepingPeriodExpiry;
		}
		
		@Override
		@RosettaAttribute("dateOfTimelyStatement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dateOfTimelyStatement")
		public CustomisableOffset getDateOfTimelyStatement() {
			return dateOfTimelyStatement;
		}
		
		@Override
		public CustodianEventEndDate build() {
			return this;
		}
		
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder toBuilder() {
			CustodianEventEndDate.CustodianEventEndDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianEventEndDate.CustodianEventEndDateBuilder builder) {
			ofNullable(getDaysAfterCustodianEvent()).ifPresent(builder::setDaysAfterCustodianEvent);
			ofNullable(getReleaseDate()).ifPresent(builder::setReleaseDate);
			ofNullable(getSafekeepingPeriodExpiry()).ifPresent(builder::setSafekeepingPeriodExpiry);
			ofNullable(getDateOfTimelyStatement()).ifPresent(builder::setDateOfTimelyStatement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEventEndDate _that = getType().cast(o);
		
			if (!Objects.equals(daysAfterCustodianEvent, _that.getDaysAfterCustodianEvent())) return false;
			if (!Objects.equals(releaseDate, _that.getReleaseDate())) return false;
			if (!Objects.equals(safekeepingPeriodExpiry, _that.getSafekeepingPeriodExpiry())) return false;
			if (!Objects.equals(dateOfTimelyStatement, _that.getDateOfTimelyStatement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysAfterCustodianEvent != null ? daysAfterCustodianEvent.hashCode() : 0);
			_result = 31 * _result + (releaseDate != null ? releaseDate.hashCode() : 0);
			_result = 31 * _result + (safekeepingPeriodExpiry != null ? safekeepingPeriodExpiry.hashCode() : 0);
			_result = 31 * _result + (dateOfTimelyStatement != null ? dateOfTimelyStatement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEventEndDate {" +
				"daysAfterCustodianEvent=" + this.daysAfterCustodianEvent + ", " +
				"releaseDate=" + this.releaseDate + ", " +
				"safekeepingPeriodExpiry=" + this.safekeepingPeriodExpiry + ", " +
				"dateOfTimelyStatement=" + this.dateOfTimelyStatement +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodianEventEndDate  ***********************/
	class CustodianEventEndDateBuilderImpl implements CustodianEventEndDate.CustodianEventEndDateBuilder {
	
		protected CustomisableOffset.CustomisableOffsetBuilder daysAfterCustodianEvent;
		protected CustomisableOffset.CustomisableOffsetBuilder releaseDate;
		protected CustomisableOffset.CustomisableOffsetBuilder safekeepingPeriodExpiry;
		protected CustomisableOffset.CustomisableOffsetBuilder dateOfTimelyStatement;
		
		@Override
		@RosettaAttribute("daysAfterCustodianEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("daysAfterCustodianEvent")
		public CustomisableOffset.CustomisableOffsetBuilder getDaysAfterCustodianEvent() {
			return daysAfterCustodianEvent;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateDaysAfterCustodianEvent() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (daysAfterCustodianEvent!=null) {
				result = daysAfterCustodianEvent;
			}
			else {
				result = daysAfterCustodianEvent = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("releaseDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("releaseDate")
		public CustomisableOffset.CustomisableOffsetBuilder getReleaseDate() {
			return releaseDate;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateReleaseDate() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (releaseDate!=null) {
				result = releaseDate;
			}
			else {
				result = releaseDate = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("safekeepingPeriodExpiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("safekeepingPeriodExpiry")
		public CustomisableOffset.CustomisableOffsetBuilder getSafekeepingPeriodExpiry() {
			return safekeepingPeriodExpiry;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateSafekeepingPeriodExpiry() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (safekeepingPeriodExpiry!=null) {
				result = safekeepingPeriodExpiry;
			}
			else {
				result = safekeepingPeriodExpiry = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateOfTimelyStatement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dateOfTimelyStatement")
		public CustomisableOffset.CustomisableOffsetBuilder getDateOfTimelyStatement() {
			return dateOfTimelyStatement;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateDateOfTimelyStatement() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (dateOfTimelyStatement!=null) {
				result = dateOfTimelyStatement;
			}
			else {
				result = dateOfTimelyStatement = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("daysAfterCustodianEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("daysAfterCustodianEvent")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setDaysAfterCustodianEvent(CustomisableOffset _daysAfterCustodianEvent) {
			this.daysAfterCustodianEvent = _daysAfterCustodianEvent == null ? null : _daysAfterCustodianEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("releaseDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("releaseDate")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setReleaseDate(CustomisableOffset _releaseDate) {
			this.releaseDate = _releaseDate == null ? null : _releaseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("safekeepingPeriodExpiry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("safekeepingPeriodExpiry")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setSafekeepingPeriodExpiry(CustomisableOffset _safekeepingPeriodExpiry) {
			this.safekeepingPeriodExpiry = _safekeepingPeriodExpiry == null ? null : _safekeepingPeriodExpiry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateOfTimelyStatement")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dateOfTimelyStatement")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder setDateOfTimelyStatement(CustomisableOffset _dateOfTimelyStatement) {
			this.dateOfTimelyStatement = _dateOfTimelyStatement == null ? null : _dateOfTimelyStatement.toBuilder();
			return this;
		}
		
		@Override
		public CustodianEventEndDate build() {
			return new CustodianEventEndDate.CustodianEventEndDateImpl(this);
		}
		
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder prune() {
			if (daysAfterCustodianEvent!=null && !daysAfterCustodianEvent.prune().hasData()) daysAfterCustodianEvent = null;
			if (releaseDate!=null && !releaseDate.prune().hasData()) releaseDate = null;
			if (safekeepingPeriodExpiry!=null && !safekeepingPeriodExpiry.prune().hasData()) safekeepingPeriodExpiry = null;
			if (dateOfTimelyStatement!=null && !dateOfTimelyStatement.prune().hasData()) dateOfTimelyStatement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDaysAfterCustodianEvent()!=null && getDaysAfterCustodianEvent().hasData()) return true;
			if (getReleaseDate()!=null && getReleaseDate().hasData()) return true;
			if (getSafekeepingPeriodExpiry()!=null && getSafekeepingPeriodExpiry().hasData()) return true;
			if (getDateOfTimelyStatement()!=null && getDateOfTimelyStatement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianEventEndDate.CustodianEventEndDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianEventEndDate.CustodianEventEndDateBuilder o = (CustodianEventEndDate.CustodianEventEndDateBuilder) other;
			
			merger.mergeRosetta(getDaysAfterCustodianEvent(), o.getDaysAfterCustodianEvent(), this::setDaysAfterCustodianEvent);
			merger.mergeRosetta(getReleaseDate(), o.getReleaseDate(), this::setReleaseDate);
			merger.mergeRosetta(getSafekeepingPeriodExpiry(), o.getSafekeepingPeriodExpiry(), this::setSafekeepingPeriodExpiry);
			merger.mergeRosetta(getDateOfTimelyStatement(), o.getDateOfTimelyStatement(), this::setDateOfTimelyStatement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianEventEndDate _that = getType().cast(o);
		
			if (!Objects.equals(daysAfterCustodianEvent, _that.getDaysAfterCustodianEvent())) return false;
			if (!Objects.equals(releaseDate, _that.getReleaseDate())) return false;
			if (!Objects.equals(safekeepingPeriodExpiry, _that.getSafekeepingPeriodExpiry())) return false;
			if (!Objects.equals(dateOfTimelyStatement, _that.getDateOfTimelyStatement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysAfterCustodianEvent != null ? daysAfterCustodianEvent.hashCode() : 0);
			_result = 31 * _result + (releaseDate != null ? releaseDate.hashCode() : 0);
			_result = 31 * _result + (safekeepingPeriodExpiry != null ? safekeepingPeriodExpiry.hashCode() : 0);
			_result = 31 * _result + (dateOfTimelyStatement != null ? dateOfTimelyStatement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianEventEndDateBuilder {" +
				"daysAfterCustodianEvent=" + this.daysAfterCustodianEvent + ", " +
				"releaseDate=" + this.releaseDate + ", " +
				"safekeepingPeriodExpiry=" + this.safekeepingPeriodExpiry + ", " +
				"dateOfTimelyStatement=" + this.dateOfTimelyStatement +
			'}';
		}
	}
}

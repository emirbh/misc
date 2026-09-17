package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.DatedAsOfDateMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the dates agreed by the parties as the date of the Credit Support Annex or Credit Support Deed.
 * @version 6.23.0
 */
@RosettaDataType(value="DatedAsOfDate", builder=DatedAsOfDate.DatedAsOfDateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="DatedAsOfDate", model="cdm", builder=DatedAsOfDate.DatedAsOfDateBuilderImpl.class, version="6.23.0")
public interface DatedAsOfDate extends RosettaModelObject {

	DatedAsOfDateMeta metaData = new DatedAsOfDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date agreed by the parties as the Dated as of Date for the Credit Support Annex.
	 */
	Date getCsaDatedAsOfDate();
	/**
	 * The date agreed by the parties as the Dated as of Date for the Master Agreement.
	 */
	Date getMasterAgreementDatedAsOfDate();
	/**
	 * The date agreed by the parties as the Made On date of the Credit Support Deed.
	 */
	Date getCsaMadeOn();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	DatedAsOfDate build();
	
	DatedAsOfDate.DatedAsOfDateBuilder toBuilder();
	
	static DatedAsOfDate.DatedAsOfDateBuilder builder() {
		return new DatedAsOfDate.DatedAsOfDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DatedAsOfDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DatedAsOfDate> getType() {
		return DatedAsOfDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("csaDatedAsOfDate"), Date.class, getCsaDatedAsOfDate(), this);
		processor.processBasic(path.newSubPath("masterAgreementDatedAsOfDate"), Date.class, getMasterAgreementDatedAsOfDate(), this);
		processor.processBasic(path.newSubPath("csaMadeOn"), Date.class, getCsaMadeOn(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DatedAsOfDateBuilder extends DatedAsOfDate, RosettaModelObjectBuilder {
		DatedAsOfDate.DatedAsOfDateBuilder setCsaDatedAsOfDate(Date csaDatedAsOfDate);
		DatedAsOfDate.DatedAsOfDateBuilder setMasterAgreementDatedAsOfDate(Date masterAgreementDatedAsOfDate);
		DatedAsOfDate.DatedAsOfDateBuilder setCsaMadeOn(Date csaMadeOn);
		DatedAsOfDate.DatedAsOfDateBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("csaDatedAsOfDate"), Date.class, getCsaDatedAsOfDate(), this);
			processor.processBasic(path.newSubPath("masterAgreementDatedAsOfDate"), Date.class, getMasterAgreementDatedAsOfDate(), this);
			processor.processBasic(path.newSubPath("csaMadeOn"), Date.class, getCsaMadeOn(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		DatedAsOfDate.DatedAsOfDateBuilder prune();
	}

	/*********************** Immutable Implementation of DatedAsOfDate  ***********************/
	class DatedAsOfDateImpl implements DatedAsOfDate {
		private final Date csaDatedAsOfDate;
		private final Date masterAgreementDatedAsOfDate;
		private final Date csaMadeOn;
		private final String additionalLanguage;
		
		protected DatedAsOfDateImpl(DatedAsOfDate.DatedAsOfDateBuilder builder) {
			this.csaDatedAsOfDate = builder.getCsaDatedAsOfDate();
			this.masterAgreementDatedAsOfDate = builder.getMasterAgreementDatedAsOfDate();
			this.csaMadeOn = builder.getCsaMadeOn();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("csaDatedAsOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csaDatedAsOfDate")
		public Date getCsaDatedAsOfDate() {
			return csaDatedAsOfDate;
		}
		
		@Override
		@RosettaAttribute("masterAgreementDatedAsOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementDatedAsOfDate")
		public Date getMasterAgreementDatedAsOfDate() {
			return masterAgreementDatedAsOfDate;
		}
		
		@Override
		@RosettaAttribute("csaMadeOn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csaMadeOn")
		public Date getCsaMadeOn() {
			return csaMadeOn;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public DatedAsOfDate build() {
			return this;
		}
		
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder toBuilder() {
			DatedAsOfDate.DatedAsOfDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DatedAsOfDate.DatedAsOfDateBuilder builder) {
			ofNullable(getCsaDatedAsOfDate()).ifPresent(builder::setCsaDatedAsOfDate);
			ofNullable(getMasterAgreementDatedAsOfDate()).ifPresent(builder::setMasterAgreementDatedAsOfDate);
			ofNullable(getCsaMadeOn()).ifPresent(builder::setCsaMadeOn);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DatedAsOfDate _that = getType().cast(o);
		
			if (!Objects.equals(csaDatedAsOfDate, _that.getCsaDatedAsOfDate())) return false;
			if (!Objects.equals(masterAgreementDatedAsOfDate, _that.getMasterAgreementDatedAsOfDate())) return false;
			if (!Objects.equals(csaMadeOn, _that.getCsaMadeOn())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (csaDatedAsOfDate != null ? csaDatedAsOfDate.hashCode() : 0);
			_result = 31 * _result + (masterAgreementDatedAsOfDate != null ? masterAgreementDatedAsOfDate.hashCode() : 0);
			_result = 31 * _result + (csaMadeOn != null ? csaMadeOn.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DatedAsOfDate {" +
				"csaDatedAsOfDate=" + this.csaDatedAsOfDate + ", " +
				"masterAgreementDatedAsOfDate=" + this.masterAgreementDatedAsOfDate + ", " +
				"csaMadeOn=" + this.csaMadeOn + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of DatedAsOfDate  ***********************/
	class DatedAsOfDateBuilderImpl implements DatedAsOfDate.DatedAsOfDateBuilder {
	
		protected Date csaDatedAsOfDate;
		protected Date masterAgreementDatedAsOfDate;
		protected Date csaMadeOn;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("csaDatedAsOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csaDatedAsOfDate")
		public Date getCsaDatedAsOfDate() {
			return csaDatedAsOfDate;
		}
		
		@Override
		@RosettaAttribute("masterAgreementDatedAsOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementDatedAsOfDate")
		public Date getMasterAgreementDatedAsOfDate() {
			return masterAgreementDatedAsOfDate;
		}
		
		@Override
		@RosettaAttribute("csaMadeOn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csaMadeOn")
		public Date getCsaMadeOn() {
			return csaMadeOn;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("csaDatedAsOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("csaDatedAsOfDate")
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder setCsaDatedAsOfDate(Date _csaDatedAsOfDate) {
			this.csaDatedAsOfDate = _csaDatedAsOfDate == null ? null : _csaDatedAsOfDate;
			return this;
		}
		
		@RosettaAttribute("masterAgreementDatedAsOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementDatedAsOfDate")
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder setMasterAgreementDatedAsOfDate(Date _masterAgreementDatedAsOfDate) {
			this.masterAgreementDatedAsOfDate = _masterAgreementDatedAsOfDate == null ? null : _masterAgreementDatedAsOfDate;
			return this;
		}
		
		@RosettaAttribute("csaMadeOn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("csaMadeOn")
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder setCsaMadeOn(Date _csaMadeOn) {
			this.csaMadeOn = _csaMadeOn == null ? null : _csaMadeOn;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public DatedAsOfDate build() {
			return new DatedAsOfDate.DatedAsOfDateImpl(this);
		}
		
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCsaDatedAsOfDate()!=null) return true;
			if (getMasterAgreementDatedAsOfDate()!=null) return true;
			if (getCsaMadeOn()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DatedAsOfDate.DatedAsOfDateBuilder o = (DatedAsOfDate.DatedAsOfDateBuilder) other;
			
			
			merger.mergeBasic(getCsaDatedAsOfDate(), o.getCsaDatedAsOfDate(), this::setCsaDatedAsOfDate);
			merger.mergeBasic(getMasterAgreementDatedAsOfDate(), o.getMasterAgreementDatedAsOfDate(), this::setMasterAgreementDatedAsOfDate);
			merger.mergeBasic(getCsaMadeOn(), o.getCsaMadeOn(), this::setCsaMadeOn);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DatedAsOfDate _that = getType().cast(o);
		
			if (!Objects.equals(csaDatedAsOfDate, _that.getCsaDatedAsOfDate())) return false;
			if (!Objects.equals(masterAgreementDatedAsOfDate, _that.getMasterAgreementDatedAsOfDate())) return false;
			if (!Objects.equals(csaMadeOn, _that.getCsaMadeOn())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (csaDatedAsOfDate != null ? csaDatedAsOfDate.hashCode() : 0);
			_result = 31 * _result + (masterAgreementDatedAsOfDate != null ? masterAgreementDatedAsOfDate.hashCode() : 0);
			_result = 31 * _result + (csaMadeOn != null ? csaMadeOn.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DatedAsOfDateBuilder {" +
				"csaDatedAsOfDate=" + this.csaDatedAsOfDate + ", " +
				"masterAgreementDatedAsOfDate=" + this.masterAgreementDatedAsOfDate + ", " +
				"csaMadeOn=" + this.csaMadeOn + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}

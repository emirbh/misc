package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.AmendmentEffectiveDateMeta;
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
 * A class to specify the effective date of the Amendment to Termination Currency. This date can be specified as either an actual date, a specific date (e.g. the annex date) or as a custom provision.
 * @version 6.23.0
 */
@RosettaDataType(value="AmendmentEffectiveDate", builder=AmendmentEffectiveDate.AmendmentEffectiveDateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AmendmentEffectiveDate", model="cdm", builder=AmendmentEffectiveDate.AmendmentEffectiveDateBuilderImpl.class, version="6.23.0")
public interface AmendmentEffectiveDate extends RosettaModelObject {

	AmendmentEffectiveDateMeta metaData = new AmendmentEffectiveDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The effective date of the Amendment to Termination Currency when specified as an actual date.
	 */
	Date getDate();
	/**
	 * The effective date of the Amendment to Termination Currency when specified as relative to another date (e.g. the annex date).
	 */
	AmendmentEffectiveDateEnum getSpecificDate();
	/**
	 * The effective date of the Amendment to Termination Currency when specified as a non normalized custom provision.
	 */
	String getCustomProvision();

	/*********************** Build Methods  ***********************/
	AmendmentEffectiveDate build();
	
	AmendmentEffectiveDate.AmendmentEffectiveDateBuilder toBuilder();
	
	static AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder() {
		return new AmendmentEffectiveDate.AmendmentEffectiveDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmendmentEffectiveDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmendmentEffectiveDate> getType() {
		return AmendmentEffectiveDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("specificDate"), AmendmentEffectiveDateEnum.class, getSpecificDate(), this);
		processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmendmentEffectiveDateBuilder extends AmendmentEffectiveDate, RosettaModelObjectBuilder {
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setDate(Date date);
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setSpecificDate(AmendmentEffectiveDateEnum specificDate);
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setCustomProvision(String customProvision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("specificDate"), AmendmentEffectiveDateEnum.class, getSpecificDate(), this);
			processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
		}
		

		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder prune();
	}

	/*********************** Immutable Implementation of AmendmentEffectiveDate  ***********************/
	class AmendmentEffectiveDateImpl implements AmendmentEffectiveDate {
		private final Date date;
		private final AmendmentEffectiveDateEnum specificDate;
		private final String customProvision;
		
		protected AmendmentEffectiveDateImpl(AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder) {
			this.date = builder.getDate();
			this.specificDate = builder.getSpecificDate();
			this.customProvision = builder.getCustomProvision();
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("specificDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificDate")
		public AmendmentEffectiveDateEnum getSpecificDate() {
			return specificDate;
		}
		
		@Override
		@RosettaAttribute("customProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customProvision")
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		public AmendmentEffectiveDate build() {
			return this;
		}
		
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder toBuilder() {
			AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getSpecificDate()).ifPresent(builder::setSpecificDate);
			ofNullable(getCustomProvision()).ifPresent(builder::setCustomProvision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmendmentEffectiveDate _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(specificDate, _that.getSpecificDate())) return false;
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (specificDate != null ? specificDate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmendmentEffectiveDate {" +
				"date=" + this.date + ", " +
				"specificDate=" + this.specificDate + ", " +
				"customProvision=" + this.customProvision +
			'}';
		}
	}

	/*********************** Builder Implementation of AmendmentEffectiveDate  ***********************/
	class AmendmentEffectiveDateBuilderImpl implements AmendmentEffectiveDate.AmendmentEffectiveDateBuilder {
	
		protected Date date;
		protected AmendmentEffectiveDateEnum specificDate;
		protected String customProvision;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("specificDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificDate")
		public AmendmentEffectiveDateEnum getSpecificDate() {
			return specificDate;
		}
		
		@Override
		@RosettaAttribute("customProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customProvision")
		public String getCustomProvision() {
			return customProvision;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("date")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setDate(Date _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("specificDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specificDate")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setSpecificDate(AmendmentEffectiveDateEnum _specificDate) {
			this.specificDate = _specificDate == null ? null : _specificDate;
			return this;
		}
		
		@RosettaAttribute("customProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customProvision")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setCustomProvision(String _customProvision) {
			this.customProvision = _customProvision == null ? null : _customProvision;
			return this;
		}
		
		@Override
		public AmendmentEffectiveDate build() {
			return new AmendmentEffectiveDate.AmendmentEffectiveDateImpl(this);
		}
		
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getSpecificDate()!=null) return true;
			if (getCustomProvision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmendmentEffectiveDate.AmendmentEffectiveDateBuilder o = (AmendmentEffectiveDate.AmendmentEffectiveDateBuilder) other;
			
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getSpecificDate(), o.getSpecificDate(), this::setSpecificDate);
			merger.mergeBasic(getCustomProvision(), o.getCustomProvision(), this::setCustomProvision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmendmentEffectiveDate _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(specificDate, _that.getSpecificDate())) return false;
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (specificDate != null ? specificDate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmendmentEffectiveDateBuilder {" +
				"date=" + this.date + ", " +
				"specificDate=" + this.specificDate + ", " +
				"customProvision=" + this.customProvision +
			'}';
		}
	}
}

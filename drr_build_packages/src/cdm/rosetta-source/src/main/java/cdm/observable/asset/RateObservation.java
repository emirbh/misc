package cdm.observable.asset;

import cdm.observable.asset.meta.RateObservationMeta;
import cdm.observable.asset.metafields.ReferenceWithMetaRateObservation;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class defining parameters associated with an individual observation or fixing. This class forms part of the cashflow representation of a stream.
 * @version 6.23.0
 */
@RosettaDataType(value="RateObservation", builder=RateObservation.RateObservationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="RateObservation", model="cdm", builder=RateObservation.RateObservationBuilderImpl.class, version="6.23.0")
public interface RateObservation extends RosettaModelObject, GlobalKey {

	RateObservationMeta metaData = new RateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reset date.
	 */
	Date getResetDate();
	/**
	 * The adjusted fixing date, i.e. the actual date the rate is observed. The date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedFixingDate();
	/**
	 * The actual observed rate before any required rate treatment is applied, e.g. before converting a rate quoted on a discount basis to an equivalent yield. An observed rate of 5% would be represented as 0.05.
	 */
	BigDecimal getObservedRate();
	/**
	 * The observed rate after any required rate treatment is applied. A treated rate of 5% would be represented as 0.05.
	 */
	BigDecimal getTreatedRate();
	/**
	 * The number of days weighting to be associated with the rate observation, i.e. the number of days such rate is in effect. This is applicable in the case of a weighted average method of calculation where more than one reset date is established for a single calculation period.
	 */
	Integer getObservationWeight();
	/**
	 * A pointer style reference to a floating rate component defined as part of a stub calculation period amount component. It is only required when it is necessary to distinguish two rate observations for the same fixing date which could occur when linear interpolation of two different rates occurs for a stub calculation period.
	 */
	ReferenceWithMetaRateObservation getRateReference();
	/**
	 * The value representing the forecast rate used to calculate the forecast future value of the accrual period.A value of 1% should be represented as 0.01.
	 */
	BigDecimal getForecastRate();
	/**
	 * The value representing the forecast rate after applying rate treatment rules. A value of 1% should be represented as 0.01.
	 */
	BigDecimal getTreatedForecastRate();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	RateObservation build();
	
	RateObservation.RateObservationBuilder toBuilder();
	
	static RateObservation.RateObservationBuilder builder() {
		return new RateObservation.RateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RateObservation> getType() {
		return RateObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
		processor.processBasic(path.newSubPath("adjustedFixingDate"), Date.class, getAdjustedFixingDate(), this);
		processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
		processor.processBasic(path.newSubPath("treatedRate"), BigDecimal.class, getTreatedRate(), this);
		processor.processBasic(path.newSubPath("observationWeight"), Integer.class, getObservationWeight(), this);
		processRosetta(path.newSubPath("rateReference"), processor, ReferenceWithMetaRateObservation.class, getRateReference());
		processor.processBasic(path.newSubPath("forecastRate"), BigDecimal.class, getForecastRate(), this);
		processor.processBasic(path.newSubPath("treatedForecastRate"), BigDecimal.class, getTreatedForecastRate(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateObservationBuilder extends RateObservation, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder getOrCreateRateReference();
		@Override
		ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder getRateReference();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		RateObservation.RateObservationBuilder setResetDate(Date resetDate);
		RateObservation.RateObservationBuilder setAdjustedFixingDate(Date adjustedFixingDate);
		RateObservation.RateObservationBuilder setObservedRate(BigDecimal observedRate);
		RateObservation.RateObservationBuilder setTreatedRate(BigDecimal treatedRate);
		RateObservation.RateObservationBuilder setObservationWeight(Integer observationWeight);
		RateObservation.RateObservationBuilder setRateReference(ReferenceWithMetaRateObservation rateReference);
		RateObservation.RateObservationBuilder setRateReferenceValue(RateObservation rateReference);
		RateObservation.RateObservationBuilder setForecastRate(BigDecimal forecastRate);
		RateObservation.RateObservationBuilder setTreatedForecastRate(BigDecimal treatedForecastRate);
		RateObservation.RateObservationBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("resetDate"), Date.class, getResetDate(), this);
			processor.processBasic(path.newSubPath("adjustedFixingDate"), Date.class, getAdjustedFixingDate(), this);
			processor.processBasic(path.newSubPath("observedRate"), BigDecimal.class, getObservedRate(), this);
			processor.processBasic(path.newSubPath("treatedRate"), BigDecimal.class, getTreatedRate(), this);
			processor.processBasic(path.newSubPath("observationWeight"), Integer.class, getObservationWeight(), this);
			processRosetta(path.newSubPath("rateReference"), processor, ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder.class, getRateReference());
			processor.processBasic(path.newSubPath("forecastRate"), BigDecimal.class, getForecastRate(), this);
			processor.processBasic(path.newSubPath("treatedForecastRate"), BigDecimal.class, getTreatedForecastRate(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		RateObservation.RateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of RateObservation  ***********************/
	class RateObservationImpl implements RateObservation {
		private final Date resetDate;
		private final Date adjustedFixingDate;
		private final BigDecimal observedRate;
		private final BigDecimal treatedRate;
		private final Integer observationWeight;
		private final ReferenceWithMetaRateObservation rateReference;
		private final BigDecimal forecastRate;
		private final BigDecimal treatedForecastRate;
		private final MetaFields meta;
		
		protected RateObservationImpl(RateObservation.RateObservationBuilder builder) {
			this.resetDate = builder.getResetDate();
			this.adjustedFixingDate = builder.getAdjustedFixingDate();
			this.observedRate = builder.getObservedRate();
			this.treatedRate = builder.getTreatedRate();
			this.observationWeight = builder.getObservationWeight();
			this.rateReference = ofNullable(builder.getRateReference()).map(f->f.build()).orElse(null);
			this.forecastRate = builder.getForecastRate();
			this.treatedForecastRate = builder.getTreatedForecastRate();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("resetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("adjustedFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedFixingDate")
		public Date getAdjustedFixingDate() {
			return adjustedFixingDate;
		}
		
		@Override
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observedRate")
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		@RosettaAttribute("treatedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("treatedRate")
		public BigDecimal getTreatedRate() {
			return treatedRate;
		}
		
		@Override
		@RosettaAttribute("observationWeight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationWeight")
		public Integer getObservationWeight() {
			return observationWeight;
		}
		
		@Override
		@RosettaAttribute("rateReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateReference")
		public ReferenceWithMetaRateObservation getRateReference() {
			return rateReference;
		}
		
		@Override
		@RosettaAttribute("forecastRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastRate")
		public BigDecimal getForecastRate() {
			return forecastRate;
		}
		
		@Override
		@RosettaAttribute("treatedForecastRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("treatedForecastRate")
		public BigDecimal getTreatedForecastRate() {
			return treatedForecastRate;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public RateObservation build() {
			return this;
		}
		
		@Override
		public RateObservation.RateObservationBuilder toBuilder() {
			RateObservation.RateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateObservation.RateObservationBuilder builder) {
			ofNullable(getResetDate()).ifPresent(builder::setResetDate);
			ofNullable(getAdjustedFixingDate()).ifPresent(builder::setAdjustedFixingDate);
			ofNullable(getObservedRate()).ifPresent(builder::setObservedRate);
			ofNullable(getTreatedRate()).ifPresent(builder::setTreatedRate);
			ofNullable(getObservationWeight()).ifPresent(builder::setObservationWeight);
			ofNullable(getRateReference()).ifPresent(builder::setRateReference);
			ofNullable(getForecastRate()).ifPresent(builder::setForecastRate);
			ofNullable(getTreatedForecastRate()).ifPresent(builder::setTreatedForecastRate);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateObservation _that = getType().cast(o);
		
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(adjustedFixingDate, _that.getAdjustedFixingDate())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			if (!Objects.equals(treatedRate, _that.getTreatedRate())) return false;
			if (!Objects.equals(observationWeight, _that.getObservationWeight())) return false;
			if (!Objects.equals(rateReference, _that.getRateReference())) return false;
			if (!Objects.equals(forecastRate, _that.getForecastRate())) return false;
			if (!Objects.equals(treatedForecastRate, _that.getTreatedForecastRate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (adjustedFixingDate != null ? adjustedFixingDate.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			_result = 31 * _result + (treatedRate != null ? treatedRate.hashCode() : 0);
			_result = 31 * _result + (observationWeight != null ? observationWeight.hashCode() : 0);
			_result = 31 * _result + (rateReference != null ? rateReference.hashCode() : 0);
			_result = 31 * _result + (forecastRate != null ? forecastRate.hashCode() : 0);
			_result = 31 * _result + (treatedForecastRate != null ? treatedForecastRate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateObservation {" +
				"resetDate=" + this.resetDate + ", " +
				"adjustedFixingDate=" + this.adjustedFixingDate + ", " +
				"observedRate=" + this.observedRate + ", " +
				"treatedRate=" + this.treatedRate + ", " +
				"observationWeight=" + this.observationWeight + ", " +
				"rateReference=" + this.rateReference + ", " +
				"forecastRate=" + this.forecastRate + ", " +
				"treatedForecastRate=" + this.treatedForecastRate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of RateObservation  ***********************/
	class RateObservationBuilderImpl implements RateObservation.RateObservationBuilder {
	
		protected Date resetDate;
		protected Date adjustedFixingDate;
		protected BigDecimal observedRate;
		protected BigDecimal treatedRate;
		protected Integer observationWeight;
		protected ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder rateReference;
		protected BigDecimal forecastRate;
		protected BigDecimal treatedForecastRate;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("resetDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetDate")
		public Date getResetDate() {
			return resetDate;
		}
		
		@Override
		@RosettaAttribute("adjustedFixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedFixingDate")
		public Date getAdjustedFixingDate() {
			return adjustedFixingDate;
		}
		
		@Override
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observedRate")
		public BigDecimal getObservedRate() {
			return observedRate;
		}
		
		@Override
		@RosettaAttribute("treatedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("treatedRate")
		public BigDecimal getTreatedRate() {
			return treatedRate;
		}
		
		@Override
		@RosettaAttribute("observationWeight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationWeight")
		public Integer getObservationWeight() {
			return observationWeight;
		}
		
		@Override
		@RosettaAttribute("rateReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rateReference")
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder getRateReference() {
			return rateReference;
		}
		
		@Override
		public ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder getOrCreateRateReference() {
			ReferenceWithMetaRateObservation.ReferenceWithMetaRateObservationBuilder result;
			if (rateReference!=null) {
				result = rateReference;
			}
			else {
				result = rateReference = ReferenceWithMetaRateObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("forecastRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("forecastRate")
		public BigDecimal getForecastRate() {
			return forecastRate;
		}
		
		@Override
		@RosettaAttribute("treatedForecastRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("treatedForecastRate")
		public BigDecimal getTreatedForecastRate() {
			return treatedForecastRate;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("resetDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetDate")
		@Override
		public RateObservation.RateObservationBuilder setResetDate(Date _resetDate) {
			this.resetDate = _resetDate == null ? null : _resetDate;
			return this;
		}
		
		@RosettaAttribute("adjustedFixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedFixingDate")
		@Override
		public RateObservation.RateObservationBuilder setAdjustedFixingDate(Date _adjustedFixingDate) {
			this.adjustedFixingDate = _adjustedFixingDate == null ? null : _adjustedFixingDate;
			return this;
		}
		
		@RosettaAttribute("observedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observedRate")
		@Override
		public RateObservation.RateObservationBuilder setObservedRate(BigDecimal _observedRate) {
			this.observedRate = _observedRate == null ? null : _observedRate;
			return this;
		}
		
		@RosettaAttribute("treatedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("treatedRate")
		@Override
		public RateObservation.RateObservationBuilder setTreatedRate(BigDecimal _treatedRate) {
			this.treatedRate = _treatedRate == null ? null : _treatedRate;
			return this;
		}
		
		@RosettaAttribute("observationWeight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationWeight")
		@Override
		public RateObservation.RateObservationBuilder setObservationWeight(Integer _observationWeight) {
			this.observationWeight = _observationWeight == null ? null : _observationWeight;
			return this;
		}
		
		@RosettaAttribute("rateReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateReference")
		@Override
		public RateObservation.RateObservationBuilder setRateReference(ReferenceWithMetaRateObservation _rateReference) {
			this.rateReference = _rateReference == null ? null : _rateReference.toBuilder();
			return this;
		}
		
		@Override
		public RateObservation.RateObservationBuilder setRateReferenceValue(RateObservation _rateReference) {
			this.getOrCreateRateReference().setValue(_rateReference);
			return this;
		}
		
		@RosettaAttribute("forecastRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("forecastRate")
		@Override
		public RateObservation.RateObservationBuilder setForecastRate(BigDecimal _forecastRate) {
			this.forecastRate = _forecastRate == null ? null : _forecastRate;
			return this;
		}
		
		@RosettaAttribute("treatedForecastRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("treatedForecastRate")
		@Override
		public RateObservation.RateObservationBuilder setTreatedForecastRate(BigDecimal _treatedForecastRate) {
			this.treatedForecastRate = _treatedForecastRate == null ? null : _treatedForecastRate;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public RateObservation.RateObservationBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public RateObservation build() {
			return new RateObservation.RateObservationImpl(this);
		}
		
		@Override
		public RateObservation.RateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateObservation.RateObservationBuilder prune() {
			if (rateReference!=null && !rateReference.prune().hasData()) rateReference = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResetDate()!=null) return true;
			if (getAdjustedFixingDate()!=null) return true;
			if (getObservedRate()!=null) return true;
			if (getTreatedRate()!=null) return true;
			if (getObservationWeight()!=null) return true;
			if (getRateReference()!=null && getRateReference().hasData()) return true;
			if (getForecastRate()!=null) return true;
			if (getTreatedForecastRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateObservation.RateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateObservation.RateObservationBuilder o = (RateObservation.RateObservationBuilder) other;
			
			merger.mergeRosetta(getRateReference(), o.getRateReference(), this::setRateReference);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getResetDate(), o.getResetDate(), this::setResetDate);
			merger.mergeBasic(getAdjustedFixingDate(), o.getAdjustedFixingDate(), this::setAdjustedFixingDate);
			merger.mergeBasic(getObservedRate(), o.getObservedRate(), this::setObservedRate);
			merger.mergeBasic(getTreatedRate(), o.getTreatedRate(), this::setTreatedRate);
			merger.mergeBasic(getObservationWeight(), o.getObservationWeight(), this::setObservationWeight);
			merger.mergeBasic(getForecastRate(), o.getForecastRate(), this::setForecastRate);
			merger.mergeBasic(getTreatedForecastRate(), o.getTreatedForecastRate(), this::setTreatedForecastRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateObservation _that = getType().cast(o);
		
			if (!Objects.equals(resetDate, _that.getResetDate())) return false;
			if (!Objects.equals(adjustedFixingDate, _that.getAdjustedFixingDate())) return false;
			if (!Objects.equals(observedRate, _that.getObservedRate())) return false;
			if (!Objects.equals(treatedRate, _that.getTreatedRate())) return false;
			if (!Objects.equals(observationWeight, _that.getObservationWeight())) return false;
			if (!Objects.equals(rateReference, _that.getRateReference())) return false;
			if (!Objects.equals(forecastRate, _that.getForecastRate())) return false;
			if (!Objects.equals(treatedForecastRate, _that.getTreatedForecastRate())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resetDate != null ? resetDate.hashCode() : 0);
			_result = 31 * _result + (adjustedFixingDate != null ? adjustedFixingDate.hashCode() : 0);
			_result = 31 * _result + (observedRate != null ? observedRate.hashCode() : 0);
			_result = 31 * _result + (treatedRate != null ? treatedRate.hashCode() : 0);
			_result = 31 * _result + (observationWeight != null ? observationWeight.hashCode() : 0);
			_result = 31 * _result + (rateReference != null ? rateReference.hashCode() : 0);
			_result = 31 * _result + (forecastRate != null ? forecastRate.hashCode() : 0);
			_result = 31 * _result + (treatedForecastRate != null ? treatedForecastRate.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateObservationBuilder {" +
				"resetDate=" + this.resetDate + ", " +
				"adjustedFixingDate=" + this.adjustedFixingDate + ", " +
				"observedRate=" + this.observedRate + ", " +
				"treatedRate=" + this.treatedRate + ", " +
				"observationWeight=" + this.observationWeight + ", " +
				"rateReference=" + this.rateReference + ", " +
				"forecastRate=" + this.forecastRate + ", " +
				"treatedForecastRate=" + this.treatedForecastRate + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

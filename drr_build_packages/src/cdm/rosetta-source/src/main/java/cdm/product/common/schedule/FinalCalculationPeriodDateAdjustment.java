package cdm.product.common.schedule;

import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.metafields.ReferenceWithMetaAdjustableOrRelativeDates;
import cdm.product.common.schedule.meta.FinalCalculationPeriodDateAdjustmentMeta;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
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
 * A data to:  define business date convention adjustment to final payment period per leg.
 * @version 6.23.0
 */
@RosettaDataType(value="FinalCalculationPeriodDateAdjustment", builder=FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FinalCalculationPeriodDateAdjustment", model="cdm", builder=FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl.class, version="6.23.0")
public interface FinalCalculationPeriodDateAdjustment extends RosettaModelObject {

	FinalCalculationPeriodDateAdjustmentMeta metaData = new FinalCalculationPeriodDateAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the unadjusted cancellation effective dates.
	 */
	ReferenceWithMetaAdjustableOrRelativeDates getRelevantUnderlyingDateReference();
	/**
	 * Reference to the leg, where date adjustments may apply.
	 */
	ReferenceWithMetaPayout getSwapStreamReference();
	/**
	 * Override business date convention. This takes precedence over leg level information.
	 */
	BusinessDayConventionEnum getBusinessDayConvention();

	/*********************** Build Methods  ***********************/
	FinalCalculationPeriodDateAdjustment build();
	
	FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder();
	
	static FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder() {
		return new FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinalCalculationPeriodDateAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinalCalculationPeriodDateAdjustment> getType() {
		return FinalCalculationPeriodDateAdjustment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relevantUnderlyingDateReference"), processor, ReferenceWithMetaAdjustableOrRelativeDates.class, getRelevantUnderlyingDateReference());
		processRosetta(path.newSubPath("swapStreamReference"), processor, ReferenceWithMetaPayout.class, getSwapStreamReference());
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinalCalculationPeriodDateAdjustmentBuilder extends FinalCalculationPeriodDateAdjustment, RosettaModelObjectBuilder {
		ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDateReference();
		@Override
		ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder getRelevantUnderlyingDateReference();
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreateSwapStreamReference();
		@Override
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getSwapStreamReference();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReference(ReferenceWithMetaAdjustableOrRelativeDates relevantUnderlyingDateReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReferenceValue(AdjustableOrRelativeDates relevantUnderlyingDateReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReference(ReferenceWithMetaPayout swapStreamReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReferenceValue(Payout swapStreamReference);
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relevantUnderlyingDateReference"), processor, ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDateReference());
			processRosetta(path.newSubPath("swapStreamReference"), processor, ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder.class, getSwapStreamReference());
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		}
		

		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of FinalCalculationPeriodDateAdjustment  ***********************/
	class FinalCalculationPeriodDateAdjustmentImpl implements FinalCalculationPeriodDateAdjustment {
		private final ReferenceWithMetaAdjustableOrRelativeDates relevantUnderlyingDateReference;
		private final ReferenceWithMetaPayout swapStreamReference;
		private final BusinessDayConventionEnum businessDayConvention;
		
		protected FinalCalculationPeriodDateAdjustmentImpl(FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder) {
			this.relevantUnderlyingDateReference = ofNullable(builder.getRelevantUnderlyingDateReference()).map(f->f.build()).orElse(null);
			this.swapStreamReference = ofNullable(builder.getSwapStreamReference()).map(f->f.build()).orElse(null);
			this.businessDayConvention = builder.getBusinessDayConvention();
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDateReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("relevantUnderlyingDateReference")
		public ReferenceWithMetaAdjustableOrRelativeDates getRelevantUnderlyingDateReference() {
			return relevantUnderlyingDateReference;
		}
		
		@Override
		@RosettaAttribute("swapStreamReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("swapStreamReference")
		public ReferenceWithMetaPayout getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment build() {
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder() {
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder builder) {
			ofNullable(getRelevantUnderlyingDateReference()).ifPresent(builder::setRelevantUnderlyingDateReference);
			ofNullable(getSwapStreamReference()).ifPresent(builder::setSwapStreamReference);
			ofNullable(getBusinessDayConvention()).ifPresent(builder::setBusinessDayConvention);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalCalculationPeriodDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(relevantUnderlyingDateReference, _that.getRelevantUnderlyingDateReference())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relevantUnderlyingDateReference != null ? relevantUnderlyingDateReference.hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalCalculationPeriodDateAdjustment {" +
				"relevantUnderlyingDateReference=" + this.relevantUnderlyingDateReference + ", " +
				"swapStreamReference=" + this.swapStreamReference + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}';
		}
	}

	/*********************** Builder Implementation of FinalCalculationPeriodDateAdjustment  ***********************/
	class FinalCalculationPeriodDateAdjustmentBuilderImpl implements FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder {
	
		protected ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder relevantUnderlyingDateReference;
		protected ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder swapStreamReference;
		protected BusinessDayConventionEnum businessDayConvention;
		
		@Override
		@RosettaAttribute("relevantUnderlyingDateReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("relevantUnderlyingDateReference")
		public ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder getRelevantUnderlyingDateReference() {
			return relevantUnderlyingDateReference;
		}
		
		@Override
		public ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDateReference() {
			ReferenceWithMetaAdjustableOrRelativeDates.ReferenceWithMetaAdjustableOrRelativeDatesBuilder result;
			if (relevantUnderlyingDateReference!=null) {
				result = relevantUnderlyingDateReference;
			}
			else {
				result = relevantUnderlyingDateReference = ReferenceWithMetaAdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("swapStreamReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("swapStreamReference")
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreateSwapStreamReference() {
			ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder result;
			if (swapStreamReference!=null) {
				result = swapStreamReference;
			}
			else {
				result = swapStreamReference = ReferenceWithMetaPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("businessDayConvention")
		public BusinessDayConventionEnum getBusinessDayConvention() {
			return businessDayConvention;
		}
		
		@RosettaAttribute("relevantUnderlyingDateReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("relevantUnderlyingDateReference")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReference(ReferenceWithMetaAdjustableOrRelativeDates _relevantUnderlyingDateReference) {
			this.relevantUnderlyingDateReference = _relevantUnderlyingDateReference == null ? null : _relevantUnderlyingDateReference.toBuilder();
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setRelevantUnderlyingDateReferenceValue(AdjustableOrRelativeDates _relevantUnderlyingDateReference) {
			this.getOrCreateRelevantUnderlyingDateReference().setValue(_relevantUnderlyingDateReference);
			return this;
		}
		
		@RosettaAttribute("swapStreamReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("swapStreamReference")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReference(ReferenceWithMetaPayout _swapStreamReference) {
			this.swapStreamReference = _swapStreamReference == null ? null : _swapStreamReference.toBuilder();
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setSwapStreamReferenceValue(Payout _swapStreamReference) {
			this.getOrCreateSwapStreamReference().setValue(_swapStreamReference);
			return this;
		}
		
		@RosettaAttribute("businessDayConvention")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("businessDayConvention")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder setBusinessDayConvention(BusinessDayConventionEnum _businessDayConvention) {
			this.businessDayConvention = _businessDayConvention == null ? null : _businessDayConvention;
			return this;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment build() {
			return new FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentImpl(this);
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder prune() {
			if (relevantUnderlyingDateReference!=null && !relevantUnderlyingDateReference.prune().hasData()) relevantUnderlyingDateReference = null;
			if (swapStreamReference!=null && !swapStreamReference.prune().hasData()) swapStreamReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelevantUnderlyingDateReference()!=null && getRelevantUnderlyingDateReference().hasData()) return true;
			if (getSwapStreamReference()!=null && getSwapStreamReference().hasData()) return true;
			if (getBusinessDayConvention()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder o = (FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder) other;
			
			merger.mergeRosetta(getRelevantUnderlyingDateReference(), o.getRelevantUnderlyingDateReference(), this::setRelevantUnderlyingDateReference);
			merger.mergeRosetta(getSwapStreamReference(), o.getSwapStreamReference(), this::setSwapStreamReference);
			
			merger.mergeBasic(getBusinessDayConvention(), o.getBusinessDayConvention(), this::setBusinessDayConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalCalculationPeriodDateAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(relevantUnderlyingDateReference, _that.getRelevantUnderlyingDateReference())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			if (!Objects.equals(businessDayConvention, _that.getBusinessDayConvention())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relevantUnderlyingDateReference != null ? relevantUnderlyingDateReference.hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			_result = 31 * _result + (businessDayConvention != null ? businessDayConvention.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalCalculationPeriodDateAdjustmentBuilder {" +
				"relevantUnderlyingDateReference=" + this.relevantUnderlyingDateReference + ", " +
				"swapStreamReference=" + this.swapStreamReference + ", " +
				"businessDayConvention=" + this.businessDayConvention +
			'}';
		}
	}
}

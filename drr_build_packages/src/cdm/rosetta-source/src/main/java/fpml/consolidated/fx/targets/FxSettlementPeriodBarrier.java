package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxSettlementPeriodBarrierMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxSettlementPeriodBarrier", builder=FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxSettlementPeriodBarrier", model="fpml", builder=FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilderImpl.class, version="2.1.1")
public interface FxSettlementPeriodBarrier extends RosettaModelObject {

	FxSettlementPeriodBarrierMeta metaData = new FxSettlementPeriodBarrierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the barrier structure within the parametric representation of the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the barrier structure within the parametric representation of the product.
	 *
	 */
	FxComplexBarrierBaseReference getBarrierReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Barrier trigger rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Barrier trigger rate.
	 *
	 */
	BigDecimal getTriggerRate();

	/*********************** Build Methods  ***********************/
	FxSettlementPeriodBarrier build();
	
	FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder toBuilder();
	
	static FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder() {
		return new FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSettlementPeriodBarrier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxSettlementPeriodBarrier> getType() {
		return FxSettlementPeriodBarrier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.class, getBarrierReference());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSettlementPeriodBarrierBuilder extends FxSettlementPeriodBarrier, RosettaModelObjectBuilder {
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference();
		@Override
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference();
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference);
		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setTriggerRate(BigDecimal triggerRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder.class, getBarrierReference());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		}
		

		FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder prune();
	}

	/*********************** Immutable Implementation of FxSettlementPeriodBarrier  ***********************/
	class FxSettlementPeriodBarrierImpl implements FxSettlementPeriodBarrier {
		private final FxComplexBarrierBaseReference barrierReference;
		private final BigDecimal triggerRate;
		
		protected FxSettlementPeriodBarrierImpl(FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder) {
			this.barrierReference = ofNullable(builder.getBarrierReference()).map(f->f.build()).orElse(null);
			this.triggerRate = builder.getTriggerRate();
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierReference")
		public FxComplexBarrierBaseReference getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@Override
		public FxSettlementPeriodBarrier build() {
			return this;
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder toBuilder() {
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder builder) {
			ofNullable(getBarrierReference()).ifPresent(builder::setBarrierReference);
			ofNullable(getTriggerRate()).ifPresent(builder::setTriggerRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementPeriodBarrier _that = getType().cast(o);
		
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementPeriodBarrier {" +
				"barrierReference=" + this.barrierReference + ", " +
				"triggerRate=" + this.triggerRate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSettlementPeriodBarrier  ***********************/
	class FxSettlementPeriodBarrierBuilderImpl implements FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder {
	
		protected FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder barrierReference;
		protected BigDecimal triggerRate;
		
		@Override
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierReference")
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference() {
			FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder result;
			if (barrierReference!=null) {
				result = barrierReference;
			}
			else {
				result = barrierReference = FxComplexBarrierBaseReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("triggerRate")
		public BigDecimal getTriggerRate() {
			return triggerRate;
		}
		
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierReference")
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setBarrierReference(FxComplexBarrierBaseReference _barrierReference) {
			this.barrierReference = _barrierReference == null ? null : _barrierReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerRate")
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@Override
		public FxSettlementPeriodBarrier build() {
			return new FxSettlementPeriodBarrier.FxSettlementPeriodBarrierImpl(this);
		}
		
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder prune() {
			if (barrierReference!=null && !barrierReference.prune().hasData()) barrierReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBarrierReference()!=null && getBarrierReference().hasData()) return true;
			if (getTriggerRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder o = (FxSettlementPeriodBarrier.FxSettlementPeriodBarrierBuilder) other;
			
			merger.mergeRosetta(getBarrierReference(), o.getBarrierReference(), this::setBarrierReference);
			
			merger.mergeBasic(getTriggerRate(), o.getTriggerRate(), this::setTriggerRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementPeriodBarrier _that = getType().cast(o);
		
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(triggerRate, _that.getTriggerRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (triggerRate != null ? triggerRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementPeriodBarrierBuilder {" +
				"barrierReference=" + this.barrierReference + ", " +
				"triggerRate=" + this.triggerRate +
			'}';
		}
	}
}

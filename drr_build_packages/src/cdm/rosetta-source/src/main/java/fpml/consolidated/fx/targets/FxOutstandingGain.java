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
import fpml.consolidated.fpmlenum.FxSettlementAdjustmentMethodEnum;
import fpml.consolidated.fx.targets.meta.FxOutstandingGainMeta;
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
@RosettaDataType(value="FxOutstandingGain", builder=FxOutstandingGain.FxOutstandingGainBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxOutstandingGain", model="fpml", builder=FxOutstandingGain.FxOutstandingGainBuilderImpl.class, version="2.1.1")
public interface FxOutstandingGain extends RosettaModelObject {

	FxOutstandingGainMeta metaData = new FxOutstandingGainMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a target structure within the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a target structure within the product.
	 *
	 */
	FxTargetReference getTargetReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Settlement Adjustment Style can be VariedStrike or VariedNotional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Settlement Adjustment Style can be VariedStrike or VariedNotional.
	 *
	 */
	FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle();

	/*********************** Build Methods  ***********************/
	FxOutstandingGain build();
	
	FxOutstandingGain.FxOutstandingGainBuilder toBuilder();
	
	static FxOutstandingGain.FxOutstandingGainBuilder builder() {
		return new FxOutstandingGain.FxOutstandingGainBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOutstandingGain> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxOutstandingGain> getType() {
		return FxOutstandingGain.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("targetReference"), processor, FxTargetReference.class, getTargetReference());
		processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOutstandingGainBuilder extends FxOutstandingGain, RosettaModelObjectBuilder {
		FxTargetReference.FxTargetReferenceBuilder getOrCreateTargetReference();
		@Override
		FxTargetReference.FxTargetReferenceBuilder getTargetReference();
		FxOutstandingGain.FxOutstandingGainBuilder setTargetReference(FxTargetReference targetReference);
		FxOutstandingGain.FxOutstandingGainBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("targetReference"), processor, FxTargetReference.FxTargetReferenceBuilder.class, getTargetReference());
			processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
		}
		

		FxOutstandingGain.FxOutstandingGainBuilder prune();
	}

	/*********************** Immutable Implementation of FxOutstandingGain  ***********************/
	class FxOutstandingGainImpl implements FxOutstandingGain {
		private final FxTargetReference targetReference;
		private final FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		
		protected FxOutstandingGainImpl(FxOutstandingGain.FxOutstandingGainBuilder builder) {
			this.targetReference = ofNullable(builder.getTargetReference()).map(f->f.build()).orElse(null);
			this.settlementAdjustmentStyle = builder.getSettlementAdjustmentStyle();
		}
		
		@Override
		@RosettaAttribute("targetReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("targetReference")
		public FxTargetReference getTargetReference() {
			return targetReference;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		public FxOutstandingGain build() {
			return this;
		}
		
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder toBuilder() {
			FxOutstandingGain.FxOutstandingGainBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOutstandingGain.FxOutstandingGainBuilder builder) {
			ofNullable(getTargetReference()).ifPresent(builder::setTargetReference);
			ofNullable(getSettlementAdjustmentStyle()).ifPresent(builder::setSettlementAdjustmentStyle);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOutstandingGain _that = getType().cast(o);
		
			if (!Objects.equals(targetReference, _that.getTargetReference())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (targetReference != null ? targetReference.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOutstandingGain {" +
				"targetReference=" + this.targetReference + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}

	/*********************** Builder Implementation of FxOutstandingGain  ***********************/
	class FxOutstandingGainBuilderImpl implements FxOutstandingGain.FxOutstandingGainBuilder {
	
		protected FxTargetReference.FxTargetReferenceBuilder targetReference;
		protected FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		
		@Override
		@RosettaAttribute("targetReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("targetReference")
		public FxTargetReference.FxTargetReferenceBuilder getTargetReference() {
			return targetReference;
		}
		
		@Override
		public FxTargetReference.FxTargetReferenceBuilder getOrCreateTargetReference() {
			FxTargetReference.FxTargetReferenceBuilder result;
			if (targetReference!=null) {
				result = targetReference;
			}
			else {
				result = targetReference = FxTargetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@RosettaAttribute("targetReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("targetReference")
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder setTargetReference(FxTargetReference _targetReference) {
			this.targetReference = _targetReference == null ? null : _targetReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementAdjustmentStyle")
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum _settlementAdjustmentStyle) {
			this.settlementAdjustmentStyle = _settlementAdjustmentStyle == null ? null : _settlementAdjustmentStyle;
			return this;
		}
		
		@Override
		public FxOutstandingGain build() {
			return new FxOutstandingGain.FxOutstandingGainImpl(this);
		}
		
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder prune() {
			if (targetReference!=null && !targetReference.prune().hasData()) targetReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTargetReference()!=null && getTargetReference().hasData()) return true;
			if (getSettlementAdjustmentStyle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOutstandingGain.FxOutstandingGainBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxOutstandingGain.FxOutstandingGainBuilder o = (FxOutstandingGain.FxOutstandingGainBuilder) other;
			
			merger.mergeRosetta(getTargetReference(), o.getTargetReference(), this::setTargetReference);
			
			merger.mergeBasic(getSettlementAdjustmentStyle(), o.getSettlementAdjustmentStyle(), this::setSettlementAdjustmentStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOutstandingGain _that = getType().cast(o);
		
			if (!Objects.equals(targetReference, _that.getTargetReference())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (targetReference != null ? targetReference.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOutstandingGainBuilder {" +
				"targetReference=" + this.targetReference + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}
}

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
import fpml.consolidated.fx.targets.meta.FxTargetPhysicalSettlementMeta;
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
@RosettaDataType(value="FxTargetPhysicalSettlement", builder=FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetPhysicalSettlement", model="fpml", builder=FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilderImpl.class, version="2.1.1")
public interface FxTargetPhysicalSettlement extends RosettaModelObject {

	FxTargetPhysicalSettlementMeta metaData = new FxTargetPhysicalSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the first direction of who pays and receives a specific currency without specifying the amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the first direction of who pays and receives a specific currency without specifying the amount.
	 *
	 */
	FxExchangedCurrency getExchangedCurrency1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the second direction of who pays and receives a specific currency without specifying the amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the second direction of who pays and receives a specific currency without specifying the amount.
	 *
	 */
	FxExchangedCurrency getExchangedCurrency2();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Strike price of the Target.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Strike price of the Target.
	 *
	 */
	FxStrike getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an existing strike structure within the FX product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an existing strike structure within the FX product.
	 *
	 */
	FxStrikeReference getStrikeReference();

	/*********************** Build Methods  ***********************/
	FxTargetPhysicalSettlement build();
	
	FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder toBuilder();
	
	static FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder() {
		return new FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetPhysicalSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetPhysicalSettlement> getType() {
		return FxTargetPhysicalSettlement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exchangedCurrency1"), processor, FxExchangedCurrency.class, getExchangedCurrency1());
		processRosetta(path.newSubPath("exchangedCurrency2"), processor, FxExchangedCurrency.class, getExchangedCurrency2());
		processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
		processRosetta(path.newSubPath("strike"), processor, FxStrike.class, getStrike());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetPhysicalSettlementBuilder extends FxTargetPhysicalSettlement, RosettaModelObjectBuilder {
		FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency1();
		@Override
		FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency1();
		FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency2();
		@Override
		FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency2();
		FxStrike.FxStrikeBuilder getOrCreateStrike();
		@Override
		FxStrike.FxStrikeBuilder getStrike();
		FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference();
		@Override
		FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference();
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setExchangedCurrency1(FxExchangedCurrency exchangedCurrency1);
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setExchangedCurrency2(FxExchangedCurrency exchangedCurrency2);
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle);
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setStrike(FxStrike strike);
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setStrikeReference(FxStrikeReference strikeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exchangedCurrency1"), processor, FxExchangedCurrency.FxExchangedCurrencyBuilder.class, getExchangedCurrency1());
			processRosetta(path.newSubPath("exchangedCurrency2"), processor, FxExchangedCurrency.FxExchangedCurrencyBuilder.class, getExchangedCurrency2());
			processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
			processRosetta(path.newSubPath("strike"), processor, FxStrike.FxStrikeBuilder.class, getStrike());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
		}
		

		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetPhysicalSettlement  ***********************/
	class FxTargetPhysicalSettlementImpl implements FxTargetPhysicalSettlement {
		private final FxExchangedCurrency exchangedCurrency1;
		private final FxExchangedCurrency exchangedCurrency2;
		private final FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		private final FxStrike strike;
		private final FxStrikeReference strikeReference;
		
		protected FxTargetPhysicalSettlementImpl(FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder) {
			this.exchangedCurrency1 = ofNullable(builder.getExchangedCurrency1()).map(f->f.build()).orElse(null);
			this.exchangedCurrency2 = ofNullable(builder.getExchangedCurrency2()).map(f->f.build()).orElse(null);
			this.settlementAdjustmentStyle = builder.getSettlementAdjustmentStyle();
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		public FxExchangedCurrency getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		public FxExchangedCurrency getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public FxStrike getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxTargetPhysicalSettlement build() {
			return this;
		}
		
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder toBuilder() {
			FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder builder) {
			ofNullable(getExchangedCurrency1()).ifPresent(builder::setExchangedCurrency1);
			ofNullable(getExchangedCurrency2()).ifPresent(builder::setExchangedCurrency2);
			ofNullable(getSettlementAdjustmentStyle()).ifPresent(builder::setSettlementAdjustmentStyle);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetPhysicalSettlement {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle + ", " +
				"strike=" + this.strike + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetPhysicalSettlement  ***********************/
	class FxTargetPhysicalSettlementBuilderImpl implements FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder {
	
		protected FxExchangedCurrency.FxExchangedCurrencyBuilder exchangedCurrency1;
		protected FxExchangedCurrency.FxExchangedCurrencyBuilder exchangedCurrency2;
		protected FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		protected FxStrike.FxStrikeBuilder strike;
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency1() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder result;
			if (exchangedCurrency1!=null) {
				result = exchangedCurrency1;
			}
			else {
				result = exchangedCurrency1 = FxExchangedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency2() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder result;
			if (exchangedCurrency2!=null) {
				result = exchangedCurrency2;
			}
			else {
				result = exchangedCurrency2 = FxExchangedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public FxStrike.FxStrikeBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxStrike.FxStrikeBuilder getOrCreateStrike() {
			FxStrike.FxStrikeBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxStrikeReference.FxStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxStrikeReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setExchangedCurrency1(FxExchangedCurrency _exchangedCurrency1) {
			this.exchangedCurrency1 = _exchangedCurrency1 == null ? null : _exchangedCurrency1.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setExchangedCurrency2(FxExchangedCurrency _exchangedCurrency2) {
			this.exchangedCurrency2 = _exchangedCurrency2 == null ? null : _exchangedCurrency2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementAdjustmentStyle")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum _settlementAdjustmentStyle) {
			this.settlementAdjustmentStyle = _settlementAdjustmentStyle == null ? null : _settlementAdjustmentStyle;
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setStrike(FxStrike _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder setStrikeReference(FxStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetPhysicalSettlement build() {
			return new FxTargetPhysicalSettlement.FxTargetPhysicalSettlementImpl(this);
		}
		
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder prune() {
			if (exchangedCurrency1!=null && !exchangedCurrency1.prune().hasData()) exchangedCurrency1 = null;
			if (exchangedCurrency2!=null && !exchangedCurrency2.prune().hasData()) exchangedCurrency2 = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExchangedCurrency1()!=null && getExchangedCurrency1().hasData()) return true;
			if (getExchangedCurrency2()!=null && getExchangedCurrency2().hasData()) return true;
			if (getSettlementAdjustmentStyle()!=null) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder o = (FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder) other;
			
			merger.mergeRosetta(getExchangedCurrency1(), o.getExchangedCurrency1(), this::setExchangedCurrency1);
			merger.mergeRosetta(getExchangedCurrency2(), o.getExchangedCurrency2(), this::setExchangedCurrency2);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			
			merger.mergeBasic(getSettlementAdjustmentStyle(), o.getSettlementAdjustmentStyle(), this::setSettlementAdjustmentStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetPhysicalSettlementBuilder {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle + ", " +
				"strike=" + this.strike + ", " +
				"strikeReference=" + this.strikeReference +
			'}';
		}
	}
}

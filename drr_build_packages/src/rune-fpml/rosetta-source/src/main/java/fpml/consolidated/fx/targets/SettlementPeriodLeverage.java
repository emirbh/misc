package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.SettlementPeriodLeverageMeta;
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
@RosettaDataType(value="SettlementPeriodLeverage", builder=SettlementPeriodLeverage.SettlementPeriodLeverageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriodLeverage", model="fpml", builder=SettlementPeriodLeverage.SettlementPeriodLeverageBuilderImpl.class, version="2.1.1")
public interface SettlementPeriodLeverage extends RosettaModelObject {

	SettlementPeriodLeverageMeta metaData = new SettlementPeriodLeverageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Leverage expressed as ratio.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leverage expressed as ratio.
	 *
	 */
	BigDecimal getRatio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Leverage notional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leverage notional.
	 *
	 */
	BigDecimal getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Leverage counter currency notional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leverage counter currency notional.
	 *
	 */
	BigDecimal getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	SettlementPeriodLeverage build();
	
	SettlementPeriodLeverage.SettlementPeriodLeverageBuilder toBuilder();
	
	static SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder() {
		return new SettlementPeriodLeverage.SettlementPeriodLeverageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodLeverage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriodLeverage> getType() {
		return SettlementPeriodLeverage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ratio"), BigDecimal.class, getRatio(), this);
		processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
		processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodLeverageBuilder extends SettlementPeriodLeverage, RosettaModelObjectBuilder {
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setRatio(BigDecimal ratio);
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setNotionalAmount(BigDecimal notionalAmount);
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ratio"), BigDecimal.class, getRatio(), this);
			processor.processBasic(path.newSubPath("notionalAmount"), BigDecimal.class, getNotionalAmount(), this);
			processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
		}
		

		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodLeverage  ***********************/
	class SettlementPeriodLeverageImpl implements SettlementPeriodLeverage {
		private final BigDecimal ratio;
		private final BigDecimal notionalAmount;
		private final BigDecimal counterCurrencyAmount;
		
		protected SettlementPeriodLeverageImpl(SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder) {
			this.ratio = builder.getRatio();
			this.notionalAmount = builder.getNotionalAmount();
			this.counterCurrencyAmount = builder.getCounterCurrencyAmount();
		}
		
		@Override
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratio")
		public BigDecimal getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public SettlementPeriodLeverage build() {
			return this;
		}
		
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder toBuilder() {
			SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodLeverage.SettlementPeriodLeverageBuilder builder) {
			ofNullable(getRatio()).ifPresent(builder::setRatio);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodLeverage _that = getType().cast(o);
		
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodLeverage {" +
				"ratio=" + this.ratio + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodLeverage  ***********************/
	class SettlementPeriodLeverageBuilderImpl implements SettlementPeriodLeverage.SettlementPeriodLeverageBuilder {
	
		protected BigDecimal ratio;
		protected BigDecimal notionalAmount;
		protected BigDecimal counterCurrencyAmount;
		
		@Override
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratio")
		public BigDecimal getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public BigDecimal getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratio")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setRatio(BigDecimal _ratio) {
			this.ratio = _ratio == null ? null : _ratio;
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setNotionalAmount(BigDecimal _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount;
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder setCounterCurrencyAmount(BigDecimal _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount;
			return this;
		}
		
		@Override
		public SettlementPeriodLeverage build() {
			return new SettlementPeriodLeverage.SettlementPeriodLeverageImpl(this);
		}
		
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRatio()!=null) return true;
			if (getNotionalAmount()!=null) return true;
			if (getCounterCurrencyAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodLeverage.SettlementPeriodLeverageBuilder o = (SettlementPeriodLeverage.SettlementPeriodLeverageBuilder) other;
			
			
			merger.mergeBasic(getRatio(), o.getRatio(), this::setRatio);
			merger.mergeBasic(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeBasic(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodLeverage _that = getType().cast(o);
		
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodLeverageBuilder {" +
				"ratio=" + this.ratio + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}

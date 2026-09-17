package cdm.legaldocumentation.csa;

import cdm.base.math.RoundingModeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.legaldocumentation.csa.meta.CollateralRoundingMeta;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the rounding methodology applicable to the Delivery Amount and the Return Amount.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)(vi)( C )" * name "Rounding"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(vi)( C )" * name "Rounding"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)(vi)( C )" * name "Rounding"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CollateralRounding", builder=CollateralRounding.CollateralRoundingBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralRounding", model="cdm", builder=CollateralRounding.CollateralRoundingBuilderImpl.class, version="6.23.0")
public interface CollateralRounding extends RosettaModelObject {

	CollateralRoundingMeta metaData = new CollateralRoundingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The nearest integral multiple of Base Currency units to which the Delivery Amount will be rounded in accordance with the specified rounding direction.
	 */
	BigDecimal getDeliveryAmount();
	/**
	 * The rounding rule applicable to the Delivery Amount (which can be (i) up to nearest; (ii) down to nearest).
	 */
	RoundingModeEnum getDeliveryDirection();
	/**
	 * The nearest integral multiple of Base Currency units to which the Return Amount will be rounded in accordance with the specified rounding direction.
	 */
	BigDecimal getReturnAmount();
	/**
	 * The rounding rule applicable to the Return Amount (which can be (i) up to nearest; (ii) down to nearest).
	 */
	RoundingModeEnum getReturnDirection();
	/**
	 * The currency in which the Delivery Amount and Return Amount rounding amounts are specified.
	 */
	ISOCurrencyCodeEnum getCurrency();
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	String getOther();

	/*********************** Build Methods  ***********************/
	CollateralRounding build();
	
	CollateralRounding.CollateralRoundingBuilder toBuilder();
	
	static CollateralRounding.CollateralRoundingBuilder builder() {
		return new CollateralRounding.CollateralRoundingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralRounding> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralRounding> getType() {
		return CollateralRounding.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryAmount"), BigDecimal.class, getDeliveryAmount(), this);
		processor.processBasic(path.newSubPath("deliveryDirection"), RoundingModeEnum.class, getDeliveryDirection(), this);
		processor.processBasic(path.newSubPath("returnAmount"), BigDecimal.class, getReturnAmount(), this);
		processor.processBasic(path.newSubPath("returnDirection"), RoundingModeEnum.class, getReturnDirection(), this);
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralRoundingBuilder extends CollateralRounding, RosettaModelObjectBuilder {
		CollateralRounding.CollateralRoundingBuilder setDeliveryAmount(BigDecimal deliveryAmount);
		CollateralRounding.CollateralRoundingBuilder setDeliveryDirection(RoundingModeEnum deliveryDirection);
		CollateralRounding.CollateralRoundingBuilder setReturnAmount(BigDecimal returnAmount);
		CollateralRounding.CollateralRoundingBuilder setReturnDirection(RoundingModeEnum returnDirection);
		CollateralRounding.CollateralRoundingBuilder setCurrency(ISOCurrencyCodeEnum currency);
		CollateralRounding.CollateralRoundingBuilder setOther(String other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("deliveryAmount"), BigDecimal.class, getDeliveryAmount(), this);
			processor.processBasic(path.newSubPath("deliveryDirection"), RoundingModeEnum.class, getDeliveryDirection(), this);
			processor.processBasic(path.newSubPath("returnAmount"), BigDecimal.class, getReturnAmount(), this);
			processor.processBasic(path.newSubPath("returnDirection"), RoundingModeEnum.class, getReturnDirection(), this);
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
			processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
		}
		

		CollateralRounding.CollateralRoundingBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralRounding  ***********************/
	class CollateralRoundingImpl implements CollateralRounding {
		private final BigDecimal deliveryAmount;
		private final RoundingModeEnum deliveryDirection;
		private final BigDecimal returnAmount;
		private final RoundingModeEnum returnDirection;
		private final ISOCurrencyCodeEnum currency;
		private final String other;
		
		protected CollateralRoundingImpl(CollateralRounding.CollateralRoundingBuilder builder) {
			this.deliveryAmount = builder.getDeliveryAmount();
			this.deliveryDirection = builder.getDeliveryDirection();
			this.returnAmount = builder.getReturnAmount();
			this.returnDirection = builder.getReturnDirection();
			this.currency = builder.getCurrency();
			this.other = builder.getOther();
		}
		
		@Override
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryAmount")
		public BigDecimal getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		@RosettaAttribute("deliveryDirection")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryDirection")
		public RoundingModeEnum getDeliveryDirection() {
			return deliveryDirection;
		}
		
		@Override
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnAmount")
		public BigDecimal getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		@RosettaAttribute("returnDirection")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnDirection")
		public RoundingModeEnum getReturnDirection() {
			return returnDirection;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@Override
		public CollateralRounding build() {
			return this;
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder toBuilder() {
			CollateralRounding.CollateralRoundingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralRounding.CollateralRoundingBuilder builder) {
			ofNullable(getDeliveryAmount()).ifPresent(builder::setDeliveryAmount);
			ofNullable(getDeliveryDirection()).ifPresent(builder::setDeliveryDirection);
			ofNullable(getReturnAmount()).ifPresent(builder::setReturnAmount);
			ofNullable(getReturnDirection()).ifPresent(builder::setReturnDirection);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralRounding _that = getType().cast(o);
		
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(deliveryDirection, _that.getDeliveryDirection())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(returnDirection, _that.getReturnDirection())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (deliveryDirection != null ? deliveryDirection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (returnDirection != null ? returnDirection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralRounding {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"deliveryDirection=" + this.deliveryDirection + ", " +
				"returnAmount=" + this.returnAmount + ", " +
				"returnDirection=" + this.returnDirection + ", " +
				"currency=" + this.currency + ", " +
				"other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralRounding  ***********************/
	class CollateralRoundingBuilderImpl implements CollateralRounding.CollateralRoundingBuilder {
	
		protected BigDecimal deliveryAmount;
		protected RoundingModeEnum deliveryDirection;
		protected BigDecimal returnAmount;
		protected RoundingModeEnum returnDirection;
		protected ISOCurrencyCodeEnum currency;
		protected String other;
		
		@Override
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryAmount")
		public BigDecimal getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		@RosettaAttribute("deliveryDirection")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryDirection")
		public RoundingModeEnum getDeliveryDirection() {
			return deliveryDirection;
		}
		
		@Override
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnAmount")
		public BigDecimal getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		@RosettaAttribute("returnDirection")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnDirection")
		public RoundingModeEnum getReturnDirection() {
			return returnDirection;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryAmount")
		@Override
		public CollateralRounding.CollateralRoundingBuilder setDeliveryAmount(BigDecimal _deliveryAmount) {
			this.deliveryAmount = _deliveryAmount == null ? null : _deliveryAmount;
			return this;
		}
		
		@RosettaAttribute("deliveryDirection")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryDirection")
		@Override
		public CollateralRounding.CollateralRoundingBuilder setDeliveryDirection(RoundingModeEnum _deliveryDirection) {
			this.deliveryDirection = _deliveryDirection == null ? null : _deliveryDirection;
			return this;
		}
		
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("returnAmount")
		@Override
		public CollateralRounding.CollateralRoundingBuilder setReturnAmount(BigDecimal _returnAmount) {
			this.returnAmount = _returnAmount == null ? null : _returnAmount;
			return this;
		}
		
		@RosettaAttribute("returnDirection")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("returnDirection")
		@Override
		public CollateralRounding.CollateralRoundingBuilder setReturnDirection(RoundingModeEnum _returnDirection) {
			this.returnDirection = _returnDirection == null ? null : _returnDirection;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public CollateralRounding.CollateralRoundingBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("other")
		@Override
		public CollateralRounding.CollateralRoundingBuilder setOther(String _other) {
			this.other = _other == null ? null : _other;
			return this;
		}
		
		@Override
		public CollateralRounding build() {
			return new CollateralRounding.CollateralRoundingImpl(this);
		}
		
		@Override
		public CollateralRounding.CollateralRoundingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralRounding.CollateralRoundingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryAmount()!=null) return true;
			if (getDeliveryDirection()!=null) return true;
			if (getReturnAmount()!=null) return true;
			if (getReturnDirection()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getOther()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralRounding.CollateralRoundingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralRounding.CollateralRoundingBuilder o = (CollateralRounding.CollateralRoundingBuilder) other;
			
			
			merger.mergeBasic(getDeliveryAmount(), o.getDeliveryAmount(), this::setDeliveryAmount);
			merger.mergeBasic(getDeliveryDirection(), o.getDeliveryDirection(), this::setDeliveryDirection);
			merger.mergeBasic(getReturnAmount(), o.getReturnAmount(), this::setReturnAmount);
			merger.mergeBasic(getReturnDirection(), o.getReturnDirection(), this::setReturnDirection);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeBasic(getOther(), o.getOther(), this::setOther);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralRounding _that = getType().cast(o);
		
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			if (!Objects.equals(deliveryDirection, _that.getDeliveryDirection())) return false;
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(returnDirection, _that.getReturnDirection())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			_result = 31 * _result + (deliveryDirection != null ? deliveryDirection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (returnDirection != null ? returnDirection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralRoundingBuilder {" +
				"deliveryAmount=" + this.deliveryAmount + ", " +
				"deliveryDirection=" + this.deliveryDirection + ", " +
				"returnAmount=" + this.returnAmount + ", " +
				"returnDirection=" + this.returnDirection + ", " +
				"currency=" + this.currency + ", " +
				"other=" + this.other +
			'}';
		}
	}
}

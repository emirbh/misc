package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.ConstituentWeightMeta;
import fpml.consolidated.shared.Money;
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
 * Provision A type describing the weight of each of the underlyer constituent within the basket, either in absolute or relative terms.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the weight of each of the underlyer constituent within the basket, either in absolute or relative terms.
 *
 */
@RosettaDataType(value="ConstituentWeight", builder=ConstituentWeight.ConstituentWeightBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ConstituentWeight", model="fpml", builder=ConstituentWeight.ConstituentWeightBuilderImpl.class, version="2.1.1")
public interface ConstituentWeight extends RosettaModelObject {

	ConstituentWeightMeta metaData = new ConstituentWeightMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 *
	 */
	BigDecimal getOpenUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The relative weight of each respective basket constituent, expressed in percentage. A basket percentage of 5% would be represented as 0.05.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The relative weight of each respective basket constituent, expressed in percentage. A basket percentage of 5% would be represented as 0.05.
	 *
	 */
	BigDecimal getBasketPercentage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. The relative weight of each respective basket constituent, expressed as a monetary amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. The relative weight of each respective basket constituent, expressed as a monetary amount.
	 *
	 */
	Money getBasketAmount();

	/*********************** Build Methods  ***********************/
	ConstituentWeight build();
	
	ConstituentWeight.ConstituentWeightBuilder toBuilder();
	
	static ConstituentWeight.ConstituentWeightBuilder builder() {
		return new ConstituentWeight.ConstituentWeightBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConstituentWeight> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConstituentWeight> getType() {
		return ConstituentWeight.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
		processor.processBasic(path.newSubPath("basketPercentage"), BigDecimal.class, getBasketPercentage(), this);
		processRosetta(path.newSubPath("basketAmount"), processor, Money.class, getBasketAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConstituentWeightBuilder extends ConstituentWeight, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateBasketAmount();
		@Override
		Money.MoneyBuilder getBasketAmount();
		ConstituentWeight.ConstituentWeightBuilder setOpenUnits(BigDecimal openUnits);
		ConstituentWeight.ConstituentWeightBuilder setBasketPercentage(BigDecimal basketPercentage);
		ConstituentWeight.ConstituentWeightBuilder setBasketAmount(Money basketAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
			processor.processBasic(path.newSubPath("basketPercentage"), BigDecimal.class, getBasketPercentage(), this);
			processRosetta(path.newSubPath("basketAmount"), processor, Money.MoneyBuilder.class, getBasketAmount());
		}
		

		ConstituentWeight.ConstituentWeightBuilder prune();
	}

	/*********************** Immutable Implementation of ConstituentWeight  ***********************/
	class ConstituentWeightImpl implements ConstituentWeight {
		private final BigDecimal openUnits;
		private final BigDecimal basketPercentage;
		private final Money basketAmount;
		
		protected ConstituentWeightImpl(ConstituentWeight.ConstituentWeightBuilder builder) {
			this.openUnits = builder.getOpenUnits();
			this.basketPercentage = builder.getBasketPercentage();
			this.basketAmount = ofNullable(builder.getBasketAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("basketPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketPercentage")
		public BigDecimal getBasketPercentage() {
			return basketPercentage;
		}
		
		@Override
		@RosettaAttribute("basketAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketAmount")
		public Money getBasketAmount() {
			return basketAmount;
		}
		
		@Override
		public ConstituentWeight build() {
			return this;
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder toBuilder() {
			ConstituentWeight.ConstituentWeightBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConstituentWeight.ConstituentWeightBuilder builder) {
			ofNullable(getOpenUnits()).ifPresent(builder::setOpenUnits);
			ofNullable(getBasketPercentage()).ifPresent(builder::setBasketPercentage);
			ofNullable(getBasketAmount()).ifPresent(builder::setBasketAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConstituentWeight _that = getType().cast(o);
		
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!Objects.equals(basketPercentage, _that.getBasketPercentage())) return false;
			if (!Objects.equals(basketAmount, _that.getBasketAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (basketPercentage != null ? basketPercentage.hashCode() : 0);
			_result = 31 * _result + (basketAmount != null ? basketAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConstituentWeight {" +
				"openUnits=" + this.openUnits + ", " +
				"basketPercentage=" + this.basketPercentage + ", " +
				"basketAmount=" + this.basketAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of ConstituentWeight  ***********************/
	class ConstituentWeightBuilderImpl implements ConstituentWeight.ConstituentWeightBuilder {
	
		protected BigDecimal openUnits;
		protected BigDecimal basketPercentage;
		protected Money.MoneyBuilder basketAmount;
		
		@Override
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("basketPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketPercentage")
		public BigDecimal getBasketPercentage() {
			return basketPercentage;
		}
		
		@Override
		@RosettaAttribute("basketAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketAmount")
		public Money.MoneyBuilder getBasketAmount() {
			return basketAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateBasketAmount() {
			Money.MoneyBuilder result;
			if (basketAmount!=null) {
				result = basketAmount;
			}
			else {
				result = basketAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("openUnits")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder setOpenUnits(BigDecimal _openUnits) {
			this.openUnits = _openUnits == null ? null : _openUnits;
			return this;
		}
		
		@RosettaAttribute("basketPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketPercentage")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder setBasketPercentage(BigDecimal _basketPercentage) {
			this.basketPercentage = _basketPercentage == null ? null : _basketPercentage;
			return this;
		}
		
		@RosettaAttribute("basketAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketAmount")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder setBasketAmount(Money _basketAmount) {
			this.basketAmount = _basketAmount == null ? null : _basketAmount.toBuilder();
			return this;
		}
		
		@Override
		public ConstituentWeight build() {
			return new ConstituentWeight.ConstituentWeightImpl(this);
		}
		
		@Override
		public ConstituentWeight.ConstituentWeightBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder prune() {
			if (basketAmount!=null && !basketAmount.prune().hasData()) basketAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOpenUnits()!=null) return true;
			if (getBasketPercentage()!=null) return true;
			if (getBasketAmount()!=null && getBasketAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConstituentWeight.ConstituentWeightBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ConstituentWeight.ConstituentWeightBuilder o = (ConstituentWeight.ConstituentWeightBuilder) other;
			
			merger.mergeRosetta(getBasketAmount(), o.getBasketAmount(), this::setBasketAmount);
			
			merger.mergeBasic(getOpenUnits(), o.getOpenUnits(), this::setOpenUnits);
			merger.mergeBasic(getBasketPercentage(), o.getBasketPercentage(), this::setBasketPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ConstituentWeight _that = getType().cast(o);
		
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!Objects.equals(basketPercentage, _that.getBasketPercentage())) return false;
			if (!Objects.equals(basketAmount, _that.getBasketAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (basketPercentage != null ? basketPercentage.hashCode() : 0);
			_result = 31 * _result + (basketAmount != null ? basketAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConstituentWeightBuilder {" +
				"openUnits=" + this.openUnits + ", " +
				"basketPercentage=" + this.basketPercentage + ", " +
				"basketAmount=" + this.basketAmount +
			'}';
		}
	}
}

package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityNotionalAmountMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A complex type to specify the notional amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A complex type to specify the notional amount.
 *
 */
@RosettaDataType(value="CommodityNotionalAmount", builder=CommodityNotionalAmount.CommodityNotionalAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityNotionalAmount", model="fpml", builder=CommodityNotionalAmount.CommodityNotionalAmountBuilderImpl.class, version="2.1.1")
public interface CommodityNotionalAmount extends NonNegativeMoney {

	CommodityNotionalAmountMeta metaData = new CommodityNotionalAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element indicates whether the notional amount (or equivalent) is constant across each Calculation Period or whether the notional amount in each Calculation Period ("false") is the notional amount in the previous period multiplied by 1 + commodity index return in the current period ("true"). In cases where reinstementFeature = true the 'amount' element is the Initial Notional Amount (or equivalent).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element indicates whether the notional amount (or equivalent) is constant across each Calculation Period or whether the notional amount in each Calculation Period ("false") is the notional amount in the previous period multiplied by 1 + commodity index return in the current period ("true"). In cases where reinstementFeature = true the 'amount' element is the Initial Notional Amount (or equivalent).
	 *
	 */
	Boolean getReinvestmentFeature();

	/*********************** Build Methods  ***********************/
	CommodityNotionalAmount build();
	
	CommodityNotionalAmount.CommodityNotionalAmountBuilder toBuilder();
	
	static CommodityNotionalAmount.CommodityNotionalAmountBuilder builder() {
		return new CommodityNotionalAmount.CommodityNotionalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityNotionalAmount> getType() {
		return CommodityNotionalAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("reinvestmentFeature"), Boolean.class, getReinvestmentFeature(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalAmountBuilder extends CommodityNotionalAmount, NonNegativeMoney.NonNegativeMoneyBuilder {
		@Override
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setId(String id);
		@Override
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setCurrency(Currency currency);
		@Override
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setAmount(BigDecimal amount);
		CommodityNotionalAmount.CommodityNotionalAmountBuilder setReinvestmentFeature(Boolean reinvestmentFeature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("reinvestmentFeature"), Boolean.class, getReinvestmentFeature(), this);
		}
		

		CommodityNotionalAmount.CommodityNotionalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalAmount  ***********************/
	class CommodityNotionalAmountImpl extends NonNegativeMoney.NonNegativeMoneyImpl implements CommodityNotionalAmount {
		private final Boolean reinvestmentFeature;
		
		protected CommodityNotionalAmountImpl(CommodityNotionalAmount.CommodityNotionalAmountBuilder builder) {
			super(builder);
			this.reinvestmentFeature = builder.getReinvestmentFeature();
		}
		
		@Override
		@RosettaAttribute("reinvestmentFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reinvestmentFeature")
		public Boolean getReinvestmentFeature() {
			return reinvestmentFeature;
		}
		
		@Override
		public CommodityNotionalAmount build() {
			return this;
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder toBuilder() {
			CommodityNotionalAmount.CommodityNotionalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalAmount.CommodityNotionalAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReinvestmentFeature()).ifPresent(builder::setReinvestmentFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityNotionalAmount _that = getType().cast(o);
		
			if (!Objects.equals(reinvestmentFeature, _that.getReinvestmentFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reinvestmentFeature != null ? reinvestmentFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalAmount {" +
				"reinvestmentFeature=" + this.reinvestmentFeature +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityNotionalAmount  ***********************/
	class CommodityNotionalAmountBuilderImpl extends NonNegativeMoney.NonNegativeMoneyBuilderImpl implements CommodityNotionalAmount.CommodityNotionalAmountBuilder {
	
		protected Boolean reinvestmentFeature;
		
		@Override
		@RosettaAttribute("reinvestmentFeature")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reinvestmentFeature")
		public Boolean getReinvestmentFeature() {
			return reinvestmentFeature;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("reinvestmentFeature")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reinvestmentFeature")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder setReinvestmentFeature(Boolean _reinvestmentFeature) {
			this.reinvestmentFeature = _reinvestmentFeature == null ? null : _reinvestmentFeature;
			return this;
		}
		
		@Override
		public CommodityNotionalAmount build() {
			return new CommodityNotionalAmount.CommodityNotionalAmountImpl(this);
		}
		
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReinvestmentFeature()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalAmount.CommodityNotionalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityNotionalAmount.CommodityNotionalAmountBuilder o = (CommodityNotionalAmount.CommodityNotionalAmountBuilder) other;
			
			
			merger.mergeBasic(getReinvestmentFeature(), o.getReinvestmentFeature(), this::setReinvestmentFeature);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityNotionalAmount _that = getType().cast(o);
		
			if (!Objects.equals(reinvestmentFeature, _that.getReinvestmentFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reinvestmentFeature != null ? reinvestmentFeature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityNotionalAmountBuilder {" +
				"reinvestmentFeature=" + this.reinvestmentFeature +
			'}' + " " + super.toString();
		}
	}
}

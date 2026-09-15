package fpml.consolidated.fx;

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
import fpml.consolidated.fpmlenum.DualCurrencyStrikeQuoteBasisEnum;
import fpml.consolidated.fx.meta.DualCurrencyStrikePriceMeta;
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
 * Provision A type that describes the rate of exchange at which the embedded option in a Dual Currency Deposit has been struck.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes the rate of exchange at which the embedded option in a Dual Currency Deposit has been struck.
 *
 */
@RosettaDataType(value="DualCurrencyStrikePrice", builder=DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DualCurrencyStrikePrice", model="fpml", builder=DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilderImpl.class, version="2.1.1")
public interface DualCurrencyStrikePrice extends RosettaModelObject {

	DualCurrencyStrikePriceMeta metaData = new DualCurrencyStrikePriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate of exchange between the two currencies of the leg of a deal.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate of exchange between the two currencies of the leg of a deal.
	 *
	 */
	BigDecimal getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which the strike rate is quoted, in terms of the deposit (principal) and alternate currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which the strike rate is quoted, in terms of the deposit (principal) and alternate currencies.
	 *
	 */
	DualCurrencyStrikeQuoteBasisEnum getStrikeQuoteBasis();

	/*********************** Build Methods  ***********************/
	DualCurrencyStrikePrice build();
	
	DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder toBuilder();
	
	static DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder() {
		return new DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DualCurrencyStrikePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DualCurrencyStrikePrice> getType() {
		return DualCurrencyStrikePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		processor.processBasic(path.newSubPath("strikeQuoteBasis"), DualCurrencyStrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DualCurrencyStrikePriceBuilder extends DualCurrencyStrikePrice, RosettaModelObjectBuilder {
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setRate(BigDecimal rate);
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setStrikeQuoteBasis(DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
			processor.processBasic(path.newSubPath("strikeQuoteBasis"), DualCurrencyStrikeQuoteBasisEnum.class, getStrikeQuoteBasis(), this);
		}
		

		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder prune();
	}

	/*********************** Immutable Implementation of DualCurrencyStrikePrice  ***********************/
	class DualCurrencyStrikePriceImpl implements DualCurrencyStrikePrice {
		private final BigDecimal rate;
		private final DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis;
		
		protected DualCurrencyStrikePriceImpl(DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder) {
			this.rate = builder.getRate();
			this.strikeQuoteBasis = builder.getStrikeQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeQuoteBasis")
		public DualCurrencyStrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@Override
		public DualCurrencyStrikePrice build() {
			return this;
		}
		
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder toBuilder() {
			DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder builder) {
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getStrikeQuoteBasis()).ifPresent(builder::setStrikeQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualCurrencyStrikePrice {" +
				"rate=" + this.rate + ", " +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of DualCurrencyStrikePrice  ***********************/
	class DualCurrencyStrikePriceBuilderImpl implements DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder {
	
		protected BigDecimal rate;
		protected DualCurrencyStrikeQuoteBasisEnum strikeQuoteBasis;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("strikeQuoteBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeQuoteBasis")
		public DualCurrencyStrikeQuoteBasisEnum getStrikeQuoteBasis() {
			return strikeQuoteBasis;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@RosettaAttribute("strikeQuoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeQuoteBasis")
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder setStrikeQuoteBasis(DualCurrencyStrikeQuoteBasisEnum _strikeQuoteBasis) {
			this.strikeQuoteBasis = _strikeQuoteBasis == null ? null : _strikeQuoteBasis;
			return this;
		}
		
		@Override
		public DualCurrencyStrikePrice build() {
			return new DualCurrencyStrikePrice.DualCurrencyStrikePriceImpl(this);
		}
		
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRate()!=null) return true;
			if (getStrikeQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder o = (DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			merger.mergeBasic(getStrikeQuoteBasis(), o.getStrikeQuoteBasis(), this::setStrikeQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyStrikePrice _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(strikeQuoteBasis, _that.getStrikeQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (strikeQuoteBasis != null ? strikeQuoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualCurrencyStrikePriceBuilder {" +
				"rate=" + this.rate + ", " +
				"strikeQuoteBasis=" + this.strikeQuoteBasis +
			'}';
		}
	}
}

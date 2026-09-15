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
import fpml.consolidated.asset.meta.UnderlyerLoanRateMeta;
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
 * Provision Defines stock loan information where this is required per underlyer. You must not duplicate infromation within dividend conditions at transaction level
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines stock loan information where this is required per underlyer. You must not duplicate infromation within dividend conditions at transaction level
 *
 */
@RosettaDataType(value="UnderlyerLoanRate", builder=UnderlyerLoanRate.UnderlyerLoanRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UnderlyerLoanRate", model="fpml", builder=UnderlyerLoanRate.UnderlyerLoanRateBuilderImpl.class, version="2.1.1")
public interface UnderlyerLoanRate extends RosettaModelObject {

	UnderlyerLoanRateMeta metaData = new UnderlyerLoanRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then loss of stock borrow is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then loss of stock borrow is applicable.
	 *
	 */
	Boolean getLossOfStockBorrow();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the maximum stock loan rate for Loss of Stock Borrow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the maximum stock loan rate for Loss of Stock Borrow.
	 *
	 */
	BigDecimal getMaximumStockLoanRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then increased cost of stock borrow is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then increased cost of stock borrow is applicable.
	 *
	 */
	Boolean getIncreasedCostOfStockBorrow();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the initial stock loan rate for Increased Cost of Stock Borrow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the initial stock loan rate for Increased Cost of Stock Borrow.
	 *
	 */
	BigDecimal getInitialStockLoanRate();

	/*********************** Build Methods  ***********************/
	UnderlyerLoanRate build();
	
	UnderlyerLoanRate.UnderlyerLoanRateBuilder toBuilder();
	
	static UnderlyerLoanRate.UnderlyerLoanRateBuilder builder() {
		return new UnderlyerLoanRate.UnderlyerLoanRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyerLoanRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnderlyerLoanRate> getType() {
		return UnderlyerLoanRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
		processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyerLoanRateBuilder extends UnderlyerLoanRate, RosettaModelObjectBuilder {
		UnderlyerLoanRate.UnderlyerLoanRateBuilder setLossOfStockBorrow(Boolean lossOfStockBorrow);
		UnderlyerLoanRate.UnderlyerLoanRateBuilder setMaximumStockLoanRate(BigDecimal maximumStockLoanRate);
		UnderlyerLoanRate.UnderlyerLoanRateBuilder setIncreasedCostOfStockBorrow(Boolean increasedCostOfStockBorrow);
		UnderlyerLoanRate.UnderlyerLoanRateBuilder setInitialStockLoanRate(BigDecimal initialStockLoanRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
			processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
		}
		

		UnderlyerLoanRate.UnderlyerLoanRateBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyerLoanRate  ***********************/
	class UnderlyerLoanRateImpl implements UnderlyerLoanRate {
		private final Boolean lossOfStockBorrow;
		private final BigDecimal maximumStockLoanRate;
		private final Boolean increasedCostOfStockBorrow;
		private final BigDecimal initialStockLoanRate;
		
		protected UnderlyerLoanRateImpl(UnderlyerLoanRate.UnderlyerLoanRateBuilder builder) {
			this.lossOfStockBorrow = builder.getLossOfStockBorrow();
			this.maximumStockLoanRate = builder.getMaximumStockLoanRate();
			this.increasedCostOfStockBorrow = builder.getIncreasedCostOfStockBorrow();
			this.initialStockLoanRate = builder.getInitialStockLoanRate();
		}
		
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lossOfStockBorrow")
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumStockLoanRate")
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increasedCostOfStockBorrow")
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("initialStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialStockLoanRate")
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		public UnderlyerLoanRate build() {
			return this;
		}
		
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder toBuilder() {
			UnderlyerLoanRate.UnderlyerLoanRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyerLoanRate.UnderlyerLoanRateBuilder builder) {
			ofNullable(getLossOfStockBorrow()).ifPresent(builder::setLossOfStockBorrow);
			ofNullable(getMaximumStockLoanRate()).ifPresent(builder::setMaximumStockLoanRate);
			ofNullable(getIncreasedCostOfStockBorrow()).ifPresent(builder::setIncreasedCostOfStockBorrow);
			ofNullable(getInitialStockLoanRate()).ifPresent(builder::setInitialStockLoanRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyerLoanRate _that = getType().cast(o);
		
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerLoanRate {" +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate +
			'}';
		}
	}

	/*********************** Builder Implementation of UnderlyerLoanRate  ***********************/
	class UnderlyerLoanRateBuilderImpl implements UnderlyerLoanRate.UnderlyerLoanRateBuilder {
	
		protected Boolean lossOfStockBorrow;
		protected BigDecimal maximumStockLoanRate;
		protected Boolean increasedCostOfStockBorrow;
		protected BigDecimal initialStockLoanRate;
		
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lossOfStockBorrow")
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumStockLoanRate")
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increasedCostOfStockBorrow")
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("initialStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialStockLoanRate")
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@RosettaAttribute("lossOfStockBorrow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lossOfStockBorrow")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder setLossOfStockBorrow(Boolean _lossOfStockBorrow) {
			this.lossOfStockBorrow = _lossOfStockBorrow == null ? null : _lossOfStockBorrow;
			return this;
		}
		
		@RosettaAttribute("maximumStockLoanRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumStockLoanRate")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder setMaximumStockLoanRate(BigDecimal _maximumStockLoanRate) {
			this.maximumStockLoanRate = _maximumStockLoanRate == null ? null : _maximumStockLoanRate;
			return this;
		}
		
		@RosettaAttribute("increasedCostOfStockBorrow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increasedCostOfStockBorrow")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder setIncreasedCostOfStockBorrow(Boolean _increasedCostOfStockBorrow) {
			this.increasedCostOfStockBorrow = _increasedCostOfStockBorrow == null ? null : _increasedCostOfStockBorrow;
			return this;
		}
		
		@RosettaAttribute("initialStockLoanRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialStockLoanRate")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder setInitialStockLoanRate(BigDecimal _initialStockLoanRate) {
			this.initialStockLoanRate = _initialStockLoanRate == null ? null : _initialStockLoanRate;
			return this;
		}
		
		@Override
		public UnderlyerLoanRate build() {
			return new UnderlyerLoanRate.UnderlyerLoanRateImpl(this);
		}
		
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLossOfStockBorrow()!=null) return true;
			if (getMaximumStockLoanRate()!=null) return true;
			if (getIncreasedCostOfStockBorrow()!=null) return true;
			if (getInitialStockLoanRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnderlyerLoanRate.UnderlyerLoanRateBuilder o = (UnderlyerLoanRate.UnderlyerLoanRateBuilder) other;
			
			
			merger.mergeBasic(getLossOfStockBorrow(), o.getLossOfStockBorrow(), this::setLossOfStockBorrow);
			merger.mergeBasic(getMaximumStockLoanRate(), o.getMaximumStockLoanRate(), this::setMaximumStockLoanRate);
			merger.mergeBasic(getIncreasedCostOfStockBorrow(), o.getIncreasedCostOfStockBorrow(), this::setIncreasedCostOfStockBorrow);
			merger.mergeBasic(getInitialStockLoanRate(), o.getInitialStockLoanRate(), this::setInitialStockLoanRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyerLoanRate _that = getType().cast(o);
		
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerLoanRateBuilder {" +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate +
			'}';
		}
	}
}

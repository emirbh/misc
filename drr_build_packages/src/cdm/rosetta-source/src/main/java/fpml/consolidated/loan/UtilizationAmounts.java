package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.UtilizationAmountsMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure which defines the total utilization and available credit levels for a given facility.
 *
 */
@RosettaDataType(value="UtilizationAmounts", builder=UtilizationAmounts.UtilizationAmountsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UtilizationAmounts", model="fpml", builder=UtilizationAmounts.UtilizationAmountsBuilderImpl.class, version="2.1.1")
public interface UtilizationAmounts extends RosettaModelObject {

	UtilizationAmountsMeta metaData = new UtilizationAmountsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of utilization which is funded.
	 *
	 */
	BigDecimal getFundedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of utilization which is unfunded.
	 *
	 */
	BigDecimal getUnfundedAmount();

	/*********************** Build Methods  ***********************/
	UtilizationAmounts build();
	
	UtilizationAmounts.UtilizationAmountsBuilder toBuilder();
	
	static UtilizationAmounts.UtilizationAmountsBuilder builder() {
		return new UtilizationAmounts.UtilizationAmountsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationAmounts> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UtilizationAmounts> getType() {
		return UtilizationAmounts.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fundedAmount"), BigDecimal.class, getFundedAmount(), this);
		processor.processBasic(path.newSubPath("unfundedAmount"), BigDecimal.class, getUnfundedAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationAmountsBuilder extends UtilizationAmounts, RosettaModelObjectBuilder {
		UtilizationAmounts.UtilizationAmountsBuilder setFundedAmount(BigDecimal fundedAmount);
		UtilizationAmounts.UtilizationAmountsBuilder setUnfundedAmount(BigDecimal unfundedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fundedAmount"), BigDecimal.class, getFundedAmount(), this);
			processor.processBasic(path.newSubPath("unfundedAmount"), BigDecimal.class, getUnfundedAmount(), this);
		}
		

		UtilizationAmounts.UtilizationAmountsBuilder prune();
	}

	/*********************** Immutable Implementation of UtilizationAmounts  ***********************/
	class UtilizationAmountsImpl implements UtilizationAmounts {
		private final BigDecimal fundedAmount;
		private final BigDecimal unfundedAmount;
		
		protected UtilizationAmountsImpl(UtilizationAmounts.UtilizationAmountsBuilder builder) {
			this.fundedAmount = builder.getFundedAmount();
			this.unfundedAmount = builder.getUnfundedAmount();
		}
		
		@Override
		@RosettaAttribute("fundedAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fundedAmount")
		public BigDecimal getFundedAmount() {
			return fundedAmount;
		}
		
		@Override
		@RosettaAttribute("unfundedAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("unfundedAmount")
		public BigDecimal getUnfundedAmount() {
			return unfundedAmount;
		}
		
		@Override
		public UtilizationAmounts build() {
			return this;
		}
		
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder toBuilder() {
			UtilizationAmounts.UtilizationAmountsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationAmounts.UtilizationAmountsBuilder builder) {
			ofNullable(getFundedAmount()).ifPresent(builder::setFundedAmount);
			ofNullable(getUnfundedAmount()).ifPresent(builder::setUnfundedAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationAmounts _that = getType().cast(o);
		
			if (!Objects.equals(fundedAmount, _that.getFundedAmount())) return false;
			if (!Objects.equals(unfundedAmount, _that.getUnfundedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fundedAmount != null ? fundedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedAmount != null ? unfundedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationAmounts {" +
				"fundedAmount=" + this.fundedAmount + ", " +
				"unfundedAmount=" + this.unfundedAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationAmounts  ***********************/
	class UtilizationAmountsBuilderImpl implements UtilizationAmounts.UtilizationAmountsBuilder {
	
		protected BigDecimal fundedAmount;
		protected BigDecimal unfundedAmount;
		
		@Override
		@RosettaAttribute("fundedAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fundedAmount")
		public BigDecimal getFundedAmount() {
			return fundedAmount;
		}
		
		@Override
		@RosettaAttribute("unfundedAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("unfundedAmount")
		public BigDecimal getUnfundedAmount() {
			return unfundedAmount;
		}
		
		@RosettaAttribute("fundedAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fundedAmount")
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder setFundedAmount(BigDecimal _fundedAmount) {
			this.fundedAmount = _fundedAmount == null ? null : _fundedAmount;
			return this;
		}
		
		@RosettaAttribute("unfundedAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("unfundedAmount")
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder setUnfundedAmount(BigDecimal _unfundedAmount) {
			this.unfundedAmount = _unfundedAmount == null ? null : _unfundedAmount;
			return this;
		}
		
		@Override
		public UtilizationAmounts build() {
			return new UtilizationAmounts.UtilizationAmountsImpl(this);
		}
		
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFundedAmount()!=null) return true;
			if (getUnfundedAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationAmounts.UtilizationAmountsBuilder o = (UtilizationAmounts.UtilizationAmountsBuilder) other;
			
			
			merger.mergeBasic(getFundedAmount(), o.getFundedAmount(), this::setFundedAmount);
			merger.mergeBasic(getUnfundedAmount(), o.getUnfundedAmount(), this::setUnfundedAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationAmounts _that = getType().cast(o);
		
			if (!Objects.equals(fundedAmount, _that.getFundedAmount())) return false;
			if (!Objects.equals(unfundedAmount, _that.getUnfundedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fundedAmount != null ? fundedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedAmount != null ? unfundedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationAmountsBuilder {" +
				"fundedAmount=" + this.fundedAmount + ", " +
				"unfundedAmount=" + this.unfundedAmount +
			'}';
		}
	}
}

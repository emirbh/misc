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
import fpml.consolidated.loan.meta.TaxWithholdingMeta;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A structure that represents the withholding tax being applied to a particular cash flow.
 *
 */
@RosettaDataType(value="TaxWithholding", builder=TaxWithholding.TaxWithholdingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TaxWithholding", model="fpml", builder=TaxWithholding.TaxWithholdingBuilderImpl.class, version="2.1.1")
public interface TaxWithholding extends RosettaModelObject {

	TaxWithholdingMeta metaData = new TaxWithholdingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of withholding tax being applied.
	 *
	 */
	NonNegativeMoney getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The tax rate being applied to the associated cash flow.
	 *
	 */
	BigDecimal getTaxRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A scheme used to identify the reason for withholding tax being applied to a cash flow.
	 *
	 */
	WithholdingTaxReason getReason();

	/*********************** Build Methods  ***********************/
	TaxWithholding build();
	
	TaxWithholding.TaxWithholdingBuilder toBuilder();
	
	static TaxWithholding.TaxWithholdingBuilder builder() {
		return new TaxWithholding.TaxWithholdingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaxWithholding> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TaxWithholding> getType() {
		return TaxWithholding.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("taxRate"), BigDecimal.class, getTaxRate(), this);
		processRosetta(path.newSubPath("reason"), processor, WithholdingTaxReason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaxWithholdingBuilder extends TaxWithholding, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		WithholdingTaxReason.WithholdingTaxReasonBuilder getOrCreateReason();
		@Override
		WithholdingTaxReason.WithholdingTaxReasonBuilder getReason();
		TaxWithholding.TaxWithholdingBuilder setAmount(NonNegativeMoney amount);
		TaxWithholding.TaxWithholdingBuilder setTaxRate(BigDecimal taxRate);
		TaxWithholding.TaxWithholdingBuilder setReason(WithholdingTaxReason reason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("taxRate"), BigDecimal.class, getTaxRate(), this);
			processRosetta(path.newSubPath("reason"), processor, WithholdingTaxReason.WithholdingTaxReasonBuilder.class, getReason());
		}
		

		TaxWithholding.TaxWithholdingBuilder prune();
	}

	/*********************** Immutable Implementation of TaxWithholding  ***********************/
	class TaxWithholdingImpl implements TaxWithholding {
		private final NonNegativeMoney amount;
		private final BigDecimal taxRate;
		private final WithholdingTaxReason reason;
		
		protected TaxWithholdingImpl(TaxWithholding.TaxWithholdingBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.taxRate = builder.getTaxRate();
			this.reason = ofNullable(builder.getReason()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("taxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taxRate")
		public BigDecimal getTaxRate() {
			return taxRate;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reason")
		public WithholdingTaxReason getReason() {
			return reason;
		}
		
		@Override
		public TaxWithholding build() {
			return this;
		}
		
		@Override
		public TaxWithholding.TaxWithholdingBuilder toBuilder() {
			TaxWithholding.TaxWithholdingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaxWithholding.TaxWithholdingBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getTaxRate()).ifPresent(builder::setTaxRate);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxWithholding _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(taxRate, _that.getTaxRate())) return false;
			if (!Objects.equals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (taxRate != null ? taxRate.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxWithholding {" +
				"amount=" + this.amount + ", " +
				"taxRate=" + this.taxRate + ", " +
				"reason=" + this.reason +
			'}';
		}
	}

	/*********************** Builder Implementation of TaxWithholding  ***********************/
	class TaxWithholdingBuilderImpl implements TaxWithholding.TaxWithholdingBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected BigDecimal taxRate;
		protected WithholdingTaxReason.WithholdingTaxReasonBuilder reason;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taxRate")
		public BigDecimal getTaxRate() {
			return taxRate;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reason")
		public WithholdingTaxReason.WithholdingTaxReasonBuilder getReason() {
			return reason;
		}
		
		@Override
		public WithholdingTaxReason.WithholdingTaxReasonBuilder getOrCreateReason() {
			WithholdingTaxReason.WithholdingTaxReasonBuilder result;
			if (reason!=null) {
				result = reason;
			}
			else {
				result = reason = WithholdingTaxReason.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public TaxWithholding.TaxWithholdingBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taxRate")
		@Override
		public TaxWithholding.TaxWithholdingBuilder setTaxRate(BigDecimal _taxRate) {
			this.taxRate = _taxRate == null ? null : _taxRate;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reason")
		@Override
		public TaxWithholding.TaxWithholdingBuilder setReason(WithholdingTaxReason _reason) {
			this.reason = _reason == null ? null : _reason.toBuilder();
			return this;
		}
		
		@Override
		public TaxWithholding build() {
			return new TaxWithholding.TaxWithholdingImpl(this);
		}
		
		@Override
		public TaxWithholding.TaxWithholdingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxWithholding.TaxWithholdingBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (reason!=null && !reason.prune().hasData()) reason = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getTaxRate()!=null) return true;
			if (getReason()!=null && getReason().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxWithholding.TaxWithholdingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaxWithholding.TaxWithholdingBuilder o = (TaxWithholding.TaxWithholdingBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getReason(), o.getReason(), this::setReason);
			
			merger.mergeBasic(getTaxRate(), o.getTaxRate(), this::setTaxRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxWithholding _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(taxRate, _that.getTaxRate())) return false;
			if (!Objects.equals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (taxRate != null ? taxRate.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxWithholdingBuilder {" +
				"amount=" + this.amount + ", " +
				"taxRate=" + this.taxRate + ", " +
				"reason=" + this.reason +
			'}';
		}
	}
}

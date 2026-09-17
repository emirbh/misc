package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.ReturnSwapAmountMeta;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import fpml.consolidated.shared.ReferenceAmount;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies, in relation to each Payment Date, the amount to which the Payment Date relates. For Equity Swaps this element is equivalent to the Equity Amount term as defined in the ISDA 2002 Equity Derivatives Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies, in relation to each Payment Date, the amount to which the Payment Date relates. For Equity Swaps this element is equivalent to the Equity Amount term as defined in the ISDA 2002 Equity Derivatives Definitions.
 *
 */
@RosettaDataType(value="ReturnSwapAmount", builder=ReturnSwapAmount.ReturnSwapAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnSwapAmount", model="fpml", builder=ReturnSwapAmount.ReturnSwapAmountBuilderImpl.class, version="2.1.1")
public interface ReturnSwapAmount extends LegAmount {

	ReturnSwapAmountMeta metaData = new ReturnSwapAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then cash settlement is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then cash settlement is applicable.
	 *
	 */
	Boolean getCashSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then options exchange dividends are applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then options exchange dividends are applicable.
	 *
	 */
	Boolean getOptionsExchangeDividends();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then additional dividends are applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then additional dividends are applicable.
	 *
	 */
	Boolean getAdditionalDividends();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Represents the European Master Confirmation value of 'All Dividends' which, when applicable, signifies that, for a given Ex-Date, the daily observed Share Price for that day is adjusted (reduced) by the cash dividend and/or the cash value of any non cash dividend per Share (including Extraordinary Dividends) declared by the Issuer. All Dividends in accordance with the ISDA 2002 Equity Derivatives Definitions.
	 *
	 */
	Boolean getAllDividends();

	/*********************** Build Methods  ***********************/
	ReturnSwapAmount build();
	
	ReturnSwapAmount.ReturnSwapAmountBuilder toBuilder();
	
	static ReturnSwapAmount.ReturnSwapAmountBuilder builder() {
		return new ReturnSwapAmount.ReturnSwapAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnSwapAmount> getType() {
		return ReturnSwapAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.class, getCurrencyReference());
		processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.class, getReferenceAmount());
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
		processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.class, getCalculationDates());
		processor.processBasic(path.newSubPath("cashSettlement"), Boolean.class, getCashSettlement(), this);
		processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
		processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
		processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapAmountBuilder extends ReturnSwapAmount, LegAmount.LegAmountBuilder {
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setCurrencyReference(IdentifiedCurrencyReference currencyReference);
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setReferenceAmount(ReferenceAmount referenceAmount);
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setFormula(Formula formula);
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setEncodedDescription(String encodedDescription);
		@Override
		ReturnSwapAmount.ReturnSwapAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);
		ReturnSwapAmount.ReturnSwapAmountBuilder setCashSettlement(Boolean cashSettlement);
		ReturnSwapAmount.ReturnSwapAmountBuilder setOptionsExchangeDividends(Boolean optionsExchangeDividends);
		ReturnSwapAmount.ReturnSwapAmountBuilder setAdditionalDividends(Boolean additionalDividends);
		ReturnSwapAmount.ReturnSwapAmountBuilder setAllDividends(Boolean allDividends);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder.class, getCurrencyReference());
			processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.ReferenceAmountBuilder.class, getReferenceAmount());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
			processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
			processor.processBasic(path.newSubPath("cashSettlement"), Boolean.class, getCashSettlement(), this);
			processor.processBasic(path.newSubPath("optionsExchangeDividends"), Boolean.class, getOptionsExchangeDividends(), this);
			processor.processBasic(path.newSubPath("additionalDividends"), Boolean.class, getAdditionalDividends(), this);
			processor.processBasic(path.newSubPath("allDividends"), Boolean.class, getAllDividends(), this);
		}
		

		ReturnSwapAmount.ReturnSwapAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapAmount  ***********************/
	class ReturnSwapAmountImpl extends LegAmount.LegAmountImpl implements ReturnSwapAmount {
		private final Boolean cashSettlement;
		private final Boolean optionsExchangeDividends;
		private final Boolean additionalDividends;
		private final Boolean allDividends;
		
		protected ReturnSwapAmountImpl(ReturnSwapAmount.ReturnSwapAmountBuilder builder) {
			super(builder);
			this.cashSettlement = builder.getCashSettlement();
			this.optionsExchangeDividends = builder.getOptionsExchangeDividends();
			this.additionalDividends = builder.getAdditionalDividends();
			this.allDividends = builder.getAllDividends();
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public Boolean getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionsExchangeDividends")
		public Boolean getOptionsExchangeDividends() {
			return optionsExchangeDividends;
		}
		
		@Override
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalDividends")
		public Boolean getAdditionalDividends() {
			return additionalDividends;
		}
		
		@Override
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allDividends")
		public Boolean getAllDividends() {
			return allDividends;
		}
		
		@Override
		public ReturnSwapAmount build() {
			return this;
		}
		
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder toBuilder() {
			ReturnSwapAmount.ReturnSwapAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapAmount.ReturnSwapAmountBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getOptionsExchangeDividends()).ifPresent(builder::setOptionsExchangeDividends);
			ofNullable(getAdditionalDividends()).ifPresent(builder::setAdditionalDividends);
			ofNullable(getAllDividends()).ifPresent(builder::setAllDividends);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAmount _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(optionsExchangeDividends, _that.getOptionsExchangeDividends())) return false;
			if (!Objects.equals(additionalDividends, _that.getAdditionalDividends())) return false;
			if (!Objects.equals(allDividends, _that.getAllDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeDividends != null ? optionsExchangeDividends.hashCode() : 0);
			_result = 31 * _result + (additionalDividends != null ? additionalDividends.hashCode() : 0);
			_result = 31 * _result + (allDividends != null ? allDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAmount {" +
				"cashSettlement=" + this.cashSettlement + ", " +
				"optionsExchangeDividends=" + this.optionsExchangeDividends + ", " +
				"additionalDividends=" + this.additionalDividends + ", " +
				"allDividends=" + this.allDividends +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwapAmount  ***********************/
	class ReturnSwapAmountBuilderImpl extends LegAmount.LegAmountBuilderImpl implements ReturnSwapAmount.ReturnSwapAmountBuilder {
	
		protected Boolean cashSettlement;
		protected Boolean optionsExchangeDividends;
		protected Boolean additionalDividends;
		protected Boolean allDividends;
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public Boolean getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionsExchangeDividends")
		public Boolean getOptionsExchangeDividends() {
			return optionsExchangeDividends;
		}
		
		@Override
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalDividends")
		public Boolean getAdditionalDividends() {
			return additionalDividends;
		}
		
		@Override
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allDividends")
		public Boolean getAllDividends() {
			return allDividends;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyReference")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCurrencyReference(IdentifiedCurrencyReference _currencyReference) {
			this.currencyReference = _currencyReference == null ? null : _currencyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceAmount")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setReferenceAmount(ReferenceAmount _referenceAmount) {
			this.referenceAmount = _referenceAmount == null ? null : _referenceAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("formula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formula")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setFormula(Formula _formula) {
			this.formula = _formula == null ? null : _formula.toBuilder();
			return this;
		}
		
		@RosettaAttribute("encodedDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("encodedDescription")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setEncodedDescription(String _encodedDescription) {
			this.encodedDescription = _encodedDescription == null ? null : _encodedDescription;
			return this;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setCashSettlement(Boolean _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement;
			return this;
		}
		
		@RosettaAttribute("optionsExchangeDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionsExchangeDividends")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setOptionsExchangeDividends(Boolean _optionsExchangeDividends) {
			this.optionsExchangeDividends = _optionsExchangeDividends == null ? null : _optionsExchangeDividends;
			return this;
		}
		
		@RosettaAttribute("additionalDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalDividends")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setAdditionalDividends(Boolean _additionalDividends) {
			this.additionalDividends = _additionalDividends == null ? null : _additionalDividends;
			return this;
		}
		
		@RosettaAttribute("allDividends")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allDividends")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder setAllDividends(Boolean _allDividends) {
			this.allDividends = _allDividends == null ? null : _allDividends;
			return this;
		}
		
		@Override
		public ReturnSwapAmount build() {
			return new ReturnSwapAmount.ReturnSwapAmountImpl(this);
		}
		
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCashSettlement()!=null) return true;
			if (getOptionsExchangeDividends()!=null) return true;
			if (getAdditionalDividends()!=null) return true;
			if (getAllDividends()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapAmount.ReturnSwapAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ReturnSwapAmount.ReturnSwapAmountBuilder o = (ReturnSwapAmount.ReturnSwapAmountBuilder) other;
			
			
			merger.mergeBasic(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeBasic(getOptionsExchangeDividends(), o.getOptionsExchangeDividends(), this::setOptionsExchangeDividends);
			merger.mergeBasic(getAdditionalDividends(), o.getAdditionalDividends(), this::setAdditionalDividends);
			merger.mergeBasic(getAllDividends(), o.getAllDividends(), this::setAllDividends);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwapAmount _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(optionsExchangeDividends, _that.getOptionsExchangeDividends())) return false;
			if (!Objects.equals(additionalDividends, _that.getAdditionalDividends())) return false;
			if (!Objects.equals(allDividends, _that.getAllDividends())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (optionsExchangeDividends != null ? optionsExchangeDividends.hashCode() : 0);
			_result = 31 * _result + (additionalDividends != null ? additionalDividends.hashCode() : 0);
			_result = 31 * _result + (allDividends != null ? allDividends.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapAmountBuilder {" +
				"cashSettlement=" + this.cashSettlement + ", " +
				"optionsExchangeDividends=" + this.optionsExchangeDividends + ", " +
				"additionalDividends=" + this.additionalDividends + ", " +
				"allDividends=" + this.allDividends +
			'}' + " " + super.toString();
		}
	}
}

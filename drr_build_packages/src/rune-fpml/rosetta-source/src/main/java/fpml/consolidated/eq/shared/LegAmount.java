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
import fpml.consolidated.eq.shared.meta.LegAmountMeta;
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
 * Provision A type describing the amount that will paid or received on each of the payment dates. This type is used to define both the Equity Amount and the Interest Amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the amount that will paid or received on each of the payment dates. This type is used to define both the Equity Amount and the Interest Amount.
 *
 */
@RosettaDataType(value="LegAmount", builder=LegAmount.LegAmountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegAmount", model="fpml", builder=LegAmount.LegAmountBuilderImpl.class, version="2.1.1")
public interface LegAmount extends RosettaModelObject {

	LegAmountMeta metaData = new LegAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	IdentifiedCurrency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the method according to which an amount or a date is determined.
	 *
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a currency defined elsewhere in the document
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a currency defined elsewhere in the document
	 *
	 */
	IdentifiedCurrencyReference getCurrencyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the reference Amount when this term either corresponds to the standard ISDA Definition (either the 2002 Equity Definition for the Equity Amount, or the 2000 Definition for the Interest Amount), or points to a term defined elsewhere in the swap document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the reference Amount when this term either corresponds to the standard ISDA Definition (either the 2002 Equity Definition for the Equity Amount, or the 2000 Definition for the Interest Amount), or points to a term defined elsewhere in the swap document.
	 *
	 */
	ReferenceAmount getReferenceAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a formula, with its description and components.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a formula, with its description and components.
	 *
	 */
	Formula getFormula();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Description of the leg amount when represented through an encoded image.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Description of the leg amount when represented through an encoded image.
	 *
	 */
	String getEncodedDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the date on which a calculation or an observation will be performed for the purpose of defining the Equity Amount, and in accordance to the definition terms of this latter.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the date on which a calculation or an observation will be performed for the purpose of defining the Equity Amount, and in accordance to the definition terms of this latter.
	 *
	 */
	AdjustableRelativeOrPeriodicDates getCalculationDates();

	/*********************** Build Methods  ***********************/
	LegAmount build();
	
	LegAmount.LegAmountBuilder toBuilder();
	
	static LegAmount.LegAmountBuilder builder() {
		return new LegAmount.LegAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegAmount> getType() {
		return LegAmount.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegAmountBuilder extends LegAmount, RosettaModelObjectBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getOrCreateCurrencyReference();
		@Override
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getCurrencyReference();
		ReferenceAmount.ReferenceAmountBuilder getOrCreateReferenceAmount();
		@Override
		ReferenceAmount.ReferenceAmountBuilder getReferenceAmount();
		Formula.FormulaBuilder getOrCreateFormula();
		@Override
		Formula.FormulaBuilder getFormula();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates();
		@Override
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates();
		LegAmount.LegAmountBuilder setCurrency(IdentifiedCurrency currency);
		LegAmount.LegAmountBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		LegAmount.LegAmountBuilder setCurrencyReference(IdentifiedCurrencyReference currencyReference);
		LegAmount.LegAmountBuilder setReferenceAmount(ReferenceAmount referenceAmount);
		LegAmount.LegAmountBuilder setFormula(Formula formula);
		LegAmount.LegAmountBuilder setEncodedDescription(String encodedDescription);
		LegAmount.LegAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates calculationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder.class, getCurrencyReference());
			processRosetta(path.newSubPath("referenceAmount"), processor, ReferenceAmount.ReferenceAmountBuilder.class, getReferenceAmount());
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
			processor.processBasic(path.newSubPath("encodedDescription"), String.class, getEncodedDescription(), this);
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder.class, getCalculationDates());
		}
		

		LegAmount.LegAmountBuilder prune();
	}

	/*********************** Immutable Implementation of LegAmount  ***********************/
	class LegAmountImpl implements LegAmount {
		private final IdentifiedCurrency currency;
		private final DeterminationMethod determinationMethod;
		private final IdentifiedCurrencyReference currencyReference;
		private final ReferenceAmount referenceAmount;
		private final Formula formula;
		private final String encodedDescription;
		private final AdjustableRelativeOrPeriodicDates calculationDates;
		
		protected LegAmountImpl(LegAmount.LegAmountBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.currencyReference = ofNullable(builder.getCurrencyReference()).map(f->f.build()).orElse(null);
			this.referenceAmount = ofNullable(builder.getReferenceAmount()).map(f->f.build()).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
			this.encodedDescription = builder.getEncodedDescription();
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyReference")
		public IdentifiedCurrencyReference getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceAmount")
		public ReferenceAmount getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("encodedDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("encodedDescription")
		public String getEncodedDescription() {
			return encodedDescription;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public LegAmount build() {
			return this;
		}
		
		@Override
		public LegAmount.LegAmountBuilder toBuilder() {
			LegAmount.LegAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegAmount.LegAmountBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getCurrencyReference()).ifPresent(builder::setCurrencyReference);
			ofNullable(getReferenceAmount()).ifPresent(builder::setReferenceAmount);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getEncodedDescription()).ifPresent(builder::setEncodedDescription);
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegAmount _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(encodedDescription, _that.getEncodedDescription())) return false;
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (encodedDescription != null ? encodedDescription.hashCode() : 0);
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegAmount {" +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"formula=" + this.formula + ", " +
				"encodedDescription=" + this.encodedDescription + ", " +
				"calculationDates=" + this.calculationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of LegAmount  ***********************/
	class LegAmountBuilderImpl implements LegAmount.LegAmountBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder currency;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder currencyReference;
		protected ReferenceAmount.ReferenceAmountBuilder referenceAmount;
		protected Formula.FormulaBuilder formula;
		protected String encodedDescription;
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder calculationDates;
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyReference")
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getOrCreateCurrencyReference() {
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder result;
			if (currencyReference!=null) {
				result = currencyReference;
			}
			else {
				result = currencyReference = IdentifiedCurrencyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceAmount")
		public ReferenceAmount.ReferenceAmountBuilder getReferenceAmount() {
			return referenceAmount;
		}
		
		@Override
		public ReferenceAmount.ReferenceAmountBuilder getOrCreateReferenceAmount() {
			ReferenceAmount.ReferenceAmountBuilder result;
			if (referenceAmount!=null) {
				result = referenceAmount;
			}
			else {
				result = referenceAmount = ReferenceAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public Formula.FormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public Formula.FormulaBuilder getOrCreateFormula() {
			Formula.FormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = Formula.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("encodedDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("encodedDescription")
		public String getEncodedDescription() {
			return encodedDescription;
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder getOrCreateCalculationDates() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableRelativeOrPeriodicDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public LegAmount.LegAmountBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determinationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determinationMethod")
		@Override
		public LegAmount.LegAmountBuilder setDeterminationMethod(DeterminationMethod _determinationMethod) {
			this.determinationMethod = _determinationMethod == null ? null : _determinationMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currencyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyReference")
		@Override
		public LegAmount.LegAmountBuilder setCurrencyReference(IdentifiedCurrencyReference _currencyReference) {
			this.currencyReference = _currencyReference == null ? null : _currencyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceAmount")
		@Override
		public LegAmount.LegAmountBuilder setReferenceAmount(ReferenceAmount _referenceAmount) {
			this.referenceAmount = _referenceAmount == null ? null : _referenceAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("formula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formula")
		@Override
		public LegAmount.LegAmountBuilder setFormula(Formula _formula) {
			this.formula = _formula == null ? null : _formula.toBuilder();
			return this;
		}
		
		@RosettaAttribute("encodedDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("encodedDescription")
		@Override
		public LegAmount.LegAmountBuilder setEncodedDescription(String _encodedDescription) {
			this.encodedDescription = _encodedDescription == null ? null : _encodedDescription;
			return this;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public LegAmount.LegAmountBuilder setCalculationDates(AdjustableRelativeOrPeriodicDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@Override
		public LegAmount build() {
			return new LegAmount.LegAmountImpl(this);
		}
		
		@Override
		public LegAmount.LegAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegAmount.LegAmountBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (currencyReference!=null && !currencyReference.prune().hasData()) currencyReference = null;
			if (referenceAmount!=null && !referenceAmount.prune().hasData()) referenceAmount = null;
			if (formula!=null && !formula.prune().hasData()) formula = null;
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getCurrencyReference()!=null && getCurrencyReference().hasData()) return true;
			if (getReferenceAmount()!=null && getReferenceAmount().hasData()) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			if (getEncodedDescription()!=null) return true;
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegAmount.LegAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegAmount.LegAmountBuilder o = (LegAmount.LegAmountBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getCurrencyReference(), o.getCurrencyReference(), this::setCurrencyReference);
			merger.mergeRosetta(getReferenceAmount(), o.getReferenceAmount(), this::setReferenceAmount);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			
			merger.mergeBasic(getEncodedDescription(), o.getEncodedDescription(), this::setEncodedDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegAmount _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			if (!Objects.equals(referenceAmount, _that.getReferenceAmount())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(encodedDescription, _that.getEncodedDescription())) return false;
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			_result = 31 * _result + (referenceAmount != null ? referenceAmount.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (encodedDescription != null ? encodedDescription.hashCode() : 0);
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegAmountBuilder {" +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference + ", " +
				"referenceAmount=" + this.referenceAmount + ", " +
				"formula=" + this.formula + ", " +
				"encodedDescription=" + this.encodedDescription + ", " +
				"calculationDates=" + this.calculationDates +
			'}';
		}
	}
}

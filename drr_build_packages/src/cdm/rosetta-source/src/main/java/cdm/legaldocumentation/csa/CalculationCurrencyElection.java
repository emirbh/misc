package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.CalculationCurrencyElectionMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the ISDA SIMM Calculation Currency.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(ee)(3"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CalculationCurrencyElection", builder=CalculationCurrencyElection.CalculationCurrencyElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CalculationCurrencyElection", model="cdm", builder=CalculationCurrencyElection.CalculationCurrencyElectionBuilderImpl.class, version="6.23.0")
public interface CalculationCurrencyElection extends RosettaModelObject {

	CalculationCurrencyElectionMeta metaData = new CalculationCurrencyElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party which the SIMM Calculation Currency qualification applies to.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The SIMM Calculation Currency (also known as SIMM Reporting Currency) means the Base Currency when True. It means a different currency when False. In that latter case, the SIMM Calculation Currency is specified as part of the currency attribute.
	 */
	Boolean getIsBaseCurrency();
	/**
	 * The currency in which the ISDA SIMM Calculation is denominated, when different from the Base Currency. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();

	/*********************** Build Methods  ***********************/
	CalculationCurrencyElection build();
	
	CalculationCurrencyElection.CalculationCurrencyElectionBuilder toBuilder();
	
	static CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder() {
		return new CalculationCurrencyElection.CalculationCurrencyElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationCurrencyElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationCurrencyElection> getType() {
		return CalculationCurrencyElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isBaseCurrency"), Boolean.class, getIsBaseCurrency(), this);
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationCurrencyElectionBuilder extends CalculationCurrencyElection, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getCurrency();
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setParty(CounterpartyRoleEnum party);
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setIsBaseCurrency(Boolean isBaseCurrency);
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrency(FieldWithMetaString currency);
		CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrencyValue(String currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isBaseCurrency"), Boolean.class, getIsBaseCurrency(), this);
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCurrency());
		}
		

		CalculationCurrencyElection.CalculationCurrencyElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationCurrencyElection  ***********************/
	class CalculationCurrencyElectionImpl implements CalculationCurrencyElection {
		private final CounterpartyRoleEnum party;
		private final Boolean isBaseCurrency;
		private final FieldWithMetaString currency;
		
		protected CalculationCurrencyElectionImpl(CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder) {
			this.party = builder.getParty();
			this.isBaseCurrency = builder.getIsBaseCurrency();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isBaseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isBaseCurrency")
		public Boolean getIsBaseCurrency() {
			return isBaseCurrency;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public CalculationCurrencyElection build() {
			return this;
		}
		
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder toBuilder() {
			CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationCurrencyElection.CalculationCurrencyElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsBaseCurrency()).ifPresent(builder::setIsBaseCurrency);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationCurrencyElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isBaseCurrency, _that.getIsBaseCurrency())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isBaseCurrency != null ? isBaseCurrency.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationCurrencyElection {" +
				"party=" + this.party + ", " +
				"isBaseCurrency=" + this.isBaseCurrency + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationCurrencyElection  ***********************/
	class CalculationCurrencyElectionBuilderImpl implements CalculationCurrencyElection.CalculationCurrencyElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean isBaseCurrency;
		protected FieldWithMetaString.FieldWithMetaStringBuilder currency;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isBaseCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isBaseCurrency")
		public Boolean getIsBaseCurrency() {
			return isBaseCurrency;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public FieldWithMetaString.FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isBaseCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isBaseCurrency")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setIsBaseCurrency(Boolean _isBaseCurrency) {
			this.isBaseCurrency = _isBaseCurrency == null ? null : _isBaseCurrency;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrency(FieldWithMetaString _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder setCurrencyValue(String _currency) {
			this.getOrCreateCurrency().setValue(_currency);
			return this;
		}
		
		@Override
		public CalculationCurrencyElection build() {
			return new CalculationCurrencyElection.CalculationCurrencyElectionImpl(this);
		}
		
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIsBaseCurrency()!=null) return true;
			if (getCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationCurrencyElection.CalculationCurrencyElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationCurrencyElection.CalculationCurrencyElectionBuilder o = (CalculationCurrencyElection.CalculationCurrencyElectionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsBaseCurrency(), o.getIsBaseCurrency(), this::setIsBaseCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationCurrencyElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isBaseCurrency, _that.getIsBaseCurrency())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isBaseCurrency != null ? isBaseCurrency.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationCurrencyElectionBuilder {" +
				"party=" + this.party + ", " +
				"isBaseCurrency=" + this.isBaseCurrency + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}

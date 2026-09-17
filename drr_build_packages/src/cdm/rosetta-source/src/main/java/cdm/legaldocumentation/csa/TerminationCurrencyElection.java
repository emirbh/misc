package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.TerminationCurrencyElectionMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Amendment to Termination Currency election by the parties to the agreement.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(t)(A) &amp; (B)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="TerminationCurrencyElection", builder=TerminationCurrencyElection.TerminationCurrencyElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="TerminationCurrencyElection", model="cdm", builder=TerminationCurrencyElection.TerminationCurrencyElectionBuilderImpl.class, version="6.23.0")
public interface TerminationCurrencyElection extends RosettaModelObject {

	TerminationCurrencyElectionMeta metaData = new TerminationCurrencyElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	List<CounterpartyRoleEnum> getParty();
	/**
	 * The qualification of whether the Termination Currency is specified in this document (True) or in an Eligible Support Credit Support (IM) Schedule (False).
	 */
	Boolean getIsSpecified();
	/**
	 * The Termination Currency associated with the party that referenced as part of this class. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getCurrency();

	/*********************** Build Methods  ***********************/
	TerminationCurrencyElection build();
	
	TerminationCurrencyElection.TerminationCurrencyElectionBuilder toBuilder();
	
	static TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder() {
		return new TerminationCurrencyElection.TerminationCurrencyElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TerminationCurrencyElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TerminationCurrencyElection> getType() {
		return TerminationCurrencyElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TerminationCurrencyElectionBuilder extends TerminationCurrencyElection, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCurrency();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getCurrency();
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum party);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum party, int idx);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(List<CounterpartyRoleEnum> party);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setParty(List<CounterpartyRoleEnum> party);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setIsSpecified(Boolean isSpecified);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrency(FieldWithMetaString currency);
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrencyValue(String currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCurrency());
		}
		

		TerminationCurrencyElection.TerminationCurrencyElectionBuilder prune();
	}

	/*********************** Immutable Implementation of TerminationCurrencyElection  ***********************/
	class TerminationCurrencyElectionImpl implements TerminationCurrencyElection {
		private final List<CounterpartyRoleEnum> party;
		private final Boolean isSpecified;
		private final FieldWithMetaString currency;
		
		protected TerminationCurrencyElectionImpl(TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder) {
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.isSpecified = builder.getIsSpecified();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public TerminationCurrencyElection build() {
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder toBuilder() {
			TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrencyElection.TerminationCurrencyElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyElection _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyElection {" +
				"party=" + this.party + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of TerminationCurrencyElection  ***********************/
	class TerminationCurrencyElectionBuilderImpl implements TerminationCurrencyElection.TerminationCurrencyElectionBuilder {
	
		protected List<CounterpartyRoleEnum> party = new ArrayList<>();
		protected Boolean isSpecified;
		protected FieldWithMetaString.FieldWithMetaStringBuilder currency;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
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
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum _party) {
			if (_party != null) {
				this.party.add(_party);
			}
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(CounterpartyRoleEnum _party, int idx) {
			getIndex(this.party, idx, () -> _party);
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder addParty(List<CounterpartyRoleEnum> partys) {
			if (partys != null) {
				for (final CounterpartyRoleEnum toAdd : partys) {
					this.party.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setParty(List<CounterpartyRoleEnum> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isSpecified")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setIsSpecified(Boolean _isSpecified) {
			this.isSpecified = _isSpecified == null ? null : _isSpecified;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrency(FieldWithMetaString _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder setCurrencyValue(String _currency) {
			this.getOrCreateCurrency().setValue(_currency);
			return this;
		}
		
		@Override
		public TerminationCurrencyElection build() {
			return new TerminationCurrencyElection.TerminationCurrencyElectionImpl(this);
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && !getParty().isEmpty()) return true;
			if (getIsSpecified()!=null) return true;
			if (getCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrencyElection.TerminationCurrencyElectionBuilder o = (TerminationCurrencyElection.TerminationCurrencyElectionBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			merger.mergeBasic(getParty(), o.getParty(), (Consumer<CounterpartyRoleEnum>) this::addParty);
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyElection _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyElectionBuilder {" +
				"party=" + this.party + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}

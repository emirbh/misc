package cdm.legaldocumentation.common;

import cdm.base.staticdata.party.Counterparty;
import cdm.legaldocumentation.common.meta.AgreementTermsMeta;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specification of the content of a legal agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="AgreementTerms", builder=AgreementTerms.AgreementTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AgreementTerms", model="cdm", builder=AgreementTerms.AgreementTermsBuilderImpl.class, version="6.23.0")
public interface AgreementTerms extends RosettaModelObject {

	AgreementTermsMeta metaData = new AgreementTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specification of the standard set of terms that define a legal agreement.
	 */
	Agreement getAgreement();
	/**
	 * Specification of whether the agreement terms have been negotiated using the clause library methodology.
	 */
	Boolean getClauseLibrary();
	/**
	 * Specification of the roles of the counterparties to the agreement.
	 */
	List<? extends Counterparty> getCounterparty();

	/*********************** Build Methods  ***********************/
	AgreementTerms build();
	
	AgreementTerms.AgreementTermsBuilder toBuilder();
	
	static AgreementTerms.AgreementTermsBuilder builder() {
		return new AgreementTerms.AgreementTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgreementTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgreementTerms> getType() {
		return AgreementTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("agreement"), processor, Agreement.class, getAgreement());
		processor.processBasic(path.newSubPath("clauseLibrary"), Boolean.class, getClauseLibrary(), this);
		processRosetta(path.newSubPath("counterparty"), processor, Counterparty.class, getCounterparty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgreementTermsBuilder extends AgreementTerms, RosettaModelObjectBuilder {
		Agreement.AgreementBuilder getOrCreateAgreement();
		@Override
		Agreement.AgreementBuilder getAgreement();
		Counterparty.CounterpartyBuilder getOrCreateCounterparty(int index);
		@Override
		List<? extends Counterparty.CounterpartyBuilder> getCounterparty();
		AgreementTerms.AgreementTermsBuilder setAgreement(Agreement agreement);
		AgreementTerms.AgreementTermsBuilder setClauseLibrary(Boolean clauseLibrary);
		AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty counterparty);
		AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty counterparty, int idx);
		AgreementTerms.AgreementTermsBuilder addCounterparty(List<? extends Counterparty> counterparty);
		AgreementTerms.AgreementTermsBuilder setCounterparty(List<? extends Counterparty> counterparty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("agreement"), processor, Agreement.AgreementBuilder.class, getAgreement());
			processor.processBasic(path.newSubPath("clauseLibrary"), Boolean.class, getClauseLibrary(), this);
			processRosetta(path.newSubPath("counterparty"), processor, Counterparty.CounterpartyBuilder.class, getCounterparty());
		}
		

		AgreementTerms.AgreementTermsBuilder prune();
	}

	/*********************** Immutable Implementation of AgreementTerms  ***********************/
	class AgreementTermsImpl implements AgreementTerms {
		private final Agreement agreement;
		private final Boolean clauseLibrary;
		private final List<? extends Counterparty> counterparty;
		
		protected AgreementTermsImpl(AgreementTerms.AgreementTermsBuilder builder) {
			this.agreement = ofNullable(builder.getAgreement()).map(f->f.build()).orElse(null);
			this.clauseLibrary = builder.getClauseLibrary();
			this.counterparty = ofNullable(builder.getCounterparty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("agreement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agreement")
		public Agreement getAgreement() {
			return agreement;
		}
		
		@Override
		@RosettaAttribute("clauseLibrary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clauseLibrary")
		public Boolean getClauseLibrary() {
			return clauseLibrary;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("counterparty")
		public List<? extends Counterparty> getCounterparty() {
			return counterparty;
		}
		
		@Override
		public AgreementTerms build() {
			return this;
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder toBuilder() {
			AgreementTerms.AgreementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgreementTerms.AgreementTermsBuilder builder) {
			ofNullable(getAgreement()).ifPresent(builder::setAgreement);
			ofNullable(getClauseLibrary()).ifPresent(builder::setClauseLibrary);
			ofNullable(getCounterparty()).ifPresent(builder::setCounterparty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementTerms _that = getType().cast(o);
		
			if (!Objects.equals(agreement, _that.getAgreement())) return false;
			if (!Objects.equals(clauseLibrary, _that.getClauseLibrary())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreement != null ? agreement.hashCode() : 0);
			_result = 31 * _result + (clauseLibrary != null ? clauseLibrary.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementTerms {" +
				"agreement=" + this.agreement + ", " +
				"clauseLibrary=" + this.clauseLibrary + ", " +
				"counterparty=" + this.counterparty +
			'}';
		}
	}

	/*********************** Builder Implementation of AgreementTerms  ***********************/
	class AgreementTermsBuilderImpl implements AgreementTerms.AgreementTermsBuilder {
	
		protected Agreement.AgreementBuilder agreement;
		protected Boolean clauseLibrary;
		protected List<Counterparty.CounterpartyBuilder> counterparty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("agreement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agreement")
		public Agreement.AgreementBuilder getAgreement() {
			return agreement;
		}
		
		@Override
		public Agreement.AgreementBuilder getOrCreateAgreement() {
			Agreement.AgreementBuilder result;
			if (agreement!=null) {
				result = agreement;
			}
			else {
				result = agreement = Agreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clauseLibrary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clauseLibrary")
		public Boolean getClauseLibrary() {
			return clauseLibrary;
		}
		
		@Override
		@RosettaAttribute("counterparty")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("counterparty")
		public List<? extends Counterparty.CounterpartyBuilder> getCounterparty() {
			return counterparty;
		}
		
		@Override
		public Counterparty.CounterpartyBuilder getOrCreateCounterparty(int index) {
			if (counterparty==null) {
				this.counterparty = new ArrayList<>();
			}
			return getIndex(counterparty, index, () -> {
						Counterparty.CounterpartyBuilder newCounterparty = Counterparty.builder();
						return newCounterparty;
					});
		}
		
		@RosettaAttribute("agreement")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agreement")
		@Override
		public AgreementTerms.AgreementTermsBuilder setAgreement(Agreement _agreement) {
			this.agreement = _agreement == null ? null : _agreement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clauseLibrary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clauseLibrary")
		@Override
		public AgreementTerms.AgreementTermsBuilder setClauseLibrary(Boolean _clauseLibrary) {
			this.clauseLibrary = _clauseLibrary == null ? null : _clauseLibrary;
			return this;
		}
		
		@RosettaAttribute("counterparty")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("counterparty")
		@Override
		public AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty _counterparty) {
			if (_counterparty != null) {
				this.counterparty.add(_counterparty.toBuilder());
			}
			return this;
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder addCounterparty(Counterparty _counterparty, int idx) {
			getIndex(this.counterparty, idx, () -> _counterparty.toBuilder());
			return this;
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder addCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys != null) {
				for (final Counterparty toAdd : counterpartys) {
					this.counterparty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("counterparty")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("counterparty")
		@Override
		public AgreementTerms.AgreementTermsBuilder setCounterparty(List<? extends Counterparty> counterpartys) {
			if (counterpartys == null) {
				this.counterparty = new ArrayList<>();
			} else {
				this.counterparty = counterpartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AgreementTerms build() {
			return new AgreementTerms.AgreementTermsImpl(this);
		}
		
		@Override
		public AgreementTerms.AgreementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementTerms.AgreementTermsBuilder prune() {
			if (agreement!=null && !agreement.prune().hasData()) agreement = null;
			counterparty = counterparty.stream().filter(b->b!=null).<Counterparty.CounterpartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgreement()!=null && getAgreement().hasData()) return true;
			if (getClauseLibrary()!=null) return true;
			if (getCounterparty()!=null && getCounterparty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementTerms.AgreementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgreementTerms.AgreementTermsBuilder o = (AgreementTerms.AgreementTermsBuilder) other;
			
			merger.mergeRosetta(getAgreement(), o.getAgreement(), this::setAgreement);
			merger.mergeRosetta(getCounterparty(), o.getCounterparty(), this::getOrCreateCounterparty);
			
			merger.mergeBasic(getClauseLibrary(), o.getClauseLibrary(), this::setClauseLibrary);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementTerms _that = getType().cast(o);
		
			if (!Objects.equals(agreement, _that.getAgreement())) return false;
			if (!Objects.equals(clauseLibrary, _that.getClauseLibrary())) return false;
			if (!ListEquals.listEquals(counterparty, _that.getCounterparty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agreement != null ? agreement.hashCode() : 0);
			_result = 31 * _result + (clauseLibrary != null ? clauseLibrary.hashCode() : 0);
			_result = 31 * _result + (counterparty != null ? counterparty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgreementTermsBuilder {" +
				"agreement=" + this.agreement + ", " +
				"clauseLibrary=" + this.clauseLibrary + ", " +
				"counterparty=" + this.counterparty +
			'}';
		}
	}
}

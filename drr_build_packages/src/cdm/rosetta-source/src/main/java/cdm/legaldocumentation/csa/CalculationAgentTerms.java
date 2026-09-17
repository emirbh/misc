package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.CalculationAgentTermsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Calculation Agent for purposes of Initial or Variation Margin agreements.
 * @version 6.23.0
 */
@RosettaDataType(value="CalculationAgentTerms", builder=CalculationAgentTerms.CalculationAgentTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CalculationAgentTerms", model="cdm", builder=CalculationAgentTerms.CalculationAgentTermsBuilderImpl.class, version="6.23.0")
public interface CalculationAgentTerms extends RosettaModelObject {

	CalculationAgentTermsMeta metaData = new CalculationAgentTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party which is specified as Calculation Agent for Initial Margin.
	 */
	List<CounterpartyRoleEnum> getParty();
	/**
	 * The Calculation Agent (IM) terms when specified.
	 */
	String getBespokeCalculationAgentTerms();

	/*********************** Build Methods  ***********************/
	CalculationAgentTerms build();
	
	CalculationAgentTerms.CalculationAgentTermsBuilder toBuilder();
	
	static CalculationAgentTerms.CalculationAgentTermsBuilder builder() {
		return new CalculationAgentTerms.CalculationAgentTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationAgentTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationAgentTerms> getType() {
		return CalculationAgentTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("bespokeCalculationAgentTerms"), String.class, getBespokeCalculationAgentTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationAgentTermsBuilder extends CalculationAgentTerms, RosettaModelObjectBuilder {
		CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum party);
		CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum party, int idx);
		CalculationAgentTerms.CalculationAgentTermsBuilder addParty(List<CounterpartyRoleEnum> party);
		CalculationAgentTerms.CalculationAgentTermsBuilder setParty(List<CounterpartyRoleEnum> party);
		CalculationAgentTerms.CalculationAgentTermsBuilder setBespokeCalculationAgentTerms(String bespokeCalculationAgentTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("bespokeCalculationAgentTerms"), String.class, getBespokeCalculationAgentTerms(), this);
		}
		

		CalculationAgentTerms.CalculationAgentTermsBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationAgentTerms  ***********************/
	class CalculationAgentTermsImpl implements CalculationAgentTerms {
		private final List<CounterpartyRoleEnum> party;
		private final String bespokeCalculationAgentTerms;
		
		protected CalculationAgentTermsImpl(CalculationAgentTerms.CalculationAgentTermsBuilder builder) {
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.bespokeCalculationAgentTerms = builder.getBespokeCalculationAgentTerms();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("party")
		public List<CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationAgentTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationAgentTerms")
		public String getBespokeCalculationAgentTerms() {
			return bespokeCalculationAgentTerms;
		}
		
		@Override
		public CalculationAgentTerms build() {
			return this;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder toBuilder() {
			CalculationAgentTerms.CalculationAgentTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAgentTerms.CalculationAgentTermsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getBespokeCalculationAgentTerms()).ifPresent(builder::setBespokeCalculationAgentTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgentTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(bespokeCalculationAgentTerms, _that.getBespokeCalculationAgentTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (bespokeCalculationAgentTerms != null ? bespokeCalculationAgentTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgentTerms {" +
				"party=" + this.party + ", " +
				"bespokeCalculationAgentTerms=" + this.bespokeCalculationAgentTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationAgentTerms  ***********************/
	class CalculationAgentTermsBuilderImpl implements CalculationAgentTerms.CalculationAgentTermsBuilder {
	
		protected List<CounterpartyRoleEnum> party = new ArrayList<>();
		protected String bespokeCalculationAgentTerms;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("party")
		public List<CounterpartyRoleEnum> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("bespokeCalculationAgentTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCalculationAgentTerms")
		public String getBespokeCalculationAgentTerms() {
			return bespokeCalculationAgentTerms;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum _party) {
			if (_party != null) {
				this.party.add(_party);
			}
			return this;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder addParty(CounterpartyRoleEnum _party, int idx) {
			getIndex(this.party, idx, () -> _party);
			return this;
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder addParty(List<CounterpartyRoleEnum> partys) {
			if (partys != null) {
				for (final CounterpartyRoleEnum toAdd : partys) {
					this.party.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder setParty(List<CounterpartyRoleEnum> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("bespokeCalculationAgentTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeCalculationAgentTerms")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder setBespokeCalculationAgentTerms(String _bespokeCalculationAgentTerms) {
			this.bespokeCalculationAgentTerms = _bespokeCalculationAgentTerms == null ? null : _bespokeCalculationAgentTerms;
			return this;
		}
		
		@Override
		public CalculationAgentTerms build() {
			return new CalculationAgentTerms.CalculationAgentTermsImpl(this);
		}
		
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && !getParty().isEmpty()) return true;
			if (getBespokeCalculationAgentTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgentTerms.CalculationAgentTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationAgentTerms.CalculationAgentTermsBuilder o = (CalculationAgentTerms.CalculationAgentTermsBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), (Consumer<CounterpartyRoleEnum>) this::addParty);
			merger.mergeBasic(getBespokeCalculationAgentTerms(), o.getBespokeCalculationAgentTerms(), this::setBespokeCalculationAgentTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgentTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(bespokeCalculationAgentTerms, _that.getBespokeCalculationAgentTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (bespokeCalculationAgentTerms != null ? bespokeCalculationAgentTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgentTermsBuilder {" +
				"party=" + this.party + ", " +
				"bespokeCalculationAgentTerms=" + this.bespokeCalculationAgentTerms +
			'}';
		}
	}
}

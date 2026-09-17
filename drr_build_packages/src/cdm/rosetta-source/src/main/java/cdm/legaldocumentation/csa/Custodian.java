package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CustodianMeta;
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
 * A class to specify the custodian and custody account details for each party to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="Custodian", builder=Custodian.CustodianBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Custodian", model="cdm", builder=Custodian.CustodianBuilderImpl.class, version="6.23.0")
public interface Custodian extends RosettaModelObject {

	CustodianMeta metaData = new CustodianMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party specific elections.
	 */
	List<? extends CustodianElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	Custodian build();
	
	Custodian.CustodianBuilder toBuilder();
	
	static Custodian.CustodianBuilder builder() {
		return new Custodian.CustodianBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Custodian> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Custodian> getType() {
		return Custodian.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, CustodianElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianBuilder extends Custodian, RosettaModelObjectBuilder {
		CustodianElection.CustodianElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends CustodianElection.CustodianElectionBuilder> getPartyElection();
		Custodian.CustodianBuilder addPartyElection(CustodianElection partyElection);
		Custodian.CustodianBuilder addPartyElection(CustodianElection partyElection, int idx);
		Custodian.CustodianBuilder addPartyElection(List<? extends CustodianElection> partyElection);
		Custodian.CustodianBuilder setPartyElection(List<? extends CustodianElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, CustodianElection.CustodianElectionBuilder.class, getPartyElection());
		}
		

		Custodian.CustodianBuilder prune();
	}

	/*********************** Immutable Implementation of Custodian  ***********************/
	class CustodianImpl implements Custodian {
		private final List<? extends CustodianElection> partyElection;
		
		protected CustodianImpl(Custodian.CustodianBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CustodianElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public Custodian build() {
			return this;
		}
		
		@Override
		public Custodian.CustodianBuilder toBuilder() {
			Custodian.CustodianBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Custodian.CustodianBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Custodian _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Custodian {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of Custodian  ***********************/
	class CustodianBuilderImpl implements Custodian.CustodianBuilder {
	
		protected List<CustodianElection.CustodianElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CustodianElection.CustodianElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CustodianElection.CustodianElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						CustodianElection.CustodianElectionBuilder newPartyElection = CustodianElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public Custodian.CustodianBuilder addPartyElection(CustodianElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public Custodian.CustodianBuilder addPartyElection(CustodianElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public Custodian.CustodianBuilder addPartyElection(List<? extends CustodianElection> partyElections) {
			if (partyElections != null) {
				for (final CustodianElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public Custodian.CustodianBuilder setPartyElection(List<? extends CustodianElection> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Custodian build() {
			return new Custodian.CustodianImpl(this);
		}
		
		@Override
		public Custodian.CustodianBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Custodian.CustodianBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CustodianElection.CustodianElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Custodian.CustodianBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Custodian.CustodianBuilder o = (Custodian.CustodianBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Custodian _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}

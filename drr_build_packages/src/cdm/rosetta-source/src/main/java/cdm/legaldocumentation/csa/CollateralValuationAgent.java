package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CollateralValuationAgentMeta;
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
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Collateral Valuation Agent terms.
 * @version 6.23.0
 */
@RosettaDataType(value="CollateralValuationAgent", builder=CollateralValuationAgent.CollateralValuationAgentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralValuationAgent", model="cdm", builder=CollateralValuationAgent.CollateralValuationAgentBuilderImpl.class, version="6.23.0")
public interface CollateralValuationAgent extends RosettaModelObject {

	CollateralValuationAgentMeta metaData = new CollateralValuationAgentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties Collateral Valuation Agent Elections.
	 */
	List<? extends CollateralValuationAgentElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	CollateralValuationAgent build();
	
	CollateralValuationAgent.CollateralValuationAgentBuilder toBuilder();
	
	static CollateralValuationAgent.CollateralValuationAgentBuilder builder() {
		return new CollateralValuationAgent.CollateralValuationAgentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralValuationAgent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralValuationAgent> getType() {
		return CollateralValuationAgent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, CollateralValuationAgentElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralValuationAgentBuilder extends CollateralValuationAgent, RosettaModelObjectBuilder {
		CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder> getPartyElection();
		CollateralValuationAgent.CollateralValuationAgentBuilder addPartyElection(CollateralValuationAgentElection partyElection);
		CollateralValuationAgent.CollateralValuationAgentBuilder addPartyElection(CollateralValuationAgentElection partyElection, int idx);
		CollateralValuationAgent.CollateralValuationAgentBuilder addPartyElection(List<? extends CollateralValuationAgentElection> partyElection);
		CollateralValuationAgent.CollateralValuationAgentBuilder setPartyElection(List<? extends CollateralValuationAgentElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder.class, getPartyElection());
		}
		

		CollateralValuationAgent.CollateralValuationAgentBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralValuationAgent  ***********************/
	class CollateralValuationAgentImpl implements CollateralValuationAgent {
		private final List<? extends CollateralValuationAgentElection> partyElection;
		
		protected CollateralValuationAgentImpl(CollateralValuationAgent.CollateralValuationAgentBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CollateralValuationAgentElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CollateralValuationAgent build() {
			return this;
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder toBuilder() {
			CollateralValuationAgent.CollateralValuationAgentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValuationAgent.CollateralValuationAgentBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationAgent _that = getType().cast(o);
		
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
			return "CollateralValuationAgent {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralValuationAgent  ***********************/
	class CollateralValuationAgentBuilderImpl implements CollateralValuationAgent.CollateralValuationAgentBuilder {
	
		protected List<CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder newPartyElection = CollateralValuationAgentElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder addPartyElection(CollateralValuationAgentElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder addPartyElection(CollateralValuationAgentElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder addPartyElection(List<? extends CollateralValuationAgentElection> partyElections) {
			if (partyElections != null) {
				for (final CollateralValuationAgentElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder setPartyElection(List<? extends CollateralValuationAgentElection> partyElections) {
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
		public CollateralValuationAgent build() {
			return new CollateralValuationAgent.CollateralValuationAgentImpl(this);
		}
		
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationAgent.CollateralValuationAgentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValuationAgent.CollateralValuationAgentBuilder o = (CollateralValuationAgent.CollateralValuationAgentBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationAgent _that = getType().cast(o);
		
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
			return "CollateralValuationAgentBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}

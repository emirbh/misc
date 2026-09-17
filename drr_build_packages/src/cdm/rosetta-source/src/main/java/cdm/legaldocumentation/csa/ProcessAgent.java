package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ProcessAgentMeta;
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
 * A class to specify the Process Agent that might be appointed by the parties as part of a Credit Support Annex/Deed or Collateral Transfer Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="ProcessAgent", builder=ProcessAgent.ProcessAgentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ProcessAgent", model="cdm", builder=ProcessAgent.ProcessAgentBuilderImpl.class, version="6.23.0")
public interface ProcessAgent extends RosettaModelObject {

	ProcessAgentMeta metaData = new ProcessAgentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; Process Agent election.
	 */
	List<? extends ProcessAgentElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	ProcessAgent build();
	
	ProcessAgent.ProcessAgentBuilder toBuilder();
	
	static ProcessAgent.ProcessAgentBuilder builder() {
		return new ProcessAgent.ProcessAgentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProcessAgent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProcessAgent> getType() {
		return ProcessAgent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, ProcessAgentElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProcessAgentBuilder extends ProcessAgent, RosettaModelObjectBuilder {
		ProcessAgentElection.ProcessAgentElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends ProcessAgentElection.ProcessAgentElectionBuilder> getPartyElection();
		ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection partyElection);
		ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection partyElection, int idx);
		ProcessAgent.ProcessAgentBuilder addPartyElection(List<? extends ProcessAgentElection> partyElection);
		ProcessAgent.ProcessAgentBuilder setPartyElection(List<? extends ProcessAgentElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, ProcessAgentElection.ProcessAgentElectionBuilder.class, getPartyElection());
		}
		

		ProcessAgent.ProcessAgentBuilder prune();
	}

	/*********************** Immutable Implementation of ProcessAgent  ***********************/
	class ProcessAgentImpl implements ProcessAgent {
		private final List<? extends ProcessAgentElection> partyElection;
		
		protected ProcessAgentImpl(ProcessAgent.ProcessAgentBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends ProcessAgentElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public ProcessAgent build() {
			return this;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder toBuilder() {
			ProcessAgent.ProcessAgentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProcessAgent.ProcessAgentBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgent _that = getType().cast(o);
		
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
			return "ProcessAgent {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of ProcessAgent  ***********************/
	class ProcessAgentBuilderImpl implements ProcessAgent.ProcessAgentBuilder {
	
		protected List<ProcessAgentElection.ProcessAgentElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends ProcessAgentElection.ProcessAgentElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						ProcessAgentElection.ProcessAgentElectionBuilder newPartyElection = ProcessAgentElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder addPartyElection(ProcessAgentElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder addPartyElection(List<? extends ProcessAgentElection> partyElections) {
			if (partyElections != null) {
				for (final ProcessAgentElection toAdd : partyElections) {
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
		public ProcessAgent.ProcessAgentBuilder setPartyElection(List<? extends ProcessAgentElection> partyElections) {
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
		public ProcessAgent build() {
			return new ProcessAgent.ProcessAgentImpl(this);
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgent.ProcessAgentBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<ProcessAgentElection.ProcessAgentElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgent.ProcessAgentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProcessAgent.ProcessAgentBuilder o = (ProcessAgent.ProcessAgentBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgent _that = getType().cast(o);
		
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
			return "ProcessAgentBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}

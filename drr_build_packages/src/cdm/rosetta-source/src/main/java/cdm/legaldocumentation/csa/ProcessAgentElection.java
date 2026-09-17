package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyContactInformation;
import cdm.legaldocumentation.csa.meta.ProcessAgentElectionMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the parties&#39; respective elections with respect to the Process Agent.
 * @version 6.23.0
 */
@RosettaDataType(value="ProcessAgentElection", builder=ProcessAgentElection.ProcessAgentElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ProcessAgentElection", model="cdm", builder=ProcessAgentElection.ProcessAgentElectionBuilderImpl.class, version="6.23.0")
public interface ProcessAgentElection extends RosettaModelObject {

	ProcessAgentElectionMeta metaData = new ProcessAgentElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The qualification of whether the Process Agent is applicable (True) or not applicable (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The Process Agent specification, when applicable.
	 */
	PartyContactInformation getProcessAgent();

	/*********************** Build Methods  ***********************/
	ProcessAgentElection build();
	
	ProcessAgentElection.ProcessAgentElectionBuilder toBuilder();
	
	static ProcessAgentElection.ProcessAgentElectionBuilder builder() {
		return new ProcessAgentElection.ProcessAgentElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProcessAgentElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProcessAgentElection> getType() {
		return ProcessAgentElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processRosetta(path.newSubPath("processAgent"), processor, PartyContactInformation.class, getProcessAgent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProcessAgentElectionBuilder extends ProcessAgentElection, RosettaModelObjectBuilder {
		PartyContactInformation.PartyContactInformationBuilder getOrCreateProcessAgent();
		@Override
		PartyContactInformation.PartyContactInformationBuilder getProcessAgent();
		ProcessAgentElection.ProcessAgentElectionBuilder setParty(CounterpartyRoleEnum party);
		ProcessAgentElection.ProcessAgentElectionBuilder setIsApplicable(Boolean isApplicable);
		ProcessAgentElection.ProcessAgentElectionBuilder setProcessAgent(PartyContactInformation processAgent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processRosetta(path.newSubPath("processAgent"), processor, PartyContactInformation.PartyContactInformationBuilder.class, getProcessAgent());
		}
		

		ProcessAgentElection.ProcessAgentElectionBuilder prune();
	}

	/*********************** Immutable Implementation of ProcessAgentElection  ***********************/
	class ProcessAgentElectionImpl implements ProcessAgentElection {
		private final CounterpartyRoleEnum party;
		private final Boolean isApplicable;
		private final PartyContactInformation processAgent;
		
		protected ProcessAgentElectionImpl(ProcessAgentElection.ProcessAgentElectionBuilder builder) {
			this.party = builder.getParty();
			this.isApplicable = builder.getIsApplicable();
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processAgent")
		public PartyContactInformation getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public ProcessAgentElection build() {
			return this;
		}
		
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder toBuilder() {
			ProcessAgentElection.ProcessAgentElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProcessAgentElection.ProcessAgentElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProcessAgentElection {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"processAgent=" + this.processAgent +
			'}';
		}
	}

	/*********************** Builder Implementation of ProcessAgentElection  ***********************/
	class ProcessAgentElectionBuilderImpl implements ProcessAgentElection.ProcessAgentElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean isApplicable;
		protected PartyContactInformation.PartyContactInformationBuilder processAgent;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processAgent")
		public PartyContactInformation.PartyContactInformationBuilder getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public PartyContactInformation.PartyContactInformationBuilder getOrCreateProcessAgent() {
			PartyContactInformation.PartyContactInformationBuilder result;
			if (processAgent!=null) {
				result = processAgent;
			}
			else {
				result = processAgent = PartyContactInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("processAgent")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder setProcessAgent(PartyContactInformation _processAgent) {
			this.processAgent = _processAgent == null ? null : _processAgent.toBuilder();
			return this;
		}
		
		@Override
		public ProcessAgentElection build() {
			return new ProcessAgentElection.ProcessAgentElectionImpl(this);
		}
		
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder prune() {
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIsApplicable()!=null) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProcessAgentElection.ProcessAgentElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProcessAgentElection.ProcessAgentElectionBuilder o = (ProcessAgentElection.ProcessAgentElectionBuilder) other;
			
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProcessAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProcessAgentElectionBuilder {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable + ", " +
				"processAgent=" + this.processAgent +
			'}';
		}
	}
}

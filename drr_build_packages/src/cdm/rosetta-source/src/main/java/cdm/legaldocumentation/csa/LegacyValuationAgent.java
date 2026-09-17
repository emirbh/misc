package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyValuationAgentMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Details of the party calculating the value of collateral to be delivered or returned.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyValuationAgent", builder=LegacyValuationAgent.LegacyValuationAgentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyValuationAgent", model="cdm", builder=LegacyValuationAgent.LegacyValuationAgentBuilderImpl.class, version="6.23.0")
public interface LegacyValuationAgent extends RosettaModelObject {

	LegacyValuationAgentMeta metaData = new LegacyValuationAgentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	ValuationAgentPartyEnum getParty();
	/**
	 * Specifies how the Valuation Agent is determined.
	 */
	LegacyValuationAgentEnum getValuationAgent();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyValuationAgent build();
	
	LegacyValuationAgent.LegacyValuationAgentBuilder toBuilder();
	
	static LegacyValuationAgent.LegacyValuationAgentBuilder builder() {
		return new LegacyValuationAgent.LegacyValuationAgentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyValuationAgent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyValuationAgent> getType() {
		return LegacyValuationAgent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), ValuationAgentPartyEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("valuationAgent"), LegacyValuationAgentEnum.class, getValuationAgent(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyValuationAgentBuilder extends LegacyValuationAgent, RosettaModelObjectBuilder {
		LegacyValuationAgent.LegacyValuationAgentBuilder setParty(ValuationAgentPartyEnum party);
		LegacyValuationAgent.LegacyValuationAgentBuilder setValuationAgent(LegacyValuationAgentEnum valuationAgent);
		LegacyValuationAgent.LegacyValuationAgentBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), ValuationAgentPartyEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("valuationAgent"), LegacyValuationAgentEnum.class, getValuationAgent(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyValuationAgent.LegacyValuationAgentBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyValuationAgent  ***********************/
	class LegacyValuationAgentImpl implements LegacyValuationAgent {
		private final ValuationAgentPartyEnum party;
		private final LegacyValuationAgentEnum valuationAgent;
		private final String additionalLanguage;
		
		protected LegacyValuationAgentImpl(LegacyValuationAgent.LegacyValuationAgentBuilder builder) {
			this.party = builder.getParty();
			this.valuationAgent = builder.getValuationAgent();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public ValuationAgentPartyEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("valuationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAgent")
		public LegacyValuationAgentEnum getValuationAgent() {
			return valuationAgent;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyValuationAgent build() {
			return this;
		}
		
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder toBuilder() {
			LegacyValuationAgent.LegacyValuationAgentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyValuationAgent.LegacyValuationAgentBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getValuationAgent()).ifPresent(builder::setValuationAgent);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyValuationAgent _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(valuationAgent, _that.getValuationAgent())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationAgent != null ? valuationAgent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyValuationAgent {" +
				"party=" + this.party + ", " +
				"valuationAgent=" + this.valuationAgent + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyValuationAgent  ***********************/
	class LegacyValuationAgentBuilderImpl implements LegacyValuationAgent.LegacyValuationAgentBuilder {
	
		protected ValuationAgentPartyEnum party;
		protected LegacyValuationAgentEnum valuationAgent;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public ValuationAgentPartyEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("valuationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAgent")
		public LegacyValuationAgentEnum getValuationAgent() {
			return valuationAgent;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("party")
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder setParty(ValuationAgentPartyEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("valuationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAgent")
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder setValuationAgent(LegacyValuationAgentEnum _valuationAgent) {
			this.valuationAgent = _valuationAgent == null ? null : _valuationAgent;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyValuationAgent build() {
			return new LegacyValuationAgent.LegacyValuationAgentImpl(this);
		}
		
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getValuationAgent()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyValuationAgent.LegacyValuationAgentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyValuationAgent.LegacyValuationAgentBuilder o = (LegacyValuationAgent.LegacyValuationAgentBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getValuationAgent(), o.getValuationAgent(), this::setValuationAgent);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyValuationAgent _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(valuationAgent, _that.getValuationAgent())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationAgent != null ? valuationAgent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyValuationAgentBuilder {" +
				"party=" + this.party + ", " +
				"valuationAgent=" + this.valuationAgent + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}

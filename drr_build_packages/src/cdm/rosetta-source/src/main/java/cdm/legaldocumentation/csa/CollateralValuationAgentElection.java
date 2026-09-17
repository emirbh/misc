package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.CollateralValuationAgentElectionMeta;
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
 * A class to specify Collateral Valuation Agent language.
 * @version 6.23.0
 */
@RosettaDataType(value="CollateralValuationAgentElection", builder=CollateralValuationAgentElection.CollateralValuationAgentElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralValuationAgentElection", model="cdm", builder=CollateralValuationAgentElection.CollateralValuationAgentElectionBuilderImpl.class, version="6.23.0")
public interface CollateralValuationAgentElection extends RosettaModelObject {

	CollateralValuationAgentElectionMeta metaData = new CollateralValuationAgentElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	CollateralValuationAgentElection build();
	
	CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder toBuilder();
	
	static CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder() {
		return new CollateralValuationAgentElection.CollateralValuationAgentElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralValuationAgentElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralValuationAgentElection> getType() {
		return CollateralValuationAgentElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralValuationAgentElectionBuilder extends CollateralValuationAgentElection, RosettaModelObjectBuilder {
		CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setParty(CounterpartyRoleEnum party);
		CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralValuationAgentElection  ***********************/
	class CollateralValuationAgentElectionImpl implements CollateralValuationAgentElection {
		private final CounterpartyRoleEnum party;
		private final String additionalLanguage;
		
		protected CollateralValuationAgentElectionImpl(CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder) {
			this.party = builder.getParty();
			this.additionalLanguage = builder.getAdditionalLanguage();
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
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public CollateralValuationAgentElection build() {
			return this;
		}
		
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder toBuilder() {
			CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationAgentElection {" +
				"party=" + this.party + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralValuationAgentElection  ***********************/
	class CollateralValuationAgentElectionBuilderImpl implements CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
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
		@Required
		@RuneAttribute("party")
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public CollateralValuationAgentElection build() {
			return new CollateralValuationAgentElection.CollateralValuationAgentElectionImpl(this);
		}
		
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder o = (CollateralValuationAgentElection.CollateralValuationAgentElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValuationAgentElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValuationAgentElectionBuilder {" +
				"party=" + this.party + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}

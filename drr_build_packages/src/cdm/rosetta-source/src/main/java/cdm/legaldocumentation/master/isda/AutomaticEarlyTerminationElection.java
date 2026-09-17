package cdm.legaldocumentation.master.isda;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.master.isda.meta.AutomaticEarlyTerminationElectionMeta;
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
 * A class to specify the party elections specific to the Automatic Early Termination Clause.
 * @version 6.23.0
 */
@RosettaDataType(value="AutomaticEarlyTerminationElection", builder=AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AutomaticEarlyTerminationElection", model="cdm", builder=AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilderImpl.class, version="6.23.0")
public interface AutomaticEarlyTerminationElection extends RosettaModelObject {

	AutomaticEarlyTerminationElectionMeta metaData = new AutomaticEarlyTerminationElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party for which the Automatic Early Termination provisions are being specified.
	 */
	Party getParty();
	/**
	 * A boolean election to specify whether the Automatic Early Termination provisions of Section 6(a) are applicable (True) or not applicable (False).
	 */
	Boolean getIsApplicable();

	/*********************** Build Methods  ***********************/
	AutomaticEarlyTerminationElection build();
	
	AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder toBuilder();
	
	static AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder() {
		return new AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AutomaticEarlyTerminationElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AutomaticEarlyTerminationElection> getType() {
		return AutomaticEarlyTerminationElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AutomaticEarlyTerminationElectionBuilder extends AutomaticEarlyTerminationElection, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setParty(Party party);
		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setIsApplicable(Boolean isApplicable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		}
		

		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder prune();
	}

	/*********************** Immutable Implementation of AutomaticEarlyTerminationElection  ***********************/
	class AutomaticEarlyTerminationElectionImpl implements AutomaticEarlyTerminationElection {
		private final Party party;
		private final Boolean isApplicable;
		
		protected AutomaticEarlyTerminationElectionImpl(AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder) {
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.isApplicable = builder.getIsApplicable();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party getParty() {
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
		public AutomaticEarlyTerminationElection build() {
			return this;
		}
		
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder toBuilder() {
			AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTerminationElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTerminationElection {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}

	/*********************** Builder Implementation of AutomaticEarlyTerminationElection  ***********************/
	class AutomaticEarlyTerminationElectionBuilderImpl implements AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder {
	
		protected Party.PartyBuilder party;
		protected Boolean isApplicable;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@Override
		public AutomaticEarlyTerminationElection build() {
			return new AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionImpl(this);
		}
		
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().hasData()) return true;
			if (getIsApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder o = (AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTerminationElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTerminationElectionBuilder {" +
				"party=" + this.party + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}

package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.ControlAgreementElectionsMeta;
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
 * A class to specify the Control Agreement election sby each party to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="ControlAgreementElections", builder=ControlAgreementElections.ControlAgreementElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ControlAgreementElections", model="cdm", builder=ControlAgreementElections.ControlAgreementElectionsBuilderImpl.class, version="6.23.0")
public interface ControlAgreementElections extends RosettaModelObject {

	ControlAgreementElectionsMeta metaData = new ControlAgreementElectionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The identification of whether the Control Agreement is a Credit Support Document with respect to each party.
	 */
	Boolean getControlAgreementAsCsd();
	/**
	 * Unless specified as inapplicable in the event of any inconsistency between this Deed and the Control Agreement, this Deed will prevail over the Control Agreement.
	 */
	Boolean getConsistencyWithControlAgreement();
	/**
	 * Unless specified as inapplicable the parties recognise that the Control Agreement is a means by which the parties can perform their obligations.
	 */
	Boolean getRelationshipWithControlAgreement();

	/*********************** Build Methods  ***********************/
	ControlAgreementElections build();
	
	ControlAgreementElections.ControlAgreementElectionsBuilder toBuilder();
	
	static ControlAgreementElections.ControlAgreementElectionsBuilder builder() {
		return new ControlAgreementElections.ControlAgreementElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ControlAgreementElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ControlAgreementElections> getType() {
		return ControlAgreementElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("controlAgreementAsCsd"), Boolean.class, getControlAgreementAsCsd(), this);
		processor.processBasic(path.newSubPath("consistencyWithControlAgreement"), Boolean.class, getConsistencyWithControlAgreement(), this);
		processor.processBasic(path.newSubPath("relationshipWithControlAgreement"), Boolean.class, getRelationshipWithControlAgreement(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ControlAgreementElectionsBuilder extends ControlAgreementElections, RosettaModelObjectBuilder {
		ControlAgreementElections.ControlAgreementElectionsBuilder setParty(CounterpartyRoleEnum party);
		ControlAgreementElections.ControlAgreementElectionsBuilder setControlAgreementAsCsd(Boolean controlAgreementAsCsd);
		ControlAgreementElections.ControlAgreementElectionsBuilder setConsistencyWithControlAgreement(Boolean consistencyWithControlAgreement);
		ControlAgreementElections.ControlAgreementElectionsBuilder setRelationshipWithControlAgreement(Boolean relationshipWithControlAgreement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("controlAgreementAsCsd"), Boolean.class, getControlAgreementAsCsd(), this);
			processor.processBasic(path.newSubPath("consistencyWithControlAgreement"), Boolean.class, getConsistencyWithControlAgreement(), this);
			processor.processBasic(path.newSubPath("relationshipWithControlAgreement"), Boolean.class, getRelationshipWithControlAgreement(), this);
		}
		

		ControlAgreementElections.ControlAgreementElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of ControlAgreementElections  ***********************/
	class ControlAgreementElectionsImpl implements ControlAgreementElections {
		private final CounterpartyRoleEnum party;
		private final Boolean controlAgreementAsCsd;
		private final Boolean consistencyWithControlAgreement;
		private final Boolean relationshipWithControlAgreement;
		
		protected ControlAgreementElectionsImpl(ControlAgreementElections.ControlAgreementElectionsBuilder builder) {
			this.party = builder.getParty();
			this.controlAgreementAsCsd = builder.getControlAgreementAsCsd();
			this.consistencyWithControlAgreement = builder.getConsistencyWithControlAgreement();
			this.relationshipWithControlAgreement = builder.getRelationshipWithControlAgreement();
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
		@RosettaAttribute("controlAgreementAsCsd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("controlAgreementAsCsd")
		public Boolean getControlAgreementAsCsd() {
			return controlAgreementAsCsd;
		}
		
		@Override
		@RosettaAttribute("consistencyWithControlAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("consistencyWithControlAgreement")
		public Boolean getConsistencyWithControlAgreement() {
			return consistencyWithControlAgreement;
		}
		
		@Override
		@RosettaAttribute("relationshipWithControlAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relationshipWithControlAgreement")
		public Boolean getRelationshipWithControlAgreement() {
			return relationshipWithControlAgreement;
		}
		
		@Override
		public ControlAgreementElections build() {
			return this;
		}
		
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder toBuilder() {
			ControlAgreementElections.ControlAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ControlAgreementElections.ControlAgreementElectionsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getControlAgreementAsCsd()).ifPresent(builder::setControlAgreementAsCsd);
			ofNullable(getConsistencyWithControlAgreement()).ifPresent(builder::setConsistencyWithControlAgreement);
			ofNullable(getRelationshipWithControlAgreement()).ifPresent(builder::setRelationshipWithControlAgreement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(controlAgreementAsCsd, _that.getControlAgreementAsCsd())) return false;
			if (!Objects.equals(consistencyWithControlAgreement, _that.getConsistencyWithControlAgreement())) return false;
			if (!Objects.equals(relationshipWithControlAgreement, _that.getRelationshipWithControlAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (controlAgreementAsCsd != null ? controlAgreementAsCsd.hashCode() : 0);
			_result = 31 * _result + (consistencyWithControlAgreement != null ? consistencyWithControlAgreement.hashCode() : 0);
			_result = 31 * _result + (relationshipWithControlAgreement != null ? relationshipWithControlAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementElections {" +
				"party=" + this.party + ", " +
				"controlAgreementAsCsd=" + this.controlAgreementAsCsd + ", " +
				"consistencyWithControlAgreement=" + this.consistencyWithControlAgreement + ", " +
				"relationshipWithControlAgreement=" + this.relationshipWithControlAgreement +
			'}';
		}
	}

	/*********************** Builder Implementation of ControlAgreementElections  ***********************/
	class ControlAgreementElectionsBuilderImpl implements ControlAgreementElections.ControlAgreementElectionsBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean controlAgreementAsCsd;
		protected Boolean consistencyWithControlAgreement;
		protected Boolean relationshipWithControlAgreement;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("controlAgreementAsCsd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("controlAgreementAsCsd")
		public Boolean getControlAgreementAsCsd() {
			return controlAgreementAsCsd;
		}
		
		@Override
		@RosettaAttribute("consistencyWithControlAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("consistencyWithControlAgreement")
		public Boolean getConsistencyWithControlAgreement() {
			return consistencyWithControlAgreement;
		}
		
		@Override
		@RosettaAttribute("relationshipWithControlAgreement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relationshipWithControlAgreement")
		public Boolean getRelationshipWithControlAgreement() {
			return relationshipWithControlAgreement;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("controlAgreementAsCsd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("controlAgreementAsCsd")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setControlAgreementAsCsd(Boolean _controlAgreementAsCsd) {
			this.controlAgreementAsCsd = _controlAgreementAsCsd == null ? null : _controlAgreementAsCsd;
			return this;
		}
		
		@RosettaAttribute("consistencyWithControlAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("consistencyWithControlAgreement")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setConsistencyWithControlAgreement(Boolean _consistencyWithControlAgreement) {
			this.consistencyWithControlAgreement = _consistencyWithControlAgreement == null ? null : _consistencyWithControlAgreement;
			return this;
		}
		
		@RosettaAttribute("relationshipWithControlAgreement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relationshipWithControlAgreement")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder setRelationshipWithControlAgreement(Boolean _relationshipWithControlAgreement) {
			this.relationshipWithControlAgreement = _relationshipWithControlAgreement == null ? null : _relationshipWithControlAgreement;
			return this;
		}
		
		@Override
		public ControlAgreementElections build() {
			return new ControlAgreementElections.ControlAgreementElectionsImpl(this);
		}
		
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getControlAgreementAsCsd()!=null) return true;
			if (getConsistencyWithControlAgreement()!=null) return true;
			if (getRelationshipWithControlAgreement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ControlAgreementElections.ControlAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ControlAgreementElections.ControlAgreementElectionsBuilder o = (ControlAgreementElections.ControlAgreementElectionsBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getControlAgreementAsCsd(), o.getControlAgreementAsCsd(), this::setControlAgreementAsCsd);
			merger.mergeBasic(getConsistencyWithControlAgreement(), o.getConsistencyWithControlAgreement(), this::setConsistencyWithControlAgreement);
			merger.mergeBasic(getRelationshipWithControlAgreement(), o.getRelationshipWithControlAgreement(), this::setRelationshipWithControlAgreement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ControlAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(controlAgreementAsCsd, _that.getControlAgreementAsCsd())) return false;
			if (!Objects.equals(consistencyWithControlAgreement, _that.getConsistencyWithControlAgreement())) return false;
			if (!Objects.equals(relationshipWithControlAgreement, _that.getRelationshipWithControlAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (controlAgreementAsCsd != null ? controlAgreementAsCsd.hashCode() : 0);
			_result = 31 * _result + (consistencyWithControlAgreement != null ? consistencyWithControlAgreement.hashCode() : 0);
			_result = 31 * _result + (relationshipWithControlAgreement != null ? relationshipWithControlAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ControlAgreementElectionsBuilder {" +
				"party=" + this.party + ", " +
				"controlAgreementAsCsd=" + this.controlAgreementAsCsd + ", " +
				"consistencyWithControlAgreement=" + this.consistencyWithControlAgreement + ", " +
				"relationshipWithControlAgreement=" + this.relationshipWithControlAgreement +
			'}';
		}
	}
}

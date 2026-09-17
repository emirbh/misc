package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.AccessConditionsElectionsMeta;
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
 * A class to specify the Termination Events that will be deemed an Access Condition or a Specified Condition.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(e) (ii)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(f) (ii)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(e) (ii)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause "(e)" * name "Conditions Precedent and Secured Partys Rights and Remedies."
 *
 * Provision 
 *
 */
@RosettaDataType(value="AccessConditionsElections", builder=AccessConditionsElections.AccessConditionsElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AccessConditionsElections", model="cdm", builder=AccessConditionsElections.AccessConditionsElectionsBuilderImpl.class, version="6.23.0")
public interface AccessConditionsElections extends RosettaModelObject {

	AccessConditionsElectionsMeta metaData = new AccessConditionsElectionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * Represents an illegality Termination Event.
	 */
	Boolean getIllegality();
	/**
	 * Represents a force Majeure Termination Event.
	 */
	Boolean getForceMajeure();
	/**
	 * Represents a Tax Termination Event.
	 */
	Boolean getTaxEvent();
	/**
	 * Represents a Tax Event Upon Merger Termination Event.
	 */
	Boolean getTaxEventUponMerger();
	/**
	 * Represents a Credit Event Upon Merger Termination Event.
	 */
	Boolean getCreditEventUponMerger();

	/*********************** Build Methods  ***********************/
	AccessConditionsElections build();
	
	AccessConditionsElections.AccessConditionsElectionsBuilder toBuilder();
	
	static AccessConditionsElections.AccessConditionsElectionsBuilder builder() {
		return new AccessConditionsElections.AccessConditionsElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccessConditionsElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccessConditionsElections> getType() {
		return AccessConditionsElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("illegality"), Boolean.class, getIllegality(), this);
		processor.processBasic(path.newSubPath("forceMajeure"), Boolean.class, getForceMajeure(), this);
		processor.processBasic(path.newSubPath("taxEvent"), Boolean.class, getTaxEvent(), this);
		processor.processBasic(path.newSubPath("taxEventUponMerger"), Boolean.class, getTaxEventUponMerger(), this);
		processor.processBasic(path.newSubPath("creditEventUponMerger"), Boolean.class, getCreditEventUponMerger(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccessConditionsElectionsBuilder extends AccessConditionsElections, RosettaModelObjectBuilder {
		AccessConditionsElections.AccessConditionsElectionsBuilder setParty(CounterpartyRoleEnum party);
		AccessConditionsElections.AccessConditionsElectionsBuilder setIllegality(Boolean illegality);
		AccessConditionsElections.AccessConditionsElectionsBuilder setForceMajeure(Boolean forceMajeure);
		AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEvent(Boolean taxEvent);
		AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEventUponMerger(Boolean taxEventUponMerger);
		AccessConditionsElections.AccessConditionsElectionsBuilder setCreditEventUponMerger(Boolean creditEventUponMerger);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("illegality"), Boolean.class, getIllegality(), this);
			processor.processBasic(path.newSubPath("forceMajeure"), Boolean.class, getForceMajeure(), this);
			processor.processBasic(path.newSubPath("taxEvent"), Boolean.class, getTaxEvent(), this);
			processor.processBasic(path.newSubPath("taxEventUponMerger"), Boolean.class, getTaxEventUponMerger(), this);
			processor.processBasic(path.newSubPath("creditEventUponMerger"), Boolean.class, getCreditEventUponMerger(), this);
		}
		

		AccessConditionsElections.AccessConditionsElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of AccessConditionsElections  ***********************/
	class AccessConditionsElectionsImpl implements AccessConditionsElections {
		private final CounterpartyRoleEnum party;
		private final Boolean illegality;
		private final Boolean forceMajeure;
		private final Boolean taxEvent;
		private final Boolean taxEventUponMerger;
		private final Boolean creditEventUponMerger;
		
		protected AccessConditionsElectionsImpl(AccessConditionsElections.AccessConditionsElectionsBuilder builder) {
			this.party = builder.getParty();
			this.illegality = builder.getIllegality();
			this.forceMajeure = builder.getForceMajeure();
			this.taxEvent = builder.getTaxEvent();
			this.taxEventUponMerger = builder.getTaxEventUponMerger();
			this.creditEventUponMerger = builder.getCreditEventUponMerger();
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
		@RosettaAttribute("illegality")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("illegality")
		public Boolean getIllegality() {
			return illegality;
		}
		
		@Override
		@RosettaAttribute("forceMajeure")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forceMajeure")
		public Boolean getForceMajeure() {
			return forceMajeure;
		}
		
		@Override
		@RosettaAttribute("taxEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taxEvent")
		public Boolean getTaxEvent() {
			return taxEvent;
		}
		
		@Override
		@RosettaAttribute("taxEventUponMerger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taxEventUponMerger")
		public Boolean getTaxEventUponMerger() {
			return taxEventUponMerger;
		}
		
		@Override
		@RosettaAttribute("creditEventUponMerger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditEventUponMerger")
		public Boolean getCreditEventUponMerger() {
			return creditEventUponMerger;
		}
		
		@Override
		public AccessConditionsElections build() {
			return this;
		}
		
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder toBuilder() {
			AccessConditionsElections.AccessConditionsElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccessConditionsElections.AccessConditionsElectionsBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIllegality()).ifPresent(builder::setIllegality);
			ofNullable(getForceMajeure()).ifPresent(builder::setForceMajeure);
			ofNullable(getTaxEvent()).ifPresent(builder::setTaxEvent);
			ofNullable(getTaxEventUponMerger()).ifPresent(builder::setTaxEventUponMerger);
			ofNullable(getCreditEventUponMerger()).ifPresent(builder::setCreditEventUponMerger);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditionsElections _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(illegality, _that.getIllegality())) return false;
			if (!Objects.equals(forceMajeure, _that.getForceMajeure())) return false;
			if (!Objects.equals(taxEvent, _that.getTaxEvent())) return false;
			if (!Objects.equals(taxEventUponMerger, _that.getTaxEventUponMerger())) return false;
			if (!Objects.equals(creditEventUponMerger, _that.getCreditEventUponMerger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (illegality != null ? illegality.hashCode() : 0);
			_result = 31 * _result + (forceMajeure != null ? forceMajeure.hashCode() : 0);
			_result = 31 * _result + (taxEvent != null ? taxEvent.hashCode() : 0);
			_result = 31 * _result + (taxEventUponMerger != null ? taxEventUponMerger.hashCode() : 0);
			_result = 31 * _result + (creditEventUponMerger != null ? creditEventUponMerger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditionsElections {" +
				"party=" + this.party + ", " +
				"illegality=" + this.illegality + ", " +
				"forceMajeure=" + this.forceMajeure + ", " +
				"taxEvent=" + this.taxEvent + ", " +
				"taxEventUponMerger=" + this.taxEventUponMerger + ", " +
				"creditEventUponMerger=" + this.creditEventUponMerger +
			'}';
		}
	}

	/*********************** Builder Implementation of AccessConditionsElections  ***********************/
	class AccessConditionsElectionsBuilderImpl implements AccessConditionsElections.AccessConditionsElectionsBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean illegality;
		protected Boolean forceMajeure;
		protected Boolean taxEvent;
		protected Boolean taxEventUponMerger;
		protected Boolean creditEventUponMerger;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("illegality")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("illegality")
		public Boolean getIllegality() {
			return illegality;
		}
		
		@Override
		@RosettaAttribute("forceMajeure")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("forceMajeure")
		public Boolean getForceMajeure() {
			return forceMajeure;
		}
		
		@Override
		@RosettaAttribute("taxEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taxEvent")
		public Boolean getTaxEvent() {
			return taxEvent;
		}
		
		@Override
		@RosettaAttribute("taxEventUponMerger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taxEventUponMerger")
		public Boolean getTaxEventUponMerger() {
			return taxEventUponMerger;
		}
		
		@Override
		@RosettaAttribute("creditEventUponMerger")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditEventUponMerger")
		public Boolean getCreditEventUponMerger() {
			return creditEventUponMerger;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("illegality")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("illegality")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setIllegality(Boolean _illegality) {
			this.illegality = _illegality == null ? null : _illegality;
			return this;
		}
		
		@RosettaAttribute("forceMajeure")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("forceMajeure")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setForceMajeure(Boolean _forceMajeure) {
			this.forceMajeure = _forceMajeure == null ? null : _forceMajeure;
			return this;
		}
		
		@RosettaAttribute("taxEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("taxEvent")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEvent(Boolean _taxEvent) {
			this.taxEvent = _taxEvent == null ? null : _taxEvent;
			return this;
		}
		
		@RosettaAttribute("taxEventUponMerger")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("taxEventUponMerger")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setTaxEventUponMerger(Boolean _taxEventUponMerger) {
			this.taxEventUponMerger = _taxEventUponMerger == null ? null : _taxEventUponMerger;
			return this;
		}
		
		@RosettaAttribute("creditEventUponMerger")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditEventUponMerger")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder setCreditEventUponMerger(Boolean _creditEventUponMerger) {
			this.creditEventUponMerger = _creditEventUponMerger == null ? null : _creditEventUponMerger;
			return this;
		}
		
		@Override
		public AccessConditionsElections build() {
			return new AccessConditionsElections.AccessConditionsElectionsImpl(this);
		}
		
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIllegality()!=null) return true;
			if (getForceMajeure()!=null) return true;
			if (getTaxEvent()!=null) return true;
			if (getTaxEventUponMerger()!=null) return true;
			if (getCreditEventUponMerger()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccessConditionsElections.AccessConditionsElectionsBuilder o = (AccessConditionsElections.AccessConditionsElectionsBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIllegality(), o.getIllegality(), this::setIllegality);
			merger.mergeBasic(getForceMajeure(), o.getForceMajeure(), this::setForceMajeure);
			merger.mergeBasic(getTaxEvent(), o.getTaxEvent(), this::setTaxEvent);
			merger.mergeBasic(getTaxEventUponMerger(), o.getTaxEventUponMerger(), this::setTaxEventUponMerger);
			merger.mergeBasic(getCreditEventUponMerger(), o.getCreditEventUponMerger(), this::setCreditEventUponMerger);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditionsElections _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(illegality, _that.getIllegality())) return false;
			if (!Objects.equals(forceMajeure, _that.getForceMajeure())) return false;
			if (!Objects.equals(taxEvent, _that.getTaxEvent())) return false;
			if (!Objects.equals(taxEventUponMerger, _that.getTaxEventUponMerger())) return false;
			if (!Objects.equals(creditEventUponMerger, _that.getCreditEventUponMerger())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (illegality != null ? illegality.hashCode() : 0);
			_result = 31 * _result + (forceMajeure != null ? forceMajeure.hashCode() : 0);
			_result = 31 * _result + (taxEvent != null ? taxEvent.hashCode() : 0);
			_result = 31 * _result + (taxEventUponMerger != null ? taxEventUponMerger.hashCode() : 0);
			_result = 31 * _result + (creditEventUponMerger != null ? creditEventUponMerger.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditionsElectionsBuilder {" +
				"party=" + this.party + ", " +
				"illegality=" + this.illegality + ", " +
				"forceMajeure=" + this.forceMajeure + ", " +
				"taxEvent=" + this.taxEvent + ", " +
				"taxEventUponMerger=" + this.taxEventUponMerger + ", " +
				"creditEventUponMerger=" + this.creditEventUponMerger +
			'}';
		}
	}
}

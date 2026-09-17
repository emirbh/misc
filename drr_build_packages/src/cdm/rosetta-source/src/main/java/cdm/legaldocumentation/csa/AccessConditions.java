package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.AccessConditionsMeta;
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
 * A class to specify each party&#39;s election with respect to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA).
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
@RosettaDataType(value="AccessConditions", builder=AccessConditions.AccessConditionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AccessConditions", model="cdm", builder=AccessConditions.AccessConditionsBuilderImpl.class, version="6.23.0")
public interface AccessConditions extends RosettaModelObject {

	AccessConditionsMeta metaData = new AccessConditionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA) election.
	 */
	List<? extends AccessConditionsElections> getPartyElection();
	/**
	 * Additional Termination Events applicable to the agreement.
	 */
	List<? extends AdditionalTerminationEvent> getAdditionalTerminationEvent();

	/*********************** Build Methods  ***********************/
	AccessConditions build();
	
	AccessConditions.AccessConditionsBuilder toBuilder();
	
	static AccessConditions.AccessConditionsBuilder builder() {
		return new AccessConditions.AccessConditionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccessConditions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccessConditions> getType() {
		return AccessConditions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, AccessConditionsElections.class, getPartyElection());
		processRosetta(path.newSubPath("additionalTerminationEvent"), processor, AdditionalTerminationEvent.class, getAdditionalTerminationEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccessConditionsBuilder extends AccessConditions, RosettaModelObjectBuilder {
		AccessConditionsElections.AccessConditionsElectionsBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends AccessConditionsElections.AccessConditionsElectionsBuilder> getPartyElection();
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder getOrCreateAdditionalTerminationEvent(int index);
		@Override
		List<? extends AdditionalTerminationEvent.AdditionalTerminationEventBuilder> getAdditionalTerminationEvent();
		AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections partyElection);
		AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections partyElection, int idx);
		AccessConditions.AccessConditionsBuilder addPartyElection(List<? extends AccessConditionsElections> partyElection);
		AccessConditions.AccessConditionsBuilder setPartyElection(List<? extends AccessConditionsElections> partyElection);
		AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent additionalTerminationEvent);
		AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent additionalTerminationEvent, int idx);
		AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvent);
		AccessConditions.AccessConditionsBuilder setAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, AccessConditionsElections.AccessConditionsElectionsBuilder.class, getPartyElection());
			processRosetta(path.newSubPath("additionalTerminationEvent"), processor, AdditionalTerminationEvent.AdditionalTerminationEventBuilder.class, getAdditionalTerminationEvent());
		}
		

		AccessConditions.AccessConditionsBuilder prune();
	}

	/*********************** Immutable Implementation of AccessConditions  ***********************/
	class AccessConditionsImpl implements AccessConditions {
		private final List<? extends AccessConditionsElections> partyElection;
		private final List<? extends AdditionalTerminationEvent> additionalTerminationEvent;
		
		protected AccessConditionsImpl(AccessConditions.AccessConditionsBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalTerminationEvent = ofNullable(builder.getAdditionalTerminationEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends AccessConditionsElections> getPartyElection() {
			return partyElection;
		}
		
		@Override
		@RosettaAttribute("additionalTerminationEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalTerminationEvent")
		public List<? extends AdditionalTerminationEvent> getAdditionalTerminationEvent() {
			return additionalTerminationEvent;
		}
		
		@Override
		public AccessConditions build() {
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder toBuilder() {
			AccessConditions.AccessConditionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccessConditions.AccessConditionsBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
			ofNullable(getAdditionalTerminationEvent()).ifPresent(builder::setAdditionalTerminationEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!ListEquals.listEquals(additionalTerminationEvent, _that.getAdditionalTerminationEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (additionalTerminationEvent != null ? additionalTerminationEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditions {" +
				"partyElection=" + this.partyElection + ", " +
				"additionalTerminationEvent=" + this.additionalTerminationEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of AccessConditions  ***********************/
	class AccessConditionsBuilderImpl implements AccessConditions.AccessConditionsBuilder {
	
		protected List<AccessConditionsElections.AccessConditionsElectionsBuilder> partyElection = new ArrayList<>();
		protected List<AdditionalTerminationEvent.AdditionalTerminationEventBuilder> additionalTerminationEvent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends AccessConditionsElections.AccessConditionsElectionsBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AccessConditionsElections.AccessConditionsElectionsBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						AccessConditionsElections.AccessConditionsElectionsBuilder newPartyElection = AccessConditionsElections.builder();
						return newPartyElection;
					});
		}
		
		@Override
		@RosettaAttribute("additionalTerminationEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalTerminationEvent")
		public List<? extends AdditionalTerminationEvent.AdditionalTerminationEventBuilder> getAdditionalTerminationEvent() {
			return additionalTerminationEvent;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder getOrCreateAdditionalTerminationEvent(int index) {
			if (additionalTerminationEvent==null) {
				this.additionalTerminationEvent = new ArrayList<>();
			}
			return getIndex(additionalTerminationEvent, index, () -> {
						AdditionalTerminationEvent.AdditionalTerminationEventBuilder newAdditionalTerminationEvent = AdditionalTerminationEvent.builder();
						return newAdditionalTerminationEvent;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addPartyElection(AccessConditionsElections _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addPartyElection(List<? extends AccessConditionsElections> partyElections) {
			if (partyElections != null) {
				for (final AccessConditionsElections toAdd : partyElections) {
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
		public AccessConditions.AccessConditionsBuilder setPartyElection(List<? extends AccessConditionsElections> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalTerminationEvent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalTerminationEvent")
		@Override
		public AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent _additionalTerminationEvent) {
			if (_additionalTerminationEvent != null) {
				this.additionalTerminationEvent.add(_additionalTerminationEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(AdditionalTerminationEvent _additionalTerminationEvent, int idx) {
			getIndex(this.additionalTerminationEvent, idx, () -> _additionalTerminationEvent.toBuilder());
			return this;
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder addAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvents) {
			if (additionalTerminationEvents != null) {
				for (final AdditionalTerminationEvent toAdd : additionalTerminationEvents) {
					this.additionalTerminationEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalTerminationEvent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalTerminationEvent")
		@Override
		public AccessConditions.AccessConditionsBuilder setAdditionalTerminationEvent(List<? extends AdditionalTerminationEvent> additionalTerminationEvents) {
			if (additionalTerminationEvents == null) {
				this.additionalTerminationEvent = new ArrayList<>();
			} else {
				this.additionalTerminationEvent = additionalTerminationEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AccessConditions build() {
			return new AccessConditions.AccessConditionsImpl(this);
		}
		
		@Override
		public AccessConditions.AccessConditionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditions.AccessConditionsBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<AccessConditionsElections.AccessConditionsElectionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalTerminationEvent = additionalTerminationEvent.stream().filter(b->b!=null).<AdditionalTerminationEvent.AdditionalTerminationEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalTerminationEvent()!=null && getAdditionalTerminationEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccessConditions.AccessConditionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccessConditions.AccessConditionsBuilder o = (AccessConditions.AccessConditionsBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			merger.mergeRosetta(getAdditionalTerminationEvent(), o.getAdditionalTerminationEvent(), this::getOrCreateAdditionalTerminationEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccessConditions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!ListEquals.listEquals(additionalTerminationEvent, _that.getAdditionalTerminationEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (additionalTerminationEvent != null ? additionalTerminationEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccessConditionsBuilder {" +
				"partyElection=" + this.partyElection + ", " +
				"additionalTerminationEvent=" + this.additionalTerminationEvent +
			'}';
		}
	}
}

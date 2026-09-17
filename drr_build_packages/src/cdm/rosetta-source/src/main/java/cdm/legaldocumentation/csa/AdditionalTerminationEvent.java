package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.AdditionalTerminationEventMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify an optional termination event, additional to the Termination Events that will be deemed an Access Condition (Initial Margin CSA) or a Specified Condition (Variation Margin CSA).
 * @version 6.23.0
 */
@RosettaDataType(value="AdditionalTerminationEvent", builder=AdditionalTerminationEvent.AdditionalTerminationEventBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AdditionalTerminationEvent", model="cdm", builder=AdditionalTerminationEvent.AdditionalTerminationEventBuilderImpl.class, version="6.23.0")
public interface AdditionalTerminationEvent extends RosettaModelObject {

	AdditionalTerminationEventMeta metaData = new AdditionalTerminationEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the additional termination event.
	 */
	String getName();
	/**
	 * Whether the additional termination event is applicable for the relevant party.
	 */
	List<CounterpartyRoleEnum> getApplicableParty();

	/*********************** Build Methods  ***********************/
	AdditionalTerminationEvent build();
	
	AdditionalTerminationEvent.AdditionalTerminationEventBuilder toBuilder();
	
	static AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder() {
		return new AdditionalTerminationEvent.AdditionalTerminationEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalTerminationEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalTerminationEvent> getType() {
		return AdditionalTerminationEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("applicableParty"), CounterpartyRoleEnum.class, getApplicableParty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalTerminationEventBuilder extends AdditionalTerminationEvent, RosettaModelObjectBuilder {
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder setName(String name);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum applicableParty);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum applicableParty, int idx);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(List<CounterpartyRoleEnum> applicableParty);
		AdditionalTerminationEvent.AdditionalTerminationEventBuilder setApplicableParty(List<CounterpartyRoleEnum> applicableParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("applicableParty"), CounterpartyRoleEnum.class, getApplicableParty(), this);
		}
		

		AdditionalTerminationEvent.AdditionalTerminationEventBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalTerminationEvent  ***********************/
	class AdditionalTerminationEventImpl implements AdditionalTerminationEvent {
		private final String name;
		private final List<CounterpartyRoleEnum> applicableParty;
		
		protected AdditionalTerminationEventImpl(AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder) {
			this.name = builder.getName();
			this.applicableParty = ofNullable(builder.getApplicableParty()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("applicableParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("applicableParty")
		public List<CounterpartyRoleEnum> getApplicableParty() {
			return applicableParty;
		}
		
		@Override
		public AdditionalTerminationEvent build() {
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder toBuilder() {
			AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalTerminationEvent.AdditionalTerminationEventBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getApplicableParty()).ifPresent(builder::setApplicableParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(applicableParty, _that.getApplicableParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (applicableParty != null ? applicableParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTerminationEvent {" +
				"name=" + this.name + ", " +
				"applicableParty=" + this.applicableParty +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalTerminationEvent  ***********************/
	class AdditionalTerminationEventBuilderImpl implements AdditionalTerminationEvent.AdditionalTerminationEventBuilder {
	
		protected String name;
		protected List<CounterpartyRoleEnum> applicableParty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("applicableParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("applicableParty")
		public List<CounterpartyRoleEnum> getApplicableParty() {
			return applicableParty;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("name")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("applicableParty")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("applicableParty")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum _applicableParty) {
			if (_applicableParty != null) {
				this.applicableParty.add(_applicableParty);
			}
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(CounterpartyRoleEnum _applicableParty, int idx) {
			getIndex(this.applicableParty, idx, () -> _applicableParty);
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder addApplicableParty(List<CounterpartyRoleEnum> applicablePartys) {
			if (applicablePartys != null) {
				for (final CounterpartyRoleEnum toAdd : applicablePartys) {
					this.applicableParty.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("applicableParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("applicableParty")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder setApplicableParty(List<CounterpartyRoleEnum> applicablePartys) {
			if (applicablePartys == null) {
				this.applicableParty = new ArrayList<>();
			} else {
				this.applicableParty = applicablePartys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AdditionalTerminationEvent build() {
			return new AdditionalTerminationEvent.AdditionalTerminationEventImpl(this);
		}
		
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getApplicableParty()!=null && !getApplicableParty().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalTerminationEvent.AdditionalTerminationEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalTerminationEvent.AdditionalTerminationEventBuilder o = (AdditionalTerminationEvent.AdditionalTerminationEventBuilder) other;
			
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getApplicableParty(), o.getApplicableParty(), (Consumer<CounterpartyRoleEnum>) this::addApplicableParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalTerminationEvent _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!ListEquals.listEquals(applicableParty, _that.getApplicableParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (applicableParty != null ? applicableParty.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalTerminationEventBuilder {" +
				"name=" + this.name + ", " +
				"applicableParty=" + this.applicableParty +
			'}';
		}
	}
}

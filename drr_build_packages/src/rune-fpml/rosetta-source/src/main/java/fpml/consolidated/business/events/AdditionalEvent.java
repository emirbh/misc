package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.AdditionalEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Abstract base type for an extension/substitution point to customize FpML and add additional events.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base type for an extension/substitution point to customize FpML and add additional events.
 *
 */
@RosettaDataType(value="AdditionalEvent", builder=AdditionalEvent.AdditionalEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdditionalEvent", model="fpml", builder=AdditionalEvent.AdditionalEventBuilderImpl.class, version="2.1.1")
public interface AdditionalEvent extends AbstractEvent {

	AdditionalEventMeta metaData = new AdditionalEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	AdditionalEvent build();
	
	AdditionalEvent.AdditionalEventBuilder toBuilder();
	
	static AdditionalEvent.AdditionalEventBuilder builder() {
		return new AdditionalEvent.AdditionalEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalEvent> getType() {
		return AdditionalEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalEventBuilder extends AdditionalEvent, AbstractEvent.AbstractEventBuilder {
		@Override
		AdditionalEvent.AdditionalEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		AdditionalEvent.AdditionalEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		AdditionalEvent.AdditionalEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		AdditionalEvent.AdditionalEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		AdditionalEvent.AdditionalEventBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalEvent  ***********************/
	class AdditionalEventImpl extends AbstractEvent.AbstractEventImpl implements AdditionalEvent {
		
		protected AdditionalEventImpl(AdditionalEvent.AdditionalEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public AdditionalEvent build() {
			return this;
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder toBuilder() {
			AdditionalEvent.AdditionalEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalEvent.AdditionalEventBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AdditionalEvent  ***********************/
	class AdditionalEventBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl implements AdditionalEvent.AdditionalEventBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AdditionalEvent.AdditionalEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public AdditionalEvent.AdditionalEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AdditionalEvent build() {
			return new AdditionalEvent.AdditionalEventImpl(this);
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalEvent.AdditionalEventBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalEvent.AdditionalEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AdditionalEvent.AdditionalEventBuilder o = (AdditionalEvent.AdditionalEventBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

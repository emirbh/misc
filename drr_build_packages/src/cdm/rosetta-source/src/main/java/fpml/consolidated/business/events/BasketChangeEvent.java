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
import fpml.consolidated.business.events.meta.BasketChangeEventMeta;
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
 * Provision A structure indicating that the basket underlyer of the trade has changed due to client trading activity
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure indicating that the basket underlyer of the trade has changed due to client trading activity
 *
 */
@RosettaDataType(value="BasketChangeEvent", builder=BasketChangeEvent.BasketChangeEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BasketChangeEvent", model="fpml", builder=BasketChangeEvent.BasketChangeEventBuilderImpl.class, version="2.1.1")
public interface BasketChangeEvent extends ChangeEvent {

	BasketChangeEventMeta metaData = new BasketChangeEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	BasketChangeEvent build();
	
	BasketChangeEvent.BasketChangeEventBuilder toBuilder();
	
	static BasketChangeEvent.BasketChangeEventBuilder builder() {
		return new BasketChangeEvent.BasketChangeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketChangeEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketChangeEvent> getType() {
		return BasketChangeEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketChangeEventBuilder extends BasketChangeEvent, ChangeEvent.ChangeEventBuilder {
		@Override
		BasketChangeEvent.BasketChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		BasketChangeEvent.BasketChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		BasketChangeEvent.BasketChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		BasketChangeEvent.BasketChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		BasketChangeEvent.BasketChangeEventBuilder prune();
	}

	/*********************** Immutable Implementation of BasketChangeEvent  ***********************/
	class BasketChangeEventImpl extends ChangeEvent.ChangeEventImpl implements BasketChangeEvent {
		
		protected BasketChangeEventImpl(BasketChangeEvent.BasketChangeEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public BasketChangeEvent build() {
			return this;
		}
		
		@Override
		public BasketChangeEvent.BasketChangeEventBuilder toBuilder() {
			BasketChangeEvent.BasketChangeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketChangeEvent.BasketChangeEventBuilder builder) {
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
			return "BasketChangeEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BasketChangeEvent  ***********************/
	class BasketChangeEventBuilderImpl extends ChangeEvent.ChangeEventBuilderImpl implements BasketChangeEvent.BasketChangeEventBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public BasketChangeEvent.BasketChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketChangeEvent.BasketChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public BasketChangeEvent.BasketChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BasketChangeEvent.BasketChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BasketChangeEvent build() {
			return new BasketChangeEvent.BasketChangeEventImpl(this);
		}
		
		@Override
		public BasketChangeEvent.BasketChangeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketChangeEvent.BasketChangeEventBuilder prune() {
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
		public BasketChangeEvent.BasketChangeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BasketChangeEvent.BasketChangeEventBuilder o = (BasketChangeEvent.BasketChangeEventBuilder) other;
			
			
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
			return "BasketChangeEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

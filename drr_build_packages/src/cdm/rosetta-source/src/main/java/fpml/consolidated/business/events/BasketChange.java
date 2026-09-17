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
import fpml.consolidated.business.events.meta.BasketChangeMeta;
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
 * Provision Describes a change due to change in composition of basket underlyer
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes a change due to change in composition of basket underlyer
 *
 */
@RosettaDataType(value="BasketChange", builder=BasketChange.BasketChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BasketChange", model="fpml", builder=BasketChange.BasketChangeBuilderImpl.class, version="2.1.1")
public interface BasketChange extends BasketChangeEvent {

	BasketChangeMeta metaData = new BasketChangeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	BasketChange build();
	
	BasketChange.BasketChangeBuilder toBuilder();
	
	static BasketChange.BasketChangeBuilder builder() {
		return new BasketChange.BasketChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketChange> getType() {
		return BasketChange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketChangeBuilder extends BasketChange, BasketChangeEvent.BasketChangeEventBuilder {
		@Override
		BasketChange.BasketChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		BasketChange.BasketChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		BasketChange.BasketChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		BasketChange.BasketChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
		}
		

		BasketChange.BasketChangeBuilder prune();
	}

	/*********************** Immutable Implementation of BasketChange  ***********************/
	class BasketChangeImpl extends BasketChangeEvent.BasketChangeEventImpl implements BasketChange {
		
		protected BasketChangeImpl(BasketChange.BasketChangeBuilder builder) {
			super(builder);
		}
		
		@Override
		public BasketChange build() {
			return this;
		}
		
		@Override
		public BasketChange.BasketChangeBuilder toBuilder() {
			BasketChange.BasketChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketChange.BasketChangeBuilder builder) {
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
			return "BasketChange {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BasketChange  ***********************/
	class BasketChangeBuilderImpl extends BasketChangeEvent.BasketChangeEventBuilderImpl implements BasketChange.BasketChangeBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public BasketChange.BasketChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public BasketChange.BasketChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public BasketChange.BasketChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BasketChange.BasketChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public BasketChange build() {
			return new BasketChange.BasketChangeImpl(this);
		}
		
		@Override
		public BasketChange.BasketChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketChange.BasketChangeBuilder prune() {
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
		public BasketChange.BasketChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BasketChange.BasketChangeBuilder o = (BasketChange.BasketChangeBuilder) other;
			
			
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
			return "BasketChangeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

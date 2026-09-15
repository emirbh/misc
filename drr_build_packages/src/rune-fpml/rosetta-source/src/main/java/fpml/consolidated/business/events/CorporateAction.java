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
import fpml.consolidated.business.events.meta.CorporateActionMeta;
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
 * Provision Describes a change due to a corporate action
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes a change due to a corporate action
 *
 */
@RosettaDataType(value="CorporateAction", builder=CorporateAction.CorporateActionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorporateAction", model="fpml", builder=CorporateAction.CorporateActionBuilderImpl.class, version="2.1.1")
public interface CorporateAction extends CorporateActionEvent {

	CorporateActionMeta metaData = new CorporateActionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CorporateAction build();
	
	CorporateAction.CorporateActionBuilder toBuilder();
	
	static CorporateAction.CorporateActionBuilder builder() {
		return new CorporateAction.CorporateActionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorporateAction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorporateAction> getType() {
		return CorporateAction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("type"), processor, CorporateActionType.class, _getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorporateActionBuilder extends CorporateAction, CorporateActionEvent.CorporateActionEventBuilder {
		@Override
		CorporateAction.CorporateActionBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		CorporateAction.CorporateActionBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		CorporateAction.CorporateActionBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CorporateAction.CorporateActionBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CorporateAction.CorporateActionBuilder setType(CorporateActionType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("type"), processor, CorporateActionType.CorporateActionTypeBuilder.class, _getType());
		}
		

		CorporateAction.CorporateActionBuilder prune();
	}

	/*********************** Immutable Implementation of CorporateAction  ***********************/
	class CorporateActionImpl extends CorporateActionEvent.CorporateActionEventImpl implements CorporateAction {
		
		protected CorporateActionImpl(CorporateAction.CorporateActionBuilder builder) {
			super(builder);
		}
		
		@Override
		public CorporateAction build() {
			return this;
		}
		
		@Override
		public CorporateAction.CorporateActionBuilder toBuilder() {
			CorporateAction.CorporateActionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorporateAction.CorporateActionBuilder builder) {
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
			return "CorporateAction {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorporateAction  ***********************/
	class CorporateActionBuilderImpl extends CorporateActionEvent.CorporateActionEventBuilderImpl implements CorporateAction.CorporateActionBuilder {
	
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public CorporateAction.CorporateActionBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CorporateAction.CorporateActionBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CorporateAction.CorporateActionBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public CorporateAction.CorporateActionBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public CorporateAction.CorporateActionBuilder setType(CorporateActionType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@Override
		public CorporateAction build() {
			return new CorporateAction.CorporateActionImpl(this);
		}
		
		@Override
		public CorporateAction.CorporateActionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateAction.CorporateActionBuilder prune() {
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
		public CorporateAction.CorporateActionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CorporateAction.CorporateActionBuilder o = (CorporateAction.CorporateActionBuilder) other;
			
			
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
			return "CorporateActionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}

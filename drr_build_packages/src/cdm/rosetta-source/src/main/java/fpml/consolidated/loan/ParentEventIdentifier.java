package fpml.consolidated.loan;

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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.EventId;
import fpml.consolidated.loan.meta.ParentEventIdentifierMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Astructure used to relate child events to one another.
 *
 */
@RosettaDataType(value="ParentEventIdentifier", builder=ParentEventIdentifier.ParentEventIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ParentEventIdentifier", model="fpml", builder=ParentEventIdentifier.ParentEventIdentifierBuilderImpl.class, version="2.1.1")
public interface ParentEventIdentifier extends BusinessEventIdentifier {

	ParentEventIdentifierMeta metaData = new ParentEventIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional array to express the unique identifiers of all underlying related child events.
	 *
	 */
	List<? extends BusinessEventIdentifier> getChildEventIdentifier();

	/*********************** Build Methods  ***********************/
	ParentEventIdentifier build();
	
	ParentEventIdentifier.ParentEventIdentifierBuilder toBuilder();
	
	static ParentEventIdentifier.ParentEventIdentifierBuilder builder() {
		return new ParentEventIdentifier.ParentEventIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParentEventIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ParentEventIdentifier> getType() {
		return ParentEventIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("eventId"), processor, EventId.class, getEventId());
		processRosetta(path.newSubPath("childEventIdentifier"), processor, BusinessEventIdentifier.class, getChildEventIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParentEventIdentifierBuilder extends ParentEventIdentifier, BusinessEventIdentifier.BusinessEventIdentifierBuilder {
		BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateChildEventIdentifier(int index);
		@Override
		List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getChildEventIdentifier();
		@Override
		ParentEventIdentifier.ParentEventIdentifierBuilder setId(String id);
		@Override
		ParentEventIdentifier.ParentEventIdentifierBuilder setPartyReference(PartyReference partyReference);
		@Override
		ParentEventIdentifier.ParentEventIdentifierBuilder setAccountReference(AccountReference accountReference);
		@Override
		ParentEventIdentifier.ParentEventIdentifierBuilder setEventId(EventId eventId);
		ParentEventIdentifier.ParentEventIdentifierBuilder addChildEventIdentifier(BusinessEventIdentifier childEventIdentifier);
		ParentEventIdentifier.ParentEventIdentifierBuilder addChildEventIdentifier(BusinessEventIdentifier childEventIdentifier, int idx);
		ParentEventIdentifier.ParentEventIdentifierBuilder addChildEventIdentifier(List<? extends BusinessEventIdentifier> childEventIdentifier);
		ParentEventIdentifier.ParentEventIdentifierBuilder setChildEventIdentifier(List<? extends BusinessEventIdentifier> childEventIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("eventId"), processor, EventId.EventIdBuilder.class, getEventId());
			processRosetta(path.newSubPath("childEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getChildEventIdentifier());
		}
		

		ParentEventIdentifier.ParentEventIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of ParentEventIdentifier  ***********************/
	class ParentEventIdentifierImpl extends BusinessEventIdentifier.BusinessEventIdentifierImpl implements ParentEventIdentifier {
		private final List<? extends BusinessEventIdentifier> childEventIdentifier;
		
		protected ParentEventIdentifierImpl(ParentEventIdentifier.ParentEventIdentifierBuilder builder) {
			super(builder);
			this.childEventIdentifier = ofNullable(builder.getChildEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("childEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("childEventIdentifier")
		public List<? extends BusinessEventIdentifier> getChildEventIdentifier() {
			return childEventIdentifier;
		}
		
		@Override
		public ParentEventIdentifier build() {
			return this;
		}
		
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder toBuilder() {
			ParentEventIdentifier.ParentEventIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParentEventIdentifier.ParentEventIdentifierBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getChildEventIdentifier()).ifPresent(builder::setChildEventIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ParentEventIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(childEventIdentifier, _that.getChildEventIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (childEventIdentifier != null ? childEventIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParentEventIdentifier {" +
				"childEventIdentifier=" + this.childEventIdentifier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ParentEventIdentifier  ***********************/
	class ParentEventIdentifierBuilderImpl extends BusinessEventIdentifier.BusinessEventIdentifierBuilderImpl implements ParentEventIdentifier.ParentEventIdentifierBuilder {
	
		protected List<BusinessEventIdentifier.BusinessEventIdentifierBuilder> childEventIdentifier = new ArrayList<>();
		
		@Override
		@RosettaAttribute("childEventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("childEventIdentifier")
		public List<? extends BusinessEventIdentifier.BusinessEventIdentifierBuilder> getChildEventIdentifier() {
			return childEventIdentifier;
		}
		
		@Override
		public BusinessEventIdentifier.BusinessEventIdentifierBuilder getOrCreateChildEventIdentifier(int index) {
			if (childEventIdentifier==null) {
				this.childEventIdentifier = new ArrayList<>();
			}
			return getIndex(childEventIdentifier, index, () -> {
						BusinessEventIdentifier.BusinessEventIdentifierBuilder newChildEventIdentifier = BusinessEventIdentifier.builder();
						return newChildEventIdentifier;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eventId")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder setEventId(EventId _eventId) {
			this.eventId = _eventId == null ? null : _eventId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("childEventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("childEventIdentifier")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder addChildEventIdentifier(BusinessEventIdentifier _childEventIdentifier) {
			if (_childEventIdentifier != null) {
				this.childEventIdentifier.add(_childEventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder addChildEventIdentifier(BusinessEventIdentifier _childEventIdentifier, int idx) {
			getIndex(this.childEventIdentifier, idx, () -> _childEventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder addChildEventIdentifier(List<? extends BusinessEventIdentifier> childEventIdentifiers) {
			if (childEventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : childEventIdentifiers) {
					this.childEventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("childEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("childEventIdentifier")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder setChildEventIdentifier(List<? extends BusinessEventIdentifier> childEventIdentifiers) {
			if (childEventIdentifiers == null) {
				this.childEventIdentifier = new ArrayList<>();
			} else {
				this.childEventIdentifier = childEventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ParentEventIdentifier build() {
			return new ParentEventIdentifier.ParentEventIdentifierImpl(this);
		}
		
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder prune() {
			super.prune();
			childEventIdentifier = childEventIdentifier.stream().filter(b->b!=null).<BusinessEventIdentifier.BusinessEventIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getChildEventIdentifier()!=null && getChildEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParentEventIdentifier.ParentEventIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ParentEventIdentifier.ParentEventIdentifierBuilder o = (ParentEventIdentifier.ParentEventIdentifierBuilder) other;
			
			merger.mergeRosetta(getChildEventIdentifier(), o.getChildEventIdentifier(), this::getOrCreateChildEventIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ParentEventIdentifier _that = getType().cast(o);
		
			if (!ListEquals.listEquals(childEventIdentifier, _that.getChildEventIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (childEventIdentifier != null ? childEventIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParentEventIdentifierBuilder {" +
				"childEventIdentifier=" + this.childEventIdentifier +
			'}' + " " + super.toString();
		}
	}
}

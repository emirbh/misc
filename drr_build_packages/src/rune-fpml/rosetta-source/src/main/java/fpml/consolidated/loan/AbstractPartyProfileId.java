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
import fpml.consolidated.loan.meta.AbstractPartyProfileIdMeta;
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
 * Provision An abstract base type that identifies a party profile.
 *
 */
@RosettaDataType(value="AbstractPartyProfileId", builder=AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractPartyProfileId", model="fpml", builder=AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl.class, version="2.1.1")
public interface AbstractPartyProfileId extends RosettaModelObject {

	AbstractPartyProfileIdMeta metaData = new AbstractPartyProfileIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends PartyProfileIdentifier> getPartyProfileIdentifier();

	/*********************** Build Methods  ***********************/
	AbstractPartyProfileId build();
	
	AbstractPartyProfileId.AbstractPartyProfileIdBuilder toBuilder();
	
	static AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder() {
		return new AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractPartyProfileId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractPartyProfileId> getType() {
		return AbstractPartyProfileId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.class, getPartyProfileIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractPartyProfileIdBuilder extends AbstractPartyProfileId, RosettaModelObjectBuilder {
		PartyProfileIdentifier.PartyProfileIdentifierBuilder getOrCreatePartyProfileIdentifier(int index);
		@Override
		List<? extends PartyProfileIdentifier.PartyProfileIdentifierBuilder> getPartyProfileIdentifier();
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier);
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier, int idx);
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier);
		AbstractPartyProfileId.AbstractPartyProfileIdBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.PartyProfileIdentifierBuilder.class, getPartyProfileIdentifier());
		}
		

		AbstractPartyProfileId.AbstractPartyProfileIdBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractPartyProfileId  ***********************/
	class AbstractPartyProfileIdImpl implements AbstractPartyProfileId {
		private final List<? extends PartyProfileIdentifier> partyProfileIdentifier;
		
		protected AbstractPartyProfileIdImpl(AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder) {
			this.partyProfileIdentifier = ofNullable(builder.getPartyProfileIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyProfileIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyProfileIdentifier")
		public List<? extends PartyProfileIdentifier> getPartyProfileIdentifier() {
			return partyProfileIdentifier;
		}
		
		@Override
		public AbstractPartyProfileId build() {
			return this;
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder toBuilder() {
			AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractPartyProfileId.AbstractPartyProfileIdBuilder builder) {
			ofNullable(getPartyProfileIdentifier()).ifPresent(builder::setPartyProfileIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractPartyProfileId _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileIdentifier, _that.getPartyProfileIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyProfileIdentifier != null ? partyProfileIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfileId {" +
				"partyProfileIdentifier=" + this.partyProfileIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractPartyProfileId  ***********************/
	class AbstractPartyProfileIdBuilderImpl implements AbstractPartyProfileId.AbstractPartyProfileIdBuilder {
	
		protected List<PartyProfileIdentifier.PartyProfileIdentifierBuilder> partyProfileIdentifier = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyProfileIdentifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyProfileIdentifier")
		public List<? extends PartyProfileIdentifier.PartyProfileIdentifierBuilder> getPartyProfileIdentifier() {
			return partyProfileIdentifier;
		}
		
		@Override
		public PartyProfileIdentifier.PartyProfileIdentifierBuilder getOrCreatePartyProfileIdentifier(int index) {
			if (partyProfileIdentifier==null) {
				this.partyProfileIdentifier = new ArrayList<>();
			}
			return getIndex(partyProfileIdentifier, index, () -> {
						PartyProfileIdentifier.PartyProfileIdentifierBuilder newPartyProfileIdentifier = PartyProfileIdentifier.builder();
						return newPartyProfileIdentifier;
					});
		}
		
		@RosettaAttribute("partyProfileIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyProfileIdentifier")
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier _partyProfileIdentifier) {
			if (_partyProfileIdentifier != null) {
				this.partyProfileIdentifier.add(_partyProfileIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(PartyProfileIdentifier _partyProfileIdentifier, int idx) {
			getIndex(this.partyProfileIdentifier, idx, () -> _partyProfileIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers != null) {
				for (final PartyProfileIdentifier toAdd : partyProfileIdentifiers) {
					this.partyProfileIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyProfileIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyProfileIdentifier")
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers == null) {
				this.partyProfileIdentifier = new ArrayList<>();
			} else {
				this.partyProfileIdentifier = partyProfileIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractPartyProfileId build() {
			return new AbstractPartyProfileId.AbstractPartyProfileIdImpl(this);
		}
		
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder prune() {
			partyProfileIdentifier = partyProfileIdentifier.stream().filter(b->b!=null).<PartyProfileIdentifier.PartyProfileIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyProfileIdentifier()!=null && getPartyProfileIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfileId.AbstractPartyProfileIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractPartyProfileId.AbstractPartyProfileIdBuilder o = (AbstractPartyProfileId.AbstractPartyProfileIdBuilder) other;
			
			merger.mergeRosetta(getPartyProfileIdentifier(), o.getPartyProfileIdentifier(), this::getOrCreatePartyProfileIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractPartyProfileId _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileIdentifier, _that.getPartyProfileIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyProfileIdentifier != null ? partyProfileIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfileIdBuilder {" +
				"partyProfileIdentifier=" + this.partyProfileIdentifier +
			'}';
		}
	}
}

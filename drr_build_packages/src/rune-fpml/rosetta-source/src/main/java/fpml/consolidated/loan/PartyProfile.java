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
import fpml.consolidated.loan.meta.PartyProfileMeta;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import java.time.ZonedDateTime;
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
 * Provision A type that describes a party profile record.
 *
 */
@RosettaDataType(value="PartyProfile", builder=PartyProfile.PartyProfileBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyProfile", model="fpml", builder=PartyProfile.PartyProfileBuilderImpl.class, version="2.1.1")
public interface PartyProfile extends AbstractPartyProfile {

	PartyProfileMeta metaData = new PartyProfileMeta();

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
	List<? extends PartyProfileChoice> getPartyProfileChoice();

	/*********************** Build Methods  ***********************/
	PartyProfile build();
	
	PartyProfile.PartyProfileBuilder toBuilder();
	
	static PartyProfile.PartyProfileBuilder builder() {
		return new PartyProfile.PartyProfileBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyProfile> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyProfile> getType() {
		return PartyProfile.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.class, getPartyProfileIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.class, getDocumentation());
		processRosetta(path.newSubPath("partyProfileChoice"), processor, PartyProfileChoice.class, getPartyProfileChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyProfileBuilder extends PartyProfile, AbstractPartyProfile.AbstractPartyProfileBuilder {
		PartyProfileChoice.PartyProfileChoiceBuilder getOrCreatePartyProfileChoice(int index);
		@Override
		List<? extends PartyProfileChoice.PartyProfileChoiceBuilder> getPartyProfileChoice();
		@Override
		PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier);
		@Override
		PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier, int idx);
		@Override
		PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier);
		@Override
		PartyProfile.PartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier);
		@Override
		PartyProfile.PartyProfileBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		@Override
		PartyProfile.PartyProfileBuilder setPartyReference(PartyReference partyReference);
		@Override
		PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty relatedParty);
		@Override
		PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		@Override
		PartyProfile.PartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		@Override
		PartyProfile.PartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		@Override
		PartyProfile.PartyProfileBuilder setDocumentation(PartyProfileDocumentation documentation);
		PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice partyProfileChoice);
		PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice partyProfileChoice, int idx);
		PartyProfile.PartyProfileBuilder addPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoice);
		PartyProfile.PartyProfileBuilder setPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.PartyProfileIdentifierBuilder.class, getPartyProfileIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.PartyProfileDocumentationBuilder.class, getDocumentation());
			processRosetta(path.newSubPath("partyProfileChoice"), processor, PartyProfileChoice.PartyProfileChoiceBuilder.class, getPartyProfileChoice());
		}
		

		PartyProfile.PartyProfileBuilder prune();
	}

	/*********************** Immutable Implementation of PartyProfile  ***********************/
	class PartyProfileImpl extends AbstractPartyProfile.AbstractPartyProfileImpl implements PartyProfile {
		private final List<? extends PartyProfileChoice> partyProfileChoice;
		
		protected PartyProfileImpl(PartyProfile.PartyProfileBuilder builder) {
			super(builder);
			this.partyProfileChoice = ofNullable(builder.getPartyProfileChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyProfileChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyProfileChoice")
		public List<? extends PartyProfileChoice> getPartyProfileChoice() {
			return partyProfileChoice;
		}
		
		@Override
		public PartyProfile build() {
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder toBuilder() {
			PartyProfile.PartyProfileBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyProfile.PartyProfileBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPartyProfileChoice()).ifPresent(builder::setPartyProfileChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyProfile _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileChoice, _that.getPartyProfileChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfileChoice != null ? partyProfileChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfile {" +
				"partyProfileChoice=" + this.partyProfileChoice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PartyProfile  ***********************/
	class PartyProfileBuilderImpl extends AbstractPartyProfile.AbstractPartyProfileBuilderImpl implements PartyProfile.PartyProfileBuilder {
	
		protected List<PartyProfileChoice.PartyProfileChoiceBuilder> partyProfileChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyProfileChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyProfileChoice")
		public List<? extends PartyProfileChoice.PartyProfileChoiceBuilder> getPartyProfileChoice() {
			return partyProfileChoice;
		}
		
		@Override
		public PartyProfileChoice.PartyProfileChoiceBuilder getOrCreatePartyProfileChoice(int index) {
			if (partyProfileChoice==null) {
				this.partyProfileChoice = new ArrayList<>();
			}
			return getIndex(partyProfileChoice, index, () -> {
						PartyProfileChoice.PartyProfileChoiceBuilder newPartyProfileChoice = PartyProfileChoice.builder();
						return newPartyProfileChoice;
					});
		}
		
		@RosettaAttribute("partyProfileIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyProfileIdentifier")
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier _partyProfileIdentifier) {
			if (_partyProfileIdentifier != null) {
				this.partyProfileIdentifier.add(_partyProfileIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier _partyProfileIdentifier, int idx) {
			getIndex(this.partyProfileIdentifier, idx, () -> _partyProfileIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
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
		public PartyProfile.PartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
			if (partyProfileIdentifiers == null) {
				this.partyProfileIdentifier = new ArrayList<>();
			} else {
				this.partyProfileIdentifier = partyProfileIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("effectiveDate")
		@Override
		public PartyProfile.PartyProfileBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public PartyProfile.PartyProfileBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyProfile.PartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("documentation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("documentation")
		@Override
		public PartyProfile.PartyProfileBuilder setDocumentation(PartyProfileDocumentation _documentation) {
			this.documentation = _documentation == null ? null : _documentation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyProfileChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyProfileChoice")
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice _partyProfileChoice) {
			if (_partyProfileChoice != null) {
				this.partyProfileChoice.add(_partyProfileChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileChoice(PartyProfileChoice _partyProfileChoice, int idx) {
			getIndex(this.partyProfileChoice, idx, () -> _partyProfileChoice.toBuilder());
			return this;
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder addPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoices) {
			if (partyProfileChoices != null) {
				for (final PartyProfileChoice toAdd : partyProfileChoices) {
					this.partyProfileChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyProfileChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyProfileChoice")
		@Override
		public PartyProfile.PartyProfileBuilder setPartyProfileChoice(List<? extends PartyProfileChoice> partyProfileChoices) {
			if (partyProfileChoices == null) {
				this.partyProfileChoice = new ArrayList<>();
			} else {
				this.partyProfileChoice = partyProfileChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PartyProfile build() {
			return new PartyProfile.PartyProfileImpl(this);
		}
		
		@Override
		public PartyProfile.PartyProfileBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfile.PartyProfileBuilder prune() {
			super.prune();
			partyProfileChoice = partyProfileChoice.stream().filter(b->b!=null).<PartyProfileChoice.PartyProfileChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPartyProfileChoice()!=null && getPartyProfileChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyProfile.PartyProfileBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PartyProfile.PartyProfileBuilder o = (PartyProfile.PartyProfileBuilder) other;
			
			merger.mergeRosetta(getPartyProfileChoice(), o.getPartyProfileChoice(), this::getOrCreatePartyProfileChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyProfile _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyProfileChoice, _that.getPartyProfileChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partyProfileChoice != null ? partyProfileChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyProfileBuilder {" +
				"partyProfileChoice=" + this.partyProfileChoice +
			'}' + " " + super.toString();
		}
	}
}

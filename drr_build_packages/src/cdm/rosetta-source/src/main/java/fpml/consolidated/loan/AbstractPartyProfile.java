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
import fpml.consolidated.loan.meta.AbstractPartyProfileMeta;
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
 * Provision An abstract base type that describes a party profile.
 *
 */
@RosettaDataType(value="AbstractPartyProfile", builder=AbstractPartyProfile.AbstractPartyProfileBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractPartyProfile", model="fpml", builder=AbstractPartyProfile.AbstractPartyProfileBuilderImpl.class, version="2.1.1")
public interface AbstractPartyProfile extends AbstractPartyProfileId {

	AbstractPartyProfileMeta metaData = new AbstractPartyProfileMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business date on which the information conveyed within the party profile becomes effective.
	 *
	 */
	ZonedDateTime getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party whose details are being communicated within the notification.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Other parties that may be related to the receiver party. Examples: custodian or trustee; or, to convey company hierarchy (for use in the context of 'blacklists').
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Description of the tax form registered by the party.
	 *
	 */
	PartyProfileDocumentation getDocumentation();

	/*********************** Build Methods  ***********************/
	AbstractPartyProfile build();
	
	AbstractPartyProfile.AbstractPartyProfileBuilder toBuilder();
	
	static AbstractPartyProfile.AbstractPartyProfileBuilder builder() {
		return new AbstractPartyProfile.AbstractPartyProfileBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractPartyProfile> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractPartyProfile> getType() {
		return AbstractPartyProfile.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.class, getPartyProfileIdentifier());
		processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.class, getDocumentation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractPartyProfileBuilder extends AbstractPartyProfile, AbstractPartyProfileId.AbstractPartyProfileIdBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		PartyProfileDocumentation.PartyProfileDocumentationBuilder getOrCreateDocumentation();
		@Override
		PartyProfileDocumentation.PartyProfileDocumentationBuilder getDocumentation();
		@Override
		AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier);
		@Override
		AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier partyProfileIdentifier, int idx);
		@Override
		AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier);
		@Override
		AbstractPartyProfile.AbstractPartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifier);
		AbstractPartyProfile.AbstractPartyProfileBuilder setEffectiveDate(ZonedDateTime effectiveDate);
		AbstractPartyProfile.AbstractPartyProfileBuilder setPartyReference(PartyReference partyReference);
		AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty relatedParty);
		AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		AbstractPartyProfile.AbstractPartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		AbstractPartyProfile.AbstractPartyProfileBuilder setDocumentation(PartyProfileDocumentation documentation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyProfileIdentifier"), processor, PartyProfileIdentifier.PartyProfileIdentifierBuilder.class, getPartyProfileIdentifier());
			processor.processBasic(path.newSubPath("effectiveDate"), ZonedDateTime.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("documentation"), processor, PartyProfileDocumentation.PartyProfileDocumentationBuilder.class, getDocumentation());
		}
		

		AbstractPartyProfile.AbstractPartyProfileBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractPartyProfile  ***********************/
	class AbstractPartyProfileImpl extends AbstractPartyProfileId.AbstractPartyProfileIdImpl implements AbstractPartyProfile {
		private final ZonedDateTime effectiveDate;
		private final PartyReference partyReference;
		private final List<? extends RelatedParty> relatedParty;
		private final PartyProfileDocumentation documentation;
		
		protected AbstractPartyProfileImpl(AbstractPartyProfile.AbstractPartyProfileBuilder builder) {
			super(builder);
			this.effectiveDate = builder.getEffectiveDate();
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.documentation = ofNullable(builder.getDocumentation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("documentation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentation")
		public PartyProfileDocumentation getDocumentation() {
			return documentation;
		}
		
		@Override
		public AbstractPartyProfile build() {
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder toBuilder() {
			AbstractPartyProfile.AbstractPartyProfileBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractPartyProfile.AbstractPartyProfileBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getDocumentation()).ifPresent(builder::setDocumentation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractPartyProfile _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfile {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"documentation=" + this.documentation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractPartyProfile  ***********************/
	class AbstractPartyProfileBuilderImpl extends AbstractPartyProfileId.AbstractPartyProfileIdBuilderImpl implements AbstractPartyProfile.AbstractPartyProfileBuilder {
	
		protected ZonedDateTime effectiveDate;
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected PartyProfileDocumentation.PartyProfileDocumentationBuilder documentation;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("effectiveDate")
		public ZonedDateTime getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("documentation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentation")
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder getDocumentation() {
			return documentation;
		}
		
		@Override
		public PartyProfileDocumentation.PartyProfileDocumentationBuilder getOrCreateDocumentation() {
			PartyProfileDocumentation.PartyProfileDocumentationBuilder result;
			if (documentation!=null) {
				result = documentation;
			}
			else {
				result = documentation = PartyProfileDocumentation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyProfileIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyProfileIdentifier")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier _partyProfileIdentifier) {
			if (_partyProfileIdentifier != null) {
				this.partyProfileIdentifier.add(_partyProfileIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(PartyProfileIdentifier _partyProfileIdentifier, int idx) {
			getIndex(this.partyProfileIdentifier, idx, () -> _partyProfileIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
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
		public AbstractPartyProfile.AbstractPartyProfileBuilder setPartyProfileIdentifier(List<? extends PartyProfileIdentifier> partyProfileIdentifiers) {
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
		public AbstractPartyProfile.AbstractPartyProfileBuilder setEffectiveDate(ZonedDateTime _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public AbstractPartyProfile.AbstractPartyProfileBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public AbstractPartyProfile.AbstractPartyProfileBuilder setDocumentation(PartyProfileDocumentation _documentation) {
			this.documentation = _documentation == null ? null : _documentation.toBuilder();
			return this;
		}
		
		@Override
		public AbstractPartyProfile build() {
			return new AbstractPartyProfile.AbstractPartyProfileImpl(this);
		}
		
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder prune() {
			super.prune();
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (documentation!=null && !documentation.prune().hasData()) documentation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDocumentation()!=null && getDocumentation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractPartyProfile.AbstractPartyProfileBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AbstractPartyProfile.AbstractPartyProfileBuilder o = (AbstractPartyProfile.AbstractPartyProfileBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getDocumentation(), o.getDocumentation(), this::setDocumentation);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractPartyProfile _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractPartyProfileBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyReference=" + this.partyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"documentation=" + this.documentation +
			'}' + " " + super.toString();
		}
	}
}

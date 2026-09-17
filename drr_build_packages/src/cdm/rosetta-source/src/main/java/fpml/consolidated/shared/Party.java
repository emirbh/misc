package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.PartyMeta;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
 *
 */
@RosettaDataType(value="Party", builder=Party.PartyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Party", model="fpml", builder=Party.PartyBuilderImpl.class, version="2.1.1")
public interface Party extends RosettaModelObject {

	PartyMeta metaData = new PartyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The id uniquely identifying the Party within the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The id uniquely identifying the Party within the document.
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A party identifier, e.g. a S.W.I.F.T. bank identifier code (BIC).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party identifier, e.g. a S.W.I.F.T. bank identifier code (BIC).
	 *
	 */
	List<? extends PartyId> getPartyId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The legal name of the organization. A free format string. FpML does not define usage rules for this element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The legal name of the organization. A free format string. FpML does not define usage rules for this element.
	 *
	 */
	PartyName getPartyName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party's industry sector classification.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party's industry sector classification.
	 *
	 */
	List<? extends IndustryClassification> getClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party's credit rating.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party's credit rating.
	 *
	 */
	List<? extends CreditRating> getCreditRating();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The country where the party is domiciled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The country where the party is domiciled.
	 *
	 */
	CountryCode getCountry();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A code for a grouping of countries to which this belongs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A code for a grouping of countries to which this belongs.
	 *
	 */
	List<? extends Region> getRegion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The legal jurisdiction of the entity's registration.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The legal jurisdiction of the entity's registration.
	 *
	 */
	List<? extends GoverningLaw> getJurisdiction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of an organization's participantion in the OTC derivatives market.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of an organization's participantion in the OTC derivatives market.
	 *
	 */
	List<? extends OrganizationType> getOrganizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information on how to contact the party using various means.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information on how to contact the party using various means.
	 *
	 */
	ContactInformation getContactInfo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process .
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process .
	 *
	 */
	List<? extends BusinessUnit> getBusinessUnit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional information about people involved in a transaction or busines process. (These are eomployees of the party).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional information about people involved in a transaction or busines process. (These are eomployees of the party).
	 *
	 */
	List<? extends Person> getPerson();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Party Group Type, e.g. JointAndSeveralLiability
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party Group Type, e.g. JointAndSeveralLiability
	 *
	 */
	PartyGroupType getGroupType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party that is a member of the group of entities that are acting together as a single party in a transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party that is a member of the group of entities that are acting together as a single party in a transaction.
	 *
	 */
	List<? extends PartyReference> getPartyReference();

	/*********************** Build Methods  ***********************/
	Party build();
	
	Party.PartyBuilder toBuilder();
	
	static Party.PartyBuilder builder() {
		return new Party.PartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Party> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Party> getType() {
		return Party.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyId"), processor, PartyId.class, getPartyId());
		processRosetta(path.newSubPath("partyName"), processor, PartyName.class, getPartyName());
		processRosetta(path.newSubPath("classification"), processor, IndustryClassification.class, getClassification());
		processRosetta(path.newSubPath("creditRating"), processor, CreditRating.class, getCreditRating());
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
		processRosetta(path.newSubPath("region"), processor, Region.class, getRegion());
		processRosetta(path.newSubPath("jurisdiction"), processor, GoverningLaw.class, getJurisdiction());
		processRosetta(path.newSubPath("organizationType"), processor, OrganizationType.class, getOrganizationType());
		processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.class, getContactInfo());
		processRosetta(path.newSubPath("businessUnit"), processor, BusinessUnit.class, getBusinessUnit());
		processRosetta(path.newSubPath("person"), processor, Person.class, getPerson());
		processRosetta(path.newSubPath("groupType"), processor, PartyGroupType.class, getGroupType());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyBuilder extends Party, RosettaModelObjectBuilder {
		PartyId.PartyIdBuilder getOrCreatePartyId(int index);
		@Override
		List<? extends PartyId.PartyIdBuilder> getPartyId();
		PartyName.PartyNameBuilder getOrCreatePartyName();
		@Override
		PartyName.PartyNameBuilder getPartyName();
		IndustryClassification.IndustryClassificationBuilder getOrCreateClassification(int index);
		@Override
		List<? extends IndustryClassification.IndustryClassificationBuilder> getClassification();
		CreditRating.CreditRatingBuilder getOrCreateCreditRating(int index);
		@Override
		List<? extends CreditRating.CreditRatingBuilder> getCreditRating();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		@Override
		CountryCode.CountryCodeBuilder getCountry();
		Region.RegionBuilder getOrCreateRegion(int index);
		@Override
		List<? extends Region.RegionBuilder> getRegion();
		GoverningLaw.GoverningLawBuilder getOrCreateJurisdiction(int index);
		@Override
		List<? extends GoverningLaw.GoverningLawBuilder> getJurisdiction();
		OrganizationType.OrganizationTypeBuilder getOrCreateOrganizationType(int index);
		@Override
		List<? extends OrganizationType.OrganizationTypeBuilder> getOrganizationType();
		ContactInformation.ContactInformationBuilder getOrCreateContactInfo();
		@Override
		ContactInformation.ContactInformationBuilder getContactInfo();
		BusinessUnit.BusinessUnitBuilder getOrCreateBusinessUnit(int index);
		@Override
		List<? extends BusinessUnit.BusinessUnitBuilder> getBusinessUnit();
		Person.PersonBuilder getOrCreatePerson(int index);
		@Override
		List<? extends Person.PersonBuilder> getPerson();
		PartyGroupType.PartyGroupTypeBuilder getOrCreateGroupType();
		@Override
		PartyGroupType.PartyGroupTypeBuilder getGroupType();
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getPartyReference();
		Party.PartyBuilder setId(String id);
		Party.PartyBuilder addPartyId(PartyId partyId);
		Party.PartyBuilder addPartyId(PartyId partyId, int idx);
		Party.PartyBuilder addPartyId(List<? extends PartyId> partyId);
		Party.PartyBuilder setPartyId(List<? extends PartyId> partyId);
		Party.PartyBuilder setPartyName(PartyName partyName);
		Party.PartyBuilder addClassification(IndustryClassification classification);
		Party.PartyBuilder addClassification(IndustryClassification classification, int idx);
		Party.PartyBuilder addClassification(List<? extends IndustryClassification> classification);
		Party.PartyBuilder setClassification(List<? extends IndustryClassification> classification);
		Party.PartyBuilder addCreditRating(CreditRating creditRating);
		Party.PartyBuilder addCreditRating(CreditRating creditRating, int idx);
		Party.PartyBuilder addCreditRating(List<? extends CreditRating> creditRating);
		Party.PartyBuilder setCreditRating(List<? extends CreditRating> creditRating);
		Party.PartyBuilder setCountry(CountryCode country);
		Party.PartyBuilder addRegion(Region region);
		Party.PartyBuilder addRegion(Region region, int idx);
		Party.PartyBuilder addRegion(List<? extends Region> region);
		Party.PartyBuilder setRegion(List<? extends Region> region);
		Party.PartyBuilder addJurisdiction(GoverningLaw jurisdiction);
		Party.PartyBuilder addJurisdiction(GoverningLaw jurisdiction, int idx);
		Party.PartyBuilder addJurisdiction(List<? extends GoverningLaw> jurisdiction);
		Party.PartyBuilder setJurisdiction(List<? extends GoverningLaw> jurisdiction);
		Party.PartyBuilder addOrganizationType(OrganizationType organizationType);
		Party.PartyBuilder addOrganizationType(OrganizationType organizationType, int idx);
		Party.PartyBuilder addOrganizationType(List<? extends OrganizationType> organizationType);
		Party.PartyBuilder setOrganizationType(List<? extends OrganizationType> organizationType);
		Party.PartyBuilder setContactInfo(ContactInformation contactInfo);
		Party.PartyBuilder addBusinessUnit(BusinessUnit businessUnit);
		Party.PartyBuilder addBusinessUnit(BusinessUnit businessUnit, int idx);
		Party.PartyBuilder addBusinessUnit(List<? extends BusinessUnit> businessUnit);
		Party.PartyBuilder setBusinessUnit(List<? extends BusinessUnit> businessUnit);
		Party.PartyBuilder addPerson(Person person);
		Party.PartyBuilder addPerson(Person person, int idx);
		Party.PartyBuilder addPerson(List<? extends Person> person);
		Party.PartyBuilder setPerson(List<? extends Person> person);
		Party.PartyBuilder setGroupType(PartyGroupType groupType);
		Party.PartyBuilder addPartyReference(PartyReference partyReference);
		Party.PartyBuilder addPartyReference(PartyReference partyReference, int idx);
		Party.PartyBuilder addPartyReference(List<? extends PartyReference> partyReference);
		Party.PartyBuilder setPartyReference(List<? extends PartyReference> partyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyId"), processor, PartyId.PartyIdBuilder.class, getPartyId());
			processRosetta(path.newSubPath("partyName"), processor, PartyName.PartyNameBuilder.class, getPartyName());
			processRosetta(path.newSubPath("classification"), processor, IndustryClassification.IndustryClassificationBuilder.class, getClassification());
			processRosetta(path.newSubPath("creditRating"), processor, CreditRating.CreditRatingBuilder.class, getCreditRating());
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
			processRosetta(path.newSubPath("region"), processor, Region.RegionBuilder.class, getRegion());
			processRosetta(path.newSubPath("jurisdiction"), processor, GoverningLaw.GoverningLawBuilder.class, getJurisdiction());
			processRosetta(path.newSubPath("organizationType"), processor, OrganizationType.OrganizationTypeBuilder.class, getOrganizationType());
			processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.ContactInformationBuilder.class, getContactInfo());
			processRosetta(path.newSubPath("businessUnit"), processor, BusinessUnit.BusinessUnitBuilder.class, getBusinessUnit());
			processRosetta(path.newSubPath("person"), processor, Person.PersonBuilder.class, getPerson());
			processRosetta(path.newSubPath("groupType"), processor, PartyGroupType.PartyGroupTypeBuilder.class, getGroupType());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
		}
		

		Party.PartyBuilder prune();
	}

	/*********************** Immutable Implementation of Party  ***********************/
	class PartyImpl implements Party {
		private final String id;
		private final List<? extends PartyId> partyId;
		private final PartyName partyName;
		private final List<? extends IndustryClassification> classification;
		private final List<? extends CreditRating> creditRating;
		private final CountryCode country;
		private final List<? extends Region> region;
		private final List<? extends GoverningLaw> jurisdiction;
		private final List<? extends OrganizationType> organizationType;
		private final ContactInformation contactInfo;
		private final List<? extends BusinessUnit> businessUnit;
		private final List<? extends Person> person;
		private final PartyGroupType groupType;
		private final List<? extends PartyReference> partyReference;
		
		protected PartyImpl(Party.PartyBuilder builder) {
			this.id = builder.getId();
			this.partyId = ofNullable(builder.getPartyId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyName = ofNullable(builder.getPartyName()).map(f->f.build()).orElse(null);
			this.classification = ofNullable(builder.getClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditRating = ofNullable(builder.getCreditRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
			this.region = ofNullable(builder.getRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.jurisdiction = ofNullable(builder.getJurisdiction()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.organizationType = ofNullable(builder.getOrganizationType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.contactInfo = ofNullable(builder.getContactInfo()).map(f->f.build()).orElse(null);
			this.businessUnit = ofNullable(builder.getBusinessUnit()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.person = ofNullable(builder.getPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.groupType = ofNullable(builder.getGroupType()).map(f->f.build()).orElse(null);
			this.partyReference = ofNullable(builder.getPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyId")
		public List<? extends PartyId> getPartyId() {
			return partyId;
		}
		
		@Override
		@RosettaAttribute("partyName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyName")
		public PartyName getPartyName() {
			return partyName;
		}
		
		@Override
		@RosettaAttribute("classification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("classification")
		public List<? extends IndustryClassification> getClassification() {
			return classification;
		}
		
		@Override
		@RosettaAttribute("creditRating")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditRating")
		public List<? extends CreditRating> getCreditRating() {
			return creditRating;
		}
		
		@Override
		@RosettaAttribute("country")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		@RosettaAttribute("region")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("region")
		public List<? extends Region> getRegion() {
			return region;
		}
		
		@Override
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("jurisdiction")
		public List<? extends GoverningLaw> getJurisdiction() {
			return jurisdiction;
		}
		
		@Override
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("organizationType")
		public List<? extends OrganizationType> getOrganizationType() {
			return organizationType;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contactInfo")
		public ContactInformation getContactInfo() {
			return contactInfo;
		}
		
		@Override
		@RosettaAttribute("businessUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("businessUnit")
		public List<? extends BusinessUnit> getBusinessUnit() {
			return businessUnit;
		}
		
		@Override
		@RosettaAttribute("person")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("person")
		public List<? extends Person> getPerson() {
			return person;
		}
		
		@Override
		@RosettaAttribute("groupType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("groupType")
		public PartyGroupType getGroupType() {
			return groupType;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyReference")
		public List<? extends PartyReference> getPartyReference() {
			return partyReference;
		}
		
		@Override
		public Party build() {
			return this;
		}
		
		@Override
		public Party.PartyBuilder toBuilder() {
			Party.PartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Party.PartyBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyId()).ifPresent(builder::setPartyId);
			ofNullable(getPartyName()).ifPresent(builder::setPartyName);
			ofNullable(getClassification()).ifPresent(builder::setClassification);
			ofNullable(getCreditRating()).ifPresent(builder::setCreditRating);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
			ofNullable(getRegion()).ifPresent(builder::setRegion);
			ofNullable(getJurisdiction()).ifPresent(builder::setJurisdiction);
			ofNullable(getOrganizationType()).ifPresent(builder::setOrganizationType);
			ofNullable(getContactInfo()).ifPresent(builder::setContactInfo);
			ofNullable(getBusinessUnit()).ifPresent(builder::setBusinessUnit);
			ofNullable(getPerson()).ifPresent(builder::setPerson);
			ofNullable(getGroupType()).ifPresent(builder::setGroupType);
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!ListEquals.listEquals(classification, _that.getClassification())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!ListEquals.listEquals(region, _that.getRegion())) return false;
			if (!ListEquals.listEquals(jurisdiction, _that.getJurisdiction())) return false;
			if (!ListEquals.listEquals(organizationType, _that.getOrganizationType())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!ListEquals.listEquals(businessUnit, _that.getBusinessUnit())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			if (!Objects.equals(groupType, _that.getGroupType())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (classification != null ? classification.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (region != null ? region.hashCode() : 0);
			_result = 31 * _result + (jurisdiction != null ? jurisdiction.hashCode() : 0);
			_result = 31 * _result + (organizationType != null ? organizationType.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (businessUnit != null ? businessUnit.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			_result = 31 * _result + (groupType != null ? groupType.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Party {" +
				"id=" + this.id + ", " +
				"partyId=" + this.partyId + ", " +
				"partyName=" + this.partyName + ", " +
				"classification=" + this.classification + ", " +
				"creditRating=" + this.creditRating + ", " +
				"country=" + this.country + ", " +
				"region=" + this.region + ", " +
				"jurisdiction=" + this.jurisdiction + ", " +
				"organizationType=" + this.organizationType + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"businessUnit=" + this.businessUnit + ", " +
				"person=" + this.person + ", " +
				"groupType=" + this.groupType + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of Party  ***********************/
	class PartyBuilderImpl implements Party.PartyBuilder {
	
		protected String id;
		protected List<PartyId.PartyIdBuilder> partyId = new ArrayList<>();
		protected PartyName.PartyNameBuilder partyName;
		protected List<IndustryClassification.IndustryClassificationBuilder> classification = new ArrayList<>();
		protected List<CreditRating.CreditRatingBuilder> creditRating = new ArrayList<>();
		protected CountryCode.CountryCodeBuilder country;
		protected List<Region.RegionBuilder> region = new ArrayList<>();
		protected List<GoverningLaw.GoverningLawBuilder> jurisdiction = new ArrayList<>();
		protected List<OrganizationType.OrganizationTypeBuilder> organizationType = new ArrayList<>();
		protected ContactInformation.ContactInformationBuilder contactInfo;
		protected List<BusinessUnit.BusinessUnitBuilder> businessUnit = new ArrayList<>();
		protected List<Person.PersonBuilder> person = new ArrayList<>();
		protected PartyGroupType.PartyGroupTypeBuilder groupType;
		protected List<PartyReference.PartyReferenceBuilder> partyReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyId")
		public List<? extends PartyId.PartyIdBuilder> getPartyId() {
			return partyId;
		}
		
		@Override
		public PartyId.PartyIdBuilder getOrCreatePartyId(int index) {
			if (partyId==null) {
				this.partyId = new ArrayList<>();
			}
			return getIndex(partyId, index, () -> {
						PartyId.PartyIdBuilder newPartyId = PartyId.builder();
						return newPartyId;
					});
		}
		
		@Override
		@RosettaAttribute("partyName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyName")
		public PartyName.PartyNameBuilder getPartyName() {
			return partyName;
		}
		
		@Override
		public PartyName.PartyNameBuilder getOrCreatePartyName() {
			PartyName.PartyNameBuilder result;
			if (partyName!=null) {
				result = partyName;
			}
			else {
				result = partyName = PartyName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("classification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("classification")
		public List<? extends IndustryClassification.IndustryClassificationBuilder> getClassification() {
			return classification;
		}
		
		@Override
		public IndustryClassification.IndustryClassificationBuilder getOrCreateClassification(int index) {
			if (classification==null) {
				this.classification = new ArrayList<>();
			}
			return getIndex(classification, index, () -> {
						IndustryClassification.IndustryClassificationBuilder newClassification = IndustryClassification.builder();
						return newClassification;
					});
		}
		
		@Override
		@RosettaAttribute("creditRating")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditRating")
		public List<? extends CreditRating.CreditRatingBuilder> getCreditRating() {
			return creditRating;
		}
		
		@Override
		public CreditRating.CreditRatingBuilder getOrCreateCreditRating(int index) {
			if (creditRating==null) {
				this.creditRating = new ArrayList<>();
			}
			return getIndex(creditRating, index, () -> {
						CreditRating.CreditRatingBuilder newCreditRating = CreditRating.builder();
						return newCreditRating;
					});
		}
		
		@Override
		@RosettaAttribute("country")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("country")
		public CountryCode.CountryCodeBuilder getCountry() {
			return country;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateCountry() {
			CountryCode.CountryCodeBuilder result;
			if (country!=null) {
				result = country;
			}
			else {
				result = country = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("region")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("region")
		public List<? extends Region.RegionBuilder> getRegion() {
			return region;
		}
		
		@Override
		public Region.RegionBuilder getOrCreateRegion(int index) {
			if (region==null) {
				this.region = new ArrayList<>();
			}
			return getIndex(region, index, () -> {
						Region.RegionBuilder newRegion = Region.builder();
						return newRegion;
					});
		}
		
		@Override
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("jurisdiction")
		public List<? extends GoverningLaw.GoverningLawBuilder> getJurisdiction() {
			return jurisdiction;
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder getOrCreateJurisdiction(int index) {
			if (jurisdiction==null) {
				this.jurisdiction = new ArrayList<>();
			}
			return getIndex(jurisdiction, index, () -> {
						GoverningLaw.GoverningLawBuilder newJurisdiction = GoverningLaw.builder();
						return newJurisdiction;
					});
		}
		
		@Override
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("organizationType")
		public List<? extends OrganizationType.OrganizationTypeBuilder> getOrganizationType() {
			return organizationType;
		}
		
		@Override
		public OrganizationType.OrganizationTypeBuilder getOrCreateOrganizationType(int index) {
			if (organizationType==null) {
				this.organizationType = new ArrayList<>();
			}
			return getIndex(organizationType, index, () -> {
						OrganizationType.OrganizationTypeBuilder newOrganizationType = OrganizationType.builder();
						return newOrganizationType;
					});
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contactInfo")
		public ContactInformation.ContactInformationBuilder getContactInfo() {
			return contactInfo;
		}
		
		@Override
		public ContactInformation.ContactInformationBuilder getOrCreateContactInfo() {
			ContactInformation.ContactInformationBuilder result;
			if (contactInfo!=null) {
				result = contactInfo;
			}
			else {
				result = contactInfo = ContactInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("businessUnit")
		public List<? extends BusinessUnit.BusinessUnitBuilder> getBusinessUnit() {
			return businessUnit;
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder getOrCreateBusinessUnit(int index) {
			if (businessUnit==null) {
				this.businessUnit = new ArrayList<>();
			}
			return getIndex(businessUnit, index, () -> {
						BusinessUnit.BusinessUnitBuilder newBusinessUnit = BusinessUnit.builder();
						return newBusinessUnit;
					});
		}
		
		@Override
		@RosettaAttribute("person")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("person")
		public List<? extends Person.PersonBuilder> getPerson() {
			return person;
		}
		
		@Override
		public Person.PersonBuilder getOrCreatePerson(int index) {
			if (person==null) {
				this.person = new ArrayList<>();
			}
			return getIndex(person, index, () -> {
						Person.PersonBuilder newPerson = Person.builder();
						return newPerson;
					});
		}
		
		@Override
		@RosettaAttribute("groupType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("groupType")
		public PartyGroupType.PartyGroupTypeBuilder getGroupType() {
			return groupType;
		}
		
		@Override
		public PartyGroupType.PartyGroupTypeBuilder getOrCreateGroupType() {
			PartyGroupType.PartyGroupTypeBuilder result;
			if (groupType!=null) {
				result = groupType;
			}
			else {
				result = groupType = PartyGroupType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference(int index) {
			if (partyReference==null) {
				this.partyReference = new ArrayList<>();
			}
			return getIndex(partyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newPartyReference = PartyReference.builder();
						return newPartyReference;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public Party.PartyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyId")
		@Override
		public Party.PartyBuilder addPartyId(PartyId _partyId) {
			if (_partyId != null) {
				this.partyId.add(_partyId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPartyId(PartyId _partyId, int idx) {
			getIndex(this.partyId, idx, () -> _partyId.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPartyId(List<? extends PartyId> partyIds) {
			if (partyIds != null) {
				for (final PartyId toAdd : partyIds) {
					this.partyId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyId")
		@Override
		public Party.PartyBuilder setPartyId(List<? extends PartyId> partyIds) {
			if (partyIds == null) {
				this.partyId = new ArrayList<>();
			} else {
				this.partyId = partyIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyName")
		@Override
		public Party.PartyBuilder setPartyName(PartyName _partyName) {
			this.partyName = _partyName == null ? null : _partyName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("classification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("classification")
		@Override
		public Party.PartyBuilder addClassification(IndustryClassification _classification) {
			if (_classification != null) {
				this.classification.add(_classification.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addClassification(IndustryClassification _classification, int idx) {
			getIndex(this.classification, idx, () -> _classification.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addClassification(List<? extends IndustryClassification> classifications) {
			if (classifications != null) {
				for (final IndustryClassification toAdd : classifications) {
					this.classification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("classification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("classification")
		@Override
		public Party.PartyBuilder setClassification(List<? extends IndustryClassification> classifications) {
			if (classifications == null) {
				this.classification = new ArrayList<>();
			} else {
				this.classification = classifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditRating")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditRating")
		@Override
		public Party.PartyBuilder addCreditRating(CreditRating _creditRating) {
			if (_creditRating != null) {
				this.creditRating.add(_creditRating.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addCreditRating(CreditRating _creditRating, int idx) {
			getIndex(this.creditRating, idx, () -> _creditRating.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addCreditRating(List<? extends CreditRating> creditRatings) {
			if (creditRatings != null) {
				for (final CreditRating toAdd : creditRatings) {
					this.creditRating.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditRating")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditRating")
		@Override
		public Party.PartyBuilder setCreditRating(List<? extends CreditRating> creditRatings) {
			if (creditRatings == null) {
				this.creditRating = new ArrayList<>();
			} else {
				this.creditRating = creditRatings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("country")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("country")
		@Override
		public Party.PartyBuilder setCountry(CountryCode _country) {
			this.country = _country == null ? null : _country.toBuilder();
			return this;
		}
		
		@RosettaAttribute("region")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("region")
		@Override
		public Party.PartyBuilder addRegion(Region _region) {
			if (_region != null) {
				this.region.add(_region.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addRegion(Region _region, int idx) {
			getIndex(this.region, idx, () -> _region.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addRegion(List<? extends Region> regions) {
			if (regions != null) {
				for (final Region toAdd : regions) {
					this.region.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("region")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("region")
		@Override
		public Party.PartyBuilder setRegion(List<? extends Region> regions) {
			if (regions == null) {
				this.region = new ArrayList<>();
			} else {
				this.region = regions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("jurisdiction")
		@Override
		public Party.PartyBuilder addJurisdiction(GoverningLaw _jurisdiction) {
			if (_jurisdiction != null) {
				this.jurisdiction.add(_jurisdiction.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addJurisdiction(GoverningLaw _jurisdiction, int idx) {
			getIndex(this.jurisdiction, idx, () -> _jurisdiction.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addJurisdiction(List<? extends GoverningLaw> jurisdictions) {
			if (jurisdictions != null) {
				for (final GoverningLaw toAdd : jurisdictions) {
					this.jurisdiction.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("jurisdiction")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("jurisdiction")
		@Override
		public Party.PartyBuilder setJurisdiction(List<? extends GoverningLaw> jurisdictions) {
			if (jurisdictions == null) {
				this.jurisdiction = new ArrayList<>();
			} else {
				this.jurisdiction = jurisdictions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("organizationType")
		@Override
		public Party.PartyBuilder addOrganizationType(OrganizationType _organizationType) {
			if (_organizationType != null) {
				this.organizationType.add(_organizationType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addOrganizationType(OrganizationType _organizationType, int idx) {
			getIndex(this.organizationType, idx, () -> _organizationType.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addOrganizationType(List<? extends OrganizationType> organizationTypes) {
			if (organizationTypes != null) {
				for (final OrganizationType toAdd : organizationTypes) {
					this.organizationType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("organizationType")
		@Override
		public Party.PartyBuilder setOrganizationType(List<? extends OrganizationType> organizationTypes) {
			if (organizationTypes == null) {
				this.organizationType = new ArrayList<>();
			} else {
				this.organizationType = organizationTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contactInfo")
		@Override
		public Party.PartyBuilder setContactInfo(ContactInformation _contactInfo) {
			this.contactInfo = _contactInfo == null ? null : _contactInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessUnit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("businessUnit")
		@Override
		public Party.PartyBuilder addBusinessUnit(BusinessUnit _businessUnit) {
			if (_businessUnit != null) {
				this.businessUnit.add(_businessUnit.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addBusinessUnit(BusinessUnit _businessUnit, int idx) {
			getIndex(this.businessUnit, idx, () -> _businessUnit.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addBusinessUnit(List<? extends BusinessUnit> businessUnits) {
			if (businessUnits != null) {
				for (final BusinessUnit toAdd : businessUnits) {
					this.businessUnit.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("businessUnit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("businessUnit")
		@Override
		public Party.PartyBuilder setBusinessUnit(List<? extends BusinessUnit> businessUnits) {
			if (businessUnits == null) {
				this.businessUnit = new ArrayList<>();
			} else {
				this.businessUnit = businessUnits.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("person")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("person")
		@Override
		public Party.PartyBuilder addPerson(Person _person) {
			if (_person != null) {
				this.person.add(_person.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPerson(Person _person, int idx) {
			getIndex(this.person, idx, () -> _person.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPerson(List<? extends Person> persons) {
			if (persons != null) {
				for (final Person toAdd : persons) {
					this.person.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("person")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("person")
		@Override
		public Party.PartyBuilder setPerson(List<? extends Person> persons) {
			if (persons == null) {
				this.person = new ArrayList<>();
			} else {
				this.person = persons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("groupType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("groupType")
		@Override
		public Party.PartyBuilder setGroupType(PartyGroupType _groupType) {
			this.groupType = _groupType == null ? null : _groupType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyReference")
		@Override
		public Party.PartyBuilder addPartyReference(PartyReference _partyReference) {
			if (_partyReference != null) {
				this.partyReference.add(_partyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPartyReference(PartyReference _partyReference, int idx) {
			getIndex(this.partyReference, idx, () -> _partyReference.toBuilder());
			return this;
		}
		
		@Override
		public Party.PartyBuilder addPartyReference(List<? extends PartyReference> partyReferences) {
			if (partyReferences != null) {
				for (final PartyReference toAdd : partyReferences) {
					this.partyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyReference")
		@Override
		public Party.PartyBuilder setPartyReference(List<? extends PartyReference> partyReferences) {
			if (partyReferences == null) {
				this.partyReference = new ArrayList<>();
			} else {
				this.partyReference = partyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Party build() {
			return new Party.PartyImpl(this);
		}
		
		@Override
		public Party.PartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Party.PartyBuilder prune() {
			partyId = partyId.stream().filter(b->b!=null).<PartyId.PartyIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyName!=null && !partyName.prune().hasData()) partyName = null;
			classification = classification.stream().filter(b->b!=null).<IndustryClassification.IndustryClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditRating = creditRating.stream().filter(b->b!=null).<CreditRating.CreditRatingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (country!=null && !country.prune().hasData()) country = null;
			region = region.stream().filter(b->b!=null).<Region.RegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			jurisdiction = jurisdiction.stream().filter(b->b!=null).<GoverningLaw.GoverningLawBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			organizationType = organizationType.stream().filter(b->b!=null).<OrganizationType.OrganizationTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (contactInfo!=null && !contactInfo.prune().hasData()) contactInfo = null;
			businessUnit = businessUnit.stream().filter(b->b!=null).<BusinessUnit.BusinessUnitBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			person = person.stream().filter(b->b!=null).<Person.PersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (groupType!=null && !groupType.prune().hasData()) groupType = null;
			partyReference = partyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyId()!=null && getPartyId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyName()!=null && getPartyName().hasData()) return true;
			if (getClassification()!=null && getClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditRating()!=null && getCreditRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			if (getRegion()!=null && getRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getJurisdiction()!=null && getJurisdiction().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOrganizationType()!=null && getOrganizationType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getContactInfo()!=null && getContactInfo().hasData()) return true;
			if (getBusinessUnit()!=null && getBusinessUnit().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPerson()!=null && getPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getGroupType()!=null && getGroupType().hasData()) return true;
			if (getPartyReference()!=null && getPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Party.PartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Party.PartyBuilder o = (Party.PartyBuilder) other;
			
			merger.mergeRosetta(getPartyId(), o.getPartyId(), this::getOrCreatePartyId);
			merger.mergeRosetta(getPartyName(), o.getPartyName(), this::setPartyName);
			merger.mergeRosetta(getClassification(), o.getClassification(), this::getOrCreateClassification);
			merger.mergeRosetta(getCreditRating(), o.getCreditRating(), this::getOrCreateCreditRating);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			merger.mergeRosetta(getRegion(), o.getRegion(), this::getOrCreateRegion);
			merger.mergeRosetta(getJurisdiction(), o.getJurisdiction(), this::getOrCreateJurisdiction);
			merger.mergeRosetta(getOrganizationType(), o.getOrganizationType(), this::getOrCreateOrganizationType);
			merger.mergeRosetta(getContactInfo(), o.getContactInfo(), this::setContactInfo);
			merger.mergeRosetta(getBusinessUnit(), o.getBusinessUnit(), this::getOrCreateBusinessUnit);
			merger.mergeRosetta(getPerson(), o.getPerson(), this::getOrCreatePerson);
			merger.mergeRosetta(getGroupType(), o.getGroupType(), this::setGroupType);
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::getOrCreatePartyReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Party _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(partyId, _that.getPartyId())) return false;
			if (!Objects.equals(partyName, _that.getPartyName())) return false;
			if (!ListEquals.listEquals(classification, _that.getClassification())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			if (!ListEquals.listEquals(region, _that.getRegion())) return false;
			if (!ListEquals.listEquals(jurisdiction, _that.getJurisdiction())) return false;
			if (!ListEquals.listEquals(organizationType, _that.getOrganizationType())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!ListEquals.listEquals(businessUnit, _that.getBusinessUnit())) return false;
			if (!ListEquals.listEquals(person, _that.getPerson())) return false;
			if (!Objects.equals(groupType, _that.getGroupType())) return false;
			if (!ListEquals.listEquals(partyReference, _that.getPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyId != null ? partyId.hashCode() : 0);
			_result = 31 * _result + (partyName != null ? partyName.hashCode() : 0);
			_result = 31 * _result + (classification != null ? classification.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			_result = 31 * _result + (region != null ? region.hashCode() : 0);
			_result = 31 * _result + (jurisdiction != null ? jurisdiction.hashCode() : 0);
			_result = 31 * _result + (organizationType != null ? organizationType.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (businessUnit != null ? businessUnit.hashCode() : 0);
			_result = 31 * _result + (person != null ? person.hashCode() : 0);
			_result = 31 * _result + (groupType != null ? groupType.hashCode() : 0);
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyBuilder {" +
				"id=" + this.id + ", " +
				"partyId=" + this.partyId + ", " +
				"partyName=" + this.partyName + ", " +
				"classification=" + this.classification + ", " +
				"creditRating=" + this.creditRating + ", " +
				"country=" + this.country + ", " +
				"region=" + this.region + ", " +
				"jurisdiction=" + this.jurisdiction + ", " +
				"organizationType=" + this.organizationType + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"businessUnit=" + this.businessUnit + ", " +
				"person=" + this.person + ", " +
				"groupType=" + this.groupType + ", " +
				"partyReference=" + this.partyReference +
			'}';
		}
	}
}

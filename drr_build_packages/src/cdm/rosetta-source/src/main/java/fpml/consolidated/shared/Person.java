package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.shared.meta.PersonMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that represents information about a person connected with a trade or business process.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that represents information about a person connected with a trade or business process.
 *
 */
@RosettaDataType(value="Person", builder=Person.PersonBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Person", model="fpml", builder=Person.PersonBuilderImpl.class, version="2.1.1")
public interface Person extends RosettaModelObject {

	PersonMeta metaData = new PersonMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An honorific title, such as Mr., Ms., Dr. etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An honorific title, such as Mr., Ms., Dr. etc.
	 *
	 */
	String getHonorific();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Given name, such as John or Mary.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Given name, such as John or Mary.
	 *
	 */
	String getFirstName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<String> getMiddleName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<String> getInitial();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Family name, such as Smith or Jones.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Family name, such as Smith or Jones.
	 *
	 */
	String getSurname();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Name suffix, such as Jr., III, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Name suffix, such as Jr., III, etc.
	 *
	 */
	String getSuffix();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifier assigned by a system for uniquely identifying the individual
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier assigned by a system for uniquely identifying the individual
	 *
	 */
	List<? extends PersonId> getPersonId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The unit for which the indvidual works.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The unit for which the indvidual works.
	 *
	 */
	BusinessUnitReference getBusinessUnitReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information on how to contact the individual using various means.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information on how to contact the individual using various means.
	 *
	 */
	ContactInformation getContactInfo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The birth date of the person, e.g. 1970-01-01
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The birth date of the person, e.g. 1970-01-01
	 *
	 */
	ZonedDateTime getDateOfBirth();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISO 3166 standard code for the country where the individual works.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISO 3166 standard code for the country where the individual works.
	 *
	 */
	CountryCode getCountry();

	/*********************** Build Methods  ***********************/
	Person build();
	
	Person.PersonBuilder toBuilder();
	
	static Person.PersonBuilder builder() {
		return new Person.PersonBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Person> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Person> getType() {
		return Person.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
		processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
		processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
		processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
		processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
		processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
		processRosetta(path.newSubPath("personId"), processor, PersonId.class, getPersonId());
		processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.class, getBusinessUnitReference());
		processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.class, getContactInfo());
		processor.processBasic(path.newSubPath("dateOfBirth"), ZonedDateTime.class, getDateOfBirth(), this);
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PersonBuilder extends Person, RosettaModelObjectBuilder {
		PersonId.PersonIdBuilder getOrCreatePersonId(int index);
		@Override
		List<? extends PersonId.PersonIdBuilder> getPersonId();
		BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference();
		@Override
		BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference();
		ContactInformation.ContactInformationBuilder getOrCreateContactInfo();
		@Override
		ContactInformation.ContactInformationBuilder getContactInfo();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		@Override
		CountryCode.CountryCodeBuilder getCountry();
		Person.PersonBuilder setId(String id);
		Person.PersonBuilder setHonorific(String honorific);
		Person.PersonBuilder setFirstName(String firstName);
		Person.PersonBuilder addMiddleName(String middleName);
		Person.PersonBuilder addMiddleName(String middleName, int idx);
		Person.PersonBuilder addMiddleName(List<String> middleName);
		Person.PersonBuilder setMiddleName(List<String> middleName);
		Person.PersonBuilder addInitial(String initial);
		Person.PersonBuilder addInitial(String initial, int idx);
		Person.PersonBuilder addInitial(List<String> initial);
		Person.PersonBuilder setInitial(List<String> initial);
		Person.PersonBuilder setSurname(String surname);
		Person.PersonBuilder setSuffix(String suffix);
		Person.PersonBuilder addPersonId(PersonId personId);
		Person.PersonBuilder addPersonId(PersonId personId, int idx);
		Person.PersonBuilder addPersonId(List<? extends PersonId> personId);
		Person.PersonBuilder setPersonId(List<? extends PersonId> personId);
		Person.PersonBuilder setBusinessUnitReference(BusinessUnitReference businessUnitReference);
		Person.PersonBuilder setContactInfo(ContactInformation contactInfo);
		Person.PersonBuilder setDateOfBirth(ZonedDateTime dateOfBirth);
		Person.PersonBuilder setCountry(CountryCode country);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("honorific"), String.class, getHonorific(), this);
			processor.processBasic(path.newSubPath("firstName"), String.class, getFirstName(), this);
			processor.processBasic(path.newSubPath("middleName"), String.class, getMiddleName(), this);
			processor.processBasic(path.newSubPath("initial"), String.class, getInitial(), this);
			processor.processBasic(path.newSubPath("surname"), String.class, getSurname(), this);
			processor.processBasic(path.newSubPath("suffix"), String.class, getSuffix(), this);
			processRosetta(path.newSubPath("personId"), processor, PersonId.PersonIdBuilder.class, getPersonId());
			processRosetta(path.newSubPath("businessUnitReference"), processor, BusinessUnitReference.BusinessUnitReferenceBuilder.class, getBusinessUnitReference());
			processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.ContactInformationBuilder.class, getContactInfo());
			processor.processBasic(path.newSubPath("dateOfBirth"), ZonedDateTime.class, getDateOfBirth(), this);
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
		}
		

		Person.PersonBuilder prune();
	}

	/*********************** Immutable Implementation of Person  ***********************/
	class PersonImpl implements Person {
		private final String id;
		private final String honorific;
		private final String firstName;
		private final List<String> middleName;
		private final List<String> initial;
		private final String surname;
		private final String suffix;
		private final List<? extends PersonId> personId;
		private final BusinessUnitReference businessUnitReference;
		private final ContactInformation contactInfo;
		private final ZonedDateTime dateOfBirth;
		private final CountryCode country;
		
		protected PersonImpl(Person.PersonBuilder builder) {
			this.id = builder.getId();
			this.honorific = builder.getHonorific();
			this.firstName = builder.getFirstName();
			this.middleName = ofNullable(builder.getMiddleName()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.initial = ofNullable(builder.getInitial()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.surname = builder.getSurname();
			this.suffix = builder.getSuffix();
			this.personId = ofNullable(builder.getPersonId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.businessUnitReference = ofNullable(builder.getBusinessUnitReference()).map(f->f.build()).orElse(null);
			this.contactInfo = ofNullable(builder.getContactInfo()).map(f->f.build()).orElse(null);
			this.dateOfBirth = builder.getDateOfBirth();
			this.country = ofNullable(builder.getCountry()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("honorific")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("honorific")
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		@RosettaAttribute("firstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstName")
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		@RosettaAttribute("middleName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("middleName")
		public List<String> getMiddleName() {
			return middleName;
		}
		
		@Override
		@RosettaAttribute("initial")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("initial")
		public List<String> getInitial() {
			return initial;
		}
		
		@Override
		@RosettaAttribute("surname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("surname")
		public String getSurname() {
			return surname;
		}
		
		@Override
		@RosettaAttribute("suffix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("suffix")
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		@RosettaAttribute("personId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("personId")
		public List<? extends PersonId> getPersonId() {
			return personId;
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessUnitReference")
		public BusinessUnitReference getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contactInfo")
		public ContactInformation getContactInfo() {
			return contactInfo;
		}
		
		@Override
		@RosettaAttribute("dateOfBirth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateOfBirth")
		public ZonedDateTime getDateOfBirth() {
			return dateOfBirth;
		}
		
		@Override
		@RosettaAttribute("country")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		public Person build() {
			return this;
		}
		
		@Override
		public Person.PersonBuilder toBuilder() {
			Person.PersonBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Person.PersonBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getHonorific()).ifPresent(builder::setHonorific);
			ofNullable(getFirstName()).ifPresent(builder::setFirstName);
			ofNullable(getMiddleName()).ifPresent(builder::setMiddleName);
			ofNullable(getInitial()).ifPresent(builder::setInitial);
			ofNullable(getSurname()).ifPresent(builder::setSurname);
			ofNullable(getSuffix()).ifPresent(builder::setSuffix);
			ofNullable(getPersonId()).ifPresent(builder::setPersonId);
			ofNullable(getBusinessUnitReference()).ifPresent(builder::setBusinessUnitReference);
			ofNullable(getContactInfo()).ifPresent(builder::setContactInfo);
			ofNullable(getDateOfBirth()).ifPresent(builder::setDateOfBirth);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Person _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			if (!ListEquals.listEquals(personId, _that.getPersonId())) return false;
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			_result = 31 * _result + (personId != null ? personId.hashCode() : 0);
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Person {" +
				"id=" + this.id + ", " +
				"honorific=" + this.honorific + ", " +
				"firstName=" + this.firstName + ", " +
				"middleName=" + this.middleName + ", " +
				"initial=" + this.initial + ", " +
				"surname=" + this.surname + ", " +
				"suffix=" + this.suffix + ", " +
				"personId=" + this.personId + ", " +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"country=" + this.country +
			'}';
		}
	}

	/*********************** Builder Implementation of Person  ***********************/
	class PersonBuilderImpl implements Person.PersonBuilder {
	
		protected String id;
		protected String honorific;
		protected String firstName;
		protected List<String> middleName = new ArrayList<>();
		protected List<String> initial = new ArrayList<>();
		protected String surname;
		protected String suffix;
		protected List<PersonId.PersonIdBuilder> personId = new ArrayList<>();
		protected BusinessUnitReference.BusinessUnitReferenceBuilder businessUnitReference;
		protected ContactInformation.ContactInformationBuilder contactInfo;
		protected ZonedDateTime dateOfBirth;
		protected CountryCode.CountryCodeBuilder country;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("honorific")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("honorific")
		public String getHonorific() {
			return honorific;
		}
		
		@Override
		@RosettaAttribute("firstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstName")
		public String getFirstName() {
			return firstName;
		}
		
		@Override
		@RosettaAttribute("middleName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("middleName")
		public List<String> getMiddleName() {
			return middleName;
		}
		
		@Override
		@RosettaAttribute("initial")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("initial")
		public List<String> getInitial() {
			return initial;
		}
		
		@Override
		@RosettaAttribute("surname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("surname")
		public String getSurname() {
			return surname;
		}
		
		@Override
		@RosettaAttribute("suffix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("suffix")
		public String getSuffix() {
			return suffix;
		}
		
		@Override
		@RosettaAttribute("personId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("personId")
		public List<? extends PersonId.PersonIdBuilder> getPersonId() {
			return personId;
		}
		
		@Override
		public PersonId.PersonIdBuilder getOrCreatePersonId(int index) {
			if (personId==null) {
				this.personId = new ArrayList<>();
			}
			return getIndex(personId, index, () -> {
						PersonId.PersonIdBuilder newPersonId = PersonId.builder();
						return newPersonId;
					});
		}
		
		@Override
		@RosettaAttribute("businessUnitReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessUnitReference")
		public BusinessUnitReference.BusinessUnitReferenceBuilder getBusinessUnitReference() {
			return businessUnitReference;
		}
		
		@Override
		public BusinessUnitReference.BusinessUnitReferenceBuilder getOrCreateBusinessUnitReference() {
			BusinessUnitReference.BusinessUnitReferenceBuilder result;
			if (businessUnitReference!=null) {
				result = businessUnitReference;
			}
			else {
				result = businessUnitReference = BusinessUnitReference.builder();
			}
			
			return result;
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
		@RosettaAttribute("dateOfBirth")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateOfBirth")
		public ZonedDateTime getDateOfBirth() {
			return dateOfBirth;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Person.PersonBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("honorific")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("honorific")
		@Override
		public Person.PersonBuilder setHonorific(String _honorific) {
			this.honorific = _honorific == null ? null : _honorific;
			return this;
		}
		
		@RosettaAttribute("firstName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstName")
		@Override
		public Person.PersonBuilder setFirstName(String _firstName) {
			this.firstName = _firstName == null ? null : _firstName;
			return this;
		}
		
		@RosettaAttribute("middleName")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("middleName")
		@Override
		public Person.PersonBuilder addMiddleName(String _middleName) {
			if (_middleName != null) {
				this.middleName.add(_middleName);
			}
			return this;
		}
		
		@Override
		public Person.PersonBuilder addMiddleName(String _middleName, int idx) {
			getIndex(this.middleName, idx, () -> _middleName);
			return this;
		}
		
		@Override
		public Person.PersonBuilder addMiddleName(List<String> middleNames) {
			if (middleNames != null) {
				for (final String toAdd : middleNames) {
					this.middleName.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("middleName")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("middleName")
		@Override
		public Person.PersonBuilder setMiddleName(List<String> middleNames) {
			if (middleNames == null) {
				this.middleName = new ArrayList<>();
			} else {
				this.middleName = middleNames.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("initial")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("initial")
		@Override
		public Person.PersonBuilder addInitial(String _initial) {
			if (_initial != null) {
				this.initial.add(_initial);
			}
			return this;
		}
		
		@Override
		public Person.PersonBuilder addInitial(String _initial, int idx) {
			getIndex(this.initial, idx, () -> _initial);
			return this;
		}
		
		@Override
		public Person.PersonBuilder addInitial(List<String> initials) {
			if (initials != null) {
				for (final String toAdd : initials) {
					this.initial.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("initial")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("initial")
		@Override
		public Person.PersonBuilder setInitial(List<String> initials) {
			if (initials == null) {
				this.initial = new ArrayList<>();
			} else {
				this.initial = initials.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("surname")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("surname")
		@Override
		public Person.PersonBuilder setSurname(String _surname) {
			this.surname = _surname == null ? null : _surname;
			return this;
		}
		
		@RosettaAttribute("suffix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("suffix")
		@Override
		public Person.PersonBuilder setSuffix(String _suffix) {
			this.suffix = _suffix == null ? null : _suffix;
			return this;
		}
		
		@RosettaAttribute("personId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("personId")
		@Override
		public Person.PersonBuilder addPersonId(PersonId _personId) {
			if (_personId != null) {
				this.personId.add(_personId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Person.PersonBuilder addPersonId(PersonId _personId, int idx) {
			getIndex(this.personId, idx, () -> _personId.toBuilder());
			return this;
		}
		
		@Override
		public Person.PersonBuilder addPersonId(List<? extends PersonId> personIds) {
			if (personIds != null) {
				for (final PersonId toAdd : personIds) {
					this.personId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("personId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("personId")
		@Override
		public Person.PersonBuilder setPersonId(List<? extends PersonId> personIds) {
			if (personIds == null) {
				this.personId = new ArrayList<>();
			} else {
				this.personId = personIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("businessUnitReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessUnitReference")
		@Override
		public Person.PersonBuilder setBusinessUnitReference(BusinessUnitReference _businessUnitReference) {
			this.businessUnitReference = _businessUnitReference == null ? null : _businessUnitReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contactInfo")
		@Override
		public Person.PersonBuilder setContactInfo(ContactInformation _contactInfo) {
			this.contactInfo = _contactInfo == null ? null : _contactInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateOfBirth")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateOfBirth")
		@Override
		public Person.PersonBuilder setDateOfBirth(ZonedDateTime _dateOfBirth) {
			this.dateOfBirth = _dateOfBirth == null ? null : _dateOfBirth;
			return this;
		}
		
		@RosettaAttribute("country")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("country")
		@Override
		public Person.PersonBuilder setCountry(CountryCode _country) {
			this.country = _country == null ? null : _country.toBuilder();
			return this;
		}
		
		@Override
		public Person build() {
			return new Person.PersonImpl(this);
		}
		
		@Override
		public Person.PersonBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Person.PersonBuilder prune() {
			personId = personId.stream().filter(b->b!=null).<PersonId.PersonIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (businessUnitReference!=null && !businessUnitReference.prune().hasData()) businessUnitReference = null;
			if (contactInfo!=null && !contactInfo.prune().hasData()) contactInfo = null;
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getHonorific()!=null) return true;
			if (getFirstName()!=null) return true;
			if (getMiddleName()!=null && !getMiddleName().isEmpty()) return true;
			if (getInitial()!=null && !getInitial().isEmpty()) return true;
			if (getSurname()!=null) return true;
			if (getSuffix()!=null) return true;
			if (getPersonId()!=null && getPersonId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBusinessUnitReference()!=null && getBusinessUnitReference().hasData()) return true;
			if (getContactInfo()!=null && getContactInfo().hasData()) return true;
			if (getDateOfBirth()!=null) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Person.PersonBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Person.PersonBuilder o = (Person.PersonBuilder) other;
			
			merger.mergeRosetta(getPersonId(), o.getPersonId(), this::getOrCreatePersonId);
			merger.mergeRosetta(getBusinessUnitReference(), o.getBusinessUnitReference(), this::setBusinessUnitReference);
			merger.mergeRosetta(getContactInfo(), o.getContactInfo(), this::setContactInfo);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getHonorific(), o.getHonorific(), this::setHonorific);
			merger.mergeBasic(getFirstName(), o.getFirstName(), this::setFirstName);
			merger.mergeBasic(getMiddleName(), o.getMiddleName(), (Consumer<String>) this::addMiddleName);
			merger.mergeBasic(getInitial(), o.getInitial(), (Consumer<String>) this::addInitial);
			merger.mergeBasic(getSurname(), o.getSurname(), this::setSurname);
			merger.mergeBasic(getSuffix(), o.getSuffix(), this::setSuffix);
			merger.mergeBasic(getDateOfBirth(), o.getDateOfBirth(), this::setDateOfBirth);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Person _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(honorific, _that.getHonorific())) return false;
			if (!Objects.equals(firstName, _that.getFirstName())) return false;
			if (!ListEquals.listEquals(middleName, _that.getMiddleName())) return false;
			if (!ListEquals.listEquals(initial, _that.getInitial())) return false;
			if (!Objects.equals(surname, _that.getSurname())) return false;
			if (!Objects.equals(suffix, _that.getSuffix())) return false;
			if (!ListEquals.listEquals(personId, _that.getPersonId())) return false;
			if (!Objects.equals(businessUnitReference, _that.getBusinessUnitReference())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(dateOfBirth, _that.getDateOfBirth())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (honorific != null ? honorific.hashCode() : 0);
			_result = 31 * _result + (firstName != null ? firstName.hashCode() : 0);
			_result = 31 * _result + (middleName != null ? middleName.hashCode() : 0);
			_result = 31 * _result + (initial != null ? initial.hashCode() : 0);
			_result = 31 * _result + (surname != null ? surname.hashCode() : 0);
			_result = 31 * _result + (suffix != null ? suffix.hashCode() : 0);
			_result = 31 * _result + (personId != null ? personId.hashCode() : 0);
			_result = 31 * _result + (businessUnitReference != null ? businessUnitReference.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PersonBuilder {" +
				"id=" + this.id + ", " +
				"honorific=" + this.honorific + ", " +
				"firstName=" + this.firstName + ", " +
				"middleName=" + this.middleName + ", " +
				"initial=" + this.initial + ", " +
				"surname=" + this.surname + ", " +
				"suffix=" + this.suffix + ", " +
				"personId=" + this.personId + ", " +
				"businessUnitReference=" + this.businessUnitReference + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"dateOfBirth=" + this.dateOfBirth + ", " +
				"country=" + this.country +
			'}';
		}
	}
}

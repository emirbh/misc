package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.BusinessUnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that represents information about a unit within an organization.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that represents information about a unit within an organization.
 *
 */
@RosettaDataType(value="BusinessUnit", builder=BusinessUnit.BusinessUnitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessUnit", model="fpml", builder=BusinessUnit.BusinessUnitBuilderImpl.class, version="2.1.1")
public interface BusinessUnit extends RosettaModelObject {

	BusinessUnitMeta metaData = new BusinessUnitMeta();

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
	 * Provision A name used to describe the organization unit
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A name used to describe the organization unit
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An identifier used to uniquely identify organization unit
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An identifier used to uniquely identify organization unit
	 *
	 */
	Unit getBusinessUnitId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information on how to contact the unit using various means.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information on how to contact the unit using various means.
	 *
	 */
	ContactInformation getContactInfo();
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
	BusinessUnit build();
	
	BusinessUnit.BusinessUnitBuilder toBuilder();
	
	static BusinessUnit.BusinessUnitBuilder builder() {
		return new BusinessUnit.BusinessUnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessUnit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessUnit> getType() {
		return BusinessUnit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("businessUnitId"), processor, Unit.class, getBusinessUnitId());
		processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.class, getContactInfo());
		processRosetta(path.newSubPath("country"), processor, CountryCode.class, getCountry());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessUnitBuilder extends BusinessUnit, RosettaModelObjectBuilder {
		Unit.UnitBuilder getOrCreateBusinessUnitId();
		@Override
		Unit.UnitBuilder getBusinessUnitId();
		ContactInformation.ContactInformationBuilder getOrCreateContactInfo();
		@Override
		ContactInformation.ContactInformationBuilder getContactInfo();
		CountryCode.CountryCodeBuilder getOrCreateCountry();
		@Override
		CountryCode.CountryCodeBuilder getCountry();
		BusinessUnit.BusinessUnitBuilder setId(String id);
		BusinessUnit.BusinessUnitBuilder setName(String name);
		BusinessUnit.BusinessUnitBuilder setBusinessUnitId(Unit businessUnitId);
		BusinessUnit.BusinessUnitBuilder setContactInfo(ContactInformation contactInfo);
		BusinessUnit.BusinessUnitBuilder setCountry(CountryCode country);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("businessUnitId"), processor, Unit.UnitBuilder.class, getBusinessUnitId());
			processRosetta(path.newSubPath("contactInfo"), processor, ContactInformation.ContactInformationBuilder.class, getContactInfo());
			processRosetta(path.newSubPath("country"), processor, CountryCode.CountryCodeBuilder.class, getCountry());
		}
		

		BusinessUnit.BusinessUnitBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessUnit  ***********************/
	class BusinessUnitImpl implements BusinessUnit {
		private final String id;
		private final String name;
		private final Unit businessUnitId;
		private final ContactInformation contactInfo;
		private final CountryCode country;
		
		protected BusinessUnitImpl(BusinessUnit.BusinessUnitBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.businessUnitId = ofNullable(builder.getBusinessUnitId()).map(f->f.build()).orElse(null);
			this.contactInfo = ofNullable(builder.getContactInfo()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("businessUnitId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessUnitId")
		public Unit getBusinessUnitId() {
			return businessUnitId;
		}
		
		@Override
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contactInfo")
		public ContactInformation getContactInfo() {
			return contactInfo;
		}
		
		@Override
		@RosettaAttribute("country")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("country")
		public CountryCode getCountry() {
			return country;
		}
		
		@Override
		public BusinessUnit build() {
			return this;
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder toBuilder() {
			BusinessUnit.BusinessUnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessUnit.BusinessUnitBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getBusinessUnitId()).ifPresent(builder::setBusinessUnitId);
			ofNullable(getContactInfo()).ifPresent(builder::setContactInfo);
			ofNullable(getCountry()).ifPresent(builder::setCountry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(businessUnitId, _that.getBusinessUnitId())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (businessUnitId != null ? businessUnitId.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnit {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"businessUnitId=" + this.businessUnitId + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"country=" + this.country +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessUnit  ***********************/
	class BusinessUnitBuilderImpl implements BusinessUnit.BusinessUnitBuilder {
	
		protected String id;
		protected String name;
		protected Unit.UnitBuilder businessUnitId;
		protected ContactInformation.ContactInformationBuilder contactInfo;
		protected CountryCode.CountryCodeBuilder country;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("businessUnitId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessUnitId")
		public Unit.UnitBuilder getBusinessUnitId() {
			return businessUnitId;
		}
		
		@Override
		public Unit.UnitBuilder getOrCreateBusinessUnitId() {
			Unit.UnitBuilder result;
			if (businessUnitId!=null) {
				result = businessUnitId;
			}
			else {
				result = businessUnitId = Unit.builder();
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
		public BusinessUnit.BusinessUnitBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public BusinessUnit.BusinessUnitBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("businessUnitId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessUnitId")
		@Override
		public BusinessUnit.BusinessUnitBuilder setBusinessUnitId(Unit _businessUnitId) {
			this.businessUnitId = _businessUnitId == null ? null : _businessUnitId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contactInfo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contactInfo")
		@Override
		public BusinessUnit.BusinessUnitBuilder setContactInfo(ContactInformation _contactInfo) {
			this.contactInfo = _contactInfo == null ? null : _contactInfo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("country")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("country")
		@Override
		public BusinessUnit.BusinessUnitBuilder setCountry(CountryCode _country) {
			this.country = _country == null ? null : _country.toBuilder();
			return this;
		}
		
		@Override
		public BusinessUnit build() {
			return new BusinessUnit.BusinessUnitImpl(this);
		}
		
		@Override
		public BusinessUnit.BusinessUnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnit.BusinessUnitBuilder prune() {
			if (businessUnitId!=null && !businessUnitId.prune().hasData()) businessUnitId = null;
			if (contactInfo!=null && !contactInfo.prune().hasData()) contactInfo = null;
			if (country!=null && !country.prune().hasData()) country = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getBusinessUnitId()!=null && getBusinessUnitId().hasData()) return true;
			if (getContactInfo()!=null && getContactInfo().hasData()) return true;
			if (getCountry()!=null && getCountry().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessUnit.BusinessUnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessUnit.BusinessUnitBuilder o = (BusinessUnit.BusinessUnitBuilder) other;
			
			merger.mergeRosetta(getBusinessUnitId(), o.getBusinessUnitId(), this::setBusinessUnitId);
			merger.mergeRosetta(getContactInfo(), o.getContactInfo(), this::setContactInfo);
			merger.mergeRosetta(getCountry(), o.getCountry(), this::setCountry);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessUnit _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(businessUnitId, _that.getBusinessUnitId())) return false;
			if (!Objects.equals(contactInfo, _that.getContactInfo())) return false;
			if (!Objects.equals(country, _that.getCountry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (businessUnitId != null ? businessUnitId.hashCode() : 0);
			_result = 31 * _result + (contactInfo != null ? contactInfo.hashCode() : 0);
			_result = 31 * _result + (country != null ? country.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessUnitBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"businessUnitId=" + this.businessUnitId + ", " +
				"contactInfo=" + this.contactInfo + ", " +
				"country=" + this.country +
			'}';
		}
	}
}

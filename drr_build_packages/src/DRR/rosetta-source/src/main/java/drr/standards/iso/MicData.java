package drr.standards.iso;

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
import com.rosetta.model.lib.records.Date;
import drr.standards.iso.meta.MicDataMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="MicData", builder=MicData.MicDataBuilderImpl.class, version="7.7.0")
@RuneDataType(value="MicData", model="drr", builder=MicData.MicDataBuilderImpl.class, version="7.7.0")
public interface MicData extends RosettaModelObject {

	MicDataMeta metaData = new MicDataMeta();

	/*********************** Getter Methods  ***********************/
	String getMic();
	String getOperatingMic();
	MicTypeEnum getMicType();
	String getNameInstitutionDescription();
	String getLegalEntityName();
	MicMarketCategoryEnum getMarketCategory();
	MicMarketCategoryEnum getMarketCategoryEsma();
	MicMarketCategoryEnum getMarketCategoryFca();
	String getAcronym();
	String getCountryCode();
	String getCity();
	String getWebsite();
	String getStatus();
	Date getCreationDate();
	Date getLastUpdateDate();
	Date getLastValidationDate();
	Date getExpiryDate();
	/**
	 * Specifies whether the MIC enrichment data should be used (True) or not (False).
	 */
	Boolean getMicValidation();

	/*********************** Build Methods  ***********************/
	MicData build();
	
	MicData.MicDataBuilder toBuilder();
	
	static MicData.MicDataBuilder builder() {
		return new MicData.MicDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MicData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MicData> getType() {
		return MicData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("mic"), String.class, getMic(), this);
		processor.processBasic(path.newSubPath("operatingMic"), String.class, getOperatingMic(), this);
		processor.processBasic(path.newSubPath("micType"), MicTypeEnum.class, getMicType(), this);
		processor.processBasic(path.newSubPath("nameInstitutionDescription"), String.class, getNameInstitutionDescription(), this);
		processor.processBasic(path.newSubPath("legalEntityName"), String.class, getLegalEntityName(), this);
		processor.processBasic(path.newSubPath("marketCategory"), MicMarketCategoryEnum.class, getMarketCategory(), this);
		processor.processBasic(path.newSubPath("marketCategoryEsma"), MicMarketCategoryEnum.class, getMarketCategoryEsma(), this);
		processor.processBasic(path.newSubPath("marketCategoryFca"), MicMarketCategoryEnum.class, getMarketCategoryFca(), this);
		processor.processBasic(path.newSubPath("acronym"), String.class, getAcronym(), this);
		processor.processBasic(path.newSubPath("countryCode"), String.class, getCountryCode(), this);
		processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
		processor.processBasic(path.newSubPath("website"), String.class, getWebsite(), this);
		processor.processBasic(path.newSubPath("status"), String.class, getStatus(), this);
		processor.processBasic(path.newSubPath("creationDate"), Date.class, getCreationDate(), this);
		processor.processBasic(path.newSubPath("lastUpdateDate"), Date.class, getLastUpdateDate(), this);
		processor.processBasic(path.newSubPath("lastValidationDate"), Date.class, getLastValidationDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("micValidation"), Boolean.class, getMicValidation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MicDataBuilder extends MicData, RosettaModelObjectBuilder {
		MicData.MicDataBuilder setMic(String mic);
		MicData.MicDataBuilder setOperatingMic(String operatingMic);
		MicData.MicDataBuilder setMicType(MicTypeEnum micType);
		MicData.MicDataBuilder setNameInstitutionDescription(String nameInstitutionDescription);
		MicData.MicDataBuilder setLegalEntityName(String legalEntityName);
		MicData.MicDataBuilder setMarketCategory(MicMarketCategoryEnum marketCategory);
		MicData.MicDataBuilder setMarketCategoryEsma(MicMarketCategoryEnum marketCategoryEsma);
		MicData.MicDataBuilder setMarketCategoryFca(MicMarketCategoryEnum marketCategoryFca);
		MicData.MicDataBuilder setAcronym(String acronym);
		MicData.MicDataBuilder setCountryCode(String countryCode);
		MicData.MicDataBuilder setCity(String city);
		MicData.MicDataBuilder setWebsite(String website);
		MicData.MicDataBuilder setStatus(String status);
		MicData.MicDataBuilder setCreationDate(Date creationDate);
		MicData.MicDataBuilder setLastUpdateDate(Date lastUpdateDate);
		MicData.MicDataBuilder setLastValidationDate(Date lastValidationDate);
		MicData.MicDataBuilder setExpiryDate(Date expiryDate);
		MicData.MicDataBuilder setMicValidation(Boolean micValidation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("mic"), String.class, getMic(), this);
			processor.processBasic(path.newSubPath("operatingMic"), String.class, getOperatingMic(), this);
			processor.processBasic(path.newSubPath("micType"), MicTypeEnum.class, getMicType(), this);
			processor.processBasic(path.newSubPath("nameInstitutionDescription"), String.class, getNameInstitutionDescription(), this);
			processor.processBasic(path.newSubPath("legalEntityName"), String.class, getLegalEntityName(), this);
			processor.processBasic(path.newSubPath("marketCategory"), MicMarketCategoryEnum.class, getMarketCategory(), this);
			processor.processBasic(path.newSubPath("marketCategoryEsma"), MicMarketCategoryEnum.class, getMarketCategoryEsma(), this);
			processor.processBasic(path.newSubPath("marketCategoryFca"), MicMarketCategoryEnum.class, getMarketCategoryFca(), this);
			processor.processBasic(path.newSubPath("acronym"), String.class, getAcronym(), this);
			processor.processBasic(path.newSubPath("countryCode"), String.class, getCountryCode(), this);
			processor.processBasic(path.newSubPath("city"), String.class, getCity(), this);
			processor.processBasic(path.newSubPath("website"), String.class, getWebsite(), this);
			processor.processBasic(path.newSubPath("status"), String.class, getStatus(), this);
			processor.processBasic(path.newSubPath("creationDate"), Date.class, getCreationDate(), this);
			processor.processBasic(path.newSubPath("lastUpdateDate"), Date.class, getLastUpdateDate(), this);
			processor.processBasic(path.newSubPath("lastValidationDate"), Date.class, getLastValidationDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("micValidation"), Boolean.class, getMicValidation(), this);
		}
		

		MicData.MicDataBuilder prune();
	}

	/*********************** Immutable Implementation of MicData  ***********************/
	class MicDataImpl implements MicData {
		private final String mic;
		private final String operatingMic;
		private final MicTypeEnum micType;
		private final String nameInstitutionDescription;
		private final String legalEntityName;
		private final MicMarketCategoryEnum marketCategory;
		private final MicMarketCategoryEnum marketCategoryEsma;
		private final MicMarketCategoryEnum marketCategoryFca;
		private final String acronym;
		private final String countryCode;
		private final String city;
		private final String website;
		private final String status;
		private final Date creationDate;
		private final Date lastUpdateDate;
		private final Date lastValidationDate;
		private final Date expiryDate;
		private final Boolean micValidation;
		
		protected MicDataImpl(MicData.MicDataBuilder builder) {
			this.mic = builder.getMic();
			this.operatingMic = builder.getOperatingMic();
			this.micType = builder.getMicType();
			this.nameInstitutionDescription = builder.getNameInstitutionDescription();
			this.legalEntityName = builder.getLegalEntityName();
			this.marketCategory = builder.getMarketCategory();
			this.marketCategoryEsma = builder.getMarketCategoryEsma();
			this.marketCategoryFca = builder.getMarketCategoryFca();
			this.acronym = builder.getAcronym();
			this.countryCode = builder.getCountryCode();
			this.city = builder.getCity();
			this.website = builder.getWebsite();
			this.status = builder.getStatus();
			this.creationDate = builder.getCreationDate();
			this.lastUpdateDate = builder.getLastUpdateDate();
			this.lastValidationDate = builder.getLastValidationDate();
			this.expiryDate = builder.getExpiryDate();
			this.micValidation = builder.getMicValidation();
		}
		
		@Override
		@RosettaAttribute("mic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mic")
		public String getMic() {
			return mic;
		}
		
		@Override
		@RosettaAttribute("operatingMic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("operatingMic")
		public String getOperatingMic() {
			return operatingMic;
		}
		
		@Override
		@RosettaAttribute("micType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("micType")
		public MicTypeEnum getMicType() {
			return micType;
		}
		
		@Override
		@RosettaAttribute("nameInstitutionDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nameInstitutionDescription")
		public String getNameInstitutionDescription() {
			return nameInstitutionDescription;
		}
		
		@Override
		@RosettaAttribute("legalEntityName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalEntityName")
		public String getLegalEntityName() {
			return legalEntityName;
		}
		
		@Override
		@RosettaAttribute("marketCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketCategory")
		public MicMarketCategoryEnum getMarketCategory() {
			return marketCategory;
		}
		
		@Override
		@RosettaAttribute("marketCategoryEsma")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketCategoryEsma")
		public MicMarketCategoryEnum getMarketCategoryEsma() {
			return marketCategoryEsma;
		}
		
		@Override
		@RosettaAttribute("marketCategoryFca")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketCategoryFca")
		public MicMarketCategoryEnum getMarketCategoryFca() {
			return marketCategoryFca;
		}
		
		@Override
		@RosettaAttribute("acronym")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("acronym")
		public String getAcronym() {
			return acronym;
		}
		
		@Override
		@RosettaAttribute("countryCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryCode")
		public String getCountryCode() {
			return countryCode;
		}
		
		@Override
		@RosettaAttribute("city")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("city")
		public String getCity() {
			return city;
		}
		
		@Override
		@RosettaAttribute("website")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("website")
		public String getWebsite() {
			return website;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public String getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("creationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creationDate")
		public Date getCreationDate() {
			return creationDate;
		}
		
		@Override
		@RosettaAttribute("lastUpdateDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastUpdateDate")
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}
		
		@Override
		@RosettaAttribute("lastValidationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastValidationDate")
		public Date getLastValidationDate() {
			return lastValidationDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("micValidation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("micValidation")
		public Boolean getMicValidation() {
			return micValidation;
		}
		
		@Override
		public MicData build() {
			return this;
		}
		
		@Override
		public MicData.MicDataBuilder toBuilder() {
			MicData.MicDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MicData.MicDataBuilder builder) {
			ofNullable(getMic()).ifPresent(builder::setMic);
			ofNullable(getOperatingMic()).ifPresent(builder::setOperatingMic);
			ofNullable(getMicType()).ifPresent(builder::setMicType);
			ofNullable(getNameInstitutionDescription()).ifPresent(builder::setNameInstitutionDescription);
			ofNullable(getLegalEntityName()).ifPresent(builder::setLegalEntityName);
			ofNullable(getMarketCategory()).ifPresent(builder::setMarketCategory);
			ofNullable(getMarketCategoryEsma()).ifPresent(builder::setMarketCategoryEsma);
			ofNullable(getMarketCategoryFca()).ifPresent(builder::setMarketCategoryFca);
			ofNullable(getAcronym()).ifPresent(builder::setAcronym);
			ofNullable(getCountryCode()).ifPresent(builder::setCountryCode);
			ofNullable(getCity()).ifPresent(builder::setCity);
			ofNullable(getWebsite()).ifPresent(builder::setWebsite);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getCreationDate()).ifPresent(builder::setCreationDate);
			ofNullable(getLastUpdateDate()).ifPresent(builder::setLastUpdateDate);
			ofNullable(getLastValidationDate()).ifPresent(builder::setLastValidationDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getMicValidation()).ifPresent(builder::setMicValidation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MicData _that = getType().cast(o);
		
			if (!Objects.equals(mic, _that.getMic())) return false;
			if (!Objects.equals(operatingMic, _that.getOperatingMic())) return false;
			if (!Objects.equals(micType, _that.getMicType())) return false;
			if (!Objects.equals(nameInstitutionDescription, _that.getNameInstitutionDescription())) return false;
			if (!Objects.equals(legalEntityName, _that.getLegalEntityName())) return false;
			if (!Objects.equals(marketCategory, _that.getMarketCategory())) return false;
			if (!Objects.equals(marketCategoryEsma, _that.getMarketCategoryEsma())) return false;
			if (!Objects.equals(marketCategoryFca, _that.getMarketCategoryFca())) return false;
			if (!Objects.equals(acronym, _that.getAcronym())) return false;
			if (!Objects.equals(countryCode, _that.getCountryCode())) return false;
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(website, _that.getWebsite())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(creationDate, _that.getCreationDate())) return false;
			if (!Objects.equals(lastUpdateDate, _that.getLastUpdateDate())) return false;
			if (!Objects.equals(lastValidationDate, _that.getLastValidationDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(micValidation, _that.getMicValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mic != null ? mic.hashCode() : 0);
			_result = 31 * _result + (operatingMic != null ? operatingMic.hashCode() : 0);
			_result = 31 * _result + (micType != null ? micType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nameInstitutionDescription != null ? nameInstitutionDescription.hashCode() : 0);
			_result = 31 * _result + (legalEntityName != null ? legalEntityName.hashCode() : 0);
			_result = 31 * _result + (marketCategory != null ? marketCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (marketCategoryEsma != null ? marketCategoryEsma.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (marketCategoryFca != null ? marketCategoryFca.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (acronym != null ? acronym.hashCode() : 0);
			_result = 31 * _result + (countryCode != null ? countryCode.hashCode() : 0);
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (website != null ? website.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (creationDate != null ? creationDate.hashCode() : 0);
			_result = 31 * _result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
			_result = 31 * _result + (lastValidationDate != null ? lastValidationDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (micValidation != null ? micValidation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MicData {" +
				"mic=" + this.mic + ", " +
				"operatingMic=" + this.operatingMic + ", " +
				"micType=" + this.micType + ", " +
				"nameInstitutionDescription=" + this.nameInstitutionDescription + ", " +
				"legalEntityName=" + this.legalEntityName + ", " +
				"marketCategory=" + this.marketCategory + ", " +
				"marketCategoryEsma=" + this.marketCategoryEsma + ", " +
				"marketCategoryFca=" + this.marketCategoryFca + ", " +
				"acronym=" + this.acronym + ", " +
				"countryCode=" + this.countryCode + ", " +
				"city=" + this.city + ", " +
				"website=" + this.website + ", " +
				"status=" + this.status + ", " +
				"creationDate=" + this.creationDate + ", " +
				"lastUpdateDate=" + this.lastUpdateDate + ", " +
				"lastValidationDate=" + this.lastValidationDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"micValidation=" + this.micValidation +
			'}';
		}
	}

	/*********************** Builder Implementation of MicData  ***********************/
	class MicDataBuilderImpl implements MicData.MicDataBuilder {
	
		protected String mic;
		protected String operatingMic;
		protected MicTypeEnum micType;
		protected String nameInstitutionDescription;
		protected String legalEntityName;
		protected MicMarketCategoryEnum marketCategory;
		protected MicMarketCategoryEnum marketCategoryEsma;
		protected MicMarketCategoryEnum marketCategoryFca;
		protected String acronym;
		protected String countryCode;
		protected String city;
		protected String website;
		protected String status;
		protected Date creationDate;
		protected Date lastUpdateDate;
		protected Date lastValidationDate;
		protected Date expiryDate;
		protected Boolean micValidation;
		
		@Override
		@RosettaAttribute("mic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mic")
		public String getMic() {
			return mic;
		}
		
		@Override
		@RosettaAttribute("operatingMic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("operatingMic")
		public String getOperatingMic() {
			return operatingMic;
		}
		
		@Override
		@RosettaAttribute("micType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("micType")
		public MicTypeEnum getMicType() {
			return micType;
		}
		
		@Override
		@RosettaAttribute("nameInstitutionDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nameInstitutionDescription")
		public String getNameInstitutionDescription() {
			return nameInstitutionDescription;
		}
		
		@Override
		@RosettaAttribute("legalEntityName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legalEntityName")
		public String getLegalEntityName() {
			return legalEntityName;
		}
		
		@Override
		@RosettaAttribute("marketCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketCategory")
		public MicMarketCategoryEnum getMarketCategory() {
			return marketCategory;
		}
		
		@Override
		@RosettaAttribute("marketCategoryEsma")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketCategoryEsma")
		public MicMarketCategoryEnum getMarketCategoryEsma() {
			return marketCategoryEsma;
		}
		
		@Override
		@RosettaAttribute("marketCategoryFca")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketCategoryFca")
		public MicMarketCategoryEnum getMarketCategoryFca() {
			return marketCategoryFca;
		}
		
		@Override
		@RosettaAttribute("acronym")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("acronym")
		public String getAcronym() {
			return acronym;
		}
		
		@Override
		@RosettaAttribute("countryCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryCode")
		public String getCountryCode() {
			return countryCode;
		}
		
		@Override
		@RosettaAttribute("city")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("city")
		public String getCity() {
			return city;
		}
		
		@Override
		@RosettaAttribute("website")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("website")
		public String getWebsite() {
			return website;
		}
		
		@Override
		@RosettaAttribute("status")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("status")
		public String getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("creationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creationDate")
		public Date getCreationDate() {
			return creationDate;
		}
		
		@Override
		@RosettaAttribute("lastUpdateDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastUpdateDate")
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}
		
		@Override
		@RosettaAttribute("lastValidationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastValidationDate")
		public Date getLastValidationDate() {
			return lastValidationDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("micValidation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("micValidation")
		public Boolean getMicValidation() {
			return micValidation;
		}
		
		@RosettaAttribute("mic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mic")
		@Override
		public MicData.MicDataBuilder setMic(String _mic) {
			this.mic = _mic == null ? null : _mic;
			return this;
		}
		
		@RosettaAttribute("operatingMic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("operatingMic")
		@Override
		public MicData.MicDataBuilder setOperatingMic(String _operatingMic) {
			this.operatingMic = _operatingMic == null ? null : _operatingMic;
			return this;
		}
		
		@RosettaAttribute("micType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("micType")
		@Override
		public MicData.MicDataBuilder setMicType(MicTypeEnum _micType) {
			this.micType = _micType == null ? null : _micType;
			return this;
		}
		
		@RosettaAttribute("nameInstitutionDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nameInstitutionDescription")
		@Override
		public MicData.MicDataBuilder setNameInstitutionDescription(String _nameInstitutionDescription) {
			this.nameInstitutionDescription = _nameInstitutionDescription == null ? null : _nameInstitutionDescription;
			return this;
		}
		
		@RosettaAttribute("legalEntityName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legalEntityName")
		@Override
		public MicData.MicDataBuilder setLegalEntityName(String _legalEntityName) {
			this.legalEntityName = _legalEntityName == null ? null : _legalEntityName;
			return this;
		}
		
		@RosettaAttribute("marketCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketCategory")
		@Override
		public MicData.MicDataBuilder setMarketCategory(MicMarketCategoryEnum _marketCategory) {
			this.marketCategory = _marketCategory == null ? null : _marketCategory;
			return this;
		}
		
		@RosettaAttribute("marketCategoryEsma")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketCategoryEsma")
		@Override
		public MicData.MicDataBuilder setMarketCategoryEsma(MicMarketCategoryEnum _marketCategoryEsma) {
			this.marketCategoryEsma = _marketCategoryEsma == null ? null : _marketCategoryEsma;
			return this;
		}
		
		@RosettaAttribute("marketCategoryFca")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketCategoryFca")
		@Override
		public MicData.MicDataBuilder setMarketCategoryFca(MicMarketCategoryEnum _marketCategoryFca) {
			this.marketCategoryFca = _marketCategoryFca == null ? null : _marketCategoryFca;
			return this;
		}
		
		@RosettaAttribute("acronym")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("acronym")
		@Override
		public MicData.MicDataBuilder setAcronym(String _acronym) {
			this.acronym = _acronym == null ? null : _acronym;
			return this;
		}
		
		@RosettaAttribute("countryCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryCode")
		@Override
		public MicData.MicDataBuilder setCountryCode(String _countryCode) {
			this.countryCode = _countryCode == null ? null : _countryCode;
			return this;
		}
		
		@RosettaAttribute("city")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("city")
		@Override
		public MicData.MicDataBuilder setCity(String _city) {
			this.city = _city == null ? null : _city;
			return this;
		}
		
		@RosettaAttribute("website")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("website")
		@Override
		public MicData.MicDataBuilder setWebsite(String _website) {
			this.website = _website == null ? null : _website;
			return this;
		}
		
		@RosettaAttribute("status")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("status")
		@Override
		public MicData.MicDataBuilder setStatus(String _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("creationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creationDate")
		@Override
		public MicData.MicDataBuilder setCreationDate(Date _creationDate) {
			this.creationDate = _creationDate == null ? null : _creationDate;
			return this;
		}
		
		@RosettaAttribute("lastUpdateDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastUpdateDate")
		@Override
		public MicData.MicDataBuilder setLastUpdateDate(Date _lastUpdateDate) {
			this.lastUpdateDate = _lastUpdateDate == null ? null : _lastUpdateDate;
			return this;
		}
		
		@RosettaAttribute("lastValidationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastValidationDate")
		@Override
		public MicData.MicDataBuilder setLastValidationDate(Date _lastValidationDate) {
			this.lastValidationDate = _lastValidationDate == null ? null : _lastValidationDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public MicData.MicDataBuilder setExpiryDate(Date _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("micValidation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("micValidation")
		@Override
		public MicData.MicDataBuilder setMicValidation(Boolean _micValidation) {
			this.micValidation = _micValidation == null ? null : _micValidation;
			return this;
		}
		
		@Override
		public MicData build() {
			return new MicData.MicDataImpl(this);
		}
		
		@Override
		public MicData.MicDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MicData.MicDataBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMic()!=null) return true;
			if (getOperatingMic()!=null) return true;
			if (getMicType()!=null) return true;
			if (getNameInstitutionDescription()!=null) return true;
			if (getLegalEntityName()!=null) return true;
			if (getMarketCategory()!=null) return true;
			if (getMarketCategoryEsma()!=null) return true;
			if (getMarketCategoryFca()!=null) return true;
			if (getAcronym()!=null) return true;
			if (getCountryCode()!=null) return true;
			if (getCity()!=null) return true;
			if (getWebsite()!=null) return true;
			if (getStatus()!=null) return true;
			if (getCreationDate()!=null) return true;
			if (getLastUpdateDate()!=null) return true;
			if (getLastValidationDate()!=null) return true;
			if (getExpiryDate()!=null) return true;
			if (getMicValidation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MicData.MicDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MicData.MicDataBuilder o = (MicData.MicDataBuilder) other;
			
			
			merger.mergeBasic(getMic(), o.getMic(), this::setMic);
			merger.mergeBasic(getOperatingMic(), o.getOperatingMic(), this::setOperatingMic);
			merger.mergeBasic(getMicType(), o.getMicType(), this::setMicType);
			merger.mergeBasic(getNameInstitutionDescription(), o.getNameInstitutionDescription(), this::setNameInstitutionDescription);
			merger.mergeBasic(getLegalEntityName(), o.getLegalEntityName(), this::setLegalEntityName);
			merger.mergeBasic(getMarketCategory(), o.getMarketCategory(), this::setMarketCategory);
			merger.mergeBasic(getMarketCategoryEsma(), o.getMarketCategoryEsma(), this::setMarketCategoryEsma);
			merger.mergeBasic(getMarketCategoryFca(), o.getMarketCategoryFca(), this::setMarketCategoryFca);
			merger.mergeBasic(getAcronym(), o.getAcronym(), this::setAcronym);
			merger.mergeBasic(getCountryCode(), o.getCountryCode(), this::setCountryCode);
			merger.mergeBasic(getCity(), o.getCity(), this::setCity);
			merger.mergeBasic(getWebsite(), o.getWebsite(), this::setWebsite);
			merger.mergeBasic(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeBasic(getCreationDate(), o.getCreationDate(), this::setCreationDate);
			merger.mergeBasic(getLastUpdateDate(), o.getLastUpdateDate(), this::setLastUpdateDate);
			merger.mergeBasic(getLastValidationDate(), o.getLastValidationDate(), this::setLastValidationDate);
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getMicValidation(), o.getMicValidation(), this::setMicValidation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MicData _that = getType().cast(o);
		
			if (!Objects.equals(mic, _that.getMic())) return false;
			if (!Objects.equals(operatingMic, _that.getOperatingMic())) return false;
			if (!Objects.equals(micType, _that.getMicType())) return false;
			if (!Objects.equals(nameInstitutionDescription, _that.getNameInstitutionDescription())) return false;
			if (!Objects.equals(legalEntityName, _that.getLegalEntityName())) return false;
			if (!Objects.equals(marketCategory, _that.getMarketCategory())) return false;
			if (!Objects.equals(marketCategoryEsma, _that.getMarketCategoryEsma())) return false;
			if (!Objects.equals(marketCategoryFca, _that.getMarketCategoryFca())) return false;
			if (!Objects.equals(acronym, _that.getAcronym())) return false;
			if (!Objects.equals(countryCode, _that.getCountryCode())) return false;
			if (!Objects.equals(city, _that.getCity())) return false;
			if (!Objects.equals(website, _that.getWebsite())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(creationDate, _that.getCreationDate())) return false;
			if (!Objects.equals(lastUpdateDate, _that.getLastUpdateDate())) return false;
			if (!Objects.equals(lastValidationDate, _that.getLastValidationDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(micValidation, _that.getMicValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mic != null ? mic.hashCode() : 0);
			_result = 31 * _result + (operatingMic != null ? operatingMic.hashCode() : 0);
			_result = 31 * _result + (micType != null ? micType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (nameInstitutionDescription != null ? nameInstitutionDescription.hashCode() : 0);
			_result = 31 * _result + (legalEntityName != null ? legalEntityName.hashCode() : 0);
			_result = 31 * _result + (marketCategory != null ? marketCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (marketCategoryEsma != null ? marketCategoryEsma.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (marketCategoryFca != null ? marketCategoryFca.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (acronym != null ? acronym.hashCode() : 0);
			_result = 31 * _result + (countryCode != null ? countryCode.hashCode() : 0);
			_result = 31 * _result + (city != null ? city.hashCode() : 0);
			_result = 31 * _result + (website != null ? website.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (creationDate != null ? creationDate.hashCode() : 0);
			_result = 31 * _result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
			_result = 31 * _result + (lastValidationDate != null ? lastValidationDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (micValidation != null ? micValidation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MicDataBuilder {" +
				"mic=" + this.mic + ", " +
				"operatingMic=" + this.operatingMic + ", " +
				"micType=" + this.micType + ", " +
				"nameInstitutionDescription=" + this.nameInstitutionDescription + ", " +
				"legalEntityName=" + this.legalEntityName + ", " +
				"marketCategory=" + this.marketCategory + ", " +
				"marketCategoryEsma=" + this.marketCategoryEsma + ", " +
				"marketCategoryFca=" + this.marketCategoryFca + ", " +
				"acronym=" + this.acronym + ", " +
				"countryCode=" + this.countryCode + ", " +
				"city=" + this.city + ", " +
				"website=" + this.website + ", " +
				"status=" + this.status + ", " +
				"creationDate=" + this.creationDate + ", " +
				"lastUpdateDate=" + this.lastUpdateDate + ", " +
				"lastValidationDate=" + this.lastValidationDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"micValidation=" + this.micValidation +
			'}';
		}
	}
}

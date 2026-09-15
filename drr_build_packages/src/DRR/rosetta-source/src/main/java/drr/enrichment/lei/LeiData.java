package drr.enrichment.lei;

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
import drr.enrichment.lei.meta.LeiDataMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * LEI data from GLEIF.
 * @version 7.7.0
 */
@RosettaDataType(value="LeiData", builder=LeiData.LeiDataBuilderImpl.class, version="7.7.0")
@RuneDataType(value="LeiData", model="drr", builder=LeiData.LeiDataBuilderImpl.class, version="7.7.0")
public interface LeiData extends RosettaModelObject {

	LeiDataMeta metaData = new LeiDataMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * LEI identifier.
	 */
	String getLei();
	/**
	 * LEI legal entity name.
	 */
	String getEntityName();
	/**
	 * LEI legal entity category.
	 */
	LeiCategoryEnum getEntityCategory();
	/**
	 * LEI legal entity status.
	 */
	LeiStatusEnum getEntityStatus();
	/**
	 * LEI branch entity status.
	 */
	LeiStatusEnum getBranchEntityStatus();
	LeiGeneralCategoryEnum getGeneralCategory();
	/**
	 * LEI registration status.
	 */
	LeiRegistrationStatusEnum getRegistrationStatus();
	/**
	 * LEI registration date.
	 */
	ZonedDateTime getRegistrationDate();
	/**
	 * The LEI is included in the LEI data as published by GLEIF.
	 */
	Boolean getPublished();
	/**
	 * Specifies whether the LEI enrichment data should be used (True) or not (False).
	 */
	Boolean getLeiValidation();

	/*********************** Build Methods  ***********************/
	LeiData build();
	
	LeiData.LeiDataBuilder toBuilder();
	
	static LeiData.LeiDataBuilder builder() {
		return new LeiData.LeiDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LeiData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LeiData> getType() {
		return LeiData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
		processor.processBasic(path.newSubPath("entityName"), String.class, getEntityName(), this);
		processor.processBasic(path.newSubPath("entityCategory"), LeiCategoryEnum.class, getEntityCategory(), this);
		processor.processBasic(path.newSubPath("entityStatus"), LeiStatusEnum.class, getEntityStatus(), this);
		processor.processBasic(path.newSubPath("branchEntityStatus"), LeiStatusEnum.class, getBranchEntityStatus(), this);
		processor.processBasic(path.newSubPath("generalCategory"), LeiGeneralCategoryEnum.class, getGeneralCategory(), this);
		processor.processBasic(path.newSubPath("registrationStatus"), LeiRegistrationStatusEnum.class, getRegistrationStatus(), this);
		processor.processBasic(path.newSubPath("registrationDate"), ZonedDateTime.class, getRegistrationDate(), this);
		processor.processBasic(path.newSubPath("published"), Boolean.class, getPublished(), this);
		processor.processBasic(path.newSubPath("leiValidation"), Boolean.class, getLeiValidation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LeiDataBuilder extends LeiData, RosettaModelObjectBuilder {
		LeiData.LeiDataBuilder setLei(String lei);
		LeiData.LeiDataBuilder setEntityName(String entityName);
		LeiData.LeiDataBuilder setEntityCategory(LeiCategoryEnum entityCategory);
		LeiData.LeiDataBuilder setEntityStatus(LeiStatusEnum entityStatus);
		LeiData.LeiDataBuilder setBranchEntityStatus(LeiStatusEnum branchEntityStatus);
		LeiData.LeiDataBuilder setGeneralCategory(LeiGeneralCategoryEnum generalCategory);
		LeiData.LeiDataBuilder setRegistrationStatus(LeiRegistrationStatusEnum registrationStatus);
		LeiData.LeiDataBuilder setRegistrationDate(ZonedDateTime registrationDate);
		LeiData.LeiDataBuilder setPublished(Boolean published);
		LeiData.LeiDataBuilder setLeiValidation(Boolean leiValidation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lei"), String.class, getLei(), this);
			processor.processBasic(path.newSubPath("entityName"), String.class, getEntityName(), this);
			processor.processBasic(path.newSubPath("entityCategory"), LeiCategoryEnum.class, getEntityCategory(), this);
			processor.processBasic(path.newSubPath("entityStatus"), LeiStatusEnum.class, getEntityStatus(), this);
			processor.processBasic(path.newSubPath("branchEntityStatus"), LeiStatusEnum.class, getBranchEntityStatus(), this);
			processor.processBasic(path.newSubPath("generalCategory"), LeiGeneralCategoryEnum.class, getGeneralCategory(), this);
			processor.processBasic(path.newSubPath("registrationStatus"), LeiRegistrationStatusEnum.class, getRegistrationStatus(), this);
			processor.processBasic(path.newSubPath("registrationDate"), ZonedDateTime.class, getRegistrationDate(), this);
			processor.processBasic(path.newSubPath("published"), Boolean.class, getPublished(), this);
			processor.processBasic(path.newSubPath("leiValidation"), Boolean.class, getLeiValidation(), this);
		}
		

		LeiData.LeiDataBuilder prune();
	}

	/*********************** Immutable Implementation of LeiData  ***********************/
	class LeiDataImpl implements LeiData {
		private final String lei;
		private final String entityName;
		private final LeiCategoryEnum entityCategory;
		private final LeiStatusEnum entityStatus;
		private final LeiStatusEnum branchEntityStatus;
		private final LeiGeneralCategoryEnum generalCategory;
		private final LeiRegistrationStatusEnum registrationStatus;
		private final ZonedDateTime registrationDate;
		private final Boolean published;
		private final Boolean leiValidation;
		
		protected LeiDataImpl(LeiData.LeiDataBuilder builder) {
			this.lei = builder.getLei();
			this.entityName = builder.getEntityName();
			this.entityCategory = builder.getEntityCategory();
			this.entityStatus = builder.getEntityStatus();
			this.branchEntityStatus = builder.getBranchEntityStatus();
			this.generalCategory = builder.getGeneralCategory();
			this.registrationStatus = builder.getRegistrationStatus();
			this.registrationDate = builder.getRegistrationDate();
			this.published = builder.getPublished();
			this.leiValidation = builder.getLeiValidation();
		}
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@Override
		@RosettaAttribute("entityName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityName")
		public String getEntityName() {
			return entityName;
		}
		
		@Override
		@RosettaAttribute("entityCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityCategory")
		public LeiCategoryEnum getEntityCategory() {
			return entityCategory;
		}
		
		@Override
		@RosettaAttribute("entityStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityStatus")
		public LeiStatusEnum getEntityStatus() {
			return entityStatus;
		}
		
		@Override
		@RosettaAttribute("branchEntityStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("branchEntityStatus")
		public LeiStatusEnum getBranchEntityStatus() {
			return branchEntityStatus;
		}
		
		@Override
		@RosettaAttribute("generalCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalCategory")
		public LeiGeneralCategoryEnum getGeneralCategory() {
			return generalCategory;
		}
		
		@Override
		@RosettaAttribute("registrationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("registrationStatus")
		public LeiRegistrationStatusEnum getRegistrationStatus() {
			return registrationStatus;
		}
		
		@Override
		@RosettaAttribute("registrationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("registrationDate")
		public ZonedDateTime getRegistrationDate() {
			return registrationDate;
		}
		
		@Override
		@RosettaAttribute("published")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("published")
		public Boolean getPublished() {
			return published;
		}
		
		@Override
		@RosettaAttribute("leiValidation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leiValidation")
		public Boolean getLeiValidation() {
			return leiValidation;
		}
		
		@Override
		public LeiData build() {
			return this;
		}
		
		@Override
		public LeiData.LeiDataBuilder toBuilder() {
			LeiData.LeiDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LeiData.LeiDataBuilder builder) {
			ofNullable(getLei()).ifPresent(builder::setLei);
			ofNullable(getEntityName()).ifPresent(builder::setEntityName);
			ofNullable(getEntityCategory()).ifPresent(builder::setEntityCategory);
			ofNullable(getEntityStatus()).ifPresent(builder::setEntityStatus);
			ofNullable(getBranchEntityStatus()).ifPresent(builder::setBranchEntityStatus);
			ofNullable(getGeneralCategory()).ifPresent(builder::setGeneralCategory);
			ofNullable(getRegistrationStatus()).ifPresent(builder::setRegistrationStatus);
			ofNullable(getRegistrationDate()).ifPresent(builder::setRegistrationDate);
			ofNullable(getPublished()).ifPresent(builder::setPublished);
			ofNullable(getLeiValidation()).ifPresent(builder::setLeiValidation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LeiData _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			if (!Objects.equals(entityName, _that.getEntityName())) return false;
			if (!Objects.equals(entityCategory, _that.getEntityCategory())) return false;
			if (!Objects.equals(entityStatus, _that.getEntityStatus())) return false;
			if (!Objects.equals(branchEntityStatus, _that.getBranchEntityStatus())) return false;
			if (!Objects.equals(generalCategory, _that.getGeneralCategory())) return false;
			if (!Objects.equals(registrationStatus, _that.getRegistrationStatus())) return false;
			if (!Objects.equals(registrationDate, _that.getRegistrationDate())) return false;
			if (!Objects.equals(published, _that.getPublished())) return false;
			if (!Objects.equals(leiValidation, _that.getLeiValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			_result = 31 * _result + (entityName != null ? entityName.hashCode() : 0);
			_result = 31 * _result + (entityCategory != null ? entityCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (entityStatus != null ? entityStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (branchEntityStatus != null ? branchEntityStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (generalCategory != null ? generalCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (registrationStatus != null ? registrationStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (registrationDate != null ? registrationDate.hashCode() : 0);
			_result = 31 * _result + (published != null ? published.hashCode() : 0);
			_result = 31 * _result + (leiValidation != null ? leiValidation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LeiData {" +
				"lei=" + this.lei + ", " +
				"entityName=" + this.entityName + ", " +
				"entityCategory=" + this.entityCategory + ", " +
				"entityStatus=" + this.entityStatus + ", " +
				"branchEntityStatus=" + this.branchEntityStatus + ", " +
				"generalCategory=" + this.generalCategory + ", " +
				"registrationStatus=" + this.registrationStatus + ", " +
				"registrationDate=" + this.registrationDate + ", " +
				"published=" + this.published + ", " +
				"leiValidation=" + this.leiValidation +
			'}';
		}
	}

	/*********************** Builder Implementation of LeiData  ***********************/
	class LeiDataBuilderImpl implements LeiData.LeiDataBuilder {
	
		protected String lei;
		protected String entityName;
		protected LeiCategoryEnum entityCategory;
		protected LeiStatusEnum entityStatus;
		protected LeiStatusEnum branchEntityStatus;
		protected LeiGeneralCategoryEnum generalCategory;
		protected LeiRegistrationStatusEnum registrationStatus;
		protected ZonedDateTime registrationDate;
		protected Boolean published;
		protected Boolean leiValidation;
		
		@Override
		@RosettaAttribute("lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lei")
		public String getLei() {
			return lei;
		}
		
		@Override
		@RosettaAttribute("entityName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityName")
		public String getEntityName() {
			return entityName;
		}
		
		@Override
		@RosettaAttribute("entityCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityCategory")
		public LeiCategoryEnum getEntityCategory() {
			return entityCategory;
		}
		
		@Override
		@RosettaAttribute("entityStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entityStatus")
		public LeiStatusEnum getEntityStatus() {
			return entityStatus;
		}
		
		@Override
		@RosettaAttribute("branchEntityStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("branchEntityStatus")
		public LeiStatusEnum getBranchEntityStatus() {
			return branchEntityStatus;
		}
		
		@Override
		@RosettaAttribute("generalCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalCategory")
		public LeiGeneralCategoryEnum getGeneralCategory() {
			return generalCategory;
		}
		
		@Override
		@RosettaAttribute("registrationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("registrationStatus")
		public LeiRegistrationStatusEnum getRegistrationStatus() {
			return registrationStatus;
		}
		
		@Override
		@RosettaAttribute("registrationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("registrationDate")
		public ZonedDateTime getRegistrationDate() {
			return registrationDate;
		}
		
		@Override
		@RosettaAttribute("published")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("published")
		public Boolean getPublished() {
			return published;
		}
		
		@Override
		@RosettaAttribute("leiValidation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leiValidation")
		public Boolean getLeiValidation() {
			return leiValidation;
		}
		
		@RosettaAttribute("lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lei")
		@Override
		public LeiData.LeiDataBuilder setLei(String _lei) {
			this.lei = _lei == null ? null : _lei;
			return this;
		}
		
		@RosettaAttribute("entityName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityName")
		@Override
		public LeiData.LeiDataBuilder setEntityName(String _entityName) {
			this.entityName = _entityName == null ? null : _entityName;
			return this;
		}
		
		@RosettaAttribute("entityCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityCategory")
		@Override
		public LeiData.LeiDataBuilder setEntityCategory(LeiCategoryEnum _entityCategory) {
			this.entityCategory = _entityCategory == null ? null : _entityCategory;
			return this;
		}
		
		@RosettaAttribute("entityStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entityStatus")
		@Override
		public LeiData.LeiDataBuilder setEntityStatus(LeiStatusEnum _entityStatus) {
			this.entityStatus = _entityStatus == null ? null : _entityStatus;
			return this;
		}
		
		@RosettaAttribute("branchEntityStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("branchEntityStatus")
		@Override
		public LeiData.LeiDataBuilder setBranchEntityStatus(LeiStatusEnum _branchEntityStatus) {
			this.branchEntityStatus = _branchEntityStatus == null ? null : _branchEntityStatus;
			return this;
		}
		
		@RosettaAttribute("generalCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generalCategory")
		@Override
		public LeiData.LeiDataBuilder setGeneralCategory(LeiGeneralCategoryEnum _generalCategory) {
			this.generalCategory = _generalCategory == null ? null : _generalCategory;
			return this;
		}
		
		@RosettaAttribute("registrationStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("registrationStatus")
		@Override
		public LeiData.LeiDataBuilder setRegistrationStatus(LeiRegistrationStatusEnum _registrationStatus) {
			this.registrationStatus = _registrationStatus == null ? null : _registrationStatus;
			return this;
		}
		
		@RosettaAttribute("registrationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("registrationDate")
		@Override
		public LeiData.LeiDataBuilder setRegistrationDate(ZonedDateTime _registrationDate) {
			this.registrationDate = _registrationDate == null ? null : _registrationDate;
			return this;
		}
		
		@RosettaAttribute("published")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("published")
		@Override
		public LeiData.LeiDataBuilder setPublished(Boolean _published) {
			this.published = _published == null ? null : _published;
			return this;
		}
		
		@RosettaAttribute("leiValidation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leiValidation")
		@Override
		public LeiData.LeiDataBuilder setLeiValidation(Boolean _leiValidation) {
			this.leiValidation = _leiValidation == null ? null : _leiValidation;
			return this;
		}
		
		@Override
		public LeiData build() {
			return new LeiData.LeiDataImpl(this);
		}
		
		@Override
		public LeiData.LeiDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LeiData.LeiDataBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLei()!=null) return true;
			if (getEntityName()!=null) return true;
			if (getEntityCategory()!=null) return true;
			if (getEntityStatus()!=null) return true;
			if (getBranchEntityStatus()!=null) return true;
			if (getGeneralCategory()!=null) return true;
			if (getRegistrationStatus()!=null) return true;
			if (getRegistrationDate()!=null) return true;
			if (getPublished()!=null) return true;
			if (getLeiValidation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LeiData.LeiDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LeiData.LeiDataBuilder o = (LeiData.LeiDataBuilder) other;
			
			
			merger.mergeBasic(getLei(), o.getLei(), this::setLei);
			merger.mergeBasic(getEntityName(), o.getEntityName(), this::setEntityName);
			merger.mergeBasic(getEntityCategory(), o.getEntityCategory(), this::setEntityCategory);
			merger.mergeBasic(getEntityStatus(), o.getEntityStatus(), this::setEntityStatus);
			merger.mergeBasic(getBranchEntityStatus(), o.getBranchEntityStatus(), this::setBranchEntityStatus);
			merger.mergeBasic(getGeneralCategory(), o.getGeneralCategory(), this::setGeneralCategory);
			merger.mergeBasic(getRegistrationStatus(), o.getRegistrationStatus(), this::setRegistrationStatus);
			merger.mergeBasic(getRegistrationDate(), o.getRegistrationDate(), this::setRegistrationDate);
			merger.mergeBasic(getPublished(), o.getPublished(), this::setPublished);
			merger.mergeBasic(getLeiValidation(), o.getLeiValidation(), this::setLeiValidation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LeiData _that = getType().cast(o);
		
			if (!Objects.equals(lei, _that.getLei())) return false;
			if (!Objects.equals(entityName, _that.getEntityName())) return false;
			if (!Objects.equals(entityCategory, _that.getEntityCategory())) return false;
			if (!Objects.equals(entityStatus, _that.getEntityStatus())) return false;
			if (!Objects.equals(branchEntityStatus, _that.getBranchEntityStatus())) return false;
			if (!Objects.equals(generalCategory, _that.getGeneralCategory())) return false;
			if (!Objects.equals(registrationStatus, _that.getRegistrationStatus())) return false;
			if (!Objects.equals(registrationDate, _that.getRegistrationDate())) return false;
			if (!Objects.equals(published, _that.getPublished())) return false;
			if (!Objects.equals(leiValidation, _that.getLeiValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lei != null ? lei.hashCode() : 0);
			_result = 31 * _result + (entityName != null ? entityName.hashCode() : 0);
			_result = 31 * _result + (entityCategory != null ? entityCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (entityStatus != null ? entityStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (branchEntityStatus != null ? branchEntityStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (generalCategory != null ? generalCategory.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (registrationStatus != null ? registrationStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (registrationDate != null ? registrationDate.hashCode() : 0);
			_result = 31 * _result + (published != null ? published.hashCode() : 0);
			_result = 31 * _result + (leiValidation != null ? leiValidation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LeiDataBuilder {" +
				"lei=" + this.lei + ", " +
				"entityName=" + this.entityName + ", " +
				"entityCategory=" + this.entityCategory + ", " +
				"entityStatus=" + this.entityStatus + ", " +
				"branchEntityStatus=" + this.branchEntityStatus + ", " +
				"generalCategory=" + this.generalCategory + ", " +
				"registrationStatus=" + this.registrationStatus + ", " +
				"registrationDate=" + this.registrationDate + ", " +
				"published=" + this.published + ", " +
				"leiValidation=" + this.leiValidation +
			'}';
		}
	}
}

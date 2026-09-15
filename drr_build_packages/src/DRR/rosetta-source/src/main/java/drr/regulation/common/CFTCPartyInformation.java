package drr.regulation.common;

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
import drr.regulation.common.meta.CFTCPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction to the CFTC.
 * @version 7.7.0
 */
@RosettaDataType(value="CFTCPartyInformation", builder=CFTCPartyInformation.CFTCPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CFTCPartyInformation", model="drr", builder=CFTCPartyInformation.CFTCPartyInformationBuilderImpl.class, version="7.7.0")
public interface CFTCPartyInformation extends RosettaModelObject {

	CFTCPartyInformationMeta metaData = new CFTCPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the nature of the type as registered with the CFTC.
	 */
	CFTCEntityClassificationEnum getOrganizationType();
	/**
	 * Indicator of whether counterparty is a federal entity, and which type.
	 */
	CFTCFederalEntityClassificationEnum getFederalEntity();
	/**
	 * Indicator of whether counterparty is a financial entity, and which type.
	 */
	CFTCFinancialEntityClassificationEnum getFinancialEntity();
	/**
	 * Indicator of whether the contract is classified as a physical commodity by referencing one of the contracts described in P43 Appendix B. The approach is consistent with 43.4(c)(4)(ii).
	 */
	Boolean getPhysicalCommodityContractIndicator();
	Boolean getIsUSPerson();
	/**
	 * Specifies whether the portfolio contains non reported transactions.
	 */
	Boolean getNonReportedTradePortfolio();

	/*********************** Build Methods  ***********************/
	CFTCPartyInformation build();
	
	CFTCPartyInformation.CFTCPartyInformationBuilder toBuilder();
	
	static CFTCPartyInformation.CFTCPartyInformationBuilder builder() {
		return new CFTCPartyInformation.CFTCPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CFTCPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CFTCPartyInformation> getType() {
		return CFTCPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("organizationType"), CFTCEntityClassificationEnum.class, getOrganizationType(), this);
		processor.processBasic(path.newSubPath("federalEntity"), CFTCFederalEntityClassificationEnum.class, getFederalEntity(), this);
		processor.processBasic(path.newSubPath("financialEntity"), CFTCFinancialEntityClassificationEnum.class, getFinancialEntity(), this);
		processor.processBasic(path.newSubPath("physicalCommodityContractIndicator"), Boolean.class, getPhysicalCommodityContractIndicator(), this);
		processor.processBasic(path.newSubPath("isUSPerson"), Boolean.class, getIsUSPerson(), this);
		processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CFTCPartyInformationBuilder extends CFTCPartyInformation, RosettaModelObjectBuilder {
		CFTCPartyInformation.CFTCPartyInformationBuilder setOrganizationType(CFTCEntityClassificationEnum organizationType);
		CFTCPartyInformation.CFTCPartyInformationBuilder setFederalEntity(CFTCFederalEntityClassificationEnum federalEntity);
		CFTCPartyInformation.CFTCPartyInformationBuilder setFinancialEntity(CFTCFinancialEntityClassificationEnum financialEntity);
		CFTCPartyInformation.CFTCPartyInformationBuilder setPhysicalCommodityContractIndicator(Boolean physicalCommodityContractIndicator);
		CFTCPartyInformation.CFTCPartyInformationBuilder setIsUSPerson(Boolean isUSPerson);
		CFTCPartyInformation.CFTCPartyInformationBuilder setNonReportedTradePortfolio(Boolean nonReportedTradePortfolio);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("organizationType"), CFTCEntityClassificationEnum.class, getOrganizationType(), this);
			processor.processBasic(path.newSubPath("federalEntity"), CFTCFederalEntityClassificationEnum.class, getFederalEntity(), this);
			processor.processBasic(path.newSubPath("financialEntity"), CFTCFinancialEntityClassificationEnum.class, getFinancialEntity(), this);
			processor.processBasic(path.newSubPath("physicalCommodityContractIndicator"), Boolean.class, getPhysicalCommodityContractIndicator(), this);
			processor.processBasic(path.newSubPath("isUSPerson"), Boolean.class, getIsUSPerson(), this);
			processor.processBasic(path.newSubPath("nonReportedTradePortfolio"), Boolean.class, getNonReportedTradePortfolio(), this);
		}
		

		CFTCPartyInformation.CFTCPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of CFTCPartyInformation  ***********************/
	class CFTCPartyInformationImpl implements CFTCPartyInformation {
		private final CFTCEntityClassificationEnum organizationType;
		private final CFTCFederalEntityClassificationEnum federalEntity;
		private final CFTCFinancialEntityClassificationEnum financialEntity;
		private final Boolean physicalCommodityContractIndicator;
		private final Boolean isUSPerson;
		private final Boolean nonReportedTradePortfolio;
		
		protected CFTCPartyInformationImpl(CFTCPartyInformation.CFTCPartyInformationBuilder builder) {
			this.organizationType = builder.getOrganizationType();
			this.federalEntity = builder.getFederalEntity();
			this.financialEntity = builder.getFinancialEntity();
			this.physicalCommodityContractIndicator = builder.getPhysicalCommodityContractIndicator();
			this.isUSPerson = builder.getIsUSPerson();
			this.nonReportedTradePortfolio = builder.getNonReportedTradePortfolio();
		}
		
		@Override
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("organizationType")
		public CFTCEntityClassificationEnum getOrganizationType() {
			return organizationType;
		}
		
		@Override
		@RosettaAttribute("federalEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("federalEntity")
		public CFTCFederalEntityClassificationEnum getFederalEntity() {
			return federalEntity;
		}
		
		@Override
		@RosettaAttribute("financialEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("financialEntity")
		public CFTCFinancialEntityClassificationEnum getFinancialEntity() {
			return financialEntity;
		}
		
		@Override
		@RosettaAttribute("physicalCommodityContractIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalCommodityContractIndicator")
		public Boolean getPhysicalCommodityContractIndicator() {
			return physicalCommodityContractIndicator;
		}
		
		@Override
		@RosettaAttribute("isUSPerson")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isUSPerson")
		public Boolean getIsUSPerson() {
			return isUSPerson;
		}
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@Override
		public CFTCPartyInformation build() {
			return this;
		}
		
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder toBuilder() {
			CFTCPartyInformation.CFTCPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CFTCPartyInformation.CFTCPartyInformationBuilder builder) {
			ofNullable(getOrganizationType()).ifPresent(builder::setOrganizationType);
			ofNullable(getFederalEntity()).ifPresent(builder::setFederalEntity);
			ofNullable(getFinancialEntity()).ifPresent(builder::setFinancialEntity);
			ofNullable(getPhysicalCommodityContractIndicator()).ifPresent(builder::setPhysicalCommodityContractIndicator);
			ofNullable(getIsUSPerson()).ifPresent(builder::setIsUSPerson);
			ofNullable(getNonReportedTradePortfolio()).ifPresent(builder::setNonReportedTradePortfolio);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CFTCPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(organizationType, _that.getOrganizationType())) return false;
			if (!Objects.equals(federalEntity, _that.getFederalEntity())) return false;
			if (!Objects.equals(financialEntity, _that.getFinancialEntity())) return false;
			if (!Objects.equals(physicalCommodityContractIndicator, _that.getPhysicalCommodityContractIndicator())) return false;
			if (!Objects.equals(isUSPerson, _that.getIsUSPerson())) return false;
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (organizationType != null ? organizationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (federalEntity != null ? federalEntity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (financialEntity != null ? financialEntity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (physicalCommodityContractIndicator != null ? physicalCommodityContractIndicator.hashCode() : 0);
			_result = 31 * _result + (isUSPerson != null ? isUSPerson.hashCode() : 0);
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCPartyInformation {" +
				"organizationType=" + this.organizationType + ", " +
				"federalEntity=" + this.federalEntity + ", " +
				"financialEntity=" + this.financialEntity + ", " +
				"physicalCommodityContractIndicator=" + this.physicalCommodityContractIndicator + ", " +
				"isUSPerson=" + this.isUSPerson + ", " +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio +
			'}';
		}
	}

	/*********************** Builder Implementation of CFTCPartyInformation  ***********************/
	class CFTCPartyInformationBuilderImpl implements CFTCPartyInformation.CFTCPartyInformationBuilder {
	
		protected CFTCEntityClassificationEnum organizationType;
		protected CFTCFederalEntityClassificationEnum federalEntity;
		protected CFTCFinancialEntityClassificationEnum financialEntity;
		protected Boolean physicalCommodityContractIndicator;
		protected Boolean isUSPerson;
		protected Boolean nonReportedTradePortfolio;
		
		@Override
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("organizationType")
		public CFTCEntityClassificationEnum getOrganizationType() {
			return organizationType;
		}
		
		@Override
		@RosettaAttribute("federalEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("federalEntity")
		public CFTCFederalEntityClassificationEnum getFederalEntity() {
			return federalEntity;
		}
		
		@Override
		@RosettaAttribute("financialEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("financialEntity")
		public CFTCFinancialEntityClassificationEnum getFinancialEntity() {
			return financialEntity;
		}
		
		@Override
		@RosettaAttribute("physicalCommodityContractIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalCommodityContractIndicator")
		public Boolean getPhysicalCommodityContractIndicator() {
			return physicalCommodityContractIndicator;
		}
		
		@Override
		@RosettaAttribute("isUSPerson")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isUSPerson")
		public Boolean getIsUSPerson() {
			return isUSPerson;
		}
		
		@Override
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		public Boolean getNonReportedTradePortfolio() {
			return nonReportedTradePortfolio;
		}
		
		@RosettaAttribute("organizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("organizationType")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder setOrganizationType(CFTCEntityClassificationEnum _organizationType) {
			this.organizationType = _organizationType == null ? null : _organizationType;
			return this;
		}
		
		@RosettaAttribute("federalEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("federalEntity")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder setFederalEntity(CFTCFederalEntityClassificationEnum _federalEntity) {
			this.federalEntity = _federalEntity == null ? null : _federalEntity;
			return this;
		}
		
		@RosettaAttribute("financialEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("financialEntity")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder setFinancialEntity(CFTCFinancialEntityClassificationEnum _financialEntity) {
			this.financialEntity = _financialEntity == null ? null : _financialEntity;
			return this;
		}
		
		@RosettaAttribute("physicalCommodityContractIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalCommodityContractIndicator")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder setPhysicalCommodityContractIndicator(Boolean _physicalCommodityContractIndicator) {
			this.physicalCommodityContractIndicator = _physicalCommodityContractIndicator == null ? null : _physicalCommodityContractIndicator;
			return this;
		}
		
		@RosettaAttribute("isUSPerson")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isUSPerson")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder setIsUSPerson(Boolean _isUSPerson) {
			this.isUSPerson = _isUSPerson == null ? null : _isUSPerson;
			return this;
		}
		
		@RosettaAttribute("nonReportedTradePortfolio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonReportedTradePortfolio")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder setNonReportedTradePortfolio(Boolean _nonReportedTradePortfolio) {
			this.nonReportedTradePortfolio = _nonReportedTradePortfolio == null ? null : _nonReportedTradePortfolio;
			return this;
		}
		
		@Override
		public CFTCPartyInformation build() {
			return new CFTCPartyInformation.CFTCPartyInformationImpl(this);
		}
		
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOrganizationType()!=null) return true;
			if (getFederalEntity()!=null) return true;
			if (getFinancialEntity()!=null) return true;
			if (getPhysicalCommodityContractIndicator()!=null) return true;
			if (getIsUSPerson()!=null) return true;
			if (getNonReportedTradePortfolio()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCPartyInformation.CFTCPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CFTCPartyInformation.CFTCPartyInformationBuilder o = (CFTCPartyInformation.CFTCPartyInformationBuilder) other;
			
			
			merger.mergeBasic(getOrganizationType(), o.getOrganizationType(), this::setOrganizationType);
			merger.mergeBasic(getFederalEntity(), o.getFederalEntity(), this::setFederalEntity);
			merger.mergeBasic(getFinancialEntity(), o.getFinancialEntity(), this::setFinancialEntity);
			merger.mergeBasic(getPhysicalCommodityContractIndicator(), o.getPhysicalCommodityContractIndicator(), this::setPhysicalCommodityContractIndicator);
			merger.mergeBasic(getIsUSPerson(), o.getIsUSPerson(), this::setIsUSPerson);
			merger.mergeBasic(getNonReportedTradePortfolio(), o.getNonReportedTradePortfolio(), this::setNonReportedTradePortfolio);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CFTCPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(organizationType, _that.getOrganizationType())) return false;
			if (!Objects.equals(federalEntity, _that.getFederalEntity())) return false;
			if (!Objects.equals(financialEntity, _that.getFinancialEntity())) return false;
			if (!Objects.equals(physicalCommodityContractIndicator, _that.getPhysicalCommodityContractIndicator())) return false;
			if (!Objects.equals(isUSPerson, _that.getIsUSPerson())) return false;
			if (!Objects.equals(nonReportedTradePortfolio, _that.getNonReportedTradePortfolio())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (organizationType != null ? organizationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (federalEntity != null ? federalEntity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (financialEntity != null ? financialEntity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (physicalCommodityContractIndicator != null ? physicalCommodityContractIndicator.hashCode() : 0);
			_result = 31 * _result + (isUSPerson != null ? isUSPerson.hashCode() : 0);
			_result = 31 * _result + (nonReportedTradePortfolio != null ? nonReportedTradePortfolio.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCPartyInformationBuilder {" +
				"organizationType=" + this.organizationType + ", " +
				"federalEntity=" + this.federalEntity + ", " +
				"financialEntity=" + this.financialEntity + ", " +
				"physicalCommodityContractIndicator=" + this.physicalCommodityContractIndicator + ", " +
				"isUSPerson=" + this.isUSPerson + ", " +
				"nonReportedTradePortfolio=" + this.nonReportedTradePortfolio +
			'}';
		}
	}
}

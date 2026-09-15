package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ProductSummaryMeta;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Summary information about the product that was traded. This is intended primarily for trade reporting by TRs.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Summary information about the product that was traded. This is intended primarily for trade reporting by TRs.
 *
 */
@RosettaDataType(value="ProductSummary", builder=ProductSummary.ProductSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ProductSummary", model="fpml", builder=ProductSummary.ProductSummaryBuilderImpl.class, version="2.1.1")
public interface ProductSummary extends RosettaModelObject {

	ProductSummaryMeta metaData = new ProductSummaryMeta();

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
	ZonedDateTime getFinalSettlementDate();
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
	SettlementTypeEnum getSettlementType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Added to support CFTC Amendments to Part 43/45 (Published November 2020)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Added to support CFTC Amendments to Part 43/45 (Published November 2020)
	 *
	 */
	BusinessCenter getSettlementLocation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Use instead the field within credit products: indexReferenceInformation/seniority (RPTWG decision 2017-09)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. Use instead the field within credit products: indexReferenceInformation/seniority (RPTWG decision 2017-09)
	 *
	 */
	CreditSeniority getSeniority();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Use instead the field within credit products: indexReferenceInformation/indexFactor (RPTWG decision 2017-09)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. Use instead the field within credit products: indexReferenceInformation/indexFactor (RPTWG decision 2017-09)
	 *
	 */
	BigDecimal getIndexFactor();
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
	AdmissionToTrading getAdmissionToTrading();

	/*********************** Build Methods  ***********************/
	ProductSummary build();
	
	ProductSummary.ProductSummaryBuilder toBuilder();
	
	static ProductSummary.ProductSummaryBuilder builder() {
		return new ProductSummary.ProductSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProductSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProductSummary> getType() {
		return ProductSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("finalSettlementDate"), ZonedDateTime.class, getFinalSettlementDate(), this);
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementLocation"), processor, BusinessCenter.class, getSettlementLocation());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processRosetta(path.newSubPath("admissionToTrading"), processor, AdmissionToTrading.class, getAdmissionToTrading());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProductSummaryBuilder extends ProductSummary, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateSettlementLocation();
		@Override
		BusinessCenter.BusinessCenterBuilder getSettlementLocation();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		AdmissionToTrading.AdmissionToTradingBuilder getOrCreateAdmissionToTrading();
		@Override
		AdmissionToTrading.AdmissionToTradingBuilder getAdmissionToTrading();
		ProductSummary.ProductSummaryBuilder setFinalSettlementDate(ZonedDateTime finalSettlementDate);
		ProductSummary.ProductSummaryBuilder setSettlementType(SettlementTypeEnum settlementType);
		ProductSummary.ProductSummaryBuilder setSettlementLocation(BusinessCenter settlementLocation);
		ProductSummary.ProductSummaryBuilder setSeniority(CreditSeniority seniority);
		ProductSummary.ProductSummaryBuilder setIndexFactor(BigDecimal indexFactor);
		ProductSummary.ProductSummaryBuilder setAdmissionToTrading(AdmissionToTrading admissionToTrading);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("finalSettlementDate"), ZonedDateTime.class, getFinalSettlementDate(), this);
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementLocation"), processor, BusinessCenter.BusinessCenterBuilder.class, getSettlementLocation());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processRosetta(path.newSubPath("admissionToTrading"), processor, AdmissionToTrading.AdmissionToTradingBuilder.class, getAdmissionToTrading());
		}
		

		ProductSummary.ProductSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of ProductSummary  ***********************/
	class ProductSummaryImpl implements ProductSummary {
		private final ZonedDateTime finalSettlementDate;
		private final SettlementTypeEnum settlementType;
		private final BusinessCenter settlementLocation;
		private final CreditSeniority seniority;
		private final BigDecimal indexFactor;
		private final AdmissionToTrading admissionToTrading;
		
		protected ProductSummaryImpl(ProductSummary.ProductSummaryBuilder builder) {
			this.finalSettlementDate = builder.getFinalSettlementDate();
			this.settlementType = builder.getSettlementType();
			this.settlementLocation = ofNullable(builder.getSettlementLocation()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.indexFactor = builder.getIndexFactor();
			this.admissionToTrading = ofNullable(builder.getAdmissionToTrading()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalSettlementDate")
		public ZonedDateTime getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public BusinessCenter getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("admissionToTrading")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("admissionToTrading")
		public AdmissionToTrading getAdmissionToTrading() {
			return admissionToTrading;
		}
		
		@Override
		public ProductSummary build() {
			return this;
		}
		
		@Override
		public ProductSummary.ProductSummaryBuilder toBuilder() {
			ProductSummary.ProductSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProductSummary.ProductSummaryBuilder builder) {
			ofNullable(getFinalSettlementDate()).ifPresent(builder::setFinalSettlementDate);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementLocation()).ifPresent(builder::setSettlementLocation);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getAdmissionToTrading()).ifPresent(builder::setAdmissionToTrading);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductSummary _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(admissionToTrading, _that.getAdmissionToTrading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (admissionToTrading != null ? admissionToTrading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductSummary {" +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"admissionToTrading=" + this.admissionToTrading +
			'}';
		}
	}

	/*********************** Builder Implementation of ProductSummary  ***********************/
	class ProductSummaryBuilderImpl implements ProductSummary.ProductSummaryBuilder {
	
		protected ZonedDateTime finalSettlementDate;
		protected SettlementTypeEnum settlementType;
		protected BusinessCenter.BusinessCenterBuilder settlementLocation;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected BigDecimal indexFactor;
		protected AdmissionToTrading.AdmissionToTradingBuilder admissionToTrading;
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalSettlementDate")
		public ZonedDateTime getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public BusinessCenter.BusinessCenterBuilder getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateSettlementLocation() {
			BusinessCenter.BusinessCenterBuilder result;
			if (settlementLocation!=null) {
				result = settlementLocation;
			}
			else {
				result = settlementLocation = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("admissionToTrading")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("admissionToTrading")
		public AdmissionToTrading.AdmissionToTradingBuilder getAdmissionToTrading() {
			return admissionToTrading;
		}
		
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder getOrCreateAdmissionToTrading() {
			AdmissionToTrading.AdmissionToTradingBuilder result;
			if (admissionToTrading!=null) {
				result = admissionToTrading;
			}
			else {
				result = admissionToTrading = AdmissionToTrading.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalSettlementDate")
		@Override
		public ProductSummary.ProductSummaryBuilder setFinalSettlementDate(ZonedDateTime _finalSettlementDate) {
			this.finalSettlementDate = _finalSettlementDate == null ? null : _finalSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public ProductSummary.ProductSummaryBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public ProductSummary.ProductSummaryBuilder setSettlementLocation(BusinessCenter _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public ProductSummary.ProductSummaryBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public ProductSummary.ProductSummaryBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("admissionToTrading")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("admissionToTrading")
		@Override
		public ProductSummary.ProductSummaryBuilder setAdmissionToTrading(AdmissionToTrading _admissionToTrading) {
			this.admissionToTrading = _admissionToTrading == null ? null : _admissionToTrading.toBuilder();
			return this;
		}
		
		@Override
		public ProductSummary build() {
			return new ProductSummary.ProductSummaryImpl(this);
		}
		
		@Override
		public ProductSummary.ProductSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductSummary.ProductSummaryBuilder prune() {
			if (settlementLocation!=null && !settlementLocation.prune().hasData()) settlementLocation = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			if (admissionToTrading!=null && !admissionToTrading.prune().hasData()) admissionToTrading = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFinalSettlementDate()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getSettlementLocation()!=null && getSettlementLocation().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getAdmissionToTrading()!=null && getAdmissionToTrading().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProductSummary.ProductSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProductSummary.ProductSummaryBuilder o = (ProductSummary.ProductSummaryBuilder) other;
			
			merger.mergeRosetta(getSettlementLocation(), o.getSettlementLocation(), this::setSettlementLocation);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getAdmissionToTrading(), o.getAdmissionToTrading(), this::setAdmissionToTrading);
			
			merger.mergeBasic(getFinalSettlementDate(), o.getFinalSettlementDate(), this::setFinalSettlementDate);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProductSummary _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(admissionToTrading, _that.getAdmissionToTrading())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (admissionToTrading != null ? admissionToTrading.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProductSummaryBuilder {" +
				"finalSettlementDate=" + this.finalSettlementDate + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"admissionToTrading=" + this.admissionToTrading +
			'}';
		}
	}
}

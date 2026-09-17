package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingProductCreditDetailsMeta;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Credit related fields. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingProductCreditDetails", builder=RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingProductCreditDetails", model="fpml", builder=RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingProductCreditDetails extends RosettaModelObject {

	RegulatoryReportingProductCreditDetailsMeta metaData = new RegulatoryReportingProductCreditDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Lower bound percentage of the loss that the Tranche can endure, expressed as a decimal. An attachment point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche. A schema facet to constraint the value between 0 to 1 will be introduced in FpML 4.3. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	BigDecimal getAttachmentPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Upper bound percentage of the loss that the Tranche can endure, expressed as a decimal. An exhaustion point of 5% would be represented as 0.05. The difference between Attachment and Exhaustion points is call the width of the Tranche. A schema facet to constraint the value between 0 to 1 will be introduced in FpML 4.3. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	BigDecimal getExhaustionPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	BigDecimal getIndexFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index series identifier, e.g. 1, 2, 3 etc. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	Integer getIndexSeries();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A CDS index series version identifier, e.g. 1, 2, 3 etc. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	Integer getIndexAnnexVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	BigDecimal getFixedRecoveryFinalPrice();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingProductCreditDetails build();
	
	RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder toBuilder();
	
	static RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder builder() {
		return new RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingProductCreditDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingProductCreditDetails> getType() {
		return RegulatoryReportingProductCreditDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("attachmentPoint"), BigDecimal.class, getAttachmentPoint(), this);
		processor.processBasic(path.newSubPath("exhaustionPoint"), BigDecimal.class, getExhaustionPoint(), this);
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
		processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
		processor.processBasic(path.newSubPath("fixedRecoveryFinalPrice"), BigDecimal.class, getFixedRecoveryFinalPrice(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingProductCreditDetailsBuilder extends RegulatoryReportingProductCreditDetails, RosettaModelObjectBuilder {
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setAttachmentPoint(BigDecimal attachmentPoint);
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setExhaustionPoint(BigDecimal exhaustionPoint);
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setSeniority(CreditSeniority seniority);
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setIndexFactor(BigDecimal indexFactor);
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setIndexSeries(Integer indexSeries);
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setIndexAnnexVersion(Integer indexAnnexVersion);
		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setFixedRecoveryFinalPrice(BigDecimal fixedRecoveryFinalPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("attachmentPoint"), BigDecimal.class, getAttachmentPoint(), this);
			processor.processBasic(path.newSubPath("exhaustionPoint"), BigDecimal.class, getExhaustionPoint(), this);
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processor.processBasic(path.newSubPath("indexSeries"), Integer.class, getIndexSeries(), this);
			processor.processBasic(path.newSubPath("indexAnnexVersion"), Integer.class, getIndexAnnexVersion(), this);
			processor.processBasic(path.newSubPath("fixedRecoveryFinalPrice"), BigDecimal.class, getFixedRecoveryFinalPrice(), this);
		}
		

		RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingProductCreditDetails  ***********************/
	class RegulatoryReportingProductCreditDetailsImpl implements RegulatoryReportingProductCreditDetails {
		private final BigDecimal attachmentPoint;
		private final BigDecimal exhaustionPoint;
		private final CreditSeniority seniority;
		private final BigDecimal indexFactor;
		private final Integer indexSeries;
		private final Integer indexAnnexVersion;
		private final BigDecimal fixedRecoveryFinalPrice;
		
		protected RegulatoryReportingProductCreditDetailsImpl(RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder builder) {
			this.attachmentPoint = builder.getAttachmentPoint();
			this.exhaustionPoint = builder.getExhaustionPoint();
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.indexFactor = builder.getIndexFactor();
			this.indexSeries = builder.getIndexSeries();
			this.indexAnnexVersion = builder.getIndexAnnexVersion();
			this.fixedRecoveryFinalPrice = builder.getFixedRecoveryFinalPrice();
		}
		
		@Override
		@RosettaAttribute("attachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("attachmentPoint")
		public BigDecimal getAttachmentPoint() {
			return attachmentPoint;
		}
		
		@Override
		@RosettaAttribute("exhaustionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exhaustionPoint")
		public BigDecimal getExhaustionPoint() {
			return exhaustionPoint;
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
		@RosettaAttribute("indexSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("fixedRecoveryFinalPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRecoveryFinalPrice")
		public BigDecimal getFixedRecoveryFinalPrice() {
			return fixedRecoveryFinalPrice;
		}
		
		@Override
		public RegulatoryReportingProductCreditDetails build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder toBuilder() {
			RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder builder) {
			ofNullable(getAttachmentPoint()).ifPresent(builder::setAttachmentPoint);
			ofNullable(getExhaustionPoint()).ifPresent(builder::setExhaustionPoint);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getIndexSeries()).ifPresent(builder::setIndexSeries);
			ofNullable(getIndexAnnexVersion()).ifPresent(builder::setIndexAnnexVersion);
			ofNullable(getFixedRecoveryFinalPrice()).ifPresent(builder::setFixedRecoveryFinalPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductCreditDetails _that = getType().cast(o);
		
			if (!Objects.equals(attachmentPoint, _that.getAttachmentPoint())) return false;
			if (!Objects.equals(exhaustionPoint, _that.getExhaustionPoint())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(fixedRecoveryFinalPrice, _that.getFixedRecoveryFinalPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attachmentPoint != null ? attachmentPoint.hashCode() : 0);
			_result = 31 * _result + (exhaustionPoint != null ? exhaustionPoint.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (fixedRecoveryFinalPrice != null ? fixedRecoveryFinalPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductCreditDetails {" +
				"attachmentPoint=" + this.attachmentPoint + ", " +
				"exhaustionPoint=" + this.exhaustionPoint + ", " +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"fixedRecoveryFinalPrice=" + this.fixedRecoveryFinalPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingProductCreditDetails  ***********************/
	class RegulatoryReportingProductCreditDetailsBuilderImpl implements RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder {
	
		protected BigDecimal attachmentPoint;
		protected BigDecimal exhaustionPoint;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected BigDecimal indexFactor;
		protected Integer indexSeries;
		protected Integer indexAnnexVersion;
		protected BigDecimal fixedRecoveryFinalPrice;
		
		@Override
		@RosettaAttribute("attachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("attachmentPoint")
		public BigDecimal getAttachmentPoint() {
			return attachmentPoint;
		}
		
		@Override
		@RosettaAttribute("exhaustionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exhaustionPoint")
		public BigDecimal getExhaustionPoint() {
			return exhaustionPoint;
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
		@RosettaAttribute("indexSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexSeries")
		public Integer getIndexSeries() {
			return indexSeries;
		}
		
		@Override
		@RosettaAttribute("indexAnnexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexAnnexVersion")
		public Integer getIndexAnnexVersion() {
			return indexAnnexVersion;
		}
		
		@Override
		@RosettaAttribute("fixedRecoveryFinalPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRecoveryFinalPrice")
		public BigDecimal getFixedRecoveryFinalPrice() {
			return fixedRecoveryFinalPrice;
		}
		
		@RosettaAttribute("attachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("attachmentPoint")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setAttachmentPoint(BigDecimal _attachmentPoint) {
			this.attachmentPoint = _attachmentPoint == null ? null : _attachmentPoint;
			return this;
		}
		
		@RosettaAttribute("exhaustionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exhaustionPoint")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setExhaustionPoint(BigDecimal _exhaustionPoint) {
			this.exhaustionPoint = _exhaustionPoint == null ? null : _exhaustionPoint;
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("indexSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexSeries")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setIndexSeries(Integer _indexSeries) {
			this.indexSeries = _indexSeries == null ? null : _indexSeries;
			return this;
		}
		
		@RosettaAttribute("indexAnnexVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexAnnexVersion")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setIndexAnnexVersion(Integer _indexAnnexVersion) {
			this.indexAnnexVersion = _indexAnnexVersion == null ? null : _indexAnnexVersion;
			return this;
		}
		
		@RosettaAttribute("fixedRecoveryFinalPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRecoveryFinalPrice")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder setFixedRecoveryFinalPrice(BigDecimal _fixedRecoveryFinalPrice) {
			this.fixedRecoveryFinalPrice = _fixedRecoveryFinalPrice == null ? null : _fixedRecoveryFinalPrice;
			return this;
		}
		
		@Override
		public RegulatoryReportingProductCreditDetails build() {
			return new RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsImpl(this);
		}
		
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder prune() {
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAttachmentPoint()!=null) return true;
			if (getExhaustionPoint()!=null) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getIndexSeries()!=null) return true;
			if (getIndexAnnexVersion()!=null) return true;
			if (getFixedRecoveryFinalPrice()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder o = (RegulatoryReportingProductCreditDetails.RegulatoryReportingProductCreditDetailsBuilder) other;
			
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getAttachmentPoint(), o.getAttachmentPoint(), this::setAttachmentPoint);
			merger.mergeBasic(getExhaustionPoint(), o.getExhaustionPoint(), this::setExhaustionPoint);
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			merger.mergeBasic(getIndexSeries(), o.getIndexSeries(), this::setIndexSeries);
			merger.mergeBasic(getIndexAnnexVersion(), o.getIndexAnnexVersion(), this::setIndexAnnexVersion);
			merger.mergeBasic(getFixedRecoveryFinalPrice(), o.getFixedRecoveryFinalPrice(), this::setFixedRecoveryFinalPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingProductCreditDetails _that = getType().cast(o);
		
			if (!Objects.equals(attachmentPoint, _that.getAttachmentPoint())) return false;
			if (!Objects.equals(exhaustionPoint, _that.getExhaustionPoint())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(indexSeries, _that.getIndexSeries())) return false;
			if (!Objects.equals(indexAnnexVersion, _that.getIndexAnnexVersion())) return false;
			if (!Objects.equals(fixedRecoveryFinalPrice, _that.getFixedRecoveryFinalPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attachmentPoint != null ? attachmentPoint.hashCode() : 0);
			_result = 31 * _result + (exhaustionPoint != null ? exhaustionPoint.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (indexSeries != null ? indexSeries.hashCode() : 0);
			_result = 31 * _result + (indexAnnexVersion != null ? indexAnnexVersion.hashCode() : 0);
			_result = 31 * _result + (fixedRecoveryFinalPrice != null ? fixedRecoveryFinalPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingProductCreditDetailsBuilder {" +
				"attachmentPoint=" + this.attachmentPoint + ", " +
				"exhaustionPoint=" + this.exhaustionPoint + ", " +
				"seniority=" + this.seniority + ", " +
				"indexFactor=" + this.indexFactor + ", " +
				"indexSeries=" + this.indexSeries + ", " +
				"indexAnnexVersion=" + this.indexAnnexVersion + ", " +
				"fixedRecoveryFinalPrice=" + this.fixedRecoveryFinalPrice +
			'}';
		}
	}
}

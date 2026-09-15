package fpml.consolidated.reg.fpmlreporting.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.reg.fpmlreporting.shared.meta.RegulatoryReportingCollateralizationMeta;
import fpml.consolidated.shared.CollateralizationType;
import fpml.consolidated.shared.CollateralizedExposureGrouping;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining collateral information to be reported.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining collateral information to be reported.
 *
 */
@RosettaDataType(value="RegulatoryReportingCollateralization", builder=RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingCollateralization", model="fpml", builder=RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingCollateralization extends RosettaModelObject {

	RegulatoryReportingCollateralizationMeta metaData = new RegulatoryReportingCollateralizationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A party that can post the collateral.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party that can post the collateral.
	 *
	 */
	PartyReference getPostingPartyReference();
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
	PartyReference getBeneficiaryPartyReference();
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
	PartyReference getHoldingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the trade collateralized exposure is calculated at the individual (single) trade aggregation level or the net (multiple trades) aggregation level. SFTR description of the field: Collateralization of net exposure - Indicates whether the collateral has been provided for a net exposure, rather than for a single transaction ('true' or 'false').
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the trade collateralized exposure is calculated at the individual (single) trade aggregation level or the net (multiple trades) aggregation level. SFTR description of the field: Collateralization of net exposure - Indicates whether the collateral has been provided for a net exposure, rather than for a single transaction ('true' or 'false').
	 *
	 */
	CollateralizedExposureGrouping getCollateralizedExposureGrouping();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies how the transaction is collateralized by this party, fully or partially, or uncollateralized. For Transparency view, the options include Full, Partial, Uncollateralized, and One-Way. For Recordkeeping, the collateralization type refers to collateral that is posted by this firm, and One-Way option is not meaningful. In other words, if the collateralization type is Full, this trade is fully collateralized by this party. SFTR description of the field: Uncollateralised SL flag - Indicates whether the securities lending transaction is uncollateralised ('true' or 'false'). Uncollateralised SL will be 'true', if collateralizationType = 'Uncollateralized'.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies how the transaction is collateralized by this party, fully or partially, or uncollateralized. For Transparency view, the options include Full, Partial, Uncollateralized, and One-Way. For Recordkeeping, the collateralization type refers to collateral that is posted by this firm, and One-Way option is not meaningful. In other words, if the collateralization type is Full, this trade is fully collateralized by this party. SFTR description of the field: Uncollateralised SL flag - Indicates whether the securities lending transaction is uncollateralised ('true' or 'false'). Uncollateralised SL will be 'true', if collateralizationType = 'Uncollateralized'.
	 *
	 */
	CollateralizationType getCollateralizationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides code, or other identifier for the collateral portfolio to which this belongs. The collateral portfolio describes how trades are aggregated for collateral calculation purposes. All trades that are aggregated together for collateral calculation purposes will share the same collateral portfolio code. This code may come from different sources depending on the level of aggregation defined in the CSA (e.g. it may be the LEI of a counterparty or a desk identifier). SFTR description of this field: Portfolio code - If the transaction is cleared and is included in a portfolio of transactions for which margins are exchanged, this portfolio should be identified by a unique code determined by the reporting counterparty. 52 alphanumeric character code including four special characters: .- _. Special characters are not allowed at the beginning and at the end of the code. No space allowed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides code, or other identifier for the collateral portfolio to which this belongs. The collateral portfolio describes how trades are aggregated for collateral calculation purposes. All trades that are aggregated together for collateral calculation purposes will share the same collateral portfolio code. This code may come from different sources depending on the level of aggregation defined in the CSA (e.g. it may be the LEI of a counterparty or a desk identifier). SFTR description of this field: Portfolio code - If the transaction is cleared and is included in a portfolio of transactions for which margins are exchanged, this portfolio should be identified by a unique code determined by the reporting counterparty. 52 alphanumeric character code including four special characters: .- _. Special characters are not allowed at the beginning and at the end of the code. No space allowed.
	 *
	 */
	CollateralPortfolioId getPortfolioId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Information about the amount of collateral actually posted by the posting party as of a particular value date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information about the amount of collateral actually posted by the posting party as of a particular value date.
	 *
	 */
	CollateralPortfolio getPostedCollateral();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingCollateralization build();
	
	RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder toBuilder();
	
	static RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder builder() {
		return new RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingCollateralization> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingCollateralization> getType() {
		return RegulatoryReportingCollateralization.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("postingPartyReference"), processor, PartyReference.class, getPostingPartyReference());
		processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.class, getBeneficiaryPartyReference());
		processRosetta(path.newSubPath("holdingPartyReference"), processor, PartyReference.class, getHoldingPartyReference());
		processRosetta(path.newSubPath("collateralizedExposureGrouping"), processor, CollateralizedExposureGrouping.class, getCollateralizedExposureGrouping());
		processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.class, getCollateralizationType());
		processRosetta(path.newSubPath("portfolioId"), processor, CollateralPortfolioId.class, getPortfolioId());
		processRosetta(path.newSubPath("postedCollateral"), processor, CollateralPortfolio.class, getPostedCollateral());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingCollateralizationBuilder extends RegulatoryReportingCollateralization, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePostingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPostingPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateHoldingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getHoldingPartyReference();
		CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder getOrCreateCollateralizedExposureGrouping();
		@Override
		CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder getCollateralizedExposureGrouping();
		CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType();
		@Override
		CollateralizationType.CollateralizationTypeBuilder getCollateralizationType();
		CollateralPortfolioId.CollateralPortfolioIdBuilder getOrCreatePortfolioId();
		@Override
		CollateralPortfolioId.CollateralPortfolioIdBuilder getPortfolioId();
		CollateralPortfolio.CollateralPortfolioBuilder getOrCreatePostedCollateral();
		@Override
		CollateralPortfolio.CollateralPortfolioBuilder getPostedCollateral();
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setPostingPartyReference(PartyReference postingPartyReference);
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference);
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setHoldingPartyReference(PartyReference holdingPartyReference);
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setCollateralizedExposureGrouping(CollateralizedExposureGrouping collateralizedExposureGrouping);
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setCollateralizationType(CollateralizationType collateralizationType);
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setPortfolioId(CollateralPortfolioId portfolioId);
		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setPostedCollateral(CollateralPortfolio postedCollateral);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("postingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPostingPartyReference());
			processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBeneficiaryPartyReference());
			processRosetta(path.newSubPath("holdingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getHoldingPartyReference());
			processRosetta(path.newSubPath("collateralizedExposureGrouping"), processor, CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder.class, getCollateralizedExposureGrouping());
			processRosetta(path.newSubPath("collateralizationType"), processor, CollateralizationType.CollateralizationTypeBuilder.class, getCollateralizationType());
			processRosetta(path.newSubPath("portfolioId"), processor, CollateralPortfolioId.CollateralPortfolioIdBuilder.class, getPortfolioId());
			processRosetta(path.newSubPath("postedCollateral"), processor, CollateralPortfolio.CollateralPortfolioBuilder.class, getPostedCollateral());
		}
		

		RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingCollateralization  ***********************/
	class RegulatoryReportingCollateralizationImpl implements RegulatoryReportingCollateralization {
		private final PartyReference postingPartyReference;
		private final PartyReference beneficiaryPartyReference;
		private final PartyReference holdingPartyReference;
		private final CollateralizedExposureGrouping collateralizedExposureGrouping;
		private final CollateralizationType collateralizationType;
		private final CollateralPortfolioId portfolioId;
		private final CollateralPortfolio postedCollateral;
		
		protected RegulatoryReportingCollateralizationImpl(RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder builder) {
			this.postingPartyReference = ofNullable(builder.getPostingPartyReference()).map(f->f.build()).orElse(null);
			this.beneficiaryPartyReference = ofNullable(builder.getBeneficiaryPartyReference()).map(f->f.build()).orElse(null);
			this.holdingPartyReference = ofNullable(builder.getHoldingPartyReference()).map(f->f.build()).orElse(null);
			this.collateralizedExposureGrouping = ofNullable(builder.getCollateralizedExposureGrouping()).map(f->f.build()).orElse(null);
			this.collateralizationType = ofNullable(builder.getCollateralizationType()).map(f->f.build()).orElse(null);
			this.portfolioId = ofNullable(builder.getPortfolioId()).map(f->f.build()).orElse(null);
			this.postedCollateral = ofNullable(builder.getPostedCollateral()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("postingPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postingPartyReference")
		public PartyReference getPostingPartyReference() {
			return postingPartyReference;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiaryPartyReference")
		public PartyReference getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		@RosettaAttribute("holdingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("holdingPartyReference")
		public PartyReference getHoldingPartyReference() {
			return holdingPartyReference;
		}
		
		@Override
		@RosettaAttribute("collateralizedExposureGrouping")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizedExposureGrouping")
		public CollateralizedExposureGrouping getCollateralizedExposureGrouping() {
			return collateralizedExposureGrouping;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		@RosettaAttribute("portfolioId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioId")
		public CollateralPortfolioId getPortfolioId() {
			return portfolioId;
		}
		
		@Override
		@RosettaAttribute("postedCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postedCollateral")
		public CollateralPortfolio getPostedCollateral() {
			return postedCollateral;
		}
		
		@Override
		public RegulatoryReportingCollateralization build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder toBuilder() {
			RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder builder) {
			ofNullable(getPostingPartyReference()).ifPresent(builder::setPostingPartyReference);
			ofNullable(getBeneficiaryPartyReference()).ifPresent(builder::setBeneficiaryPartyReference);
			ofNullable(getHoldingPartyReference()).ifPresent(builder::setHoldingPartyReference);
			ofNullable(getCollateralizedExposureGrouping()).ifPresent(builder::setCollateralizedExposureGrouping);
			ofNullable(getCollateralizationType()).ifPresent(builder::setCollateralizationType);
			ofNullable(getPortfolioId()).ifPresent(builder::setPortfolioId);
			ofNullable(getPostedCollateral()).ifPresent(builder::setPostedCollateral);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingCollateralization _that = getType().cast(o);
		
			if (!Objects.equals(postingPartyReference, _that.getPostingPartyReference())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			if (!Objects.equals(holdingPartyReference, _that.getHoldingPartyReference())) return false;
			if (!Objects.equals(collateralizedExposureGrouping, _that.getCollateralizedExposureGrouping())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(portfolioId, _that.getPortfolioId())) return false;
			if (!Objects.equals(postedCollateral, _that.getPostedCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (postingPartyReference != null ? postingPartyReference.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			_result = 31 * _result + (holdingPartyReference != null ? holdingPartyReference.hashCode() : 0);
			_result = 31 * _result + (collateralizedExposureGrouping != null ? collateralizedExposureGrouping.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (portfolioId != null ? portfolioId.hashCode() : 0);
			_result = 31 * _result + (postedCollateral != null ? postedCollateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingCollateralization {" +
				"postingPartyReference=" + this.postingPartyReference + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference + ", " +
				"holdingPartyReference=" + this.holdingPartyReference + ", " +
				"collateralizedExposureGrouping=" + this.collateralizedExposureGrouping + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"portfolioId=" + this.portfolioId + ", " +
				"postedCollateral=" + this.postedCollateral +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingCollateralization  ***********************/
	class RegulatoryReportingCollateralizationBuilderImpl implements RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder {
	
		protected PartyReference.PartyReferenceBuilder postingPartyReference;
		protected PartyReference.PartyReferenceBuilder beneficiaryPartyReference;
		protected PartyReference.PartyReferenceBuilder holdingPartyReference;
		protected CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder collateralizedExposureGrouping;
		protected CollateralizationType.CollateralizationTypeBuilder collateralizationType;
		protected CollateralPortfolioId.CollateralPortfolioIdBuilder portfolioId;
		protected CollateralPortfolio.CollateralPortfolioBuilder postedCollateral;
		
		@Override
		@RosettaAttribute("postingPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postingPartyReference")
		public PartyReference.PartyReferenceBuilder getPostingPartyReference() {
			return postingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePostingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (postingPartyReference!=null) {
				result = postingPartyReference;
			}
			else {
				result = postingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiaryPartyReference")
		public PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (beneficiaryPartyReference!=null) {
				result = beneficiaryPartyReference;
			}
			else {
				result = beneficiaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("holdingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("holdingPartyReference")
		public PartyReference.PartyReferenceBuilder getHoldingPartyReference() {
			return holdingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateHoldingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (holdingPartyReference!=null) {
				result = holdingPartyReference;
			}
			else {
				result = holdingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizedExposureGrouping")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizedExposureGrouping")
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder getCollateralizedExposureGrouping() {
			return collateralizedExposureGrouping;
		}
		
		@Override
		public CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder getOrCreateCollateralizedExposureGrouping() {
			CollateralizedExposureGrouping.CollateralizedExposureGroupingBuilder result;
			if (collateralizedExposureGrouping!=null) {
				result = collateralizedExposureGrouping;
			}
			else {
				result = collateralizedExposureGrouping = CollateralizedExposureGrouping.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizationType")
		public CollateralizationType.CollateralizationTypeBuilder getCollateralizationType() {
			return collateralizationType;
		}
		
		@Override
		public CollateralizationType.CollateralizationTypeBuilder getOrCreateCollateralizationType() {
			CollateralizationType.CollateralizationTypeBuilder result;
			if (collateralizationType!=null) {
				result = collateralizationType;
			}
			else {
				result = collateralizationType = CollateralizationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioId")
		public CollateralPortfolioId.CollateralPortfolioIdBuilder getPortfolioId() {
			return portfolioId;
		}
		
		@Override
		public CollateralPortfolioId.CollateralPortfolioIdBuilder getOrCreatePortfolioId() {
			CollateralPortfolioId.CollateralPortfolioIdBuilder result;
			if (portfolioId!=null) {
				result = portfolioId;
			}
			else {
				result = portfolioId = CollateralPortfolioId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postedCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postedCollateral")
		public CollateralPortfolio.CollateralPortfolioBuilder getPostedCollateral() {
			return postedCollateral;
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder getOrCreatePostedCollateral() {
			CollateralPortfolio.CollateralPortfolioBuilder result;
			if (postedCollateral!=null) {
				result = postedCollateral;
			}
			else {
				result = postedCollateral = CollateralPortfolio.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("postingPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("postingPartyReference")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setPostingPartyReference(PartyReference _postingPartyReference) {
			this.postingPartyReference = _postingPartyReference == null ? null : _postingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiaryPartyReference")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setBeneficiaryPartyReference(PartyReference _beneficiaryPartyReference) {
			this.beneficiaryPartyReference = _beneficiaryPartyReference == null ? null : _beneficiaryPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("holdingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("holdingPartyReference")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setHoldingPartyReference(PartyReference _holdingPartyReference) {
			this.holdingPartyReference = _holdingPartyReference == null ? null : _holdingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizedExposureGrouping")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizedExposureGrouping")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setCollateralizedExposureGrouping(CollateralizedExposureGrouping _collateralizedExposureGrouping) {
			this.collateralizedExposureGrouping = _collateralizedExposureGrouping == null ? null : _collateralizedExposureGrouping.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizationType")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setCollateralizationType(CollateralizationType _collateralizationType) {
			this.collateralizationType = _collateralizationType == null ? null : _collateralizationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("portfolioId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolioId")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setPortfolioId(CollateralPortfolioId _portfolioId) {
			this.portfolioId = _portfolioId == null ? null : _portfolioId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postedCollateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postedCollateral")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder setPostedCollateral(CollateralPortfolio _postedCollateral) {
			this.postedCollateral = _postedCollateral == null ? null : _postedCollateral.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryReportingCollateralization build() {
			return new RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationImpl(this);
		}
		
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder prune() {
			if (postingPartyReference!=null && !postingPartyReference.prune().hasData()) postingPartyReference = null;
			if (beneficiaryPartyReference!=null && !beneficiaryPartyReference.prune().hasData()) beneficiaryPartyReference = null;
			if (holdingPartyReference!=null && !holdingPartyReference.prune().hasData()) holdingPartyReference = null;
			if (collateralizedExposureGrouping!=null && !collateralizedExposureGrouping.prune().hasData()) collateralizedExposureGrouping = null;
			if (collateralizationType!=null && !collateralizationType.prune().hasData()) collateralizationType = null;
			if (portfolioId!=null && !portfolioId.prune().hasData()) portfolioId = null;
			if (postedCollateral!=null && !postedCollateral.prune().hasData()) postedCollateral = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPostingPartyReference()!=null && getPostingPartyReference().hasData()) return true;
			if (getBeneficiaryPartyReference()!=null && getBeneficiaryPartyReference().hasData()) return true;
			if (getHoldingPartyReference()!=null && getHoldingPartyReference().hasData()) return true;
			if (getCollateralizedExposureGrouping()!=null && getCollateralizedExposureGrouping().hasData()) return true;
			if (getCollateralizationType()!=null && getCollateralizationType().hasData()) return true;
			if (getPortfolioId()!=null && getPortfolioId().hasData()) return true;
			if (getPostedCollateral()!=null && getPostedCollateral().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder o = (RegulatoryReportingCollateralization.RegulatoryReportingCollateralizationBuilder) other;
			
			merger.mergeRosetta(getPostingPartyReference(), o.getPostingPartyReference(), this::setPostingPartyReference);
			merger.mergeRosetta(getBeneficiaryPartyReference(), o.getBeneficiaryPartyReference(), this::setBeneficiaryPartyReference);
			merger.mergeRosetta(getHoldingPartyReference(), o.getHoldingPartyReference(), this::setHoldingPartyReference);
			merger.mergeRosetta(getCollateralizedExposureGrouping(), o.getCollateralizedExposureGrouping(), this::setCollateralizedExposureGrouping);
			merger.mergeRosetta(getCollateralizationType(), o.getCollateralizationType(), this::setCollateralizationType);
			merger.mergeRosetta(getPortfolioId(), o.getPortfolioId(), this::setPortfolioId);
			merger.mergeRosetta(getPostedCollateral(), o.getPostedCollateral(), this::setPostedCollateral);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingCollateralization _that = getType().cast(o);
		
			if (!Objects.equals(postingPartyReference, _that.getPostingPartyReference())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			if (!Objects.equals(holdingPartyReference, _that.getHoldingPartyReference())) return false;
			if (!Objects.equals(collateralizedExposureGrouping, _that.getCollateralizedExposureGrouping())) return false;
			if (!Objects.equals(collateralizationType, _that.getCollateralizationType())) return false;
			if (!Objects.equals(portfolioId, _that.getPortfolioId())) return false;
			if (!Objects.equals(postedCollateral, _that.getPostedCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (postingPartyReference != null ? postingPartyReference.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			_result = 31 * _result + (holdingPartyReference != null ? holdingPartyReference.hashCode() : 0);
			_result = 31 * _result + (collateralizedExposureGrouping != null ? collateralizedExposureGrouping.hashCode() : 0);
			_result = 31 * _result + (collateralizationType != null ? collateralizationType.hashCode() : 0);
			_result = 31 * _result + (portfolioId != null ? portfolioId.hashCode() : 0);
			_result = 31 * _result + (postedCollateral != null ? postedCollateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingCollateralizationBuilder {" +
				"postingPartyReference=" + this.postingPartyReference + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference + ", " +
				"holdingPartyReference=" + this.holdingPartyReference + ", " +
				"collateralizedExposureGrouping=" + this.collateralizedExposureGrouping + ", " +
				"collateralizationType=" + this.collateralizationType + ", " +
				"portfolioId=" + this.portfolioId + ", " +
				"postedCollateral=" + this.postedCollateral +
			'}';
		}
	}
}

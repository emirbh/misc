package fpml.consolidated.sec.lending;

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
import fpml.consolidated.repo.CollateralArrangement;
import fpml.consolidated.repo.CollateralType;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.sec.lending.meta.SecLendCollateralProvisionsMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
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
 * Provision Parameters relating to acceptable collateral for the specified security lending transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Parameters relating to acceptable collateral for the specified security lending transaction.
 *
 */
@RosettaDataType(value="SecLendCollateralProvisions", builder=SecLendCollateralProvisions.SecLendCollateralProvisionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecLendCollateralProvisions", model="fpml", builder=SecLendCollateralProvisions.SecLendCollateralProvisionsBuilderImpl.class, version="2.1.1")
public interface SecLendCollateralProvisions extends RosettaModelObject {

	SecLendCollateralProvisionsMeta metaData = new SecLendCollateralProvisionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The collateral type, which is a restriction of the collateral deemed acceptable for the purpose of the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The collateral type, which is a restriction of the collateral deemed acceptable for the purpose of the transaction.
	 *
	 */
	CollateralType getCollateralType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Tri-party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Tri-party.
	 *
	 */
	TriParty getTriParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 *
	 */
	BigDecimal getMarginRatio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the security lending and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the security lending to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the security lending and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the security lending to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 *
	 */
	BigDecimal getHaircut();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference currency.
	 *
	 */
	Currency getCollateralCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the rate of a currency conversion that is used to compute settlement amount for cross-currency transactions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the rate of a currency conversion that is used to compute settlement amount for cross-currency transactions.
	 *
	 */
	FxRate getFxRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision (SFTR related field) Method used to provide collateral - Indication whether the collateral is subject to a title transfer collateral arrangement, a securities financial collateral arrangement, or a securities financial with the right of use.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision (SFTR related field) Method used to provide collateral - Indication whether the collateral is subject to a title transfer collateral arrangement, a securities financial collateral arrangement, or a securities financial with the right of use.
	 *
	 */
	CollateralArrangement getCollateralArrangement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision (SFTR related field) In the case of securities borrowing and lending, indication whether the borrower has exclusive access to borrow from the lender's securities portfolio. (True/False).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision (SFTR related field) In the case of securities borrowing and lending, indication whether the borrower has exclusive access to borrow from the lender's securities portfolio. (True/False).
	 *
	 */
	Boolean getExclusiveArrangements();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indication whether the collateral taker can reuse the securities provided as a collateral.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indication whether the collateral taker can reuse the securities provided as a collateral.
	 *
	 */
	Boolean getEligibleForRehypothecation();

	/*********************** Build Methods  ***********************/
	SecLendCollateralProvisions build();
	
	SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder toBuilder();
	
	static SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder builder() {
		return new SecLendCollateralProvisions.SecLendCollateralProvisionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecLendCollateralProvisions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecLendCollateralProvisions> getType() {
		return SecLendCollateralProvisions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralType"), processor, CollateralType.class, getCollateralType());
		processRosetta(path.newSubPath("triParty"), processor, TriParty.class, getTriParty());
		processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
		processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
		processRosetta(path.newSubPath("collateralCurrency"), processor, Currency.class, getCollateralCurrency());
		processRosetta(path.newSubPath("fxRate"), processor, FxRate.class, getFxRate());
		processRosetta(path.newSubPath("collateralArrangement"), processor, CollateralArrangement.class, getCollateralArrangement());
		processor.processBasic(path.newSubPath("exclusiveArrangements"), Boolean.class, getExclusiveArrangements(), this);
		processor.processBasic(path.newSubPath("eligibleForRehypothecation"), Boolean.class, getEligibleForRehypothecation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecLendCollateralProvisionsBuilder extends SecLendCollateralProvisions, RosettaModelObjectBuilder {
		CollateralType.CollateralTypeBuilder getOrCreateCollateralType();
		@Override
		CollateralType.CollateralTypeBuilder getCollateralType();
		TriParty.TriPartyBuilder getOrCreateTriParty();
		@Override
		TriParty.TriPartyBuilder getTriParty();
		Currency.CurrencyBuilder getOrCreateCollateralCurrency();
		@Override
		Currency.CurrencyBuilder getCollateralCurrency();
		FxRate.FxRateBuilder getOrCreateFxRate();
		@Override
		FxRate.FxRateBuilder getFxRate();
		CollateralArrangement.CollateralArrangementBuilder getOrCreateCollateralArrangement();
		@Override
		CollateralArrangement.CollateralArrangementBuilder getCollateralArrangement();
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setCollateralType(CollateralType collateralType);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setTriParty(TriParty triParty);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setMarginRatio(BigDecimal marginRatio);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setHaircut(BigDecimal haircut);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setCollateralCurrency(Currency collateralCurrency);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setFxRate(FxRate fxRate);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setCollateralArrangement(CollateralArrangement collateralArrangement);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setExclusiveArrangements(Boolean exclusiveArrangements);
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setEligibleForRehypothecation(Boolean eligibleForRehypothecation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralType"), processor, CollateralType.CollateralTypeBuilder.class, getCollateralType());
			processRosetta(path.newSubPath("triParty"), processor, TriParty.TriPartyBuilder.class, getTriParty());
			processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
			processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
			processRosetta(path.newSubPath("collateralCurrency"), processor, Currency.CurrencyBuilder.class, getCollateralCurrency());
			processRosetta(path.newSubPath("fxRate"), processor, FxRate.FxRateBuilder.class, getFxRate());
			processRosetta(path.newSubPath("collateralArrangement"), processor, CollateralArrangement.CollateralArrangementBuilder.class, getCollateralArrangement());
			processor.processBasic(path.newSubPath("exclusiveArrangements"), Boolean.class, getExclusiveArrangements(), this);
			processor.processBasic(path.newSubPath("eligibleForRehypothecation"), Boolean.class, getEligibleForRehypothecation(), this);
		}
		

		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder prune();
	}

	/*********************** Immutable Implementation of SecLendCollateralProvisions  ***********************/
	class SecLendCollateralProvisionsImpl implements SecLendCollateralProvisions {
		private final CollateralType collateralType;
		private final TriParty triParty;
		private final BigDecimal marginRatio;
		private final BigDecimal haircut;
		private final Currency collateralCurrency;
		private final FxRate fxRate;
		private final CollateralArrangement collateralArrangement;
		private final Boolean exclusiveArrangements;
		private final Boolean eligibleForRehypothecation;
		
		protected SecLendCollateralProvisionsImpl(SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder builder) {
			this.collateralType = ofNullable(builder.getCollateralType()).map(f->f.build()).orElse(null);
			this.triParty = ofNullable(builder.getTriParty()).map(f->f.build()).orElse(null);
			this.marginRatio = builder.getMarginRatio();
			this.haircut = builder.getHaircut();
			this.collateralCurrency = ofNullable(builder.getCollateralCurrency()).map(f->f.build()).orElse(null);
			this.fxRate = ofNullable(builder.getFxRate()).map(f->f.build()).orElse(null);
			this.collateralArrangement = ofNullable(builder.getCollateralArrangement()).map(f->f.build()).orElse(null);
			this.exclusiveArrangements = builder.getExclusiveArrangements();
			this.eligibleForRehypothecation = builder.getEligibleForRehypothecation();
		}
		
		@Override
		@RosettaAttribute("collateralType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralType")
		public CollateralType getCollateralType() {
			return collateralType;
		}
		
		@Override
		@RosettaAttribute("triParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triParty")
		public TriParty getTriParty() {
			return triParty;
		}
		
		@Override
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		@RosettaAttribute("collateralCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralCurrency")
		public Currency getCollateralCurrency() {
			return collateralCurrency;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxRate")
		public FxRate getFxRate() {
			return fxRate;
		}
		
		@Override
		@RosettaAttribute("collateralArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralArrangement")
		public CollateralArrangement getCollateralArrangement() {
			return collateralArrangement;
		}
		
		@Override
		@RosettaAttribute("exclusiveArrangements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exclusiveArrangements")
		public Boolean getExclusiveArrangements() {
			return exclusiveArrangements;
		}
		
		@Override
		@RosettaAttribute("eligibleForRehypothecation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleForRehypothecation")
		public Boolean getEligibleForRehypothecation() {
			return eligibleForRehypothecation;
		}
		
		@Override
		public SecLendCollateralProvisions build() {
			return this;
		}
		
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder toBuilder() {
			SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder builder) {
			ofNullable(getCollateralType()).ifPresent(builder::setCollateralType);
			ofNullable(getTriParty()).ifPresent(builder::setTriParty);
			ofNullable(getMarginRatio()).ifPresent(builder::setMarginRatio);
			ofNullable(getHaircut()).ifPresent(builder::setHaircut);
			ofNullable(getCollateralCurrency()).ifPresent(builder::setCollateralCurrency);
			ofNullable(getFxRate()).ifPresent(builder::setFxRate);
			ofNullable(getCollateralArrangement()).ifPresent(builder::setCollateralArrangement);
			ofNullable(getExclusiveArrangements()).ifPresent(builder::setExclusiveArrangements);
			ofNullable(getEligibleForRehypothecation()).ifPresent(builder::setEligibleForRehypothecation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendCollateralProvisions _that = getType().cast(o);
		
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			if (!Objects.equals(triParty, _that.getTriParty())) return false;
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			if (!Objects.equals(collateralCurrency, _that.getCollateralCurrency())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(collateralArrangement, _that.getCollateralArrangement())) return false;
			if (!Objects.equals(exclusiveArrangements, _that.getExclusiveArrangements())) return false;
			if (!Objects.equals(eligibleForRehypothecation, _that.getEligibleForRehypothecation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralType != null ? collateralType.hashCode() : 0);
			_result = 31 * _result + (triParty != null ? triParty.hashCode() : 0);
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			_result = 31 * _result + (collateralCurrency != null ? collateralCurrency.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (collateralArrangement != null ? collateralArrangement.hashCode() : 0);
			_result = 31 * _result + (exclusiveArrangements != null ? exclusiveArrangements.hashCode() : 0);
			_result = 31 * _result + (eligibleForRehypothecation != null ? eligibleForRehypothecation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendCollateralProvisions {" +
				"collateralType=" + this.collateralType + ", " +
				"triParty=" + this.triParty + ", " +
				"marginRatio=" + this.marginRatio + ", " +
				"haircut=" + this.haircut + ", " +
				"collateralCurrency=" + this.collateralCurrency + ", " +
				"fxRate=" + this.fxRate + ", " +
				"collateralArrangement=" + this.collateralArrangement + ", " +
				"exclusiveArrangements=" + this.exclusiveArrangements + ", " +
				"eligibleForRehypothecation=" + this.eligibleForRehypothecation +
			'}';
		}
	}

	/*********************** Builder Implementation of SecLendCollateralProvisions  ***********************/
	class SecLendCollateralProvisionsBuilderImpl implements SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder {
	
		protected CollateralType.CollateralTypeBuilder collateralType;
		protected TriParty.TriPartyBuilder triParty;
		protected BigDecimal marginRatio;
		protected BigDecimal haircut;
		protected Currency.CurrencyBuilder collateralCurrency;
		protected FxRate.FxRateBuilder fxRate;
		protected CollateralArrangement.CollateralArrangementBuilder collateralArrangement;
		protected Boolean exclusiveArrangements;
		protected Boolean eligibleForRehypothecation;
		
		@Override
		@RosettaAttribute("collateralType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralType")
		public CollateralType.CollateralTypeBuilder getCollateralType() {
			return collateralType;
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder getOrCreateCollateralType() {
			CollateralType.CollateralTypeBuilder result;
			if (collateralType!=null) {
				result = collateralType;
			}
			else {
				result = collateralType = CollateralType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triParty")
		public TriParty.TriPartyBuilder getTriParty() {
			return triParty;
		}
		
		@Override
		public TriParty.TriPartyBuilder getOrCreateTriParty() {
			TriParty.TriPartyBuilder result;
			if (triParty!=null) {
				result = triParty;
			}
			else {
				result = triParty = TriParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		@RosettaAttribute("collateralCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralCurrency")
		public Currency.CurrencyBuilder getCollateralCurrency() {
			return collateralCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCollateralCurrency() {
			Currency.CurrencyBuilder result;
			if (collateralCurrency!=null) {
				result = collateralCurrency;
			}
			else {
				result = collateralCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxRate")
		public FxRate.FxRateBuilder getFxRate() {
			return fxRate;
		}
		
		@Override
		public FxRate.FxRateBuilder getOrCreateFxRate() {
			FxRate.FxRateBuilder result;
			if (fxRate!=null) {
				result = fxRate;
			}
			else {
				result = fxRate = FxRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralArrangement")
		public CollateralArrangement.CollateralArrangementBuilder getCollateralArrangement() {
			return collateralArrangement;
		}
		
		@Override
		public CollateralArrangement.CollateralArrangementBuilder getOrCreateCollateralArrangement() {
			CollateralArrangement.CollateralArrangementBuilder result;
			if (collateralArrangement!=null) {
				result = collateralArrangement;
			}
			else {
				result = collateralArrangement = CollateralArrangement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exclusiveArrangements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exclusiveArrangements")
		public Boolean getExclusiveArrangements() {
			return exclusiveArrangements;
		}
		
		@Override
		@RosettaAttribute("eligibleForRehypothecation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleForRehypothecation")
		public Boolean getEligibleForRehypothecation() {
			return eligibleForRehypothecation;
		}
		
		@RosettaAttribute("collateralType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralType")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setCollateralType(CollateralType _collateralType) {
			this.collateralType = _collateralType == null ? null : _collateralType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triParty")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setTriParty(TriParty _triParty) {
			this.triParty = _triParty == null ? null : _triParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marginRatio")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setMarginRatio(BigDecimal _marginRatio) {
			this.marginRatio = _marginRatio == null ? null : _marginRatio;
			return this;
		}
		
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("haircut")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setHaircut(BigDecimal _haircut) {
			this.haircut = _haircut == null ? null : _haircut;
			return this;
		}
		
		@RosettaAttribute("collateralCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralCurrency")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setCollateralCurrency(Currency _collateralCurrency) {
			this.collateralCurrency = _collateralCurrency == null ? null : _collateralCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxRate")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setFxRate(FxRate _fxRate) {
			this.fxRate = _fxRate == null ? null : _fxRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralArrangement")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setCollateralArrangement(CollateralArrangement _collateralArrangement) {
			this.collateralArrangement = _collateralArrangement == null ? null : _collateralArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exclusiveArrangements")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exclusiveArrangements")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setExclusiveArrangements(Boolean _exclusiveArrangements) {
			this.exclusiveArrangements = _exclusiveArrangements == null ? null : _exclusiveArrangements;
			return this;
		}
		
		@RosettaAttribute("eligibleForRehypothecation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eligibleForRehypothecation")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder setEligibleForRehypothecation(Boolean _eligibleForRehypothecation) {
			this.eligibleForRehypothecation = _eligibleForRehypothecation == null ? null : _eligibleForRehypothecation;
			return this;
		}
		
		@Override
		public SecLendCollateralProvisions build() {
			return new SecLendCollateralProvisions.SecLendCollateralProvisionsImpl(this);
		}
		
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder prune() {
			if (collateralType!=null && !collateralType.prune().hasData()) collateralType = null;
			if (triParty!=null && !triParty.prune().hasData()) triParty = null;
			if (collateralCurrency!=null && !collateralCurrency.prune().hasData()) collateralCurrency = null;
			if (fxRate!=null && !fxRate.prune().hasData()) fxRate = null;
			if (collateralArrangement!=null && !collateralArrangement.prune().hasData()) collateralArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralType()!=null && getCollateralType().hasData()) return true;
			if (getTriParty()!=null && getTriParty().hasData()) return true;
			if (getMarginRatio()!=null) return true;
			if (getHaircut()!=null) return true;
			if (getCollateralCurrency()!=null && getCollateralCurrency().hasData()) return true;
			if (getFxRate()!=null && getFxRate().hasData()) return true;
			if (getCollateralArrangement()!=null && getCollateralArrangement().hasData()) return true;
			if (getExclusiveArrangements()!=null) return true;
			if (getEligibleForRehypothecation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder o = (SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder) other;
			
			merger.mergeRosetta(getCollateralType(), o.getCollateralType(), this::setCollateralType);
			merger.mergeRosetta(getTriParty(), o.getTriParty(), this::setTriParty);
			merger.mergeRosetta(getCollateralCurrency(), o.getCollateralCurrency(), this::setCollateralCurrency);
			merger.mergeRosetta(getFxRate(), o.getFxRate(), this::setFxRate);
			merger.mergeRosetta(getCollateralArrangement(), o.getCollateralArrangement(), this::setCollateralArrangement);
			
			merger.mergeBasic(getMarginRatio(), o.getMarginRatio(), this::setMarginRatio);
			merger.mergeBasic(getHaircut(), o.getHaircut(), this::setHaircut);
			merger.mergeBasic(getExclusiveArrangements(), o.getExclusiveArrangements(), this::setExclusiveArrangements);
			merger.mergeBasic(getEligibleForRehypothecation(), o.getEligibleForRehypothecation(), this::setEligibleForRehypothecation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecLendCollateralProvisions _that = getType().cast(o);
		
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			if (!Objects.equals(triParty, _that.getTriParty())) return false;
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			if (!Objects.equals(collateralCurrency, _that.getCollateralCurrency())) return false;
			if (!Objects.equals(fxRate, _that.getFxRate())) return false;
			if (!Objects.equals(collateralArrangement, _that.getCollateralArrangement())) return false;
			if (!Objects.equals(exclusiveArrangements, _that.getExclusiveArrangements())) return false;
			if (!Objects.equals(eligibleForRehypothecation, _that.getEligibleForRehypothecation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralType != null ? collateralType.hashCode() : 0);
			_result = 31 * _result + (triParty != null ? triParty.hashCode() : 0);
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			_result = 31 * _result + (collateralCurrency != null ? collateralCurrency.hashCode() : 0);
			_result = 31 * _result + (fxRate != null ? fxRate.hashCode() : 0);
			_result = 31 * _result + (collateralArrangement != null ? collateralArrangement.hashCode() : 0);
			_result = 31 * _result + (exclusiveArrangements != null ? exclusiveArrangements.hashCode() : 0);
			_result = 31 * _result + (eligibleForRehypothecation != null ? eligibleForRehypothecation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendCollateralProvisionsBuilder {" +
				"collateralType=" + this.collateralType + ", " +
				"triParty=" + this.triParty + ", " +
				"marginRatio=" + this.marginRatio + ", " +
				"haircut=" + this.haircut + ", " +
				"collateralCurrency=" + this.collateralCurrency + ", " +
				"fxRate=" + this.fxRate + ", " +
				"collateralArrangement=" + this.collateralArrangement + ", " +
				"exclusiveArrangements=" + this.exclusiveArrangements + ", " +
				"eligibleForRehypothecation=" + this.eligibleForRehypothecation +
			'}';
		}
	}
}

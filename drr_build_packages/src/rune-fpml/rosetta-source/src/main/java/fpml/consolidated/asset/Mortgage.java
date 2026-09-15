package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.MortgageMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditRating;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
 * Provision A type describing a mortgage asset.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a mortgage asset.
 *
 */
@RosettaDataType(value="Mortgage", builder=Mortgage.MortgageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Mortgage", model="fpml", builder=Mortgage.MortgageBuilderImpl.class, version="2.1.1")
public interface Mortgage extends UnderlyingAsset {

	MortgageMeta metaData = new MortgageMeta();

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
	LegalEntity getInsurer();
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
	LegalEntityReference getInsurerReference();
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
	String getIssuerName();
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
	PartyReference getIssuerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The repayment precedence of a debt instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The repayment precedence of a debt instrument.
	 *
	 */
	CreditSeniority getSeniority();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Credit quality type (e.g. 'INVG' - Investment grade; 'NIVG' - Non-investment grade; 'NOTR' - Non-rated). Classifies the risk of the security. Note: 'NOAP' - Not applicable value is indicated by the absence of the 'creditQuality' element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Credit quality type (e.g. 'INVG' - Investment grade; 'NIVG' - Non-investment grade; 'NOTR' - Non-rated). Classifies the risk of the security. Note: 'NOAP' - Not applicable value is indicated by the absence of the 'creditQuality' element.
	 *
	 */
	List<? extends CreditQuality> getCreditQuality();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The credit rating.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The credit rating.
	 *
	 */
	List<? extends CreditRating> getCreditRating();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies if the bond has a variable coupon, step-up/down coupon or a zero-coupon.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies if the bond has a variable coupon, step-up/down coupon or a zero-coupon.
	 *
	 */
	CouponType getCouponType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
	 *
	 */
	BigDecimal getCouponRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the principal amount of a security becomes due and payable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the principal amount of a security becomes due and payable.
	 *
	 */
	ZonedDateTime getMaturity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the frequency at which the bond pays, e.g. 6M.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the frequency at which the bond pays, e.g. 6M.
	 *
	 */
	Frequency getPaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count basis for the bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count basis for the bond.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The initial issued amount of the mortgage obligation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The initial issued amount of the mortgage obligation.
	 *
	 */
	BigDecimal getOriginalPrincipalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The morgage pool that is underneath the mortgage obligation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The morgage pool that is underneath the mortgage obligation.
	 *
	 */
	AssetPool getPool();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The sector classification of the mortgage obligation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The sector classification of the mortgage obligation.
	 *
	 */
	MortgageSector getSector();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The mortgage obligation tranche that is subject to the derivative transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The mortgage obligation tranche that is subject to the derivative transaction.
	 *
	 */
	String getTranche();

	/*********************** Build Methods  ***********************/
	Mortgage build();
	
	Mortgage.MortgageBuilder toBuilder();
	
	static Mortgage.MortgageBuilder builder() {
		return new Mortgage.MortgageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Mortgage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Mortgage> getType() {
		return Mortgage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("insurer"), processor, LegalEntity.class, getInsurer());
		processRosetta(path.newSubPath("insurerReference"), processor, LegalEntityReference.class, getInsurerReference());
		processor.processBasic(path.newSubPath("issuerName"), String.class, getIssuerName(), this);
		processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.class, getIssuerPartyReference());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processRosetta(path.newSubPath("creditQuality"), processor, CreditQuality.class, getCreditQuality());
		processRosetta(path.newSubPath("creditRating"), processor, CreditRating.class, getCreditRating());
		processRosetta(path.newSubPath("couponType"), processor, CouponType.class, getCouponType());
		processor.processBasic(path.newSubPath("couponRate"), BigDecimal.class, getCouponRate(), this);
		processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
		processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.class, getPaymentFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("originalPrincipalAmount"), BigDecimal.class, getOriginalPrincipalAmount(), this);
		processRosetta(path.newSubPath("pool"), processor, AssetPool.class, getPool());
		processRosetta(path.newSubPath("sector"), processor, MortgageSector.class, getSector());
		processor.processBasic(path.newSubPath("tranche"), String.class, getTranche(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MortgageBuilder extends Mortgage, UnderlyingAsset.UnderlyingAssetBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateInsurer();
		@Override
		LegalEntity.LegalEntityBuilder getInsurer();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateInsurerReference();
		@Override
		LegalEntityReference.LegalEntityReferenceBuilder getInsurerReference();
		PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getIssuerPartyReference();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		CreditQuality.CreditQualityBuilder getOrCreateCreditQuality(int index);
		@Override
		List<? extends CreditQuality.CreditQualityBuilder> getCreditQuality();
		CreditRating.CreditRatingBuilder getOrCreateCreditRating(int index);
		@Override
		List<? extends CreditRating.CreditRatingBuilder> getCreditRating();
		CouponType.CouponTypeBuilder getOrCreateCouponType();
		@Override
		CouponType.CouponTypeBuilder getCouponType();
		Frequency.FrequencyBuilder getOrCreatePaymentFrequency();
		@Override
		Frequency.FrequencyBuilder getPaymentFrequency();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		AssetPool.AssetPoolBuilder getOrCreatePool();
		@Override
		AssetPool.AssetPoolBuilder getPool();
		MortgageSector.MortgageSectorBuilder getOrCreateSector();
		@Override
		MortgageSector.MortgageSectorBuilder getSector();
		@Override
		Mortgage.MortgageBuilder setId(String id);
		@Override
		Mortgage.MortgageBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Mortgage.MortgageBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Mortgage.MortgageBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Mortgage.MortgageBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Mortgage.MortgageBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Mortgage.MortgageBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Mortgage.MortgageBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Mortgage.MortgageBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Mortgage.MortgageBuilder setDescription(String description);
		@Override
		Mortgage.MortgageBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Mortgage.MortgageBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		Mortgage.MortgageBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		Mortgage.MortgageBuilder setDefinition(ProductReference definition);
		Mortgage.MortgageBuilder setInsurer(LegalEntity insurer);
		Mortgage.MortgageBuilder setInsurerReference(LegalEntityReference insurerReference);
		Mortgage.MortgageBuilder setIssuerName(String issuerName);
		Mortgage.MortgageBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		Mortgage.MortgageBuilder setSeniority(CreditSeniority seniority);
		Mortgage.MortgageBuilder addCreditQuality(CreditQuality creditQuality);
		Mortgage.MortgageBuilder addCreditQuality(CreditQuality creditQuality, int idx);
		Mortgage.MortgageBuilder addCreditQuality(List<? extends CreditQuality> creditQuality);
		Mortgage.MortgageBuilder setCreditQuality(List<? extends CreditQuality> creditQuality);
		Mortgage.MortgageBuilder addCreditRating(CreditRating creditRating);
		Mortgage.MortgageBuilder addCreditRating(CreditRating creditRating, int idx);
		Mortgage.MortgageBuilder addCreditRating(List<? extends CreditRating> creditRating);
		Mortgage.MortgageBuilder setCreditRating(List<? extends CreditRating> creditRating);
		Mortgage.MortgageBuilder setCouponType(CouponType couponType);
		Mortgage.MortgageBuilder setCouponRate(BigDecimal couponRate);
		Mortgage.MortgageBuilder setMaturity(ZonedDateTime maturity);
		Mortgage.MortgageBuilder setPaymentFrequency(Frequency paymentFrequency);
		Mortgage.MortgageBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Mortgage.MortgageBuilder setOriginalPrincipalAmount(BigDecimal originalPrincipalAmount);
		Mortgage.MortgageBuilder setPool(AssetPool pool);
		Mortgage.MortgageBuilder setSector(MortgageSector sector);
		Mortgage.MortgageBuilder setTranche(String tranche);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("insurer"), processor, LegalEntity.LegalEntityBuilder.class, getInsurer());
			processRosetta(path.newSubPath("insurerReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getInsurerReference());
			processor.processBasic(path.newSubPath("issuerName"), String.class, getIssuerName(), this);
			processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuerPartyReference());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processRosetta(path.newSubPath("creditQuality"), processor, CreditQuality.CreditQualityBuilder.class, getCreditQuality());
			processRosetta(path.newSubPath("creditRating"), processor, CreditRating.CreditRatingBuilder.class, getCreditRating());
			processRosetta(path.newSubPath("couponType"), processor, CouponType.CouponTypeBuilder.class, getCouponType());
			processor.processBasic(path.newSubPath("couponRate"), BigDecimal.class, getCouponRate(), this);
			processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
			processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.FrequencyBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("originalPrincipalAmount"), BigDecimal.class, getOriginalPrincipalAmount(), this);
			processRosetta(path.newSubPath("pool"), processor, AssetPool.AssetPoolBuilder.class, getPool());
			processRosetta(path.newSubPath("sector"), processor, MortgageSector.MortgageSectorBuilder.class, getSector());
			processor.processBasic(path.newSubPath("tranche"), String.class, getTranche(), this);
		}
		

		Mortgage.MortgageBuilder prune();
	}

	/*********************** Immutable Implementation of Mortgage  ***********************/
	class MortgageImpl extends UnderlyingAsset.UnderlyingAssetImpl implements Mortgage {
		private final LegalEntity insurer;
		private final LegalEntityReference insurerReference;
		private final String issuerName;
		private final PartyReference issuerPartyReference;
		private final CreditSeniority seniority;
		private final List<? extends CreditQuality> creditQuality;
		private final List<? extends CreditRating> creditRating;
		private final CouponType couponType;
		private final BigDecimal couponRate;
		private final ZonedDateTime maturity;
		private final Frequency paymentFrequency;
		private final DayCountFraction dayCountFraction;
		private final BigDecimal originalPrincipalAmount;
		private final AssetPool pool;
		private final MortgageSector sector;
		private final String tranche;
		
		protected MortgageImpl(Mortgage.MortgageBuilder builder) {
			super(builder);
			this.insurer = ofNullable(builder.getInsurer()).map(f->f.build()).orElse(null);
			this.insurerReference = ofNullable(builder.getInsurerReference()).map(f->f.build()).orElse(null);
			this.issuerName = builder.getIssuerName();
			this.issuerPartyReference = ofNullable(builder.getIssuerPartyReference()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.creditQuality = ofNullable(builder.getCreditQuality()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditRating = ofNullable(builder.getCreditRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.couponType = ofNullable(builder.getCouponType()).map(f->f.build()).orElse(null);
			this.couponRate = builder.getCouponRate();
			this.maturity = builder.getMaturity();
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.originalPrincipalAmount = builder.getOriginalPrincipalAmount();
			this.pool = ofNullable(builder.getPool()).map(f->f.build()).orElse(null);
			this.sector = ofNullable(builder.getSector()).map(f->f.build()).orElse(null);
			this.tranche = builder.getTranche();
		}
		
		@Override
		@RosettaAttribute("insurer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("insurer")
		public LegalEntity getInsurer() {
			return insurer;
		}
		
		@Override
		@RosettaAttribute("insurerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("insurerReference")
		public LegalEntityReference getInsurerReference() {
			return insurerReference;
		}
		
		@Override
		@RosettaAttribute("issuerName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerName")
		public String getIssuerName() {
			return issuerName;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerPartyReference")
		public PartyReference getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditQuality")
		public List<? extends CreditQuality> getCreditQuality() {
			return creditQuality;
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
		@RosettaAttribute("couponType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponType")
		public CouponType getCouponType() {
			return couponType;
		}
		
		@Override
		@RosettaAttribute("couponRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponRate")
		public BigDecimal getCouponRate() {
			return couponRate;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Frequency getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("originalPrincipalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalPrincipalAmount")
		public BigDecimal getOriginalPrincipalAmount() {
			return originalPrincipalAmount;
		}
		
		@Override
		@RosettaAttribute("pool")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pool")
		public AssetPool getPool() {
			return pool;
		}
		
		@Override
		@RosettaAttribute("sector")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sector")
		public MortgageSector getSector() {
			return sector;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public String getTranche() {
			return tranche;
		}
		
		@Override
		public Mortgage build() {
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder toBuilder() {
			Mortgage.MortgageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Mortgage.MortgageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInsurer()).ifPresent(builder::setInsurer);
			ofNullable(getInsurerReference()).ifPresent(builder::setInsurerReference);
			ofNullable(getIssuerName()).ifPresent(builder::setIssuerName);
			ofNullable(getIssuerPartyReference()).ifPresent(builder::setIssuerPartyReference);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getCreditQuality()).ifPresent(builder::setCreditQuality);
			ofNullable(getCreditRating()).ifPresent(builder::setCreditRating);
			ofNullable(getCouponType()).ifPresent(builder::setCouponType);
			ofNullable(getCouponRate()).ifPresent(builder::setCouponRate);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getOriginalPrincipalAmount()).ifPresent(builder::setOriginalPrincipalAmount);
			ofNullable(getPool()).ifPresent(builder::setPool);
			ofNullable(getSector()).ifPresent(builder::setSector);
			ofNullable(getTranche()).ifPresent(builder::setTranche);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Mortgage _that = getType().cast(o);
		
			if (!Objects.equals(insurer, _that.getInsurer())) return false;
			if (!Objects.equals(insurerReference, _that.getInsurerReference())) return false;
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(creditQuality, _that.getCreditQuality())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(couponType, _that.getCouponType())) return false;
			if (!Objects.equals(couponRate, _that.getCouponRate())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(originalPrincipalAmount, _that.getOriginalPrincipalAmount())) return false;
			if (!Objects.equals(pool, _that.getPool())) return false;
			if (!Objects.equals(sector, _that.getSector())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (insurer != null ? insurer.hashCode() : 0);
			_result = 31 * _result + (insurerReference != null ? insurerReference.hashCode() : 0);
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (creditQuality != null ? creditQuality.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (couponType != null ? couponType.hashCode() : 0);
			_result = 31 * _result + (couponRate != null ? couponRate.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (originalPrincipalAmount != null ? originalPrincipalAmount.hashCode() : 0);
			_result = 31 * _result + (pool != null ? pool.hashCode() : 0);
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Mortgage {" +
				"insurer=" + this.insurer + ", " +
				"insurerReference=" + this.insurerReference + ", " +
				"issuerName=" + this.issuerName + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"seniority=" + this.seniority + ", " +
				"creditQuality=" + this.creditQuality + ", " +
				"creditRating=" + this.creditRating + ", " +
				"couponType=" + this.couponType + ", " +
				"couponRate=" + this.couponRate + ", " +
				"maturity=" + this.maturity + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"originalPrincipalAmount=" + this.originalPrincipalAmount + ", " +
				"pool=" + this.pool + ", " +
				"sector=" + this.sector + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Mortgage  ***********************/
	class MortgageBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements Mortgage.MortgageBuilder {
	
		protected LegalEntity.LegalEntityBuilder insurer;
		protected LegalEntityReference.LegalEntityReferenceBuilder insurerReference;
		protected String issuerName;
		protected PartyReference.PartyReferenceBuilder issuerPartyReference;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected List<CreditQuality.CreditQualityBuilder> creditQuality = new ArrayList<>();
		protected List<CreditRating.CreditRatingBuilder> creditRating = new ArrayList<>();
		protected CouponType.CouponTypeBuilder couponType;
		protected BigDecimal couponRate;
		protected ZonedDateTime maturity;
		protected Frequency.FrequencyBuilder paymentFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected BigDecimal originalPrincipalAmount;
		protected AssetPool.AssetPoolBuilder pool;
		protected MortgageSector.MortgageSectorBuilder sector;
		protected String tranche;
		
		@Override
		@RosettaAttribute("insurer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("insurer")
		public LegalEntity.LegalEntityBuilder getInsurer() {
			return insurer;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateInsurer() {
			LegalEntity.LegalEntityBuilder result;
			if (insurer!=null) {
				result = insurer;
			}
			else {
				result = insurer = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("insurerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("insurerReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getInsurerReference() {
			return insurerReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateInsurerReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (insurerReference!=null) {
				result = insurerReference;
			}
			else {
				result = insurerReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuerName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerName")
		public String getIssuerName() {
			return issuerName;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuerPartyReference!=null) {
				result = issuerPartyReference;
			}
			else {
				result = issuerPartyReference = PartyReference.builder();
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
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditQuality")
		public List<? extends CreditQuality.CreditQualityBuilder> getCreditQuality() {
			return creditQuality;
		}
		
		@Override
		public CreditQuality.CreditQualityBuilder getOrCreateCreditQuality(int index) {
			if (creditQuality==null) {
				this.creditQuality = new ArrayList<>();
			}
			return getIndex(creditQuality, index, () -> {
						CreditQuality.CreditQualityBuilder newCreditQuality = CreditQuality.builder();
						return newCreditQuality;
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
		@RosettaAttribute("couponType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponType")
		public CouponType.CouponTypeBuilder getCouponType() {
			return couponType;
		}
		
		@Override
		public CouponType.CouponTypeBuilder getOrCreateCouponType() {
			CouponType.CouponTypeBuilder result;
			if (couponType!=null) {
				result = couponType;
			}
			else {
				result = couponType = CouponType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponRate")
		public BigDecimal getCouponRate() {
			return couponRate;
		}
		
		@Override
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturity")
		public ZonedDateTime getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Frequency.FrequencyBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreatePaymentFrequency() {
			Frequency.FrequencyBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("originalPrincipalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalPrincipalAmount")
		public BigDecimal getOriginalPrincipalAmount() {
			return originalPrincipalAmount;
		}
		
		@Override
		@RosettaAttribute("pool")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pool")
		public AssetPool.AssetPoolBuilder getPool() {
			return pool;
		}
		
		@Override
		public AssetPool.AssetPoolBuilder getOrCreatePool() {
			AssetPool.AssetPoolBuilder result;
			if (pool!=null) {
				result = pool;
			}
			else {
				result = pool = AssetPool.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sector")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sector")
		public MortgageSector.MortgageSectorBuilder getSector() {
			return sector;
		}
		
		@Override
		public MortgageSector.MortgageSectorBuilder getOrCreateSector() {
			MortgageSector.MortgageSectorBuilder result;
			if (sector!=null) {
				result = sector;
			}
			else {
				result = sector = MortgageSector.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tranche")
		public String getTranche() {
			return tranche;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Mortgage.MortgageBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Mortgage.MortgageBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Mortgage.MortgageBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Mortgage.MortgageBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public Mortgage.MortgageBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public Mortgage.MortgageBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Mortgage.MortgageBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Mortgage.MortgageBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public Mortgage.MortgageBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public Mortgage.MortgageBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("insurer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("insurer")
		@Override
		public Mortgage.MortgageBuilder setInsurer(LegalEntity _insurer) {
			this.insurer = _insurer == null ? null : _insurer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("insurerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("insurerReference")
		@Override
		public Mortgage.MortgageBuilder setInsurerReference(LegalEntityReference _insurerReference) {
			this.insurerReference = _insurerReference == null ? null : _insurerReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuerName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerName")
		@Override
		public Mortgage.MortgageBuilder setIssuerName(String _issuerName) {
			this.issuerName = _issuerName == null ? null : _issuerName;
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerPartyReference")
		@Override
		public Mortgage.MortgageBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public Mortgage.MortgageBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public Mortgage.MortgageBuilder addCreditQuality(CreditQuality _creditQuality) {
			if (_creditQuality != null) {
				this.creditQuality.add(_creditQuality.toBuilder());
			}
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addCreditQuality(CreditQuality _creditQuality, int idx) {
			getIndex(this.creditQuality, idx, () -> _creditQuality.toBuilder());
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addCreditQuality(List<? extends CreditQuality> creditQualitys) {
			if (creditQualitys != null) {
				for (final CreditQuality toAdd : creditQualitys) {
					this.creditQuality.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public Mortgage.MortgageBuilder setCreditQuality(List<? extends CreditQuality> creditQualitys) {
			if (creditQualitys == null) {
				this.creditQuality = new ArrayList<>();
			} else {
				this.creditQuality = creditQualitys.stream()
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
		public Mortgage.MortgageBuilder addCreditRating(CreditRating _creditRating) {
			if (_creditRating != null) {
				this.creditRating.add(_creditRating.toBuilder());
			}
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addCreditRating(CreditRating _creditRating, int idx) {
			getIndex(this.creditRating, idx, () -> _creditRating.toBuilder());
			return this;
		}
		
		@Override
		public Mortgage.MortgageBuilder addCreditRating(List<? extends CreditRating> creditRatings) {
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
		public Mortgage.MortgageBuilder setCreditRating(List<? extends CreditRating> creditRatings) {
			if (creditRatings == null) {
				this.creditRating = new ArrayList<>();
			} else {
				this.creditRating = creditRatings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("couponType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponType")
		@Override
		public Mortgage.MortgageBuilder setCouponType(CouponType _couponType) {
			this.couponType = _couponType == null ? null : _couponType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("couponRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponRate")
		@Override
		public Mortgage.MortgageBuilder setCouponRate(BigDecimal _couponRate) {
			this.couponRate = _couponRate == null ? null : _couponRate;
			return this;
		}
		
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturity")
		@Override
		public Mortgage.MortgageBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public Mortgage.MortgageBuilder setPaymentFrequency(Frequency _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public Mortgage.MortgageBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originalPrincipalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalPrincipalAmount")
		@Override
		public Mortgage.MortgageBuilder setOriginalPrincipalAmount(BigDecimal _originalPrincipalAmount) {
			this.originalPrincipalAmount = _originalPrincipalAmount == null ? null : _originalPrincipalAmount;
			return this;
		}
		
		@RosettaAttribute("pool")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pool")
		@Override
		public Mortgage.MortgageBuilder setPool(AssetPool _pool) {
			this.pool = _pool == null ? null : _pool.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sector")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sector")
		@Override
		public Mortgage.MortgageBuilder setSector(MortgageSector _sector) {
			this.sector = _sector == null ? null : _sector.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tranche")
		@Override
		public Mortgage.MortgageBuilder setTranche(String _tranche) {
			this.tranche = _tranche == null ? null : _tranche;
			return this;
		}
		
		@Override
		public Mortgage build() {
			return new Mortgage.MortgageImpl(this);
		}
		
		@Override
		public Mortgage.MortgageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Mortgage.MortgageBuilder prune() {
			super.prune();
			if (insurer!=null && !insurer.prune().hasData()) insurer = null;
			if (insurerReference!=null && !insurerReference.prune().hasData()) insurerReference = null;
			if (issuerPartyReference!=null && !issuerPartyReference.prune().hasData()) issuerPartyReference = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			creditQuality = creditQuality.stream().filter(b->b!=null).<CreditQuality.CreditQualityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditRating = creditRating.stream().filter(b->b!=null).<CreditRating.CreditRatingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (couponType!=null && !couponType.prune().hasData()) couponType = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (pool!=null && !pool.prune().hasData()) pool = null;
			if (sector!=null && !sector.prune().hasData()) sector = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInsurer()!=null && getInsurer().hasData()) return true;
			if (getInsurerReference()!=null && getInsurerReference().hasData()) return true;
			if (getIssuerName()!=null) return true;
			if (getIssuerPartyReference()!=null && getIssuerPartyReference().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getCreditQuality()!=null && getCreditQuality().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditRating()!=null && getCreditRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCouponType()!=null && getCouponType().hasData()) return true;
			if (getCouponRate()!=null) return true;
			if (getMaturity()!=null) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getOriginalPrincipalAmount()!=null) return true;
			if (getPool()!=null && getPool().hasData()) return true;
			if (getSector()!=null && getSector().hasData()) return true;
			if (getTranche()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Mortgage.MortgageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Mortgage.MortgageBuilder o = (Mortgage.MortgageBuilder) other;
			
			merger.mergeRosetta(getInsurer(), o.getInsurer(), this::setInsurer);
			merger.mergeRosetta(getInsurerReference(), o.getInsurerReference(), this::setInsurerReference);
			merger.mergeRosetta(getIssuerPartyReference(), o.getIssuerPartyReference(), this::setIssuerPartyReference);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getCreditQuality(), o.getCreditQuality(), this::getOrCreateCreditQuality);
			merger.mergeRosetta(getCreditRating(), o.getCreditRating(), this::getOrCreateCreditRating);
			merger.mergeRosetta(getCouponType(), o.getCouponType(), this::setCouponType);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getPool(), o.getPool(), this::setPool);
			merger.mergeRosetta(getSector(), o.getSector(), this::setSector);
			
			merger.mergeBasic(getIssuerName(), o.getIssuerName(), this::setIssuerName);
			merger.mergeBasic(getCouponRate(), o.getCouponRate(), this::setCouponRate);
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			merger.mergeBasic(getOriginalPrincipalAmount(), o.getOriginalPrincipalAmount(), this::setOriginalPrincipalAmount);
			merger.mergeBasic(getTranche(), o.getTranche(), this::setTranche);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Mortgage _that = getType().cast(o);
		
			if (!Objects.equals(insurer, _that.getInsurer())) return false;
			if (!Objects.equals(insurerReference, _that.getInsurerReference())) return false;
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(creditQuality, _that.getCreditQuality())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(couponType, _that.getCouponType())) return false;
			if (!Objects.equals(couponRate, _that.getCouponRate())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(originalPrincipalAmount, _that.getOriginalPrincipalAmount())) return false;
			if (!Objects.equals(pool, _that.getPool())) return false;
			if (!Objects.equals(sector, _that.getSector())) return false;
			if (!Objects.equals(tranche, _that.getTranche())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (insurer != null ? insurer.hashCode() : 0);
			_result = 31 * _result + (insurerReference != null ? insurerReference.hashCode() : 0);
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (creditQuality != null ? creditQuality.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (couponType != null ? couponType.hashCode() : 0);
			_result = 31 * _result + (couponRate != null ? couponRate.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (originalPrincipalAmount != null ? originalPrincipalAmount.hashCode() : 0);
			_result = 31 * _result + (pool != null ? pool.hashCode() : 0);
			_result = 31 * _result + (sector != null ? sector.hashCode() : 0);
			_result = 31 * _result + (tranche != null ? tranche.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MortgageBuilder {" +
				"insurer=" + this.insurer + ", " +
				"insurerReference=" + this.insurerReference + ", " +
				"issuerName=" + this.issuerName + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"seniority=" + this.seniority + ", " +
				"creditQuality=" + this.creditQuality + ", " +
				"creditRating=" + this.creditRating + ", " +
				"couponType=" + this.couponType + ", " +
				"couponRate=" + this.couponRate + ", " +
				"maturity=" + this.maturity + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"originalPrincipalAmount=" + this.originalPrincipalAmount + ", " +
				"pool=" + this.pool + ", " +
				"sector=" + this.sector + ", " +
				"tranche=" + this.tranche +
			'}' + " " + super.toString();
		}
	}
}

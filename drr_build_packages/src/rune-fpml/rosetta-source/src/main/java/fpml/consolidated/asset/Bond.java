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
import fpml.consolidated.asset.meta.BondMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditRating;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
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
 * Provision An exchange traded bond.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An exchange traded bond.
 *
 */
@RosettaDataType(value="Bond", builder=Bond.BondBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Bond", model="fpml", builder=Bond.BondBuilderImpl.class, version="2.1.1")
public interface Bond extends UnderlyingAsset {

	BondMeta metaData = new BondMeta();

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
	 * Provision Specifies the nominal amount of a fixed income security or convertible bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the nominal amount of a fixed income security or convertible bond.
	 *
	 */
	BigDecimal getParValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the total amount of the issue. Corresponds to the par value multiplied by the number of issued security.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the total amount of the issue. Corresponds to the par value multiplied by the number of issued security.
	 *
	 */
	BigDecimal getFaceAmount();
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

	/*********************** Build Methods  ***********************/
	Bond build();
	
	Bond.BondBuilder toBuilder();
	
	static Bond.BondBuilder builder() {
		return new Bond.BondBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Bond> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Bond> getType() {
		return Bond.class;
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
		processor.processBasic(path.newSubPath("issuerName"), String.class, getIssuerName(), this);
		processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.class, getIssuerPartyReference());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processRosetta(path.newSubPath("creditQuality"), processor, CreditQuality.class, getCreditQuality());
		processRosetta(path.newSubPath("creditRating"), processor, CreditRating.class, getCreditRating());
		processRosetta(path.newSubPath("couponType"), processor, CouponType.class, getCouponType());
		processor.processBasic(path.newSubPath("couponRate"), BigDecimal.class, getCouponRate(), this);
		processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
		processor.processBasic(path.newSubPath("parValue"), BigDecimal.class, getParValue(), this);
		processor.processBasic(path.newSubPath("faceAmount"), BigDecimal.class, getFaceAmount(), this);
		processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.class, getPaymentFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BondBuilder extends Bond, UnderlyingAsset.UnderlyingAssetBuilder {
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
		@Override
		Bond.BondBuilder setId(String id);
		@Override
		Bond.BondBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Bond.BondBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Bond.BondBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Bond.BondBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Bond.BondBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Bond.BondBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Bond.BondBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Bond.BondBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Bond.BondBuilder setDescription(String description);
		@Override
		Bond.BondBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Bond.BondBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		Bond.BondBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		Bond.BondBuilder setDefinition(ProductReference definition);
		Bond.BondBuilder setIssuerName(String issuerName);
		Bond.BondBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		Bond.BondBuilder setSeniority(CreditSeniority seniority);
		Bond.BondBuilder addCreditQuality(CreditQuality creditQuality);
		Bond.BondBuilder addCreditQuality(CreditQuality creditQuality, int idx);
		Bond.BondBuilder addCreditQuality(List<? extends CreditQuality> creditQuality);
		Bond.BondBuilder setCreditQuality(List<? extends CreditQuality> creditQuality);
		Bond.BondBuilder addCreditRating(CreditRating creditRating);
		Bond.BondBuilder addCreditRating(CreditRating creditRating, int idx);
		Bond.BondBuilder addCreditRating(List<? extends CreditRating> creditRating);
		Bond.BondBuilder setCreditRating(List<? extends CreditRating> creditRating);
		Bond.BondBuilder setCouponType(CouponType couponType);
		Bond.BondBuilder setCouponRate(BigDecimal couponRate);
		Bond.BondBuilder setMaturity(ZonedDateTime maturity);
		Bond.BondBuilder setParValue(BigDecimal parValue);
		Bond.BondBuilder setFaceAmount(BigDecimal faceAmount);
		Bond.BondBuilder setPaymentFrequency(Frequency paymentFrequency);
		Bond.BondBuilder setDayCountFraction(DayCountFraction dayCountFraction);

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
			processor.processBasic(path.newSubPath("issuerName"), String.class, getIssuerName(), this);
			processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuerPartyReference());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processRosetta(path.newSubPath("creditQuality"), processor, CreditQuality.CreditQualityBuilder.class, getCreditQuality());
			processRosetta(path.newSubPath("creditRating"), processor, CreditRating.CreditRatingBuilder.class, getCreditRating());
			processRosetta(path.newSubPath("couponType"), processor, CouponType.CouponTypeBuilder.class, getCouponType());
			processor.processBasic(path.newSubPath("couponRate"), BigDecimal.class, getCouponRate(), this);
			processor.processBasic(path.newSubPath("maturity"), ZonedDateTime.class, getMaturity(), this);
			processor.processBasic(path.newSubPath("parValue"), BigDecimal.class, getParValue(), this);
			processor.processBasic(path.newSubPath("faceAmount"), BigDecimal.class, getFaceAmount(), this);
			processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.FrequencyBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		Bond.BondBuilder prune();
	}

	/*********************** Immutable Implementation of Bond  ***********************/
	class BondImpl extends UnderlyingAsset.UnderlyingAssetImpl implements Bond {
		private final String issuerName;
		private final PartyReference issuerPartyReference;
		private final CreditSeniority seniority;
		private final List<? extends CreditQuality> creditQuality;
		private final List<? extends CreditRating> creditRating;
		private final CouponType couponType;
		private final BigDecimal couponRate;
		private final ZonedDateTime maturity;
		private final BigDecimal parValue;
		private final BigDecimal faceAmount;
		private final Frequency paymentFrequency;
		private final DayCountFraction dayCountFraction;
		
		protected BondImpl(Bond.BondBuilder builder) {
			super(builder);
			this.issuerName = builder.getIssuerName();
			this.issuerPartyReference = ofNullable(builder.getIssuerPartyReference()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.creditQuality = ofNullable(builder.getCreditQuality()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditRating = ofNullable(builder.getCreditRating()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.couponType = ofNullable(builder.getCouponType()).map(f->f.build()).orElse(null);
			this.couponRate = builder.getCouponRate();
			this.maturity = builder.getMaturity();
			this.parValue = builder.getParValue();
			this.faceAmount = builder.getFaceAmount();
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("parValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parValue")
		public BigDecimal getParValue() {
			return parValue;
		}
		
		@Override
		@RosettaAttribute("faceAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("faceAmount")
		public BigDecimal getFaceAmount() {
			return faceAmount;
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
		public Bond build() {
			return this;
		}
		
		@Override
		public Bond.BondBuilder toBuilder() {
			Bond.BondBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Bond.BondBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIssuerName()).ifPresent(builder::setIssuerName);
			ofNullable(getIssuerPartyReference()).ifPresent(builder::setIssuerPartyReference);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getCreditQuality()).ifPresent(builder::setCreditQuality);
			ofNullable(getCreditRating()).ifPresent(builder::setCreditRating);
			ofNullable(getCouponType()).ifPresent(builder::setCouponType);
			ofNullable(getCouponRate()).ifPresent(builder::setCouponRate);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
			ofNullable(getParValue()).ifPresent(builder::setParValue);
			ofNullable(getFaceAmount()).ifPresent(builder::setFaceAmount);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Bond _that = getType().cast(o);
		
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(creditQuality, _that.getCreditQuality())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(couponType, _that.getCouponType())) return false;
			if (!Objects.equals(couponRate, _that.getCouponRate())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(parValue, _that.getParValue())) return false;
			if (!Objects.equals(faceAmount, _that.getFaceAmount())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (creditQuality != null ? creditQuality.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (couponType != null ? couponType.hashCode() : 0);
			_result = 31 * _result + (couponRate != null ? couponRate.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (parValue != null ? parValue.hashCode() : 0);
			_result = 31 * _result + (faceAmount != null ? faceAmount.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Bond {" +
				"issuerName=" + this.issuerName + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"seniority=" + this.seniority + ", " +
				"creditQuality=" + this.creditQuality + ", " +
				"creditRating=" + this.creditRating + ", " +
				"couponType=" + this.couponType + ", " +
				"couponRate=" + this.couponRate + ", " +
				"maturity=" + this.maturity + ", " +
				"parValue=" + this.parValue + ", " +
				"faceAmount=" + this.faceAmount + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Bond  ***********************/
	class BondBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements Bond.BondBuilder {
	
		protected String issuerName;
		protected PartyReference.PartyReferenceBuilder issuerPartyReference;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected List<CreditQuality.CreditQualityBuilder> creditQuality = new ArrayList<>();
		protected List<CreditRating.CreditRatingBuilder> creditRating = new ArrayList<>();
		protected CouponType.CouponTypeBuilder couponType;
		protected BigDecimal couponRate;
		protected ZonedDateTime maturity;
		protected BigDecimal parValue;
		protected BigDecimal faceAmount;
		protected Frequency.FrequencyBuilder paymentFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		
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
		@RosettaAttribute("parValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parValue")
		public BigDecimal getParValue() {
			return parValue;
		}
		
		@Override
		@RosettaAttribute("faceAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("faceAmount")
		public BigDecimal getFaceAmount() {
			return faceAmount;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Bond.BondBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Bond.BondBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Bond.BondBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Bond.BondBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Bond.BondBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Bond.BondBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Bond.BondBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Bond.BondBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Bond.BondBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Bond.BondBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Bond.BondBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Bond.BondBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public Bond.BondBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public Bond.BondBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuerName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerName")
		@Override
		public Bond.BondBuilder setIssuerName(String _issuerName) {
			this.issuerName = _issuerName == null ? null : _issuerName;
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerPartyReference")
		@Override
		public Bond.BondBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public Bond.BondBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public Bond.BondBuilder addCreditQuality(CreditQuality _creditQuality) {
			if (_creditQuality != null) {
				this.creditQuality.add(_creditQuality.toBuilder());
			}
			return this;
		}
		
		@Override
		public Bond.BondBuilder addCreditQuality(CreditQuality _creditQuality, int idx) {
			getIndex(this.creditQuality, idx, () -> _creditQuality.toBuilder());
			return this;
		}
		
		@Override
		public Bond.BondBuilder addCreditQuality(List<? extends CreditQuality> creditQualitys) {
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
		public Bond.BondBuilder setCreditQuality(List<? extends CreditQuality> creditQualitys) {
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
		public Bond.BondBuilder addCreditRating(CreditRating _creditRating) {
			if (_creditRating != null) {
				this.creditRating.add(_creditRating.toBuilder());
			}
			return this;
		}
		
		@Override
		public Bond.BondBuilder addCreditRating(CreditRating _creditRating, int idx) {
			getIndex(this.creditRating, idx, () -> _creditRating.toBuilder());
			return this;
		}
		
		@Override
		public Bond.BondBuilder addCreditRating(List<? extends CreditRating> creditRatings) {
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
		public Bond.BondBuilder setCreditRating(List<? extends CreditRating> creditRatings) {
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
		public Bond.BondBuilder setCouponType(CouponType _couponType) {
			this.couponType = _couponType == null ? null : _couponType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("couponRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponRate")
		@Override
		public Bond.BondBuilder setCouponRate(BigDecimal _couponRate) {
			this.couponRate = _couponRate == null ? null : _couponRate;
			return this;
		}
		
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturity")
		@Override
		public Bond.BondBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@RosettaAttribute("parValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parValue")
		@Override
		public Bond.BondBuilder setParValue(BigDecimal _parValue) {
			this.parValue = _parValue == null ? null : _parValue;
			return this;
		}
		
		@RosettaAttribute("faceAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("faceAmount")
		@Override
		public Bond.BondBuilder setFaceAmount(BigDecimal _faceAmount) {
			this.faceAmount = _faceAmount == null ? null : _faceAmount;
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public Bond.BondBuilder setPaymentFrequency(Frequency _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public Bond.BondBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public Bond build() {
			return new Bond.BondImpl(this);
		}
		
		@Override
		public Bond.BondBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bond.BondBuilder prune() {
			super.prune();
			if (issuerPartyReference!=null && !issuerPartyReference.prune().hasData()) issuerPartyReference = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			creditQuality = creditQuality.stream().filter(b->b!=null).<CreditQuality.CreditQualityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditRating = creditRating.stream().filter(b->b!=null).<CreditRating.CreditRatingBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (couponType!=null && !couponType.prune().hasData()) couponType = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIssuerName()!=null) return true;
			if (getIssuerPartyReference()!=null && getIssuerPartyReference().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getCreditQuality()!=null && getCreditQuality().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditRating()!=null && getCreditRating().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCouponType()!=null && getCouponType().hasData()) return true;
			if (getCouponRate()!=null) return true;
			if (getMaturity()!=null) return true;
			if (getParValue()!=null) return true;
			if (getFaceAmount()!=null) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bond.BondBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Bond.BondBuilder o = (Bond.BondBuilder) other;
			
			merger.mergeRosetta(getIssuerPartyReference(), o.getIssuerPartyReference(), this::setIssuerPartyReference);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getCreditQuality(), o.getCreditQuality(), this::getOrCreateCreditQuality);
			merger.mergeRosetta(getCreditRating(), o.getCreditRating(), this::getOrCreateCreditRating);
			merger.mergeRosetta(getCouponType(), o.getCouponType(), this::setCouponType);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			merger.mergeBasic(getIssuerName(), o.getIssuerName(), this::setIssuerName);
			merger.mergeBasic(getCouponRate(), o.getCouponRate(), this::setCouponRate);
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			merger.mergeBasic(getParValue(), o.getParValue(), this::setParValue);
			merger.mergeBasic(getFaceAmount(), o.getFaceAmount(), this::setFaceAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Bond _that = getType().cast(o);
		
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!ListEquals.listEquals(creditQuality, _that.getCreditQuality())) return false;
			if (!ListEquals.listEquals(creditRating, _that.getCreditRating())) return false;
			if (!Objects.equals(couponType, _that.getCouponType())) return false;
			if (!Objects.equals(couponRate, _that.getCouponRate())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(parValue, _that.getParValue())) return false;
			if (!Objects.equals(faceAmount, _that.getFaceAmount())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (creditQuality != null ? creditQuality.hashCode() : 0);
			_result = 31 * _result + (creditRating != null ? creditRating.hashCode() : 0);
			_result = 31 * _result + (couponType != null ? couponType.hashCode() : 0);
			_result = 31 * _result + (couponRate != null ? couponRate.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (parValue != null ? parValue.hashCode() : 0);
			_result = 31 * _result + (faceAmount != null ? faceAmount.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondBuilder {" +
				"issuerName=" + this.issuerName + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"seniority=" + this.seniority + ", " +
				"creditQuality=" + this.creditQuality + ", " +
				"creditRating=" + this.creditRating + ", " +
				"couponType=" + this.couponType + ", " +
				"couponRate=" + this.couponRate + ", " +
				"maturity=" + this.maturity + ", " +
				"parValue=" + this.parValue + ", " +
				"faceAmount=" + this.faceAmount + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}
}

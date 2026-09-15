package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.ConvertibleBondMeta;
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
 * Provision Identifies the underlying asset when it is a convertible bond.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies the underlying asset when it is a convertible bond.
 *
 */
@RosettaDataType(value="ConvertibleBond", builder=ConvertibleBond.ConvertibleBondBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ConvertibleBond", model="fpml", builder=ConvertibleBond.ConvertibleBondBuilderImpl.class, version="2.1.1")
public interface ConvertibleBond extends Bond {

	ConvertibleBondMeta metaData = new ConvertibleBondMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the equity in which the convertible bond can be converted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the equity in which the convertible bond can be converted.
	 *
	 */
	EquityAsset getUnderlyingEquity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Earlier date between the convertible bond put dates and its maturity date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Earlier date between the convertible bond put dates and its maturity date.
	 *
	 */
	ZonedDateTime getRedemptionDate();

	/*********************** Build Methods  ***********************/
	ConvertibleBond build();
	
	ConvertibleBond.ConvertibleBondBuilder toBuilder();
	
	static ConvertibleBond.ConvertibleBondBuilder builder() {
		return new ConvertibleBond.ConvertibleBondBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConvertibleBond> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConvertibleBond> getType() {
		return ConvertibleBond.class;
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
		processRosetta(path.newSubPath("underlyingEquity"), processor, EquityAsset.class, getUnderlyingEquity());
		processor.processBasic(path.newSubPath("redemptionDate"), ZonedDateTime.class, getRedemptionDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConvertibleBondBuilder extends ConvertibleBond, Bond.BondBuilder {
		EquityAsset.EquityAssetBuilder getOrCreateUnderlyingEquity();
		@Override
		EquityAsset.EquityAssetBuilder getUnderlyingEquity();
		@Override
		ConvertibleBond.ConvertibleBondBuilder setId(String id);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setDescription(String description);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setDefinition(ProductReference definition);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setIssuerName(String issuerName);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setSeniority(CreditSeniority seniority);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addCreditQuality(CreditQuality creditQuality);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addCreditQuality(CreditQuality creditQuality, int idx);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addCreditQuality(List<? extends CreditQuality> creditQuality);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setCreditQuality(List<? extends CreditQuality> creditQuality);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addCreditRating(CreditRating creditRating);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addCreditRating(CreditRating creditRating, int idx);
		@Override
		ConvertibleBond.ConvertibleBondBuilder addCreditRating(List<? extends CreditRating> creditRating);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setCreditRating(List<? extends CreditRating> creditRating);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setCouponType(CouponType couponType);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setCouponRate(BigDecimal couponRate);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setMaturity(ZonedDateTime maturity);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setParValue(BigDecimal parValue);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setFaceAmount(BigDecimal faceAmount);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setPaymentFrequency(Frequency paymentFrequency);
		@Override
		ConvertibleBond.ConvertibleBondBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		ConvertibleBond.ConvertibleBondBuilder setUnderlyingEquity(EquityAsset underlyingEquity);
		ConvertibleBond.ConvertibleBondBuilder setRedemptionDate(ZonedDateTime redemptionDate);

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
			processRosetta(path.newSubPath("underlyingEquity"), processor, EquityAsset.EquityAssetBuilder.class, getUnderlyingEquity());
			processor.processBasic(path.newSubPath("redemptionDate"), ZonedDateTime.class, getRedemptionDate(), this);
		}
		

		ConvertibleBond.ConvertibleBondBuilder prune();
	}

	/*********************** Immutable Implementation of ConvertibleBond  ***********************/
	class ConvertibleBondImpl extends Bond.BondImpl implements ConvertibleBond {
		private final EquityAsset underlyingEquity;
		private final ZonedDateTime redemptionDate;
		
		protected ConvertibleBondImpl(ConvertibleBond.ConvertibleBondBuilder builder) {
			super(builder);
			this.underlyingEquity = ofNullable(builder.getUnderlyingEquity()).map(f->f.build()).orElse(null);
			this.redemptionDate = builder.getRedemptionDate();
		}
		
		@Override
		@RosettaAttribute("underlyingEquity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingEquity")
		public EquityAsset getUnderlyingEquity() {
			return underlyingEquity;
		}
		
		@Override
		@RosettaAttribute("redemptionDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("redemptionDate")
		public ZonedDateTime getRedemptionDate() {
			return redemptionDate;
		}
		
		@Override
		public ConvertibleBond build() {
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder toBuilder() {
			ConvertibleBond.ConvertibleBondBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConvertibleBond.ConvertibleBondBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlyingEquity()).ifPresent(builder::setUnderlyingEquity);
			ofNullable(getRedemptionDate()).ifPresent(builder::setRedemptionDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConvertibleBond _that = getType().cast(o);
		
			if (!Objects.equals(underlyingEquity, _that.getUnderlyingEquity())) return false;
			if (!Objects.equals(redemptionDate, _that.getRedemptionDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyingEquity != null ? underlyingEquity.hashCode() : 0);
			_result = 31 * _result + (redemptionDate != null ? redemptionDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConvertibleBond {" +
				"underlyingEquity=" + this.underlyingEquity + ", " +
				"redemptionDate=" + this.redemptionDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConvertibleBond  ***********************/
	class ConvertibleBondBuilderImpl extends Bond.BondBuilderImpl implements ConvertibleBond.ConvertibleBondBuilder {
	
		protected EquityAsset.EquityAssetBuilder underlyingEquity;
		protected ZonedDateTime redemptionDate;
		
		@Override
		@RosettaAttribute("underlyingEquity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingEquity")
		public EquityAsset.EquityAssetBuilder getUnderlyingEquity() {
			return underlyingEquity;
		}
		
		@Override
		public EquityAsset.EquityAssetBuilder getOrCreateUnderlyingEquity() {
			EquityAsset.EquityAssetBuilder result;
			if (underlyingEquity!=null) {
				result = underlyingEquity;
			}
			else {
				result = underlyingEquity = EquityAsset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("redemptionDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("redemptionDate")
		public ZonedDateTime getRedemptionDate() {
			return redemptionDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ConvertibleBond.ConvertibleBondBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ConvertibleBond.ConvertibleBondBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ConvertibleBond.ConvertibleBondBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuerName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerName")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setIssuerName(String _issuerName) {
			this.issuerName = _issuerName == null ? null : _issuerName;
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerPartyReference")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditQuality")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditQuality")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addCreditQuality(CreditQuality _creditQuality) {
			if (_creditQuality != null) {
				this.creditQuality.add(_creditQuality.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addCreditQuality(CreditQuality _creditQuality, int idx) {
			getIndex(this.creditQuality, idx, () -> _creditQuality.toBuilder());
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addCreditQuality(List<? extends CreditQuality> creditQualitys) {
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
		public ConvertibleBond.ConvertibleBondBuilder setCreditQuality(List<? extends CreditQuality> creditQualitys) {
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
		public ConvertibleBond.ConvertibleBondBuilder addCreditRating(CreditRating _creditRating) {
			if (_creditRating != null) {
				this.creditRating.add(_creditRating.toBuilder());
			}
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addCreditRating(CreditRating _creditRating, int idx) {
			getIndex(this.creditRating, idx, () -> _creditRating.toBuilder());
			return this;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder addCreditRating(List<? extends CreditRating> creditRatings) {
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
		public ConvertibleBond.ConvertibleBondBuilder setCreditRating(List<? extends CreditRating> creditRatings) {
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
		public ConvertibleBond.ConvertibleBondBuilder setCouponType(CouponType _couponType) {
			this.couponType = _couponType == null ? null : _couponType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("couponRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponRate")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setCouponRate(BigDecimal _couponRate) {
			this.couponRate = _couponRate == null ? null : _couponRate;
			return this;
		}
		
		@RosettaAttribute("maturity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturity")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setMaturity(ZonedDateTime _maturity) {
			this.maturity = _maturity == null ? null : _maturity;
			return this;
		}
		
		@RosettaAttribute("parValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parValue")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setParValue(BigDecimal _parValue) {
			this.parValue = _parValue == null ? null : _parValue;
			return this;
		}
		
		@RosettaAttribute("faceAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("faceAmount")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setFaceAmount(BigDecimal _faceAmount) {
			this.faceAmount = _faceAmount == null ? null : _faceAmount;
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setPaymentFrequency(Frequency _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyingEquity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingEquity")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setUnderlyingEquity(EquityAsset _underlyingEquity) {
			this.underlyingEquity = _underlyingEquity == null ? null : _underlyingEquity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("redemptionDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("redemptionDate")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder setRedemptionDate(ZonedDateTime _redemptionDate) {
			this.redemptionDate = _redemptionDate == null ? null : _redemptionDate;
			return this;
		}
		
		@Override
		public ConvertibleBond build() {
			return new ConvertibleBond.ConvertibleBondImpl(this);
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder prune() {
			super.prune();
			if (underlyingEquity!=null && !underlyingEquity.prune().hasData()) underlyingEquity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlyingEquity()!=null && getUnderlyingEquity().hasData()) return true;
			if (getRedemptionDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConvertibleBond.ConvertibleBondBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ConvertibleBond.ConvertibleBondBuilder o = (ConvertibleBond.ConvertibleBondBuilder) other;
			
			merger.mergeRosetta(getUnderlyingEquity(), o.getUnderlyingEquity(), this::setUnderlyingEquity);
			
			merger.mergeBasic(getRedemptionDate(), o.getRedemptionDate(), this::setRedemptionDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConvertibleBond _that = getType().cast(o);
		
			if (!Objects.equals(underlyingEquity, _that.getUnderlyingEquity())) return false;
			if (!Objects.equals(redemptionDate, _that.getRedemptionDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyingEquity != null ? underlyingEquity.hashCode() : 0);
			_result = 31 * _result + (redemptionDate != null ? redemptionDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConvertibleBondBuilder {" +
				"underlyingEquity=" + this.underlyingEquity + ", " +
				"redemptionDate=" + this.redemptionDate +
			'}' + " " + super.toString();
		}
	}
}

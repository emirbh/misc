package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.DualCurrencyFeatureMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
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
 * Provision Describes the parameters for a dual currency option transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the parameters for a dual currency option transaction.
 *
 */
@RosettaDataType(value="DualCurrencyFeature", builder=DualCurrencyFeature.DualCurrencyFeatureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DualCurrencyFeature", model="fpml", builder=DualCurrencyFeature.DualCurrencyFeatureBuilderImpl.class, version="2.1.1")
public interface DualCurrencyFeature extends RosettaModelObject {

	DualCurrencyFeatureMeta metaData = new DualCurrencyFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Alternate currency i.e. the currency in which the deposit will be redeemed in the event that the spot rate fixes below the strike rate at the specified fixing date and time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Alternate currency i.e. the currency in which the deposit will be redeemed in the event that the spot rate fixes below the strike rate at the specified fixing date and time.
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the fx spot rate is compared against the strike rate, in order to determine the delivery currency. This is the expiry date of a put option on the Deposit/Alternate currency couple. Also known as "valuation date" or "reference date".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the fx spot rate is compared against the strike rate, in order to determine the delivery currency. This is the expiry date of a put option on the Deposit/Alternate currency couple. Also known as "valuation date" or "reference date".
	 *
	 */
	ZonedDateTime getFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time at which the fx spot rate observation is made i.e. the option cut off time on the expiry date. Also known as "valuation time".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which the fx spot rate observation is made i.e. the option cut off time on the expiry date. Also known as "valuation time".
	 *
	 */
	BusinessCenterTime getFixingTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate at which the deposit will be converted to the Alternate currency, in the event that the spot rate is strictly lower than the strike rate at the specified fixing date and time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate at which the deposit will be converted to the Alternate currency, in the event that the spot rate is strictly lower than the strike rate at the specified fixing date and time.
	 *
	 */
	DualCurrencyStrikePrice getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The spot rate at the time the trade was agreed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The spot rate at the time the trade was agreed.
	 *
	 */
	BigDecimal getSpotRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the interest component of the redemption amount is subject to conversion to the Alternate currency, in the event that the spot rate is strictly lower than the strike rate at the specified fixing date and time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the interest component of the redemption amount is subject to conversion to the Alternate currency, in the event that the spot rate is strictly lower than the strike rate at the specified fixing date and time.
	 *
	 */
	Boolean getInterestAtRisk();

	/*********************** Build Methods  ***********************/
	DualCurrencyFeature build();
	
	DualCurrencyFeature.DualCurrencyFeatureBuilder toBuilder();
	
	static DualCurrencyFeature.DualCurrencyFeatureBuilder builder() {
		return new DualCurrencyFeature.DualCurrencyFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DualCurrencyFeature> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DualCurrencyFeature> getType() {
		return DualCurrencyFeature.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("strike"), processor, DualCurrencyStrikePrice.class, getStrike());
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processor.processBasic(path.newSubPath("interestAtRisk"), Boolean.class, getInterestAtRisk(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DualCurrencyFeatureBuilder extends DualCurrencyFeature, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getOrCreateStrike();
		@Override
		DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getStrike();
		DualCurrencyFeature.DualCurrencyFeatureBuilder setCurrency(Currency currency);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingDate(ZonedDateTime fixingDate);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingTime(BusinessCenterTime fixingTime);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setStrike(DualCurrencyStrikePrice strike);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setSpotRate(BigDecimal spotRate);
		DualCurrencyFeature.DualCurrencyFeatureBuilder setInterestAtRisk(Boolean interestAtRisk);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("strike"), processor, DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder.class, getStrike());
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processor.processBasic(path.newSubPath("interestAtRisk"), Boolean.class, getInterestAtRisk(), this);
		}
		

		DualCurrencyFeature.DualCurrencyFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of DualCurrencyFeature  ***********************/
	class DualCurrencyFeatureImpl implements DualCurrencyFeature {
		private final Currency currency;
		private final ZonedDateTime fixingDate;
		private final BusinessCenterTime fixingTime;
		private final DualCurrencyStrikePrice strike;
		private final BigDecimal spotRate;
		private final Boolean interestAtRisk;
		
		protected DualCurrencyFeatureImpl(DualCurrencyFeature.DualCurrencyFeatureBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.fixingDate = builder.getFixingDate();
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.spotRate = builder.getSpotRate();
			this.interestAtRisk = builder.getInterestAtRisk();
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public DualCurrencyStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("interestAtRisk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestAtRisk")
		public Boolean getInterestAtRisk() {
			return interestAtRisk;
		}
		
		@Override
		public DualCurrencyFeature build() {
			return this;
		}
		
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder toBuilder() {
			DualCurrencyFeature.DualCurrencyFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DualCurrencyFeature.DualCurrencyFeatureBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getSpotRate()).ifPresent(builder::setSpotRate);
			ofNullable(getInterestAtRisk()).ifPresent(builder::setInterestAtRisk);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyFeature _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(interestAtRisk, _that.getInterestAtRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (interestAtRisk != null ? interestAtRisk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualCurrencyFeature {" +
				"currency=" + this.currency + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"interestAtRisk=" + this.interestAtRisk +
			'}';
		}
	}

	/*********************** Builder Implementation of DualCurrencyFeature  ***********************/
	class DualCurrencyFeatureBuilderImpl implements DualCurrencyFeature.DualCurrencyFeatureBuilder {
	
		protected Currency.CurrencyBuilder currency;
		protected ZonedDateTime fixingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder strike;
		protected BigDecimal spotRate;
		protected Boolean interestAtRisk;
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder getOrCreateStrike() {
			DualCurrencyStrikePrice.DualCurrencyStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = DualCurrencyStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spotRate")
		public BigDecimal getSpotRate() {
			return spotRate;
		}
		
		@Override
		@RosettaAttribute("interestAtRisk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestAtRisk")
		public Boolean getInterestAtRisk() {
			return interestAtRisk;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setFixingTime(BusinessCenterTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setStrike(DualCurrencyStrikePrice _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("interestAtRisk")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestAtRisk")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder setInterestAtRisk(Boolean _interestAtRisk) {
			this.interestAtRisk = _interestAtRisk == null ? null : _interestAtRisk;
			return this;
		}
		
		@Override
		public DualCurrencyFeature build() {
			return new DualCurrencyFeature.DualCurrencyFeatureImpl(this);
		}
		
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getSpotRate()!=null) return true;
			if (getInterestAtRisk()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DualCurrencyFeature.DualCurrencyFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DualCurrencyFeature.DualCurrencyFeatureBuilder o = (DualCurrencyFeature.DualCurrencyFeatureBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			merger.mergeBasic(getSpotRate(), o.getSpotRate(), this::setSpotRate);
			merger.mergeBasic(getInterestAtRisk(), o.getInterestAtRisk(), this::setInterestAtRisk);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DualCurrencyFeature _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(spotRate, _that.getSpotRate())) return false;
			if (!Objects.equals(interestAtRisk, _that.getInterestAtRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (spotRate != null ? spotRate.hashCode() : 0);
			_result = 31 * _result + (interestAtRisk != null ? interestAtRisk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DualCurrencyFeatureBuilder {" +
				"currency=" + this.currency + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"strike=" + this.strike + ", " +
				"spotRate=" + this.spotRate + ", " +
				"interestAtRisk=" + this.interestAtRisk +
			'}';
		}
	}
}

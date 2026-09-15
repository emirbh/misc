package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.SingleUnderlyerMeta;
import fpml.consolidated.shared.AverageDailyTradingVolumeLimit;
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
 * Provision A type describing a single underlyer
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a single underlyer
 *
 */
@RosettaDataType(value="SingleUnderlyer", builder=SingleUnderlyer.SingleUnderlyerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SingleUnderlyer", model="fpml", builder=SingleUnderlyer.SingleUnderlyerBuilderImpl.class, version="2.1.1")
public interface SingleUnderlyer extends RosettaModelObject {

	SingleUnderlyerMeta metaData = new SingleUnderlyerMeta();

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
	Asset getUnderlyingAsset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of units (index or securities) that constitute the underlyer of the swap. In the case of a basket swap, this element is used to reference both the number of basket units, and the number of each asset components of the basket when these are expressed in absolute terms.
	 *
	 */
	BigDecimal getOpenUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the dividend payout ratio associated with an equity underlyer. A basket swap can have different payout ratios across the various underlying constituents. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified. Users should note that FpML makes a distinction between the derivative contract and the underlyer of the contract. It would be better if the agreed dividend payout on a derivative contract was modelled at the level of the derivative contract, an approach which may be adopted in the next major version of FpML.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the dividend payout ratio associated with an equity underlyer. A basket swap can have different payout ratios across the various underlying constituents. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified. Users should note that FpML makes a distinction between the derivative contract and the underlyer of the contract. It would be better if the agreed dividend payout on a derivative contract was modelled at the level of the derivative contract, an approach which may be adopted in the next major version of FpML.
	 *
	 */
	DividendPayout getDividendPayout();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The next upcoming coupon payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The next upcoming coupon payment.
	 *
	 */
	PendingPayment getCouponPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The average amount of individual securities traded in a day or over a specified amount of time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The average amount of individual securities traded in a day or over a specified amount of time.
	 *
	 */
	AverageDailyTradingVolumeLimit getAverageDailyTradingVolume();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A Depository Receipt is a negotiable certificate issued by a trust company or security depository. This element is used to represent whether a Depository Receipt is applicable or not to the underlyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A Depository Receipt is a negotiable certificate issued by a trust company or security depository. This element is used to represent whether a Depository Receipt is applicable or not to the underlyer.
	 *
	 */
	Boolean getDepositoryReceipt();

	/*********************** Build Methods  ***********************/
	SingleUnderlyer build();
	
	SingleUnderlyer.SingleUnderlyerBuilder toBuilder();
	
	static SingleUnderlyer.SingleUnderlyerBuilder builder() {
		return new SingleUnderlyer.SingleUnderlyerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SingleUnderlyer> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SingleUnderlyer> getType() {
		return SingleUnderlyer.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
		processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.class, getDividendPayout());
		processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.class, getCouponPayment());
		processRosetta(path.newSubPath("averageDailyTradingVolume"), processor, AverageDailyTradingVolumeLimit.class, getAverageDailyTradingVolume());
		processor.processBasic(path.newSubPath("depositoryReceipt"), Boolean.class, getDepositoryReceipt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SingleUnderlyerBuilder extends SingleUnderlyer, RosettaModelObjectBuilder {
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		@Override
		Asset.AssetBuilder getUnderlyingAsset();
		DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout();
		@Override
		DividendPayout.DividendPayoutBuilder getDividendPayout();
		PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment();
		@Override
		PendingPayment.PendingPaymentBuilder getCouponPayment();
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getOrCreateAverageDailyTradingVolume();
		@Override
		AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getAverageDailyTradingVolume();
		SingleUnderlyer.SingleUnderlyerBuilder setUnderlyingAsset(Asset underlyingAsset);
		SingleUnderlyer.SingleUnderlyerBuilder setOpenUnits(BigDecimal openUnits);
		SingleUnderlyer.SingleUnderlyerBuilder setDividendPayout(DividendPayout dividendPayout);
		SingleUnderlyer.SingleUnderlyerBuilder setCouponPayment(PendingPayment couponPayment);
		SingleUnderlyer.SingleUnderlyerBuilder setAverageDailyTradingVolume(AverageDailyTradingVolumeLimit averageDailyTradingVolume);
		SingleUnderlyer.SingleUnderlyerBuilder setDepositoryReceipt(Boolean depositoryReceipt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processor.processBasic(path.newSubPath("openUnits"), BigDecimal.class, getOpenUnits(), this);
			processRosetta(path.newSubPath("dividendPayout"), processor, DividendPayout.DividendPayoutBuilder.class, getDividendPayout());
			processRosetta(path.newSubPath("couponPayment"), processor, PendingPayment.PendingPaymentBuilder.class, getCouponPayment());
			processRosetta(path.newSubPath("averageDailyTradingVolume"), processor, AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder.class, getAverageDailyTradingVolume());
			processor.processBasic(path.newSubPath("depositoryReceipt"), Boolean.class, getDepositoryReceipt(), this);
		}
		

		SingleUnderlyer.SingleUnderlyerBuilder prune();
	}

	/*********************** Immutable Implementation of SingleUnderlyer  ***********************/
	class SingleUnderlyerImpl implements SingleUnderlyer {
		private final Asset underlyingAsset;
		private final BigDecimal openUnits;
		private final DividendPayout dividendPayout;
		private final PendingPayment couponPayment;
		private final AverageDailyTradingVolumeLimit averageDailyTradingVolume;
		private final Boolean depositoryReceipt;
		
		protected SingleUnderlyerImpl(SingleUnderlyer.SingleUnderlyerBuilder builder) {
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.openUnits = builder.getOpenUnits();
			this.dividendPayout = ofNullable(builder.getDividendPayout()).map(f->f.build()).orElse(null);
			this.couponPayment = ofNullable(builder.getCouponPayment()).map(f->f.build()).orElse(null);
			this.averageDailyTradingVolume = ofNullable(builder.getAverageDailyTradingVolume()).map(f->f.build()).orElse(null);
			this.depositoryReceipt = builder.getDepositoryReceipt();
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayout")
		public DividendPayout getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponPayment")
		public PendingPayment getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		@RosettaAttribute("averageDailyTradingVolume")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageDailyTradingVolume")
		public AverageDailyTradingVolumeLimit getAverageDailyTradingVolume() {
			return averageDailyTradingVolume;
		}
		
		@Override
		@RosettaAttribute("depositoryReceipt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("depositoryReceipt")
		public Boolean getDepositoryReceipt() {
			return depositoryReceipt;
		}
		
		@Override
		public SingleUnderlyer build() {
			return this;
		}
		
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder toBuilder() {
			SingleUnderlyer.SingleUnderlyerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SingleUnderlyer.SingleUnderlyerBuilder builder) {
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getOpenUnits()).ifPresent(builder::setOpenUnits);
			ofNullable(getDividendPayout()).ifPresent(builder::setDividendPayout);
			ofNullable(getCouponPayment()).ifPresent(builder::setCouponPayment);
			ofNullable(getAverageDailyTradingVolume()).ifPresent(builder::setAverageDailyTradingVolume);
			ofNullable(getDepositoryReceipt()).ifPresent(builder::setDepositoryReceipt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			if (!Objects.equals(averageDailyTradingVolume, _that.getAverageDailyTradingVolume())) return false;
			if (!Objects.equals(depositoryReceipt, _that.getDepositoryReceipt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			_result = 31 * _result + (averageDailyTradingVolume != null ? averageDailyTradingVolume.hashCode() : 0);
			_result = 31 * _result + (depositoryReceipt != null ? depositoryReceipt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleUnderlyer {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"openUnits=" + this.openUnits + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"couponPayment=" + this.couponPayment + ", " +
				"averageDailyTradingVolume=" + this.averageDailyTradingVolume + ", " +
				"depositoryReceipt=" + this.depositoryReceipt +
			'}';
		}
	}

	/*********************** Builder Implementation of SingleUnderlyer  ***********************/
	class SingleUnderlyerBuilderImpl implements SingleUnderlyer.SingleUnderlyerBuilder {
	
		protected Asset.AssetBuilder underlyingAsset;
		protected BigDecimal openUnits;
		protected DividendPayout.DividendPayoutBuilder dividendPayout;
		protected PendingPayment.PendingPaymentBuilder couponPayment;
		protected AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder averageDailyTradingVolume;
		protected Boolean depositoryReceipt;
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("openUnits")
		public BigDecimal getOpenUnits() {
			return openUnits;
		}
		
		@Override
		@RosettaAttribute("dividendPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendPayout")
		public DividendPayout.DividendPayoutBuilder getDividendPayout() {
			return dividendPayout;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder getOrCreateDividendPayout() {
			DividendPayout.DividendPayoutBuilder result;
			if (dividendPayout!=null) {
				result = dividendPayout;
			}
			else {
				result = dividendPayout = DividendPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponPayment")
		public PendingPayment.PendingPaymentBuilder getCouponPayment() {
			return couponPayment;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder getOrCreateCouponPayment() {
			PendingPayment.PendingPaymentBuilder result;
			if (couponPayment!=null) {
				result = couponPayment;
			}
			else {
				result = couponPayment = PendingPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageDailyTradingVolume")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageDailyTradingVolume")
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getAverageDailyTradingVolume() {
			return averageDailyTradingVolume;
		}
		
		@Override
		public AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder getOrCreateAverageDailyTradingVolume() {
			AverageDailyTradingVolumeLimit.AverageDailyTradingVolumeLimitBuilder result;
			if (averageDailyTradingVolume!=null) {
				result = averageDailyTradingVolume;
			}
			else {
				result = averageDailyTradingVolume = AverageDailyTradingVolumeLimit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("depositoryReceipt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("depositoryReceipt")
		public Boolean getDepositoryReceipt() {
			return depositoryReceipt;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("underlyingAsset")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder setUnderlyingAsset(Asset _underlyingAsset) {
			this.underlyingAsset = _underlyingAsset == null ? null : _underlyingAsset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("openUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("openUnits")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder setOpenUnits(BigDecimal _openUnits) {
			this.openUnits = _openUnits == null ? null : _openUnits;
			return this;
		}
		
		@RosettaAttribute("dividendPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendPayout")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder setDividendPayout(DividendPayout _dividendPayout) {
			this.dividendPayout = _dividendPayout == null ? null : _dividendPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("couponPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponPayment")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder setCouponPayment(PendingPayment _couponPayment) {
			this.couponPayment = _couponPayment == null ? null : _couponPayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageDailyTradingVolume")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageDailyTradingVolume")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder setAverageDailyTradingVolume(AverageDailyTradingVolumeLimit _averageDailyTradingVolume) {
			this.averageDailyTradingVolume = _averageDailyTradingVolume == null ? null : _averageDailyTradingVolume.toBuilder();
			return this;
		}
		
		@RosettaAttribute("depositoryReceipt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("depositoryReceipt")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder setDepositoryReceipt(Boolean _depositoryReceipt) {
			this.depositoryReceipt = _depositoryReceipt == null ? null : _depositoryReceipt;
			return this;
		}
		
		@Override
		public SingleUnderlyer build() {
			return new SingleUnderlyer.SingleUnderlyerImpl(this);
		}
		
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder prune() {
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (dividendPayout!=null && !dividendPayout.prune().hasData()) dividendPayout = null;
			if (couponPayment!=null && !couponPayment.prune().hasData()) couponPayment = null;
			if (averageDailyTradingVolume!=null && !averageDailyTradingVolume.prune().hasData()) averageDailyTradingVolume = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getOpenUnits()!=null) return true;
			if (getDividendPayout()!=null && getDividendPayout().hasData()) return true;
			if (getCouponPayment()!=null && getCouponPayment().hasData()) return true;
			if (getAverageDailyTradingVolume()!=null && getAverageDailyTradingVolume().hasData()) return true;
			if (getDepositoryReceipt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleUnderlyer.SingleUnderlyerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SingleUnderlyer.SingleUnderlyerBuilder o = (SingleUnderlyer.SingleUnderlyerBuilder) other;
			
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getDividendPayout(), o.getDividendPayout(), this::setDividendPayout);
			merger.mergeRosetta(getCouponPayment(), o.getCouponPayment(), this::setCouponPayment);
			merger.mergeRosetta(getAverageDailyTradingVolume(), o.getAverageDailyTradingVolume(), this::setAverageDailyTradingVolume);
			
			merger.mergeBasic(getOpenUnits(), o.getOpenUnits(), this::setOpenUnits);
			merger.mergeBasic(getDepositoryReceipt(), o.getDepositoryReceipt(), this::setDepositoryReceipt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleUnderlyer _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(openUnits, _that.getOpenUnits())) return false;
			if (!Objects.equals(dividendPayout, _that.getDividendPayout())) return false;
			if (!Objects.equals(couponPayment, _that.getCouponPayment())) return false;
			if (!Objects.equals(averageDailyTradingVolume, _that.getAverageDailyTradingVolume())) return false;
			if (!Objects.equals(depositoryReceipt, _that.getDepositoryReceipt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (openUnits != null ? openUnits.hashCode() : 0);
			_result = 31 * _result + (dividendPayout != null ? dividendPayout.hashCode() : 0);
			_result = 31 * _result + (couponPayment != null ? couponPayment.hashCode() : 0);
			_result = 31 * _result + (averageDailyTradingVolume != null ? averageDailyTradingVolume.hashCode() : 0);
			_result = 31 * _result + (depositoryReceipt != null ? depositoryReceipt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleUnderlyerBuilder {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"openUnits=" + this.openUnits + ", " +
				"dividendPayout=" + this.dividendPayout + ", " +
				"couponPayment=" + this.couponPayment + ", " +
				"averageDailyTradingVolume=" + this.averageDailyTradingVolume + ", " +
				"depositoryReceipt=" + this.depositoryReceipt +
			'}';
		}
	}
}

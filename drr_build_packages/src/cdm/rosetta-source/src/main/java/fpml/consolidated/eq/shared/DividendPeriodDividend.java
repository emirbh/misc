package fpml.consolidated.eq.shared;

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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.eq.shared.meta.DividendPeriodDividendMeta;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A time bounded dividend period, with an expected dividend for each period.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A time bounded dividend period, with an expected dividend for each period.
 *
 */
@RosettaDataType(value="DividendPeriodDividend", builder=DividendPeriodDividend.DividendPeriodDividendBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendPeriodDividend", model="fpml", builder=DividendPeriodDividend.DividendPeriodDividendBuilderImpl.class, version="2.1.1")
public interface DividendPeriodDividend extends DividendPeriod {

	DividendPeriodDividendMeta metaData = new DividendPeriodDividendMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Expected dividend in this period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expected dividend in this period.
	 *
	 */
	NonNegativeMoney getDividend();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Multiplier is a percentage value which is used to produce Deviation by multiplying the difference between Expected Dividend and Actual Dividend Deviation = Multiplier * (Expected Dividend — Actual Dividend).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Multiplier is a percentage value which is used to produce Deviation by multiplying the difference between Expected Dividend and Actual Dividend Deviation = Multiplier * (Expected Dividend — Actual Dividend).
	 *
	 */
	BigDecimal getMultiplier();

	/*********************** Build Methods  ***********************/
	DividendPeriodDividend build();
	
	DividendPeriodDividend.DividendPeriodDividendBuilder toBuilder();
	
	static DividendPeriodDividend.DividendPeriodDividendBuilder builder() {
		return new DividendPeriodDividend.DividendPeriodDividendBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPeriodDividend> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendPeriodDividend> getType() {
		return DividendPeriodDividend.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.class, getUnadjustedStartDate());
		processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.class, getUnadjustedEndDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processRosetta(path.newSubPath("dividend"), processor, NonNegativeMoney.class, getDividend());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPeriodDividendBuilder extends DividendPeriodDividend, DividendPeriod.DividendPeriodBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateDividend();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getDividend();
		@Override
		DividendPeriodDividend.DividendPeriodDividendBuilder setId(String id);
		@Override
		DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate);
		@Override
		DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate);
		@Override
		DividendPeriodDividend.DividendPeriodDividendBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		@Override
		DividendPeriodDividend.DividendPeriodDividendBuilder setUnderlyerReference(AssetReference underlyerReference);
		DividendPeriodDividend.DividendPeriodDividendBuilder setDividend(NonNegativeMoney dividend);
		DividendPeriodDividend.DividendPeriodDividendBuilder setMultiplier(BigDecimal multiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedStartDate());
			processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedEndDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processRosetta(path.newSubPath("dividend"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getDividend());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		}
		

		DividendPeriodDividend.DividendPeriodDividendBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPeriodDividend  ***********************/
	class DividendPeriodDividendImpl extends DividendPeriod.DividendPeriodImpl implements DividendPeriodDividend {
		private final NonNegativeMoney dividend;
		private final BigDecimal multiplier;
		
		protected DividendPeriodDividendImpl(DividendPeriodDividend.DividendPeriodDividendBuilder builder) {
			super(builder);
			this.dividend = ofNullable(builder.getDividend()).map(f->f.build()).orElse(null);
			this.multiplier = builder.getMultiplier();
		}
		
		@Override
		@RosettaAttribute("dividend")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividend")
		public NonNegativeMoney getDividend() {
			return dividend;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public DividendPeriodDividend build() {
			return this;
		}
		
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder toBuilder() {
			DividendPeriodDividend.DividendPeriodDividendBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPeriodDividend.DividendPeriodDividendBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDividend()).ifPresent(builder::setDividend);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodDividend _that = getType().cast(o);
		
			if (!Objects.equals(dividend, _that.getDividend())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividend != null ? dividend.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodDividend {" +
				"dividend=" + this.dividend + ", " +
				"multiplier=" + this.multiplier +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendPeriodDividend  ***********************/
	class DividendPeriodDividendBuilderImpl extends DividendPeriod.DividendPeriodBuilderImpl implements DividendPeriodDividend.DividendPeriodDividendBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder dividend;
		protected BigDecimal multiplier;
		
		@Override
		@RosettaAttribute("dividend")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividend")
		public NonNegativeMoney.NonNegativeMoneyBuilder getDividend() {
			return dividend;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateDividend() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (dividend!=null) {
				result = dividend;
			}
			else {
				result = dividend = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedStartDate")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedStartDate(IdentifiedDate _unadjustedStartDate) {
			this.unadjustedStartDate = _unadjustedStartDate == null ? null : _unadjustedStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedEndDate")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setUnadjustedEndDate(IdentifiedDate _unadjustedEndDate) {
			this.unadjustedEndDate = _unadjustedEndDate == null ? null : _unadjustedEndDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerReference")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setUnderlyerReference(AssetReference _underlyerReference) {
			this.underlyerReference = _underlyerReference == null ? null : _underlyerReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividend")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividend")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setDividend(NonNegativeMoney _dividend) {
			this.dividend = _dividend == null ? null : _dividend.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@Override
		public DividendPeriodDividend build() {
			return new DividendPeriodDividend.DividendPeriodDividendImpl(this);
		}
		
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder prune() {
			super.prune();
			if (dividend!=null && !dividend.prune().hasData()) dividend = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDividend()!=null && getDividend().hasData()) return true;
			if (getMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodDividend.DividendPeriodDividendBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DividendPeriodDividend.DividendPeriodDividendBuilder o = (DividendPeriodDividend.DividendPeriodDividendBuilder) other;
			
			merger.mergeRosetta(getDividend(), o.getDividend(), this::setDividend);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodDividend _that = getType().cast(o);
		
			if (!Objects.equals(dividend, _that.getDividend())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividend != null ? dividend.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodDividendBuilder {" +
				"dividend=" + this.dividend + ", " +
				"multiplier=" + this.multiplier +
			'}' + " " + super.toString();
		}
	}
}

package fpml.consolidated.dividend.swaps;

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
import fpml.consolidated.dividend.swaps.meta.DividendPeriodPaymentMeta;
import fpml.consolidated.eq.shared.DividendPeriod;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
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
 * Provision A time bounded dividend period, with fixed strike and a dividend payment date per period.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A time bounded dividend period, with fixed strike and a dividend payment date per period.
 *
 */
@RosettaDataType(value="DividendPeriodPayment", builder=DividendPeriodPayment.DividendPeriodPaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DividendPeriodPayment", model="fpml", builder=DividendPeriodPayment.DividendPeriodPaymentBuilderImpl.class, version="2.1.1")
public interface DividendPeriodPayment extends DividendPeriod {

	DividendPeriodPaymentMeta metaData = new DividendPeriodPaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Fixed strike.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Fixed strike.
	 *
	 */
	BigDecimal getFixedStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dividend period amount payment date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dividend period amount payment date.
	 *
	 */
	AdjustableOrRelativeDate getPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dividend period amount valuation date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dividend period amount valuation date.
	 *
	 */
	AdjustableOrRelativeDate getValuationDate();

	/*********************** Build Methods  ***********************/
	DividendPeriodPayment build();
	
	DividendPeriodPayment.DividendPeriodPaymentBuilder toBuilder();
	
	static DividendPeriodPayment.DividendPeriodPaymentBuilder builder() {
		return new DividendPeriodPayment.DividendPeriodPaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPeriodPayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DividendPeriodPayment> getType() {
		return DividendPeriodPayment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.class, getUnadjustedStartDate());
		processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.class, getUnadjustedEndDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processor.processBasic(path.newSubPath("fixedStrike"), BigDecimal.class, getFixedStrike(), this);
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("valuationDate"), processor, AdjustableOrRelativeDate.class, getValuationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPeriodPaymentBuilder extends DividendPeriodPayment, DividendPeriod.DividendPeriodBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValuationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValuationDate();
		@Override
		DividendPeriodPayment.DividendPeriodPaymentBuilder setId(String id);
		@Override
		DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate);
		@Override
		DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate);
		@Override
		DividendPeriodPayment.DividendPeriodPaymentBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		@Override
		DividendPeriodPayment.DividendPeriodPaymentBuilder setUnderlyerReference(AssetReference underlyerReference);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setFixedStrike(BigDecimal fixedStrike);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		DividendPeriodPayment.DividendPeriodPaymentBuilder setValuationDate(AdjustableOrRelativeDate valuationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedStartDate());
			processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedEndDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processor.processBasic(path.newSubPath("fixedStrike"), BigDecimal.class, getFixedStrike(), this);
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("valuationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getValuationDate());
		}
		

		DividendPeriodPayment.DividendPeriodPaymentBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPeriodPayment  ***********************/
	class DividendPeriodPaymentImpl extends DividendPeriod.DividendPeriodImpl implements DividendPeriodPayment {
		private final BigDecimal fixedStrike;
		private final AdjustableOrRelativeDate paymentDate;
		private final AdjustableOrRelativeDate valuationDate;
		
		protected DividendPeriodPaymentImpl(DividendPeriodPayment.DividendPeriodPaymentBuilder builder) {
			super(builder);
			this.fixedStrike = builder.getFixedStrike();
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedStrike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedStrike")
		public BigDecimal getFixedStrike() {
			return fixedStrike;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public AdjustableOrRelativeDate getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public DividendPeriodPayment build() {
			return this;
		}
		
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder toBuilder() {
			DividendPeriodPayment.DividendPeriodPaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPeriodPayment.DividendPeriodPaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedStrike()).ifPresent(builder::setFixedStrike);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodPayment _that = getType().cast(o);
		
			if (!Objects.equals(fixedStrike, _that.getFixedStrike())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedStrike != null ? fixedStrike.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodPayment {" +
				"fixedStrike=" + this.fixedStrike + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"valuationDate=" + this.valuationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendPeriodPayment  ***********************/
	class DividendPeriodPaymentBuilderImpl extends DividendPeriod.DividendPeriodBuilderImpl implements DividendPeriodPayment.DividendPeriodPaymentBuilder {
	
		protected BigDecimal fixedStrike;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder valuationDate;
		
		@Override
		@RosettaAttribute("fixedStrike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedStrike")
		public BigDecimal getFixedStrike() {
			return fixedStrike;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValuationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedStartDate")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedStartDate(IdentifiedDate _unadjustedStartDate) {
			this.unadjustedStartDate = _unadjustedStartDate == null ? null : _unadjustedStartDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unadjustedEndDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedEndDate")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setUnadjustedEndDate(IdentifiedDate _unadjustedEndDate) {
			this.unadjustedEndDate = _unadjustedEndDate == null ? null : _unadjustedEndDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerReference")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setUnderlyerReference(AssetReference _underlyerReference) {
			this.underlyerReference = _underlyerReference == null ? null : _underlyerReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedStrike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedStrike")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setFixedStrike(BigDecimal _fixedStrike) {
			this.fixedStrike = _fixedStrike == null ? null : _fixedStrike;
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder setValuationDate(AdjustableOrRelativeDate _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate.toBuilder();
			return this;
		}
		
		@Override
		public DividendPeriodPayment build() {
			return new DividendPeriodPayment.DividendPeriodPaymentImpl(this);
		}
		
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder prune() {
			super.prune();
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedStrike()!=null) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriodPayment.DividendPeriodPaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DividendPeriodPayment.DividendPeriodPaymentBuilder o = (DividendPeriodPayment.DividendPeriodPaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			
			merger.mergeBasic(getFixedStrike(), o.getFixedStrike(), this::setFixedStrike);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendPeriodPayment _that = getType().cast(o);
		
			if (!Objects.equals(fixedStrike, _that.getFixedStrike())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedStrike != null ? fixedStrike.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodPaymentBuilder {" +
				"fixedStrike=" + this.fixedStrike + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"valuationDate=" + this.valuationDate +
			'}' + " " + super.toString();
		}
	}
}

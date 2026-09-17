package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FxFixingMeta;
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
 * Provision A type that specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that specifies the source for and timing of a fixing of an exchange rate. This is used in the agreement of non-deliverable forward trades as well as various types of FX OTC options that require observations against a particular rate.
 *
 */
@RosettaDataType(value="FxFixing", builder=FxFixing.FxFixingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFixing", model="fpml", builder=FxFixing.FxFixingBuilderImpl.class, version="2.1.1")
public interface FxFixing extends RosettaModelObject {

	FxFixingMeta metaData = new FxFixingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
	 *
	 */
	QuotedCurrencyPair getQuotedCurrencyPair();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the specific date when a non-deliverable forward or cash-settled option will "fix" against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the specific date when a non-deliverable forward or cash-settled option will "fix" against a particular rate, which will be used to compute the ultimate cash settlement. This element should be omitted where a single, discrete fixing date cannot be identified e.g. on an american option, where fixing may occur at any date on a continuous range.
	 *
	 */
	ZonedDateTime getFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the methodology (reference source and, optionally, fixing time) to be used for determining a currency conversion rate.
	 *
	 */
	FxSpotRateSource getFxSpotRateSource();

	/*********************** Build Methods  ***********************/
	FxFixing build();
	
	FxFixing.FxFixingBuilder toBuilder();
	
	static FxFixing.FxFixingBuilder builder() {
		return new FxFixing.FxFixingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixing> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFixing> getType() {
		return FxFixing.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingBuilder extends FxFixing, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource();
		@Override
		FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource();
		FxFixing.FxFixingBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxFixing.FxFixingBuilder setFixingDate(ZonedDateTime fixingDate);
		FxFixing.FxFixingBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
		}
		

		FxFixing.FxFixingBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixing  ***********************/
	class FxFixingImpl implements FxFixing {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final ZonedDateTime fixingDate;
		private final FxSpotRateSource fxSpotRateSource;
		
		protected FxFixingImpl(FxFixing.FxFixingBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.fixingDate = builder.getFixingDate();
			this.fxSpotRateSource = ofNullable(builder.getFxSpotRateSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingDate")
		public ZonedDateTime getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("fxSpotRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxSpotRateSource")
		public FxSpotRateSource getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxFixing build() {
			return this;
		}
		
		@Override
		public FxFixing.FxFixingBuilder toBuilder() {
			FxFixing.FxFixingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixing.FxFixingBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getFxSpotRateSource()).ifPresent(builder::setFxSpotRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixing _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixing {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixing  ***********************/
	class FxFixingBuilderImpl implements FxFixing.FxFixingBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected ZonedDateTime fixingDate;
		protected FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource;
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (quotedCurrencyPair!=null) {
				result = quotedCurrencyPair;
			}
			else {
				result = quotedCurrencyPair = QuotedCurrencyPair.builder();
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
		@RosettaAttribute("fxSpotRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxSpotRateSource")
		public FxSpotRateSource.FxSpotRateSourceBuilder getFxSpotRateSource() {
			return fxSpotRateSource;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder getOrCreateFxSpotRateSource() {
			FxSpotRateSource.FxSpotRateSourceBuilder result;
			if (fxSpotRateSource!=null) {
				result = fxSpotRateSource;
			}
			else {
				result = fxSpotRateSource = FxSpotRateSource.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxFixing.FxFixingBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public FxFixing.FxFixingBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("fxSpotRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxSpotRateSource")
		@Override
		public FxFixing.FxFixingBuilder setFxSpotRateSource(FxSpotRateSource _fxSpotRateSource) {
			this.fxSpotRateSource = _fxSpotRateSource == null ? null : _fxSpotRateSource.toBuilder();
			return this;
		}
		
		@Override
		public FxFixing build() {
			return new FxFixing.FxFixingImpl(this);
		}
		
		@Override
		public FxFixing.FxFixingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixing.FxFixingBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (fxSpotRateSource!=null && !fxSpotRateSource.prune().hasData()) fxSpotRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getFixingDate()!=null) return true;
			if (getFxSpotRateSource()!=null && getFxSpotRateSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixing.FxFixingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixing.FxFixingBuilder o = (FxFixing.FxFixingBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getFxSpotRateSource(), o.getFxSpotRateSource(), this::setFxSpotRateSource);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), this::setFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixing _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(fxSpotRateSource, _that.getFxSpotRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (fxSpotRateSource != null ? fxSpotRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"fxSpotRateSource=" + this.fxSpotRateSource +
			'}';
		}
	}
}

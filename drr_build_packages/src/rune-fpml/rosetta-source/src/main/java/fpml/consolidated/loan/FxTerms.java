package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.FxTermsMeta;
import fpml.consolidated.shared.FxFixing;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure which specifies FX conversion terms.
 *
 */
@RosettaDataType(value="FxTerms", builder=FxTerms.FxTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTerms", model="fpml", builder=FxTerms.FxTermsBuilderImpl.class, version="2.1.1")
public interface FxTerms extends FxFixing {

	FxTermsMeta metaData = new FxTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
	 *
	 */
	BigDecimal getRate();

	/*********************** Build Methods  ***********************/
	FxTerms build();
	
	FxTerms.FxTermsBuilder toBuilder();
	
	static FxTerms.FxTermsBuilder builder() {
		return new FxTerms.FxTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTerms> getType() {
		return FxTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.class, getFxSpotRateSource());
		processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTermsBuilder extends FxTerms, FxFixing.FxFixingBuilder {
		@Override
		FxTerms.FxTermsBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxTerms.FxTermsBuilder setFixingDate(ZonedDateTime fixingDate);
		@Override
		FxTerms.FxTermsBuilder setFxSpotRateSource(FxSpotRateSource fxSpotRateSource);
		FxTerms.FxTermsBuilder setRate(BigDecimal rate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processRosetta(path.newSubPath("fxSpotRateSource"), processor, FxSpotRateSource.FxSpotRateSourceBuilder.class, getFxSpotRateSource());
			processor.processBasic(path.newSubPath("rate"), BigDecimal.class, getRate(), this);
		}
		

		FxTerms.FxTermsBuilder prune();
	}

	/*********************** Immutable Implementation of FxTerms  ***********************/
	class FxTermsImpl extends FxFixing.FxFixingImpl implements FxTerms {
		private final BigDecimal rate;
		
		protected FxTermsImpl(FxTerms.FxTermsBuilder builder) {
			super(builder);
			this.rate = builder.getRate();
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@Override
		public FxTerms build() {
			return this;
		}
		
		@Override
		public FxTerms.FxTermsBuilder toBuilder() {
			FxTerms.FxTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTerms.FxTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRate()).ifPresent(builder::setRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTerms _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTerms {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTerms  ***********************/
	class FxTermsBuilderImpl extends FxFixing.FxFixingBuilderImpl implements FxTerms.FxTermsBuilder {
	
		protected BigDecimal rate;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public BigDecimal getRate() {
			return rate;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxTerms.FxTermsBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingDate")
		@Override
		public FxTerms.FxTermsBuilder setFixingDate(ZonedDateTime _fixingDate) {
			this.fixingDate = _fixingDate == null ? null : _fixingDate;
			return this;
		}
		
		@RosettaAttribute("fxSpotRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxSpotRateSource")
		@Override
		public FxTerms.FxTermsBuilder setFxSpotRateSource(FxSpotRateSource _fxSpotRateSource) {
			this.fxSpotRateSource = _fxSpotRateSource == null ? null : _fxSpotRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public FxTerms.FxTermsBuilder setRate(BigDecimal _rate) {
			this.rate = _rate == null ? null : _rate;
			return this;
		}
		
		@Override
		public FxTerms build() {
			return new FxTerms.FxTermsImpl(this);
		}
		
		@Override
		public FxTerms.FxTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTerms.FxTermsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTerms.FxTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxTerms.FxTermsBuilder o = (FxTerms.FxTermsBuilder) other;
			
			
			merger.mergeBasic(getRate(), o.getRate(), this::setRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTerms _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTermsBuilder {" +
				"rate=" + this.rate +
			'}' + " " + super.toString();
		}
	}
}

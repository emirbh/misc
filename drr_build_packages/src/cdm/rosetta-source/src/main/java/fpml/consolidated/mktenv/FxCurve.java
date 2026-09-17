package fpml.consolidated.mktenv;

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
import fpml.consolidated.mktenv.meta.FxCurveMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PricingStructure;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An fx curve object., which includes pricing inputs and term structures for fx forwards.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An fx curve object., which includes pricing inputs and term structures for fx forwards.
 *
 */
@RosettaDataType(value="FxCurve", builder=FxCurve.FxCurveBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxCurve", model="fpml", builder=FxCurve.FxCurveBuilderImpl.class, version="2.1.1")
public interface FxCurve extends PricingStructure {

	FxCurveMeta metaData = new FxCurveMeta();

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

	/*********************** Build Methods  ***********************/
	FxCurve build();
	
	FxCurve.FxCurveBuilder toBuilder();
	
	static FxCurve.FxCurveBuilder builder() {
		return new FxCurve.FxCurveBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCurve> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxCurve> getType() {
		return FxCurve.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCurveBuilder extends FxCurve, PricingStructure.PricingStructureBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		@Override
		FxCurve.FxCurveBuilder setId(String id);
		@Override
		FxCurve.FxCurveBuilder setName(String name);
		@Override
		FxCurve.FxCurveBuilder setCurrency(Currency currency);
		FxCurve.FxCurveBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
		}
		

		FxCurve.FxCurveBuilder prune();
	}

	/*********************** Immutable Implementation of FxCurve  ***********************/
	class FxCurveImpl extends PricingStructure.PricingStructureImpl implements FxCurve {
		private final QuotedCurrencyPair quotedCurrencyPair;
		
		protected FxCurveImpl(FxCurve.FxCurveBuilder builder) {
			super(builder);
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotedCurrencyPair")
		public QuotedCurrencyPair getQuotedCurrencyPair() {
			return quotedCurrencyPair;
		}
		
		@Override
		public FxCurve build() {
			return this;
		}
		
		@Override
		public FxCurve.FxCurveBuilder toBuilder() {
			FxCurve.FxCurveBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCurve.FxCurveBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurve _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurve {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxCurve  ***********************/
	class FxCurveBuilderImpl extends PricingStructure.PricingStructureBuilderImpl implements FxCurve.FxCurveBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		
		@Override
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.GETTER)
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxCurve.FxCurveBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public FxCurve.FxCurveBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public FxCurve.FxCurveBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxCurve.FxCurveBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@Override
		public FxCurve build() {
			return new FxCurve.FxCurveImpl(this);
		}
		
		@Override
		public FxCurve.FxCurveBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurve.FxCurveBuilder prune() {
			super.prune();
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCurve.FxCurveBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxCurve.FxCurveBuilder o = (FxCurve.FxCurveBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxCurve _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCurveBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair +
			'}' + " " + super.toString();
		}
	}
}

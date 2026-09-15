package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxCrossRateObservableMeta;
import fpml.consolidated.shared.FxInformationSource;
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
 * Provision A type that is used for including the currency exchange rates information used to cross between the traded currencies for non-base currency FX contracts.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that is used for including the currency exchange rates information used to cross between the traded currencies for non-base currency FX contracts.
 *
 */
@RosettaDataType(value="FxCrossRateObservable", builder=FxCrossRateObservable.FxCrossRateObservableBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxCrossRateObservable", model="fpml", builder=FxCrossRateObservable.FxCrossRateObservableBuilderImpl.class, version="2.1.1")
public interface FxCrossRateObservable extends RosettaModelObject {

	FxCrossRateObservableMeta metaData = new FxCrossRateObservableMeta();

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
	QuotedCurrencyPair getQuotedCurrencyPair();
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
	FxInformationSource getInformationSource();

	/*********************** Build Methods  ***********************/
	FxCrossRateObservable build();
	
	FxCrossRateObservable.FxCrossRateObservableBuilder toBuilder();
	
	static FxCrossRateObservable.FxCrossRateObservableBuilder builder() {
		return new FxCrossRateObservable.FxCrossRateObservableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxCrossRateObservable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxCrossRateObservable> getType() {
		return FxCrossRateObservable.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxCrossRateObservableBuilder extends FxCrossRateObservable, RosettaModelObjectBuilder {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateQuotedCurrencyPair();
		@Override
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getQuotedCurrencyPair();
		FxInformationSource.FxInformationSourceBuilder getOrCreateInformationSource();
		@Override
		FxInformationSource.FxInformationSourceBuilder getInformationSource();
		FxCrossRateObservable.FxCrossRateObservableBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		FxCrossRateObservable.FxCrossRateObservableBuilder setInformationSource(FxInformationSource informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processRosetta(path.newSubPath("informationSource"), processor, FxInformationSource.FxInformationSourceBuilder.class, getInformationSource());
		}
		

		FxCrossRateObservable.FxCrossRateObservableBuilder prune();
	}

	/*********************** Immutable Implementation of FxCrossRateObservable  ***********************/
	class FxCrossRateObservableImpl implements FxCrossRateObservable {
		private final QuotedCurrencyPair quotedCurrencyPair;
		private final FxInformationSource informationSource;
		
		protected FxCrossRateObservableImpl(FxCrossRateObservable.FxCrossRateObservableBuilder builder) {
			this.quotedCurrencyPair = ofNullable(builder.getQuotedCurrencyPair()).map(f->f.build()).orElse(null);
			this.informationSource = ofNullable(builder.getInformationSource()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("informationSource")
		public FxInformationSource getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxCrossRateObservable build() {
			return this;
		}
		
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder toBuilder() {
			FxCrossRateObservable.FxCrossRateObservableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxCrossRateObservable.FxCrossRateObservableBuilder builder) {
			ofNullable(getQuotedCurrencyPair()).ifPresent(builder::setQuotedCurrencyPair);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCrossRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCrossRateObservable {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}

	/*********************** Builder Implementation of FxCrossRateObservable  ***********************/
	class FxCrossRateObservableBuilderImpl implements FxCrossRateObservable.FxCrossRateObservableBuilder {
	
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair;
		protected FxInformationSource.FxInformationSourceBuilder informationSource;
		
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
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("informationSource")
		public FxInformationSource.FxInformationSourceBuilder getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder getOrCreateInformationSource() {
			FxInformationSource.FxInformationSourceBuilder result;
			if (informationSource!=null) {
				result = informationSource;
			}
			else {
				result = informationSource = FxInformationSource.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("informationSource")
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder setInformationSource(FxInformationSource _informationSource) {
			this.informationSource = _informationSource == null ? null : _informationSource.toBuilder();
			return this;
		}
		
		@Override
		public FxCrossRateObservable build() {
			return new FxCrossRateObservable.FxCrossRateObservableImpl(this);
		}
		
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder prune() {
			if (quotedCurrencyPair!=null && !quotedCurrencyPair.prune().hasData()) quotedCurrencyPair = null;
			if (informationSource!=null && !informationSource.prune().hasData()) informationSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotedCurrencyPair()!=null && getQuotedCurrencyPair().hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxCrossRateObservable.FxCrossRateObservableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxCrossRateObservable.FxCrossRateObservableBuilder o = (FxCrossRateObservable.FxCrossRateObservableBuilder) other;
			
			merger.mergeRosetta(getQuotedCurrencyPair(), o.getQuotedCurrencyPair(), this::setQuotedCurrencyPair);
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::setInformationSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxCrossRateObservable _that = getType().cast(o);
		
			if (!Objects.equals(quotedCurrencyPair, _that.getQuotedCurrencyPair())) return false;
			if (!Objects.equals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotedCurrencyPair != null ? quotedCurrencyPair.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxCrossRateObservableBuilder {" +
				"quotedCurrencyPair=" + this.quotedCurrencyPair + ", " +
				"informationSource=" + this.informationSource +
			'}';
		}
	}
}

package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.FxHaircutCurrencyMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.
 * @version 6.23.0
 */
@RosettaDataType(value="FxHaircutCurrency", builder=FxHaircutCurrency.FxHaircutCurrencyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FxHaircutCurrency", model="cdm", builder=FxHaircutCurrency.FxHaircutCurrencyBuilderImpl.class, version="6.23.0")
public interface FxHaircutCurrency extends RosettaModelObject {

	FxHaircutCurrencyMeta metaData = new FxHaircutCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation is the Termination Currency when the Boolean value is set to True.
	 */
	Boolean getIsTerminationCurrency();
	/**
	 * When specified, the reference currency for the purpose of specifying the FX Haircut relating to a posting obligation. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
	 */
	FieldWithMetaString getFxDesignatedCurrency();

	/*********************** Build Methods  ***********************/
	FxHaircutCurrency build();
	
	FxHaircutCurrency.FxHaircutCurrencyBuilder toBuilder();
	
	static FxHaircutCurrency.FxHaircutCurrencyBuilder builder() {
		return new FxHaircutCurrency.FxHaircutCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxHaircutCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxHaircutCurrency> getType() {
		return FxHaircutCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isTerminationCurrency"), Boolean.class, getIsTerminationCurrency(), this);
		processRosetta(path.newSubPath("fxDesignatedCurrency"), processor, FieldWithMetaString.class, getFxDesignatedCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxHaircutCurrencyBuilder extends FxHaircutCurrency, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateFxDesignatedCurrency();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getFxDesignatedCurrency();
		FxHaircutCurrency.FxHaircutCurrencyBuilder setIsTerminationCurrency(Boolean isTerminationCurrency);
		FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrency(FieldWithMetaString fxDesignatedCurrency);
		FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrencyValue(String fxDesignatedCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isTerminationCurrency"), Boolean.class, getIsTerminationCurrency(), this);
			processRosetta(path.newSubPath("fxDesignatedCurrency"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getFxDesignatedCurrency());
		}
		

		FxHaircutCurrency.FxHaircutCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of FxHaircutCurrency  ***********************/
	class FxHaircutCurrencyImpl implements FxHaircutCurrency {
		private final Boolean isTerminationCurrency;
		private final FieldWithMetaString fxDesignatedCurrency;
		
		protected FxHaircutCurrencyImpl(FxHaircutCurrency.FxHaircutCurrencyBuilder builder) {
			this.isTerminationCurrency = builder.getIsTerminationCurrency();
			this.fxDesignatedCurrency = ofNullable(builder.getFxDesignatedCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isTerminationCurrency")
		public Boolean getIsTerminationCurrency() {
			return isTerminationCurrency;
		}
		
		@Override
		@RosettaAttribute("fxDesignatedCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxDesignatedCurrency")
		public FieldWithMetaString getFxDesignatedCurrency() {
			return fxDesignatedCurrency;
		}
		
		@Override
		public FxHaircutCurrency build() {
			return this;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder toBuilder() {
			FxHaircutCurrency.FxHaircutCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxHaircutCurrency.FxHaircutCurrencyBuilder builder) {
			ofNullable(getIsTerminationCurrency()).ifPresent(builder::setIsTerminationCurrency);
			ofNullable(getFxDesignatedCurrency()).ifPresent(builder::setFxDesignatedCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxHaircutCurrency _that = getType().cast(o);
		
			if (!Objects.equals(isTerminationCurrency, _that.getIsTerminationCurrency())) return false;
			if (!Objects.equals(fxDesignatedCurrency, _that.getFxDesignatedCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isTerminationCurrency != null ? isTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (fxDesignatedCurrency != null ? fxDesignatedCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxHaircutCurrency {" +
				"isTerminationCurrency=" + this.isTerminationCurrency + ", " +
				"fxDesignatedCurrency=" + this.fxDesignatedCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of FxHaircutCurrency  ***********************/
	class FxHaircutCurrencyBuilderImpl implements FxHaircutCurrency.FxHaircutCurrencyBuilder {
	
		protected Boolean isTerminationCurrency;
		protected FieldWithMetaString.FieldWithMetaStringBuilder fxDesignatedCurrency;
		
		@Override
		@RosettaAttribute("isTerminationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isTerminationCurrency")
		public Boolean getIsTerminationCurrency() {
			return isTerminationCurrency;
		}
		
		@Override
		@RosettaAttribute("fxDesignatedCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxDesignatedCurrency")
		public FieldWithMetaString.FieldWithMetaStringBuilder getFxDesignatedCurrency() {
			return fxDesignatedCurrency;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateFxDesignatedCurrency() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (fxDesignatedCurrency!=null) {
				result = fxDesignatedCurrency;
			}
			else {
				result = fxDesignatedCurrency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isTerminationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isTerminationCurrency")
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder setIsTerminationCurrency(Boolean _isTerminationCurrency) {
			this.isTerminationCurrency = _isTerminationCurrency == null ? null : _isTerminationCurrency;
			return this;
		}
		
		@RosettaAttribute("fxDesignatedCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxDesignatedCurrency")
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrency(FieldWithMetaString _fxDesignatedCurrency) {
			this.fxDesignatedCurrency = _fxDesignatedCurrency == null ? null : _fxDesignatedCurrency.toBuilder();
			return this;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder setFxDesignatedCurrencyValue(String _fxDesignatedCurrency) {
			this.getOrCreateFxDesignatedCurrency().setValue(_fxDesignatedCurrency);
			return this;
		}
		
		@Override
		public FxHaircutCurrency build() {
			return new FxHaircutCurrency.FxHaircutCurrencyImpl(this);
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder prune() {
			if (fxDesignatedCurrency!=null && !fxDesignatedCurrency.prune().hasData()) fxDesignatedCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsTerminationCurrency()!=null) return true;
			if (getFxDesignatedCurrency()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxHaircutCurrency.FxHaircutCurrencyBuilder o = (FxHaircutCurrency.FxHaircutCurrencyBuilder) other;
			
			merger.mergeRosetta(getFxDesignatedCurrency(), o.getFxDesignatedCurrency(), this::setFxDesignatedCurrency);
			
			merger.mergeBasic(getIsTerminationCurrency(), o.getIsTerminationCurrency(), this::setIsTerminationCurrency);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxHaircutCurrency _that = getType().cast(o);
		
			if (!Objects.equals(isTerminationCurrency, _that.getIsTerminationCurrency())) return false;
			if (!Objects.equals(fxDesignatedCurrency, _that.getFxDesignatedCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isTerminationCurrency != null ? isTerminationCurrency.hashCode() : 0);
			_result = 31 * _result + (fxDesignatedCurrency != null ? fxDesignatedCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxHaircutCurrencyBuilder {" +
				"isTerminationCurrency=" + this.isTerminationCurrency + ", " +
				"fxDesignatedCurrency=" + this.fxDesignatedCurrency +
			'}';
		}
	}
}
